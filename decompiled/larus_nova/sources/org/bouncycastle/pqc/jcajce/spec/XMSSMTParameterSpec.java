package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTParameterSpec implements AlgorithmParameterSpec {
    public static final String SHA256 = "SHA256";
    public static final String SHA512 = "SHA512";
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";
    public static final XMSSMTParameterSpec XMSSMT_SHA2_20d2_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_20d2_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_20d4_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_20d4_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d2_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d2_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d4_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d4_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d8_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_40d8_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d12_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d12_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d3_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d3_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d6_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHA2_60d6_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_20d2_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_20d2_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_20d4_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_20d4_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d2_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d2_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d4_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d4_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d8_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_40d8_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d12_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d12_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d3_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d3_512 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d6_256 = null;
    public static final XMSSMTParameterSpec XMSSMT_SHAKE_60d6_512 = null;
    private final int height;
    private final int layers;
    private final String treeDigest;

    static {
        XMSSMT_SHA2_20d2_256 = new XMSSMTParameterSpec(20, 2, "SHA256");
        XMSSMT_SHA2_20d4_256 = new XMSSMTParameterSpec(20, 4, "SHA256");
        XMSSMT_SHA2_40d2_256 = new XMSSMTParameterSpec(40, 2, "SHA256");
        XMSSMT_SHA2_40d4_256 = new XMSSMTParameterSpec(40, 4, "SHA256");
        XMSSMT_SHA2_40d8_256 = new XMSSMTParameterSpec(40, 8, "SHA256");
        XMSSMT_SHA2_60d3_256 = new XMSSMTParameterSpec(60, 3, "SHA256");
        XMSSMT_SHA2_60d6_256 = new XMSSMTParameterSpec(60, 6, "SHA256");
        XMSSMT_SHA2_60d12_256 = new XMSSMTParameterSpec(60, 12, "SHA256");
        XMSSMT_SHA2_20d2_512 = new XMSSMTParameterSpec(20, 2, "SHA512");
        XMSSMT_SHA2_20d4_512 = new XMSSMTParameterSpec(20, 4, "SHA512");
        XMSSMT_SHA2_40d2_512 = new XMSSMTParameterSpec(40, 2, "SHA512");
        XMSSMT_SHA2_40d4_512 = new XMSSMTParameterSpec(40, 4, "SHA512");
        XMSSMT_SHA2_40d8_512 = new XMSSMTParameterSpec(40, 8, "SHA512");
        XMSSMT_SHA2_60d3_512 = new XMSSMTParameterSpec(60, 3, "SHA512");
        XMSSMT_SHA2_60d6_512 = new XMSSMTParameterSpec(60, 6, "SHA512");
        XMSSMT_SHA2_60d12_512 = new XMSSMTParameterSpec(60, 12, "SHA512");
        XMSSMT_SHAKE_20d2_256 = new XMSSMTParameterSpec(20, 2, "SHAKE128");
        XMSSMT_SHAKE_20d4_256 = new XMSSMTParameterSpec(20, 4, "SHAKE128");
        XMSSMT_SHAKE_40d2_256 = new XMSSMTParameterSpec(40, 2, "SHAKE128");
        XMSSMT_SHAKE_40d4_256 = new XMSSMTParameterSpec(40, 4, "SHAKE128");
        XMSSMT_SHAKE_40d8_256 = new XMSSMTParameterSpec(40, 8, "SHAKE128");
        XMSSMT_SHAKE_60d3_256 = new XMSSMTParameterSpec(60, 3, "SHAKE128");
        XMSSMT_SHAKE_60d6_256 = new XMSSMTParameterSpec(60, 6, "SHAKE128");
        XMSSMT_SHAKE_60d12_256 = new XMSSMTParameterSpec(60, 12, "SHAKE128");
        XMSSMT_SHAKE_20d2_512 = new XMSSMTParameterSpec(20, 2, "SHAKE256");
        XMSSMT_SHAKE_20d4_512 = new XMSSMTParameterSpec(20, 4, "SHAKE256");
        XMSSMT_SHAKE_40d2_512 = new XMSSMTParameterSpec(40, 2, "SHAKE256");
        XMSSMT_SHAKE_40d4_512 = new XMSSMTParameterSpec(40, 4, "SHAKE256");
        XMSSMT_SHAKE_40d8_512 = new XMSSMTParameterSpec(40, 8, "SHAKE256");
        XMSSMT_SHAKE_60d3_512 = new XMSSMTParameterSpec(60, 3, "SHAKE256");
        XMSSMT_SHAKE_60d6_512 = new XMSSMTParameterSpec(60, 6, "SHAKE256");
        XMSSMT_SHAKE_60d12_512 = new XMSSMTParameterSpec(60, 12, "SHAKE256");
    }

    public XMSSMTParameterSpec(int r100, int r101, String r102) {
        this.height = r100;
        this.layers = r101;
        this.treeDigest = r102;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLayers() {
        return this.layers;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
