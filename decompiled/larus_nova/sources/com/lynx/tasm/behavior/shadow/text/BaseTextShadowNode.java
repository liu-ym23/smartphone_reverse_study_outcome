package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.i;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import y6a.l;
import z6a.j;
import z6a.k;
import z6a.m;
import z6a.n;
import z6a.o;
import z6a.q;
import z6a.t;

/* JADX INFO: loaded from: classes32.dex */
public class BaseTextShadowNode extends ShadowNode {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static Method f382231J = null;
    public static Object K = null;
    public static boolean L = true;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public int F;
    public boolean G;
    public boolean H;
    public String I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.lynx.tasm.behavior.shadow.text.a f382232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f382233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f382234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f382235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f382236z;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f382237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f382238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f382239c;

        public final void a(SpannableStringBuilder r100) {
            int r101 = this.f382237a;
            if (r101 != 0) goto L5;
            int r102 = 18;
        L6:
            Object r103 = this.f382239c;
            if ((r103 instanceof com.lynx.tasm.behavior.ui.text.a) == false) goto L9;
        L10:
            r102 = 33;
        L11:
            r100.setSpan(r103, r101, this.f382238b, r102);
            return;
        L9:
            if ((r103 instanceof n) == false) goto L11;
        L5:
            r102 = 34;
            goto L6
        }

        public a(int r100, int r101, Object r102) {
            this.f382237a = r100;
            this.f382238b = r101;
            this.f382239c = r102;
        }
    }

    public boolean K() {
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class C() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("androidx.emoji2.text.EmojiCompat");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("androidx.emoji2.text.EmojiCompat");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("androidx.emoji2.text.EmojiCompat");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("androidx.emoji2.text.EmojiCompat");
    }

    public BaseTextShadowNode() {
        this.f382233w = false;
        this.f382234x = false;
        this.f382235y = false;
        this.f382236z = 1.0E21f;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.I = null;
        this.f382232v = new com.lynx.tasm.behavior.shadow.text.a();
    }

    public final void M(boolean r100) {
        this.f382233w = r100;
        setFontSize(this.f382232v.f382258n);
        int r101 = 0;
    L4:
        if (r101 >= l()) goto L9;
        ShadowNode r102 = k(r101);
        if ((r102 instanceof BaseTextShadowNode) == false) goto L8;
        ((BaseTextShadowNode) r102).M(this.f382233w);
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public final void N(float r100) {
        this.f382236z = r100;
        if (this.f382233w == false) goto L7;
        LynxContext r101 = this.f382220m;
        if (r101 == null) goto L7;
        r100 = r100 * r101.getFontScale();
    L7:
        com.lynx.tasm.behavior.shadow.text.a r102 = this.f382232v;
        if (r102.f382255k == r100) goto L11;
        r102.f382255k = r100;
        q();
        return;
    }

    @LynxProp(name = "custom-baseline-shift")
    public void setBaselineShift(String r100) {
    L11:
        th = move-exception;
        q();
        throw th;
    L13:
        e = move-exception;
        LLog.e("BaseTextShadowNode", e.toString());     // Catch: Throwable -> L11
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;     // Catch: Throwable -> L11
        r101.f382260p = 0.0f;     // Catch: Throwable -> L11
        r101.f382250f = -1;     // Catch: Throwable -> L11
    L15:
        q();
        return;
    L4:
        if (r100.contains(GXTemplateKey.GAIAX_PX) == false) goto L7;
        float r102 = Float.parseFloat(r100.substring(0, r100.indexOf(GXTemplateKey.GAIAX_PX)).trim());     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r103 = this.f382232v;     // Catch: Throwable -> L11 Exception -> L13
        r103.f382260p = i.b(r102, 0.0f);     // Catch: Throwable -> L11 Exception -> L13
        this.f382232v.f382250f = 3;     // Catch: Throwable -> L11 Exception -> L13
    L21:
    L7:
        if (r100.contains(GXTemplateKey.GAIAX_PE) == false) goto L9;
        String r104 = r100.substring(0, r100.indexOf(GXTemplateKey.GAIAX_PE)).trim();     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r105 = this.f382232v;     // Catch: Throwable -> L11 Exception -> L13
        float r106 = Float.parseFloat(r104) * 0.01f;     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r107 = this.f382232v;     // Catch: Throwable -> L11 Exception -> L13
        r105.f382260p = r106 * r107.f382258n;     // Catch: Throwable -> L11 Exception -> L13
        r107.f382250f = 3;     // Catch: Throwable -> L11 Exception -> L13
        goto L21
    L9:
        float r108 = Float.parseFloat(r100.trim());     // Catch: Throwable -> L11 Exception -> L13
        com.lynx.tasm.behavior.shadow.text.a r109 = this.f382232v;     // Catch: Throwable -> L11 Exception -> L13
        r109.f382260p = r108 * r109.f382258n;     // Catch: Throwable -> L11 Exception -> L13
        r109.f382250f = 3;     // Catch: Throwable -> L11 Exception -> L13
        goto L21
    }

    @LynxProp(name = "color")
    public void setColor(f6a.a r100) {
        ReadableType r101 = r100.getType();
        ReadableType r102 = ReadableType.Array;
        if (r101 != r102) goto L23;
        this.f382232v.f382247c = null;
        ReadableArray r103 = r100.asArray();
        if (r103.size() >= 2) goto L7;
    L21:
        this.f382232v.O = null;
    L29:
        q();
        return;
    L7:
        if (r103.getType(1) != r102) goto L21;
        long r104 = r103.getLong(0);
        if (r104 != 2) goto L15;
        com.lynx.tasm.behavior.shadow.text.a r105 = this.f382232v;
        r105.O = new a7a.f(r103.getArray(1));
        if (this.E == false) goto L29;
        this.f382232v.O.i(true);
        goto L29
    L15:
        if (r104 != 3) goto L18;
        com.lynx.tasm.behavior.shadow.text.a r106 = this.f382232v;
        r106.O = new a7a.i(r103.getArray(1));
        goto L29
    L18:
        if (r104 != 4) goto L20;
        com.lynx.tasm.behavior.shadow.text.a r107 = this.f382232v;
        r107.O = new a7a.a(r103.getArray(1));
        goto L29
    L20:
        this.f382232v.O = null;
        goto L29
    L23:
        if (r101 != ReadableType.Int) goto L26;
        com.lynx.tasm.behavior.shadow.text.a r108 = this.f382232v;
        r108.f382247c = Integer.valueOf(r100.asInt());
        this.f382232v.O = null;
        goto L29
    L26:
        if (r101 != ReadableType.Long) goto L28;
        com.lynx.tasm.behavior.shadow.text.a r109 = this.f382232v;
        r109.f382247c = Integer.valueOf((int) r100.asLong());
        this.f382232v.O = null;
        goto L29
    L28:
        com.lynx.tasm.behavior.shadow.text.a r110 = this.f382232v;
        r110.f382247c = null;
        r110.O = null;
        goto L29
    }

    @LynxProp(defaultInt = 0, name = "direction")
    public void setDirection(int r100) {
        this.f382232v.f382249e = r100;
        q();
    }

    @LynxProp(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r100) {
        this.E = r100;
        a7a.b r101 = this.f382232v.O;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @LynxProp(name = "android-emoji-compat")
    public void setEnableEmojiCompat(boolean r100) {
        this.H = r100;
        if (r100 == true) goto L5;
    L13:
        q();
        return;
    L5:
        if (L == false) goto L13;
        if (f382231J != null) goto L13;
        Class r101 = C();     // Catch: Exception -> L11
        K = r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        f382231J = r101.getDeclaredMethod("process", new Class[]{CharSequence.class});     // Catch: Exception -> L11
        r101.getDeclaredMethod("setEmojiSpanIndicatorColor", new Class[]{Integer.TYPE}).invoke(K, new Object[]{0});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        L = false;
        LLog.e("lynx_BaseTextShadowNode", "enable emoji e: " + e);
        goto L13
    }

    @LynxProp(name = "enable-font-scaling")
    public void setEnableFontScaling(String r100) {
        LynxContext r101 = this.f382220m;
        if (r101 == null) goto L5;
        LynxFeatureCounter.a(90, r101.getInstanceId());
    L5:
        M(Boolean.parseBoolean(r100));
    }

    @LynxProp(name = GXTemplateKey.STYLE_FONT_FAMILY)
    public void setFontFamily(String r100) {
        if (r100 == null) goto L4;
    L7:
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.equals(this.f382232v.f382265u) == true) goto L13;
        this.f382232v.f382265u = r100;
        q();
        return;
    L13:
        return;
    L4:
        if (TextUtils.isEmpty(this.f382232v.f382265u) == true) goto L7;
        this.f382232v.f382265u = null;
        q();
    }

    @LynxProp(name = "font-feature-settings")
    public void setFontFeatureSettings(ReadableArray r100) {
        if (r100 != null) goto L4;
    L13:
        this.f382232v.E = null;
    L14:
        q();
        return;
    L4:
        if (r100.size() == 0) goto L13;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= (r100.size() / 2)) goto L12;
        if (r102 <= 0) goto L11;
        r101.append(",");
    L11:
        int r103 = r102 * 2;
        String r104 = r100.getString(r103);
        int r105 = r100.getInt(r103 + 1);
        r101.append("'");
        r101.append(r104);
        r101.append("' ");
        r101.append(r105);
        r102 = r102 + 1;
        goto L8
    L12:
        com.lynx.tasm.behavior.shadow.text.a r106 = this.f382232v;
        r106.E = r101.toString();
        goto L14
    }

    @LynxProp(defaultFloat = 1.0E21f, name = GXTemplateKey.STYLE_FONT_SIZE)
    public void setFontSize(float r100) {
        if (this.f382233w == false) goto L8;
        LynxContext r101 = this.f382220m;
        if (r101 == null) goto L8;
        r100 = r100 * r101.getFontScale();
    L8:
        if (com.lynx.tasm.utils.b.a(this.f382232v.f382258n, r100) == true) goto L10;
        this.f382232v.f382258n = r100;
    L10:
        q();
    }

    @LynxProp(defaultInt = 0, name = "font-style")
    public void setFontStyle(int r100) {
        if (r100 != 0) goto L7;
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r101.f382252h == 0) goto L7;
        r101.f382252h = 0;
        q();
    L7:
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L9;
        return;
    L9:
        com.lynx.tasm.behavior.shadow.text.a r102 = this.f382232v;
        if (r102.f382252h == 2) goto L14;
        r102.f382252h = 2;
        q();
        return;
    }

    @LynxProp(name = "font-variation-settings")
    public void setFontVariationSettings(ReadableArray r100) {
        if (r100 != null) goto L4;
    L13:
        this.f382232v.D = null;
    L14:
        q();
        return;
    L4:
        if (r100.size() == 0) goto L13;
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= (r100.size() / 2)) goto L12;
        if (r102 <= 0) goto L11;
        r101.append(",");
    L11:
        int r103 = r102 * 2;
        String r104 = r100.getString(r103);
        double r105 = r100.getDouble(r103 + 1);
        r101.append("'");
        r101.append(r104);
        r101.append("' ");
        r101.append(r105);
        r102 = r102 + 1;
        goto L8
    L12:
        com.lynx.tasm.behavior.shadow.text.a r106 = this.f382232v;
        r106.D = r101.toString();
        goto L14
    }

    @LynxProp(defaultInt = 0, name = GXTemplateKey.STYLE_FONT_WEIGHT)
    public void setFontWeight(int r100) {
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r100 == r101.f382251g) goto L6;
        r101.f382251g = r100;
        q();
        return;
    }

    @LynxProp(name = "include-font-padding")
    public void setIncludeFontPadding(boolean r100) {
        this.f382232v.f382264t = r100;
        q();
    }

    @LynxProp(defaultFloat = 1.0E21f, name = "letter-spacing")
    public void setLetterSpacing(float r100) {
        this.f382232v.f382256l = r100;
        q();
    }

    @LynxProp(defaultFloat = 1.0E21f, name = GXTemplateKey.STYLE_FONT_LINE_HEIGHT)
    public void setLineHeight(float r100) {
        if (this.A == true) goto L6;
        N(r100);
        return;
    }

    @LynxProp(defaultFloat = 0.0f, name = GXTemplateKey.GAIAX_LAYER_LINE_SPACING)
    public void setLineSpacing(float r100) {
        this.f382232v.f382257m = r100;
        q();
    }

    @LynxProp(name = "text")
    public void setText(f6a.a r100) {
        this.I = b.b(r100);
        q();
    }

    @LynxProp(defaultInt = 3, name = GXTemplateKey.STYLE_FONT_TEXT_ALIGN)
    public void setTextAlign(int r100) {
        this.f382232v.f382248d = r100;
        q();
    }

    @LynxProp(name = GXTemplateKey.STYLE_FONT_TEXT_DECORATION)
    public void setTextDecoration(ReadableArray r100) {
        if (r100 != null) goto L5;
    L9:
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        r101.f382244J = 0;
        r101.K = 4;
        r101.L = 0;
        q();
        return;
    L5:
        if (r100.size() != 3) goto L9;
        int r102 = r100.getInt(0);
        int r103 = r100.getInt(1);
        int r104 = r100.getInt(2);
        com.lynx.tasm.behavior.shadow.text.a r105 = this.f382232v;
        r105.f382244J = r102;
        r105.K = r103;
        r105.L = r104;
        q();
    }

    @LynxProp(name = "text-fake-bold")
    public void setTextFakeBold(boolean r100) {
        this.f382234x = r100;
        q();
    }

    @LynxProp(name = "text-indent")
    public void setTextIndent(ReadableArray r100) {
        if (r100 != null) goto L4;
    L7:
        this.f382232v.f382259o = null;
    L8:
        q();
        return;
    L4:
        if (r100.size() != 2) goto L7;
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        r101.f382259o = new t(r100);
        goto L8
    }

    @LynxProp(name = "text-maxlength")
    public void setTextMaxLength(String r100) {
        this.f382232v.f382246b = Integer.valueOf(r100).intValue();     // Catch: Throwable -> L7
        q();     // Catch: Throwable -> L7
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r101.f382246b >= 0) goto L11;
    L6:
        r101.f382246b = -1;
        return;
    L11:
        return;
    L7:
        this.f382232v.f382246b = -1;     // Catch: Throwable -> L12
        LLog.e("lynx_BaseTextShadowNode", "setTextMaxLength with invalid value:" + r100);     // Catch: Throwable -> L12
        r101 = this.f382232v;
        if (r101.f382246b < 0) goto L6;
        return;
    L12:
        th = move-exception;
        com.lynx.tasm.behavior.shadow.text.a r102 = this.f382232v;
        if (r102.f382246b >= 0) goto L16;
        r102.f382246b = -1;
    L16:
        throw th;
    }

    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(String r100) {
        this.f382232v.f382245a = Integer.parseInt(r100);     // Catch: Throwable -> L8
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r101.f382245a >= 0) goto L7;
    L6:
        r101.f382245a = -1;
    L7:
        q();
        return;
    L8:
        this.f382232v.f382245a = -1;     // Catch: Throwable -> L13
        LLog.e("lynx_BaseTextShadowNode", "setTextMaxLine with invalid value:" + r100);     // Catch: Throwable -> L13
        r101 = this.f382232v;
        if (r101.f382245a >= 0) goto L7;
    L13:
        th = move-exception;
        com.lynx.tasm.behavior.shadow.text.a r102 = this.f382232v;
        if (r102.f382245a >= 0) goto L17;
        r102.f382245a = -1;
    L17:
        q();
        throw th;
    }

    @LynxProp(defaultInt = 0, name = GXTemplateKey.STYLE_FONT_TEXT_OVERFLOW)
    public void setTextOverflow(int r100) {
        this.f382232v.f382254j = r100;
        q();
    }

    @LynxProp(name = "text-shadow")
    public void setTextShadow(ReadableArray r100) {
        this.f382232v.I = null;
        if (r100 != null) goto L5;
        return;
    L5:
        ArrayList r101 = (ArrayList) com.lynx.tasm.behavior.ui.g.b(r100);
        if (r101.size() != 0) goto L8;
        return;
    L8:
        this.f382232v.I = (com.lynx.tasm.behavior.ui.g) ListProtector.get(r101, 0);
    }

    @LynxProp(name = "text-stroke-color")
    public void setTextStrokeColor(f6a.a r100) {
        ReadableType r101 = r100.getType();
        if (r101 != ReadableType.Int) goto L6;
        com.lynx.tasm.behavior.shadow.text.a r102 = this.f382232v;
        r102.M = r100.asInt();
    L9:
        q();
        return;
    L6:
        if (r101 != ReadableType.Long) goto L8;
        com.lynx.tasm.behavior.shadow.text.a r103 = this.f382232v;
        r103.M = (int) r100.asLong();
        goto L9
    L8:
        this.f382232v.M = 0;
        goto L9
    }

    @LynxProp(defaultFloat = 0.0f, name = "text-stroke-width")
    public void setTextStrokeWidth(float r100) {
        this.f382232v.N = r100;
        q();
    }

    @LynxProp(name = "text-vertical-align")
    public void setTextVerticalAlign(String r100) {
        if ("top".equals(r100) == false) goto L6;
        this.f382232v.f382250f = 0;
    L11:
        q();
        return;
    L6:
        if ("center".equals(r100) == false) goto L9;
        this.f382232v.f382250f = 1;
        goto L11
    L9:
        if ("bottom".equals(r100) == false) goto L11;
        this.f382232v.f382250f = 2;
        goto L11
    }

    @LynxProp(name = "use-web-line-height")
    public void setUseWebLineHeight(boolean r100) {
        if (this.f382235y == r100) goto L8;
        this.f382235y = r100;
        float r101 = this.f382236z;
        if (r101 == 1.0E21f) goto L9;
        setLineHeight(r101);
        return;
    L9:
        return;
    }

    @LynxProp(defaultInt = 0, name = "white-space")
    public void setWhiteSpace(int r100) {
        this.f382232v.f382253i = r100;
        q();
    }

    @LynxProp(name = "word-break")
    public void setWordBreakStrategy(int r100) {
        if (r100 == 2) goto L10;
        if (r100 == 1) goto L10;
        if (r100 != 0) goto L8;
        this.F = 2;
    L13:
        q();
        return;
    L8:
        this.F = 0;
    L10:
        if (this.B == false) goto L12;
        this.D = r100;
        goto L13
    L12:
        this.F = 1;
        goto L13
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public void w(LynxContext r100) {
        this.f382220m = r100;
        this.A = r100.isTextRefactorEnabled();
        this.B = r100.isNewClipModeEnabled();
        this.C = r100.isTextBoringLayoutEnabled();
        this.f382232v.f382264t = r100.getDefaultTextIncludePadding();
        this.f382232v.f382258n = Math.round(i.b(14.0f, r100.getScreenMetrics().density));
    }

    @LynxProp(name = "font-optical-sizing")
    public void setFontFeatureSettings(int r100) {
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        boolean r102 = true;
        if (r100 == 1) goto L6;
        r102 = false;
    L6:
        r101.F = r102;
        q();
    }

    public void G(SpannableStringBuilder r110, List<a> r111) {
        com.lynx.tasm.behavior.shadow.text.a r100 = this.f382232v;
        r100.f382261q = false;
        r100.f382262r = false;
        this.G = false;
        int r101 = r110.length();
        if (l() != 0) goto L7;
        String r102 = this.I;
        if (r102 == null) goto L7;
        E(r110, r102, false);
    L7:
        int r103 = l();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L49;
        ShadowNode r105 = k(r104);
        if ((r105 instanceof RawTextShadowNode) == false) goto L15;
        RawTextShadowNode r106 = (RawTextShadowNode) r105;
        String r107 = r106.f382240v;
        if (r107 == null) goto L46;
        E(r110, r107, r106.f382241w);
    L46:
        r104 = r104 + 1;
        goto L8
    L15:
        if ((r105 instanceof AbsInlineImageShadowNode) == false) goto L27;
        r110.append("I");
        AbsInlineImageShadowNode r108 = (AbsInlineImageShadowNode) r105;
        int r109 = r110.length() - 1;
        int r112 = r110.length();
        com.lynx.tasm.behavior.ui.text.a r113 = r108.O();
        r108.S(r113);
        com.lynx.tasm.behavior.ui.utils.e r114 = r108.P;
        if (r114 == null) goto L21;
        BackgroundDrawable r115 = (BackgroundDrawable) r114.f383142b;
        if (r115 == null) goto L21;
        r115.setBounds(0, 0, (int) Math.ceil(r108.f382209h.c()), (int) Math.ceil((int) r108.f382209h.a()));
        r108.P.n(r108.O);
        r113.f383089n = r108.P;
    L22:
        r113.f383088m = r108.f382232v.f382260p;
        a r116 = new a(r109, r112, r113);
        ArrayList r117 = (ArrayList) r111;
        r117.add(r116);
        if (r108.r() == false) goto L25;
        r117.add(new a(r109, r112, r108.A()));
    L25:
        this.f382232v.f382261q = true;
    L21:
        r113.f383087l = r108.O;
        goto L22
    L27:
        if ((r105 instanceof NativeLayoutNodeRef) == false) goto L33;
        r110.append("B");
        NativeLayoutNodeRef r118 = (NativeLayoutNodeRef) r105;
        int r119 = r110.length() - 1;
        int r120 = r110.length();
        r118.f382214x = r119;
        r118.f382212v = r119;
        r118.f382215y = r120;
        r118.f382213w = r120;
        n r121 = new n();
        y6a.n r122 = r118.f382221n;
        if (r122 == null) goto L31;
        int r123 = r122.f566415a;
        float r124 = r122.f566416b;
        r121.f570552a = r123;
        r121.f570553b = r124;
    L31:
        a r125 = new a(r119, r120, r121);
        ArrayList r126 = (ArrayList) r111;
        r126.add(r125);
        r126.add(new a(r119, r120, r118.A()));
        this.f382232v.f382262r = true;
        goto L46
    L33:
        if ((r105 instanceof BaseTextShadowNode) == false) goto L48;
        if ((r105 instanceof InlineTruncationShadowNode) == true) goto L46;
        BaseTextShadowNode r127 = (BaseTextShadowNode) r105;
        com.lynx.tasm.behavior.shadow.text.a r128 = r127.f382232v;
        if (r128.f382247c == null) goto L40;
    L45:
        r127.G(r110, r111);
        com.lynx.tasm.behavior.shadow.text.a r129 = this.f382232v;
        boolean r130 = r129.f382261q;
        com.lynx.tasm.behavior.shadow.text.a r131 = r127.f382232v;
        r129.f382261q = r130 | r131.f382261q;
        r129.f382262r |= r131.f382262r;
        this.G = r127.G | this.G;
        goto L46
    L40:
        if (r128.N <= 0.0f) goto L45;
        Integer r132 = this.f382232v.f382247c;
        if (r132 == null) goto L44;
        r128.f382247c = Integer.valueOf(r132.intValue());
        goto L45
    L44:
        r128.f382247c = -16777216;
        goto L45
    L48:
        throw new RuntimeException("Unexpected view type nested under text node: " + r105.getClass());
    L49:
        int r133 = r110.length();
        if (r133 <= r101) goto L61;
        F(r101, r133, r111);
        return;
    }

    public final CharSequence H(String r100, boolean r101) {
        if (this.H == false) goto L13;
        if (L == false) goto L13;
        return (CharSequence) f382231J.invoke(K, new Object[]{I(r100, r101)});
    L9:
        e = move-exception;
        LLog.w("lynx_BaseTextShadowNode", "process emoji: " + e);
        return I(r100, r101);
    L13:
        return I(r100, r101);
    }

    public final CharSequence I(String r110, boolean r111) {
        int r100 = 2;
        int r101 = 0;
        if (r111 == false) goto L50;
        int r112 = this.D;
        if (r112 == 1) goto L8;
        if (r112 == 2) goto L9;
        r100 = 0;
    L9:
        com.lynx.tasm.behavior.utils.f.a r113 = null;
        if (r110 != null) goto L13;
        return null;
    L13:
        if (r100 == 0) goto L15;
    L17:
        int r102 = r110.length();
        StringBuilder r103 = new StringBuilder(r102);
        if (r100 == 0) goto L20;
        r113 = new com.lynx.tasm.behavior.utils.f.a();
    L20:
        if (r101 >= r102) goto L68;
        if (r110.charAt(r101) != '\\') goto L45;
        int r104 = r101 + 1;
        if (r104 >= r102) goto L45;
        StringBuilder r105 = new StringBuilder();
    L26:
        if (r104 < r102) goto L28;
    L58:
        r103.append((char) CastIntegerProtector.parseInt(r105.toString(), 16));     // Catch: Exception -> L44
        r101 = r101 + r105.length();
    L46:
        if (r100 == 0) goto L48;
        r113.a(r103, r100);
    L48:
        r101 = r101 + 1;
    L44:
        r103.append(r110.charAt(r101));
        goto L46
    L28:
        if (r104 >= (r101 + 5)) goto L58;
        char r106 = r110.charAt(r104);
        if (r106 < '0') goto L34;
        if (r106 > '9') goto L34;
    L41:
        r105.append(r106);
        r104 = r104 + 1;
    L34:
        if (r106 < 'A') goto L38;
        if (r106 <= 'Z') goto L41;
    L38:
        if (r106 < 'a') goto L58;
        if (r106 > 'z') goto L58;
    L45:
        r103.append(r110.charAt(r101));
        goto L46
    L68:
        return r103.toString();
    L15:
        if (r110.indexOf(92) >= 0) goto L17;
        return r110;
    L8:
        r100 = 1;
        goto L9
    L50:
        int r114 = this.D;
        if (r114 == 1) goto L54;
        if (r114 != 2) goto L57;
    L55:
        r101 = r100;
    L57:
        return com.lynx.tasm.behavior.utils.f.a(r110, r101);
    L54:
        r100 = 1;
        goto L55
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void j(ShadowNode r100, int r101) {
        super.j(r100, r101);
        if ((r100 instanceof BaseTextShadowNode) == false) goto L6;
        ((BaseTextShadowNode) r100).M(this.f382233w);
        return;
    }

    public final void D(Layout r110, SpannableStringBuilder r111, PointF r112) {
        int r100 = 0;
    L4:
        if (r100 >= l()) goto L30;
        ShadowNode r101 = k(r100);
        if ((r101 instanceof NativeLayoutNodeRef) == false) goto L25;
        NativeLayoutNodeRef r102 = (NativeLayoutNodeRef) r101;
        y6a.b r103 = new y6a.b();
        if (r102.f382212v < r110.getText().length()) goto L10;
        r102.C(r103);
    L29:
        r100 = r100 + 1;
        goto L4
    L10:
        n[] r104 = (n[]) r111.getSpans(r102.f382212v, r102.f382213w, n.class);
        if (r104.length != 1) goto L13;
        n r105 = r104[0];
    L14:
        int r106 = r110.getLineForOffset(r102.f382212v);
        float r107 = r110.getPrimaryHorizontal(r102.f382212v) + r112.x;
        if (r110.isRtlCharAt(r102.f382212v) == false) goto L20;
        if (r105 != null) goto L18;
        int r108 = 0;
    L19:
        r107 = r107 - r108;
        goto L20
    L18:
        r108 = r105.f570602g;
    L20:
        r103.f566403a = r107;
        if (r105 == null) goto L23;
        r103.f566404b = r105.b(r110.getLineTop(r106), r110.getLineBottom(r106), r110.getLineAscent(r106), r110.getLineDescent(r106)) + r112.y;
    L23:
        r102.C(r103);
        goto L29
    L13:
        r105 = null;
        goto L14
    L25:
        if ((r101 instanceof InlineTextShadowNode) == false) goto L27;
    L28:
        ((BaseTextShadowNode) r101).D(r110, r111, r112);
        goto L29
    L27:
        if ((r101 instanceof InlineTruncationShadowNode) == false) goto L29;
    }

    public void E(SpannableStringBuilder r100, String r101, boolean r102) {
        r100.append(H(r101, r102));
    }

    public void F(int r110, int r111, List<a> r112) {
        if (K() == true) goto L7;
        if (this.f382232v.f382247c == null) goto L7;
    L8:
        Integer r100 = this.f382232v.f382247c;
        if (r100 != null) goto L11;
        int r101 = -16777216;
    L12:
        j r102 = new j(r101);
        com.lynx.tasm.behavior.shadow.text.a r103 = this.f382232v;
        float r104 = r103.N;
        if (r104 <= 0.0f) goto L17;
        int r105 = r103.M;
        if (r105 == 0) goto L17;
        r102.f570586b = r105;
        r102.f570587c = r104;
        this.G = true;
    L17:
        ArrayList r106 = (ArrayList) r112;
        r106.add(new a(r110, r111, r102));
    L18:
        com.lynx.tasm.behavior.shadow.text.a r107 = this.f382232v;
        boolean r108 = false;
        if (r107.K == 4) goto L21;
    L29:
        int r109 = r107.f382244J;
        if ((r109 & 1) == 0) goto L32;
        boolean r113 = true;
    L34:
        if ((r109 & 2) == 0) goto L36;
        boolean r114 = true;
    L37:
        if (r113 == true) goto L39;
        if (r114 == true) goto L39;
    L41:
        if (this.f382232v.f382250f != (-1)) goto L43;
    L45:
        y6a.n r115 = this.f382221n;
        if (r115 == null) goto L51;
        if (r115.f566415a == 0) goto L51;
        k r116 = new k();
        y6a.n r117 = this.f382221n;
        int r118 = r117.f566415a;
        float r119 = r117.f566416b;
        r116.f570589a = r118;
        r116.f570590b = r119;
        a r120 = new a(r110, r111, r116);
        ((ArrayList) r112).add(r120);
    L51:
        if (l.a(this.f382232v.f382255k) == false) goto L53;
    L62:
        com.lynx.tasm.behavior.shadow.text.a r121 = this.f382232v;
        if (r121.G != 0) goto L65;
    L69:
        boolean r122 = false;
    L70:
        if (r122 == false) goto L72;
    L71:
        boolean r123 = true;
    L73:
        if (r123 == false) goto L83;
        com.lynx.tasm.behavior.shadow.text.a r124 = this.f382232v;
        float r125 = r124.f382255k;
        boolean r126 = this.A;
        int r127 = r124.G;
        if (r124.f382254j == 0) goto L77;
    L81:
        a r128 = new a(r110, r111, new z6a.f(r125, r126, r127, r108));
        ((ArrayList) r112).add(r128);
        goto L83
    L77:
        if (r124.f382245a != 1) goto L79;
    L80:
        r108 = true;
        goto L81
    L79:
        if (r124.f382253i != 1) goto L81;
    L83:
        if (this.f382232v.I == null) goto L86;
        a r129 = new a(r110, r111, new o(this.f382232v.I));
        ((ArrayList) r112).add(r129);
    L86:
        if (this.f382232v.f382256l == 1.0E21f) goto L89;
        a r130 = new a(r110, r111, new z6a.e(this.f382232v.f382256l));
        ((ArrayList) r112).add(r130);
    L89:
        if (Build.VERSION.SDK_INT >= 28) goto L91;
    L95:
        com.lynx.tasm.behavior.shadow.text.a r131 = this.f382232v;
        int r132 = r131.f382252h;
        if (r132 == 1) goto L100;
        if (r132 == 2) goto L100;
        if (r131.e() == 1) goto L100;
    L102:
        if (this.f382232v.O == null) goto L105;
        ArrayList r133 = (ArrayList) r112;
        r133.add(new a(r110, r111, new m(this.f382232v.O)));
        return;
    L105:
        return;
    L100:
        a r134 = new a(r110, r111, new StyleSpan(this.f382232v.e()));
        ((ArrayList) r112).add(r134);
        goto L102
    L91:
        if (this.f382234x == true) goto L95;
        if (K() == true) goto L102;
        com.lynx.tasm.behavior.shadow.text.a r135 = this.f382232v;
        int r136 = r135.f382252h;
        int r137 = r135.f382251g;
        String r138 = r135.f382265u;
        String r139 = r135.c();
        com.lynx.tasm.behavior.shadow.text.a r140 = this.f382232v;
        a r141 = new a(r110, r111, new z6a.g(r136, r137, r138, r139, r140.E, r140.B));
        ((ArrayList) r112).add(r141);
        goto L102
    L72:
        r123 = false;
        goto L73
    L65:
        if (r121.f382262r == true) goto L69;
        if (r121.f382261q == true) goto L69;
        r122 = true;
        goto L70
    L53:
        if (this.C == false) goto L71;
        if (this.A == false) goto L71;
        com.lynx.tasm.behavior.shadow.text.a r142 = this.f382232v;
        if (r142.f382253i != 1) goto L71;
        if (r142.f382261q == true) goto L71;
        if (r142.f382262r == true) goto L71;
    L43:
        if (Build.VERSION.SDK_INT <= 28) goto L45;
        com.lynx.tasm.behavior.shadow.text.a r143 = this.f382232v;
        a r144 = new a(r110, r111, new z6a.d(r143.f382250f, r143.f382260p));
        ((ArrayList) r112).add(r144);
    L39:
        com.lynx.tasm.behavior.shadow.text.a r145 = this.f382232v;
        a r146 = new a(r110, r111, new q(r113, r114, r145.K, r145.L));
        ((ArrayList) r112).add(r146);
        goto L41
    L36:
        r114 = false;
        goto L37
    L32:
        r113 = false;
        goto L34
    L21:
        if (r107.L != 0) goto L29;
        if ((r107.f382244J & 2) == 0) goto L27;
        a r147 = new a(r110, r111, new LynxStrikethroughSpan());
        ((ArrayList) r112).add(r147);
    L27:
        if ((this.f382232v.f382244J & 1) == 0) goto L41;
        a r148 = new a(r110, r111, new LynxUnderlineSpan());
        ((ArrayList) r112).add(r148);
        goto L41
    L11:
        r101 = r100.intValue();
    L7:
        if (this.f382232v.N <= 0.0f) goto L18;
        goto L8
    }

    public final void J(CharSequence r100, Set r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= l()) goto L20;
        ShadowNode r104 = k(r103);
        if ((r104 instanceof NativeLayoutNodeRef) == false) goto L15;
        NativeLayoutNodeRef r105 = (NativeLayoutNodeRef) r104;
        if (r105.f382212v >= r100.length()) goto L13;
        int r106 = r105.f382212v;
        if (r106 >= r102) goto L13;
        if (r100.charAt(r106) != "B".charAt(0)) goto L13;
    L19:
        r103 = r103 + 1;
    L13:
        HashSet r107 = (HashSet) r101;
        r107.add(Integer.valueOf(r105.f382203b));
        goto L19
    L15:
        if ((r104 instanceof BaseTextShadowNode) == false) goto L19;
        if ((r104 instanceof InlineTruncationShadowNode) == true) goto L19;
        ((BaseTextShadowNode) r104).J(r100, r101, r102);
        goto L19
    }

    public final void L(SpannableStringBuilder r110, y6a.j r111, y6a.g r112) {
        int r100 = 0;
    L4:
        if (r100 >= l()) goto L16;
        ShadowNode r101 = k(r100);
        if ((r101 instanceof NativeLayoutNodeRef) == false) goto L11;
        NativeLayoutNodeRef r102 = (NativeLayoutNodeRef) r101;
        y6a.k r103 = r102.D(r112, r111);
        n[] r104 = (n[]) r110.getSpans(r102.f382212v, r102.f382213w, n.class);
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        n r107 = r104[r106];
        int r108 = (int) Math.floor(r103.f566414a[0]);
        int r109 = (int) Math.ceil(r103.f566414a[1]);
        int r113 = (int) Math.ceil(r103.f566414a[2]);
        r107.f570602g = r108;
        r107.f570601f = r109;
        r107.f570603h = r113;
        r106 = r106 + 1;
    L15:
        r100 = r100 + 1;
        goto L4
    L11:
        if ((r101 instanceof BaseTextShadowNode) == false) goto L15;
        if ((r101 instanceof InlineTruncationShadowNode) == true) goto L15;
        ((BaseTextShadowNode) r101).L(r110, r111, r112);
        goto L15
    }
}
