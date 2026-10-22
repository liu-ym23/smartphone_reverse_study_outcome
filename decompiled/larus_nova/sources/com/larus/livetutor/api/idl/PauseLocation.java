package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/livetutor/api/idl/PauseLocation;", "Ljava/io/Serializable;", "lastTutorPartId", "", "lastTtsAudioIdx", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getLastTutorPartId", "()Ljava/lang/Long;", "setLastTutorPartId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLastTtsAudioIdx", "setLastTtsAudioIdx", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/livetutor/api/idl/PauseLocation;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PauseLocation implements Serializable {

    @SerializedName("last_tts_audio_idx")
    private Long lastTtsAudioIdx;

    @SerializedName("last_tutor_part_id")
    private Long lastTutorPartId;

    /* JADX WARN: Multi-variable type inference failed */
    public PauseLocation() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PauseLocation copy$default(PauseLocation r100, Long r101, Long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lastTutorPartId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.lastTtsAudioIdx;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.lastTutorPartId;
    }

    public final Long component2() {
        return this.lastTtsAudioIdx;
    }

    public final PauseLocation copy(Long r100, Long r101) {
        return new PauseLocation(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PauseLocation) == true) goto L8;
        return false;
    L8:
        PauseLocation r101 = (PauseLocation) r100;
        if (Intrinsics.areEqual(this.lastTutorPartId, r101.lastTutorPartId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lastTtsAudioIdx, r101.lastTtsAudioIdx) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.lastTutorPartId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.lastTtsAudioIdx;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PauseLocation(lastTutorPartId=" + this.lastTutorPartId + ", lastTtsAudioIdx=" + this.lastTtsAudioIdx + ')';
    }

    public final Long getLastTtsAudioIdx() {
        return this.lastTtsAudioIdx;
    }

    public final Long getLastTutorPartId() {
        return this.lastTutorPartId;
    }

    public final void setLastTtsAudioIdx(Long r100) {
        this.lastTtsAudioIdx = r100;
    }

    public final void setLastTutorPartId(Long r100) {
        this.lastTutorPartId = r100;
    }

    public PauseLocation(Long r100, Long r101) {
        this.lastTutorPartId = r100;
        this.lastTtsAudioIdx = r101;
    }

    public /* synthetic */ PauseLocation(Long r100, Long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
