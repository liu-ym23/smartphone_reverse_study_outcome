package vx3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationView;
import com.bytedance.awemeopen.servicesapi.thread.AoThreadService;
import com.facebook.keyframes.model.KFImage;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ DiggAnimationView a;

    public final void a() {
        this.a.setSelected(true);
        int r0 = e.b;
        final e r1 = e.b.a;
        final Context r2 = this.a.getContext();
        final a r3 = new a(this);
        KFImage r4 = r1.a.get("aos_anim_likes_explode");
        if (r4 == null) goto L5;
        r3.a(r4);
        return;
    L5:
        final AoThreadService r5 = j64.a.a(AoThreadService.class);
        r5.executeIO(new c(r1, r2, r5, r3));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(DiggAnimationView r1) {
        this.a = r1;
    }
}
