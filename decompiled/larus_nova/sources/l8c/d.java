package l8c;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskSectionSelectAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f508084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailTaskSectionSelectAdapter f508085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f508086c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f508084a;
        long r102 = System.currentTimeMillis();
        this.f508084a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        DetailTaskSectionSelectAdapter.a r103 = this.f508085b.f443482c;
        if (r103 == null) goto L9;
        r103.b(this.f508086c.f508076a.guid);
        return;
    }

    public d(DetailTaskSectionSelectAdapter r100, a r101) {
        this.f508085b = r100;
        this.f508086c = r101;
    }
}
