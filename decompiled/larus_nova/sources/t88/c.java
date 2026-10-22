package t88;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/larus/avlink/aiproactive/model/ChangeUserAonTaskStatusRequest;", "", "doraSubBiz", "", DBDefinition.TASK_ID, "", "status", "imuCapability", "Lcom/larus/avlink/aiproactive/model/ImuCapability;", "<init>", "(Ljava/lang/Integer;JILcom/larus/avlink/aiproactive/model/ImuCapability;)V", "getDoraSubBiz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskId", "()J", "getStatus", "()I", "getImuCapability", "()Lcom/larus/avlink/aiproactive/model/ImuCapability;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;JILcom/larus/avlink/aiproactive/model/ImuCapability;)Lcom/larus/avlink/aiproactive/model/ChangeUserAonTaskStatusRequest;", "equals", "", "other", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("dora_sub_biz")
    private final Integer doraSubBiz;

    @SerializedName("imu_capability")
    private final l imuCapability;

    @SerializedName("status")
    private final int status;

    @SerializedName("task_id")
    private final long taskId;

    public c() {
        this(0, 0, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.doraSubBiz, r101.doraSubBiz) == true) goto L12;
        return false;
    L12:
        if (this.taskId == r101.taskId) goto L15;
        return false;
    L15:
        if (this.status == r101.status) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imuCapability, r101.imuCapability) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.doraSubBiz;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        long r103 = this.taskId;
        int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.status) * 31;
        l r105 = this.imuCapability;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return r104 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChangeUserAonTaskStatusRequest(doraSubBiz=" + this.doraSubBiz + ", taskId=" + this.taskId + ", status=" + this.status + ", imuCapability=" + this.imuCapability + ')';
    }

    public c(long r100, int r101, l r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        Integer r104 = 3;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r100 = 0;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = 0;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        this.doraSubBiz = r104;
        this.taskId = r100;
        this.status = r101;
        this.imuCapability = r102;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
