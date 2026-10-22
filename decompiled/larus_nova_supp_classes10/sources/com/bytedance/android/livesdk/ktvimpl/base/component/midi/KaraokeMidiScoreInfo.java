package com.bytedance.android.livesdk.ktvimpl.base.component.midi;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u008b\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0004HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0010HÖ\u0001J\b\u00104\u001a\u000205H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiScoreInfo;", "", "()V", "sentenceScore", "", "songScore", "userPitch", "userNote", "userCent", "userOctave", "userFrequency", "refPitch", "refNote", "refCent", "refFrequency", "sentenceIndex", "", "timeMilliseconds", "(FFFFFFFFFFFIF)V", "getRefCent", "()F", "getRefFrequency", "getRefNote", "getRefPitch", "getSentenceIndex", "()I", "getSentenceScore", "getSongScore", "getTimeMilliseconds", "getUserCent", "getUserFrequency", "getUserNote", "getUserOctave", "getUserPitch", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeMidiScoreInfo {

    @SerializedName("refCent")
    private final float refCent;

    @SerializedName("refFrequency")
    private final float refFrequency;

    @SerializedName("refNote")
    private final float refNote;

    @SerializedName("refPitch")
    private final float refPitch;

    @SerializedName("sentenceIndex")
    private final int sentenceIndex;

    @SerializedName("sentenceScore")
    private final float sentenceScore;

    @SerializedName("songScore")
    private final float songScore;

    @SerializedName("timeMilliseconds")
    private final float timeMilliseconds;

    @SerializedName("userCent")
    private final float userCent;

    @SerializedName("userFrequency")
    private final float userFrequency;

    @SerializedName("userNote")
    private final float userNote;

    @SerializedName("userOctave")
    private final float userOctave;

    @SerializedName("userPitch")
    private final float userPitch;

    public KaraokeMidiScoreInfo() {
        this(0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, -1, 0.0f);
    }

    public static /* synthetic */ KaraokeMidiScoreInfo copy$default(KaraokeMidiScoreInfo r14, float r15, float r16, float r17, float r18, float r19, float r20, float r21, float r22, float r23, float r24, float r25, int r26, float r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        float r2 = r14.sentenceScore;
    L7:
        if ((r28 & 2) == 0) goto L9;
        float r3 = r14.songScore;
    L11:
        if ((r28 & 4) == 0) goto L13;
        float r4 = r14.userPitch;
    L15:
        if ((r28 & 8) == 0) goto L17;
        float r5 = r14.userNote;
    L19:
        if ((r28 & 16) == 0) goto L21;
        float r6 = r14.userCent;
    L23:
        if ((r28 & 32) == 0) goto L25;
        float r7 = r14.userOctave;
    L27:
        if ((r28 & 64) == 0) goto L29;
        float r8 = r14.userFrequency;
    L31:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        float r9 = r14.refPitch;
    L35:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        float r10 = r14.refNote;
    L39:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        float r11 = r14.refCent;
    L43:
        if ((r28 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        float r12 = r14.refFrequency;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        int r13 = r14.sentenceIndex;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        float r1 = r14.timeMilliseconds;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final float component1() {
        return this.sentenceScore;
    }

    public final float component10() {
        return this.refCent;
    }

    public final float component11() {
        return this.refFrequency;
    }

    public final int component12() {
        return this.sentenceIndex;
    }

    public final float component13() {
        return this.timeMilliseconds;
    }

    public final float component2() {
        return this.songScore;
    }

    public final float component3() {
        return this.userPitch;
    }

    public final float component4() {
        return this.userNote;
    }

    public final float component5() {
        return this.userCent;
    }

    public final float component6() {
        return this.userOctave;
    }

    public final float component7() {
        return this.userFrequency;
    }

    public final float component8() {
        return this.refPitch;
    }

    public final float component9() {
        return this.refNote;
    }

    public final KaraokeMidiScoreInfo copy(float r16, float r17, float r18, float r19, float r20, float r21, float r22, float r23, float r24, float r25, float r26, int r27, float r28) {
        return new KaraokeMidiScoreInfo(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof KaraokeMidiScoreInfo) == false) goto L32;
        KaraokeMidiScoreInfo r4 = (KaraokeMidiScoreInfo) r3;
        if (Float.compare(this.sentenceScore, r4.sentenceScore) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.songScore, r4.songScore) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.userPitch, r4.userPitch) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.userNote, r4.userNote) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.userCent, r4.userCent) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.userOctave, r4.userOctave) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.userFrequency, r4.userFrequency) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.refPitch, r4.refPitch) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.refNote, r4.refNote) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.refCent, r4.refCent) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.refFrequency, r4.refFrequency) == 0) goto L28;
        return false;
    L28:
        if (this.sentenceIndex == r4.sentenceIndex) goto L30;
        return false;
    L30:
        if (Float.compare(this.timeMilliseconds, r4.timeMilliseconds) == 0) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Float.floatToIntBits(this.sentenceScore) * 31) + Float.floatToIntBits(this.songScore)) * 31) + Float.floatToIntBits(this.userPitch)) * 31) + Float.floatToIntBits(this.userNote)) * 31) + Float.floatToIntBits(this.userCent)) * 31) + Float.floatToIntBits(this.userOctave)) * 31) + Float.floatToIntBits(this.userFrequency)) * 31) + Float.floatToIntBits(this.refPitch)) * 31) + Float.floatToIntBits(this.refNote)) * 31) + Float.floatToIntBits(this.refCent)) * 31) + Float.floatToIntBits(this.refFrequency)) * 31) + this.sentenceIndex) * 31) + Float.floatToIntBits(this.timeMilliseconds);
    }

    public String toString() {
        return "KaraokeMidiScoreInfo(sentenceScore=" + this.sentenceScore + ", songScore=" + this.songScore + ", userPitch=" + this.userPitch + ", userNote=" + this.userNote + ", userCent=" + this.userCent + ", userOctave=" + this.userOctave + ", userFrequency=" + this.userFrequency + ", refPitch=" + this.refPitch + ", refNote=" + this.refNote + ", refCent=" + this.refCent + ", refFrequency=" + this.refFrequency + ", sentenceIndex=" + this.sentenceIndex + ", timeMilliseconds=" + this.timeMilliseconds + ')';
    }

    public final float getRefCent() {
        return this.refCent;
    }

    public final float getRefFrequency() {
        return this.refFrequency;
    }

    public final float getRefNote() {
        return this.refNote;
    }

    public final float getRefPitch() {
        return this.refPitch;
    }

    public final int getSentenceIndex() {
        return this.sentenceIndex;
    }

    public final float getSentenceScore() {
        return this.sentenceScore;
    }

    public final float getSongScore() {
        return this.songScore;
    }

    public final float getTimeMilliseconds() {
        return this.timeMilliseconds;
    }

    public final float getUserCent() {
        return this.userCent;
    }

    public final float getUserFrequency() {
        return this.userFrequency;
    }

    public final float getUserNote() {
        return this.userNote;
    }

    public final float getUserOctave() {
        return this.userOctave;
    }

    public final float getUserPitch() {
        return this.userPitch;
    }

    public KaraokeMidiScoreInfo(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, int r12, float r13) {
        this.sentenceScore = r1;
        this.songScore = r2;
        this.userPitch = r3;
        this.userNote = r4;
        this.userCent = r5;
        this.userOctave = r6;
        this.userFrequency = r7;
        this.refPitch = r8;
        this.refNote = r9;
        this.refCent = r10;
        this.refFrequency = r11;
        this.sentenceIndex = r12;
        this.timeMilliseconds = r13;
    }
}
