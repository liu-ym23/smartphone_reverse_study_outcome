package t88;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JB\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/avlink/aiproactive/model/EditUserAonTaskRequest;", "", "doraSubBiz", "", DBDefinition.TASK_ID, "", "draftSlotList", "", "Lcom/larus/avlink/aiproactive/model/AonTaskDescriptionSlot;", "reminderMethod", "<init>", "(Ljava/lang/Integer;JLjava/util/List;I)V", "getDoraSubBiz", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskId", "()J", "getDraftSlotList", "()Ljava/util/List;", "getReminderMethod", "()I", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;JLjava/util/List;I)Lcom/larus/avlink/aiproactive/model/EditUserAonTaskRequest;", "equals", "", "other", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class h {

    @SerializedName("dora_sub_biz")
    private final Integer doraSubBiz;

    @SerializedName("draft_slot_list")
    private final List<b> draftSlotList;

    @SerializedName("reminder_method")
    private final int reminderMethod;

    @SerializedName("task_id")
    private final long taskId;

    public h() {
        this(0, null, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.doraSubBiz, r101.doraSubBiz) == true) goto L12;
        return false;
    L12:
        if (this.taskId == r101.taskId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.draftSlotList, r101.draftSlotList) == true) goto L18;
        return false;
    L18:
        if (this.reminderMethod == r101.reminderMethod) goto L20;
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
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        List<b> r105 = this.draftSlotList;
        if (r105 == null) goto L11;
        r101 = r105.hashCode();
    L11:
        return ((r104 + r101) * 31) + this.reminderMethod;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EditUserAonTaskRequest(doraSubBiz=" + this.doraSubBiz + ", taskId=" + this.taskId + ", draftSlotList=" + this.draftSlotList + ", reminderMethod=" + this.reminderMethod + ')';
    }

    public h(long r100, List r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        Integer r104 = 3;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r100 = 0;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = 0;
    L15:
        this.doraSubBiz = r104;
        this.taskId = r100;
        this.draftSlotList = r101;
        this.reminderMethod = r102;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
