package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class BindParameter extends Identifier implements ExpressionConvertible {
    public static final BindParameter _1 = null;
    public static final BindParameter _10 = null;
    public static final BindParameter _2 = null;
    public static final BindParameter _3 = null;
    public static final BindParameter _4 = null;
    public static final BindParameter _5 = null;
    public static final BindParameter _6 = null;
    public static final BindParameter _7 = null;
    public static final BindParameter _8 = null;
    public static final BindParameter _9 = null;
    public static final BindParameter def = null;

    private static native long atBindParameter(String r100);

    private static native long createCppObj(int r100);

    private static native long createCppObj(String r100);

    private static native long[] createCppObjs(int r100);

    private static native long dollarBindParameter(String r100);

    @Override // com.tencent.wcdb.winq.Identifier, com.tencent.wcdb.winq.IdentifierConvertible
    public Identifier asIdentifier() {
        return this;
    }

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 14;
    }

    static {
        def = new BindParameter(0);
        _1 = new BindParameter(1);
        _2 = new BindParameter(2);
        _3 = new BindParameter(3);
        _4 = new BindParameter(4);
        _5 = new BindParameter(5);
        _6 = new BindParameter(6);
        _7 = new BindParameter(7);
        _8 = new BindParameter(8);
        _9 = new BindParameter(9);
        _10 = new BindParameter(10);
    }

    private BindParameter() {
    }

    public BindParameter(int r100) {
        this.cppObj = createCppObj(r100);
    }

    public static BindParameter at(String r100) {
        BindParameter r101 = new BindParameter();
        r101.cppObj = atBindParameter(r100);
        return r101;
    }

    public static BindParameter[] bindParameters(int r100) {
        int r101 = 0;
        if (r100 == 0) goto L5;
        BindParameter[] r102 = new BindParameter[r100];
        long[] r103 = createCppObjs(r100);
    L7:
        if (r101 >= r100) goto L9;
        BindParameter r104 = new BindParameter();
        r102[r101] = r104;
        r104.cppObj = r103[r101];
        r101 = r101 + 1;
        goto L7
    L9:
        return r102;
    L5:
        return new BindParameter[0];
    }

    public static BindParameter colon(String r100) {
        return new BindParameter(r100);
    }

    public static BindParameter dollar(String r100) {
        BindParameter r101 = new BindParameter();
        r101.cppObj = dollarBindParameter(r100);
        return r101;
    }

    public BindParameter(String r100) {
        this.cppObj = createCppObj(r100);
    }
}
