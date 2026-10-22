package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECCurrentPromotion;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.b1;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class StatusPresenter extends p implements q83.a {
    public String g;
    public com.bytedance.android.livesdk.livecommerce.view.countdown.c h;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ StatusPresenter a;

        public b(StatusPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ECUIPromotion r3 = (ECUIPromotion) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isAuction() == true) goto L9;
            this.a.E(r3);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ StatusPresenter a;

        public c(StatusPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            pk2.d r5 = (pk2.d) r4;
            if (r5.b != 2) goto L6;
            this.a.w().f().animate().alpha(0.0f).setDuration(500).setInterpolator(new FastOutSlowInInterpolator()).start();
        L6:
            if (r5.b != 0) goto L9;
            this.a.w().f().setAlpha(1.0f);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r0 = this.h;
        if (r0 == null) goto L12;
        monitor-enter(r0);
        boolean r1 = r0.b;     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r1 == false) goto L12;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L17;
        r0 = null;
    L17:
        if (r0 == null) goto L22;
        r0.a();
        this.h = null;
        return;
    L22:
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r2 = false;
        goto L14
    }

    public StatusPresenter() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r8) {
        Intrinsics.checkNotNullParameter(r8, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L7;
        r1.b(r8.getLifecycleOwner(), new b(this));
    L7:
        w().b(2131376107).a(new StatusPresenter$bind$2(this));
        c0.b((TextView) w().b(2131391657).f(), MonitorLevel.FATAL);
        com.bytedance.android.livesdk.livecommerce.utils.a.a(w().b(2131376107).f(), th.a.g(u().c(), 2131896389));
        ExplainCardViewModel r2 = this.e;
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.livecommerce.largemode.b r3 = r2.getLargeModeAdapter();
        if (r3 == null) goto L14;
        ComponentLargeModeConfig r4 = r3.b("ExplainCard", "ExplainCard.TopArea");
        if (r4 == null) goto L14;
        int r5 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r4, w().f());
    L14:
        ExplainCardViewModel r6 = this.e;
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.largemode.b r7 = r6.getLargeModeAdapter();
        if (r7 == null) goto L21;
        ComponentLargeModeConfig r9 = r7.b("ExplainCard", "ExplainCard.TopArea.Close");
        if (r9 == null) goto L21;
        int r10 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r9, w().b(2131376107).f());
    L21:
        View r11 = w().b(2131377645).f();
        ExplainCardViewModel r12 = this.e;
        if (r12 == null) goto L28;
        com.bytedance.android.livesdk.livecommerce.largemode.b r13 = r12.getLargeModeAdapter();
        if (r13 == null) goto L28;
        ComponentLargeModeConfig r14 = r13.b("ExplainCard", "ExplainCard.TopArea.Tag");
        if (r14 == null) goto L28;
        LargeModeConfigHelper.a(r14, r11);
    L28:
        ExplainCardViewModel r15 = this.e;
        if (r15 == null) goto L35;
        com.bytedance.android.livesdk.livecommerce.largemode.b r16 = r15.getLargeModeAdapter();
        if (r16 == null) goto L35;
        ComponentLargeModeConfig r17 = r16.b("ExplainCard", "ExplainCard.TopArea.Tag.Text");
        if (r17 == null) goto L35;
        int r18 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r17, r11.findViewById(2131391657));
    L35:
        View r19 = w().b(2131377646).f();
        ExplainCardViewModel r20 = this.e;
        if (r20 == null) goto L42;
        com.bytedance.android.livesdk.livecommerce.largemode.b r21 = r20.getLargeModeAdapter();
        if (r21 == null) goto L42;
        ComponentLargeModeConfig r22 = r21.b("ExplainCard", "ExplainCard.TopArea.Tag");
        if (r22 == null) goto L42;
        LargeModeConfigHelper.a(r22, r19);
    L42:
        ExplainCardViewModel r23 = this.e;
        if (r23 == null) goto L49;
        com.bytedance.android.livesdk.livecommerce.largemode.b r24 = r23.getLargeModeAdapter();
        if (r24 == null) goto L49;
        ComponentLargeModeConfig r25 = r24.b("ExplainCard", "ExplainCard.TopArea.Tag.Text");
        if (r25 == null) goto L49;
        int r26 = LargeModeConfigHelper.a;
        LargeModeConfigHelper.a(r25, r19.findViewById(2131391657));
    L49:
        ExplainCardViewModel r27 = this.e;
        if (r27 == null) goto L55;
        QLiveData<pk2.d> r28 = r27.getCardExtendInfoState();
        if (r28 == null) goto L56;
        r28.b(r8.getLifecycleOwner(), new c(this));
        return;
    L56:
        return;
    }

    public final void E(ECUIPromotion r25) {
        ECUICampaign r2 = r25.campaign;
        boolean r5 = false;
        w().b(2131377645).f().setVisibility(0);
        w().b(2131377646).f().setVisibility(8);
        Query r3 = w().b(2131391657);
        r3.g(8);
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r6 = this.h;
        if (r6 == null) goto L13;
        monitor-enter(r6);
        boolean r9 = r6.b;     // Catch: Throwable -> L9
        monitor-exit(r6);
        if (r9 == false) goto L13;
        boolean r10 = true;
    L14:
        String r11 = null;
        if (r10 == true) goto L18;
        r6 = null;
    L18:
        if (r6 == null) goto L20;
        r6.a();
        this.h = null;
    L20:
        if (r2 == null) goto L22;
        Boolean r7 = r2.isSecKill();
    L24:
        if (Intrinsics.areEqual(r7, Boolean.TRUE) == false) goto L44;
        boolean r8 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a(r2.startTime, r2.endTime) == false) goto L44;
        long r12 = r2.startTime;
        long r13 = r2.endTime;
        Handler r14 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r15 = SystemClock.elapsedRealtime();
        if (r12 <= r15) goto L30;
    L32:
        boolean r16 = false;
    L33:
        if (r16 == false) goto L44;
        if (r25.getStatus() == 2) goto L44;
        if (r25.isPriceDeduce() == true) goto L44;
        if (r2.fakeSecKill == true) goto L44;
        View r4 = r3.b;
        if ((r4 instanceof TextView) == false) goto L43;
        ((TextView) r4).setTextSize(1, 10.0f);
    L43:
        r3.g(0);
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r17 = new com.bytedance.android.livesdk.livecommerce.view.countdown.c(this);
        r17.c();
        this.h = r17;
        boolean r18 = true;
    L45:
        String r19 = r25.qIvIcon;
        String r20 = r25.upDesc;
        boolean r21 = !r18;
        RitTagTrack r22 = r25.getUpIconTagTrack();
        Query r23 = w().b(2131377645);
        Query r24 = r23.b(2131375968);
        Query r26 = r23.b(2131391657);
        if (r22 == null) goto L49;
        r22.setVisibile(true);
    L49:
        if ((!Intrinsics.areEqual(r19, this.g)) == false) goto L69;
        this.g = r19;
        if (r19 != null) goto L53;
    L56:
        boolean r27 = true;
    L57:
        if (r27 == false) goto L59;
        r24.c();
        goto L69
    L59:
        r24.g(0);
        GenericDraweeView r110 = r24.f();
        ImageExtensionsKt.D(r110, new com.bytedance.android.ec.core.imagex.r("ec_live", "goods_card_up_view"));
        b0 r28 = new b0(this);
        if (TextUtils.isEmpty(r19) == true) goto L69;
        if (com.bytedance.android.ec.core.utils.y.m() == false) goto L65;
        ImageExtensionsKt.s(r110, r19, null, null, null, null, null, null, r28, true, null, null, null);
        goto L69
    L65:
        com.bytedance.android.ec.core.imagex.u r29 = com.bytedance.android.ec.core.utils.y.j(r110);
        AbstractDraweeController r30 = Fresco.newDraweeControllerBuilder().setOldController(r110.getController()).setControllerListener(r28).setCallerContext(r29).setImageRequest(ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r19)).build()).build();
        if ((r29 instanceof com.bytedance.android.ec.core.imagex.u) == false) goto L68;
        r29.k();
    L68:
        r110.setController(r30);
        goto L69
    L53:
        if (r19.length() == 0) goto L56;
        r27 = false;
    L69:
        if (r21 == false) goto L78;
        HashMap r31 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r20) == false) goto L76;
        r26.e(r20);
        View r32 = r26.b;
        if ((r32 instanceof TextView) == false) goto L75;
        ((TextView) r32).setTextSize(1, 9.0f);
    L75:
        r26.g(0);
        goto L78
    L76:
        r26.c();
    L78:
        if (r26.d() == true) goto L82;
        View r33 = r23.b;
        if (r33 == null) goto L83;
        r33.setBackgroundColor(r33.getContext().getResources().getColor(2131101701));
    L83:
        ECCurrentPromotion.a r0 = r25.publicArea;
        if (r0 == null) goto L86;
        r11 = r0.noticeText;
    L86:
        if (r11 != null) goto L88;
    L89:
        r5 = true;
    L90:
        if (r5 == true) goto L97;
        ExplainCardViewModel r1 = this.e;
        if (r1 == null) goto L98;
        r1.postNoFilterNoticeEvent(r11);
        return;
    L98:
        return;
    L97:
        return;
    L88:
        if (r11.length() != 0) goto L90;
    L82:
        r23.f().setBackgroundResource(2131234288);
        goto L83
    L30:
        if ((r13 - r15) > 86400000) goto L32;
        r16 = true;
    L44:
        r18 = false;
        goto L45
    L22:
        r7 = null;
    L9:
        th = move-exception;
        throw th;
    L13:
        r10 = false;
        goto L14
    }

    public final boolean onTick(long r11) {
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L45;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L45;
        ECUIPromotion r2 = (ECUIPromotion) r1.a();
        if (r2 == null) goto L45;
        Query r3 = w().b(2131391657);
        if (r2.isSecKill().booleanValue() == false) goto L43;
        if (r2.campaign.endTime <= r11) goto L43;
        if (r3.d() == false) goto L43;
        int r4 = b1.e;
        Context r5 = u().c();
        long r6 = r2.campaign.endTime - r11;
        Intrinsics.checkNotNullParameter(r5, "context");
        b1 r12 = new b1();
        if (r6 <= 0) goto L37;
        long r7 = r6 / ((long) 1000);
        int r8 = ((int) r7) % 60;
        long r9 = 60;
        long r10 = r7 / r9;
        int r13 = ((int) r10) % 60;
        int r14 = (int) (r10 / r9);
        int r15 = r14 % 24;
        int r16 = r14 / 24;
        if (r16 <= 0) goto L21;
        String.valueOf(r16);
    L21:
        if (r15 >= 10) goto L23;
        String r17 = th.a.h(r5, 2131913722, new Object[]{Integer.valueOf(r15)});
    L24:
        r12.a = r17;
        if (r13 >= 10) goto L27;
        String r18 = th.a.h(r5, 2131913722, new Object[]{Integer.valueOf(r13)});
    L28:
        r12.b = r18;
        if (r8 >= 10) goto L31;
        String r19 = th.a.h(r5, 2131913722, new Object[]{Integer.valueOf(r8)});
    L32:
        r12.c = r19;
        if (r16 <= 0) goto L35;
        String r20 = th.a.h(r5, 2131913718, new Object[]{Integer.valueOf(r16), r12.a, r12.b, r12.c});
    L36:
        r12.d = r20;
    L38:
        String r110 = r12.d;
        if (r110 == null) goto L41;
        w().b(2131391657).e(r110);
    L41:
        return true;
    L35:
        r20 = th.a.h(r5, 2131913720, new Object[]{r12.a, r12.b, r19});
        goto L36
    L31:
        r19 = String.valueOf(r8);
        goto L32
    L27:
        r18 = String.valueOf(r13);
        goto L28
    L23:
        r17 = String.valueOf(r15);
        goto L24
    L37:
        r12.a = th.a.g(r5, 2131913719);
        r12.b = th.a.g(r5, 2131913719);
        r12.c = th.a.g(r5, 2131913719);
    L43:
        if (r3.d() == false) goto L45;
        E(r2);
    L45:
        return false;
    }
}
