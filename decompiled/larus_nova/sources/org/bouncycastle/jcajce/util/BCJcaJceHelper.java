package org.bouncycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes42.dex */
public class BCJcaJceHelper extends ProviderJcaJceHelper {
    private static volatile Provider bcProvider;

    public BCJcaJceHelper() {
        super(getBouncyCastleProvider());
    }

    private static synchronized Provider getBouncyCastleProvider() {
        monitor-enter(BCJcaJceHelper.class);
        Provider r100 = Security.getProvider("BC");     // Catch: Throwable -> L16
        if ((r100 instanceof BouncyCastleProvider) == false) goto L9;
        monitor-exit(BCJcaJceHelper.class);
        return r100;
    L9:
        if (bcProvider == null) goto L13;
        Provider r101 = bcProvider;     // Catch: Throwable -> L16
        monitor-exit(BCJcaJceHelper.class);
        return r101;
    L13:
        bcProvider = new BouncyCastleProvider();     // Catch: Throwable -> L16
        Provider r102 = bcProvider;     // Catch: Throwable -> L16
        monitor-exit(BCJcaJceHelper.class);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }
}
