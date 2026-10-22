package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardPriceComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends oh2.a {

    public static final class a<T> implements Observer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IntroPromotionVO r4 = (IntroPromotionVO) r3;
            if (r4 == null) goto L11;
            IntroPrice r0 = r4.getPrice();
            if (r0 == null) goto L13;
            i r1 = this.a;
            s0 r5 = r4.getControl();
            if (r5 == null) goto L9;
            Integer r6 = Integer.valueOf(r5.d());
        L10:
            ((IntroCardPriceComponent) r1.w().f()).b(r0, r6);
            return;
        L9:
            r6 = null;
            goto L10
        L13:
            return;
        L11:
            ((IntroCardPriceComponent) this.a.w().f()).c();
            Unit r7 = Unit.INSTANCE;
        }
    }

    public i() {
        super(0);
    }

    @Override // oh2.a
    public final void C() {
        clearDisposable();
        ((IntroCardPriceComponent) w().f()).c();
    }

    @Override // oh2.a
    public final void D(oh2.h r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        IntroCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        bk2.e<IntroPromotionVO> r1 = r0.getCardState();
        if (r1 == null) goto L9;
        r1.b(r3.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }
}
