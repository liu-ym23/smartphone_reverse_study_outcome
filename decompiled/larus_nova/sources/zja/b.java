package zja;

import com.google.gson.annotations.SerializedName;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R0\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lzja/b;", "", "", "taskType", "I", "getTaskType", "()I", "", DBDefinition.TASK_ID, "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "instruct", "getInstruct", "setInstruct", "shortInstruct", "getShortInstruct", "setShortInstruct", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "setTaskMode", "(Ljava/lang/Integer;)V", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "setTaskKnowledge", "(Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;)V", "src", "getSrc", "setSrc", "", "isTryRun", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setTryRun", "(Ljava/lang/Boolean;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class b {

    @SerializedName("ext")
    private Map<String, String> ext;

    @SerializedName("instruct")
    private String instruct;

    @SerializedName("isTryRun")
    private Boolean isTryRun;

    @SerializedName("shortInstruct")
    private String shortInstruct;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    @SerializedName("src")
    private Integer f572552src;

    @SerializedName(DBDefinition.TASK_ID)
    private String taskId;

    @SerializedName("taskKnowledge")
    private TaskKnowledge taskKnowledge;

    @SerializedName("taskMode")
    private Integer taskMode;

    @SerializedName("taskType")
    private final int taskType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.taskType == r101.taskType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.instruct, r101.instruct) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shortInstruct, r101.shortInstruct) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskMode, r101.taskMode) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskKnowledge, r101.taskKnowledge) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f572552src, r101.f572552src) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.isTryRun, r101.isTryRun) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.taskType * 31;
        String r101 = this.taskId;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.instruct;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.shortInstruct;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.taskMode;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        TaskKnowledge r114 = this.taskKnowledge;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f572552src;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        Boolean r120 = this.isTryRun;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Map<String, String> r123 = this.ext;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "EventTaskInfo(taskType=" + this.taskType + ", taskId=" + this.taskId + ", instruct=" + this.instruct + ", shortInstruct=" + this.shortInstruct + ", taskMode=" + this.taskMode + ", taskKnowledge=" + this.taskKnowledge + ", src=" + this.f572552src + ", isTryRun=" + this.isTryRun + ", ext=" + this.ext + ')';
    }
}
