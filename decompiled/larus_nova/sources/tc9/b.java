package tc9;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006("}, d2 = {"Lcom/larus/im/bean/AppFrameworkTaskCenterTaskRuntimeChangePush;", "", "taskInstanceId", "", "taskMetaId", "taskReferenceId", "createTimeUs", "", "version", "commonParam", "Lcom/google/gson/JsonObject;", "updateData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)V", "getTaskInstanceId", "()Ljava/lang/String;", "getTaskMetaId", "getTaskReferenceId", "getCreateTimeUs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVersion", "getCommonParam", "()Lcom/google/gson/JsonObject;", "getUpdateData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;)Lcom/larus/im/bean/AppFrameworkTaskCenterTaskRuntimeChangePush;", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("common_param")
    private final JsonObject commonParam;

    @SerializedName("create_time_us")
    private final Long createTimeUs;

    @SerializedName("task_instance_id")
    private final String taskInstanceId;

    @SerializedName("task_meta_id")
    private final String taskMetaId;

    @SerializedName("task_reference_id")
    private final String taskReferenceId;

    @SerializedName("update_data")
    private final JsonObject updateData;

    @SerializedName("version")
    private final Long version;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.taskInstanceId, r101.taskInstanceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskMetaId, r101.taskMetaId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskReferenceId, r101.taskReferenceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.createTimeUs, r101.createTimeUs) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.commonParam, r101.commonParam) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.updateData, r101.updateData) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.taskInstanceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.taskMetaId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskReferenceId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.createTimeUs;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.version;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        JsonObject r116 = this.commonParam;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        JsonObject r119 = this.updateData;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppFrameworkTaskCenterTaskRuntimeChangePush(taskInstanceId=" + this.taskInstanceId + ", taskMetaId=" + this.taskMetaId + ", taskReferenceId=" + this.taskReferenceId + ", createTimeUs=" + this.createTimeUs + ", version=" + this.version + ", commonParam=" + this.commonParam + ", updateData=" + this.updateData + ')';
    }

    public b() {
        this.taskInstanceId = null;
        this.taskMetaId = null;
        this.taskReferenceId = null;
        this.createTimeUs = 0L;
        this.version = null;
        this.commonParam = null;
        this.updateData = null;
    }

    public final String a() {
        return this.taskInstanceId;
    }

    public final String b() {
        return this.taskReferenceId;
    }

    public final JsonObject c() {
        return this.updateData;
    }

    public final Long d() {
        return this.version;
    }
}
