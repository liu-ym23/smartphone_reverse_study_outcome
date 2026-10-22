package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.livesdk.livecommerce.promotionlist.viewmodel.LivePromotionListViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a extends QFragmentPresenter implements com.bytedance.android.ec.core.async.b {
    public final Lazy f;
    public boolean g;
    public final String h;
    public final com.bytedance.android.ec.core.async.b i;

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.i.add(r2);
    }

    public final void clearDisposable() {
        this.i.clearDisposable();
    }

    public final CompositeDisposable compositeDisposable() {
        return this.i.compositeDisposable();
    }

    public final LivePromotionListViewModel d0() {
        return (LivePromotionListViewModel) this.f.getValue();
    }

    public abstract void e0();

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.i.remove(r2);
    }

    public void c0() {
        clearDisposable();
        this.g = false;
    }

    public final void b0(QModel r1) {
        if (this.g == true) goto L6;
        this.g = true;
        e0();
        return;
    }

    public a(final Fragment r3, String r4) {
        DisposableScope r0 = new DisposableScope();
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r0, "disposableScope");
        super(r3);
        this.h = r4;
        this.i = r0;
        this.f = LazyKt.lazy(new LivePromotionListBasePresenter$viewModel$2(this, r3));
    }
}
