package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "Ljava/io/Serializable;", "partInTutorIdx", "", "liveTutorSubtitles", "", "Lcom/larus/livetutor/api/idl/LiveTutorSubtitle;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "getPartInTutorIdx", "()Ljava/lang/Long;", "setPartInTutorIdx", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLiveTutorSubtitles", "()Ljava/util/List;", "setLiveTutorSubtitles", "(Ljava/util/List;)V", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lcom/larus/livetutor/api/idl/ClearSubtitleMsg;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearSubtitleMsg implements Serializable {

    @SerializedName("live_tutor_subtitles")
    private List<LiveTutorSubtitle> liveTutorSubtitles;

    @SerializedName("part_in_tutor_idx")
    private Long partInTutorIdx;

    /* JADX WARN: Multi-variable type inference failed */
    public ClearSubtitleMsg() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClearSubtitleMsg copy$default(ClearSubtitleMsg r100, Long r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.partInTutorIdx;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.liveTutorSubtitles;
    L9:
        return r100.copy(r101, r102);
    }

    public final Long component1() {
        return this.partInTutorIdx;
    }

    public final List<LiveTutorSubtitle> component2() {
        return this.liveTutorSubtitles;
    }

    public final ClearSubtitleMsg copy(Long r100, List<LiveTutorSubtitle> r101) {
        return new ClearSubtitleMsg(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ClearSubtitleMsg) == true) goto L8;
        return false;
    L8:
        ClearSubtitleMsg r101 = (ClearSubtitleMsg) r100;
        if (Intrinsics.areEqual(this.partInTutorIdx, r101.partInTutorIdx) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveTutorSubtitles, r101.liveTutorSubtitles) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r100 = this.partInTutorIdx;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<LiveTutorSubtitle> r104 = this.liveTutorSubtitles;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ClearSubtitleMsg(partInTutorIdx=" + this.partInTutorIdx + ", liveTutorSubtitles=" + this.liveTutorSubtitles + ')';
    }

    public final List<LiveTutorSubtitle> getLiveTutorSubtitles() {
        return this.liveTutorSubtitles;
    }

    public final Long getPartInTutorIdx() {
        return this.partInTutorIdx;
    }

    public final void setLiveTutorSubtitles(List<LiveTutorSubtitle> r100) {
        this.liveTutorSubtitles = r100;
    }

    public final void setPartInTutorIdx(Long r100) {
        this.partInTutorIdx = r100;
    }

    public ClearSubtitleMsg(Long r100, List<LiveTutorSubtitle> r101) {
        this.partInTutorIdx = r100;
        this.liveTutorSubtitles = r101;
    }

    public /* synthetic */ ClearSubtitleMsg(Long r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
