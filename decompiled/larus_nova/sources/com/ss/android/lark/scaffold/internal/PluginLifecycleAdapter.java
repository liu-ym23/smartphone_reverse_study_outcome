package com.ss.android.lark.scaffold.internal;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.scaffold.PagePlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l3c.f;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/scaffold/internal/PluginLifecycleAdapter;", "Landroidx/lifecycle/DefaultLifecycleObserver;", CloudControlInf.PLUGIN, "Lcom/ss/android/lark/scaffold/PagePlugin;", "runtime", "Lcom/ss/android/lark/scaffold/PageRuntime;", "<init>", "(Lcom/ss/android/lark/scaffold/PagePlugin;Lcom/ss/android/lark/scaffold/PageRuntime;)V", WidgetCostModule.TYPE_ON_CREATE, "", "owner", "Landroidx/lifecycle/LifecycleOwner;", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginLifecycleAdapter implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PagePlugin f439732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f439733b;

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        PagePlugin r101 = this.f439732a;
        f r102 = this.f439733b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "runtime");
        r101.a(r102);
        r101.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        r100.getLifecycle().removeObserver(this);
        this.f439732a.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f439732a.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        PagePlugin r101 = this.f439732a;
        r101.onResume();
        r101.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        PagePlugin r101 = this.f439732a;
        r101.onStart();
        r101.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        this.f439732a.f439731a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public PluginLifecycleAdapter(PagePlugin r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r101, "runtime");
        this.f439732a = r100;
        this.f439733b = r101;
    }
}
