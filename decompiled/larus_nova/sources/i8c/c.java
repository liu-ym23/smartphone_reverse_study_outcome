package i8c;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.todo.impl.features.detail.dependent.dialog.TaskDependentAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f488738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskDependentAdapter f488739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Todo f488740c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f488738a;
        long r102 = System.currentTimeMillis();
        this.f488738a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskDependentAdapter.b r103 = this.f488739b.f443071b;
        if (r103 == null) goto L9;
        r103.a(this.f488740c.guid);
        return;
    }

    public c(TaskDependentAdapter r100, Todo r101) {
        this.f488739b = r100;
        this.f488740c = r101;
    }
}
