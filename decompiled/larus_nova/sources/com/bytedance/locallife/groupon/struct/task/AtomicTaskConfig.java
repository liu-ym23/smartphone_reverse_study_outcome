package com.bytedance.locallife.groupon.struct.task;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskConfig;", "", "tasks", "", "Lcom/bytedance/locallife/groupon/struct/task/AtomicTaskStruct;", "blackTaskList", "", "(Ljava/util/List;Ljava/util/List;)V", "getBlackTaskList", "()Ljava/util/List;", "getTasks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AtomicTaskConfig {

    @SerializedName("block_task_list")
    private final List<String> blackTaskList;

    @SerializedName("tasks")
    private final List<AtomicTaskStruct> tasks;

    /* JADX WARN: Multi-variable type inference failed */
    public AtomicTaskConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AtomicTaskConfig copy$default(AtomicTaskConfig r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.tasks;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.blackTaskList;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<AtomicTaskStruct> component1() {
        return this.tasks;
    }

    public final List<String> component2() {
        return this.blackTaskList;
    }

    public final AtomicTaskConfig copy(List<AtomicTaskStruct> r100, List<String> r101) {
        return new AtomicTaskConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AtomicTaskConfig) == true) goto L8;
        return false;
    L8:
        AtomicTaskConfig r101 = (AtomicTaskConfig) r100;
        if (Intrinsics.areEqual(this.tasks, r101.tasks) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blackTaskList, r101.blackTaskList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<AtomicTaskStruct> r100 = this.tasks;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.blackTaskList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AtomicTaskConfig(tasks=" + this.tasks + ", blackTaskList=" + this.blackTaskList + ')';
    }

    public final List<String> getBlackTaskList() {
        return this.blackTaskList;
    }

    public final List<AtomicTaskStruct> getTasks() {
        return this.tasks;
    }

    public AtomicTaskConfig(List<AtomicTaskStruct> r100, List<String> r101) {
        this.tasks = r100;
        this.blackTaskList = r101;
    }

    public /* synthetic */ AtomicTaskConfig(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
