package com.larus.bmhome.video;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/video/InteractInfo;", "", "status", "Lcom/larus/bmhome/video/InteractionStatus;", "statistic", "Lcom/larus/bmhome/video/InteractionStatistic;", "<init>", "(Lcom/larus/bmhome/video/InteractionStatus;Lcom/larus/bmhome/video/InteractionStatistic;)V", "getStatus", "()Lcom/larus/bmhome/video/InteractionStatus;", "getStatistic", "()Lcom/larus/bmhome/video/InteractionStatistic;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractInfo {

    @SerializedName("statistic")
    private final InteractionStatistic statistic;

    @SerializedName("status")
    private final InteractionStatus status;

    /* JADX WARN: Multi-variable type inference failed */
    public InteractInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InteractInfo copy$default(InteractInfo r100, InteractionStatus r101, InteractionStatistic r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.statistic;
    L9:
        return r100.copy(r101, r102);
    }

    public final InteractionStatus component1() {
        return this.status;
    }

    public final InteractionStatistic component2() {
        return this.statistic;
    }

    public final InteractInfo copy(InteractionStatus r100, InteractionStatistic r101) {
        return new InteractInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InteractInfo) == true) goto L8;
        return false;
    L8:
        InteractInfo r101 = (InteractInfo) r100;
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statistic, r101.statistic) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        InteractionStatus r100 = this.status;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        InteractionStatistic r104 = this.statistic;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "InteractInfo(status=" + this.status + ", statistic=" + this.statistic + ')';
    }

    public final InteractionStatistic getStatistic() {
        return this.statistic;
    }

    public final InteractionStatus getStatus() {
        return this.status;
    }

    public InteractInfo(InteractionStatus r100, InteractionStatistic r101) {
        this.status = r100;
        this.statistic = r101;
    }

    public /* synthetic */ InteractInfo(InteractionStatus r100, InteractionStatistic r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
