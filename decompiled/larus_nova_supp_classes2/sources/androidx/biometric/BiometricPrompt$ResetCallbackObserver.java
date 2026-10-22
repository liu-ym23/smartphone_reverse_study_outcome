package androidx.biometric;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricPrompt$ResetCallbackObserver implements LifecycleObserver {
    private final WeakReference<BiometricViewModel> mViewModelRef;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void resetCallback() {
        if (this.mViewModelRef.get() == null) goto L6;
        this.mViewModelRef.get().resetClientCallback();
        return;
    }

    public BiometricPrompt$ResetCallbackObserver(BiometricViewModel r2) {
        this.mViewModelRef = new WeakReference(r2);
    }
}
