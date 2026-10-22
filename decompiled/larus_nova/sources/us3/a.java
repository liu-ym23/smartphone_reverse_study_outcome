package us3;

import android.app.Activity;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends vs3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f551465a;

    public a() {
        this.f551465a = e.f551472g;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        boolean r101 = zs3.c.f573475a.getServiceSwitch("activity_leak_switch");
        if (com.bytedance.apm.d.j() == false) goto L5;
        ps3.b.a(new String[]{"activity_leak_switch : " + r101});
    L5:
        if (r101 == false) goto L17;
        String r102 = UUID.randomUUID().toString();
        ((CopyOnWriteArraySet) this.f551465a.f551476c).add(r102);
        vs3.b r103 = new vs3.b(r100, r102, this.f551465a.f551475b);
        this.f551465a.getClass();
        String r104 = r100.getLocalClassName();
        if (com.bytedance.apm.d.j() == false) goto L9;
        ps3.b.a(new String[]{"Wait Check Leak:" + r104});
    L9:
        e r105 = this.f551465a;
        if (r105.f551479f != null) goto L12;
        Object r106 = f27.d.f475214f;
        r105.f551479f = f27.d.a.f475222a;
    L12:
        f27.d r107 = r105.f551479f;
        f27.e r108 = new f27.e("LeakCheck-Thread", AsyncTaskType.LIGHT_WEIGHT, new b(r105, r103, r104));
        if (r105.f551478e > 0) goto L15;
        r105.f551478e = 60000;
    L15:
        r107.i(r108, r105.f551478e);
        return;
    }
}
