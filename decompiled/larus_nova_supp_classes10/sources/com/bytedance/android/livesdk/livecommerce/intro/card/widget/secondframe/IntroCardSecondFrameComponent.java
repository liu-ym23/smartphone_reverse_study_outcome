package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.event.h;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.e0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.f0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.h0;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdk.livecommerce.view.AutoHideLinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oh2.c;
import oh2.e;
import th2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/secondframe/IntroCardSecondFrameComponent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Loh2/e;", "a", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardSecondFrameComponent extends ConstraintLayout {
    public e a;
    public c b;
    public final IntroCustomEllipsisTextView c;
    public final AutoHideLinearLayout d;
    public boolean e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public IntroCardSecondFrameComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardSecondFrameComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public e getArgument() {
        return this.a;
    }

    public c getContainerAbility() {
        return this.b;
    }

    public void setArgument(e r1) {
        this.a = r1;
    }

    public void setContainerAbility(c r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.PropertyItemView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void R5(g0 r32, int r33) {
        Intrinsics.checkNotNullParameter(r32, "model");
        this.d.removeAllViews();
        h0 r3 = r32.d();
        int r5 = 0;
        if (r3 == null) goto L9;
        String r4 = r3.b();
        if (r4 == null) goto L9;
        if ((!StringsKt.isBlank(r4)) != true) goto L9;
        final boolean r6 = true;
    L10:
        h0 r7 = r32.d();
        ECLiveLayoutConfig r8 = null;
        Integer r9 = null;
        r8 = null;
        r8 = null;
        if (r7 == null) goto L66;
        String r10 = r7.b();
        if (r10 != null) goto L15;
    L50:
        this.c.setVisibility(8);
        Unit r11 = Unit.INSTANCE;
    L51:
        int r12 = c0.a;
        c0.b(this.c, MonitorLevel.FATAL);
        IntroCustomEllipsisTextView r13 = this.c;
        List<String> r14 = r7.a();
        if (r14 == null) goto L64;
        List r15 = PromotionCardStyleHelper.ButtonHelper.a(r14);
        if (((ArrayList) r15).size() != 3) goto L56;
        boolean r16 = true;
    L57:
        if (r16 == true) goto L60;
        r15 = null;
    L60:
        if (r15 == null) goto L64;
        int[] r17 = CollectionsKt.toIntArray(r15);
        if (r17 == null) goto L64;
        ol2.a r18 = new ol2.a(r17, new float[]{0.0494f, 0.5738f, 0.9473f}, IntroCardSecondFrameComponent$updateTitleArea$5$1.INSTANCE);
    L65:
        r13.setLinearGradientCreator(r18);
    L67:
        f0 r19 = r32.b();
        int r20 = 6;
        if (r19 == null) goto L245;
        this.d.setVisibility(0);
        List<String> r110 = r19.a();
        if (r110 == null) goto L85;
        List<String> r111 = r110;
        if ((r111 instanceof Collection) == true) goto L74;
    L76:
        Iterator<T> r112 = r111.iterator();
    L78:
        if (r112.hasNext() == false) goto L82;
        if ((!StringsKt.isBlank((String) r112.next())) == false) goto L78;
        boolean r113 = true;
    L83:
        if (r113 == false) goto L85;
    L86:
        if (r110 == null) goto L105;
        LinearLayoutCompat r114 = this.d;
        com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.a r115 = new com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.a(getContext());
        Intrinsics.checkNotNullParameter(r110, "headers");
        r115.removeAllViews();
        Iterator<T> r116 = r110.iterator();
        int r117 = 0;
    L89:
        if (r116.hasNext() == false) goto L104;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L93;
        CollectionsKt.throwIndexOverflow();
    L93:
        CharSequence r120 = (String) r118;
        if (r117 != 0) goto L96;
        float r121 = 3.0f;
    L99:
        TextView r21 = new TextView(r115.getContext());
        r21.setText(r120);
        if (r6 == false) goto L102;
        float r22 = 9.0f;
    L103:
        r21.setTextSize(2, r22);
        r21.setTextColor(ColorProtector.parseColor("#FFB9BABD"));
        r21.setGravity(8388611);
        r21.setIncludeFontPadding(false);
        r21.setSingleLine();
        LinearLayout.LayoutParams r23 = new LinearLayout.LayoutParams(-2, -2);
        r23.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(r121));
        Unit r122 = Unit.INSTANCE;
        r21.setLayoutParams(r23);
        r115.addView(r21);
        r117 = r119;
        goto L89
    L102:
        r22 = 10.0f;
        goto L103
    L96:
        if (r6 == false) goto L98;
        r121 = 3.5f;
        goto L99
    L98:
        r121 = 14.3f;
        goto L99
    L104:
        Unit r24 = Unit.INSTANCE;
        r114.addView(r115);
    L105:
        List<e0> r25 = r19.b();
        if (r25 == null) goto L215;
        Iterator<T> r26 = r25.iterator();
        int r27 = 0;
    L109:
        if (r26.hasNext() == false) goto L215;
        Object r28 = r26.next();
        int r123 = r27 + 1;
        if (r27 >= 0) goto L113;
        CollectionsKt.throwIndexOverflow();
    L113:
        e0 r29 = (e0) r28;
        final ?? r124 = new PropertyItemView(getContext(), null, 6, r5);
        if (r27 != 0) goto L116;
        boolean r125 = true;
    L117:
        Intrinsics.checkNotNullParameter(r29, "model");
        ImageView r126 = r124.c;
        if (r125 == false) goto L120;
        int r127 = 8;
    L121:
        r126.setVisibility(r127);
        TextView r128 = r124.a;
        String r129 = r29.b();
        String r130 = "";
        if (r129 != null) goto L124;
        r129 = "";
    L124:
        r128.setText(r129);
        TextView r131 = r124.b;
        String r30 = r29.a();
        if (r30 == null) goto L128;
        r130 = r30;
    L128:
        r131.setText(r130);
        ECLiveABUtils r31 = ECLiveABUtils.INSTANCE;
        b r132 = r31.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r33));
        if (r132 == null) goto L186;
        ECLiveSkinViewUIConfig r133 = r132.t();
        if (r133 == null) goto L186;
        ECLiveLayoutConfig r134 = r133.getLayout();
        if (r134 == null) goto L186;
        Integer r135 = r134.getLeftMargin();
        if (r135 != null) goto L137;
    L145:
        int r136 = 0;
    L146:
        d2.c(r124.b, UtilityKotlinExtentionsKt.d(Integer.valueOf(r136)));
        if (r6 == false) goto L149;
        int r34 = 1;
    L161:
        d2.f(r124.b, UtilityKotlinExtentionsKt.d(Integer.valueOf(r34)));
        Integer r35 = r134.getBottomMargin();
        if (r35 != null) goto L164;
    L172:
        int r36 = 0;
    L173:
        d2.a(r124.b, UtilityKotlinExtentionsKt.d(Integer.valueOf(r36)));
        Integer r37 = r134.getRightMargin();
        if (r37 != null) goto L176;
    L184:
        int r38 = 0;
    L185:
        d2.e(r124.b, UtilityKotlinExtentionsKt.d(Integer.valueOf(r38)));
    L187:
        UtilityKotlinExtentionsKt.h(r134, new PropertyItemView$updateShowStyle$2(r124, r6));
        b r39 = r31.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r33));
        int r40 = 20;
        if (r39 == null) goto L193;
        ECLiveSkinViewUIConfig r41 = r39.s();
        if (r41 == null) goto L193;
        ECLiveLayoutConfig r42 = r41.getLayout();
        if (r42 == null) goto L193;
    L194:
        Integer r137 = r42.getLeftMargin();
        if (r137 == null) goto L197;
        int r138 = r137.intValue();
    L198:
        Integer r43 = r42.getRightMargin();
        if (r43 == null) goto L201;
        r40 = r43.intValue();
    L201:
        o0.f(r124.c, UtilityKotlinExtentionsKt.d(Integer.valueOf(r138 + r40)));
        ImageView r44 = r124.c;
        if (r6 == false) goto L204;
        int r45 = 26;
    L205:
        a1.k(r44, UtilityKotlinExtentionsKt.d(Integer.valueOf(r45)));
        TextView r46 = r124.a;
        if (r6 == false) goto L208;
        float r47 = 11.0f;
    L209:
        r46.setTextSize(1, r47);
        this.d.addView(r124);
        if (r27 != 0) goto L213;
        if (r110 == null) goto L213;
        d2.c(r124, UtilityKotlinExtentionsKt.d(12));
    L213:
        r27 = r123;
        r5 = 0;
        goto L109
    L208:
        r47 = 12.0f;
        goto L209
    L204:
        r45 = 40;
        goto L205
    L197:
        r138 = 20;
    L193:
        r42 = new ECLiveLayoutConfig(null, null, 20, 20, null, null, null, null, null, null, null, 2035, null);
        goto L194
    L176:
        if (r37.intValue() < 0) goto L178;
        boolean r139 = true;
    L179:
        if (r139 == true) goto L182;
        r37 = null;
    L182:
        if (r37 == null) goto L184;
        r38 = r37.intValue();
        goto L185
    L178:
        r139 = false;
        goto L179
    L164:
        if (r35.intValue() < 0) goto L166;
        boolean r140 = true;
    L167:
        if (r140 == true) goto L170;
        r35 = null;
    L170:
        if (r35 == null) goto L172;
        r36 = r35.intValue();
        goto L173
    L166:
        r140 = false;
        goto L167
    L149:
        Integer r48 = r134.getTopMargin();
        if (r48 != null) goto L152;
    L160:
        r34 = 12;
        goto L161
    L152:
        if (r48.intValue() < 0) goto L154;
        boolean r141 = true;
    L155:
        if (r141 == true) goto L158;
        r48 = null;
    L158:
        if (r48 == null) goto L160;
        r34 = r48.intValue();
        goto L161
    L154:
        r141 = false;
        goto L155
    L137:
        if (r135.intValue() < 0) goto L139;
        boolean r142 = true;
    L140:
        if (r142 == true) goto L143;
        r135 = null;
    L143:
        if (r135 == null) goto L145;
        r136 = r135.intValue();
        goto L146
    L139:
        r142 = false;
    L186:
        r134 = null;
        goto L187
    L120:
        r127 = 0;
        goto L121
    L116:
        r125 = false;
    L215:
        if (this.e == true) goto L223;
        e r1 = getArgument();
        if (r1 == null) goto L221;
        IntroCardEventCenter r2 = r1.a;
        if (r2 == null) goto L221;
        IntroCardEventCenter.b(new h(r2));
    L221:
        this.e = true;
    L223:
        LinkedHashMap r49 = new LinkedHashMap();
        Map<String, String> r50 = r32.a();
        if (r50 == null) goto L228;
        String r51 = r50.get("sellpoint_bp");
        if (r51 == null) goto L228;
        r49.put("sellpoint_bp", r51);
    L228:
        r49.put("card_extend_type", "attribute");
        e r52 = getArgument();
        if (r52 == null) goto L246;
        IntroCardEventCenter r53 = r52.a;
        if (r53 == null) goto L246;
        Intrinsics.checkNotNullParameter(r49, "params");
        g r54 = (g) r53.d.invoke(null);
        if (r54 == null) goto L246;
        ql.a r55 = r54.a;
        if ((r55 instanceof IntroPromotionVO) == true) goto L237;
        r55 = null;
    L237:
        IntroPromotionVO r56 = (IntroPromotionVO) r55;
        if (r56 == null) goto L246;
        Iterator r57 = r49.entrySet().iterator();
    L241:
        if (r57.hasNext() == false) goto L246;
        Map.Entry r58 = (Map.Entry) r57.next();
        String r59 = (String) r58.getKey();
        String r60 = (String) r58.getValue();
        Map r61 = r56.getEventParams();
        if (r61 == null) goto L241;
        String r62 = (String) r61.put(r59, r60);
    L246:
        b r63 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r33));
        if (r63 == null) goto L299;
        ECLiveSkinViewUIConfig r64 = r63.r();
        if (r64 == null) goto L299;
        ECLiveLayoutConfig r65 = r64.getLayout();
        if (r65 == null) goto L299;
        Integer r66 = r65.getLeftMargin();
        if (r66 != null) goto L255;
    L263:
        int r67 = 0;
    L264:
        d2.c(this.d, UtilityKotlinExtentionsKt.d(Integer.valueOf(r67)));
        Integer r68 = r65.getTopMargin();
        if (r68 != null) goto L267;
    L275:
        d2.f(this.d, UtilityKotlinExtentionsKt.d(Integer.valueOf(r20)));
        Integer r69 = r65.getBottomMargin();
        if (r69 != null) goto L278;
    L286:
        int r70 = 0;
    L287:
        d2.a(this.d, UtilityKotlinExtentionsKt.d(Integer.valueOf(r70)));
        Integer r71 = r65.getRightMargin();
        if (r71 != null) goto L290;
    L297:
        int r72 = 0;
    L298:
        d2.e(this.d, UtilityKotlinExtentionsKt.d(Integer.valueOf(r72)));
        r8 = r65;
        goto L299
    L290:
        if (r71.intValue() < 0) goto L292;
        boolean r73 = true;
    L293:
        if (r73 == false) goto L295;
        r9 = r71;
    L295:
        if (r9 == null) goto L297;
        r72 = r9.intValue();
        goto L298
    L292:
        r73 = false;
        goto L293
    L278:
        if (r69.intValue() < 0) goto L280;
        boolean r74 = true;
    L281:
        if (r74 == true) goto L284;
        r69 = null;
    L284:
        if (r69 == null) goto L286;
        r70 = r69.intValue();
        goto L287
    L280:
        r74 = false;
        goto L281
    L267:
        if (r68.intValue() < 0) goto L269;
        boolean r75 = true;
    L270:
        if (r75 == true) goto L273;
        r68 = null;
    L273:
        if (r68 == null) goto L275;
        r20 = r68.intValue();
        goto L275
    L269:
        r75 = false;
        goto L270
    L255:
        if (r66.intValue() < 0) goto L257;
        boolean r76 = true;
    L258:
        if (r76 == true) goto L261;
        r66 = null;
    L261:
        if (r66 == null) goto L263;
        r67 = r66.intValue();
        goto L264
    L257:
        r76 = false;
    L299:
        UtilityKotlinExtentionsKt.h(r8, new IntroCardSecondFrameComponent$updateShowStyle$2(this));
        return;
    L82:
        r113 = false;
        goto L83
    L74:
        if (r111.isEmpty() == false) goto L76;
    L85:
        r110 = null;
        goto L86
    L245:
        this.d.setVisibility(8);
        Unit r77 = Unit.INSTANCE;
        goto L246
    L56:
        r16 = false;
    L64:
        r18 = null;
        goto L65
    L15:
        if (r10.length() <= 0) goto L17;
        boolean r143 = true;
    L18:
        if (r143 == true) goto L21;
        r10 = null;
    L21:
        if (r10 == null) goto L50;
        this.c.setVisibility(0);
        this.c.setOriginalText(r10);
        if (this.f == true) goto L51;
        s1 r78 = r7.c();
        if (r78 == null) goto L51;
        String r79 = r78.c();
        if (r79 == null) goto L51;
        if ((!StringsKt.isBlank(r79)) == true) goto L33;
        r79 = null;
    L33:
        if (r79 == null) goto L51;
        e r144 = getArgument();
        if (r144 == null) goto L49;
        IntroCardEventCenter r145 = r144.a;
        if (r145 == null) goto L49;
        String r80 = "livesdk_" + r79 + "_show";
        s1 r146 = r7.c();
        if (r146 == null) goto L41;
        Map<String, String> r147 = r146.d();
    L42:
        e r148 = getArgument();
        if (r148 == null) goto L47;
        com.bytedance.android.livesdk.livecommerce.intro.event.a r149 = r148.b;
        if (r149 == null) goto L47;
        r149.a();
        String r150 = "a1128.b3295.c59667.d30609";
    L48:
        r145.a(r80, r147, r150);
    L47:
        r150 = null;
        goto L48
    L41:
        r147 = null;
    L49:
        this.f = true;
        goto L51
    L17:
        r143 = false;
        goto L18
    L66:
        this.c.setVisibility(8);
        Unit r81 = Unit.INSTANCE;
    L9:
        r6 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.TextView, com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.IntroCustomEllipsisTextView] */
    public IntroCardSecondFrameComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560758, this, true);
        ?? r5 = (IntroCustomEllipsisTextView) findViewById(2131391606);
        this.c = r5;
        this.d = (AutoHideLinearLayout) findViewById(2131377585);
        r5.getPaint().setTextSkewX(-0.12f);
    }

    public /* synthetic */ IntroCardSecondFrameComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
