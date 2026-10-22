package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes5.dex */
public class RegistrationPolicyAlwaysRegister extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {
    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void destroy() {
    }

    public RegistrationPolicyAlwaysRegister() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.RegistrationPolicy
    public void init(NetworkChangeNotifierAutoDetect r100) {
        super.init(r100);
        register();
    }
}
