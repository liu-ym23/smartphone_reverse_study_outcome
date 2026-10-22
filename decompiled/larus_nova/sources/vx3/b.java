package vx3;

import android.content.Context;
import com.bytedance.awemeopen.apps.framework.base.view.digg.DiggAnimationView;
import com.bytedance.awemeopen.servicesapi.thread.AoThreadService;
import com.facebook.keyframes.model.KFImage;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiggAnimationView f557464a;

    public final void a() {
        this.f557464a.setSelected(true);
        int r100 = e.f557473b;
        final e r101 = e.b.f557475a;
        final Context r102 = this.f557464a.getContext();
        final a r103 = new a(this);
        KFImage r104 = r101.f557474a.get("aos_anim_likes_explode");
        if (r104 == null) goto L5;
        r103.a(r104);
        return;
    L5:
        final AoThreadService r105 = (AoThreadService) j64.a.a(AoThreadService.class);
        r105.executeIO(new c(r101, r102, r105, r103));
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

    public b(DiggAnimationView r100) {
        this.f557464a = r100;
    }
}
