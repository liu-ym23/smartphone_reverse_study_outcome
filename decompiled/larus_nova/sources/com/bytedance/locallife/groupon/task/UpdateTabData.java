package com.bytedance.locallife.groupon.task;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/locallife/groupon/task/UpdateTabData;", "", "refreshCountdown", "", "refreshTabIds", "", "", "(JLjava/util/List;)V", "getRefreshCountdown", "()J", "getRefreshTabIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class UpdateTabData {

    @SerializedName("refresh_countdown")
    private final long refreshCountdown;

    @SerializedName("refresh_tab_ids")
    private final List<Integer> refreshTabIds;

    public UpdateTabData() {
        this(0, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateTabData copy$default(UpdateTabData r100, long r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.refreshCountdown;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.refreshTabIds;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.refreshCountdown;
    }

    public final List<Integer> component2() {
        return this.refreshTabIds;
    }

    public final UpdateTabData copy(long r100, List<Integer> r101) {
        return new UpdateTabData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateTabData) == true) goto L8;
        return false;
    L8:
        UpdateTabData r101 = (UpdateTabData) r100;
        if (this.refreshCountdown == r101.refreshCountdown) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refreshTabIds, r101.refreshTabIds) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.refreshCountdown;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<Integer> r102 = this.refreshTabIds;
        if (r102 != null) goto L5;
        int r103 = 0;
    L7:
        return r101 + r103;
    L5:
        r103 = r102.hashCode();
        goto L7
    }

    public String toString() {
        return "UpdateTabData(refreshCountdown=" + this.refreshCountdown + ", refreshTabIds=" + this.refreshTabIds + ')';
    }

    public final long getRefreshCountdown() {
        return this.refreshCountdown;
    }

    public final List<Integer> getRefreshTabIds() {
        return this.refreshTabIds;
    }

    public UpdateTabData(long r100, List<Integer> r101) {
        this.refreshCountdown = r100;
        this.refreshTabIds = r101;
    }

    public /* synthetic */ UpdateTabData(long r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
