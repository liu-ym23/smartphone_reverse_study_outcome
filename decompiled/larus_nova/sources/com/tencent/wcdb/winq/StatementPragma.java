package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementPragma extends Statement {
    private static native void configPragma(long r100, long r101);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configToValue(long r100, int r101, long r102, double r103, String r104);

    private static native void configWithValue(long r100, int r101, long r102, double r103, String r104);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 53;
    }

    public StatementPragma() {
        this.cppObj = createCppObj();
    }

    public StatementPragma of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementPragma pragma(Pragma r100) {
        configPragma(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementPragma toValue(String r110) {
        if (r110 == null) goto L5;
        configToValue(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        configToValue(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public StatementPragma withValue(String r110) {
        if (r110 == null) goto L5;
        configWithValue(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        configWithValue(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public StatementPragma of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementPragma toValue(boolean r100) {
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

    public StatementPragma withValue(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        configWithValue(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public StatementPragma toValue(byte r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma withValue(byte r100) {
        configWithValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma toValue(double r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementPragma withValue(double r100) {
        configWithValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementPragma toValue(float r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementPragma withValue(float r100) {
        configWithValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementPragma toValue(int r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma withValue(int r100) {
        configWithValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma toValue(long r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma withValue(long r100) {
        configWithValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma toValue(short r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementPragma withValue(short r100) {
        configWithValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }
}
