package com.bytedance.lego.init.model;

import bf6.a;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @SerializedName(TextureRenderKeys.KEY_MODULE_NAME)
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;
    public transient a task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }

    public FeedShowTaskInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FeedShowTaskInfo r100) {
        int r101 = this.priority;
        int r102 = r100.priority;
        if (r101 >= r102) goto L6;
        return 1;
    L6:
        if (r101 <= r102) goto L10;
        return -1;
    L10:
        return this.task.getClass().getSimpleName().compareTo(r100.task.getClass().getSimpleName());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FeedShowTaskInfo r100) {
        return compareTo2(r100);
    }

    public FeedShowTaskInfo(String r100, String r101, a r102, boolean r103, int r104) {
        this.taskId = r100;
        this.moduleName = r101;
        this.task = r102;
        this.mustRunInMainThread = r103;
        this.priority = r104;
    }
}
