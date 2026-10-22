package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.ec.model.response.l1;
import com.bytedance.android.ec.model.response.m1;
import com.bytedance.android.ec.model.response.v;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.PromotionCardStyleHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.common.util.UriUtil;
import hl.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardButtonComponent;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "", "label", "", "setButtonLabel", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardButtonComponent extends ECRoundedLinearLayout {
    public jj2.a b;
    public LivePromotionCardArgsV2 c;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a d;
    public final ImageView e;
    public final TextView f;
    public final View g;
    public final ECDraweeView h;
    public final TextView i;
    public final ECDraweeView j;
    public boolean k;
    public final int l;

    public static final class a implements View.OnLongClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class b implements View.OnLongClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            return true;
        }
    }

    public static final class c {
    }

    static {
    }

    public PromotionCardButtonComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardButtonComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setButtonLabel(String r5) {
        this.f.setText(r5);
        LivePromotionCardArgsV2 r0 = this.c;
        Boolean r1 = null;
        if (r0 == null) goto L14;
        ILivePromotionCardContainerHandler r2 = r0.b;
        if (r2 == null) goto L14;
        Boolean r3 = Boolean.valueOf(r2.h(Decision.SHORTEN_BTN_INSTANT_FUSION));
        if (r3.booleanValue() == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L14;
        r3.booleanValue();
        if (r5 == null) goto L14;
        a(r5, 3);
    L14:
        LivePromotionCardArgsV2 r4 = this.c;
        if (r4 == null) goto L28;
        ILivePromotionCardContainerHandler r6 = r4.b;
        if (r6 == null) goto L29;
        Boolean r7 = (Boolean) r6.n(ILivePromotionCardContainerHandler.Scene.BuyBtnWidthSelfAdapt, Reflection.getOrCreateKotlinClass(Boolean.TYPE), null);
        if (r7 != null) goto L21;
        return;
    L21:
        if (r7.booleanValue() == false) goto L23;
        r1 = r7;
    L23:
        if (r1 == null) goto L31;
        r1.booleanValue();
        if (r5 == null) goto L32;
        a(r5, 2);
        return;
    L32:
        return;
    L31:
        return;
    L29:
        return;
    }

    public final void b(jj2.a r27) {
        Intrinsics.checkNotNullParameter(r27, "model");
        this.b = r27;
        IPromotionUIConfig.d r0 = r27.c.a(PromotionCardModuleName.AddCartModule);
        if (r0 == null) goto L5;
        int r3 = UIConfigHelper.a;
        UIConfigHelper.d(this.e, r0);
    L5:
        IPromotionUIConfig.d r1 = r27.c.a(PromotionCardModuleName.BuyModule);
        if (r1 == null) goto L8;
        int r4 = UIConfigHelper.a;
        UIConfigHelper.d(this.f, r1);
    L8:
        IPromotionUIConfig.d r2 = r27.c.a(PromotionCardModuleName.ButtonAreaModule);
        if (r2 == null) goto L12;
        UIConfigHelper.d(this, r2);
    L12:
        if (r27.a.c() == null) goto L27;
        e(r27);
        LivePromotionCardArgsV2 r5 = this.c;
        if (r5 == null) goto L20;
        ILivePromotionCardContainerHandler r6 = r5.b;
        if (r6 == null) goto L20;
        Integer r7 = (Integer) r6.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextColor, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r7 == null) goto L20;
        this.i.setTextColor(r7.intValue());
    L20:
        LivePromotionCardArgsV2 r8 = this.c;
        if (r8 == null) goto L28;
        ILivePromotionCardContainerHandler r9 = r8.b;
        if (r9 == null) goto L28;
        Integer r10 = (Integer) r9.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperTextSize, Reflection.getOrCreateKotlinClass(Integer.TYPE), null);
        if (r10 == null) goto L28;
        this.i.setTextSize(r10.intValue());
    L28:
        m1 r11 = r27.a.b();
        boolean r12 = false;
        if (r11 == null) goto L336;
        this.f.setVisibility(0);
        this.f.setTextColor(th.a.a(getContext(), 2131101703));
        setButtonLabel(r11.b());
        jj2.a r13 = this.b;
        if (r13 == null) goto L37;
        g1 r14 = r13.a;
        if (r14 == null) goto L37;
        m1 r15 = r14.b();
        if (r15 == null) goto L37;
        j0 r16 = r15.a();
    L38:
        if (r16 == null) goto L40;
        boolean r17 = true;
    L41:
        this.k = r17;
        jj2.a r18 = this.b;
        if (r18 == null) goto L48;
        g1 r19 = r18.a;
        if (r19 == null) goto L48;
        m1 r20 = r19.b();
        if (r20 == null) goto L48;
        Long r21 = r20.f();
    L49:
        jj2.a r22 = this.b;
        if (r22 == null) goto L56;
        g1 r23 = r22.a;
        if (r23 == null) goto L56;
        m1 r24 = r23.b();
        if (r24 == null) goto L56;
        Long r25 = r24.d();
    L57:
        ECLiveSkinBtnUIConfig r26 = PromotionCardStyleHelper.ButtonHelper.a;
        Map<String, Map<String, AbsECLiveSkinBaseUIConfig>> r28 = PromotionCardStyleHelper.a;
        PromotionCardStyleComponent r29 = PromotionCardStyleComponent.BUTTON;
        if (r21 == null) goto L60;
        long r110 = r21.longValue();
    L61:
        Intrinsics.checkNotNullParameter(r29, "component");
        if (PromotionCardStyleHelper.a.containsKey(r29.getValue()) == true) goto L95;
        String r111 = r29.getValue();
        PromotionCardStyleComponent.Companion.getClass();
        Intrinsics.checkNotNullParameter(r111, "componentName");
        PromotionCardStyleComponent[] r30 = PromotionCardStyleComponent.values();
        int r112 = r30.length;
        int r31 = 0;
    L64:
        if (r31 >= r112) goto L69;
        PromotionCardStyleComponent r113 = r30[r31];
        if (Intrinsics.areEqual(r113.getValue(), r111) == true) goto L70;
        r31 = r31 + 1;
    L70:
        if (r113 == null) goto L95;
        LinkedHashMap r32 = new LinkedHashMap();
        Map<String, AbsECLiveSkinBaseUIConfig> r33 = PromotionCardStyleHelper.c.get(r113.getValue());
        if (r33 == null) goto L384;
        r32.putAll(r33);
    L384:
        JSONObject r34 = (JSONObject) PromotionCardStyleHelper.b.getValue();     // Catch: Exception -> L92
        if (r34 == null) goto L94;
        JSONObject r35 = r34.optJSONObject(r111);     // Catch: Exception -> L92
        if (r35 == null) goto L94;
        Iterator<String> r36 = r35.keys();     // Catch: Exception -> L92
    L80:
        if (r36.hasNext() == false) goto L94;
        String r114 = r36.next();     // Catch: Exception -> L92
        JSONObject r115 = r35.optJSONObject(r114);     // Catch: Exception -> L92
        if (r115 == null) goto L80;
        String r116 = r115.toString();     // Catch: Exception -> L92
        if (r116 == null) goto L80;
        int r117 = m0.a;     // Catch: Exception -> L92
        Object r37 = m0.a.a.fromJson(r116, JvmClassMappingKt.getJavaClass(r113.getDataClass()));     // Catch: Exception -> L92
        if ((r37 instanceof AbsECLiveSkinBaseUIConfig) == true) goto L88;
        r37 = null;
    L88:
        AbsECLiveSkinBaseUIConfig r38 = (AbsECLiveSkinBaseUIConfig) r37;     // Catch: Exception -> L92
        if (r38 == null) goto L80;
        r32.put(r114, r38);     // Catch: Exception -> L92
    L94:
        PromotionCardStyleHelper.a.put(r111, r32);
    L92:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L94
    L69:
        r113 = null;
    L95:
        Map r39 = (Map) ((LinkedHashMap) PromotionCardStyleHelper.a).get(r29.getValue());
        if (r39 == null) goto L98;
        AbsECLiveSkinBaseUIConfig r40 = (AbsECLiveSkinBaseUIConfig) r39.get(String.valueOf(r110));
    L100:
        if ((r40 instanceof AbsECLiveSkinBaseUIConfig) == true) goto L102;
        r40 = null;
    L102:
        ECLiveSkinBtnUIConfig r41 = (ECLiveSkinBtnUIConfig) r40;
        if (r41 != null) goto L105;
        r41 = PromotionCardStyleHelper.ButtonHelper.a;
    L105:
        ECLiveSkinBtnUIConfig r42 = r41;
        LivePromotionCardArgsV2 r43 = this.c;
        if (r43 == null) goto L110;
        ILivePromotionCardContainerHandler r44 = r43.b;
        if (r44 == null) goto L110;
        com.bytedance.android.livesdk.livecommerce.largemode.b r45 = r44.o();
    L111:
        Intrinsics.checkNotNullParameter(r42, "$this$adaptForLargeMode");
        if (r45 == null) goto L174;
        ComponentLargeModeConfig r118 = r45.b("List", "PromotionCard.Button");
        if (r118 == null) goto L125;
        LayoutLargeModeConfig r119 = r118.getLayoutConfig();
        if (r119 == null) goto L125;
        Integer r120 = r119.getRadius();
        if (r120 == null) goto L125;
        if (r120.intValue() <= 0) goto L122;
        boolean r121 = true;
    L123:
        if (r121 == false) goto L125;
    L126:
        if (r120 == null) goto L129;
        r120.intValue();
        List<Integer> r122 = CollectionsKt.listOf(new Integer[]{r120, r120, r120, r120});
        if (r122 == null) goto L129;
    L130:
        ComponentLargeModeConfig r123 = r45.b("List", "PromotionCard.Button.Buy");
        if (r123 == null) goto L142;
        hi2.a r124 = r123.getTextConfig();
        if (r124 == null) goto L142;
        Integer r125 = r124.a();
        if (r125 == null) goto L142;
        if (r125.intValue() <= 0) goto L139;
        boolean r126 = true;
    L140:
        if (r126 == false) goto L142;
    L143:
        ComponentLargeModeConfig r46 = r45.b("List", "PromotionCard.Button.Buy");
        if (r46 == null) goto L155;
        hi2.a r47 = r46.getTextConfig();
        if (r47 == null) goto L155;
        Integer r48 = r47.b();
        if (r48 == null) goto L155;
        if (r48.intValue() <= 0) goto L152;
        boolean r127 = true;
    L153:
        if (r127 == false) goto L155;
    L156:
        if (r122 != null) goto L158;
        r122 = r42.getRadius();
    L158:
        List<Integer> r128 = r122;
        ECLiveSkinBaseViewUIConfig r129 = r42.getEnabled();
        if (r129 == null) goto L172;
        ECLiveSkinTextElement r130 = r42.getEnabled().getText();
        if (r130 == null) goto L170;
        if (r125 == null) goto L164;
        int r131 = r125.intValue();
    L165:
        int r210 = r131;
        if (r48 == null) goto L168;
        int r49 = r48.intValue();
    L169:
        ECLiveSkinTextElement r132 = ECLiveSkinTextElement.copy$default(r130, r210, null, r49, 2, null);
    L171:
        ECLiveSkinBaseViewUIConfig r133 = ECLiveSkinBaseViewUIConfig.copy$default(r129, r132, null, null, null, null, 30, null);
    L173:
        r42 = ECLiveSkinBtnUIConfig.copy$default(r42, r133, null, r128, 2, null);
        goto L174
    L168:
        r49 = r42.getEnabled().getText().getFontWeight();
        goto L169
    L164:
        r131 = r42.getEnabled().getText().getFontSize();
        goto L165
    L170:
        r132 = null;
        goto L171
    L172:
        r133 = null;
        goto L173
    L152:
        r127 = false;
    L155:
        r48 = null;
        goto L156
    L139:
        r126 = false;
    L142:
        r125 = null;
    L129:
        r122 = r42.getRadius();
        goto L130
    L122:
        r121 = false;
    L125:
        r120 = null;
    L174:
        if (r25 == null) goto L176;
        final long r134 = r25.longValue();
    L177:
        List<Integer> r50 = r42.getRadius();
        if (r50 == null) goto L191;
        Integer r51 = (Integer) CollectionsKt.firstOrNull(r50);
        if (r51 == null) goto L191;
        if (r51.intValue() <= 0) goto L184;
        boolean r52 = true;
    L185:
        if (r52 == true) goto L188;
        r51 = null;
    L188:
        if (r51 == null) goto L191;
        setRadius(UtilityKotlinExtentionsKt.c(Integer.valueOf(r51.intValue())));
        goto L191
    L184:
        r52 = false;
    L191:
        if (r134 != 0) goto L193;
        final ECLiveSkinBaseViewUIConfig r53 = r42.getEnabled();
    L194:
        if (r53 == null) goto L210;
        ECLiveSkinBackgroundElement r54 = r53.getBackground();
        if (r54 == null) goto L210;
        List<String> r135 = r54.getColor();
        if (r135 != null) goto L200;
    L202:
        boolean r136 = false;
    L203:
        if (r136 == true) goto L206;
        r54 = null;
    L206:
        if (r54 == null) goto L210;
        List<String> r137 = null;
        Drawable r55 = ECLiveSkinBackgroundElement.a.b(ECLiveSkinBackgroundElement.Companion, r54, getContext(), null, 6);
        if (r55 == null) goto L211;
        this.f.setBackground(r55);
    L275:
        if (r53 == null) goto L287;
        ECLiveSkinTextElement r56 = r53.getText();
        if (r56 == null) goto L287;
        Integer r57 = Integer.valueOf(r56.getFontSize());
        if (r57.intValue() <= 0) goto L281;
        boolean r58 = true;
    L282:
        if (r58 == true) goto L285;
        r57 = null;
    L285:
        if (r57 == null) goto L287;
        this.f.setTextSize(1, r57.intValue());
        goto L287
    L281:
        r58 = false;
    L287:
        if (r53 == null) goto L299;
        ECLiveSkinTextElement r59 = r53.getText();
        if (r59 == null) goto L299;
        Integer r60 = Integer.valueOf(r59.getFontWeight());
        if (r60.intValue() <= 0) goto L293;
        boolean r138 = true;
    L294:
        if (r138 == true) goto L297;
        r60 = null;
    L297:
        if (r60 == null) goto L299;
        int r61 = r60.intValue();
        int r62 = c0.a;
        c0.b(this.f, r61);
        goto L299
    L293:
        r138 = false;
    L299:
        if (r53 == null) goto L309;
        ECLiveSkinTextElement r63 = r53.getText();
        if (r63 == null) goto L309;
        List<String> r64 = r63.getColor();
        if (r64 == null) goto L309;
        String r65 = (String) CollectionsKt.firstOrNull(r64);
        if (r65 == null) goto L309;
        Integer r66 = s.b(r65);
        if (r66 == null) goto L309;
        this.f.setTextColor(r66.intValue());
    L309:
        LivePromotionCardArgsV2 r67 = this.c;
        if (r67 == null) goto L331;
        ILivePromotionCardContainerHandler r68 = r67.b;
        if (r68 == null) goto L331;
        Boolean r69 = Boolean.valueOf(r68.h(Decision.IS_IN_SPLIT_SCREEN));
        if (r69.booleanValue() == true) goto L317;
        r69 = null;
    L317:
        if (r69 == null) goto L331;
        r69.booleanValue();
        String r139 = r11.b();
        if (r139 == null) goto L331;
        TextView r140 = this.f;
        if (r139.length() <= 2) goto L331;
        r140.setMaxLines(1);
        int r70 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        Object r71 = com.bytedance.android.shopping.extensions.b.f(Float.valueOf(r140.getTextSize()));
        if ((r71 instanceof Float) == true) goto L325;
        r71 = null;
    L325:
        Float r72 = (Float) r71;
        if (r72 == null) goto L328;
        int r73 = (int) r72.floatValue();
    L329:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(r73, 4, r140.getLayoutParams().width, r139, r140, UtilityKotlinExtentionsKt.d(4) * 2);
        goto L331
    L328:
        r73 = 12;
    L331:
        this.f.setContentDescription(this.f.getText().toString() + th.a.g(getContext(), 2131896355));
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r74 = this.d;
        if (r74 == null) goto L338;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r75 = r74.b();
        if (r75 == null) goto L338;
        r75.q();
    L338:
        if (r27.a.a() == null) goto L382;
        this.e.setVisibility(0);
        this.e.setBackgroundColor(th.a.a(getContext(), 2131106155));
        jj2.a r76 = this.b;
        if (r76 == null) goto L346;
        g1 r77 = r76.a;
        if (r77 == null) goto L346;
        l1 r78 = r77.a();
        if (r78 == null) goto L346;
        j0 r79 = r78.a();
    L347:
        if (r79 == null) goto L349;
        r12 = true;
    L349:
        if (r12 == false) goto L351;
        int r80 = 2131234524;
    L352:
        if (r12 == false) goto L367;
        LivePromotionCardArgsV2 r81 = this.c;
        if (r81 == null) goto L360;
        ILivePromotionCardContainerHandler r82 = r81.b;
        if (r82 == null) goto L360;
        Integer r83 = (Integer) r82.n(ILivePromotionCardContainerHandler.Scene.AddCartIconEnabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), getContext());
        if (r83 == null) goto L360;
        r80 = r83.intValue();
    L360:
        LivePromotionCardArgsV2 r85 = this.c;
        if (r85 == null) goto L381;
        ILivePromotionCardContainerHandler r86 = r85.b;
        if (r86 == null) goto L381;
        Drawable r87 = (Drawable) r86.n(ILivePromotionCardContainerHandler.Scene.AddCartBtnBgEnabled, Reflection.getOrCreateKotlinClass(Drawable.class), getContext());
        if (r87 == null) goto L381;
        this.e.setBackground(r87);
    L381:
        this.e.setImageResource(r80);
        return;
    L367:
        LivePromotionCardArgsV2 r88 = this.c;
        if (r88 == null) goto L374;
        ILivePromotionCardContainerHandler r89 = r88.b;
        if (r89 == null) goto L374;
        Integer r90 = (Integer) r89.n(ILivePromotionCardContainerHandler.Scene.AddCartIconDisabled, Reflection.getOrCreateKotlinClass(Integer.TYPE), getContext());
        if (r90 == null) goto L374;
        r80 = r90.intValue();
    L374:
        LivePromotionCardArgsV2 r91 = this.c;
        if (r91 == null) goto L381;
        ILivePromotionCardContainerHandler r92 = r91.b;
        if (r92 == null) goto L381;
        Drawable r93 = (Drawable) r92.n(ILivePromotionCardContainerHandler.Scene.AddCartBtnBgDisabled, Reflection.getOrCreateKotlinClass(Drawable.class), getContext());
        if (r93 == null) goto L381;
        this.e.setBackground(r93);
        goto L381
    L351:
        r80 = 2131234525;
    L346:
        r79 = null;
        goto L347
    L382:
        this.e.setVisibility(8);
        Unit r94 = Unit.INSTANCE;
        return;
    L211:
        Lazy r95 = LazyKt.lazy(new PromotionCardButtonComponent$updateButtonStyle$$inlined$run$lambda$1(this, r134, r53));
        if (r53 == null) goto L274;
        ECLiveSkinBackgroundElement r141 = r53.getBackground();
        if (r141 == null) goto L274;
        List<String> r142 = r141.getColor();
        if (r142 == null) goto L274;
        if ((!r142.isEmpty()) == true) goto L221;
        r142 = r137;
    L221:
        if (r142 == null) goto L274;
        ECLiveABUtils r143 = ECLiveABUtils.INSTANCE;
        Integer r144 = r143.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r144 != null) goto L226;
    L240:
        Integer r145 = r143.getECOM_LIVE_BUTTON_V2_STYLE();
        if (r145 != null) goto L244;
    L258:
        ArrayList r96 = new ArrayList();
        Iterator<T> r97 = r142.iterator();
    L260:
        if (r97.hasNext() == false) goto L264;
        Integer r146 = s.b((String) r97.next());
        if (r146 == null) goto L260;
        r96.add(r146);
        goto L260
    L264:
        int[] r98 = CollectionsKt.toIntArray(r96);
        if (r98.length != 4) goto L267;
        boolean r99 = true;
    L268:
        if (r99 == true) goto L271;
        r98 = null;
    L271:
        if (r98 == null) goto L273;
        this.f.setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r98, new float[]{0.0f, 0.585f, 0.77625f, 1.125f}, 281.0f, UtilityKotlinExtentionsKt.c(-14)));
        goto L275
    L273:
        this.f.setBackground((Drawable) r95.getValue());
        Unit r100 = Unit.INSTANCE;
        goto L275
    L267:
        r99 = false;
        goto L268
    L244:
        if (r145.intValue() != 2) goto L258;
        if (r134 != 0) goto L247;
        List r101 = (List) PromotionCardStyleHelper.ButtonHelper.d.getValue();
    L248:
        int[] r102 = CollectionsKt.toIntArray(r101);
        if (r102.length != 3) goto L251;
        boolean r147 = true;
    L252:
        if (r147 == true) goto L255;
        r102 = null;
    L255:
        if (r102 == null) goto L257;
        this.f.setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r102, new float[]{0.0f, 0.5f, 1.0f}, 111.0f, 0.0f));
        goto L275
    L257:
        this.f.setBackground((Drawable) r95.getValue());
        Unit r103 = Unit.INSTANCE;
        goto L275
    L251:
        r147 = false;
        goto L252
    L247:
        r101 = (List) PromotionCardStyleHelper.ButtonHelper.e.getValue();
        goto L248
    L226:
        if (r144.intValue() != 1) goto L240;
        if (r134 != 0) goto L229;
        List r104 = (List) PromotionCardStyleHelper.ButtonHelper.b.getValue();
    L230:
        int[] r105 = CollectionsKt.toIntArray(r104);
        if (r105.length != 4) goto L233;
        boolean r106 = true;
    L234:
        if (r106 == true) goto L237;
        r105 = null;
    L237:
        if (r105 == null) goto L239;
        this.f.setBackground(new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin.a(r105, new float[]{0.0f, 0.38f, 0.62f, 1.0f}, 111.0f, 0.0f));
        goto L275
    L239:
        this.f.setBackground((Drawable) r95.getValue());
        Unit r107 = Unit.INSTANCE;
        goto L275
    L233:
        r106 = false;
        goto L234
    L229:
        r104 = (List) PromotionCardStyleHelper.ButtonHelper.c.getValue();
    L274:
        this.f.setBackground((Drawable) r95.getValue());
        Unit r108 = Unit.INSTANCE;
        goto L275
    L200:
        if (r135.size() != 1) goto L202;
        r136 = true;
    L210:
        r137 = null;
        goto L211
    L193:
        r53 = r42.getDisabled();
        goto L194
    L176:
        r134 = 0;
    L110:
        r45 = null;
        goto L111
    L98:
        r40 = null;
        goto L100
    L60:
        r110 = 0;
    L56:
        r25 = null;
    L48:
        r21 = null;
        goto L49
    L40:
        r17 = false;
    L37:
        r16 = null;
        goto L38
    L336:
        this.f.setVisibility(8);
        Unit r109 = Unit.INSTANCE;
        goto L338
    L27:
        this.g.setVisibility(8);
        Unit r148 = Unit.INSTANCE;
        goto L28
    }

    /* JADX WARN: Type inference failed for: r9v13, types: [com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardButtonComponent$addCartListener$1] */
    public final void d(View r28) {
        Intrinsics.checkNotNullParameter(r28, "v");
        s0.a(new m());
        LivePromotionCardArgsV2 r2 = this.c;
        if (r2 == null) goto L7;
        ILivePromotionCardContainerHandler r3 = r2.b;
        if (r3 == null) goto L7;
        il2.a r4 = r3.b(null);
    L8:
        jj2.a r5 = this.b;
        if (r5 == null) goto L17;
        String r6 = r5.e;
        if (r6 == null) goto L17;
        LivePromotionCardArgsV2 r7 = this.c;
        if (r7 == null) goto L17;
        ILivePromotionCardContainerHandler r8 = r7.b;
        if (r8 == null) goto L17;
        r8.j(r6);
    L17:
        jj2.a r9 = this.b;
        if (r9 == null) goto L20;
        int r13 = r9.f;
    L22:
        if (Intrinsics.areEqual(r28, this.h) == false) goto L27;
        if (r4 == null) goto L25;
        il2.a.C0145a.a(r4, "click_card", MapsKt.mapOf(TuplesKt.to("click_area", "stepper_sub")), false, null, null, null, 60);
    L25:
        c(StepperActionType.STEPPER_SUB, r4);
        return;
    L27:
        if (Intrinsics.areEqual(r28, this.j) == false) goto L31;
        if (r4 == null) goto L30;
        il2.a.C0145a.a(r4, "click_card", MapsKt.mapOf(TuplesKt.to("click_area", "stepper_add")), false, null, null, null, 60);
    L30:
        c(StepperActionType.STEPPER_ADD, r4);
        return;
    L31:
        String r18 = "";
        if (Intrinsics.areEqual(r28, this.e) == false) goto L103;
        if (r4 == null) goto L36;
        il2.a.C0145a.a(r4, "click_card", MapsKt.mapOf(TuplesKt.to("click_area", "add_cart")), false, null, null, null, 60);
    L36:
        LivePromotionCardArgsV2 r10 = this.c;
        if (r10 == null) goto L41;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r11 = r10.a;
        if (r11 == null) goto L41;
        String r12 = r11.a(PromotionCardButtonComponent$doClick$btm$1.INSTANCE, r13);
    L42:
        com.bytedance.android.btm.api.model.d r14 = BtmUtilsKt.e(r12, PageFinder.via(this.e));
        if (r4 == null) goto L45;
        r4.d(r14);
    L45:
        if (r12 == null) goto L47;
        r18 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r12, Boolean.FALSE).withView(this.e).build());
    L47:
        String r15 = r18;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r16 = this.d;
        if (r16 == null) goto L52;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r17 = r16.b();
        if (r17 == null) goto L52;
        r17.c(r12, r15);
    L52:
        int r19 = ECSdk.a;
        IECUserTrackerService r20 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r20 == null) goto L57;
        of.a r21 = r20.getMarketingService();
        if (r21 == null) goto L57;
        r21.a("live_add_cart_from_cart_pendant", PostActionType.DO, "live");
    L57:
        jj2.a r22 = this.b;
        if (r22 == null) goto L64;
        g1 r23 = r22.a;
        if (r23 == null) goto L64;
        l1 r24 = r23.a();
        if (r24 == null) goto L64;
        j0 r25 = r24.a();
    L65:
        if (r25 == null) goto L67;
        boolean r26 = true;
    L68:
        xh.a r27 = xh.c.a("Live");
        Pair[] r29 = new Pair[3];
        r29[0] = TuplesKt.to("button_enabled", String.valueOf(r26));
        jj2.a r30 = this.b;
        if (r30 == null) goto L71;
        String r31 = r30.d;
    L72:
        r29[1] = TuplesKt.to("promotion_id", r31);
        jj2.a r32 = this.b;
        if (r32 == null) goto L75;
        String r33 = r32.e;
    L76:
        r29[2] = TuplesKt.to("product_id", r33);
        r27.d("good_list", "cell_add_cart", MapsKt.mapOf(r29));
        if (r26 == false) goto L96;
        jj2.a r1 = this.b;
        if (r1 == null) goto L91;
        g1 r34 = r1.a;
        if (r34 == null) goto L91;
        l1 r35 = r34.a();
        if (r35 == null) goto L91;
        j0 r36 = r35.a();
        if (r36 == null) goto L91;
        if (r4 == null) goto L88;
        il2.a.C0145a.a(r4, "check_add_cart", MapsKt.mapOf(TuplesKt.to("action", r36)), false, null, null, null, 60);
    L88:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r37 = this.d;
        if (r37 == null) goto L172;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.b(r37, "button", 3, r36, 0, new PromotionCardButtonComponent$addCartListener$1(this), r14, r4, 24);
        return;
    L172:
        return;
    L91:
        if (r4 == null) goto L174;
        il2.a r38 = il2.a.C0145a.a(r4, "check_add_cart", null, false, "action_is_null", null, null, 48);
        if (r38 == null) goto L175;
        ((LiveActionTracker) r38).e(false);
        Unit r39 = Unit.INSTANCE;
        return;
    L175:
        return;
    L174:
        return;
    L96:
        if (r26 == true) goto L180;
        if (r4 == null) goto L101;
        il2.a r40 = il2.a.C0145a.a(r4, "check_add_cart", null, false, "add_cart_disable", null, null, 48);
        if (r40 == null) goto L101;
        ((LiveActionTracker) r40).e(false);
    L101:
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
        return;
    L180:
        return;
    L75:
        r33 = null;
        goto L76
    L71:
        r31 = null;
        goto L72
    L67:
        r26 = false;
    L64:
        r25 = null;
    L41:
        r12 = null;
        goto L42
    L103:
        if (Intrinsics.areEqual(r28, this.f) == false) goto L182;
        xh.a r41 = xh.c.a("Live");
        Pair[] r42 = new Pair[3];
        r42[0] = TuplesKt.to("button_enabled", String.valueOf(!this.k));
        jj2.a r43 = this.b;
        if (r43 == null) goto L108;
        String r44 = r43.d;
        if (r44 == null) goto L108;
    L109:
        r42[1] = TuplesKt.to("promotion_id", r44);
        jj2.a r45 = this.b;
        if (r45 == null) goto L113;
        String r46 = r45.e;
        if (r46 == null) goto L113;
    L114:
        r42[2] = TuplesKt.to("product_id", r46);
        r41.d("good_list", "cell_action_button", MapsKt.mapOf(r42));
        if (r4 == null) goto L118;
        il2.a.C0145a.a(r4, "click_card", MapsKt.mapOf(TuplesKt.to("click_area", "button")), false, null, null, null, 60);
    L118:
        LivePromotionCardArgsV2 r47 = this.c;
        if (r47 == null) goto L123;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r48 = r47.a;
        if (r48 == null) goto L123;
        String r49 = r48.a(PromotionCardButtonComponent$doClick$btm$2.INSTANCE, r13);
    L125:
        if (r49 != null) goto L127;
        String r50 = "";
    L128:
        BtmItemBuilder r210 = new BtmItemBuilder(r50, Boolean.TRUE).withView(this.f);
        com.bytedance.android.btm.api.model.d r110 = BtmUtilsKt.e(r49, PageFinder.via(this.f));
        if (r4 == null) goto L131;
        r4.d(r110);
    L131:
        boolean r51 = this.k;
        if (r51 == true) goto L151;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r52 = this.d;
        if (r52 == null) goto L146;
        LivePromotionCardArgsV2 r53 = this.c;
        if (r53 == null) goto L144;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r54 = r53.a;
        if (r54 == null) goto L144;
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r55 = PromotionCardButtonComponent$reportClickInvalidProductEvent$1.INSTANCE;
        jj2.a r56 = this.b;
        if (r56 == null) goto L142;
        int r57 = r56.f;
    L143:
        String r58 = r54.a(r55, r57);
    L145:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.c(r52, "button", r58, r28, 8);
        goto L146
    L142:
        r57 = 0;
    L144:
        r58 = null;
    L146:
        if (r4 == null) goto L176;
        il2.a r59 = il2.a.C0145a.a(r4, "check_buy_btn", null, false, "buy_btn_disable", null, null, 48);
        if (r59 == null) goto L177;
        ((LiveActionTracker) r59).e(false);
        return;
    L177:
        return;
    L176:
        return;
    L151:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r60 = this.d;
        if (r60 == null) goto L154;
        r60.a("button", r51, r49, r210, this.f);
    L154:
        jj2.a r61 = this.b;
        if (r61 == null) goto L167;
        g1 r62 = r61.a;
        if (r62 == null) goto L167;
        m1 r63 = r62.b();
        if (r63 == null) goto L167;
        j0 r64 = r63.a();
        if (r64 == null) goto L167;
        if (r4 == null) goto L164;
        il2.a.C0145a.a(r4, "check_buy_btn", MapsKt.mapOf(TuplesKt.to("action", r64)), false, null, null, null, 60);
    L164:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r65 = this.d;
        if (r65 == null) goto L183;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.b(r65, "button", 1, r64, 0, null, r110, r4, 56);
        return;
    L183:
        return;
    L167:
        if (r4 == null) goto L185;
        il2.a r66 = il2.a.C0145a.a(r4, "check_buy_btn", null, false, "buy_btn_action_is_null", null, null, 48);
        if (r66 == null) goto L186;
        ((LiveActionTracker) r66).e(false);
        Unit r67 = Unit.INSTANCE;
        return;
    L186:
        return;
    L185:
        return;
    L127:
        r50 = r49;
    L123:
        r49 = null;
    L113:
        r46 = "";
    L108:
        r44 = "";
        goto L109
    L182:
        return;
    L20:
        r13 = 0;
    L7:
        r4 = null;
        goto L8
    }

    public final void e(jj2.a r19) {
        boolean r3 = false;
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        v r2 = r19.a.c();
        if (r2 == null) goto L70;
        IPromotionUIConfig.d r1 = r19.c.a(PromotionCardModuleName.StepperIcon);
        if (r1 == null) goto L8;
        int r5 = UIConfigHelper.a;
        UIConfigHelper.d(this.j, r1);
        UIConfigHelper.d(this.h, r1);
    L8:
        if (r2.b() <= 0) goto L19;
        this.h.setVisibility(0);
        this.i.setVisibility(0);
        String r9 = String.valueOf(r2.b());
        int r4 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        float r6 = this.i.getTextSize();
        Intrinsics.checkNotNullParameter(r9, "text");
        Paint r7 = new Paint();
        r7.setTextSize(r6);
        if (r7.measureText(r9) < this.i.getLayoutParams().width) goto L12;
    L15:
        boolean r8 = true;
    L16:
        if (r8 == false) goto L18;
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(this.l, 8, this.i.getLayoutParams().width, r9, this.i, 0);
    L18:
        this.i.setText(String.valueOf(r2.b()));
    L21:
        if ((!r2.c()) == false) goto L38;
        LivePromotionCardArgsV2 r10 = this.c;
        if (r10 == null) goto L37;
        ILivePromotionCardContainerHandler r11 = r10.b;
        if (r11 == null) goto L37;
        String r12 = (String) r11.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddEnabledImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r12 == null) goto L37;
        if (r12.length() <= 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L34;
        String r14 = r12;
    L35:
        if (r14 == null) goto L37;
        h0.e(this.j, r14, null, null, null, 120);
    L54:
        LivePromotionCardArgsV2 r15 = this.c;
        if (r15 == null) goto L68;
        ILivePromotionCardContainerHandler r16 = r15.b;
        if (r16 == null) goto L68;
        String r17 = (String) r16.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperSubImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r17 == null) goto L68;
        if (r17.length() <= 0) goto L63;
        r3 = true;
    L63:
        if (r3 == false) goto L65;
        String r18 = r17;
    L66:
        if (r18 == null) goto L68;
        h0.e(this.h, r18, null, null, null, 120);
        return;
    L65:
        r18 = null;
    L68:
        h0.e(this.h, UriUtil.getUriForResourceId(2131234530).toString(), null, null, null, 120);
        return;
    L34:
        r14 = null;
        goto L35
    L31:
        r13 = false;
    L37:
        h0.e(this.j, UriUtil.getUriForResourceId(2131234528).toString(), null, null, null, 120);
        goto L54
    L38:
        LivePromotionCardArgsV2 r20 = this.c;
        if (r20 == null) goto L53;
        ILivePromotionCardContainerHandler r21 = r20.b;
        if (r21 == null) goto L53;
        String r22 = (String) r21.n(ILivePromotionCardContainerHandler.Scene.InstantRetailShopStepperAddDisabledImageUrl, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r22 == null) goto L53;
        if (r22.length() <= 0) goto L47;
        boolean r23 = true;
    L48:
        if (r23 == false) goto L50;
        String r24 = r22;
    L51:
        if (r24 == null) goto L53;
        h0.e(this.j, r24, null, null, null, 120);
        goto L54
    L50:
        r24 = null;
        goto L51
    L47:
        r23 = false;
    L53:
        h0.e(this.j, UriUtil.getUriForResourceId(2131234529).toString(), null, null, null, 120);
        goto L54
    L12:
        if (((int) this.i.getTextSize()) != com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.c(this.l)) goto L15;
        r8 = false;
        goto L16
    L19:
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        goto L21
    }

    public final void setAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.d = r2;
    }

    public final void setArgument(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.c = r2;
    }

    public final void a(String r7, int r8) {
        if (r7.length() <= r8) goto L5;
        this.f.setMaxLines(1);
        int r9 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.b(12, 4, this.f.getLayoutParams().width, r7, this.f, UtilityKotlinExtentionsKt.d(6) * 2);
    L6:
        this.f.setText(r7);
        return;
    L5:
        this.f.setTextSize(12);
        goto L6
    }

    public final void c(StepperActionType r17, il2.a r18) {
        jj2.a r2 = this.b;
        if (r2 == null) goto L5;
        int r3 = r2.f;
    L6:
        LivePromotionCardArgsV2 r4 = this.c;
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r5 = r4.a;
        if (r5 == null) goto L11;
        String r6 = r5.a(PromotionCardButtonComponent$clickStepper$btm$1.INSTANCE, r3);
    L12:
        if (r18 == null) goto L14;
        r18.d(BtmUtilsKt.e(r6, PageFinder.via(this.g)));
    L14:
        jj2.a r7 = this.b;
        if (r7 == null) goto L19;
        g1 r8 = r7.a;
        if (r8 == null) goto L19;
        v r11 = r8.c();
    L21:
        if (r11 != null) goto L28;
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
        if (r18 == null) goto L111;
        il2.a r1 = il2.a.C0145a.a(r18, "check_stepper", null, false, "stepper_info_is_null", null, null, 48);
        if (r1 == null) goto L112;
        ((LiveActionTracker) r1).e(false);
        return;
    L112:
        return;
    L111:
        return;
    L28:
        int r9 = r11.b();
        if (r9 <= 0) goto L31;
    L37:
        if (r6 == null) goto L39;
        String r10 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r6, Boolean.FALSE).withView(this.g).build());
    L40:
        StepperActionType r13 = StepperActionType.STEPPER_ADD;
        if (r17 != r13) goto L47;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r12 = this.d;
        if (r12 == null) goto L52;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r14 = r12.b();
        if (r14 == null) goto L52;
        r14.c(r6, r10);
    L52:
        if (r17 != r13) goto L54;
        String r15 = "live_add_cart_from_cart_pendant";
    L55:
        int r16 = ECSdk.a;
        IECUserTrackerService r19 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r19 == null) goto L60;
        of.a r20 = r19.getMarketingService();
        if (r20 == null) goto L60;
        r20.a(r15, PostActionType.DO, "live");
    L60:
        jj2.a r21 = this.b;
        if (r21 == null) goto L67;
        g1 r22 = r21.a;
        if (r22 == null) goto L67;
        v r23 = r22.c();
        if (r23 == null) goto L67;
        j0 r24 = r23.a();
    L69:
        if (r24 == null) goto L71;
        boolean r25 = true;
    L72:
        if (r17 != r13) goto L74;
        String r26 = "cell_add_cart";
    L75:
        xh.a r27 = xh.c.a("Live");
        Pair[] r110 = new Pair[3];
        r110[0] = TuplesKt.to("button_enabled", String.valueOf(r25));
        jj2.a r28 = this.b;
        if (r28 == null) goto L78;
        String r29 = r28.d;
    L79:
        r110[1] = TuplesKt.to("promotion_id", r29);
        jj2.a r30 = this.b;
        if (r30 == null) goto L82;
        String r31 = r30.e;
    L83:
        r110[2] = TuplesKt.to("product_id", r31);
        r27.d("good_list", r26, MapsKt.mapOf(r110));
        if (r25 == false) goto L104;
        if (r6 == null) goto L87;
        new BtmItemBuilder(r6, Boolean.TRUE).withView(this.g);
    L87:
        com.bytedance.android.btm.api.model.d r111 = BtmUtilsKt.e(r6, PageFinder.via(this.g));
        if (r17 != r13) goto L90;
        int r32 = r9 + 1;
    L91:
        int r112 = r32;
        if (r18 == null) goto L94;
        il2.a.C0145a.a(r18, "check_stepper", MapsKt.mapOf(new Pair[]{TuplesKt.to("target_combo_num", String.valueOf(r112)), TuplesKt.to("action_type", r17.toString())}), false, null, null, null, 60);
    L94:
        j0 r33 = r11.a();
        if (r33 == null) goto L115;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r34 = this.d;
        if (r34 != null) goto L99;
        return;
    L99:
        if (r17 != r13) goto L101;
        int r35 = 4;
    L102:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.b(r34, "button", Integer.valueOf(r35), r33, r112, null, r111, r18, 48);
        return;
    L101:
        r35 = 5;
        goto L102
    L115:
        return;
    L90:
        r32 = r9 - 1;
        goto L91
    L104:
        if (r25 == true) goto L117;
        if (r18 == null) goto L109;
        il2.a r36 = il2.a.C0145a.a(r18, "check_stepper", null, false, "stepper_disable", null, null, 48);
        if (r36 == null) goto L109;
        ((LiveActionTracker) r36).e(false);
    L109:
        UIUtils.displayToast(getContext(), th.a.g(getContext(), 2131896304));
        return;
    L117:
        return;
    L82:
        r31 = null;
        goto L83
    L78:
        r29 = null;
        goto L79
    L74:
        r26 = "cell_sub_cart";
        goto L75
    L71:
        r25 = false;
    L67:
        r24 = null;
        goto L69
    L54:
        r15 = "live_sub_cart_from_cart_pendant";
        goto L55
    L47:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r37 = this.d;
        if (r37 == null) goto L52;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r38 = r37.b();
        if (r38 == null) goto L52;
        r38.s(r6, r10);
        goto L52
    L39:
        r10 = "";
        goto L40
    L31:
        if (r17 != StepperActionType.STEPPER_SUB) goto L37;
        if (r18 == null) goto L113;
        il2.a r39 = il2.a.C0145a.a(r18, "check_stepper", null, false, "stepper_sub_data_error", null, null, 48);
        if (r39 == null) goto L114;
        ((LiveActionTracker) r39).e(false);
        return;
    L114:
        return;
    L113:
        return;
    L19:
        r11 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }

    public PromotionCardButtonComponent(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        int r10 = 14;
        this.l = 14;
        th.a.c(r7, 2131564748, this, true);
        setRadius(th.a.f(r7).getDimension(2131168167));
        ImageView r11 = (ImageView) findViewById(2131374918);
        this.e = r11;
        TextView r12 = (TextView) findViewById(2131390705);
        this.f = r12;
        this.g = findViewById(2131365250);
        ECDraweeView r1 = findViewById(2131376639);
        this.h = r1;
        TextView r2 = (TextView) findViewById(2131390286);
        this.i = r2;
        ECDraweeView r3 = findViewById(2131376638);
        this.j = r3;
        Object r4 = com.bytedance.android.shopping.extensions.b.f(Float.valueOf(r2.getTextSize()));
        if ((r4 instanceof Float) == true) goto L5;
        r4 = null;
    L5:
        Float r5 = (Float) r4;
        if (r5 == null) goto L8;
        r10 = (int) r5.floatValue();
    L8:
        this.l = r10;
        c0.b(r12, MonitorLevel.FATAL);
        com.bytedance.android.ec.core.widget.f.c(r11, null, null, new AnonymousClass1(this), 3);
        com.bytedance.android.ec.core.widget.f.c(r12, null, "bind_key_live_promotion_list", new AnonymousClass2(this), 1);
        com.bytedance.android.ec.core.widget.f.c(r1, null, null, new AnonymousClass3(this), 3);
        com.bytedance.android.ec.core.widget.f.c(r3, null, null, new AnonymousClass4(this), 3);
        r11.setOnLongClickListener(a.a);
        r12.setOnLongClickListener(b.a);
    }

    public /* synthetic */ PromotionCardButtonComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
