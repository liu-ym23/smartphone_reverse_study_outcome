package com.bytedance.android.livesdk.livecommerce.intro.auction;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.n;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oh2.h;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroAuctionPresenter extends QPresenter {
    public static final /* synthetic */ int l = 0;
    public final String e;
    public IntroAuctionViewModel f;
    public l g;
    public IntroAuctionPromotionVO h;
    public Long i;
    public final oh2.e j;
    public final oh2.c k;

    public static final class a {
    }

    static {
    }

    public final void C() {
        UtilityKotlinExtentionsKt.f(this.i, this.h, new IntroAuctionPresenter$logShowDurationEvent$1(this));
        this.i = null;
        D();
    }

    public final void D() {
        int r0 = n.o;
        IntroAuctionViewModel r1 = this.f;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.room.model.e r2 = r1.getLiveRoomInfo();
        if (r2 == null) goto L7;
        String r3 = r2.roomId();
    L8:
        IntroAuctionViewModel r4 = this.f;
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.model.e r5 = r4.getLiveRoomInfo();
        if (r5 == null) goto L13;
        String r6 = r5.a();
    L14:
        n.a.a(r3, r6).m = true;
        l r7 = this.g;
        if (r7 != null) goto L17;
    L19:
        l r8 = this.g;
        if (r8 == null) goto L22;
        r8.release();
    L22:
        this.g = null;
        return;
    L17:
        if (r7.getHybridView() == null) goto L19;
        ((ViewGroup) w().f()).removeAllViews();
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void A(final QModel r6) {
        if ((r6 instanceof h) == false) goto L18;
        h r0 = (h) r6;
        if ((r0.a() instanceof IntroAuctionViewModel) == false) goto L19;
        QViewModel r1 = r0.a();
        if (r1 == null) goto L17;
        IntroAuctionViewModel r2 = (IntroAuctionViewModel) r1;
        this.f = r2;
        bk2.e<bk2.a<Unit>> r3 = r2.getShowBeforeAnimAction();
        if (r3 == null) goto L11;
        r3.b(r0.getLifecycleOwner(), new ActionObserver(new IntroAuctionPresenter$onBind$1(this)));
    L11:
        IntroAuctionViewModel r4 = this.f;
        if (r4 == null) goto L20;
        bk2.e<IntroAuctionPromotionVO> r5 = r4.getCardState();
        if (r5 == null) goto L21;
        r5.b(r0.getLifecycleOwner(), new IntroAuctionPresenter$onBind$2(this, r6));
        return;
    L21:
        return;
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.intro.auction.IntroAuctionViewModel");
    L19:
        return;
    }

    public final void E(int r3) {
        ViewGroup.LayoutParams r0 = w().f().getLayoutParams();
        if (r0 != null) goto L5;
    L6:
        View r1 = w().f();
        ViewGroup.LayoutParams r2 = w().f().getLayoutParams();
        if (r2 == null) goto L9;
        r2.height = r3;
        Unit r4 = Unit.INSTANCE;
    L10:
        r1.setLayoutParams(r2);
        return;
    L9:
        r2 = null;
        goto L10
    L5:
        if (r0.height != r3) goto L6;
    }

    public IntroAuctionPresenter(oh2.e r2, oh2.c r3) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        Intrinsics.checkNotNullParameter(r3, "containerAbility");
        this.j = r2;
        this.k = r3;
        this.e = "auction_uuid";
    }
}
