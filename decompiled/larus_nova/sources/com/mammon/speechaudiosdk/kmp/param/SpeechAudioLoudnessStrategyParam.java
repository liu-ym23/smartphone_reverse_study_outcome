package com.mammon.speechaudiosdk.kmp.param;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/mammon/speechaudiosdk/kmp/param/SpeechAudioLoudnessStrategyParam;", "", "metaData", "", "deviceAiData", "audioDumpPath", "loudNormAlgoType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMetaData", "()Ljava/lang/String;", "setMetaData", "(Ljava/lang/String;)V", "getDeviceAiData", "setDeviceAiData", "getAudioDumpPath", "setAudioDumpPath", "getLoudNormAlgoType", "()I", "setLoudNormAlgoType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "speech_audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpeechAudioLoudnessStrategyParam {
    private String audioDumpPath;
    private String deviceAiData;
    private int loudNormAlgoType;
    private String metaData;

    public SpeechAudioLoudnessStrategyParam() {
        this(null, null, null, 0, 15, null);
    }

    public static /* synthetic */ SpeechAudioLoudnessStrategyParam copy$default(SpeechAudioLoudnessStrategyParam r100, String r101, String r102, String r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.metaData;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.deviceAiData;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.audioDumpPath;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.loudNormAlgoType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.metaData;
    }

    public final String component2() {
        return this.deviceAiData;
    }

    public final String component3() {
        return this.audioDumpPath;
    }

    public final int component4() {
        return this.loudNormAlgoType;
    }

    public final SpeechAudioLoudnessStrategyParam copy(String r100, String r101, String r102, int r103) {
        return new SpeechAudioLoudnessStrategyParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpeechAudioLoudnessStrategyParam) == true) goto L8;
        return false;
    L8:
        SpeechAudioLoudnessStrategyParam r101 = (SpeechAudioLoudnessStrategyParam) r100;
        if (Intrinsics.areEqual(this.metaData, r101.metaData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceAiData, r101.deviceAiData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioDumpPath, r101.audioDumpPath) == true) goto L18;
        return false;
    L18:
        if (this.loudNormAlgoType == r101.loudNormAlgoType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.metaData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.deviceAiData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.audioDumpPath;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.loudNormAlgoType;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SpeechAudioLoudnessStrategyParam(metaData=" + this.metaData + ", deviceAiData=" + this.deviceAiData + ", audioDumpPath=" + this.audioDumpPath + ", loudNormAlgoType=" + this.loudNormAlgoType + ')';
    }

    public final String getAudioDumpPath() {
        return this.audioDumpPath;
    }

    public final String getDeviceAiData() {
        return this.deviceAiData;
    }

    public final int getLoudNormAlgoType() {
        return this.loudNormAlgoType;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final void setAudioDumpPath(String r100) {
        this.audioDumpPath = r100;
    }

    public final void setDeviceAiData(String r100) {
        this.deviceAiData = r100;
    }

    public final void setLoudNormAlgoType(int r100) {
        this.loudNormAlgoType = r100;
    }

    public final void setMetaData(String r100) {
        this.metaData = r100;
    }

    public SpeechAudioLoudnessStrategyParam(String r100, String r101, String r102, int r103) {
        this.metaData = r100;
        this.deviceAiData = r101;
        this.audioDumpPath = r102;
        this.loudNormAlgoType = r103;
    }

    public /* synthetic */ SpeechAudioLoudnessStrategyParam(String r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
