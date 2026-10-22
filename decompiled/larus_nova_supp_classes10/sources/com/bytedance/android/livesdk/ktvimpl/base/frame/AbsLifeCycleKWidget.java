package com.bytedance.android.livesdk.ktvimpl.base.frame;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.frame.AbsKWidgetViewModel;
import com.bytedance.android.livesdk.utils.ViewModelStoreOwnerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0017¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsLifeCycleKWidget;", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "T", "Lcom/bytedance/android/livesdk/ktvimpl/base/frame/IKWidget;", "Landroidx/lifecycle/LifecycleObserver;", "", "onUnLoad", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsLifeCycleKWidget<T extends AbsKWidgetViewModel> implements IKWidget<T>, LifecycleObserver {
    public final LifecycleOwner a;

    public final /* synthetic */ ViewModelStore getViewModelStore() {
        return ViewModelStoreOwnerCompat.-CC.$default$getViewModelStore(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    public ViewModelProvider.Factory getViewModelFactory() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.frame.IKWidget
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onUnLoad() {
        getViewModelStore().clear();
        ALogger.i("AbsLifeCycleKWidget", "onUnLoad");
    }

    public AbsLifeCycleKWidget(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.a = r2;
        r2.getLifecycle().addObserver(this);
    }

    public final void b(MutableLiveData r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$bindData");
        Intrinsics.checkNotNullParameter(r4, "cb");
        r3.observe(this.a, new a(r4));
    }
}
