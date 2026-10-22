package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class Schema extends Identifier {
    public static final Schema main = null;
    public static final Schema temp = null;

    private static native long createCppObj(String r100);

    private static native long createMainCppObj();

    private static native long createTempCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 8;
    }

    static {
        main = new Schema(createMainCppObj());
        temp = new Schema(createTempCppObj());
    }

    public Schema(String r100) {
        this.cppObj = createCppObj(r100);
    }

    public Schema(long r100) {
        this.cppObj = r100;
    }
}
