package uy6;

import com.bytedance.locallife.poi.newdetail.task.TaskStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TaskStatus f552142c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f552140a, r101.f552140a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552141b, r101.f552141b) == true) goto L15;
        return false;
    L15:
        if (this.f552142c == r101.f552142c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f552140a.hashCode() * 31) + this.f552141b.hashCode()) * 31) + this.f552142c.hashCode();
    }

    public final String toString() {
        return "PoiRenderTask(name=" + this.f552140a + ", level=" + this.f552141b + ", status=" + this.f552142c + ')';
    }

    public a(String r100, String r101) {
        TaskStatus r102 = TaskStatus.NOT_KNOWN;
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r102, "status");
        this.f552140a = r100;
        this.f552141b = r101;
        this.f552142c = r102;
    }
}
