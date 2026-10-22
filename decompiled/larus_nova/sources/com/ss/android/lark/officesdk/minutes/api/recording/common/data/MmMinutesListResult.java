package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMinutesListResult;", "Ljava/io/Serializable;", "list", "", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmMinutesListItem;", "hasMore", "", "<init>", "(Ljava/util/List;Z)V", "getList", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmMinutesListResult implements Serializable {
    private final boolean hasMore;
    private final List<MmMinutesListItem> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmMinutesListResult copy$default(MmMinutesListResult r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.list;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<MmMinutesListItem> component1() {
        return this.list;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final MmMinutesListResult copy(List<MmMinutesListItem> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        return new MmMinutesListResult(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmMinutesListResult) == true) goto L8;
        return false;
    L8:
        MmMinutesListResult r101 = (MmMinutesListResult) r100;
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.list.hashCode() * 31;
        if (this.hasMore == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "MmMinutesListResult(list=" + this.list + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<MmMinutesListItem> getList() {
        return this.list;
    }

    public MmMinutesListResult(List<MmMinutesListItem> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.list = r100;
        this.hasMore = r101;
    }
}
