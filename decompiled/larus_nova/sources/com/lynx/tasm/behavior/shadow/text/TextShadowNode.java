package com.lynx.tasm.behavior.shadow.text;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.ies.xelement.text.text.LynxTextShadowNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y6a.i;
import y6a.j;
import y6a.l;
import z6a.k;
import z6a.s;
import z6a.t;
import z6a.v;
import z6a.w;

/* JADX INFO: loaded from: classes32.dex */
public class TextShadowNode extends BaseTextShadowNode implements y6a.e {
    public e M;
    public CharSequence N;
    public CharSequence O;
    public CharSequence P;
    public InlineTruncationShadowNode Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public float V;
    public float W;
    public float X;
    public int Y;
    public j Z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public y6a.g f382242k0;

    public static class a implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<ShadowNode> f382243a;

        public a(ShadowNode r100) {
            this.f382243a = new WeakReference(r100);
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r100, int r101) {
            ShadowNode r102 = this.f382243a.get();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.f382222o == false) goto L8;
            return;
        L8:
            if ((r102 instanceof BaseTextShadowNode) == false) goto L10;
            ((BaseTextShadowNode) r102).f382232v.B = true;
        L10:
            r102.q();
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final boolean K() {
        return true;
    }

    public int Q() {
        CharSequence r100 = this.N;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length();
    }

    public void U() {
        if (this.A == true) goto L14;
        int r100 = 3;
        ShadowNode r101 = this;
    L6:
        if (r101.l() <= 0) goto L12;
        r101 = r101.k(0);
        if ((r101 instanceof InlineTextShadowNode) == false) goto L12;
        int r102 = ((InlineTextShadowNode) r101).f382232v.f382248d;
        if (r102 == 3) goto L6;
        r100 = r102;
    L12:
        if (r100 == 3) goto L14;
        this.f382232v.f382248d = r100;
    L14:
        boolean r103 = T();
        this.f382232v.f382263s = r103;
        if (r103 == true) goto L17;
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        this.N = r104;
        O(r104, this);
        this.Q = null;
        int r105 = 0;
    L31:
        if (r105 >= l()) goto L37;
        if ((k(r105) instanceof InlineTruncationShadowNode) == true) goto L34;
        r105 = r105 + 1;
        goto L31
    L34:
        this.Q = (InlineTruncationShadowNode) k(r105);
    L37:
        if (this.Q == null) goto L39;
        SpannableStringBuilder r106 = new SpannableStringBuilder();
        this.O = r106;
        O(r106, this.Q);
        com.lynx.tasm.behavior.shadow.text.a r107 = this.f382232v;
        boolean r108 = r107.f382261q;
        com.lynx.tasm.behavior.shadow.text.a r109 = this.Q.f382232v;
        r107.f382261q = r108 | r109.f382261q;
        r107.f382262r |= r109.f382262r;
        r107.f382254j = 0;
    L39:
        this.W = Float.MAX_VALUE;
        this.X = Float.MIN_VALUE;
        this.V = Float.MIN_VALUE;
        if (this.U == false) goto L42;
    L43:
        P(this);
    L44:
        float r110 = this.f382232v.f382255k;
        if (r110 != 1.0E21f) goto L47;
        r110 = 0.0f;
    L47:
        z6a.c r111 = new z6a.c(Arrays.asList(new Float[]{Float.valueOf(this.W), Float.valueOf(this.X), Float.valueOf(this.V), Float.valueOf(r110)}));
        S(this.N, r111);
        CharSequence r112 = this.O;
        if (r112 == null) goto L60;
        S(r112, r111);
        return;
    L60:
        return;
    L42:
        if (this.T == false) goto L44;
    L17:
        if (l() != 0) goto L19;
        this.N = H(this.I, false);
    L21:
        if (this.N != null) goto L23;
        return;
    L23:
        ArrayList r113 = new ArrayList();
        SpannableStringBuilder r114 = new SpannableStringBuilder();
        r114.append(this.N);
        F(0, this.N.length(), r113);
        Iterator r115 = r113.iterator();
    L25:
        if (r115.hasNext() == false) goto L27;
        ((BaseTextShadowNode.a) r115.next()).a(r114);
        goto L25
    L27:
        this.N = r114;
        return;
    L19:
        RawTextShadowNode r116 = (RawTextShadowNode) k(0);
        this.N = H(r116.f382240v, r116.f382241w);
        goto L21
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void g() {
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        this.M = null;
        this.O = null;
        U();
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public Object m() {
        if (this.M != null) goto L5;
        return null;
    L5:
        DecimalFormat r100 = b.f382275a;
        Map<String, EventsListener> r101 = this.f382223p;
        boolean r102 = false;
        if (r101 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L22;
        e r104 = this.M;
        if (r104 == null) goto L22;
        Layout r105 = r104.f382287a;
        if (r105 == null) goto L22;
        int r106 = this.f382203b;
        int r107 = this.f382232v.f382254j;
        int r108 = r104.h();
        int r109 = this.Y;
        if (r109 != 0) goto L20;
        r109 = this.M.f382289c;
    L20:
        UIThreadUtils.runOnUiThread(new s(this, b.j(r106, r105, r107, r108, r109, Q(), this.M.d(), !(this instanceof LynxTextShadowNode))));
    L22:
        if (this.f382232v.f382262r == false) goto L24;
    L27:
        HashSet r110 = new HashSet();
        J(this.M.f382287a.getText(), r110, this.N.length() - this.Y);
        InlineTruncationShadowNode r111 = this.Q;
        if (r111 != null) goto L30;
    L32:
        e r112 = this.M;
        Layout r113 = r112.f382287a;
        com.lynx.tasm.behavior.shadow.text.a r114 = this.f382232v;
        boolean r115 = r114.f382261q;
        if (this.S == true) goto L35;
    L37:
        w r116 = new w(r113, r115, r110, r102);
        r116.f570623e = new PointF(r112.f382290d, r112.f382291e);
        r116.f570624f = this.G;
        r116.f570625g = this.N;
        this.M = null;
        return r116;
    L35:
        if (r114.f382248d != 5) goto L37;
        r102 = true;
        goto L37
    L30:
        if (this.Y != 0) goto L32;
        R(r111, r110);
        goto L32
    L24:
        if (this.Q != null) goto L27;
        r110 = null;
        goto L32
    L8:
        if (r101.containsKey("layout") == false) goto L10;
        r103 = true;
        goto L11
    }

    public TextShadowNode() {
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = Float.MIN_VALUE;
        this.W = Float.MAX_VALUE;
        this.X = Float.MIN_VALUE;
        this.Y = 0;
        this.Z = null;
        this.f382242k0 = null;
        if ((this instanceof LynxInlineTruncationShadowNode) == true) goto L6;
        h(this);
        return;
    }

    public boolean T() {
        if (l() != 1) goto L7;
        if ((k(0) instanceof RawTextShadowNode) == false) goto L7;
    L11:
        if (l.a(this.f382232v.f382255k) == false) goto L16;
        return true;
    L16:
        return false;
    L7:
        if (l() == 0) goto L9;
        return false;
    L9:
        if (this.I != null) goto L11;
        return false;
    }

    public static void V(BaseTextShadowNode r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.l()) goto L12;
        ShadowNode r102 = r100.k(r101);
        if ((r102 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r103 = (NativeLayoutNodeRef) r102;
        r103.f382212v = r103.f382214x;
        r103.f382213w = r103.f382215y;
    L11:
        r101 = r101 + 1;
        goto L4
    L9:
        if ((r102 instanceof BaseTextShadowNode) == false) goto L11;
        V((BaseTextShadowNode) r102);
        goto L11
    }

    public final void P(BaseTextShadowNode r100) {
        LynxContext r101 = getContext();
        com.lynx.tasm.behavior.shadow.text.a r102 = r100.f382232v;
        DecimalFormat r103 = b.f382275a;
        String r104 = r102.f382265u;
        if (TextUtils.isEmpty(r104) == true) goto L5;
        Typeface r105 = g.d(r101, r104, r102.e());
    L6:
        TextPaint r106 = b.l(r102, r105);
        if (this.U == false) goto L9;
        this.W = Math.min(r106.getFontMetrics().ascent, this.W);
        this.X = Math.max(r106.getFontMetrics().descent, this.X);
    L9:
        int r107 = 0;
        if (this.T == false) goto L13;
        Rect r108 = new Rect();
        r106.getTextBounds("x", 0, 1, r108);
        this.V = Math.max(this.V, r108.height());
    L13:
        if (r107 >= r100.l()) goto L20;
        ShadowNode r109 = r100.k(r107);
        if ((r109 instanceof InlineTextShadowNode) == false) goto L17;
    L18:
        P((BaseTextShadowNode) r109);
    L19:
        r107 = r107 + 1;
        goto L13
    L17:
        if ((r109 instanceof InlineTruncationShadowNode) == false) goto L19;
    L20:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @LynxProp(name = "-x-auto-font-size")
    public void setAutoFontSize(ReadableArray r100) {
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r100 == null) goto L8;
        r101.getClass();
        if (r100.size() != 4) goto L8;
        boolean r102 = r100.getBoolean(0);
        float r103 = (float) r100.getDouble(1);
        float r104 = (float) r100.getDouble(2);
        float r105 = (float) r100.getDouble(3);
        r101.f382266v = r102;
        r101.f382268x = r103;
        r101.f382267w = r104;
        r101.f382269y = r105;
    L9:
        q();
        return;
    L8:
        r101.f382266v = false;
        goto L9
    }

    @LynxProp(name = "-x-auto-font-size-line-ranges")
    public void setAutoFontSizeLineRanges(ReadableArray r110) {
        com.lynx.tasm.behavior.shadow.text.a r100 = this.f382232v;
        ArrayList r101 = null;
        if (r110 == null) goto L29;
        r100.getClass();
        if (r110.size() == 0) goto L29;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
    L9:
        if (r103 >= r110.size()) goto L25;
        if (r110.getType(r103).equals(ReadableType.Array) == false) goto L23;
        ReadableArray r104 = r110.getArray(r103);
        if (r104 == null) goto L23;
        if (r104.size() < 4) goto L23;
        int r105 = (int) r104.getDouble(0);
        int r106 = (int) r104.getDouble(1);
        if (r105 <= 0) goto L23;
        if (r106 < r105) goto L23;
        r102.add(new com.lynx.tasm.behavior.shadow.text.a.C4563a(r105, r106, (float) r104.getDouble(2), (float) r104.getDouble(3)));
    L23:
        r103 = r103 + 1;
        goto L9
    L25:
        if (r102.isEmpty() == true) goto L28;
        r101 = r102;
    L28:
        r100.A = r101;
    L30:
        q();
        return;
    L29:
        r100.A = null;
        goto L30
    }

    @LynxProp(name = "-x-auto-font-size-preset-sizes")
    public void setAutoFontSizePresetSizes(ReadableArray r100) {
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        float[] r102 = null;
        if (r100 == null) goto L15;
        r101.getClass();
        if (r100.size() == 0) goto L15;
        int r103 = r100.size();
        float[] r104 = new float[r103];
        int r105 = 0;
    L9:
        if (r105 >= r100.size()) goto L11;
        r104[r105] = (float) r100.getDouble(r105);
        r105 = r105 + 1;
        goto L9
    L11:
        if (r103 == 0) goto L14;
        r102 = r104;
    L14:
        r101.f382270z = r102;
        return;
    L15:
        r101.f382270z = null;
    }

    @LynxProp(name = "enable-full-justify")
    public void setEnableFullJustify(boolean r100) {
        if (this.S == r100) goto L6;
        q();
        this.S = r100;
        return;
    }

    @LynxProp(name = "tail-color-convert")
    public void setEnableTailColorConvert(boolean r100) {
        this.R = r100;
        q();
    }

    @LynxProp(name = "hyphens")
    public void setHyphen(int r100) {
        com.lynx.tasm.behavior.shadow.text.a r101 = this.f382232v;
        if (r100 != 2) goto L5;
        boolean r102 = true;
    L6:
        r101.C = r102;
        q();
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @LynxProp(defaultFloat = 1.0E21f, name = GXTemplateKey.STYLE_FONT_LINE_HEIGHT)
    public void setLineHeight(float r100) {
        N(r100);
    }

    @LynxProp(defaultInt = 0, name = "text-single-line-vertical-align")
    public void setVerticalTextAlign(String r100) {
        if ("center".equals(r100) == false) goto L6;
        this.f382232v.G = 11;
    L12:
        q();
        return;
    L6:
        if ("top".equals(r100) == false) goto L9;
        this.f382232v.G = 4;
        goto L12
    L9:
        if ("bottom".equals(r100) == false) goto L11;
        this.f382232v.G = 7;
        goto L12
    L11:
        this.f382232v.G = 0;
        goto L12
    }

    public static void R(BaseTextShadowNode r100, Set r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.l()) goto L12;
        ShadowNode r103 = r100.k(r102);
        if ((r103 instanceof NativeLayoutNodeRef) == false) goto L9;
        HashSet r104 = (HashSet) r101;
        r104.add(Integer.valueOf(r103.f382203b));
    L11:
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof BaseTextShadowNode) == false) goto L11;
        R((BaseTextShadowNode) r103, r101);
        goto L11
    }

    public static void W(int r100, BaseTextShadowNode r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.l()) goto L12;
        ShadowNode r103 = r101.k(r102);
        if ((r103 instanceof NativeLayoutNodeRef) == false) goto L9;
        NativeLayoutNodeRef r104 = (NativeLayoutNodeRef) r103;
        r104.f382212v += r100;
        r104.f382213w += r100;
    L11:
        r102 = r102 + 1;
        goto L4
    L9:
        if ((r103 instanceof BaseTextShadowNode) == false) goto L11;
        W(r100, (BaseTextShadowNode) r103);
        goto L11
    }

    public final void O(SpannableStringBuilder r100, BaseTextShadowNode r101) {
        ArrayList r102 = new ArrayList();
        r101.G(r100, r102);
        int r103 = r102.size() - 1;
    L3:
        if (r103 < 0) goto L5;
        ((BaseTextShadowNode.a) ListProtector.get(r102, r103)).a(r100);
        r103 = r103 - 1;
        goto L3
    L5:
        MetricAffectingSpan[] r104 = (MetricAffectingSpan[]) r100.getSpans(0, r100.length(), MetricAffectingSpan.class);
        int r105 = 0;
    L7:
        if (r105 >= r104.length) goto L45;
        MetricAffectingSpan r106 = r104[r105];
        if ((r106 instanceof z6a.a) == false) goto L12;
        int r107 = ((z6a.a) r106).f570552a;
    L16:
        if (this.U == false) goto L18;
    L33:
        boolean r108 = true;
    L34:
        this.U = r108;
        if (this.T == false) goto L37;
    L43:
        boolean r109 = true;
    L44:
        this.T = r109;
        r105 = r105 + 1;
        goto L7
    L37:
        if (r107 != 6) goto L39;
        boolean r110 = true;
    L40:
        if (r110 == true) goto L43;
        r109 = false;
        goto L44
    L39:
        r110 = false;
        goto L40
    L18:
        if (r107 != 5) goto L20;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == true) goto L33;
        r108 = false;
        goto L34
    L20:
        if (r107 == 8) goto L29;
        if (r107 == 4) goto L29;
        if (r107 == 7) goto L29;
        if (r107 == 11) goto L29;
        r111 = false;
        goto L30
    L12:
        if ((r106 instanceof k) == false) goto L14;
        r107 = ((k) r106).f570589a;
        goto L16
    L14:
        r107 = 0;
        goto L16
    }

    public final void S(CharSequence r100, z6a.c r101) {
        int r102 = 0;
        z6a.a[] r103 = (z6a.a[]) ((SpannableStringBuilder) r100).getSpans(0, r100.length(), z6a.a.class);
        int r104 = 0;
    L4:
        if (r104 >= r103.length) goto L6;
        z6a.a r105 = r103[r104];
        r105.f570555d = r101;
        r105.f570556e = getContext().isTextRefactorEnabled();
        r104 = r104 + 1;
        goto L4
    L6:
        k[] r106 = (k[]) ((SpannableStringBuilder) r100).getSpans(0, r100.length(), k.class);
    L8:
        if (r102 >= r106.length) goto L10;
        k r107 = r106[r102];
        r107.f570592d = r101;
        r107.f570593e = this.f382232v.f382255k;
        r102 = r102 + 1;
        goto L8
    }

    @Override // y6a.e
    public final y6a.k b(j r100, y6a.g r101) {
        this.Z = r100;
        this.f382242k0 = r101;
        this.Y = 0;
        long r102 = c(this, r100.f566410a, r100.f566411b, r100.f566412c, r100.f566413d);
        return new y6a.k(Float.intBitsToFloat((int) ((r102 >> 32) & (-1))), Float.intBitsToFloat((int) (r102 & (-1))), this.f382210i);
    }

    @Override // y6a.e
    public final void d(y6a.b r100, y6a.a r101) {
        e r102 = this.M;
        if (r102 != null) goto L5;
        return;
    L5:
        Layout r103 = r102.f382287a;
        CharSequence r104 = this.P;
        if (r104 != null) goto L8;
        r104 = this.N;
    L8:
        D(r103, (SpannableStringBuilder) r104, new PointF(r102.f382290d, r102.f382291e));
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void F(int r100, int r101, List<BaseTextShadowNode.a> r102) {
        if (this.f382232v.f382259o == null) goto L9;
        t r103 = this.f382232v.f382259o;
        float r104 = this.f382209h.c();
        int r105 = r103.f570614a;
        float r106 = r103.f570615b;
        if (r105 == 0) goto L8;
        r106 = r106 * r104;
    L8:
        BaseTextShadowNode.a r107 = new BaseTextShadowNode.a(r100, r101, new LeadingMarginSpan.Standard((int) r106, 0));
        ((ArrayList) r102).add(r107);
    L9:
        super.F(r100, r101, r102);
        if (TextUtils.isEmpty(this.f382232v.f382265u) == true) goto L16;
        com.lynx.tasm.behavior.shadow.text.a r108 = this.f382232v;
        String r109 = r108.f382265u;
        int r110 = r108.e();
        if (g.d(getContext(), r109, r110) != null) goto L14;
        FontFaceManager.g.f383410a.g(getContext(), r109, r110, new a(this));
        return;
    L14:
        this.f382232v.B = true;
        return;
    }

    public long c(LayoutNode r210, float r211, MeasureMode r212, float r213, MeasureMode r214) {
        if (TraceEvent.isTracingStarted() == false) goto L12;
        HashMap r100 = new HashMap();
        CharSequence r101 = this.N;
        if (r101 == null) goto L7;
        String r102 = r101.toString();
    L9:
        if (r102.length() <= 50) goto L11;
        r102 = r102.substring(0, 50);
    L11:
        r100.put("preview_text", r102);
        TraceEvent.beginSection("TextShadowNode.measure", r100);
        goto L12
    L7:
        r102 = "";
    L12:
        this.M = null;
        this.P = null;
        MeasureMode r110 = MeasureMode.UNDEFINED;
        float r111 = 0.0f;
        if (r212 == r110) goto L21;
        if (r214 == r110) goto L21;
        if (r211 != 0.0f) goto L21;
        if (r213 != 0.0f) goto L21;
        TraceEvent.endSection("TextShadowNode.measure");
        return i.b(0, 0);
    L21:
        CharSequence r103 = this.N;
        if (r103 != null) goto L25;
        TraceEvent.endSection("TextShadowNode.measure");
        return i.b(0, 0);
    L25:
        y6a.g r104 = this.f382242k0;
        if (r104 == null) goto L30;
        j r105 = this.Z;
        if (r105 == null) goto L30;
        L((SpannableStringBuilder) r103, r105, r104);
    L30:
        f r112 = new f(r103, this.f382232v.a(), r212, r214, r211, r213, this.F, this.R, this.A, this.C);
        v r113 = v.a.f570618a;
        this.M = r113.a(getContext(), r112);
        InlineTruncationShadowNode r106 = this.Q;
        if (r106 == null) goto L40;
        V(r106);
        CharSequence r107 = this.O;
        if (r107 == null) goto L40;
        y6a.g r108 = this.f382242k0;
        if (r108 == null) goto L40;
        j r109 = this.Z;
        if (r109 == null) goto L40;
        this.Q.L((SpannableStringBuilder) r107, r109, r108);
    L40:
        if (this.O != null) goto L42;
    L138:
        float r114 = this.M.i();
        float r115 = this.M.g();
        this.f382210i = this.M.f382287a.getLineBaseline(0);
        TraceEvent.endSection("TextShadowNode.measure");
        return i.a(r115, r114);
    L42:
        if (this.M.k() == false) goto L138;
        if (r212 == r110) goto L138;
        e r116 = r113.a(getContext(), new f(this.O, this.f382232v.a(), MeasureMode.AT_MOST, r214, r211, r213, this.F, this.R, this.A, this.C));
        Layout r117 = r116.f382287a;
        if (r117.getLineCount() == 1) goto L47;
    L49:
        boolean r118 = false;
    L50:
        if (r118 == false) goto L138;
        e r119 = this.M;
        if (r214 != r110) goto L54;
    L61:
        int r120 = r119.h() - 1;
    L62:
        int r121 = r120;
        if (this.M.f382287a.getLineEnd(r121) == this.N.length()) goto L65;
    L67:
        float r122 = r116.g();
        int r123 = this.M.f382287a.getLineStart(r121);
        int r124 = this.M.f382287a.getLineEnd(r121);
        float r125 = r211 - r122;
        if ((this.M.f382287a.getLineMax(r121) - this.M.f382287a.getLineLeft(r121)) <= r125) goto L103;
        Layout r126 = this.M.f382287a;
        HashMap r127 = new HashMap();
        ArrayList r128 = new ArrayList();
        r128.add(Float.valueOf(r126.getLineLeft(r121)));
        r128.add(Float.valueOf(r126.getLineRight(r121)));
        int r129 = r123;
    L71:
        if (r129 >= r124) goto L76;
        if (Character.isHighSurrogate(r126.getText().charAt(r129)) == true) goto L75;
        float r130 = r126.getSecondaryHorizontal(r129);
        r128.add(Float.valueOf(r130));
        r127.put(Integer.valueOf(r129), Float.valueOf(r130));
    L75:
        r129 = r129 + 1;
        goto L71
    L76:
        Collections.sort(r128);
        Iterator r131 = r127.entrySet().iterator();
    L78:
        if (r131.hasNext() == false) goto L95;
        Map.Entry r132 = (Map.Entry) r131.next();
        int r133 = ((Integer) r132.getKey()).intValue();
        float r134 = ((Float) r132.getValue()).floatValue();
        int r135 = Collections.binarySearch(r128, Float.valueOf(r134));
        if (r126.isRtlCharAt(r133) == false) goto L86;
    L81:
        if (r135 < 0) goto L90;
        if (((Float) ListProtector.get(r128, r135)).floatValue() < r134) goto L90;
        r135 = r135 - 1;
    L90:
        if (r135 < 0) goto L94;
        if (r135 >= r128.size()) goto L94;
        r127.put(Integer.valueOf(r133), Float.valueOf(Math.abs(r134 - ((Float) ListProtector.get(r128, r135)).floatValue())));
    L94:
        r127.put(Integer.valueOf(r133), Float.valueOf(0.0f));
    L86:
        if (r135 >= r128.size()) goto L90;
        if (((Float) ListProtector.get(r128, r135)).floatValue() > r134) goto L90;
        r135 = r135 + 1;
        goto L86
    L95:
        int r136 = r123;
    L96:
        if (r136 >= r124) goto L103;
        if (r127.containsKey(Integer.valueOf(r136)) == false) goto L102;
        r111 = r111 + ((Float) r127.get(Integer.valueOf(r136))).floatValue();
        if (r111 <= r125) goto L102;
        r124 = r136;
    L102:
        r136 = r136 + 1;
    L103:
        if (r124 < r123) goto L137;
    L104:
        int r137 = r124;
        if (r137 <= r123) goto L109;
        r124 = r137 - 1;
        if (Character.isWhitespace(this.N.charAt(r124)) == true) goto L104;
    L109:
        if (r137 > r123) goto L111;
        CharSequence r138 = new SpannableStringBuilder();
    L112:
        int r139 = r138.length() + r123;
        W(r139, this.Q);
        SpannableStringBuilder r140 = ((SpannableStringBuilder) this.N.subSequence(0, r123)).append(r138).append(this.O);
        this.P = r140;
        z6a.l[] r141 = (z6a.l[]) r140.getSpans(r139, r140.length(), z6a.l.class);
        int r142 = 0;
    L114:
        if (r142 >= r141.length) goto L119;
        if (r140.getSpanStart(r141[r142]) < r139) goto L118;
        z6a.l r143 = r141[r142];
        r143.f570594a += r139;
        r143.f570595b += r139;
    L118:
        r142 = r142 + 1;
        goto L114
    L119:
        boolean r144 = false;
        z6a.l[] r145 = (z6a.l[]) r140.getSpans(0, r139, z6a.l.class);
        int r146 = 0;
    L121:
        if (r146 >= r145.length) goto L129;
        z6a.l r147 = r145[r146];
        if (r147.f570594a < r139) goto L126;
        r147.f570596c = r144;
    L128:
        r146 = r146 + 1;
        r144 = false;
        goto L121
    L126:
        if (r147.f570595b <= r139) goto L128;
        r147.f570595b = r139;
        goto L128
    L129:
        com.lynx.tasm.behavior.shadow.text.a r148 = this.f382232v;
        boolean r149 = r148.f382261q;
        com.lynx.tasm.behavior.shadow.text.a r150 = this.Q.f382232v;
        r148.f382261q = r149 | r150.f382261q;
        r148.f382262r |= r150.f382262r;
        e r151 = v.a.f570618a.a(getContext(), new f(this.P, r148.a(), r212, r214, r211, r213, this.F, this.R, this.A, this.C));
        this.M = r151;
        if (r151.f382287a.getLineEnd(r121) >= this.P.length()) goto L132;
        boolean r152 = true;
    L133:
        if (r152 == false) goto L136;
        if (r137 <= r123) goto L136;
        r124 = r137 - 1;
        V(this.Q);
    L136:
        r124 = r137;
        goto L137
    L132:
        r152 = false;
        goto L133
    L111:
        r138 = this.N.subSequence(r123, r137);
    L137:
        this.Y = this.N.length() - r124;
        goto L138
    L65:
        if (this.M.f382287a.getWidth() > r211) goto L67;
    L54:
        if (r119.i() <= r213) goto L61;
        Layout r153 = r119.f382287a;
        r120 = r153.getLineCount();
    L56:
        r120 = r120 - 1;
        if (r120 <= 0) goto L62;
        if (r153.getLineBottom(r120) > r213) goto L56;
    L47:
        if (r117.getLineEnd(0) != r117.getText().length()) goto L49;
        r118 = true;
        goto L50
    }
}
