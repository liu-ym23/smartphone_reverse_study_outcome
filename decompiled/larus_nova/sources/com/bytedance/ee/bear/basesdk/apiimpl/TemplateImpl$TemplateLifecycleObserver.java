package com.bytedance.ee.bear.basesdk.apiimpl;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/apiimpl/TemplateImpl$TemplateLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "bundle", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/ref/WeakReference;Landroid/os/Bundle;)V", "onActivityDestroy", "", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateImpl$TemplateLifecycleObserver implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onActivityDestroy() {
        tt5.a.h("TemplateImpl", "TemplateLifecycleObserver onActivityDestroy()");
        throw null;
    }
}
