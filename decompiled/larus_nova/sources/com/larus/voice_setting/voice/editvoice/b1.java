package com.larus.voice_setting.voice.editvoice;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/voice_setting/voice/editvoice/VoicePitchAndRate;", "", "pitchF64", "", "speechRateF64", "<init>", "(FF)V", "getPitchF64", "()F", "getSpeechRateF64", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b1 {

    @SerializedName("pitch_f64")
    private final float pitchF64;

    @SerializedName("speech_rate_f64")
    private final float speechRateF64;

    public b1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Float.compare(this.pitchF64, r101.pitchF64) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.speechRateF64, r101.speechRateF64) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.pitchF64) * 31) + Float.floatToIntBits(this.speechRateF64);
    }

    public final String toString() {
        return "VoicePitchAndRate(pitchF64=" + this.pitchF64 + ", speechRateF64=" + this.speechRateF64 + ')';
    }

    public final float b() {
        return this.pitchF64;
    }

    public final float c() {
        return this.speechRateF64;
    }

    public /* synthetic */ b1(int r100) {
        this(0.0f, 1.0f);
    }

    public b1(float r100, float r101) {
        this.pitchF64 = r100;
        this.speechRateF64 = r101;
    }

    public static b1 a(b1 r100, float r101, float r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.pitchF64;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.speechRateF64;
    L9:
        return new b1(r101, r102);
    }
}
