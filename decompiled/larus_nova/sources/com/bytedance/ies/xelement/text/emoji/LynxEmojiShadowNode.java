package com.bytedance.ies.xelement.text.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import y6a.o;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-emoji")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/xelement/text/emoji/LynxEmojiShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "", "name", "", "setEmojiName", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-emoji_release"}, k = 1, mv = {1, 6, 0})
public final class LynxEmojiShadowNode extends TextShadowNode {
    public final Function1<? super Context, ? extends b> H0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f250375p0;

    public static final class a extends com.lynx.tasm.behavior.ui.text.a {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Drawable f250376q;

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final void e() {
        }

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final void g() {
        }

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final void h() {
        }

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final void f() {
            this.f250376q.setCallback(null);
        }

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final Drawable c() {
            return this.f250376q;
        }

        @Override // com.lynx.tasm.behavior.ui.text.a
        public final void j(Drawable.Callback r100) {
            this.f383090o = r100;
            this.f250376q.setCallback(r100);
        }

        public a(Drawable r100, int r101, int r102, int[] r103) {
            Intrinsics.checkNotNullParameter(r100, "mDrawable");
            Intrinsics.checkNotNullParameter(r103, "margins");
            super(r101, r102, r103);
            this.f250376q = r100;
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        if ((this.f382219l instanceof BaseTextShadowNode) == false) goto L7;
        return new c();
    L7:
        return super.m();
    }

    public LynxEmojiShadowNode() {
        this.H0 = LynxEmojiShadowNode$adapterProvider$1.INSTANCE;
    }

    @LynxProp(name = "emoji-name")
    public final void setEmojiName(String r100) {
        int r101 = LynxEmojiUI.f250377b;
        String r102 = LynxEmojiUI.a.a(r100);
        this.f250375p0 = r102;
        String r103 = null;
        if (r102 == null) goto L14;
        if (r102 == null) goto L11;
        LynxContext r104 = this.f382220m;
        if (r104 == null) goto L11;
        d r105 = d.f250380b;     // Catch: Exception -> L19
        Drawable r106 = d.a.a().a(r104, r102);     // Catch: Exception -> L19
    L12:
        if (r106 != null) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r103 = this.f250375p0;
    L17:
        this.I = r103;
        q();
        return;
    L11:
        r106 = null;
    L14:
        r107 = false;
        goto L15
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        super.w(r100);
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L6;
        d r101 = d.f250380b;
        d r102 = d.a.a();
        Function1<? super Context, ? extends b> r103 = this.H0;
        Intrinsics.checkNotNull(r100);
        b r104 = r103.invoke(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f250381a = r104;
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void G(SpannableStringBuilder r110, List<BaseTextShadowNode.a> r111) {
        Intrinsics.checkNotNullParameter(r110, "sb");
        Intrinsics.checkNotNullParameter(r111, "ops");
        String r100 = this.f250375p0;
        int[] r101 = null;
        if (r100 == null) goto L10;
        LynxContext r102 = this.f382220m;
        if (r102 == null) goto L10;
        d r103 = d.f250380b;     // Catch: Exception -> L89
        Drawable r104 = d.a.a().a(r102, r100);     // Catch: Exception -> L89
    L11:
        LynxContext r105 = this.f382220m;
        if (r105 == null) goto L24;
        if (r104 == null) goto L21;
        Drawable.ConstantState r106 = r104.getConstantState();
        if (r106 == null) goto L21;
        Drawable r107 = r106.newDrawable(r105.getResources());
        if (r107 == null) goto L21;
        r104 = r107;
    L21:
        if (r104 == null) goto L23;
        r104 = r104.mutate();
        goto L24
    L23:
        r104 = null;
    L24:
        if (r104 != null) goto L27;
        super.G(r110, r111);
        return;
    L27:
        int r108 = r110.length();
        r110.append("I");
        o r109 = this.f382209h;
        if (r109 == null) goto L30;
        float r112 = r109.c();
    L31:
        o r113 = this.f382209h;
        if (r113 == null) goto L34;
        float r114 = r113.a();
    L35:
        int r115 = r104.getIntrinsicWidth();
        int r116 = r104.getIntrinsicHeight();
        if (r115 <= 0) goto L50;
        if (r116 <= 0) goto L50;
        if (r112 > 0.0f) goto L42;
    L44:
        if (r112 <= 0.0f) goto L47;
        Pair r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r112), 1)), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((r112 * r116) / r115), 1)));
    L80:
        int r118 = ((Number) r117.component1()).intValue();
        int r119 = ((Number) r117.component2()).intValue();
        r104.setBounds(0, 0, r118, r119);
        o r120 = this.f382209h;
        if (r120 == null) goto L83;
        r101 = r120.b();
    L83:
        if (r101 != null) goto L85;
        r101 = new int[4];
    L85:
        a r121 = new a(r104, r118, r119, r101);
        r121.f570552a = 11;
        r121.f570553b = 0.0f;
        this.f382232v.f382261q = true;
        ArrayList r122 = (ArrayList) r111;
        r122.add(new BaseTextShadowNode.a(r108, r110.length(), r121));
        if (r() == false) goto L92;
        r122.add(new BaseTextShadowNode.a(r108, r110.length(), A()));
        return;
    L92:
        return;
    L47:
        if (r114 <= 0.0f) goto L49;
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt((r115 * r114) / r116), 1)), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r114), 1)));
        goto L80
    L49:
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r115, 0)), Integer.valueOf(RangesKt.coerceAtLeast(r116, 0)));
        goto L80
    L42:
        if (r114 <= 0.0f) goto L44;
        float r123 = r115;
        float r124 = r116;
        float r125 = Math.min(r112 / r123, r114 / r124);
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r123 * r125), 1)), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r124 * r125), 1)));
    L50:
        Float r126 = Float.valueOf(this.f382232v.f382258n);
        if (r126.floatValue() <= 0.0f) goto L53;
        boolean r127 = true;
    L54:
        if (r127 == true) goto L57;
        r126 = null;
    L57:
        if (r126 == null) goto L59;
        float r128 = r126.floatValue();
    L60:
        Float r129 = Float.valueOf(r112);
        if (r129.floatValue() <= 0.0f) goto L63;
        boolean r130 = true;
    L64:
        if (r130 == true) goto L67;
        r129 = null;
    L67:
        if (r129 == null) goto L69;
        float r131 = r129.floatValue();
    L70:
        int r132 = MathKt.roundToInt(r131);
        Float r133 = Float.valueOf(r114);
        if (r133.floatValue() <= 0.0f) goto L73;
        boolean r134 = true;
    L74:
        if (r134 == true) goto L77;
        r133 = null;
    L77:
        if (r133 == null) goto L79;
        r128 = r133.floatValue();
    L79:
        r117 = new Pair(Integer.valueOf(RangesKt.coerceAtLeast(r132, 0)), Integer.valueOf(RangesKt.coerceAtLeast(MathKt.roundToInt(r128), 0)));
        goto L80
    L73:
        r134 = false;
        goto L74
    L69:
        r131 = r128;
        goto L70
    L63:
        r130 = false;
        goto L64
    L59:
        r128 = 0.0f;
        goto L60
    L53:
        r127 = false;
        goto L54
    L34:
        r114 = 0.0f;
        goto L35
    L30:
        r112 = 0.0f;
    L10:
        r104 = null;
        goto L11
    }
}
