package com.larus.im.internal.jni.media;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006."}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioEngineConfig;", "", "uniqueId", "", "mode", "Lcom/larus/im/internal/jni/media/OmniAudioEngineMode;", "sourceFormat", "Lcom/larus/im/internal/jni/media/OmniAudioFormat;", "outputFormat", "sampleInterval", "", "chunkSize", "", "recordAmplitudeScene", "Lcom/larus/im/internal/jni/media/OmniAudioAmplitudeScene;", "playAmplitudeScene", "<init>", "(Ljava/lang/String;Lcom/larus/im/internal/jni/media/OmniAudioEngineMode;Lcom/larus/im/internal/jni/media/OmniAudioFormat;Lcom/larus/im/internal/jni/media/OmniAudioFormat;FILcom/larus/im/internal/jni/media/OmniAudioAmplitudeScene;Lcom/larus/im/internal/jni/media/OmniAudioAmplitudeScene;)V", "getUniqueId", "()Ljava/lang/String;", "getMode", "()Lcom/larus/im/internal/jni/media/OmniAudioEngineMode;", "getSourceFormat", "()Lcom/larus/im/internal/jni/media/OmniAudioFormat;", "getOutputFormat", "getSampleInterval", "()F", "getChunkSize", "()I", "getRecordAmplitudeScene", "()Lcom/larus/im/internal/jni/media/OmniAudioAmplitudeScene;", "getPlayAmplitudeScene", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioEngineConfig {
    private final int chunkSize;
    private final OmniAudioEngineMode mode;
    private final OmniAudioFormat outputFormat;
    private final OmniAudioAmplitudeScene playAmplitudeScene;
    private final OmniAudioAmplitudeScene recordAmplitudeScene;
    private final float sampleInterval;
    private final OmniAudioFormat sourceFormat;
    private final String uniqueId;

    public static /* synthetic */ OmniAudioEngineConfig copy$default(OmniAudioEngineConfig r100, String r110, OmniAudioEngineMode r111, OmniAudioFormat r112, OmniAudioFormat r113, float r114, int r115, OmniAudioAmplitudeScene r116, OmniAudioAmplitudeScene r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.uniqueId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        OmniAudioEngineMode r102 = r100.mode;
    L11:
        if ((r118 & 4) == 0) goto L13;
        OmniAudioFormat r103 = r100.sourceFormat;
    L15:
        if ((r118 & 8) == 0) goto L17;
        OmniAudioFormat r104 = r100.outputFormat;
    L19:
        if ((r118 & 16) == 0) goto L21;
        float r105 = r100.sampleInterval;
    L23:
        if ((r118 & 32) == 0) goto L25;
        int r106 = r100.chunkSize;
    L27:
        if ((r118 & 64) == 0) goto L29;
        OmniAudioAmplitudeScene r107 = r100.recordAmplitudeScene;
    L31:
        if ((r118 & 128) == 0) goto L33;
        OmniAudioAmplitudeScene r108 = r100.playAmplitudeScene;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.uniqueId;
    }

    public final OmniAudioEngineMode component2() {
        return this.mode;
    }

    public final OmniAudioFormat component3() {
        return this.sourceFormat;
    }

    public final OmniAudioFormat component4() {
        return this.outputFormat;
    }

    public final float component5() {
        return this.sampleInterval;
    }

    public final int component6() {
        return this.chunkSize;
    }

    public final OmniAudioAmplitudeScene component7() {
        return this.recordAmplitudeScene;
    }

    public final OmniAudioAmplitudeScene component8() {
        return this.playAmplitudeScene;
    }

    public final OmniAudioEngineConfig copy(String r110, OmniAudioEngineMode r111, OmniAudioFormat r112, OmniAudioFormat r113, float r114, int r115, OmniAudioAmplitudeScene r116, OmniAudioAmplitudeScene r117) {
        Intrinsics.checkNotNullParameter(r110, "uniqueId");
        Intrinsics.checkNotNullParameter(r111, "mode");
        Intrinsics.checkNotNullParameter(r112, "sourceFormat");
        Intrinsics.checkNotNullParameter(r113, "outputFormat");
        Intrinsics.checkNotNullParameter(r116, "recordAmplitudeScene");
        Intrinsics.checkNotNullParameter(r117, "playAmplitudeScene");
        return new OmniAudioEngineConfig(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAudioEngineConfig) == true) goto L8;
        return false;
    L8:
        OmniAudioEngineConfig r101 = (OmniAudioEngineConfig) r100;
        if (Intrinsics.areEqual(this.uniqueId, r101.uniqueId) == true) goto L12;
        return false;
    L12:
        if (this.mode == r101.mode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceFormat, r101.sourceFormat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.outputFormat, r101.outputFormat) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.sampleInterval, r101.sampleInterval) == 0) goto L24;
        return false;
    L24:
        if (this.chunkSize == r101.chunkSize) goto L27;
        return false;
    L27:
        if (this.recordAmplitudeScene == r101.recordAmplitudeScene) goto L30;
        return false;
    L30:
        if (this.playAmplitudeScene == r101.playAmplitudeScene) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((this.uniqueId.hashCode() * 31) + this.mode.hashCode()) * 31) + this.sourceFormat.hashCode()) * 31) + this.outputFormat.hashCode()) * 31) + Float.floatToIntBits(this.sampleInterval)) * 31) + this.chunkSize) * 31) + this.recordAmplitudeScene.hashCode()) * 31) + this.playAmplitudeScene.hashCode();
    }

    public String toString() {
        return "OmniAudioEngineConfig(uniqueId=" + this.uniqueId + ", mode=" + this.mode + ", sourceFormat=" + this.sourceFormat + ", outputFormat=" + this.outputFormat + ", sampleInterval=" + this.sampleInterval + ", chunkSize=" + this.chunkSize + ", recordAmplitudeScene=" + this.recordAmplitudeScene + ", playAmplitudeScene=" + this.playAmplitudeScene + ')';
    }

    public final int getChunkSize() {
        return this.chunkSize;
    }

    public final OmniAudioEngineMode getMode() {
        return this.mode;
    }

    public final OmniAudioFormat getOutputFormat() {
        return this.outputFormat;
    }

    public final OmniAudioAmplitudeScene getPlayAmplitudeScene() {
        return this.playAmplitudeScene;
    }

    public final OmniAudioAmplitudeScene getRecordAmplitudeScene() {
        return this.recordAmplitudeScene;
    }

    public final float getSampleInterval() {
        return this.sampleInterval;
    }

    public final OmniAudioFormat getSourceFormat() {
        return this.sourceFormat;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public OmniAudioEngineConfig(String r100, OmniAudioEngineMode r101, OmniAudioFormat r102, OmniAudioFormat r103, float r104, int r105, OmniAudioAmplitudeScene r106, OmniAudioAmplitudeScene r107) {
        Intrinsics.checkNotNullParameter(r100, "uniqueId");
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r102, "sourceFormat");
        Intrinsics.checkNotNullParameter(r103, "outputFormat");
        Intrinsics.checkNotNullParameter(r106, "recordAmplitudeScene");
        Intrinsics.checkNotNullParameter(r107, "playAmplitudeScene");
        this.uniqueId = r100;
        this.mode = r101;
        this.sourceFormat = r102;
        this.outputFormat = r103;
        this.sampleInterval = r104;
        this.chunkSize = r105;
        this.recordAmplitudeScene = r106;
        this.playAmplitudeScene = r107;
    }

    public /* synthetic */ OmniAudioEngineConfig(String r110, OmniAudioEngineMode r111, OmniAudioFormat r112, OmniAudioFormat r113, float r114, int r115, OmniAudioAmplitudeScene r116, OmniAudioAmplitudeScene r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 16) == 0) goto L5;
        float r100 = 0.1f;
    L7:
        if ((r118 & 32) == 0) goto L9;
        int r101 = 640;
    L10:
        this(r110, r111, r112, r113, r100, r101, r116, r117);
        return;
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
