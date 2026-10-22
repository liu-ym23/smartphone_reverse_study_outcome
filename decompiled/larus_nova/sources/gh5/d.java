package gh5;

import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c f481281a;

    public d(com.bytedance.ee.bear.middleground.permission.collaborator.search.topbar.c r100) {
        this.f481281a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((SpaceEditText) this.f481281a.f233615b.findViewById(R.id.share_input_edit)).requestFocus();     // Catch: Throwable -> L4
        rcb.c.h(this.f481281a.f233615b.findViewById(R.id.share_input_edit), null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
