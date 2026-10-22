package androidx.activity;

import android.os.Build;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$6 implements LifecycleEventObserver {
    final /* synthetic */ ComponentActivity this$0;

    public void onStateChanged(LifecycleOwner r1, Lifecycle.Event r2) {
        androidx_activity_ComponentActivity$6_com_larus_home_impl_utils_ComponentActivityOnBackPressedLancet_onStateChanged(this, r1, r2);
    }

    public ComponentActivity$6(ComponentActivity r1) {
        this.this$0 = r1;
    }

    public void androidx_activity_ComponentActivity$6__onStateChanged$___twin___(LifecycleOwner r2, Lifecycle.Event r3) {
        if (r3 == Lifecycle.Event.ON_CREATE) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        ComponentActivity.access$100(this.this$0).setOnBackInvokedDispatcher(ComponentActivity$Api33Impl.getOnBackInvokedDispatcher((ComponentActivity) r2));
        return;
    }

    public static void androidx_activity_ComponentActivity$6_com_larus_home_impl_utils_ComponentActivityOnBackPressedLancet_onStateChanged(ComponentActivity$6 r1, LifecycleOwner r2, Lifecycle.Event r3) {
        if ((r2 instanceof ComponentActivity) == false) goto L6;
        r1.androidx_activity_ComponentActivity$6__onStateChanged$___twin___(r2, r3);
        return;
    }
}
