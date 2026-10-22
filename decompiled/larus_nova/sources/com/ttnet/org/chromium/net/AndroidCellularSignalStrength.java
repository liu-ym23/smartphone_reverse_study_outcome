package com.ttnet.org.chromium.net;

import android.os.Build;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("net::android")
public class AndroidCellularSignalStrength {
    private static final AndroidCellularSignalStrength sInstance = null;
    private volatile int mSignalLevel;

    public class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final TelephonyManager mTelephonyManager;
        final /* synthetic */ AndroidCellularSignalStrength this$0;

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.access$002(this.this$0, Integer.MIN_VALUE);
            this.mTelephonyManager.listen(this, 0);
        }

        static {
        }

        public CellStateListener(AndroidCellularSignalStrength r100) {
            this.this$0 = r100;
            ThreadUtils.assertOnBackgroundThread();
            TelephonyManager r101 = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
            this.mTelephonyManager = r101;
            if (r101.getSimState() == 5) goto L5;
            return;
        L5:
            ApplicationStatus.registerApplicationStateListener(this);
            onApplicationStateChange(ApplicationStatus.getStateForApplication());
        }

        @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
        public void onApplicationStateChange(int r100) {
            if (r100 != 1) goto L6;
            register();
            return;
        L6:
            if (r100 != 2) goto L10;
            unregister();
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r100) {
            if (ApplicationStatus.getStateForApplication() == 1) goto L9;
            return;
        L9:
            AndroidCellularSignalStrength.access$002(this.this$0, r100.getLevel());     // Catch: SecurityException -> L7
            return;
        L7:
            AndroidCellularSignalStrength.access$002(this.this$0, Integer.MIN_VALUE);
        }
    }

    static {
        sInstance = new AndroidCellularSignalStrength();
    }

    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }

    private AndroidCellularSignalStrength() {
        this.mSignalLevel = Integer.MIN_VALUE;
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return;
    L6:
        if (TTAppSecurityManager.getInstance().isUserPrivacyRestrictionEnabled() == false) goto L8;
        return;
    L8:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("AndroidCellularSignalStrength");
        ThreadMethodProxy.start(r100);
        new Handler(r100.getLooper()).post(new AnonymousClass1(this));
    }

    public static /* synthetic */ int access$002(AndroidCellularSignalStrength r100, int r101) {
        r100.mSignalLevel = r101;
        return r101;
    }
}
