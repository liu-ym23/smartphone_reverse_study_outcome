package t88;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\"\b\u0002\u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0013\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J#\u0010+\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0018\u00010\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0099\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000bHÖ\u0001J\t\u00104\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR0\u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/larus/avlink/aiproactive/model/UserAonTaskData;", "", DBDefinition.TASK_ID, "", "draftSlotList", "", "Lcom/larus/avlink/aiproactive/model/AonTaskDescriptionSlot;", "rawText", "", "polishedText", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "title", "descriptionText", "", "taskStatus", "reminderMethod", "imuTaskInfo", "Lcom/larus/avlink/aiproactive/model/IMUTaskInfo;", "<init>", "(JLjava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/Map;IILcom/larus/avlink/aiproactive/model/IMUTaskInfo;)V", "getTaskId", "()J", "getDraftSlotList", "()Ljava/util/List;", "getRawText", "()Ljava/lang/String;", "getPolishedText", "getSceneType", "()I", "getTitle", "getDescriptionText", "()Ljava/util/Map;", "getTaskStatus", "getReminderMethod", "getImuTaskInfo", "()Lcom/larus/avlink/aiproactive/model/IMUTaskInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class n {

    @SerializedName("description_text")
    private final Map<Integer, List<String>> descriptionText;

    @SerializedName("draft_slot_list")
    private final List<b> draftSlotList;

    @SerializedName("imu_task_info")
    private final k imuTaskInfo;

    @SerializedName("polished_text")
    private final String polishedText;

    @SerializedName("raw_text")
    private final String rawText;

    @SerializedName("reminder_method")
    private final int reminderMethod;

    @SerializedName("scene_type")
    private final int sceneType;

    @SerializedName("task_id")
    private final long taskId;

    @SerializedName("task_status")
    private final int taskStatus;

    @SerializedName("title")
    private final String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.taskId == r101.taskId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.draftSlotList, r101.draftSlotList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rawText, r101.rawText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.polishedText, r101.polishedText) == true) goto L21;
        return false;
    L21:
        if (this.sceneType == r101.sceneType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.descriptionText, r101.descriptionText) == true) goto L30;
        return false;
    L30:
        if (this.taskStatus == r101.taskStatus) goto L33;
        return false;
    L33:
        if (this.reminderMethod == r101.reminderMethod) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.imuTaskInfo, r101.imuTaskInfo) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r100 = this.taskId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<b> r102 = this.draftSlotList;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.rawText;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.polishedText;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (((r108 + r110) * 31) + this.sceneType) * 31;
        String r112 = this.title;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        Map<Integer, List<String>> r115 = this.descriptionText;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (((((r114 + r116) * 31) + this.taskStatus) * 31) + this.reminderMethod) * 31;
        k r118 = this.imuTaskInfo;
        if (r118 == null) goto L27;
        r103 = r118.hashCode();
    L27:
        return r117 + r103;
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserAonTaskData(taskId=" + this.taskId + ", draftSlotList=" + this.draftSlotList + ", rawText=" + this.rawText + ", polishedText=" + this.polishedText + ", sceneType=" + this.sceneType + ", title=" + this.title + ", descriptionText=" + this.descriptionText + ", taskStatus=" + this.taskStatus + ", reminderMethod=" + this.reminderMethod + ", imuTaskInfo=" + this.imuTaskInfo + ')';
    }

    public n() {
        this(0, null, null, null, 0, null, null, 2, 0, null);
    }

    public final Map<Integer, List<String>> b() {
        return this.descriptionText;
    }

    public final List<b> c() {
        return this.draftSlotList;
    }

    public final k d() {
        return this.imuTaskInfo;
    }

    public final String e() {
        return this.polishedText;
    }

    public final String f() {
        return this.rawText;
    }

    public final int g() {
        return this.reminderMethod;
    }

    public final int h() {
        return this.sceneType;
    }

    public final long i() {
        return this.taskId;
    }

    public final int j() {
        return this.taskStatus;
    }

    public final String k() {
        return this.title;
    }

    public static n a(n r110, int r111) {
        return new n(r110.taskId, r110.draftSlotList, r110.rawText, r110.polishedText, r110.sceneType, r110.title, r110.descriptionText, r111, r110.reminderMethod, r110.imuTaskInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(long r100, List<b> r101, String r102, String r103, int r104, String r105, Map<Integer, ? extends List<String>> r106, int r107, int r110, k r111) {
        this.taskId = r100;
        this.draftSlotList = r101;
        this.rawText = r102;
        this.polishedText = r103;
        this.sceneType = r104;
        this.title = r105;
        this.descriptionText = r106;
        this.taskStatus = r107;
        this.reminderMethod = r110;
        this.imuTaskInfo = r111;
    }
}
