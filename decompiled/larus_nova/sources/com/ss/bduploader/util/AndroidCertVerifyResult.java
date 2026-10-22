package com.ss.bduploader.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class AndroidCertVerifyResult {
    private final List<X509Certificate> mCertificateChain;
    private final boolean mIsIssuedByKnownRoot;
    private final int mStatus;

    public byte[][] getCertificateChainEncoded() {
        byte[][] r100 = new byte[this.mCertificateChain.size()][];
        int r101 = 0;
    L10:
        if (r101 >= this.mCertificateChain.size()) goto L7;
        r100[r101] = ((X509Certificate) ListProtector.get(this.mCertificateChain, r101)).getEncoded();     // Catch: CertificateEncodingException -> L8
        r101 = r101 + 1;
        goto L10
    L7:
        return r100;
    L9:
        return new byte[0][];
    }

    public int getStatus() {
        return this.mStatus;
    }

    public boolean isIssuedByKnownRoot() {
        return this.mIsIssuedByKnownRoot;
    }

    public AndroidCertVerifyResult(int r100) {
        this.mStatus = r100;
        this.mIsIssuedByKnownRoot = false;
        this.mCertificateChain = Collections.emptyList();
    }

    public AndroidCertVerifyResult(int r100, boolean r101, List<X509Certificate> r102) {
        this.mStatus = r100;
        this.mIsIssuedByKnownRoot = r101;
        this.mCertificateChain = new ArrayList(r102);
    }
}
