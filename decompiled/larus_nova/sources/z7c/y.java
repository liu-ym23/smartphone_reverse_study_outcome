package z7c;

import android.content.Context;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class y extends UDBaseDialogBuilder<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f570855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f570856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.ss.android.lark.todo.impl.features.detail.sections.c> f570857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f570858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f570859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f570860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f570861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TodoItemMemberRole f570862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TodoUser f570863k;

    public y(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f570853a = 30;
        this.f570854b = 2;
        int r101 = c8c.f.f22763h;
        this.f570855c = R.color.bg_body;
        this.f570856d = 4;
        this.f570857e = CollectionsKt.emptyList();
        this.f570858f = "";
        this.f570859g = R.color.bg_filler;
        this.f570860h = 3;
        this.f570861i = "";
        this.f570862j = TodoItemMemberRole.NONE;
        gravity(80);
    }
}
