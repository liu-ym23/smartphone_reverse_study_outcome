package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class ResultColumn extends Identifier implements ResultColumnConvertible {
    private static native void configAlias(long r100, String r101);

    private static native long createCppObj(int r100, long r101, String r102);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 29;
    }

    public ResultColumn(ResultColumnConvertible r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null);
    }

    public ResultColumn as(String r100) {
        configAlias(this.cppObj, r100);
        return this;
    }

    public ResultColumn(String r100) {
        this.cppObj = createCppObj(6, 0, r100);
    }

    public ResultColumn(long r100) {
        this.cppObj = r100;
    }
}
