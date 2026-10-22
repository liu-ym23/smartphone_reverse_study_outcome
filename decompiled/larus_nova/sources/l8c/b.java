package l8c;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f508078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListSelectAdapter f508079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f508080c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f508078a;
        long r102 = System.currentTimeMillis();
        this.f508078a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        DetailTaskListSelectAdapter.a r103 = this.f508079b.f443478c;
        if (r103 == null) goto L9;
        r103.a(this.f508080c.f508093a.guid);
        return;
    }

    public b(DetailTaskListSelectAdapter r100, g r101) {
        this.f508079b = r100;
        this.f508080c = r101;
    }
}
