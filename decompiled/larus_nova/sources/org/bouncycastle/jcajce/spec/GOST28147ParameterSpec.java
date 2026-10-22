package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GOST28147ParameterSpec implements AlgorithmParameterSpec {
    private static Map oidMappings;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525388iv;
    private byte[] sBox;

    static {
        HashMap r100 = new HashMap();
        oidMappings = r100;
        r100.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
        oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
        oidMappings.put(RosstandartObjectIdentifiers.id_tc26_gost_28147_param_Z, "Param-Z");
    }

    public GOST28147ParameterSpec(String r100) {
        this.f525388iv = null;
        this.sBox = null;
        this.sBox = GOST28147Engine.getSBox(r100);
    }

    public GOST28147ParameterSpec(String r100, byte[] r101) {
        this(r100);
        byte[] r102 = new byte[r101.length];
        this.f525388iv = r102;
        System.arraycopy(r101, 0, r102, 0, r101.length);
    }

    public GOST28147ParameterSpec(ASN1ObjectIdentifier r100, byte[] r101) {
        this(getName(r100));
        this.f525388iv = Arrays.clone(r101);
    }

    public GOST28147ParameterSpec(byte[] r100) {
        this.f525388iv = null;
        this.sBox = null;
        byte[] r101 = new byte[r100.length];
        this.sBox = r101;
        System.arraycopy(r100, 0, r101, 0, r100.length);
    }

    public GOST28147ParameterSpec(byte[] r100, byte[] r101) {
        this(r100);
        byte[] r102 = new byte[r101.length];
        this.f525388iv = r102;
        System.arraycopy(r101, 0, r102, 0, r101.length);
    }

    private static String getName(ASN1ObjectIdentifier r100) {
        String r101 = (String) oidMappings.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("unknown OID: " + r100);
    }

    public byte[] getIV() {
        return Arrays.clone(this.f525388iv);
    }

    public byte[] getSBox() {
        return Arrays.clone(this.sBox);
    }

    public byte[] getSbox() {
        return Arrays.clone(this.sBox);
    }
}
