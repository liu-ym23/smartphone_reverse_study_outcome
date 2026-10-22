package com.larus.livetutor.impl.rtc.interfaces;

import com.larus.livetutor.api.idl.AudioExtraV2;
import com.larus.livetutor.api.idl.ClearSubtitleMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/livetutor/impl/rtc/interfaces/SubtitleStream;", "", "audioExtra", "Lcom/larus/livetutor/api/idl/AudioExtraV2;", "clearSubtitleMsg", "Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/AudioExtraV2;Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;)V", "getAudioExtra", "()Lcom/larus/livetutor/api/idl/AudioExtraV2;", "getClearSubtitleMsg", "()Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubtitleStream {
    private final AudioExtraV2 audioExtra;
    private final ClearSubtitleMsg clearSubtitleMsg;

    /* JADX WARN: Multi-variable type inference failed */
    public SubtitleStream() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SubtitleStream copy$default(SubtitleStream r100, AudioExtraV2 r101, ClearSubtitleMsg r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.audioExtra;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.clearSubtitleMsg;
    L9:
        return r100.copy(r101, r102);
    }

    public final AudioExtraV2 component1() {
        return this.audioExtra;
    }

    public final ClearSubtitleMsg component2() {
        return this.clearSubtitleMsg;
    }

    public final SubtitleStream copy(AudioExtraV2 r100, ClearSubtitleMsg r101) {
        return new SubtitleStream(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SubtitleStream) == true) goto L8;
        return false;
    L8:
        SubtitleStream r101 = (SubtitleStream) r100;
        if (Intrinsics.areEqual(this.audioExtra, r101.audioExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clearSubtitleMsg, r101.clearSubtitleMsg) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AudioExtraV2 r100 = this.audioExtra;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        ClearSubtitleMsg r104 = this.clearSubtitleMsg;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SubtitleStream(audioExtra=" + this.audioExtra + ", clearSubtitleMsg=" + this.clearSubtitleMsg + ')';
    }

    public final AudioExtraV2 getAudioExtra() {
        return this.audioExtra;
    }

    public final ClearSubtitleMsg getClearSubtitleMsg() {
        return this.clearSubtitleMsg;
    }

    public SubtitleStream(AudioExtraV2 r100, ClearSubtitleMsg r101) {
        this.audioExtra = r100;
        this.clearSubtitleMsg = r101;
    }

    public /* synthetic */ SubtitleStream(AudioExtraV2 r100, ClearSubtitleMsg r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
