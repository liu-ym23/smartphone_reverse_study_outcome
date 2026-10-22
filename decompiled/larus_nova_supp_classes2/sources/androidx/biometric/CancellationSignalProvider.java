package androidx.biometric;

import android.os.CancellationSignal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CancellationSignalProvider {
    private static final String TAG = "CancelSignalProvider";
    private CancellationSignal mBiometricCancellationSignal;
    private androidx.core.os.CancellationSignal mFingerprintCancellationSignal;
    private final Injector mInjector;

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static CancellationSignal create() {
            return new CancellationSignal();
        }

        public static void cancel(CancellationSignal r0) {
            r0.cancel();
        }
    }

    public interface Injector {
        CancellationSignal getBiometricCancellationSignal();

        androidx.core.os.CancellationSignal getFingerprintCancellationSignal();
    }

    public void cancel() {
        CancellationSignal r0 = this.mBiometricCancellationSignal;
        if (r0 != null) goto L15;
    L6:
        androidx.core.os.CancellationSignal r1 = this.mFingerprintCancellationSignal;
        if (r1 == null) goto L17;
        r1.cancel();     // Catch: NullPointerException -> L11
    L9:
        this.mFingerprintCancellationSignal = null;
        return;
    L17:
        return;
    L15:
        Api16Impl.cancel(r0);     // Catch: NullPointerException -> L12
    L5:
        this.mBiometricCancellationSignal = null;
        goto L6
    }

    public CancellationSignal getBiometricCancellationSignal() {
        if (this.mBiometricCancellationSignal != null) goto L6;
        this.mBiometricCancellationSignal = this.mInjector.getBiometricCancellationSignal();
    L6:
        return this.mBiometricCancellationSignal;
    }

    public androidx.core.os.CancellationSignal getFingerprintCancellationSignal() {
        if (this.mFingerprintCancellationSignal != null) goto L6;
        this.mFingerprintCancellationSignal = this.mInjector.getFingerprintCancellationSignal();
    L6:
        return this.mFingerprintCancellationSignal;
    }

    public CancellationSignalProvider() {
        this.mInjector = new AnonymousClass1(this);
    }

    public CancellationSignalProvider(Injector r1) {
        this.mInjector = r1;
    }
}
