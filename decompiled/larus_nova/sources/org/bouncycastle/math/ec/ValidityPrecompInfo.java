package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes42.dex */
class ValidityPrecompInfo implements PreCompInfo {
    static final String PRECOMP_NAME = "bc_validity";
    private boolean curveEquationPassed;
    private boolean failed;
    private boolean orderPassed;

    public ValidityPrecompInfo() {
        this.failed = false;
        this.curveEquationPassed = false;
        this.orderPassed = false;
    }

    public boolean hasCurveEquationPassed() {
        return this.curveEquationPassed;
    }

    public boolean hasFailed() {
        return this.failed;
    }

    public boolean hasOrderPassed() {
        return this.orderPassed;
    }

    public void reportCurveEquationPassed() {
        this.curveEquationPassed = true;
    }

    public void reportFailed() {
        this.failed = true;
    }

    public void reportOrderPassed() {
        this.orderPassed = true;
    }
}
