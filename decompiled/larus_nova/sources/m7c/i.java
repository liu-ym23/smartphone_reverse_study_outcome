package m7c;

import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleSubTodoData f512425b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f512424a, r101.f512424a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512425b, r101.f512425b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f512424a.hashCode() * 31;
        SimpleSubTodoData r101 = this.f512425b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "SectionInlineData(sectionGuid=" + this.f512424a + ", simpleTodo=" + this.f512425b + ')';
    }

    public i(String r100, SimpleSubTodoData r101) {
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        this.f512424a = r100;
        this.f512425b = r101;
    }
}
