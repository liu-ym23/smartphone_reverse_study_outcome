package com.larus.im.internal.jni.media;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/im/internal/jni/media/OmniAudioFormat;", "", SubInfo.KEY_FORMAT, "Lcom/larus/im/internal/jni/media/OmniAudioFormatType;", "sampleRate", "", "channels", "<init>", "(Lcom/larus/im/internal/jni/media/OmniAudioFormatType;II)V", "getFormat", "()Lcom/larus/im/internal/jni/media/OmniAudioFormatType;", "getSampleRate", "()I", "getChannels", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "omnisdk-av_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniAudioFormat {
    private final int channels;
    private final OmniAudioFormatType format;
    private final int sampleRate;

    public static /* synthetic */ OmniAudioFormat copy$default(OmniAudioFormat r100, OmniAudioFormatType r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.format;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.sampleRate;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.channels;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final OmniAudioFormatType component1() {
        return this.format;
    }

    public final int component2() {
        return this.sampleRate;
    }

    public final int component3() {
        return this.channels;
    }

    public final OmniAudioFormat copy(OmniAudioFormatType r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        return new OmniAudioFormat(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OmniAudioFormat) == true) goto L8;
        return false;
    L8:
        OmniAudioFormat r101 = (OmniAudioFormat) r100;
        if (this.format == r101.format) goto L12;
        return false;
    L12:
        if (this.sampleRate == r101.sampleRate) goto L15;
        return false;
    L15:
        if (this.channels == r101.channels) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.format.hashCode() * 31) + this.sampleRate) * 31) + this.channels;
    }

    public String toString() {
        return "OmniAudioFormat(format=" + this.format + ", sampleRate=" + this.sampleRate + ", channels=" + this.channels + ')';
    }

    public final int getChannels() {
        return this.channels;
    }

    public final OmniAudioFormatType getFormat() {
        return this.format;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    public OmniAudioFormat(OmniAudioFormatType r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        this.format = r100;
        this.sampleRate = r101;
        this.channels = r102;
    }
}
