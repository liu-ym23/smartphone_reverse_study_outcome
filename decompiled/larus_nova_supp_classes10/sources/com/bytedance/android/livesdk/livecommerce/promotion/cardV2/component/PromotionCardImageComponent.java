package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.R;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.w;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.AuctionHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.ECLiveExplainWaveView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.BottomBannerType;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionAtmosphereData;
import com.bytedance.android.ec.model.response.ECAuctionCountdownAtmosphere;
import com.bytedance.android.ec.model.response.ECAuctionDigitalAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.ECPromotionFloatIcon;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.HotAtmosphereHelperV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECPromotionImageView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.d1;
import com.bytedance.android.livesdk.livecommerce.view.roundcorner.ECPromotionTopTagLinearlayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardImageComponent;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardImageComponent extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public AnimatorSet A;
    public String B;
    public LivePromotionCardArgsV2 a;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a b;
    public jj2.c c;
    public final ECPromotionImageView d;
    public final ECPromotionTopTagLinearlayout e;
    public final ECDraweeView f;
    public final TextView g;
    public final TextView h;
    public final ECDraweeView i;
    public final ECDraweeView j;
    public final CardView k;
    public final ECHotAtmosphereView l;
    public AuctionHotAtmosphereView m;
    public final ViewStub n;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a o;
    public HotAtmosphereHelperV2 p;
    public k q;
    public final Function1<y0, Unit> r;
    public d1 s;
    public boolean t;
    public boolean u;
    public final int v;
    public final ConstraintLayout w;
    public final ECDraweeView x;
    public final ECDraweeView y;
    public final TextView z;

    public static final class a {
    }

    static {
    }

    public PromotionCardImageComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardImageComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c() {
        AnimatorSet r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        this.A = null;
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        r0.cancel();
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        jj2.c r0 = this.c;
        if (r0 != null) goto L5;
    L6:
        c();
        return;
    L5:
        if (r0.n != true) goto L6;
    }

    public final void b(jj2.c r20) {
        Intrinsics.checkNotNullParameter(r20, "model");
        jj2.c r2 = this.c;
        if (r2 == null) goto L5;
        z0 r3 = r2.c;
    L7:
        if ((!Intrinsics.areEqual(r3, r20.c)) == false) goto L11;
        k r4 = this.q;
        if (r4 == null) goto L11;
        Lazy r5 = UIUtils.a;
        UIUtils.c().removeCallbacks(r4);
    L11:
        this.c = r20;
        this.d.setPromotionImageBindConfig(new w(new j(this), null));
        this.d.setForceRadius(8);
        this.d.setCallerContext(new r("ec_live", "goods_info_view"));
        jj2.c r6 = this.c;
        if (r6 == null) goto L20;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r7 = r6.e;
        if (r7 == null) goto L20;
        IPromotionUIConfig.d r8 = r7.a(PromotionCardModuleName.ImageAreaIndex);
        if (r8 == null) goto L20;
        IPromotionUIConfig.b r9 = r8.a();
        if (r9 == null) goto L20;
        IPromotionUIConfig.b r10 = IPromotionUIConfig.b.a(r9);
        int r11 = UIConfigHelper.a;
        UIConfigHelper.c(this.e, r10);
    L20:
        ECPromotionImageView r12 = this.d;
        LivePromotionCardArgsV2 r13 = this.a;
        if (r13 == null) goto L34;
        ILivePromotionCardContainerHandler r14 = r13.b;
        if (r14 == null) goto L34;
        String r15 = (String) r14.n(ILivePromotionCardContainerHandler.Scene.ExplainBarWaveIcon, Reflection.getOrCreateKotlinClass(String.class), null);
        if (r15 == null) goto L34;
        if (r15.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == true) goto L33;
        r15 = null;
    L33:
        if (r15 == null) goto L34;
    L35:
        r12.setAnimation(r15);
        jj2.c r17 = this.c;
        if (r17 != null) goto L38;
    L61:
        boolean r18 = r20.h;
        ECPromotionImageView r19 = this.d;
        r19.k.setVisibility(8);
        TextView r21 = r19.j;
        r21.setText(th.a.g(r21.getContext(), 2131896484));
        this.k.setVisibility(8);
        String r110 = "";
        if (r18 != true) goto L120;
        LivePromotionCardArgsV2 r22 = this.a;
        if (r22 == null) goto L68;
        ILivePromotionCardContainerHandler r23 = r22.b;
        if (r23 == null) goto L68;
        boolean r24 = r23.h(Decision.HIDE_EXPLAINING_ANIM);
    L69:
        ECPromotionImageView r111 = this.d;
        r111.getClass();
        Lazy r112 = ECAppInfoService.a;
        if (ECAppInfoService.h() == false) goto L75;
        r111.h.setVisibility(0);
        if (r24 == false) goto L74;
        r111.g.setVisibility(8);
        r111.g.clearAnimation();
    L76:
        TextView r25 = r111.j;
        r25.setText(th.a.g(r25.getContext(), 2131896484));
        this.d.getExplaingingLayout().setClickable(false);
        jj2.c r26 = this.c;
        if (r26 == null) goto L191;
        z0 r27 = r26.c;
        if (r27 == null) goto L191;
        final a1 r28 = r27.c();
        if (r28 == null) goto L191;
        Long r113 = r28.d();
        if (r113 == null) goto L191;
        if (r113.longValue() <= 50) goto L191;
        this.d.setBottomBannerInfo(r28);
        BottomBannerType r29 = r28.b();
        if (r29 != null) goto L90;
    L91:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r30 = PromotionCardImageComponent$update3DModelStatus$btmInfo$2.INSTANCE;
    L93:
        LivePromotionCardArgsV2 r31 = this.a;
        if (r31 == null) goto L102;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r32 = r31.a;
        if (r32 == null) goto L102;
        jj2.c r114 = this.c;
        if (r114 == null) goto L100;
        int r115 = r114.i;
    L101:
        final String r33 = r32.a(r30, r115);
    L103:
        com.bytedance.android.ec.core.widget.f.c(this.d.getExplaingingLayout(), null, "bind_key_live_promotion_list", new PromotionCardImageComponent$update3DModelStatus$1(this, r33, r28), 1);
        StringBuilder r34 = new StringBuilder("livesdk_");
        s1 r35 = r28.g();
        if (r35 == null) goto L106;
        String r36 = r35.c();
    L107:
        if (r36 != null) goto L109;
        r36 = "";
    L109:
        r34.append(r36);
        r34.append("_show");
        String r37 = r34.toString();
        LivePromotionCardArgsV2 r38 = this.a;
        if (r38 == null) goto L191;
        il.a r39 = r38.e;
        if (r39 == null) goto L191;
        jj2.c r40 = this.c;
        if (r40 == null) goto L119;
        String r41 = r40.f;
        if (r41 == null) goto L119;
        r110 = r41;
    L119:
        r39.c(r37, r110, new PromotionCardImageComponent$update3DModelStatus$2(this, r33));
        goto L191
    L106:
        r36 = null;
        goto L107
    L100:
        r115 = 0;
    L102:
        r33 = null;
        goto L103
    L90:
        if (c.b[r29.ordinal()] != 1) goto L91;
        r30 = PromotionCardImageComponent$update3DModelStatus$btmInfo$1.INSTANCE;
    L191:
        jj2.c r42 = this.c;
        if (r42 == null) goto L196;
        z0 r43 = r42.c;
        if (r43 == null) goto L196;
        List r44 = r43.g();
    L197:
        UtilityKotlinExtentionsKt.f(r42, r44, new PromotionCardImageComponent$updateLeftTag$1(this));
        f(r20, false);
        List r45 = r20.c.e();
        final ECDraweeView r46 = this.d.getFloatIconView();
        if (r45 == null) goto L241;
        final ECPromotionFloatIcon r47 = (ECPromotionFloatIcon) CollectionsKt.firstOrNull(r45);
        if (r47 == null) goto L241;
        if (r47.getIcon() == null) goto L204;
        boolean r48 = true;
    L205:
        if (r48 == true) goto L208;
        r47 = null;
    L208:
        if (r47 == null) goto L241;
        ViewGroup.LayoutParams r49 = r46.getLayoutParams();
        if ((r49 instanceof LinearLayout.LayoutParams) == true) goto L212;
        r49 = null;
    L212:
        LinearLayout.LayoutParams r50 = (LinearLayout.LayoutParams) r49;
        if (r50 == null) goto L240;
        Long r51 = r47.getPos();
        if (r51 != null) goto L218;
    L220:
        Long r52 = r47.getPos();
        if (r52 != null) goto L224;
    L226:
        ECUrlModel r53 = r47.getIcon();
        if (r53 == null) goto L229;
        int r54 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r53.getWidth()));
    L230:
        r50.width = r54;
        ECUrlModel r55 = r47.getIcon();
        if (r55 == null) goto L233;
        int r56 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r55.getHeight()));
    L234:
        r50.height = r56;
        r46.setLayoutParams(r50);
        r46.setVisibility(0);
        h0.d(r46, r47.getIcon(), new r("ec_live", "ec_promotion_card_float_icon"), null, null, null, null, 120);
        String r57 = r47.getJumpUrl();
        if (r57 == null) goto L239;
        final String r58 = a2.d(r57);
        if (r58 == null) goto L239;
        com.bytedance.android.ec.core.widget.f.c(r46, null, null, new PromotionCardImageComponent$updateFloatIcon$$inlined$also$lambda$1(r58, r47, this, r46), 3);
    L242:
        jj2.c r59 = this.c;
        if (r59 == null) goto L252;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r60 = r59.e;
        if (r60 == null) goto L252;
        IPromotionUIConfig.d r61 = r60.a(PromotionCardModuleName.HotAtmosphere);
        if (r61 == null) goto L252;
        int r62 = UIConfigHelper.a;
        UIConfigHelper.d(this.l, r61);
        AuctionHotAtmosphereView r63 = this.m;
        if (r63 == null) goto L252;
        UIConfigHelper.d(r63, r61);
    L252:
        if (r20.d != UpdateType.UPDATE_EXPOSE) goto L255;
        this.u = true;
        return;
    L255:
        return;
    L239:
        r46.setOnClickListener(null);
        Unit r64 = Unit.INSTANCE;
        goto L242
    L233:
        r56 = 0;
        goto L234
    L229:
        r54 = 0;
        goto L230
    L224:
        if (r52.longValue() != 2) goto L226;
        r50.gravity = 8388613;
        goto L226
    L218:
        if (r51.longValue() != 1) goto L220;
        r50.gravity = 8388611;
        goto L226
    L240:
        r46.setVisibility(8);
        Unit r65 = Unit.INSTANCE;
        goto L242
    L204:
        r48 = false;
    L241:
        r46.setVisibility(8);
        Unit r66 = Unit.INSTANCE;
    L196:
        r44 = null;
        goto L197
    L74:
        r111.g.setVisibility(0);
        r111.g.setAnimation(r111.n);
        r111.g.playAnimation();
        r111.g.loop(true);
        goto L76
    L75:
        r111.e.setVisibility(0);
        ECLiveExplainWaveView r67 = r111.f.a;
        r67.k = true;
        r67.invalidate();
    L68:
        r24 = false;
        goto L69
    L120:
        if (r18 == true) goto L191;
        jj2.c r68 = this.c;
        if (r68 == null) goto L191;
        z0 r69 = r68.c;
        if (r69 == null) goto L191;
        final a1 r70 = r69.c();
        if (r70 == null) goto L191;
        Long r71 = r70.d();
        if (r71 == null) goto L191;
        if (r71.longValue() >= 50) goto L191;
        jj2.c r116 = this.c;
        if (r116 == null) goto L140;
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r117 = r116.e;
        if (r117 == null) goto L140;
        IPromotionUIConfig.d r118 = r117.a(PromotionCardModuleName.ImageAreaBottomTip);
        if (r118 == null) goto L140;
        Boolean r119 = r118.d();
        if (r119 == null) goto L140;
        boolean r120 = r119.booleanValue();
    L141:
        if (r120 == false) goto L190;
        BottomBannerType r121 = r70.b();
        if (r121 != null) goto L146;
    L147:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r122 = PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$btmInfo$2.INSTANCE;
    L148:
        KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r123 = r122;
        LivePromotionCardArgsV2 r124 = this.a;
        if (r124 == null) goto L159;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r125 = r124.a;
        if (r125 == null) goto L159;
        jj2.c r126 = this.c;
        if (r126 == null) goto L157;
        Integer r127 = Integer.valueOf(r126.i);
    L158:
        final String r72 = r125.a(r123, com.bytedance.android.shopping.extensions.k.g(r127, 0));
    L160:
        StringBuilder r128 = new StringBuilder("livesdk_");
        s1 r129 = r70.g();
        if (r129 == null) goto L163;
        String r130 = r129.c();
    L164:
        if (r130 != null) goto L166;
        r130 = "";
    L166:
        r128.append(r130);
        r128.append("_show");
        String r73 = r128.toString();
        LivePromotionCardArgsV2 r131 = this.a;
        if (r131 == null) goto L176;
        il.a r132 = r131.e;
        if (r132 == null) goto L176;
        jj2.c r133 = this.c;
        if (r133 == null) goto L174;
        String r134 = r133.f;
        if (r134 == null) goto L174;
    L175:
        r132.c(r73, r134, new PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$1(this, r72));
    L174:
        r134 = "";
    L176:
        String r74 = a2.d(r70.f());
        if (r74 != null) goto L179;
        r74 = th.a.g(getContext(), 2131896704);
    L179:
        this.h.setText(r74);
        this.k.setAlpha(1.0f);
        a(this.i, r70.c(), "ec_promotion_card_bottom_banner_left");
        a(this.j, r70.e(), "ec_promotion_card_bottom_banner_right");
        Integer r135 = ECLiveABUtils.INSTANCE.getEC_LIVE_LIST_REPLAY_BUTTON_ENHANCE();
        if (r135 != null) goto L183;
    L188:
        this.k.setBackgroundResource(2131234247);
        this.k.setCardElevation(0.0f);
    L189:
        this.k.setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(this.k, null, "bind_key_live_promotion_list", new PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$3(this, r72, r70), 1);
        this.k.setFocusable(true);
        this.k.setContentDescription(r74 + th.a.g(getContext(), 2131896355));
        goto L191
    L183:
        if (r135.intValue() != 1) goto L188;
        ViewGroup.LayoutParams r136 = this.k.getLayoutParams();
        if (r136 == null) goto L187;
        r136.height = UtilityKotlinExtentionsKt.d(22);
        this.k.setLayoutParams(r136);
    L187:
        this.k.setRadius(q.a(11));
        this.k.setCardElevation(q.a(2));
        this.k.setCardBackgroundColor(th.a.a(getContext(), 2131101572));
        this.h.setTextSize(1, 11.0f);
        goto L189
    L163:
        r130 = null;
        goto L164
    L157:
        r127 = null;
    L159:
        r72 = null;
        goto L160
    L146:
        if (c.a[r121.ordinal()] != 1) goto L147;
        r122 = PromotionCardImageComponent$updateExplainPlaybackOrRequestExplainInfo$btmInfo$1.INSTANCE;
        goto L148
    L190:
        this.k.setVisibility(8);
    L140:
        r120 = true;
        goto L141
    L38:
        if (this.t == false) goto L51;
        this.d.a();
        d1 r75 = this.s;
        if (r75 == null) goto L50;
        r75.a = 1;
        if (r75.b == true) goto L47;
        Runnable r76 = r75.c;
        if (r76 == null) goto L46;
        r76.run();
    L46:
        boolean r77 = true;
    L48:
        if (r77 == false) goto L50;
        r75.b = true;
        goto L50
    L47:
        r77 = false;
    L50:
        this.t = false;
    L52:
        String r78 = r17.c.h();
        if (r78 == null) goto L55;
        ECPromotionImageView r79 = this.d;
        r79.d.setText(r78);
        r79.d.setVisibility(0);
    L55:
        ECPromotionImageView r80 = this.d;
        String r81 = r17.c.b();
        r80.getClass();
        if (TextUtils.isEmpty(r81) == true) goto L58;
        r80.c.setVisibility(0);
        ECLiveImageUtils.i(r80.c, r81, r80.getImageRadius(), R.color.transparent);
        goto L61
    L58:
        ECNetImageView r82 = r80.c;
        if (r82 == null) goto L61;
        r82.setVisibility(8);
        goto L61
    L51:
        ECPromotionImageView r83 = this.d;
        y.e(r83.b, r17.c.d(), -1, -1, r83.m);
        r83.a();
        goto L52
    L29:
        r16 = false;
    L34:
        r15 = "live_music_wave_icon_normal.json";
        goto L35
    L5:
        r3 = null;
        goto L7
    }

    public final void d(z0 r10) {
        Intrinsics.checkNotNullParameter(r10, "promotionImage");
        boolean r0 = true;
        this.t = true;
        this.s = new d1();
        String r2 = r10.d();
        r r3 = new r("ec_live", "goods_info_view");
        Function1<Bitmap, Unit> r7 = new PromotionCardImageComponent$fetchCoverImage$1(this);
        h0 r11 = h0.a;
        if (r2 != null) goto L5;
    L8:
        if (r0 == true) goto L12;
        ImageExtensionsKt.f(r2, r3, null, null, null, r7, 96);
        return;
    L12:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void setAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.b = r2;
    }

    public final void setArgument(final LivePromotionCardArgsV2 r3) {
        Intrinsics.checkNotNullParameter(r3, "argument");
        this.a = r3;
        this.l.setDegradeModeCallback(new PromotionCardImageComponent$updateHotAtmosphereDegradeStatus$1(r3));
    }

    public static void e(View r1, int r2) {
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
        r1.setLayoutParams(r0);
        return;
    }

    public final void f(jj2.c r6, boolean r7) {
        ECHotAtmosphere r0 = r6.c.f();
        ECAuctionAtmosphere r1 = r6.c.a();
        int r2 = 0;
        if (r0 == null) goto L14;
        String r3 = r0.num;
        if (r3 == null) goto L11;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        if (r5 > 0) goto L14;
    L9:
        r5 = 0;
    L11:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r8 = this.b;
        if (r8 == null) goto L14;
        r8.e(Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR);
    L14:
        if (r1 == null) goto L48;
        ECAuctionDigitalAtmosphere r9 = r1.getDigital();
        View r10 = null;
        if (r9 == null) goto L21;
        ECAuctionAtmosphereData r11 = r9.getData();
        if (r11 == null) goto L21;
        String r12 = r11.getNum();
        if (r12 == null) goto L21;
    L27:
        if (r12 == null) goto L32;
        Integer r13 = StringsKt.toIntOrNull(r12);
        if (r13 == null) goto L31;
        r2 = r13.intValue();
    L31:
        if (r2 <= 0) goto L32;
    L36:
        if (this.m != null) goto L48;
        ViewStub r14 = this.n;
        if (r14 == null) goto L40;
        View r15 = r14.inflate();
    L42:
        if ((r15 instanceof AuctionHotAtmosphereView) == false) goto L45;
        r10 = r15;
    L45:
        final AuctionHotAtmosphereView r16 = (AuctionHotAtmosphereView) r10;
        if (r16 == null) goto L48;
        this.m = r16;
        this.p = new HotAtmosphereHelperV2(r16, this.e, new PromotionCardImageComponent$inflateAuctionAtmosphereView$$inlined$also$lambda$1(r16, this));
        goto L48
    L40:
        r15 = null;
    L32:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r17 = this.b;
        if (r17 == null) goto L36;
        r17.e(Action.SHOP_LIST_HOT_ATMOSPHERE_DATA_ERR);
    L21:
        ECAuctionCountdownAtmosphere r18 = r1.getCountDown();
        if (r18 == null) goto L26;
        ECAuctionAtmosphereData r19 = r18.getData();
        if (r19 == null) goto L26;
        r12 = r19.getNum();
    L26:
        r12 = null;
    L48:
        if (r1 == null) goto L55;
        HotAtmosphereHelperV2 r20 = this.p;
        if (r20 == null) goto L52;
        r20.a(r6, r7);
    L52:
        HotAtmosphereHelperV2 r21 = this.p;
        if (r21 == null) goto L62;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.b(r21);
        return;
    L62:
        return;
    L55:
        HotAtmosphereHelperV2 r22 = this.p;
        if (r22 == null) goto L58;
        r22.c(r6);
    L58:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a r23 = this.o;
        if (r23 == null) goto L64;
        r23.a(r6, r7);
        return;
    }

    public PromotionCardImageComponent(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.r = new PromotionCardImageComponent$clearFlickerIcon$1(this);
        this.v = UtilityKotlinExtentionsKt.d(20);
        th.a.c(r4, 2131564751, this, true);
        this.d = (ECPromotionImageView) findViewById(2131382338);
        ECPromotionTopTagLinearlayout r7 = (ECPromotionTopTagLinearlayout) findViewById(2131389180);
        this.e = r7;
        this.f = findViewById(2131376637);
        this.g = (TextView) findViewById(2131391196);
        this.k = findViewById(2131390593);
        this.i = findViewById(2131390594);
        this.j = findViewById(2131390595);
        this.h = (TextView) findViewById(2131390592);
        ECHotAtmosphereView r8 = findViewById(2131377516);
        this.l = r8;
        this.n = (ViewStub) findViewById(2131377518);
        this.w = findViewById(2131387297);
        this.x = findViewById(2131387299);
        this.y = findViewById(2131387296);
        this.z = (TextView) findViewById(2131387300);
        int r0 = UtilityKotlinExtentionsKt.d(8);
        int r9 = UtilityKotlinExtentionsKt.d(8);
        r7.a.d(r0, 0, 0, r9);
        this.o = new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.a(r8, r7, new AnonymousClass1(this));
    }

    public static void a(ECDraweeView r10, ECUrlModel r11, String r12) {
        if (r11 == null) goto L20;
        boolean r0 = false;
        r10.setVisibility(0);
        ViewGroup.LayoutParams r1 = r10.getLayoutParams();
        if (r1 == null) goto L19;
        Integer r2 = Integer.valueOf(r11.getWidth());
        if (r2.intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        Integer r5 = null;
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        r1.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r2, 12)));
        Integer r4 = Integer.valueOf(r11.getHeight());
        if (r4.intValue() <= 0) goto L16;
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        r5 = r4;
    L18:
        r1.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(com.bytedance.android.shopping.extensions.k.g(r5, 12)));
        r10.setLayoutParams(r1);
        goto L19
    L8:
        r3 = false;
    L19:
        h0.d(r10, r11, new r("ec_live", r12), null, null, null, null, 120);
        return;
    L20:
        r10.setVisibility(8);
        Unit r13 = Unit.INSTANCE;
    }

    public /* synthetic */ PromotionCardImageComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
