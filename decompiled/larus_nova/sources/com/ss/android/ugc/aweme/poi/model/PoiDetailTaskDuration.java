package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiDetailTaskDuration;", "Ljava/io/Serializable;", "taskName", "", "taskDuration", "", "taskLevel", "(Ljava/lang/String;II)V", "getTaskDuration", "()I", "getTaskLevel", "getTaskName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiDetailTaskDuration implements Serializable {

    @SerializedName("task_duration")
    private final int taskDuration;

    @SerializedName("task_level")
    private final int taskLevel;

    @SerializedName("task_name")
    private final String taskName;

    public PoiDetailTaskDuration() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ PoiDetailTaskDuration copy$default(PoiDetailTaskDuration r100, String r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.taskName;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.taskDuration;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.taskLevel;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.taskName;
    }

    public final int component2() {
        return this.taskDuration;
    }

    public final int component3() {
        return this.taskLevel;
    }

    public final PoiDetailTaskDuration copy(String r100, int r101, int r102) {
        return new PoiDetailTaskDuration(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDetailTaskDuration) == true) goto L8;
        return false;
    L8:
        PoiDetailTaskDuration r101 = (PoiDetailTaskDuration) r100;
        if (Intrinsics.areEqual(this.taskName, r101.taskName) == true) goto L12;
        return false;
    L12:
        if (this.taskDuration == r101.taskDuration) goto L15;
        return false;
    L15:
        if (this.taskLevel == r101.taskLevel) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.taskName;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.taskDuration) * 31) + this.taskLevel;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiDetailTaskDuration(taskName=" + this.taskName + ", taskDuration=" + this.taskDuration + ", taskLevel=" + this.taskLevel + ')';
    }

    public final int getTaskDuration() {
        return this.taskDuration;
    }

    public final int getTaskLevel() {
        return this.taskLevel;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public PoiDetailTaskDuration(String r100, int r101, int r102) {
        this.taskName = r100;
        this.taskDuration = r101;
        this.taskLevel = r102;
    }

    public /* synthetic */ PoiDetailTaskDuration(String r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
