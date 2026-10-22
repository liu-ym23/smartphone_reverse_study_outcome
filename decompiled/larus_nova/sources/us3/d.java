package us3;

import android.R;
import android.app.Activity;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vs3.b f551471a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Activity r100 = (Activity) this.f551471a.get();
        if (r100 != null) goto L5;
        return false;
    L5:
        long r101 = System.currentTimeMillis();
        if (r100.getWindow() == null) goto L25;
        if (r100.getWindow().peekDecorView() == null) goto L25;
    L20:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L28;
        ps3.b.a(new String[]{"caught unexpected exception when unbind drawables.", th.getMessage()});
    L28:
        if (com.bytedance.apm.d.j() == false) goto L30;
        ps3.b.a(new String[]{"unbindDrawables done, cost: " + (System.currentTimeMillis() - r101) + " ms."});
    L30:
        return false;
    L10:
        if (r100.isDestroyed() == false) goto L30;
        if (r100.getWindow().getContext() != r100) goto L28;
        View r102 = r100.getWindow().peekDecorView().getRootView();     // Catch: Throwable -> L20
        ViewGroup r103 = (ViewGroup) r102.findViewById(R.id.content);     // Catch: Throwable -> L20
        if (r103.getChildCount() <= 0) goto L28;
        if (r103.getChildAt(0).getContext() != r100) goto L28;
        vs3.a.a(r102, r100);     // Catch: Throwable -> L20
    L25:
        if (com.bytedance.apm.d.j() == false) goto L28;
        ps3.b.a(new String[]{"unbindDrawables, ui or ui's window is null, skip rest works."});
        goto L28
    }

    public d(vs3.b r100) {
        this.f551471a = r100;
    }
}
