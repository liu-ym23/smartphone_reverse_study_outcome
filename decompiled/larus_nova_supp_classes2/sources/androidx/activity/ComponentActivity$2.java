package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$2 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$2(ComponentActivity r1) {
        this.this$0 = r1;
    }

    public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
        if (r2 != Lifecycle.Event.ON_STOP) goto L11;
        Window r3 = this.this$0.getWindow();
        if (r3 == null) goto L7;
        View r4 = r3.peekDecorView();
    L8:
        if (r4 == null) goto L12;
        ComponentActivity$Api19Impl.cancelPendingInputEvents(r4);
        return;
    L12:
        return;
    L7:
        r4 = null;
        goto L8
    }
}
