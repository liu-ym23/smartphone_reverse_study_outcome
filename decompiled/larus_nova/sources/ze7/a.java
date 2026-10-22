package ze7;

import android.os.Handler;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f571548a;

    public final void a() {
        if ((!b.f571553e.isEmpty()) == false) goto L5;
        Event r100 = new Event("onGyroscopeChange", 0, null, 4, null);
        r100.setMapParams(b.f571553e);
        EventCenter.enqueueEvent(r100);
        Event r101 = new Event("onGyroscopeChange", 0, null, 4, null);
        r101.setMapParams(b.f571553e);
        EventCenter.enqueueEvent(r101);
    L5:
        Handler r102 = b.f571551c;
        if (r102 == null) goto L9;
        r102.postDelayed(this, this.f571548a);
        return;
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

    public a(int r100) {
        this.f571548a = r100;
    }
}
