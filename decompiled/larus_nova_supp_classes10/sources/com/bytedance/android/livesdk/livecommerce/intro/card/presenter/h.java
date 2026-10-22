package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardCarouselComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h extends oh2.a implements c {

    public static final class a<T> implements Observer {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IntroPromotionVO r4 = (IntroPromotionVO) r3;
            if (r4 == null) goto L5;
            ((IntroCardCarouselComponent) this.a.w().b(2131363225).f()).R5(r4);
            return;
        L5:
            ((IntroCardCarouselComponent) this.a.w().b(2131363225).f()).release();
            Unit r5 = Unit.INSTANCE;
        }
    }

    public h() {
        super(0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c
    public final void i() {
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        bk2.e<bk2.a<Unit>> r1 = r0.getShowCardAction();
        if (r1 == null) goto L9;
        r1.g(new bk2.a(Unit.INSTANCE));
        return;
    L9:
        return;
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        ((IntroCardCarouselComponent) w().b(2131363225).f()).release();
    }

    @Override // oh2.a
    public final void D(oh2.h r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ((IntroCardCarouselComponent) w().b(2131363225).f()).setPresenter(this);
        IntroCardCarouselComponent r0 = (IntroCardCarouselComponent) w().b(2131363225).f();
        r0.setArgument(this.f);
        r0.setContainerAbility(this.g);
        IntroCardViewModel r1 = this.e;
        if (r1 == null) goto L8;
        bk2.e<IntroPromotionVO> r2 = r1.getCardState();
        if (r2 == null) goto L9;
        r2.b(r3.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c
    public final void t(boolean r3) {
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        bk2.e<bk2.a<Boolean>> r1 = r0.getSecondFrameHasTitleAction();
        if (r1 == null) goto L9;
        r1.g(new bk2.a(Boolean.valueOf(r3)));
        return;
    L9:
        return;
    }
}
