package org.bouncycastle.crypto;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public class CryptoServicesPermission extends Permission {
    public static final String DEFAULT_RANDOM = "defaultRandomConfig";
    public static final String GLOBAL_CONFIG = "globalConfig";
    public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";
    private final Set<String> actions;

    public CryptoServicesPermission(String r100) {
        super(r100);
        HashSet r101 = new HashSet();
        this.actions = r101;
        r101.add(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CryptoServicesPermission) == true) goto L5;
        return false;
    L5:
        if (this.actions.equals(((CryptoServicesPermission) r100).actions) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.actions.toString();
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission r100) {
        if ((r100 instanceof CryptoServicesPermission) == false) goto L10;
        CryptoServicesPermission r101 = (CryptoServicesPermission) r100;
        if (getName().equals(r101.getName()) == false) goto L8;
        return true;
    L8:
        if (this.actions.containsAll(r101.actions) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
