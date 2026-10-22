package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes42.dex */
public interface ConfigurableProvider {
    public static final String ACCEPTABLE_EC_CURVES = "acceptableEcCurves";
    public static final String ADDITIONAL_EC_PARAMETERS = "additionalEcParameters";
    public static final String DH_DEFAULT_PARAMS = "DhDefaultParams";
    public static final String EC_IMPLICITLY_CA = "ecImplicitlyCa";
    public static final String THREAD_LOCAL_DH_DEFAULT_PARAMS = "threadLocalDhDefaultParams";
    public static final String THREAD_LOCAL_EC_IMPLICITLY_CA = "threadLocalEcImplicitlyCa";

    void addAlgorithm(String r100, String r101);

    void addAlgorithm(String r100, ASN1ObjectIdentifier r101, String r102);

    void addAttributes(String r100, Map<String, String> r101);

    void addKeyInfoConverter(ASN1ObjectIdentifier r100, AsymmetricKeyInfoConverter r101);

    AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier r100);

    boolean hasAlgorithm(String r100, String r101);

    void setParameter(String r100, Object r101);
}
