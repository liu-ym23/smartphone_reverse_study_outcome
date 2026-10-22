package m7c;

import com.ss.android.lark.todo.impl.features.center.v3.data.TaskItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskItem.CompleteType f512378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f512379c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f512377a, r101.f512377a) == true) goto L12;
        return false;
    L12:
        if (this.f512378b == r101.f512378b) goto L15;
        return false;
    L15:
        if (this.f512379c == r101.f512379c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f512377a.hashCode() * 31) + this.f512378b.hashCode()) * 31;
        if (this.f512379c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CheckBoxClickData(taskGuid=" + this.f512377a + ", completeType=" + this.f512378b + ", isSlide=" + this.f512379c + ')';
    }

    public a(String r100, TaskItem.CompleteType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "completeType");
        this.f512377a = r100;
        this.f512378b = r101;
        this.f512379c = r102;
    }
}
