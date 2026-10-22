package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.shopping.store.home.entity.n;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends ECShopBasePresenter {

    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            int r10 = this.a.y().getHeight();
            Integer r11 = (Integer) this.a.T().getStoreInfoAreaWithoutTipsHeight().getValue();
            if (r11 == null) goto L5;
            int r12 = r11.intValue();
        L6:
            if (r10 == r12) goto L9;
            this.a.T().getStoreInfoAreaWithoutTipsHeight().setValue(Integer.valueOf(this.a.y().getHeight() - ExtensionsKt.a(12)));
            return;
        L9:
            return;
        L5:
            r12 = 0;
            goto L6
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L5;
        L13:
            d2.d(this.a.y(), 0, 0, 0, 0);
            return;
        L5:
            if (this.a.T().canShowTopLiveAndVideo() == false) goto L13;
            if (this.a.T().getStoreParam().isSplitMode() == true) goto L10;
        L12:
            d2.d(this.a.y(), 0, ExtensionsKt.a(8), 0, 0);
            return;
        L10:
            if (this.a.T().getHasLive() == true) goto L12;
            d2.d(this.a.y(), 0, 0, 0, 0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.home.slice.c$c, reason: collision with other inner class name */
    public static final class C0007c<T> implements Observer {
        public final /* synthetic */ c a;

        public C0007c(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            n r3 = (n) r2;
            if (this.a.T().canShowTopLiveAndVideo() == true) goto L6;
            d2.d(this.a.y(), 0, 0, 0, 0);
            return;
        }
    }

    public c(Fragment r1) {
        super(r1);
    }

    public final void A(QModel r4) {
        y().addOnLayoutChangeListener(new a(this));
        T().isBrandShop().a(W(), new b(this), false);
        T().getHeaderArea().a(W(), new C0007c(this), false);
    }
}
