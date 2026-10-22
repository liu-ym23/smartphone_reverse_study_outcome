package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003=>?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0006\u0010$\u001a\u00020\bH\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010-\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\u0006\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u00100\u001a\u00020\fH\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0018\u00108\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u001dH\u0002J\u0019\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "optionsJson", "Lorg/json/JSONObject;", "tabLayout", "Lcom/obric/oui/tab/OTabLayoutBase;", "suppressEvent", "", "titlesCache", "", "", "disabledCache", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", SlcElement.KEY_PROPS, "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setDisabled", "disabled", "setSelectedIndex", "index", "", MapMonitorConst.EVENT_DESTROY, "rebuildTabs", "applyTabEnabledState", "tabs", "parseTabItems", "Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI$TabItem;", "json", "resolveDrawable", "Landroid/graphics/drawable/Drawable;", "icon", "Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI$IconSpec;", "applyIndicatorOptions", "indicator", "applyStyleOptions", "style", "applyMaterialIfNeeded", "enable", "token", "isMaterialEffectEnabledReflect", "sendEvent", "type", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "parseTitles", "any", "", "dpToPx", "dp", "parseColor", "(Ljava/lang/Object;)Ljava/lang/Integer;", "isDarkTheme", "Companion", "TabItem", "IconSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUITabLayoutUI extends LynxUI<FrameLayout> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f398005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTabLayout f398006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f398007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f398008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f398009e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f398010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f398011b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f398010a, r101.f398010a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f398011b, r101.f398011b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f398010a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f398011b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "IconSpec(resName=" + this.f398010a + ", resId=" + this.f398011b + ')';
        }

        public b(String r100, Integer r101) {
            this.f398010a = r100;
            this.f398011b = r101;
        }

        public /* synthetic */ b(String r100, Integer r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f398012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f398013b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f398012a, r101.f398012a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f398013b, r101.f398013b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f398012a.hashCode() * 31;
            b r101 = this.f398013b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TabItem(title=" + this.f398012a + ", icon=" + this.f398013b + ')';
        }

        public c(String r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f398012a = r100;
            this.f398013b = r101;
        }
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        this.f398006b = null;
        super.destroy();
    }

    public LynxOUITabLayoutUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f398008d = CollectionsKt.emptyList();
        if (r100.getDefaultOverflowVisible() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class M(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public final Integer S(Object r100) {
        OTabLayout r101 = this.f398006b;
        if (r101 == null) goto L5;
        Context r102 = r101.getContext();
    L7:
        return o1.E(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h6 r101 = new h6(r100);
        r101.setMinimumHeight(R(r100, 56));
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        r101.setClipToOutline(false);
        GradientDrawable r102 = new GradientDrawable();
        r102.setColor(0);
        r101.setBackground(r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.miniapp_oui_tab_layout, r101, false);
        if ((r103 instanceof OTabLayout) == false) goto L5;
        OTabLayout r104 = (OTabLayout) r103;
    L6:
        if (r104 != null) goto L8;
        r104 = new OTabLayout(r100, null);
    L8:
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r104.setClipChildren(false);
        r104.setClipToPadding(false);
        r104.setClipToOutline(false);
        g4 r105 = new g4(this);
        if (r104.R.contains(r105) == true) goto L11;
        r104.R.add(r105);
    L11:
        this.f398006b = r104;
        r104.setEnabled(!this.f398009e);
        r101.addView(r104);
        return r101;
    L5:
        r104 = null;
        goto L6
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r100) {
        this.f398009e = r100;
        OTabLayout r101 = this.f398006b;
        if (r101 == null) goto L7;
        r101.setEnabled(!r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.util.ArrayList] */
    @LynxProp(name = "options")
    public final void setOptions(String r210) {
        if (r210 != null) goto L5;
    L17:
        JSONObject r100 = null;
    L18:
        this.f398005a = r100;
        if (r210 == null) goto L21;
        int r101 = r210.length();
    L22:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("setOptions len=");
        r103.append(r101);
        r103.append(" parsed=");
        if (this.f398005a == null) goto L25;
        boolean r104 = true;
    L26:
        r103.append(r104);
        String r105 = r103.toString();
        String r106 = "LynxOUITabLayoutUI";
        r102.i("LynxOUITabLayoutUI", r105);
        JSONObject r107 = this.f398005a;
        if (r107 != null) goto L29;
    L34:
        JSONObject r108 = this.f398005a;
        if (r108 == null) goto L212;
        OTabLayout r109 = this.f398006b;
        if (r109 == null) goto L213;
        int r110 = r108.optInt("selectedIndex", 0);
        String r111 = r108.optString("mode");
        String r112 = r108.optString(GXTemplateKey.GAIAX_LAYER_GRAVITY);
        boolean r113 = r108.optBoolean("autoFillWhenScrollable", false);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L47
        Object r115 = M("com.obric.oui.material.OMaterialHelper").getMethod("isMaterialEffectEnabled", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L47
        if ((r115 instanceof Boolean) == false) goto L44;
        Boolean r116 = (Boolean) r115;     // Catch: Throwable -> L47
    L45:
        Object r117 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r117) == false) goto L52;
        r117 = null;
    L52:
        Boolean r118 = (Boolean) r117;
        if (r118 == null) goto L55;
        boolean r119 = r118.booleanValue();
    L56:
        boolean r120 = r108.optBoolean("enableMaterial", r119);
        String r121 = r108.optString("materialToken");
        Intrinsics.checkNotNull(r121);
        if ((!StringsKt.isBlank(r121)) == false) goto L59;
        String r122 = r121;
    L60:
        JSONObject r123 = r108.optJSONObject("indicator");
        JSONObject r124 = r108.optJSONObject("style");
        JSONArray r125 = r108.optJSONArray("tabs");
        if (r125 == null) goto L111;
        ArrayList r126 = new ArrayList();
        int r127 = r125.length();
        int r128 = 0;
    L63:
        if (r128 >= r127) goto L108;
        int r129 = r127;
        JSONObject r130 = r125.optJSONObject(r128);
        JSONArray r131 = r125;
        if (r130 == null) goto L72;
        String r132 = r130.optString("title");
        Intrinsics.checkNotNull(r132);
        if ((!StringsKt.isBlank(r132)) == true) goto L71;
        r132 = null;
    L71:
        if (r132 == null) goto L72;
        Object r133 = r130.opt("icon");
        if ((r133 instanceof JSONObject) == false) goto L87;
        JSONObject r134 = (JSONObject) r133;
        String r135 = r134.optString("resName");
        Intrinsics.checkNotNull(r135);
        if ((!StringsKt.isBlank(r135)) == true) goto L79;
        r135 = null;
    L79:
        Integer r136 = Integer.valueOf(r134.optInt("resId"));
        if (r136.intValue() <= 0) goto L82;
        boolean r137 = true;
    L83:
        if (r137 == true) goto L86;
        r136 = null;
    L86:
        b r138 = new b(r135, r136);
    L94:
        b r139 = r138;
    L106:
        r126.add(new c(r132, r139));
    L107:
        r128 = r128 + 1;
        r127 = r129;
        r125 = r131;
        r106 = r106;
        r110 = r110;
        r120 = r120;
        goto L63
    L82:
        r137 = false;
        goto L83
    L87:
        r110 = r110;
        if ((r133 instanceof String) == true) goto L90;
        r120 = r120;
        if ((r133 instanceof Number) == false) goto L105;
        Integer r140 = Integer.valueOf(((Number) r133).intValue());
        if (r140.intValue() <= 0) goto L100;
        boolean r141 = true;
    L101:
        if (r141 == true) goto L104;
        r140 = null;
    L104:
        r139 = new b(null, r140, 1);
        goto L106
    L100:
        r141 = false;
        goto L101
    L105:
        r139 = null;
        goto L106
    L90:
        if ((!StringsKt.isBlank((String) r133)) == true) goto L93;
        r133 = null;
    L93:
        r138 = new b((String) r133, null, 2);
    L72:
        r110 = r110;
        r120 = r120;
        goto L107
    L108:
        String r142 = r106;
        int r211 = r110;
        boolean r212 = r120;
        if ((!r126.isEmpty()) == true) goto L147;
    L112:
        Object r143 = r108.opt("titles");
        if ((r143 instanceof JSONArray) == false) goto L124;
        JSONArray r144 = (JSONArray) r143;
        IntRange r145 = RangesKt.until(0, r144.length());
        ?? r146 = new ArrayList();
        Iterator<Integer> r147 = r145.iterator();
    L116:
        if (r147.hasNext() == false) goto L143;
        String r148 = r144.optString(((IntIterator) r147).nextInt());
        Intrinsics.checkNotNull(r148);
        if ((!StringsKt.isBlank(r148)) == true) goto L121;
        r148 = null;
    L121:
        if (r148 == null) goto L116;
        r146.add(r148);
    L143:
        Iterable r149 = (Iterable) r146;
        r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r149, 10));
        Iterator r150 = r149.iterator();
    L145:
        if (r150.hasNext() == false) goto L147;
        r126.add(new c((String) r150.next(), null));
        goto L145
    L124:
        if ((r143 instanceof String) == true) goto L189;
        r146 = CollectionsKt.emptyList();
        goto L143
    L189:
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L136
        JSONArray r152 = new JSONArray((String) r143);     // Catch: Throwable -> L136
        IntRange r153 = RangesKt.until(0, r152.length());     // Catch: Throwable -> L136
        ArrayList r154 = new ArrayList();     // Catch: Throwable -> L136
        Iterator<Integer> r155 = r153.iterator();     // Catch: Throwable -> L136
    L127:
        if (r155.hasNext() == false) goto L134;
        String r156 = r152.optString(((IntIterator) r155).nextInt());     // Catch: Throwable -> L136
        Intrinsics.checkNotNull(r156);     // Catch: Throwable -> L136
        if ((!StringsKt.isBlank(r156)) == true) goto L132;
        r156 = null;
    L132:
        if (r156 == null) goto L127;
        r154.add(r156);     // Catch: Throwable -> L136
        goto L127
    L134:
        Object r157 = Result.m9449constructorimpl(r154);     // Catch: Throwable -> L136
    L138:
        List r158 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r157) == false) goto L141;
        r157 = r158;
    L141:
        r146 = (List) r157;
    L136:
        th = move-exception;
        Result.Companion r159 = Result.Companion;
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L147:
        ArrayList r160 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r126, 10));
        Iterator r161 = r126.iterator();
    L149:
        if (r161.hasNext() == false) goto L151;
        r160.add(((c) r161.next()).f398012a);
        goto L149
    L151:
        this.f398007c = true;
        Result.Companion r162 = Result.Companion;     // Catch: Throwable -> L178
        r109.u();     // Catch: Throwable -> L178
        Iterator r163 = r126.iterator();     // Catch: Throwable -> L178
    L154:
        if (r163.hasNext() == false) goto L162;
        c r164 = (c) r163.next();     // Catch: Throwable -> L178
        OTabLayoutBase.i r165 = r109.s(0);     // Catch: Throwable -> L178
        r165.f403203b = r164.f398012a;     // Catch: Throwable -> L178
        r165.b();     // Catch: Throwable -> L178
        b r166 = r164.f398013b;     // Catch: Throwable -> L178
        if (r166 == null) goto L160;
        Drawable r167 = T(r109.getContext(), r166);     // Catch: Throwable -> L178
        if (r167 == null) goto L160;
        r165.f403202a = r167;     // Catch: Throwable -> L178
        r165.b();     // Catch: Throwable -> L178
    L160:
        r109.h(r165);     // Catch: Throwable -> L178
        goto L154
    L162:
        if (Intrinsics.areEqual(r111, "scrollable") == false) goto L165;
        r109.setTabMode(0);     // Catch: Throwable -> L178
    L168:
        if (Intrinsics.areEqual(r112, LynxVideoManagerLite.FILL) == false) goto L171;
        r109.setTabGravity(0);     // Catch: Throwable -> L178
    L173:
        r109.setAutoFillWhenScrollable(r113);     // Catch: Throwable -> L178
        O(r109, r123);     // Catch: Throwable -> L178
        Q(r109, r124);     // Catch: Throwable -> L178
        P(r109, r212, r122);     // Catch: Throwable -> L178
        int r168 = RangesKt.coerceIn(r211, 0, RangesKt.coerceAtLeast(r160.size() - 1, 0));     // Catch: Throwable -> L178
        if ((!r160.isEmpty()) == false) goto L176;
        r109.v(r168);     // Catch: Throwable -> L178
    L176:
        Object r169 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L178
    L180:
        Throwable r170 = Result.m9452exceptionOrNullimpl(r169);
        if (r170 == null) goto L183;
        FLogger.f375446a.e(r142, "rebuildTabs failed", r170);
    L183:
        this.f398007c = false;
        this.f398008d = r160;
        r109.setEnabled(!this.f398009e);
        return;
    L171:
        if (Intrinsics.areEqual(r112, "center") == false) goto L173;
        r109.setTabGravity(1);     // Catch: Throwable -> L178
        goto L173
    L165:
        if (Intrinsics.areEqual(r111, "fixed") == false) goto L168;
        r109.setTabMode(1);     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        Result.Companion r171 = Result.Companion;
        r169 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L180
    L111:
        r142 = "LynxOUITabLayoutUI";
        r211 = r110;
        r212 = r120;
        goto L112
    L59:
        r122 = null;
        goto L60
    L55:
        r119 = false;
        goto L56
    L44:
        r116 = null;
    L47:
        th = move-exception;
        Result.Companion r172 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L213:
        return;
    L212:
        return;
    L29:
        if (r107.has("disabled") == true) goto L32;
        r107 = null;
    L32:
        if (r107 == null) goto L34;
        setDisabled(r107.optBoolean("disabled", false));
        goto L34
    L25:
        r104 = false;
        goto L26
    L21:
        r101 = -1;
        goto L22
    L5:
        if ((!StringsKt.isBlank(r210)) == false) goto L7;
        String r173 = r210;
    L8:
        if (r173 == null) goto L17;
        Result.Companion r174 = Result.Companion;     // Catch: Throwable -> L11
        Object r175 = Result.m9449constructorimpl(new JSONObject(r173));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r175) == false) goto L16;
        r175 = null;
    L16:
        r100 = (JSONObject) r175;
    L11:
        th = move-exception;
        Result.Companion r176 = Result.Companion;
        r175 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L7:
        r173 = null;
        goto L8
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r100) {
        OTabLayout r101 = this.f398006b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 >= 0) goto L7;
        return;
    L7:
        if (r100 >= r101.getTabCount()) goto L19;
        this.f398007c = true;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        r101.v(r100);     // Catch: Throwable -> L12
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        this.f398007c = false;
        return;
    L12:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        super.updatePropertiesInterval(o1.S(r110, this.f398005a, new String[]{"titles", "tabs", "selectedIndex", "disabled", "mode", GXTemplateKey.GAIAX_LAYER_GRAVITY, "autoFillWhenScrollable", "enableMaterial", "materialToken", "indicator", "style"}, new String[]{"titles", "tabs", "indicator", "style"}, 2));
    }

    public static Drawable T(Context r100, b r101) {
        Integer r102 = r101.f398011b;
        Object r103 = null;
        if (r102 == null) goto L15;
        int r104 = r102.intValue();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(ContextCompat.getDrawable(r100, r104));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r106) == true) goto L14;
        r103 = r106;
    L14:
        return (Drawable) r103;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L15:
        String r108 = r101.f398010a;
        if (r108 == null) goto L40;
        String r109 = StringsKt.trim(r108).toString();
        if (r109 == null) goto L41;
        String r110 = StringsKt.removePrefix(r109, "@drawable/");
        if (r110 == null) goto L42;
        String r111 = StringsKt.removePrefix(r110, "drawable/");
        if (r111 == null) goto L44;
        int r112 = r100.getResources().getIdentifier(r111, "drawable", r100.getPackageName());
        if (r112 == 0) goto L43;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L28
        Object r114 = Result.m9449constructorimpl(ContextCompat.getDrawable(r100, r112));     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r114) == true) goto L35;
        r103 = r114;
    L35:
        return (Drawable) r103;
    L28:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L43:
        return null;
    L44:
        return null;
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    }

    public final void O(OTabLayout r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Object r102 = r101.opt("showTopLine");
        if (r102 != null) goto L7;
    L9:
        Object r103 = r101.opt("showSelectedIndicator");
        if (r103 != null) goto L12;
    L14:
        Object r104 = r101.opt("heightDp");
        Number r105 = null;
        if (r104 != null) goto L17;
    L24:
        Object r106 = r101.opt("horizontalPaddingDp");
        if (r106 != null) goto L27;
    L34:
        Object r107 = r101.opt("cornerRadiusDp");
        if (r107 != null) goto L37;
    L43:
        Integer r108 = S(r101.opt("color"));
        Integer r109 = S(r101.opt("unselectedColor"));
        if (r108 == null) goto L47;
        if (r109 == null) goto L47;
        int r110 = r108.intValue();
        int r111 = r109.intValue();
        r100.G1 = 0;
        r100.L0 = r110;
        r100.P0 = r111;
        r100.H1 = false;
        r100.B();
        r100.invalidate();
        r100.f403150t.invalidate();
    L49:
        Object r112 = r101.opt("animEnable");
        if (r112 != null) goto L52;
    L54:
        Object r113 = r101.opt("bounceEnable");
        if (r113 != null) goto L57;
        return;
    L57:
        if ((r113 instanceof Boolean) == false) goto L61;
        r100.setIndicatorBounceEnable(((Boolean) r113).booleanValue());
        return;
    L61:
        return;
    L52:
        if ((r112 instanceof Boolean) == false) goto L54;
        r100.setIndicatorAnimEnable(((Boolean) r112).booleanValue());
    L47:
        if (r108 == null) goto L49;
        r100.setSelectedTabIndicatorColor(r108.intValue());
        goto L49
    L37:
        if ((r107 instanceof Number) == false) goto L39;
        r105 = (Number) r107;
    L39:
        if (r105 == null) goto L43;
        int r114 = r105.intValue();
        if (r114 < 0) goto L43;
        r100.setIndicatorCornerRadius(R(r100.getContext(), r114));
        goto L43
    L27:
        if ((r106 instanceof Number) == false) goto L29;
        Number r115 = (Number) r106;
    L30:
        if (r115 == null) goto L34;
        int r116 = r115.intValue();
        if (r116 < 0) goto L34;
        r100.setSelectedTabHorizontalPadding(R(r100.getContext(), r116));
        goto L34
    L29:
        r115 = null;
        goto L30
    L17:
        if ((r104 instanceof Number) == false) goto L19;
        Number r117 = (Number) r104;
    L20:
        if (r117 == null) goto L24;
        int r118 = r117.intValue();
        if (r118 <= 0) goto L24;
        r100.setSelectedTabIndicatorHeight(R(r100.getContext(), r118));
        goto L24
    L19:
        r117 = null;
        goto L20
    L12:
        if ((r103 instanceof Boolean) == false) goto L14;
        r100.setShowSelectedIndicator((Boolean) r103);
        goto L14
    L7:
        if ((r102 instanceof Boolean) == false) goto L9;
        r100.setShowTopLine((Boolean) r102);
        goto L9
    }

    public final void Q(OTabLayout r110, JSONObject r111) {
        if (r111 != null) goto L4;
        return;
    L4:
        Object r100 = r111.opt("tabMarginDp");
        Number r101 = null;
        if ((r100 instanceof Number) == false) goto L7;
        Number r102 = (Number) r100;
    L8:
        if (r102 == null) goto L12;
        int r103 = r102.intValue();
        if (r103 < 0) goto L12;
        r110.setTabMargin(r103);
    L12:
        Object r104 = r111.opt("tabSideMarginDp");
        if ((r104 instanceof Number) == false) goto L15;
        Number r105 = (Number) r104;
    L16:
        if (r105 == null) goto L18;
        Integer r106 = Integer.valueOf(r105.intValue());
    L19:
        Object r107 = r111.opt("tabTopMarginDp");
        if ((r107 instanceof Number) == false) goto L22;
        Number r108 = (Number) r107;
    L23:
        if (r108 == null) goto L25;
        Integer r109 = Integer.valueOf(r108.intValue());
    L26:
        if (r106 == null) goto L35;
        if (r109 == null) goto L35;
        if (r106.intValue() < 0) goto L35;
        if (r109.intValue() < 0) goto L35;
        int r112 = r106.intValue();
        int r113 = r109.intValue();
        r110.f403155w = r110.o(r112);
        if (r110.F <= r110.o(20)) goto L35;
        r110.f403156x = r110.o(r113);
    L35:
        JSONObject r114 = r111.optJSONObject("tabStripPadding");
        if (r114 == null) goto L38;
        r110.z(R(r110.getContext(), r114.optInt("leftDp", 0)), R(r110.getContext(), r114.optInt("topDp", 0)), R(r110.getContext(), r114.optInt("rightDp", 0)), R(r110.getContext(), r114.optInt("bottomDp", 0)));
    L38:
        JSONObject r115 = r111.optJSONObject("tabPadding");
        if (r115 == null) goto L71;
        Object r116 = r115.opt("startDp");
        if (r116 != null) goto L43;
    L48:
        Object r117 = r115.opt("topDp");
        if (r117 != null) goto L51;
    L56:
        Object r118 = r115.opt("endDp");
        if (r118 != null) goto L59;
    L64:
        Object r119 = r115.opt("bottomDp");
        if (r119 == null) goto L71;
        if ((r119 instanceof Number) == false) goto L69;
        r101 = (Number) r119;
    L69:
        if (r101 == null) goto L71;
        r110.setTabPaddingBottom(R(r110.getContext(), r101.intValue()));
        goto L71
    L59:
        if ((r118 instanceof Number) == false) goto L61;
        Number r120 = (Number) r118;
    L62:
        if (r120 == null) goto L64;
        r110.setTabPaddingEnd(R(r110.getContext(), r120.intValue()));
        goto L64
    L61:
        r120 = null;
        goto L62
    L51:
        if ((r117 instanceof Number) == false) goto L53;
        Number r121 = (Number) r117;
    L54:
        if (r121 == null) goto L56;
        r110.setTabPaddingTop(R(r110.getContext(), r121.intValue()));
        goto L56
    L53:
        r121 = null;
        goto L54
    L43:
        if ((r116 instanceof Number) == false) goto L45;
        Number r122 = (Number) r116;
    L46:
        if (r122 == null) goto L48;
        r110.setTabPaddingStart(R(r110.getContext(), r122.intValue()));
        goto L48
    L45:
        r122 = null;
    L71:
        boolean r123 = r111.optBoolean("enableCustomColors", false);
        Integer r124 = S(r111.opt("textColor"));
        Integer r125 = S(r111.opt("selectedTextColor"));
        if (r123 == false) goto L76;
        if (r124 == null) goto L76;
        if (r125 == null) goto L76;
        r110.setTabTextColors(OTabLayoutBase.n(r124.intValue(), r125.intValue()));
    L76:
        Integer r126 = S(r111.opt("barColor"));
        Integer r127 = S(r111.opt("indicatorColor"));
        Integer r128 = S(r111.opt("indicatorUnselectedColor"));
        String r129 = r111.optString("backgroundMode");
        if (r123 == true) goto L80;
        return;
    L80:
        if (Intrinsics.areEqual(r129, "show_tab_and_indicator") == false) goto L85;
        if (r126 == null) goto L90;
        if (r127 == null) goto L91;
        int r130 = r126.intValue();
        int r131 = r127.intValue();
        r110.G1 = r130;
        r110.L0 = r131;
        r110.H1 = true;
        r110.B();
        r110.invalidate();
        r110.f403150t.invalidate();
        return;
    L91:
        return;
    L90:
        return;
    L85:
        if (Intrinsics.areEqual(r129, "indicator_only") == false) goto L93;
        if (r127 == null) goto L94;
        if (r128 == null) goto L95;
        int r132 = r127.intValue();
        int r133 = r128.intValue();
        r110.G1 = 0;
        r110.L0 = r132;
        r110.P0 = r133;
        r110.H1 = false;
        r110.B();
        r110.invalidate();
        r110.f403150t.invalidate();
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L25:
        r109 = null;
        goto L26
    L22:
        r108 = null;
        goto L23
    L18:
        r106 = null;
        goto L19
    L15:
        r105 = null;
        goto L16
    L7:
        r102 = null;
        goto L8
    }

    public final int R(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) (r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density);
    }

    public static final void N(LynxOUITabLayoutUI r100, String r101, OTabLayoutBase.i r102) {
        LynxContext r103 = r100.getLynxContext();
        if (r103 == null) goto L25;
        EventEmitter r104 = r103.getEventEmitter();
        if (r104 == null) goto L26;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r102.f403205d));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == false) goto L14;
        r106 = null;
    L14:
        Integer r107 = (Integer) r106;
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        String r109 = (String) CollectionsKt.getOrNull(r100.f398008d, r108);
        m7a.a r110 = new m7a.a(r100.getSign(), r101);
        r110.a("index", Integer.valueOf(r108));
        r110.a("value", Integer.valueOf(r108));
        if (r109 == null) goto L21;
        r110.a("title", r109);
    L21:
        r104.sendCustomEvent(r110);
        return;
    L17:
        r108 = -1;
    L9:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L26:
        return;
    }

    public final void P(OTabLayout r100, boolean r110, String r111) {
        if (r110 == true) goto L4;
        return;
    L4:
        if (r111 != null) goto L6;
        r111 = "regular_1";
    L6:
        com.obric.oui.material.c r112 = o1.P(r111, r100.getContext());
        if (r112 == null) goto L34;
        Integer r113 = OMaterialHelper.f401446a;
        Resources r114 = Resources.getSystem();
        OMaterialHelper.v(r100, 2, r112, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics()).density);
        GradientDrawable r115 = new GradientDrawable();
        r115.setShape(0);
        r115.setCornerRadius(99.0f);
        r115.setColor(0);
        r100.setBackground(r115);
        r100.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r100.setClipToOutline(false);
        return;
    L34:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L28
        Method r117 = M("com.obric.oui.material.MaterialToken").getMethod("parse", new Class[]{String.class, Boolean.TYPE});     // Catch: Throwable -> L28
        Object[] r101 = new Object[2];     // Catch: Throwable -> L28
        r101[0] = r111;     // Catch: Throwable -> L28
        OTabLayout r118 = this.f398006b;     // Catch: Throwable -> L28
        if (r118 == null) goto L19;
        Resources r119 = r118.getResources();     // Catch: Throwable -> L28
        if (r119 == null) goto L19;
        Configuration r120 = r119.getConfiguration();     // Catch: Throwable -> L28
        if (r120 == null) goto L19;
        if ((r120.uiMode & 48) != 32) goto L19;
        boolean r121 = true;
    L20:
        if (r121 == true) goto L22;
        boolean r122 = true;
    L23:
        r101[1] = Boolean.valueOf(r122);     // Catch: Throwable -> L28
        Object r123 = r117.invoke(null, r101);     // Catch: Throwable -> L28
        if (r123 != null) goto L26;
        return;
    L26:
        M("com.obric.oui.material.OMaterialHelper").getMethod("setMaterial", new Class[]{View.class, M("com.obric.oui.material.MaterialConfig")}).invoke(null, new Object[]{r100, r123});     // Catch: Throwable -> L28
        GradientDrawable r124 = new GradientDrawable();     // Catch: Throwable -> L28
        r124.setShape(0);     // Catch: Throwable -> L28
        r124.setCornerRadius(99.0f);     // Catch: Throwable -> L28
        r124.setColor(0);     // Catch: Throwable -> L28
        r100.setBackground(r124);     // Catch: Throwable -> L28
        r100.setOutlineProvider(ViewOutlineProvider.BACKGROUND);     // Catch: Throwable -> L28
        r100.setClipToOutline(false);     // Catch: Throwable -> L28
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L31:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L36;
        FLogger.f375446a.i("LynxOUITabLayoutUI", "applyMaterial skipped (material classes not found or failed)");
        return;
    L36:
        return;
    L22:
        r122 = false;
    L19:
        r121 = false;
    L28:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }
}
