package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class Identifier extends CppObject implements IdentifierConvertible {
    private static native String getDescription(long r100);

    public static native boolean isWriteStatement(long r100);

    public Identifier asIdentifier() {
        return this;
    }

    public int getType() {
        return 0;
    }

    public String getDescription() {
        return getDescription(this.cppObj);
    }

    public String toString() {
        return getDescription();
    }

    public Identifier() {
    }

    public static int getCppType(IdentifierConvertible r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return r100.asIdentifier().getType();
    }

    public static int getCppType(Identifier r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        return r100.getType();
    }
}
