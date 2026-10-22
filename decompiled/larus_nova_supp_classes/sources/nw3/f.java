package nw3;

import com.bytedance.applog.AppLog;
import com.bytedance.applog.b;
import com.bytedance.bdinstall.e0;
import com.bytedance.bdinstall.i;
import com.bytedance.bdinstall.k;
import com.bytedance.bdinstall.l;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.y;
import j74.a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f implements h, e0 {
    public volatile l a;
    public volatile o0 b;
    public volatile g c;
    public final b d;
    public volatile k e;
    public final ConcurrentHashMap<String, Object> f;
    public n0 g;
    public String h;
    public String i;
    public String j;

    public final y b() {
        if (this.e != null) goto L20;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (this.e != null) goto L14;
        b r0 = this.d;     // Catch: Throwable -> L16
        if (AppLog.getInstance() != r0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        this.e = i.b;     // Catch: Throwable -> L16
        goto L14
    L13:
        a r2 = i.a;     // Catch: Throwable -> L16
        this.e = new k();     // Catch: Throwable -> L16
        goto L14
    L10:
        r1 = false;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    L20:
        return this.e;
    }

    public final n0 c() {
        if (this.g != null) goto L6;
        this.g = ((k) b()).j();
    L6:
        return this.g;
    }

    public f(b r2) {
        this.a = new l();
        this.f = new ConcurrentHashMap();
        this.d = r2;
    }

    @Override // com.bytedance.bdinstall.e0
    public final void a(n0 r1) {
        this.g = r1;
    }
}
