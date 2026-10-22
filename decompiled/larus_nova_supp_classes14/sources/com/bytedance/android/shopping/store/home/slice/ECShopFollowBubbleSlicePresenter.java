package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.store.home.a0;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.home.view.FollowGiftBubbleView;
import com.bytedance.android.shopping.store.home.view.s;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFollowBubbleSlicePresenter extends ECShopBasePresenter {
    public static final /* synthetic */ int w = 0;
    public final Lazy u;
    public final Lazy v;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopFollowBubbleSlicePresenter a;

        public b(ECShopFollowBubbleSlicePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            a0 r7 = (a0) r6;
            View r1 = null;
            if (r7.b == false) goto L21;
            ECShopFollowBubbleSlicePresenter r0 = this.a;
            boolean r2 = r7.e;
            StoreFollowGiftConfig r8 = r7.f;
            if (r2 == true) goto L19;
            if (r8 == null) goto L18;
            r0.getClass();
            if (a2.b(r8.getText()) == false) goto L18;
            r0.q0().x(r8.getText(), r8.getTextColor(), r8.getBubbleColor());
            FollowGiftBubbleView r9 = r0.q0();
            WeakReference<View> r3 = r0.T().getSliceHeaderFollowButtonView();
            if (r3 == null) goto L12;
            r1 = r3.get();
        L12:
            ViewGroup r4 = (ViewGroup) r0.v.getValue();
            r9.getClass();
            if (r1 == null) goto L43;
            if (r4 == null) goto L44;
            r1.post(new s(r9, r1, r4));
            return;
        L44:
            return;
        L43:
            return;
        L18:
            r0.q0().y();
            return;
        L19:
            r0.q0().y();
            return;
        L21:
            if (r7.c == false) goto L41;
            ECShopFollowBubbleSlicePresenter r5 = this.a;
            StoreFollowGiftConfig r10 = r7.g;
            boolean r11 = r7.d;
            r5.getClass();
            if (r11 == false) goto L36;
            if (r10 == null) goto L36;
            if (a2.b(r10.getText()) == false) goto L36;
            r5.q0().x(r10.getText(), r10.getTextColor(), r10.getBubbleColor());
            FollowGiftBubbleView r12 = r5.q0();
            WeakReference<View> r13 = r5.T().getSliceHeaderFollowButtonView();
            if (r13 == null) goto L30;
            r1 = r13.get();
        L30:
            ViewGroup r14 = (ViewGroup) r5.v.getValue();
            r12.getClass();
            if (r1 == null) goto L45;
            if (r14 == null) goto L46;
            r1.post(new s(r12, r1, r14));
            return;
        L46:
            return;
        L45:
            return;
        L36:
            r5.q0().y();
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ECShopFollowBubbleSlicePresenter a;

        public c(ECShopFollowBubbleSlicePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            float r5 = ((Number) r4).floatValue();
            if (Intrinsics.areEqual((Boolean) this.a.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L6;
            this.a.q0().setAlpha(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(1 - ((r5 - 0.19f) / 0.16f), 1.0f), 0.0f));
            return;
        }
    }

    static {
    }

    public final FollowGiftBubbleView q0() {
        return (FollowGiftBubbleView) this.u.getValue();
    }

    public ECShopFollowBubbleSlicePresenter(Fragment r1) {
        super(r1);
        this.u = LazyKt.lazy(new ECShopFollowBubbleSlicePresenter$couponBubble$2(this));
        this.v = LazyKt.lazy(new ECShopFollowBubbleSlicePresenter$sliceProfileContainer$2(this));
    }

    public final void A(QModel r4) {
        T().getFollowConfigLiveData().a(W(), new b(this), false);
        T().getUpglideFactor().a(ECQuickUtilKt.a(u()), new c(this), false);
    }
}
