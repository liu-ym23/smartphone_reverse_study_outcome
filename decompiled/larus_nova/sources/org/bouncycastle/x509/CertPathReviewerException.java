package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocalizedException;

/* JADX INFO: loaded from: classes42.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;
    private int index;

    public CertPathReviewerException(ErrorBundle r100) {
        super(r100);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle r100, Throwable r101) {
        super(r100, r101);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(ErrorBundle r100, Throwable r101, CertPath r102, int r103) {
        super(r100, r101);
        this.index = -1;
        this.certPath = null;
        if (r102 == null) goto L13;
        if (r103 == (-1)) goto L13;
        if (r103 < (-1)) goto L11;
        if (r103 >= r102.getCertificates().size()) goto L11;
        this.certPath = r102;
        this.index = r103;
        return;
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new IllegalArgumentException();
    }

    public CertPathReviewerException(ErrorBundle r100, CertPath r101, int r102) {
        super(r100);
        this.index = -1;
        this.certPath = null;
        if (r101 == null) goto L13;
        if (r102 == (-1)) goto L13;
        if (r102 < (-1)) goto L11;
        if (r102 >= r101.getCertificates().size()) goto L11;
        this.certPath = r101;
        this.index = r102;
        return;
    L11:
        throw new IndexOutOfBoundsException();
    L13:
        throw new IllegalArgumentException();
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
