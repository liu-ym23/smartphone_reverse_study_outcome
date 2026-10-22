package l8c;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f508081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailTaskListSelectAdapter f508082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f508083c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f508081a;
        long r102 = System.currentTimeMillis();
        this.f508081a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        DetailTaskListSelectAdapter.a r103 = this.f508082b.f443478c;
        if (r103 == null) goto L9;
        r103.b(this.f508083c.f508093a.name);
        return;
    }

    public c(DetailTaskListSelectAdapter r100, g r101) {
        this.f508082b = r100;
        this.f508083c = r101;
    }
}
