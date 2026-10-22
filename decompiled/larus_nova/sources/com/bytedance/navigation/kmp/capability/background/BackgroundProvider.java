package com.bytedance.navigation.kmp.capability.background;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import d37.i;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/navigation/kmp/capability/background/BackgroundProvider;", "Lcom/bytedance/navigation/kmp/interfaces/IBackgroundMonitor;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "isBackground", "", "()Z", "setBackground", "(Z)V", "mBackgroundListener", "Lcom/bytedance/navigation/kmp/listener/BackgroundListener;", "getMBackgroundListener", "()Lcom/bytedance/navigation/kmp/listener/BackgroundListener;", "setMBackgroundListener", "(Lcom/bytedance/navigation/kmp/listener/BackgroundListener;)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "init", "", "setListener", "listener", "isInBackground", WidgetCostModule.TYPE_ON_START, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "cleanup", "bdnavigation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackgroundProvider implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.navigation.kmp.listener.a f265743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f265744b;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            i r102 = i.f466749a;
            i.e("CoroutineScope exception", r101);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onPause(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onResume(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onResume(this, r100);
    }

    public final void a() {
        BuildersKt.launch$default(this.f265744b, null, null, new BackgroundProvider$cleanup$1(this, null), 3, null);
        CoroutineScopeKt.cancel$default(this.f265744b, "BackgroundProvider cleaned up", null, 2, null);
        this.f265743a = null;
    }

    public final void b() {
        BuildersKt.launch$default(this.f265744b, null, null, new BackgroundProvider$init$1(this, null), 3, null);
    }

    public BackgroundProvider() {
        this.f265744b = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new a(CoroutineExceptionHandler.Key)));
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
        com.bytedance.navigation.kmp.listener.a r101 = this.f265743a;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        i r102 = i.f466749a;
        i.a("AppLifecycle: 应用进入前台");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
        com.bytedance.navigation.kmp.listener.a r101 = this.f265743a;
        if (r101 == null) goto L5;
        r101.v();
    L5:
        i r102 = i.f466749a;
        i.a("AppLifecycle: 应用进入后台");
    }
}
