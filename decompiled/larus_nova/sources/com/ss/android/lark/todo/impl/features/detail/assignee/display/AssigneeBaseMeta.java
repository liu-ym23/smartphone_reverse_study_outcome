package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/AssigneeBaseMeta;", "Ljava/io/Serializable;", "id", "", "name", "completedMilliTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getName", "getCompletedMilliTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssigneeBaseMeta implements Serializable {
    private final long completedMilliTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f442626id;
    private final String name;

    public static /* synthetic */ AssigneeBaseMeta copy$default(AssigneeBaseMeta r100, String r101, String r102, long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f442626id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.completedMilliTime;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f442626id;
    }

    public final String component2() {
        return this.name;
    }

    public final long component3() {
        return this.completedMilliTime;
    }

    public final AssigneeBaseMeta copy(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return new AssigneeBaseMeta(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AssigneeBaseMeta) == true) goto L8;
        return false;
    L8:
        AssigneeBaseMeta r101 = (AssigneeBaseMeta) r100;
        if (Intrinsics.areEqual(this.f442626id, r101.f442626id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.completedMilliTime == r101.completedMilliTime) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.f442626id.hashCode() * 31;
        String r101 = this.name;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.completedMilliTime;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AssigneeBaseMeta(id=" + this.f442626id + ", name=" + this.name + ", completedMilliTime=" + this.completedMilliTime + ')';
    }

    public final long getCompletedMilliTime() {
        return this.completedMilliTime;
    }

    public final String getId() {
        return this.f442626id;
    }

    public final String getName() {
        return this.name;
    }

    public AssigneeBaseMeta(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f442626id = r100;
        this.name = r101;
        this.completedMilliTime = r102;
    }
}
