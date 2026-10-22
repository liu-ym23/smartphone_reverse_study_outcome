package xf7;

import android.os.Message;
import com.bytedance.sync.v2.MsgNotifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.sync.a f563486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yf7.j f563487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<yf7.n> f563488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<yf7.h> f563489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f563490e;

    public interface a {
    }

    public final void a(List<yf7.n> r100) {
        List<yf7.n> r101 = this.f563488c;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList(r100);     // Catch: Throwable -> L25
        List<yf7.n> r103 = this.f563488c;     // Catch: Throwable -> L25
        monitor-enter(r103);     // Catch: Throwable -> L25
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L22
        boolean r105 = false;
    L8:
        if (r104.hasNext() == false) goto L15;
        yf7.n r106 = (yf7.n) r104.next();     // Catch: Throwable -> L22
        if (r106 == null) goto L8;
        if (((ArrayList) this.f563488c).contains(r106) == true) goto L8;
        ((ArrayList) this.f563488c).add(r106);     // Catch: Throwable -> L22
        r105 = true;
        goto L8
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L25
        if (r105 == false) goto L39;
        a r107 = this.f563490e;
        if (r107 == null) goto L40;
        long r108 = this.f563486a.f270349a;
        MsgNotifier r109 = ((u) r107).f563502e;
        r109.c().removeMessages(102);
        Message r110 = r109.c().obtainMessage(102);
        r109.c().sendMessageDelayed(r110, 50);
        r109.d(r108, 0, 50);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public final void b(List<yf7.h> r100) {
        List<yf7.h> r101 = this.f563489d;
        monitor-enter(r101);
        ArrayList r102 = new ArrayList(r100);     // Catch: Throwable -> L21
        List<yf7.h> r103 = this.f563489d;     // Catch: Throwable -> L21
        monitor-enter(r103);     // Catch: Throwable -> L21
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L18
    L8:
        if (r104.hasNext() == false) goto L15;
        yf7.h r105 = (yf7.h) r104.next();     // Catch: Throwable -> L18
        if (r105 == null) goto L8;
        if (((ArrayList) this.f563489d).contains(r105) == true) goto L8;
        ((ArrayList) this.f563489d).add(r105);     // Catch: Throwable -> L18
        goto L8
    L15:
        monitor-exit(r103);     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L21
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public o(com.bytedance.sync.a r100, p r101, a r102) {
        this.f563488c = new ArrayList();
        this.f563489d = new ArrayList();
        this.f563486a = r100;
        this.f563487b = r101;
        this.f563490e = r102;
    }
}
