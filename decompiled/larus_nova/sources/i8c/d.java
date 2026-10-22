package i8c;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.todo.impl.features.detail.dependent.dialog.TaskDependentAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f488741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskDependentAdapter f488742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Todo f488743c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f488741a;
        long r102 = System.currentTimeMillis();
        this.f488741a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskDependentAdapter.b r103 = this.f488742b.f443071b;
        if (r103 == null) goto L9;
        r103.b(this.f488743c.guid);
        return;
    }

    public d(TaskDependentAdapter r100, Todo r101) {
        this.f488742b = r100;
        this.f488743c = r101;
    }
}
