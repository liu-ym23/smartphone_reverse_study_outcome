package com.bytedance.android.livesdk.ktvimpl.base.frame;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0014J\u0012\u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\"H$R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/frame/AbsKWidgetViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "()V", "globalContextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "getGlobalContextRef", "()Ljava/lang/ref/WeakReference;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "mDataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getMDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setMDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "vmComposible", "Lio/reactivex/disposables/CompositeDisposable;", "getVmComposible", "()Lio/reactivex/disposables/CompositeDisposable;", "vmDataContext", "Lcom/bytedance/live/datacontext/DataContext;", "getVmDataContext", "()Lcom/bytedance/live/datacontext/DataContext;", "getLifecycleCompat", "Landroidx/lifecycle/Lifecycle;", "onCleared", "", "provideDataService", "Ljava/lang/Class;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class AbsKWidgetViewModel extends ViewModel implements LifecycleOwnerCompat {
    private final WeakReference<Context> globalContextRef;
    private final Lazy lifecycleRegistry$delegate;
    private DataCenter mDataCenter;
    private final CompositeDisposable vmComposible;
    private final DataContext vmDataContext;

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.lifecycleRegistry$delegate.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public abstract Class<? extends DataContext> provideDataService();

    public AbsKWidgetViewModel() {
        this.vmComposible = new CompositeDisposable();
        this.lifecycleRegistry$delegate = LazyKt.lazy(new AbsKWidgetViewModel$lifecycleRegistry$2(this));
        Context r1 = k.n(IMiddleWareHostContext.class).context();
        if (r1 != null) goto L5;
        r1 = jc1.a.b().getApplicationContext();
    L5:
        this.globalContextRef = new WeakReference(r1);
        getLifecycleRegistry().markState(Lifecycle.State.STARTED);
        final Class<? extends DataContext> r0 = provideDataService();
        if (r0 == null) goto L11;
        KtvContext.Companion.getClass();
        b r2 = KtvContext.a.g().getKWidgetManager();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "service");
        if (r2.b.get(r0) != null) goto L12;
        Pair<DataContext, Disposable> r3 = d.a(new KWidgetService$registDataService$1(r0));
        r2.b.put(r0, r3);
        return;
    L12:
        return;
    }

    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    public void onCleared() {
        getLifecycleRegistry().markState(Lifecycle.State.DESTROYED);
        this.vmComposible.dispose();
        Class<? extends DataContext> r0 = provideDataService();
        if (r0 == null) goto L8;
        KtvContext.Companion.getClass();
        b r1 = KtvContext.a.g().getKWidgetManager();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "service");
        Pair<DataContext, Disposable> r2 = r1.b.remove(r0);
        if (r2 == null) goto L9;
        ((Disposable) r2.getSecond()).dispose();
        return;
    L9:
        return;
    }

    public final WeakReference<Context> getGlobalContextRef() {
        return this.globalContextRef;
    }

    public final DataCenter getMDataCenter() {
        return this.mDataCenter;
    }

    public final CompositeDisposable getVmComposible() {
        return this.vmComposible;
    }

    public final DataContext getVmDataContext() {
        return this.vmDataContext;
    }

    public final void setMDataCenter(DataCenter r1) {
        this.mDataCenter = r1;
    }
}
