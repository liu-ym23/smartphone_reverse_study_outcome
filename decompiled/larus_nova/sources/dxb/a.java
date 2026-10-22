package dxb;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ntb.o.a f470451a;

    public final synchronized void b() {
        monitor-enter(this);
        Map<String, Object> r100 = c();     // Catch: Throwable -> L14
        if (r100 == null) goto L8;
        boolean r101 = true;
        if ((!r100.isEmpty()) != true) goto L8;
    L9:
        if (r101 == false) goto L11;
        this.f470451a.b();     // Catch: Throwable -> L14
    L11:
        this.f470451a.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r101 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public abstract Map<String, Object> c();

    public a(String r100, ntb.o.b r101) {
        int r102 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        ntb.o r103 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r103 == null) goto L6;
        ntb.o.a r104 = r103.d();
        if (r104 == null) goto L6;
    L7:
        this.f470451a = r104;
        return;
    L6:
        r104 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f470451a.a(r100);
    }
}
