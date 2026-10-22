package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$4 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$4(ComponentActivity r1) {
        this.this$0 = r1;
    }

    public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
        this.this$0.ensureViewModelStore();
        this.this$0.getLifecycle().removeObserver(this);
    }
}
