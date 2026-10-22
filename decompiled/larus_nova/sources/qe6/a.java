package qe6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/policy/model/trace/CombineValidateCost;", "", "taskCount", "", "totalCost", "", "localCost", "remoteCost", "<init>", "(IJJJ)V", "getTaskCount", "()I", "getTotalCost", "()J", "getLocalCost", "getRemoteCost", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "policy-engine_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("local_cost")
    private final long localCost;

    @SerializedName("remote_cost")
    private final long remoteCost;

    @SerializedName("task_count")
    private final int taskCount;

    @SerializedName("total_cost")
    private final long totalCost;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.taskCount == r101.taskCount) goto L12;
        return false;
    L12:
        if (this.totalCost == r101.totalCost) goto L15;
        return false;
    L15:
        if (this.localCost == r101.localCost) goto L18;
        return false;
    L18:
        if (this.remoteCost == r101.remoteCost) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.taskCount * 31;
        long r101 = this.totalCost;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.localCost;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.remoteCost;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public final String toString() {
        return "CombineValidateCost(taskCount=" + this.taskCount + ", totalCost=" + this.totalCost + ", localCost=" + this.localCost + ", remoteCost=" + this.remoteCost + ')';
    }

    public a(int r100, long r101, long r102, long r103) {
        this.taskCount = r100;
        this.totalCost = r101;
        this.localCost = r102;
        this.remoteCost = r103;
    }
}
