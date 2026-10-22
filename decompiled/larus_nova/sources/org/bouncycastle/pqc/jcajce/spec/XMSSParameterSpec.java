package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSParameterSpec implements AlgorithmParameterSpec {
    public static final String SHA256 = "SHA256";
    public static final XMSSParameterSpec SHA2_10_256 = null;
    public static final XMSSParameterSpec SHA2_10_512 = null;
    public static final XMSSParameterSpec SHA2_16_256 = null;
    public static final XMSSParameterSpec SHA2_16_512 = null;
    public static final XMSSParameterSpec SHA2_20_256 = null;
    public static final XMSSParameterSpec SHA2_20_512 = null;
    public static final String SHA512 = "SHA512";
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";
    public static final XMSSParameterSpec SHAKE_10_256 = null;
    public static final XMSSParameterSpec SHAKE_10_512 = null;
    public static final XMSSParameterSpec SHAKE_16_256 = null;
    public static final XMSSParameterSpec SHAKE_16_512 = null;
    public static final XMSSParameterSpec SHAKE_20_256 = null;
    public static final XMSSParameterSpec SHAKE_20_512 = null;
    private final int height;
    private final String treeDigest;

    static {
        SHA2_10_256 = new XMSSParameterSpec(10, "SHA256");
        SHA2_16_256 = new XMSSParameterSpec(16, "SHA256");
        SHA2_20_256 = new XMSSParameterSpec(20, "SHA256");
        SHAKE_10_256 = new XMSSParameterSpec(10, "SHAKE128");
        SHAKE_16_256 = new XMSSParameterSpec(16, "SHAKE128");
        SHAKE_20_256 = new XMSSParameterSpec(20, "SHAKE128");
        SHA2_10_512 = new XMSSParameterSpec(10, "SHA512");
        SHA2_16_512 = new XMSSParameterSpec(16, "SHA512");
        SHA2_20_512 = new XMSSParameterSpec(20, "SHA512");
        SHAKE_10_512 = new XMSSParameterSpec(10, "SHAKE256");
        SHAKE_16_512 = new XMSSParameterSpec(16, "SHAKE256");
        SHAKE_20_512 = new XMSSParameterSpec(20, "SHAKE256");
    }

    public XMSSParameterSpec(int r100, String r101) {
        this.height = r100;
        this.treeDigest = r101;
    }

    public int getHeight() {
        return this.height;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
