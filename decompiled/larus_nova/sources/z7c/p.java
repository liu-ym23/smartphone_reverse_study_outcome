package z7c;

import android.content.Context;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p extends UDBaseDialogBuilder<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TaskListMember f570799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TodoItemMemberRole f570800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f570801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f570802d;

    public interface a {
        void a(TodoItemMemberRole r100, String r101);

        void b(String r100);
    }

    public p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570800b = TodoItemMemberRole.NONE;
        gravity(80);
    }
}
