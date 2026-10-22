package com.bytedance.android.shopping.store.home.frame.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<T> extends QFragmentPresenter {
    public g f;
    public f g;
    public e h;
    public ECStoreParam i;

    public abstract void i0(T r1);

    public abstract void j0();

    public final ECStoreParam d0() {
        ECStoreParam r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("storeParam");
    L5:
        return r0;
    }

    public final LifecycleOwner h0() {
        Fragment r0 = ((QFragmentPresenter) this).e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ECQuickUtilKt.a(Y());
    }

    public final Lifecycle e0() {
        return h0().getLifecycle();
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = new d();
        this.g = new c();
        this.h = new b();
    }

    public final void b0(QModel r1) {
        j0();
    }
}
