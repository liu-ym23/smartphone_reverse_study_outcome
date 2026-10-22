package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
public class WNafPreCompInfo implements PreCompInfo {
    protected int confWidth;
    protected ECPoint[] preComp;
    protected ECPoint[] preCompNeg;
    volatile int promotionCountdown;
    protected ECPoint twice;
    protected int width;

    public WNafPreCompInfo() {
        this.promotionCountdown = 4;
        this.confWidth = -1;
        this.preComp = null;
        this.preCompNeg = null;
        this.twice = null;
        this.width = -1;
    }

    public int decrementPromotionCountdown() {
        int r100 = this.promotionCountdown;
        if (r100 <= 0) goto L6;
        int r101 = r100 - 1;
        this.promotionCountdown = r101;
        return r101;
    L6:
        return r100;
    }

    public int getConfWidth() {
        return this.confWidth;
    }

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint[] getPreCompNeg() {
        return this.preCompNeg;
    }

    public int getPromotionCountdown() {
        return this.promotionCountdown;
    }

    public ECPoint getTwice() {
        return this.twice;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPromoted() {
        if (this.promotionCountdown > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setConfWidth(int r100) {
        this.confWidth = r100;
    }

    public void setPreComp(ECPoint[] r100) {
        this.preComp = r100;
    }

    public void setPreCompNeg(ECPoint[] r100) {
        this.preCompNeg = r100;
    }

    public void setPromotionCountdown(int r100) {
        this.promotionCountdown = r100;
    }

    public void setTwice(ECPoint r100) {
        this.twice = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }
}
