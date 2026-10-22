package com.bytedance.locallife.groupon.struct.task;

import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ks6.b;
import ks6.c;
import ks6.d;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\bS\u0010TJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003J²\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0004\b&\u0010'J\t\u0010(\u001a\u00020\u0002HÖ\u0001J\t\u0010)\u001a\u00020\fHÖ\u0001J\u0013\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b0\u0010/R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b1\u0010/R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00104\u001a\u0004\b5\u00106R$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00104\u001a\u0004\b7\u00106\"\u0004\b8\u00109R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010:\u001a\u0004\b;\u0010\u000eR\u001c\u0010 \u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b<\u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010-\u001a\u0004\b=\u0010/\"\u0004\b>\u0010?R$\u0010\"\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010:\u001a\u0004\b\"\u0010\u000e\"\u0004\b@\u0010AR*\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR*\u0010$\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b$\u0010G\u0012\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskStruct;", "", "", "component1", "component2", "component3", "", "component4", "()Ljava/lang/Float;", "Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;", "component5", "component6", "", "component7", "()Ljava/lang/Integer;", "component8", "component9", "component10", "", "Lks6/c;", "component11", "Lks6/b;", "component12", "Lks6/d;", "component13", DBDefinition.TASK_ID, "uniqueKey", "taskType", "priority", "trigger", "destroyTrigger", "threadMode", "taskDelay", "data", "isLoopTask", "taskRunLogicConfig", "taskRunCheckConfig", "taskUiConfig", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lks6/b;Lks6/d;)Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskStruct;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTaskId", "()Ljava/lang/String;", "getUniqueKey", "getTaskType", "Ljava/lang/Float;", "getPriority", "Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;", "getTrigger", "()Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;", "getDestroyTrigger", "setDestroyTrigger", "(Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;)V", "Ljava/lang/Integer;", "getThreadMode", "getTaskDelay", "getData", "setData", "(Ljava/lang/String;)V", "setLoopTask", "(Ljava/lang/Integer;)V", "Ljava/util/List;", "getTaskRunLogicConfig", "()Ljava/util/List;", "setTaskRunLogicConfig", "(Ljava/util/List;)V", "Lks6/b;", "getTaskRunCheckConfig", "()Lks6/b;", "setTaskRunCheckConfig", "(Lks6/b;)V", "getTaskRunCheckConfig$annotations", "()V", "Lks6/d;", "getTaskUiConfig", "()Lks6/d;", "setTaskUiConfig", "(Lks6/d;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskTrigger;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lks6/b;Lks6/d;)V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class AtomicTaskStruct {

    @SerializedName("data")
    private String data;

    @SerializedName("destroy_trigger")
    private AtomicTaskTrigger destroyTrigger;

    @SerializedName("is_loop_task")
    private Integer isLoopTask;

    @SerializedName("priority")
    private final Float priority;

    @SerializedName("task_delay")
    private final Float taskDelay;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("task_run_check")
    private b taskRunCheckConfig;

    @SerializedName("task_run_logic")
    private List<c> taskRunLogicConfig;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final String taskType;

    @SerializedName("task_ui_config")
    private d taskUiConfig;

    @SerializedName(LynxEventReporter.PROP_NAME_THREAD_MODE)
    private final Integer threadMode;

    @SerializedName("trigger")
    private final AtomicTaskTrigger trigger;

    @SerializedName("unique_key")
    private final String uniqueKey;

    public AtomicTaskStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AtomicTaskStruct copy$default(AtomicTaskStruct r110, String r111, String r112, String r113, Float r114, AtomicTaskTrigger r115, AtomicTaskTrigger r210, Integer r211, Float r212, String r213, Integer r214, List r215, b r216, d r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = r110.taskId;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = r110.uniqueKey;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.taskType;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Float r103 = r110.priority;
    L19:
        if ((r218 & 16) == 0) goto L21;
        AtomicTaskTrigger r104 = r110.trigger;
    L23:
        if ((r218 & 32) == 0) goto L25;
        AtomicTaskTrigger r105 = r110.destroyTrigger;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Integer r106 = r110.threadMode;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Float r107 = r110.taskDelay;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r116 = r110.data;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Integer r117 = r110.isLoopTask;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        List r118 = r110.taskRunLogicConfig;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        b r119 = r110.taskRunCheckConfig;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        d r108 = r110.taskUiConfig;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @Deprecated(message = "task_run_check 已废弃，请使用 task_run_logic")
    public static /* synthetic */ void getTaskRunCheckConfig$annotations() {
    }

    public final String component1() {
        return this.taskId;
    }

    public final Integer component10() {
        return this.isLoopTask;
    }

    public final List<c> component11() {
        return this.taskRunLogicConfig;
    }

    public final b component12() {
        return this.taskRunCheckConfig;
    }

    public final d component13() {
        return this.taskUiConfig;
    }

    public final String component2() {
        return this.uniqueKey;
    }

    public final String component3() {
        return this.taskType;
    }

    public final Float component4() {
        return this.priority;
    }

    public final AtomicTaskTrigger component5() {
        return this.trigger;
    }

    public final AtomicTaskTrigger component6() {
        return this.destroyTrigger;
    }

    public final Integer component7() {
        return this.threadMode;
    }

    public final Float component8() {
        return this.taskDelay;
    }

    public final String component9() {
        return this.data;
    }

    public final AtomicTaskStruct copy(String r110, String r111, String r112, Float r113, AtomicTaskTrigger r210, AtomicTaskTrigger r211, Integer r212, Float r213, String r214, Integer r215, List<c> r216, b r217, d r218) {
        return new AtomicTaskStruct(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AtomicTaskStruct) == true) goto L8;
        return false;
    L8:
        AtomicTaskStruct r101 = (AtomicTaskStruct) r100;
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueKey, r101.uniqueKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskType, r101.taskType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.priority, r101.priority) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.trigger, r101.trigger) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.destroyTrigger, r101.destroyTrigger) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.threadMode, r101.threadMode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.taskDelay, r101.taskDelay) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isLoopTask, r101.isLoopTask) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.taskRunLogicConfig, r101.taskRunLogicConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.taskRunCheckConfig, r101.taskRunCheckConfig) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskUiConfig, r101.taskUiConfig) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.uniqueKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.priority;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        AtomicTaskTrigger r113 = this.trigger;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        AtomicTaskTrigger r116 = this.destroyTrigger;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.threadMode;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Float r122 = this.taskDelay;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.data;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.isLoopTask;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        List<c> r131 = this.taskRunLogicConfig;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        b r134 = this.taskRunCheckConfig;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        d r137 = this.taskUiConfig;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
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

    public String toString() {
        return "AtomicTaskStruct(taskId=" + this.taskId + ", uniqueKey=" + this.uniqueKey + ", taskType=" + this.taskType + ", priority=" + this.priority + ", trigger=" + this.trigger + ", destroyTrigger=" + this.destroyTrigger + ", threadMode=" + this.threadMode + ", taskDelay=" + this.taskDelay + ", data=" + this.data + ", isLoopTask=" + this.isLoopTask + ", taskRunLogicConfig=" + this.taskRunLogicConfig + ", taskRunCheckConfig=" + this.taskRunCheckConfig + ", taskUiConfig=" + this.taskUiConfig + ')';
    }

    public final String getData() {
        return this.data;
    }

    public final AtomicTaskTrigger getDestroyTrigger() {
        return this.destroyTrigger;
    }

    public final Float getPriority() {
        return this.priority;
    }

    public final Float getTaskDelay() {
        return this.taskDelay;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final b getTaskRunCheckConfig() {
        return this.taskRunCheckConfig;
    }

    public final List<c> getTaskRunLogicConfig() {
        return this.taskRunLogicConfig;
    }

    public final String getTaskType() {
        return this.taskType;
    }

    public final d getTaskUiConfig() {
        return this.taskUiConfig;
    }

    public final Integer getThreadMode() {
        return this.threadMode;
    }

    public final AtomicTaskTrigger getTrigger() {
        return this.trigger;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final Integer isLoopTask() {
        return this.isLoopTask;
    }

    public final void setData(String r100) {
        this.data = r100;
    }

    public final void setDestroyTrigger(AtomicTaskTrigger r100) {
        this.destroyTrigger = r100;
    }

    public final void setLoopTask(Integer r100) {
        this.isLoopTask = r100;
    }

    public final void setTaskRunCheckConfig(b r100) {
        this.taskRunCheckConfig = r100;
    }

    public final void setTaskRunLogicConfig(List<c> r100) {
        this.taskRunLogicConfig = r100;
    }

    public final void setTaskUiConfig(d r100) {
        this.taskUiConfig = r100;
    }

    public AtomicTaskStruct(String r100, String r101, String r102, Float r103, AtomicTaskTrigger r104, AtomicTaskTrigger r105, Integer r106, Float r107, String r108, Integer r110, List<c> r111, b r112, d r113) {
        this.taskId = r100;
        this.uniqueKey = r101;
        this.taskType = r102;
        this.priority = r103;
        this.trigger = r104;
        this.destroyTrigger = r105;
        this.threadMode = r106;
        this.taskDelay = r107;
        this.data = r108;
        this.isLoopTask = r110;
        this.taskRunLogicConfig = r111;
        this.taskRunCheckConfig = r112;
        this.taskUiConfig = r113;
    }

    public /* synthetic */ AtomicTaskStruct(String r110, String r111, String r112, Float r113, AtomicTaskTrigger r114, AtomicTaskTrigger r210, Integer r211, Float r212, String r213, Integer r214, List r215, b r216, d r217, int r218, DefaultConstructorMarker r219) {
        d r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r218 & 8) == 0) goto L17;
        Float r104 = null;
    L19:
        if ((r218 & 16) == 0) goto L21;
        AtomicTaskTrigger r105 = null;
    L23:
        if ((r218 & 32) == 0) goto L25;
        AtomicTaskTrigger r106 = null;
    L27:
        if ((r218 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r218 & 128) == 0) goto L33;
        Float r108 = null;
    L35:
        if ((r218 & 256) == 0) goto L37;
        String r115 = null;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Integer r116 = null;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        List r117 = null;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        b r118 = null;
    L51:
        if ((r218 & 4096) != 0) goto L54;
        r100 = r217;
    L54:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r115, r116, r117, r118, r100);
        return;
    L49:
        r118 = r216;
        goto L51
    L45:
        r117 = r215;
        goto L47
    L41:
        r116 = r214;
        goto L43
    L37:
        r115 = r213;
        goto L39
    L33:
        r108 = r212;
        goto L35
    L29:
        r107 = r211;
        goto L31
    L25:
        r106 = r210;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
