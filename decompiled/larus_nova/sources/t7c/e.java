package t7c;

import com.bytedance.lark.pb.todo.v1.TodoLaunchScreen;
import com.larksuite.arch.jack.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoLaunchScreen f545014a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f545014a, ((e) r100).f545014a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        TodoLaunchScreen r100 = this.f545014a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "TaskNoticeState(noticeBannerInfo=" + this.f545014a + ')';
    }

    public e(TodoLaunchScreen r100) {
        this.f545014a = r100;
    }
}
