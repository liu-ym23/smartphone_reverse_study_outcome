package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.bytedance.lark.pb.todo.v1.Commit;
import com.bytedance.lark.pb.todo.v1.DataTypeStartTime;
import com.bytedance.lark.pb.todo.v1.Todo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f441560k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f441562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Todo f441563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f441564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f441565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f441566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Commit.DataTypeDueTime f441567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DataTypeStartTime f441568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f441569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f441570j;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f441561a, r101.f441561a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441562b, r101.f441562b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441563c, r101.f441563c) == true) goto L18;
        return false;
    L18:
        if (this.f441564d == r101.f441564d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f441565e, r101.f441565e) == true) goto L24;
        return false;
    L24:
        if (this.f441566f == r101.f441566f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f441567g, r101.f441567g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f441568h, r101.f441568h) == true) goto L33;
        return false;
    L33:
        if (this.f441569i == r101.f441569i) goto L36;
        return false;
    L36:
        if (this.f441570j == r101.f441570j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f441561a.hashCode() * 31) + this.f441562b.hashCode()) * 31;
        Todo r101 = this.f441563c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f441564d;
        int r105 = (((((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f441565e.hashCode()) * 31;
        long r106 = this.f441566f;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        Commit.DataTypeDueTime r108 = this.f441567g;
        if (r108 != null) goto L9;
        int r109 = 0;
    L10:
        int r110 = (r107 + r109) * 31;
        DataTypeStartTime r111 = this.f441568h;
        if (r111 == null) goto L14;
        r102 = r111.hashCode();
    L14:
        int r112 = (r110 + r102) * 31;
        long r113 = this.f441569i;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        if (this.f441570j == false) goto L17;
        int r115 = 1231;
    L19:
        return r114 + r115;
    L17:
        r115 = 1237;
        goto L19
    L9:
        r109 = r108.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskListSortInfoData(taskGuid=" + this.f441561a + ", sectionGuid=" + this.f441562b + ", todo=" + this.f441563c + ", createMilliTime=" + this.f441564d + ", rank=" + this.f441565e + ", updateMilliTime=" + this.f441566f + ", dueTime=" + this.f441567g + ", startTime=" + this.f441568h + ", completedMilliTime=" + this.f441569i + ", isLoading=" + this.f441570j + ')';
    }

    public f(String r110, String r111, Todo r112, long r113, String r114, long r210, Commit.DataTypeDueTime r211, DataTypeStartTime r212, long r213, int r214) {
        DataTypeStartTime r100 = null;
        if ((r214 & 4) == 0) goto L5;
        Todo r101 = null;
    L6:
        long r102 = 0;
        if ((r214 & 8) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r214 & 16) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r214 & 32) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r214 & 64) == 0) goto L21;
        Commit.DataTypeDueTime r115 = null;
    L23:
        if ((r214 & 128) != 0) goto L27;
        r100 = r212;
    L27:
        if ((r214 & 256) != 0) goto L30;
        r102 = r213;
    L30:
        this.f441561a = r110;
        this.f441562b = r111;
        this.f441563c = r101;
        this.f441564d = r103;
        this.f441565e = r104;
        this.f441566f = r105;
        this.f441567g = r115;
        this.f441568h = r100;
        this.f441569i = r102;
        this.f441570j = false;
        return;
    L21:
        r115 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r104 = r114;
        goto L15
    L9:
        r103 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L6
    }
}
