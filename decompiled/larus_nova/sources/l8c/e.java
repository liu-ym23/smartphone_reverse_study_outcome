package l8c;

import android.view.View;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskSectionSelectAdapter;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f508087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DetailTaskSectionSelectAdapter f508088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f508089c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f508087a;
        long r102 = System.currentTimeMillis();
        this.f508087a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        DetailTaskSectionSelectAdapter.a r103 = this.f508088b.f443482c;
        if (r103 == null) goto L9;
        r103.b(this.f508089c.f508076a.guid);
        return;
    }

    public e(DetailTaskSectionSelectAdapter r100, a r101) {
        this.f508088b = r100;
        this.f508089c = r101;
    }
}
