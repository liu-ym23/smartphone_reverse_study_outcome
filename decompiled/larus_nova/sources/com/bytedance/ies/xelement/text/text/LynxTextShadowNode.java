package com.bytedance.ies.xelement.text.text;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bytedance.ies.xelement.text.emoji.b;
import com.bytedance.ies.xelement.text.emoji.d;
import com.bytedance.ies.xelement.text.emoji.e;
import com.bytedance.ies.xelement.text.inlinetext.LynxInlineTextShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.android.SystemUtils;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.shadow.text.g;
import com.lynx.tasm.behavior.utils.f;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import y6a.l;
import z6a.p;

/* JADX INFO: loaded from: classes19.dex */
@LynxShadowNode(tagName = "x-text")
@LynxGeneratorName(packageName = "com.bytedance.ies.xelement.text.text")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xelement/text/text/LynxTextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/TextShadowNode;", "Lcom/lynx/tasm/behavior/shadow/text/g$c;", "", "textMaxLine", "", "setTextMaxLine", "ellipsizeMode", "setEllipsizeMode", "type", "setRichType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-text_release"}, k = 1, mv = {1, 6, 0})
public final class LynxTextShadowNode extends TextShadowNode implements g.c {
    public static final Regex V0 = null;
    public int H0;
    public SpannableStringBuilder L0;
    public Function1<? super Context, ? extends b> P0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public String f250389p0;

    public static final class a {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final boolean T() {
        return false;
    }

    static {
        V0 = new Regex("^[\\s]+|[\\s]+$");
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final int Q() {
        SpannableStringBuilder r100 = this.L0;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100.length();
    L5:
        return 0;
    }

    public LynxTextShadowNode() {
        this.f250389p0 = "none";
        this.P0 = LynxTextShadowNode$adapterProvider$1.INSTANCE;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final void U() {
        super.U();
        CharSequence r100 = (SpannableStringBuilder) this.N;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        this.L0 = new SpannableStringBuilder(r100);
    }

    public final float X(TextPaint r100) {
        int r101 = l();
        float r102 = 0.0f;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L11;
        ShadowNode r104 = k(r103);
        if ((r104 instanceof LynxInlineTruncationShadowNode) == false) goto L9;
        CharSequence r105 = ((LynxInlineTruncationShadowNode) r104).N;
        if (r105 == null) goto L9;
        r102 = r102 + Layout.getDesiredWidth(r105, r100);
    L9:
        r103 = r103 + 1;
        goto L3
    L11:
        return (float) Math.ceil(r102 + 0.5f);
    }

    @LynxProp(name = "ellipsize-mode")
    public final void setEllipsizeMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ellipsizeMode");
        if (Intrinsics.areEqual(r100, "tail") == false) goto L6;
        setTextOverflow(1);
    L8:
        q();
        return;
    L6:
        if (Intrinsics.areEqual(r100, "clip") == false) goto L8;
        setTextOverflow(0);
        goto L8
    }

    @LynxProp(name = "richtype")
    public final void setRichType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L13;
        this.f250389p0 = r100;
        if (Intrinsics.areEqual(r100, "bracket") == true) goto L7;
    L11:
        q();
        return;
    L7:
        if (l.a(this.f382232v.f382255k) == false) goto L9;
        float r101 = 40.0f;
    L10:
        setLineHeight(r101);
        goto L11
    L9:
        r101 = this.f382232v.f382255k;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    @LynxProp(name = "text-maxline")
    public void setTextMaxLine(String r100) {
        Intrinsics.checkNotNullParameter(r100, "textMaxLine");
        super.setTextMaxLine(r100);
        this.H0 = CastIntegerProtector.parseInt(r100);
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r100) {
        super.w(r100);
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L6;
        d r101 = d.f250380b;
        d r102 = d.a.a();
        Function1<? super Context, ? extends b> r103 = this.P0;
        Intrinsics.checkNotNull(r100);
        b r104 = r103.invoke(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f250381a = r104;
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void G(SpannableStringBuilder r100, List<BaseTextShadowNode.a> r101) {
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L10;
        int r102 = l();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        ShadowNode r104 = k(r103);
        if ((r104 instanceof LynxInlineTextShadowNode) == false) goto L9;
        LynxInlineTextShadowNode r105 = (LynxInlineTextShadowNode) r104;
        String r106 = this.f250389p0;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.Q = r106;
    L9:
        r103 = r103 + 1;
    L10:
        super.G(r100, r101);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.g.c
    public final void a(Typeface r100, int r101) {
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void E(SpannableStringBuilder r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sb");
        if (r101 == null) goto L5;
        String r103 = f.a(V0.replace(r101, ""), 0);
    L7:
        if (LynxLiteConfigs.supportCustomEmojiInText() == true) goto L9;
        r100.append(r103);
        return;
    L9:
        if (Intrinsics.areEqual(this.f250389p0, "bracket") == false) goto L11;
        Pattern r104 = com.bytedance.ies.xelement.text.emoji.g.f250386a;
        r100.append(com.bytedance.ies.xelement.text.emoji.g.a(getContext(), r103, (int) this.f382232v.f382258n));
        return;
    L11:
        r100.append(r103);
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.shadow.text.TextShadowNode
    public final long c(LayoutNode r210, float r211, MeasureMode r310, float r311, MeasureMode r312) {
        if (this.L0 == null) goto L6;
        this.N = new SpannableStringBuilder(this.L0);
    L6:
        if (r310 != MeasureMode.UNDEFINED) goto L8;
        float r100 = Float.MAX_VALUE;
    L9:
        int r101 = 0;
        this.Y = 0;
        int r102 = l();
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r103 >= r102) goto L15;
        if ((k(r103) instanceof LynxInlineTruncationShadowNode) == false) goto L14;
        r104 = r104 + 1;
    L14:
        r103 = r103 + 1;
        goto L10
    L15:
        if (r104 > 0) goto L17;
        boolean r105 = false;
    L179:
        if (r105 == false) goto L195;
        CharSequence r106 = this.N;
        if ((r106 instanceof SpannableStringBuilder) == true) goto L184;
        r106 = null;
    L184:
        if (r106 == null) goto L186;
        SpannableStringBuilder r107 = (SpannableStringBuilder) r106;
    L187:
        int r108 = l();
    L188:
        if (r101 >= r108) goto L195;
        ShadowNode r109 = k(r101);
        if ((r109 instanceof LynxInlineTruncationShadowNode) == false) goto L193;
        if (r107 == null) goto L193;
        r107.append(((LynxInlineTruncationShadowNode) r109).N);
    L193:
        r101 = r101 + 1;
        goto L188
    L186:
        r107 = null;
    L195:
        return super.c(r210, r211, r310, r311, r312);
    L17:
        LynxContext r110 = getContext();
        com.lynx.tasm.behavior.shadow.text.a r111 = this.f382232v;
        DecimalFormat r112 = com.lynx.tasm.behavior.shadow.text.b.f382275a;
        String r113 = r111.f382265u;
        if (TextUtils.isEmpty(r113) == true) goto L20;
        Typeface r114 = g.d(r110, r113, r111.e());
    L21:
        TextPaint r115 = com.lynx.tasm.behavior.shadow.text.b.l(r111, r114);
        int r116 = Build.VERSION.SDK_INT;
        if (r116 < 23) goto L24;
        CharSequence r117 = this.N;
        int r118 = (int) r100;
        StaticLayout r119 = StaticLayout.Builder.obtain(r117, 0, r117.length(), r115, r118).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(this.f382232v.f382257m, 1.0f).setIncludePad(this.f382232v.f382264t).setEllipsize(TextUtils.TruncateAt.END).setEllipsizedWidth(r118).setTextDirection(this.f382232v.b()).build();
    L26:
        if (r116 != 29) goto L49;
        if (SystemUtils.PRODUCT_HUAWEI.equals(Build.MANUFACTURER) == false) goto L49;
        CharSequence r120 = this.N;
        Field r121 = com.lynx.tasm.utils.d.f384084a;
        if (r119 == null) goto L49;
        if (TextUtils.isEmpty(r120) == true) goto L49;
        int r122 = r119.getLineCount();
        if (r122 == 0) goto L49;
        int r123 = r122 - 1;
        int r124 = r119.getEllipsisStart(r123);
        if (r124 < 0) goto L49;
        if (Character.isLowSurrogate(r120.charAt(r124)) == false) goto L49;
        ((int[]) com.lynx.tasm.utils.d.f384084a.get(r119))[(((Integer) com.lynx.tasm.utils.d.f384085b.get(r119)).intValue() * r123) + 5] = r124 + 1;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L49:
        if (this.H0 > 0) goto L51;
    L52:
        int r125 = l();
        int r126 = 0;
    L53:
        if (r126 >= r125) goto L60;
        ShadowNode r127 = k(r126);
        if ((r127 instanceof LynxInlineTruncationShadowNode) == false) goto L59;
        if (((LynxInlineTruncationShadowNode) r127).f250388p0 == false) goto L59;
        boolean r128 = true;
    L61:
        if (r128 == false) goto L63;
    L62:
        boolean r129 = true;
    L64:
        int r130 = RangesKt.coerceAtMost(r119.getLineCount(), this.H0);
        if (r129 == false) goto L89;
        int r131 = l();
        int r132 = 0;
    L67:
        if (r132 >= r131) goto L74;
        ShadowNode r133 = k(r132);
        if ((r133 instanceof LynxInlineTruncationShadowNode) == false) goto L73;
        if (((LynxInlineTruncationShadowNode) r133).f250388p0 == false) goto L73;
        boolean r134 = true;
    L75:
        if (r134 == false) goto L89;
        if (r130 >= (this.H0 - 1)) goto L89;
        if ((r119.getLineWidth(r130 - 1) + X(r115)) <= r100) goto L177;
        CharSequence r135 = this.N;
        if ((r135 instanceof SpannableStringBuilder) == true) goto L84;
        r135 = null;
    L84:
        if (r135 == null) goto L86;
        SpannableStringBuilder r136 = (SpannableStringBuilder) r135;
    L87:
        if (r136 == null) goto L177;
        r136.append("\n");
        goto L177
    L86:
        r136 = null;
    L177:
        boolean r137 = r129;
    L178:
        r105 = r137;
    L73:
        r132 = r132 + 1;
        goto L67
    L74:
        r134 = false;
    L89:
        if (r129 == false) goto L177;
        int r138 = r130 - 1;
        float r139 = r119.getLineWidth(r138);
        int r140 = r119.getLineEnd(r138);
        int r141 = r119.getLineStart(r138);
        int r142 = r140 - 1;
        char r143 = this.N.charAt(r142);
        if (r143 != '\n') goto L98;
        if (r140 > 1) goto L94;
    L96:
        int r144 = 1;
    L97:
        r140 = r140 - r144;
    L100:
        boolean r145 = true;
    L102:
        float r146 = X(r115) + r139;
        if (r146 > r100) goto L106;
        if (r145 == true) goto L106;
        if (r129 == false) goto L177;
    L106:
        int r147 = (int) ((r146 - r100) + 0.5f);
        if (this.f382232v.f382249e == 0) goto L109;
    L113:
        CharSequence r148 = this.N;
        if (r148 == null) goto L176;
        Object[] r149 = ((Spanned) r148).getSpans(r140, r140, Object.class);
        int r150 = this.f382232v.f382249e;
        if (r150 != 3) goto L118;
        SpannableStringBuilder r151 = new SpannableStringBuilder("\u200e…\u202c");
    L121:
        int r152 = r149.length;
        int r153 = 0;
    L122:
        if (r153 >= r152) goto L124;
        r151.setSpan(r149[r153], 0, r151.length(), 33);
        r153 = r153 + 1;
        r129 = r129;
        goto L122
    L124:
        r137 = r129;
        r147 = r147 + ((int) Layout.getDesiredWidth(r151, r115));
        boolean r154 = true;
    L125:
        CharSequence r155 = this.N.subSequence(r141, r140);
        ArrayList r156 = CollectionsKt.arrayListOf(new Integer[]{0, 0});
        if (TextUtils.isEmpty(r155) == false) goto L128;
        r151 = r151;
        float r212 = r139;
        int r157 = 1;
    L166:
        SpannableStringBuilder r158 = new SpannableStringBuilder();
        if (r130 <= r157) goto L169;
        r158.append(this.N.subSequence(r101, r119.getLineEnd(r130 - 2)));
    L169:
        if (r154 == false) goto L171;
        r158.append(this.N.subSequence(r141, r140 - ((Number) ListProtector.get(r156, r101)).intValue()));
        this.Y = this.N.length() - r158.length();
    L172:
        if (r151 == null) goto L174;
        r158.append(r151);
    L174:
        this.N = r158;
        goto L178
    L171:
        CharSequence r159 = this.N;
        CharSequence r160 = TextUtils.ellipsize(r159.subSequence(r141, r159.length()), r115, r212 - ((Number) ListProtector.get(r156, 1)).floatValue(), TextUtils.TruncateAt.END);
        this.Y = ((this.N.length() - r141) - r160.length()) + 1;
        r158.append(r160);
        goto L172
    L128:
        int r161 = r155.length();
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L160;
        ArrayList r162 = new ArrayList();
        if (LynxLiteConfigs.supportCustomEmojiInText() == false) goto L141;
        if (TextUtils.isEmpty(r155) == true) goto L141;
        if ((r155 instanceof Spanned) == false) goto L141;
        Spanned r163 = (Spanned) r155;
        e[] r164 = (e[]) r163.getSpans(0, r155.length(), e.class);
        int r165 = r164.length;
    L138:
        if (r101 >= r165) goto L141;
        int r213 = r165;
        e r166 = r164[r101];
        r162.add(CollectionsKt.listOf(new Integer[]{Integer.valueOf(r163.getSpanStart(r166)), Integer.valueOf(r163.getSpanEnd(r166))}));
        r101 = r101 + 1;
        r165 = r213;
        r164 = r164;
        r139 = r139;
    L141:
        r212 = r139;
        r161 = r161;
        float r167 = 0.0f;
    L142:
        if (r161 <= 0) goto L161;
        if (r147 <= r167) goto L161;
        int r168 = r162.size() - 1;
        if (r168 < 0) goto L155;
    L147:
        int r169 = r168 - 1;
        List r170 = (List) ListProtector.get(r162, r168);
        if (((Number) ListProtector.get(r170, 0)).intValue() <= r161) goto L150;
    L152:
        if (r169 < 0) goto L155;
        r168 = r169;
        goto L147
    L150:
        if (r161 > ((Number) ListProtector.get(r170, 1)).intValue()) goto L152;
        int r171 = ((Number) ListProtector.get(r170, 1)).intValue() - ((Number) ListProtector.get(r170, 0)).intValue();
    L156:
        if (r171 > 0) goto L159;
        r171 = 1;
    L159:
        r161 = r161 - r171;
        r167 = Layout.getDesiredWidth(r155.subSequence(r161, r155.length()), r115);
    L155:
        r171 = 0;
    L161:
        if (r161 <= 0) goto L165;
        if (r147 <= r167) goto L165;
        r161 = r161 - 1;
        r167 = Layout.getDesiredWidth(r155.subSequence(r161, r155.length()), r115);
    L165:
        r101 = 0;
        ListProtector.set(r156, 0, Integer.valueOf(r155.length() - r161));
        r157 = 1;
        ListProtector.set(r156, 1, Integer.valueOf((int) r167));
        goto L166
    L160:
        r151 = r151;
        r212 = r139;
        r167 = 0.0f;
        goto L161
    L118:
        if (r150 != 0) goto L120;
        r151 = new SpannableStringBuilder("…");
        goto L121
    L120:
        r151 = new SpannableStringBuilder("\u200f…\u202c");
        goto L121
    L176:
        throw new NullPointerException("null cannot be cast to non-null type android.text.Spanned");
    L109:
        if (r146 >= r100) goto L112;
        if (r145 == true) goto L113;
    L112:
        r137 = r129;
        r154 = false;
        r151 = null;
        goto L125
    L94:
        if (this.N.charAt(r140 - 2) != '\r') goto L96;
        r144 = 2;
        goto L97
    L98:
        if (r143 != '\r') goto L101;
        r140 = r142;
        goto L100
    L101:
        r145 = false;
        goto L102
    L63:
        r129 = false;
    L59:
        r126 = r126 + 1;
        goto L53
    L60:
        r128 = false;
        goto L61
    L51:
        if (r119.getLineCount() > this.H0) goto L62;
    L24:
        CharSequence r172 = this.N;
        Layout.Alignment r173 = Layout.Alignment.ALIGN_NORMAL;
        com.lynx.tasm.behavior.shadow.text.a r174 = this.f382232v;
        r119 = p.a(r172, r172.length(), r115, (int) r100, r173, 1.0f, r174.f382257m, r174.f382264t, TextUtils.TruncateAt.END, -1, r174.b());
        goto L26
    L20:
        r114 = null;
        goto L21
    L8:
        r100 = r211;
        goto L9
    }
}
