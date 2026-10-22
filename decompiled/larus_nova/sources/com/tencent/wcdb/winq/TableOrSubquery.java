package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class TableOrSubquery extends Identifier implements TableOrSubqueryConvertible {
    private static native void argument(long r100, int r101, long r102, double r103, String r104);

    private static native void as(long r100, String r101);

    private static native long createCppObj(int r100, long r101, String r102);

    private static native long createCppObj(int r100, long[] r101, String[] r102);

    public static native long createWithFunction(String r100);

    private static native void indexedBy(long r100, String r101);

    private static native void notIndexed(long r100);

    private static native void schema(long r100, int r101, long r102, String r103);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 26;
    }

    public TableOrSubquery notIndexd() {
        notIndexed(this.cppObj);
        return this;
    }

    private TableOrSubquery() {
    }

    public TableOrSubquery(TableOrSubqueryConvertible... r100) {
        if (r100.length != 0) goto L6;
        this.cppObj = createCppObj(6, new long[0], null);
        return;
    L6:
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        this.cppObj = createCppObj(Identifier.getCppType(r100[0]), r101, null);
    }

    public static TableOrSubquery function(String r100) {
        TableOrSubquery r101 = new TableOrSubquery();
        r101.cppObj = createWithFunction(r100);
        return r101;
    }

    public TableOrSubquery argument(String r110) {
        if (r110 == null) goto L5;
        argument(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        argument(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public TableOrSubquery as(String r100) {
        as(this.cppObj, r100);
        return this;
    }

    public TableOrSubquery indexedBy(String r100) {
        indexedBy(this.cppObj, r100);
        return this;
    }

    public TableOrSubquery schema(Schema r100) {
        schema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public TableOrSubquery(TableOrSubqueryConvertible r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null);
    }

    public TableOrSubquery argument(ExpressionConvertible r100) {
        argument(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public TableOrSubquery schema(String r100) {
        schema(this.cppObj, 6, 0, r100);
        return this;
    }

    public TableOrSubquery(String r100) {
        this.cppObj = createCppObj(6, 0, r100);
    }

    public TableOrSubquery argument(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        argument(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public TableOrSubquery(String... r100) {
        this.cppObj = createCppObj(6, null, r100);
    }

    public TableOrSubquery argument(byte r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public TableOrSubquery argument(double r100) {
        argument(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public TableOrSubquery argument(float r100) {
        argument(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public TableOrSubquery argument(int r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public TableOrSubquery argument(long r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public TableOrSubquery argument(short r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }
}
