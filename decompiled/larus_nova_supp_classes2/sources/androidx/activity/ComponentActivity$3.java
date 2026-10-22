package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$3 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$3(ComponentActivity r1) {
        this.this$0 = r1;
    }

    public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
        if (r2 != Lifecycle.Event.ON_DESTROY) goto L9;
        this.this$0.mContextAwareHelper.clearAvailableContext();
        if (this.this$0.isChangingConfigurations() == true) goto L7;
        this.this$0.getViewModelStore().clear();
    L7:
        this.this$0.mReportFullyDrawnExecutor.activityDestroyed();
        return;
    }
}
