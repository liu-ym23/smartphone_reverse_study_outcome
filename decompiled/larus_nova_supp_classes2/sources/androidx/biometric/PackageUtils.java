package androidx.biometric;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class PackageUtils {

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static boolean hasSystemFeatureFingerprint(PackageManager r1) {
            return r1.hasSystemFeature("android.hardware.fingerprint");
        }
    }

    private PackageUtils() {
    }

    public static boolean hasSystemFeatureFingerprint(Context r2) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        if (r2 == null) goto L10;
        if (r2.getPackageManager() == null) goto L10;
        if (Api23Impl.hasSystemFeatureFingerprint(r2.getPackageManager()) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
