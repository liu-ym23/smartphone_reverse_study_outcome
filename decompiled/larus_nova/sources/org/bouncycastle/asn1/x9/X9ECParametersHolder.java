package org.bouncycastle.asn1.x9;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X9ECParametersHolder {
    private X9ECParameters params;

    public X9ECParametersHolder() {
    }

    public abstract X9ECParameters createParameters();

    public synchronized X9ECParameters getParameters() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.params != null) goto L6;
        this.params = createParameters();     // Catch: Throwable -> L9
    L6:
        X9ECParameters r100 = this.params;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }
}
