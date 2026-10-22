package y7c;

import com.bytedance.lark.pb.todo.v1.ChatTodoInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ChatTodoInfo> f566650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ChatTodoInfo> f566651b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f566650a, r101.f566650a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566651b, r101.f566651b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<ChatTodoInfo> r100 = this.f566650a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<ChatTodoInfo> r104 = this.f566651b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UnCompleteChatTodosData(assignToMeTodos=" + this.f566650a + ", assignToOtherTodos=" + this.f566651b + ')';
    }

    public b(List<ChatTodoInfo> r100, List<ChatTodoInfo> r101) {
        this.f566650a = r100;
        this.f566651b = r101;
    }
}
