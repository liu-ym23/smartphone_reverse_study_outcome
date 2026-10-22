package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.e0;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.sensor.SensorBatchGpsCollector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljj2/c;", "model", "", "Lcom/bytedance/android/ec/model/response/y0;", "iconList", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$d;", "invoke", "(Ljj2/c;Ljava/util/List;)Lcom/bytedance/android/livesdk/livecommerce/promotion/card/IPromotionUIConfig$d;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PromotionCardImageComponent$updateLeftTag$1 extends Lambda implements Function2<jj2.c, List<? extends y0>, IPromotionUIConfig.d> {
    final /* synthetic */ PromotionCardImageComponent this$0;

    public PromotionCardImageComponent$updateLeftTag$1(PromotionCardImageComponent r1) {
        this.this$0 = r1;
        super(2);
    }

    public final IPromotionUIConfig.d invoke(final jj2.c r29, List<y0> r30) {
        Intrinsics.checkNotNullParameter(r29, "model");
        Intrinsics.checkNotNullParameter(r30, "iconList");
        List<y0> r2 = r30;
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((y0) r4).b() == null) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L4;
    L12:
        y0 r5 = (y0) r4;
        String r9 = "DouyinNumberABC";
        if (r5 == null) goto L75;
        PromotionCardImageComponent r11 = this.this$0;
        e0 r12 = r5.b();
        Intrinsics.checkNotNull(r12);
        int r13 = PromotionCardImageComponent.C;
        r11.getClass();
        String r14 = r12.d();
        if (r14 == null) goto L19;
        r11.g.setVisibility(0);
        r11.g.setText(r14);
        Typeface r15 = ECFontHelper.e.b("DouyinNumberABC", MonitorLevel.FATAL, false);
        if (r15 == null) goto L20;
        r11.g.setTypeface(r15);
    L20:
        ECUrlModel r16 = r12.a();
        if (r16 == null) goto L76;
        String r17 = r16.getFirstUrl();
        if (r17 == null) goto L76;
        r11.f.setVisibility(8);
        r11.w.setVisibility(0);
        ECUrlModel r18 = r12.c();
        if (r18 == null) goto L32;
        ViewGroup.LayoutParams r19 = r11.x.getLayoutParams();
        r19.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r18.getWidth()));
        r19.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r18.getHeight()));
        ECDraweeView r6 = r11.x;
        String r110 = r18.getFirstUrl();
        if (r110 != null) goto L30;
        r110 = "";
    L30:
        String r111 = r110;
        int r112 = r.h;
        h0.e(r6, r111, r.a.b("ec_live_promotion_list_flicker_image"), null, null, 120);
    L32:
        if (r11.y.getController() != null) goto L34;
    L35:
        r11.B = r17;
        r11.y.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r17)).setAutoPlayAnimations(false).setControllerListener(new h(r11)).setOldController(r11.y.getController()).build());
    L37:
        if (r11.A != null) goto L40;
        PromotionCardImageComponent.e(r11.z, 0);
    L40:
        if (r29.o == false) goto L48;
        LivePromotionCardArgsV2 r7 = r11.a;
        if (r7 == null) goto L48;
        ILivePromotionCardContainerHandler r10 = r7.b;
        if (r10 == null) goto L48;
        if (r10.i(null, 3, false) != true) goto L48;
        boolean r20 = true;
    L49:
        if (r20 == false) goto L52;
        PromotionCardImageComponent.e(r11.g, 0);
    L54:
        UpdateType r21 = r29.d;
        if (r21 == UpdateType.UPDATE_EXPOSE) goto L63;
        if (r29.h == true) goto L59;
    L71:
        boolean r22 = false;
    L72:
        if (r22 == false) goto L76;
        r11.z.setText(r12.b());
        r11.z.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r23 = r11.z.getMeasuredWidth();
        r11.c();
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r11.w, View.ALPHA, new float[]{1.0f, 1.0f});
        r24.setDuration(400);
        ValueAnimator r25 = ValueAnimator.ofInt(new int[]{0, r23});
        r25.setDuration(300);
        r25.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        r25.addUpdateListener(new d(r11));
        r25.addListener(new e(r11));
        ObjectAnimator r26 = ObjectAnimator.ofFloat(r11.w, View.ALPHA, new float[]{1.0f, 1.0f});
        r26.setDuration(SensorBatchGpsCollector.DEFAULT_NETWORK_FALLBACK_TIMEOUT_MS);
        ValueAnimator r27 = ValueAnimator.ofInt(new int[]{r23, 0});
        r27.setDuration(300);
        r27.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        r27.addUpdateListener(new f(r11));
        PromotionCardImageComponent.e(r11.g, 0);
        ValueAnimator r28 = ValueAnimator.ofInt(new int[]{0, r11.v});
        r28.setDuration(300);
        r28.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        r28.addUpdateListener(new g(r11));
        AnimatorSet r31 = new AnimatorSet();
        r31.playSequentially(new Animator[]{r24, r25, r26});
        AnimatorSet r32 = new AnimatorSet();
        r32.playTogether(new Animator[]{r27, r28});
        AnimatorSet r33 = new AnimatorSet();
        r33.playSequentially(new Animator[]{r31, r32});
        r11.A = r33;
        r33.start();
        r33.addListener(new i(r11));
        goto L76
    L59:
        if (r11.u == false) goto L71;
        if (r21 != UpdateType.UPDATE_ALL) goto L71;
    L63:
        if (r29.o == false) goto L71;
        LivePromotionCardArgsV2 r34 = r11.a;
        if (r34 == null) goto L71;
        ILivePromotionCardContainerHandler r35 = r34.b;
        if (r35 == null) goto L71;
        if (r35.i(null, 3, true) != true) goto L71;
        r22 = true;
        goto L72
    L52:
        if (r11.A != null) goto L54;
        PromotionCardImageComponent.e(r11.g, r11.v);
    L48:
        r20 = false;
        goto L49
    L34:
        if ((!Intrinsics.areEqual(r11.B, r17)) == false) goto L37;
    L76:
        if (r5 == null) goto L78;
        final boolean r113 = true;
    L79:
        Iterator<T> r36 = r2.iterator();
    L81:
        if (r36.hasNext() == false) goto L131;
        y0 r37 = (y0) r36.next();
        if (r37.b() != null) goto L129;
        if (r113 == true) goto L129;
        PromotionCardImageComponent r38 = this.this$0;
        int r39 = PromotionCardImageComponent.C;
        r38.c();
        r38.w.setVisibility(8);
        PromotionCardImageComponent.e(r38.g, r38.v);
        String r40 = r37.e();
        if (r40 == null) goto L91;
        this.this$0.g.setVisibility(0);
        this.this$0.g.setText(r40);
        String r41 = r9;
        Typeface r42 = ECFontHelper.e.b(r41, MonitorLevel.FATAL, false);
        if (r42 == null) goto L92;
        this.this$0.g.setTypeface(r42);
    L92:
        t1 r43 = r37.c();
        if (r43 == null) goto L100;
        this.this$0.f.setVisibility(0);
        UtilityKotlinExtentionsKt.f(r43.c(), r43.a(), new PromotionCardImageComponent$updateLeftTag$1$$special$$inlined$forEach$lambda$1(this, r113, r29));
        List r44 = r43.b();
        if (r44 == null) goto L101;
        String r210 = (String) CollectionsKt.firstOrNull(r44);
        if (r210 == null) goto L101;
        ECDraweeView r45 = this.this$0.f;
        int r46 = r.h;
        h0.e(r45, r210, r.a.b("ec_live_promotion_list_flicker_image"), null, null, 120);
    L101:
        Long r47 = r37.a();
        if (r47 != null) goto L104;
        PromotionCardImageComponent r48 = this.this$0;
        if (r37.d() == null) goto L130;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r49 = r48.b;
        if (r49 == null) goto L130;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r50 = r49.b();
        if (r50 == null) goto L130;
        r50.n(true);
    L130:
        r9 = r41;
        goto L81
    L104:
        if (r47.longValue() <= 0) goto L130;
        if (r29.d != UpdateType.UPDATE_EXPOSE) goto L130;
        PromotionCardImageComponent r51 = this.this$0;
        r51.getClass();
        Intrinsics.checkNotNullParameter(r37, "promotionIcon");
        Long r52 = r37.a();
        if (r52 == null) goto L130;
        long r53 = r52.longValue();
        if (r51.q != null) goto L112;
        r51.q = new k(r51, r37);
    L112:
        k r54 = r51.q;
        if (r54 == null) goto L115;
        Lazy r114 = UIUtils.a;
        UIUtils.c().postDelayed(r54, r53 * ((long) 1000));
    L115:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r55 = r51.b;
        if (r55 == null) goto L130;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r56 = r55.b();
        if (r56 == null) goto L130;
        r56.n(false);
        goto L130
    L100:
        this.this$0.f.setVisibility(8);
        Unit r57 = Unit.INSTANCE;
        goto L101
    L91:
        r41 = r9;
        this.this$0.g.setVisibility(8);
        Unit r58 = Unit.INSTANCE;
    L129:
        r41 = r9;
        goto L130
    L131:
        IPromotionUIConfig.d r59 = r29.e.a(PromotionCardModuleName.ImageAreaIndex);
        if (r59 == null) goto L134;
        int r60 = UIConfigHelper.a;
        UIConfigHelper.d(this.this$0.g, r59);
    L134:
        IPromotionUIConfig.d r61 = r29.e.a(PromotionCardModuleName.ImageAreaStatusTag);
        if (r61 == null) goto L137;
        int r62 = UIConfigHelper.a;
        UIConfigHelper.d(this.this$0.f, r61);
    L137:
        IPromotionUIConfig.d r63 = r29.e.a(PromotionCardModuleName.ImageAreaExplainingBarTip);
        if (r63 == null) goto L142;
        TextView r64 = (TextView) this.this$0.d.findViewById(2131390596);
        if (r64 == null) goto L142;
        UIConfigHelper.d(r64, r63);
    L142:
        IPromotionUIConfig.d r1 = r29.e.a(PromotionCardModuleName.ImageAreaExplainingBarAnim);
        if (r1 == null) goto L148;
        ECLottieAnimationView r65 = this.this$0.d.findViewById(2131371937);
        if (r65 == null) goto L158;
        UIConfigHelper.d(r65, r1);
    L158:
        return r1;
    L148:
        return null;
    L78:
        r113 = false;
        goto L79
    L19:
        r11.g.setVisibility(8);
        Unit r115 = Unit.INSTANCE;
        goto L20
    L75:
        r5 = null;
        goto L76
    L8:
        r8 = false;
        goto L9
    L11:
        r4 = null;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((jj2.c) r1, (List) r2);
    }
}
