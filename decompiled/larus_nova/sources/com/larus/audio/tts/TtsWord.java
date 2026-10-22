package com.larus.audio.tts;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/larus/audio/tts/TtsWord;", "Ljava/io/Serializable;", EffectConfiguration.KEY_SEARCH_WORD, "", DyPayConstant.KEY_START_TIME, "", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "getWord", "()Ljava/lang/String;", "getStartTime", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEndTime", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)Lcom/larus/audio/tts/TtsWord;", "equals", "", "other", "", "hashCode", "", "toString", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsWord implements Serializable {

    @SerializedName("end_time")
    private final Float endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Float startTime;

    @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
    private final String word;

    public TtsWord() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TtsWord copy$default(TtsWord r100, String r101, Float r102, Float r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.word;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.startTime;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.endTime;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.word;
    }

    public final Float component2() {
        return this.startTime;
    }

    public final Float component3() {
        return this.endTime;
    }

    public final TtsWord copy(String r100, Float r101, Float r102) {
        return new TtsWord(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtsWord) == true) goto L8;
        return false;
    L8:
        TtsWord r101 = (TtsWord) r100;
        if (Intrinsics.areEqual(this.word, r101.word) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.word;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.startTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.endTime;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TtsWord(word=" + this.word + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public final Float getEndTime() {
        return this.endTime;
    }

    public final Float getStartTime() {
        return this.startTime;
    }

    public final String getWord() {
        return this.word;
    }

    public TtsWord(String r100, Float r101, Float r102) {
        this.word = r100;
        this.startTime = r101;
        this.endTime = r102;
    }

    public /* synthetic */ TtsWord(String r100, Float r101, Float r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Float.valueOf(0.0f);
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = Float.valueOf(0.0f);
    L11:
        this(r100, r101, r102);
    }
}
