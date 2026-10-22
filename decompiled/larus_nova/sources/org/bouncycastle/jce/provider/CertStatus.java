package org.bouncycastle.jce.provider;

import java.util.Date;

/* JADX INFO: loaded from: classes42.dex */
class CertStatus {
    public static final int UNDETERMINED = 12;
    public static final int UNREVOKED = 11;
    int certStatus;
    Date revocationDate;

    public CertStatus() {
        this.certStatus = 11;
        this.revocationDate = null;
    }

    public int getCertStatus() {
        return this.certStatus;
    }

    public Date getRevocationDate() {
        return this.revocationDate;
    }

    public void setCertStatus(int r100) {
        this.certStatus = r100;
    }

    public void setRevocationDate(Date r100) {
        this.revocationDate = r100;
    }
}
