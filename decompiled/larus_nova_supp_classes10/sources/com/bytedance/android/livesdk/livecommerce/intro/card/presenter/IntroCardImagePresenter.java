package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardImageComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardImagePresenter extends oh2.a implements d {

    public static final class a<T> implements Observer {
        public final /* synthetic */ IntroCardImagePresenter a;

        public a(IntroCardImagePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IntroPromotionVO r4 = (IntroPromotionVO) r3;
            if (r4 == null) goto L11;
            u r0 = r4.getImage();
            if (r0 == null) goto L13;
            IntroCardImagePresenter r1 = this.a;
            s0 r5 = r4.getControl();
            if (r5 == null) goto L9;
            int r6 = r5.d();
        L10:
            ((IntroCardImageComponent) r1.w().f()).R5(r0, r6);
            return;
        L9:
            r6 = 0;
            goto L10
        L13:
            return;
        L11:
            ((IntroCardImageComponent) this.a.w().f()).S5();
            Unit r7 = Unit.INSTANCE;
        }
    }

    public IntroCardImagePresenter() {
        super(0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.d
    public final void d() {
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        r r1 = r0.getCardCallback();
        if (r1 == null) goto L9;
        r1.d();
        return;
    L9:
        return;
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        ((IntroCardImageComponent) w().f()).S5();
    }

    @Override // oh2.a
    public final void D(oh2.h r4) {
        Intrinsics.checkNotNullParameter(r4, "model");
        ((IntroCardImageComponent) w().f()).setPresenter(this);
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L7;
        bk2.e<IntroPromotionVO> r1 = r0.getCardState();
        if (r1 == null) goto L7;
        r1.b(r4.getLifecycleOwner(), new a(this));
    L7:
        IntroCardViewModel r2 = this.e;
        if (r2 == null) goto L13;
        bk2.e<bk2.a<Boolean>> r3 = r2.getShowImageTagAction();
        if (r3 == null) goto L14;
        r3.b(r4.getLifecycleOwner(), new ActionObserver(new IntroCardImagePresenter$bind$2(this)));
        return;
    L14:
        return;
    }
}
