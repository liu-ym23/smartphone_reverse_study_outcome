package com.bytedance.ee.bear.drive.core.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/DrivePreviewFragment;", "Lcom/bytedance/ee/bear/drive/core/fragment/AbsLazyLoadFragment;", "<init>", "()V", "logTag", "", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "requiredLifecycleRegistry", "", "onAttachData", "onDetachData", "onPause", "onResume", "onDestroyView", "moveLifecycleState", "state", "Landroidx/lifecycle/Lifecycle$Event;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DrivePreviewFragment extends AbsLazyLoadFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f224154p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LifecycleRegistry f224155q;

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        if (this.f224155q != null) goto L5;
        this.f224155q = new LifecycleRegistry(this);
    L5:
        LifecycleRegistry r100 = this.f224155q;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public DrivePreviewFragment() {
        this.f224154p = getClass().getSimpleName();
        this.f224155q = new LifecycleRegistry(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment
    public final void W90() {
        super.W90();
        Z90(Lifecycle.Event.ON_RESUME);
        this.f224135g.c().onAttach();
        this.f224135g.c().load();
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment
    public final void X90() {
        super.X90();
        Z90(Lifecycle.Event.ON_STOP);
        this.f224135g.c().onDetach();
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        LifecycleRegistry r100 = this.f224155q;
        if (r100 == null) goto L5;
        Lifecycle.State r101 = r100.getCurrentState();
    L7:
        if (r101 == Lifecycle.State.INITIALIZED) goto L9;
        Z90(Lifecycle.Event.ON_DESTROY);
    L9:
        this.f224155q = null;
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f224142n == false) goto L6;
        Z90(Lifecycle.Event.ON_STOP);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f224142n == false) goto L6;
        Z90(Lifecycle.Event.ON_RESUME);
        return;
    }

    public final void Z90(Lifecycle.Event r100) {
        LifecycleRegistry r101 = this.f224155q;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.handleLifecycleEvent(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        tt5.a.e(this.f224154p, "moveLifecycleState() error:", th, false);
    }
}
