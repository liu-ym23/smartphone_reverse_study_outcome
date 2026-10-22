package mfc;

import android.content.Context;
import android.database.Cursor;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f513690b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PushMultiProcessSharedProvider.b f513691a;

    public final long b() {
        PushMultiProcessSharedProvider.b r100 = this.f513691a;
        r100.getClass();
        long r101 = 0;
        if (PushMultiProcessSharedProvider.f449551h == false) goto L7;
    L19:
        r101 = r100.f449561b.getLong("red_badge_last_request_time", 0);     // Catch: Throwable -> L23
    L26:
        goto L20
    L7:
        if (PushMultiProcessSharedProvider.a(r100.f449560a) == false) goto L19;
        Cursor r102 = PushMultiProcessSharedProvider.b.a(r100.f449560a.getContentResolver(), PushMultiProcessSharedProvider.c(r100.f449560a, "red_badge_last_request_time", "long"));     // Catch: Throwable -> L23
        if (r102 == null) goto L26;
        if (r102.moveToFirst() == false) goto L16;
        long r103 = r102.getLong(0);     // Catch: Throwable -> L22
    L24:
        r102.close();     // Catch: Exception -> L21 Throwable -> L23
    L18:
        r101 = r103;
    L16:
        r103 = 0;
    L20:
        return r101;
    }

    public a(Context r100) {
        this.f513691a = PushMultiProcessSharedProvider.e(r100.getApplicationContext());
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f513690b != null) goto L7;
        f513690b = new a(r100);     // Catch: Throwable -> L10
    L7:
        a r101 = f513690b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public final void c(long r100) {
        PushMultiProcessSharedProvider.a r101 = this.f513691a.b();
        r101.f449558b.put("red_badge_last_request_time", Long.valueOf(r100));
        r101.a();
    }
}
