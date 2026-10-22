package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ApplicationStatus;

/* JADX INFO: loaded from: classes6.dex */
public class RegistrationPolicyApplicationStatus extends NetworkChangeNotifierAutoDetect.RegistrationPolicy implements ApplicationStatus.ApplicationStateListener {
    private boolean mDestroyed;

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        ApplicationStatus.unregisterApplicationStateListener(this);
        this.mDestroyed = true;
    }

    public RegistrationPolicyApplicationStatus() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect r100) {
        super.init(r100);
        ApplicationStatus.registerApplicationStateListener(this);
        onApplicationStateChange(0);
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int r100) {
        if (ApplicationStatus.hasVisibleActivities() == false) goto L5;
        register();
        return;
    L5:
        unregister();
    }
}
