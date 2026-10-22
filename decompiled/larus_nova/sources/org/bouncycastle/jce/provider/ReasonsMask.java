package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.x509.ReasonFlags;

/* JADX INFO: loaded from: classes42.dex */
class ReasonsMask {
    static final ReasonsMask allReasons = null;
    private int _reasons;

    static {
        allReasons = new ReasonsMask(33023);
    }

    public ReasonsMask() {
        this(0);
    }

    private ReasonsMask(int r100) {
        this._reasons = r100;
    }

    public ReasonsMask(ReasonFlags r100) {
        this._reasons = r100.intValue();
    }

    public void addReasons(ReasonsMask r100) {
        int r101 = this._reasons;
        this._reasons = r100.getReasons() | r101;
    }

    public int getReasons() {
        return this._reasons;
    }

    public boolean hasNewReasons(ReasonsMask r100) {
        int r101 = this._reasons;
        if (((r100.getReasons() ^ this._reasons) | r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ReasonsMask intersect(ReasonsMask r100) {
        ReasonsMask r101 = new ReasonsMask();
        int r102 = this._reasons;
        r101.addReasons(new ReasonsMask(r100.getReasons() & r102));
        return r101;
    }

    public boolean isAllReasons() {
        if (this._reasons != allReasons._reasons) goto L5;
        return true;
    L5:
        return false;
    }
}
