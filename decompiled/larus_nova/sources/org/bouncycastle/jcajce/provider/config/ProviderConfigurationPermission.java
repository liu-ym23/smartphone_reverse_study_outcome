package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class ProviderConfigurationPermission extends BasicPermission {
    private static final int ACCEPTABLE_EC_CURVES = 16;
    private static final String ACCEPTABLE_EC_CURVES_STR = "acceptableeccurves";
    private static final int ADDITIONAL_EC_PARAMETERS = 32;
    private static final String ADDITIONAL_EC_PARAMETERS_STR = "additionalecparameters";
    private static final int ALL = 63;
    private static final String ALL_STR = "all";
    private static final int DH_DEFAULT_PARAMS = 8;
    private static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
    private static final int EC_IMPLICITLY_CA = 2;
    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    private static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
    private static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
    private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    private final String actions;
    private final int permissionMask;

    public ProviderConfigurationPermission(String r100) {
        super(r100);
        this.actions = "all";
        this.permissionMask = 63;
    }

    public ProviderConfigurationPermission(String r100, String r101) {
        super(r100, r101);
        this.actions = r101;
        this.permissionMask = calculateMask(r101);
    }

    private int calculateMask(String r100) {
        StringTokenizer r101 = new StringTokenizer(Strings.toLowerCase(r100), " ,");
        int r102 = 0;
    L4:
        if (r101.hasMoreTokens() == false) goto L26;
        String r103 = r101.nextToken();
        if (r103.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR) == true) goto L7;
        if (r103.equals(EC_IMPLICITLY_CA_STR) == true) goto L10;
        if (r103.equals(THREAD_LOCAL_DH_DEFAULT_PARAMS_STR) == true) goto L13;
        if (r103.equals(DH_DEFAULT_PARAMS_STR) == true) goto L16;
        if (r103.equals(ACCEPTABLE_EC_CURVES_STR) == true) goto L19;
        if (r103.equals(ADDITIONAL_EC_PARAMETERS_STR) == true) goto L22;
        if (r103.equals("all") == false) goto L4;
        r102 = r102 | 63;
        goto L4
    L22:
        r102 = r102 | 32;
        goto L4
    L19:
        r102 = r102 | 16;
        goto L4
    L16:
        r102 = r102 | 8;
        goto L4
    L13:
        r102 = r102 | 4;
        goto L4
    L10:
        r102 = r102 | 2;
        goto L4
    L7:
        r102 = r102 | 1;
        goto L4
    L26:
        if (r102 == 0) goto L29;
        return r102;
    L29:
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProviderConfigurationPermission) == false) goto L14;
        ProviderConfigurationPermission r101 = (ProviderConfigurationPermission) r100;
        if (this.permissionMask == r101.permissionMask) goto L10;
    L12:
        return false;
    L10:
        if (getName().equals(r101.getName()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.actions;
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission r100) {
        if ((r100 instanceof ProviderConfigurationPermission) == true) goto L6;
        return false;
    L6:
        if (getName().equals(r100.getName()) == true) goto L8;
        return false;
    L8:
        int r101 = this.permissionMask;
        int r102 = ((ProviderConfigurationPermission) r100).permissionMask;
        if ((r101 & r102) != r102) goto L12;
        return true;
    L12:
        return false;
    }
}
