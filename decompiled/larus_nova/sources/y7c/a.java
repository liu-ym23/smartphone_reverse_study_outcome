package y7c;

import com.bytedance.lark.pb.todo.v1.ChatTodoInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ChatTodoInfo> f566647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f566648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f566649c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f566647a, r101.f566647a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566648b, r101.f566648b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566649c, r101.f566649c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<ChatTodoInfo> r100 = this.f566647a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f566648b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f566649c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompleteChatTodosData(completedTodos=" + this.f566647a + ", pageOffset=" + this.f566648b + ", isHasMore=" + this.f566649c + ')';
    }

    public a(List<ChatTodoInfo> r100, Long r101, Boolean r102) {
        this.f566647a = r100;
        this.f566648b = r101;
        this.f566649c = r102;
    }
}
