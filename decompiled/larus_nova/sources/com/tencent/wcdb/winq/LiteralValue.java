package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes41.dex */
public class LiteralValue extends Identifier implements ExpressionConvertible {
    private static native long createCppObj(int r100, long r101, double r102, String r103);

    private static native long createCurrentDate();

    private static native long createCurrentTime();

    private static native long createCurrentTimeStamp();

    @Override // com.tencent.wcdb.winq.Identifier, com.tencent.wcdb.winq.IdentifierConvertible
    public Identifier asIdentifier() {
        return this;
    }

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 12;
    }

    public static LiteralValue currentDate() {
        LiteralValue r100 = new LiteralValue();
        r100.cppObj = createCurrentDate();
        return r100;
    }

    public static LiteralValue currentTime() {
        LiteralValue r100 = new LiteralValue();
        r100.cppObj = createCurrentTime();
        return r100;
    }

    public static LiteralValue currentTimeStamp() {
        LiteralValue r100 = new LiteralValue();
        r100.cppObj = createCurrentTimeStamp();
        return r100;
    }

    private LiteralValue() {
    }

    public LiteralValue(String r100) {
        if (r100 != null) goto L5;
        this.cppObj = createCppObj(1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return;
    L5:
        this.cppObj = createCppObj(6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r100);
    }

    public LiteralValue(boolean r100) {
        if (r100 == false) goto L5;
        long r101 = 1;
    L6:
        this.cppObj = createCppObj(2, r101, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public LiteralValue(byte r100) {
        this.cppObj = createCppObj(3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }

    public LiteralValue(double r100) {
        this.cppObj = createCppObj(5, 0, r100, null);
    }

    public LiteralValue(float r100) {
        this.cppObj = createCppObj(5, 0, r100, null);
    }

    public LiteralValue(int r100) {
        this.cppObj = createCppObj(3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }

    public LiteralValue(long r100) {
        this.cppObj = createCppObj(3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }

    public LiteralValue(short r100) {
        this.cppObj = createCppObj(3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
    }
}
