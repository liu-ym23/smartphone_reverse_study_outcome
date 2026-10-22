package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class KeyguardUtils {

    public static class Api16Impl {
        private Api16Impl() {
        }

        public static boolean isKeyguardSecure(KeyguardManager r0) {
            return r0.isKeyguardSecure();
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static KeyguardManager getKeyguardManager(Context r1) {
            return (KeyguardManager) r1.getSystemService(KeyguardManager.class);
        }

        public static boolean isDeviceSecure(KeyguardManager r0) {
            return r0.isDeviceSecure();
        }
    }

    private KeyguardUtils() {
    }

    public static KeyguardManager getKeyguardManager(Context r2) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        Object r3 = r2.getSystemService("keyguard");
        if ((r3 instanceof KeyguardManager) == true) goto L11;
        return null;
    L11:
        return (KeyguardManager) r3;
    L5:
        return Api23Impl.getKeyguardManager(r2);
    }

    public static boolean isDeviceSecuredWithCredential(Context r2) {
        KeyguardManager r3 = getKeyguardManager(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        return Api23Impl.isDeviceSecure(r3);
    L11:
        return Api16Impl.isKeyguardSecure(r3);
    }
}
