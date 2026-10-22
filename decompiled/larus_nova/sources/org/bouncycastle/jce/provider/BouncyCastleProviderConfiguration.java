package org.bouncycastle.jce.provider;

import java.security.Permission;
import java.security.spec.DSAParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    private static Permission BC_ADDITIONAL_EC_CURVE_PERMISSION;
    private static Permission BC_DH_LOCAL_PERMISSION;
    private static Permission BC_DH_PERMISSION;
    private static Permission BC_EC_CURVE_PERMISSION;
    private static Permission BC_EC_LOCAL_PERMISSION;
    private static Permission BC_EC_PERMISSION;
    private volatile Set acceptableNamedCurves;
    private volatile Map additionalECParameters;
    private volatile Object dhDefaultParams;
    private ThreadLocal dhThreadSpec;
    private volatile ECParameterSpec ecImplicitCaParams;
    private ThreadLocal ecThreadSpec;

    static {
        BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
        BC_EC_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.EC_IMPLICITLY_CA);
        BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS);
        BC_DH_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.DH_DEFAULT_PARAMS);
        BC_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.ACCEPTABLE_EC_CURVES);
        BC_ADDITIONAL_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", ConfigurableProvider.ADDITIONAL_EC_PARAMETERS);
    }

    public BouncyCastleProviderConfiguration() {
        this.ecThreadSpec = new ThreadLocal();
        this.dhThreadSpec = new ThreadLocal();
        this.acceptableNamedCurves = new HashSet();
        this.additionalECParameters = new HashMap();
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Set getAcceptableNamedCurves() {
        return Collections.unmodifiableSet(this.acceptableNamedCurves);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Map getAdditionalECParameters() {
        return Collections.unmodifiableMap(this.additionalECParameters);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public DHParameterSpec getDHDefaultParameters(int r100) {
        Object r101 = this.dhThreadSpec.get();
        if (r101 != null) goto L6;
        r101 = this.dhDefaultParams;
    L6:
        if ((r101 instanceof DHParameterSpec) == false) goto L11;
        DHParameterSpec r102 = (DHParameterSpec) r101;
        if (r102.getP().bitLength() != r100) goto L20;
        return r102;
    L20:
        DHParameters r103 = (DHParameters) CryptoServicesRegistrar.getSizedProperty(CryptoServicesRegistrar.Property.DH_DEFAULT_PARAMS, r100);
        if (r103 != null) goto L23;
        return null;
    L23:
        return new DHDomainParameterSpec(r103);
    L11:
        if ((r101 instanceof DHParameterSpec[]) == false) goto L20;
        DHParameterSpec[] r104 = (DHParameterSpec[]) r101;
        int r105 = 0;
    L14:
        if (r105 == r104.length) goto L20;
        if (r104[r105].getP().bitLength() == r100) goto L18;
        r105 = r105 + 1;
        goto L14
    L18:
        return r104[r105];
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public DSAParameterSpec getDSADefaultParameters(int r100) {
        DSAParameters r101 = (DSAParameters) CryptoServicesRegistrar.getSizedProperty(CryptoServicesRegistrar.Property.DSA_DEFAULT_PARAMS, r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return new DSAParameterSpec(r101.getP(), r101.getQ(), r101.getG());
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec r100 = (ECParameterSpec) this.ecThreadSpec.get();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.ecImplicitCaParams;
    }

    public void setParameter(String r100, Object r101) {
        SecurityManager r102 = System.getSecurityManager();
        if (r100.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA) == false) goto L17;
        if (r102 == null) goto L7;
        r102.checkPermission(BC_EC_LOCAL_PERMISSION);
    L7:
        if ((r101 instanceof ECParameterSpec) == true) goto L11;
        if (r101 == null) goto L11;
        ECParameterSpec r103 = EC5Util.convertSpec((java.security.spec.ECParameterSpec) r101);
    L12:
        if (r103 != null) goto L15;
        ThreadLocal r104 = this.ecThreadSpec;
    L14:
        r104.remove();
        return;
    L15:
        this.ecThreadSpec.set(r103);
        return;
    L11:
        r103 = (ECParameterSpec) r101;
        goto L12
    L17:
        if (r100.equals(ConfigurableProvider.EC_IMPLICITLY_CA) == false) goto L27;
        if (r102 == null) goto L21;
        r102.checkPermission(BC_EC_PERMISSION);
    L21:
        if ((r101 instanceof ECParameterSpec) == true) goto L25;
        if (r101 == null) goto L25;
        this.ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec) r101);
        return;
    L25:
        this.ecImplicitCaParams = (ECParameterSpec) r101;
        return;
    L27:
        if (r100.equals(ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS) == false) goto L43;
        if (r102 == null) goto L31;
        r102.checkPermission(BC_DH_LOCAL_PERMISSION);
    L31:
        if ((r101 instanceof DHParameterSpec) == false) goto L33;
    L38:
        r104 = this.dhThreadSpec;
        if (r101 == null) goto L14;
        r104.set(r101);
        return;
    L33:
        if ((r101 instanceof DHParameterSpec[]) == true) goto L38;
        if (r101 == null) goto L38;
        throw new IllegalArgumentException("not a valid DHParameterSpec");
    L43:
        if (r100.equals(ConfigurableProvider.DH_DEFAULT_PARAMS) == false) goto L56;
        if (r102 == null) goto L47;
        r102.checkPermission(BC_DH_PERMISSION);
    L47:
        if ((r101 instanceof DHParameterSpec) == false) goto L49;
    L54:
        this.dhDefaultParams = r101;
        return;
    L49:
        if ((r101 instanceof DHParameterSpec[]) == true) goto L54;
        if (r101 == null) goto L54;
        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
    L56:
        if (r100.equals(ConfigurableProvider.ACCEPTABLE_EC_CURVES) == false) goto L61;
        if (r102 == null) goto L59;
        r102.checkPermission(BC_EC_CURVE_PERMISSION);
    L59:
        this.acceptableNamedCurves = (Set) r101;
        return;
    L61:
        if (r100.equals(ConfigurableProvider.ADDITIONAL_EC_PARAMETERS) == false) goto L73;
        if (r102 == null) goto L64;
        r102.checkPermission(BC_ADDITIONAL_EC_CURVE_PERMISSION);
    L64:
        this.additionalECParameters = (Map) r101;
        return;
    }
}
