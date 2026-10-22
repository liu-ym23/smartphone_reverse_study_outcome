package com.bytedance.bdp.appbase.context.service;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.context.BdpAppContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bdp/appbase/context/service/ContextService;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "Landroidx/lifecycle/LifecycleEventObserver;", "appContext", "(Lcom/bytedance/bdp/appbase/context/BdpAppContext;)V", "getAppContext", "()Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "Lcom/bytedance/bdp/appbase/context/BdpAppContext;", "hasInit", "", "init", "", "init$bdp_infrastructure_release", LiveCommonConstants.REASON_ON_DEDTROY, "onStateChanged", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "stateChanged", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public abstract class ContextService<T extends BdpAppContext> implements LifecycleEventObserver {
    private final T appContext;
    private volatile boolean hasInit;

    public void onDestroy() {
    }

    public void stateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
    }

    public final void init$bdp_infrastructure_release() {
        if (this.hasInit == false) goto L5;
        return;
    L5:
        this.hasInit = true;
        this.appContext.a(this);
    }

    public final T getAppContext() {
        return this.appContext;
    }

    public ContextService(T r100) {
        this.appContext = r100;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        stateChanged(r100, r101);
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
        onDestroy();
        r100.getLifecycle().removeObserver(this);
        return;
    }
}
