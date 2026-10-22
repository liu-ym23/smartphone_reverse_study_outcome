package t88;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J$\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/avlink/aiproactive/model/DeleteUserAonTaskRequest;", "", "doraSubBiz", "", DBDefinition.TASK_ID, "", "<init>", "(Ljava/lang/Integer;J)V", "getDoraSubBiz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskId", "()J", "component1", "component2", "copy", "(Ljava/lang/Integer;J)Lcom/larus/avlink/aiproactive/model/DeleteUserAonTaskRequest;", "equals", "", "other", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("dora_sub_biz")
    private final Integer doraSubBiz;

    @SerializedName("task_id")
    private final long taskId;

    public g() {
        this(0, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.doraSubBiz, r101.doraSubBiz) == true) goto L12;
        return false;
    L12:
        if (this.taskId == r101.taskId) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.doraSubBiz;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.taskId;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeleteUserAonTaskRequest(doraSubBiz=" + this.doraSubBiz + ", taskId=" + this.taskId + ')';
    }

    public g(long r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        Integer r102 = 3;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = 0;
    L9:
        this.doraSubBiz = r102;
        this.taskId = r100;
        return;
    L5:
        r102 = null;
        goto L7
    }
}
