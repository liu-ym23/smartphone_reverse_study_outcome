package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class RaiseFunction extends Identifier implements ExpressionConvertible, ResultColumnConvertible {
    private static native long createCppObj();

    private static native void setAction(long r100, int r101, String r102);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 15;
    }

    public RaiseFunction ignore() {
        setAction(this.cppObj, 0, null);
        return this;
    }

    public RaiseFunction() {
        this.cppObj = createCppObj();
    }

    public RaiseFunction abort(String r100) {
        setAction(this.cppObj, 2, r100);
        return this;
    }

    public RaiseFunction fail(String r100) {
        setAction(this.cppObj, 3, r100);
        return this;
    }

    public RaiseFunction rollback(String r100) {
        setAction(this.cppObj, 1, r100);
        return this;
    }
}
