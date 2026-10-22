package com.ss.android.ugc.aweme.poi.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/PoiDetailApiDuration;", "Ljava/io/Serializable;", "totalDuration", "", "tasksDuration", "", "Lcom/ss/android/ugc/aweme/poi/model/PoiDetailTaskDuration;", "(ILjava/util/List;)V", "getTasksDuration", "()Ljava/util/List;", "getTotalDuration", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiDetailApiDuration implements Serializable {

    @SerializedName("tasks_duration")
    private final List<PoiDetailTaskDuration> tasksDuration;

    @SerializedName("total_duration")
    private final int totalDuration;

    /* JADX WARN: Multi-variable type inference failed */
    public PoiDetailApiDuration() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiDetailApiDuration copy$default(PoiDetailApiDuration r100, int r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.totalDuration;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.tasksDuration;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.totalDuration;
    }

    public final List<PoiDetailTaskDuration> component2() {
        return this.tasksDuration;
    }

    public final PoiDetailApiDuration copy(int r100, List<PoiDetailTaskDuration> r101) {
        return new PoiDetailApiDuration(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiDetailApiDuration) == true) goto L8;
        return false;
    L8:
        PoiDetailApiDuration r101 = (PoiDetailApiDuration) r100;
        if (this.totalDuration == r101.totalDuration) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tasksDuration, r101.tasksDuration) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.totalDuration * 31;
        List<PoiDetailTaskDuration> r101 = this.tasksDuration;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "PoiDetailApiDuration(totalDuration=" + this.totalDuration + ", tasksDuration=" + this.tasksDuration + ')';
    }

    public final List<PoiDetailTaskDuration> getTasksDuration() {
        return this.tasksDuration;
    }

    public final int getTotalDuration() {
        return this.totalDuration;
    }

    public PoiDetailApiDuration(int r100, List<PoiDetailTaskDuration> r101) {
        this.totalDuration = r100;
        this.tasksDuration = r101;
    }

    public /* synthetic */ PoiDetailApiDuration(int r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
