package com.bytedance.android.livesdk.ktvimpl.base.component;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0017J\b\u0010\u0007\u001a\u00020\u0004H\u0017J\b\u0010\b\u001a\u00020\u0004H\u0017¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/AbsViewComponent;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/android/livesdk/utils/ViewModelStoreOwnerCompat;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "onResume", "onPause", "onStop", "onDestroy", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsViewComponent implements LifecycleObserver, ViewModelStoreOwnerCompat, LifecycleOwnerCompat {
    public final LifecycleRegistry a;
    public final Lazy b;
    public final Lazy c;
    public ViewGroup d;
    public final LifecycleOwner e;
    public final ViewGroup f;

    public void b() {
    }

    public abstract ViewGroup c();

    public void e() {
    }

    public abstract void f();

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.a.setCurrentState(Lifecycle.State.DESTROYED);
        ViewGroup r0 = this.d;
        if (r0 == null) goto L5;
        this.f.removeView(r0);
    L5:
        this.e.getLifecycle().removeObserver(this);
        ((ViewModelStore) this.c.getValue()).clear();
        ((CompositeDisposable) this.b.getValue()).clear();
    }

    public final ViewModelStore tf() {
        return (ViewModelStore) this.c.getValue();
    }

    public final Lifecycle getLifecycleCompat() {
        return this.a;
    }

    public final void a(ViewGroup.LayoutParams r3) {
        f();
        ViewGroup r0 = c();
        if (r0 == null) goto L6;
        this.d = r0;
        this.f.addView(r0, r3);
        this.a.setCurrentState(Lifecycle.State.STARTED);
        e();
        b();
        return;
    }

    public AbsViewComponent(LifecycleOwner r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        this.e = r2;
        this.f = r3;
        LifecycleRegistry r4 = new LifecycleRegistry(this);
        this.a = r4;
        this.b = LazyKt.lazy(AbsViewComponent$compositeDisposable$2.INSTANCE);
        this.c = LazyKt.lazy(AbsViewComponent$viewModelStorage$2.INSTANCE);
        r2.getLifecycle().addObserver(this);
        r4.setCurrentState(Lifecycle.State.CREATED);
    }
}
