package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class Upsert extends Identifier {
    private static native void configDoNothing(long r100);

    private static native void configDoUpdate(long r100);

    private static native void configIndexedColumn(long r100, int r101, long[] r102, String[] r103);

    private static native void configSetColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configToValue(long r100, int r101, long r102, double r103, String r104);

    private static native void configWhere(long r100, long r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 23;
    }

    public Upsert onConflict() {
        return this;
    }

    public Upsert doNoThing() {
        configDoNothing(this.cppObj);
        return this;
    }

    public Upsert doUpdate() {
        configDoUpdate(this.cppObj);
        return this;
    }

    public Upsert() {
        this.cppObj = createCppObj();
    }

    public Upsert indexedBy(IndexedColumnConvertible... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        configIndexedColumn(this.cppObj, Identifier.getCppType(r100[0]), r101, null);
        return this;
    }

    public Upsert set(Column... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        configSetColumns(this.cppObj, Identifier.getCppType(r100[0]), r101, null);
        return this;
    }

    public Upsert to(String r110) {
        if (r110 == null) goto L5;
        configToValue(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        configToValue(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public Upsert where(Expression r100) {
        configWhere(this.cppObj, CppObject.get(r100));
        return this;
    }

    public Upsert indexedBy(String... r100) {
        configIndexedColumn(this.cppObj, 6, null, r100);
        return this;
    }

    public Upsert set(String... r100) {
        configSetColumns(this.cppObj, 6, null, r100);
        return this;
    }

    public Upsert to(ExpressionConvertible r100) {
        configToValue(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Upsert to(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        configToValue(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public Upsert to(byte r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Upsert to(double r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Upsert to(float r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Upsert to(int r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Upsert to(long r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Upsert to(short r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }
}
