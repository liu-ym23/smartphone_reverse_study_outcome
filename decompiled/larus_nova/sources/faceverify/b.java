package faceverify;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hs7.b f476090a;

    @Override // faceverify.j
    public void a() {
        hs7.b r100 = this.f476090a;
        r100.f487022e.f476100i = null;
        monitor-enter(r100);
        Handler r101 = r100.f487023f;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.sendEmptyMessage(902);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public b(hs7.b r100) {
        this.f476090a = r100;
    }

    @Override // faceverify.j
    public void a(String r100, String r101) {
        hs7.b r102 = this.f476090a;
        CopyOnWriteArrayList<is7.b> r103 = r102.f487034q;
        if (r103 == null) goto L5;
        r103.clear();
    L5:
        CopyOnWriteArrayList<is7.b> r104 = r102.f487033p;
        if (r104 == null) goto L8;
        r104.clear();
    L8:
        hs7.b r105 = this.f476090a;
        r105.f487022e.f476100i = r100;
        monitor-enter(r105);
        Handler r106 = r105.f487023f;     // Catch: Throwable -> L15
        if (r106 == null) goto L13;
        r106.sendEmptyMessage(902);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r105);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
