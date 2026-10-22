package z7c;

import android.content.Context;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l extends UDBaseDialogBuilder<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<TaskSection> f570781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f570782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f570783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f570784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f570785e;

    public interface a {
        void a(TaskSection r100);

        void b(String r100);
    }

    public l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570781a = CollectionsKt.emptyList();
        this.f570782b = "";
        this.f570784d = "";
        gravity(80);
    }
}
