package us3;

import android.R;
import android.app.Activity;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import vs3.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements MessageQueue.IdleHandler {
    public final /* synthetic */ vs3.b a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        Activity r0 = (Activity) this.a.get();
        if (r0 != null) goto L5;
        return false;
    L5:
        long r2 = System.currentTimeMillis();
        if (r0.getWindow() == null) goto L25;
        if (r0.getWindow().peekDecorView() == null) goto L25;
    L20:
        th = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L28;
        ps3.b.a(new String[]{"caught unexpected exception when unbind drawables.", th.getMessage()});
    L28:
        if (com.bytedance.apm.d.j() == false) goto L30;
        ps3.b.a(new String[]{"unbindDrawables done, cost: " + (System.currentTimeMillis() - r2) + " ms."});
    L30:
        return false;
    L10:
        if (r0.isDestroyed() == false) goto L30;
        if (r0.getWindow().getContext() != r0) goto L28;
        View r4 = r0.getWindow().peekDecorView().getRootView();     // Catch: Throwable -> L20
        ViewGroup r6 = (ViewGroup) r4.findViewById(R.id.content);     // Catch: Throwable -> L20
        if (r6.getChildCount() <= 0) goto L28;
        if (r6.getChildAt(0).getContext() != r0) goto L28;
        a.a(r4, r0);     // Catch: Throwable -> L20
    L25:
        if (com.bytedance.apm.d.j() == false) goto L28;
        ps3.b.a(new String[]{"unbindDrawables, ui or ui's window is null, skip rest works."});
        goto L28
    }

    public d(vs3.b r1) {
        this.a = r1;
    }
}
