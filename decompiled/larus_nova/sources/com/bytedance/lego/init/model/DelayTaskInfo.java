package com.bytedance.lego.init.model;

import bf6.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DelayTaskInfo implements Serializable, Comparable<DelayTaskInfo> {

    @SerializedName("delayTime")
    public DelayTime delayTime;

    @SerializedName(TextureRenderKeys.KEY_MODULE_NAME)
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;

    @SerializedName("realPriority")
    public int realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;
    public transient c task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.realPriority);
        r100.append(",");
        r100.append(this.taskId);
        r100.append(",");
        r100.append(this.mustRunInMainThread);
        r100.append(",");
        r100.append(this.moduleName);
        r100.append(",");
        r100.append(this.delayTime.name());
        r100.append(",");
        r100.append(this.priority);
        r100.append(",");
        List<String> r101 = this.runInProcess;
        if (r101 != null) goto L5;
    L12:
        String r102 = null;
    L13:
        r100.append(r102);
        return r100.toString();
    L5:
        if (r101.isEmpty() == true) goto L12;
        StringBuilder r103 = new StringBuilder("[");
        r103.append((String) ListProtector.get(r101, 0));
        int r104 = 1;
    L9:
        if (r104 >= r101.size()) goto L11;
        r103.append("," + ((String) ListProtector.get(r101, r104)));
        r104 = r104 + 1;
        goto L9
    L11:
        r103.append("]");
        r102 = r103.toString();
        goto L13
    }

    public DelayTaskInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DelayTaskInfo r100) {
        int r101 = this.realPriority;
        int r102 = r100.realPriority;
        if (r101 >= r102) goto L6;
        return -1;
    L6:
        if (r101 <= r102) goto L10;
        return 1;
    L10:
        return this.task.getClass().getSimpleName().compareTo(r100.task.getClass().getSimpleName());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DelayTaskInfo r100) {
        return compareTo2(r100);
    }

    public DelayTaskInfo(String r100, String r101, c r102, boolean r103, List<String> r104, int r105, DelayTime r106) {
        this.taskId = r100;
        this.moduleName = r101;
        this.task = r102;
        this.mustRunInMainThread = r103;
        this.runInProcess = r104;
        this.priority = r105;
        this.delayTime = r106;
        this.realPriority = r106.getValue() - r105;
    }
}
