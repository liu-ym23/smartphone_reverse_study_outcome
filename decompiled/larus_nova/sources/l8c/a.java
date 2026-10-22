package l8c;

import com.bytedance.lark.pb.todo.v1.TaskSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskSection f508076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508077b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f508076a, r101.f508076a) == true) goto L12;
        return false;
    L12:
        if (this.f508077b == r101.f508077b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508076a.hashCode() * 31;
        if (this.f508077b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DetailSectionSelectItem(section=" + this.f508076a + ", isCreateItem=" + this.f508077b + ')';
    }

    public a(TaskSection r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "section");
        this.f508076a = r100;
        this.f508077b = r101;
    }
}
