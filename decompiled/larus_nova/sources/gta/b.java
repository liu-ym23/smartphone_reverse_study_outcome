package gta;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.f0;
import com.ss.android.common.applog.k0;
import com.ss.android.common.applog.v;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f482682a;

    public final void a() {
        SharedPreferences.Editor r100 = this.f482682a.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Throwable -> L5
        r100.putString("key_task_session", "");     // Catch: Throwable -> L5
        r100.apply();     // Catch: Throwable -> L5
        return;
    }

    public b(Context r100) {
        this.f482682a = r100.getApplicationContext();
        f0.a(r100);
        k0.d().b(new a(this));
    }

    public final void b(g r100) {
        f0 r101 = f0.a(this.f482682a);
        r101.getClass();
        if (r100 != null) goto L5;
        g r102 = null;
    L6:
        if (r102 == null) goto L11;
        v r103 = new v();
        r103.f408225a = r102;
        Context r104 = r101.f408124a;
        AppLog r105 = AppLog.f408004g0.e(r104);
        if (r105 == null) goto L12;
        r105.j(r103);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        g r106 = new g();
        r106.f482704a = r100.f482704a;
        r106.f482705b = r100.f482705b;
        r106.f482706c = r100.f482706c;
        r106.f482707d = r100.f482707d;
        r106.f482708e = r100.f482708e;
        r106.f482709f = r100.f482709f;
        r106.f482710g = r100.f482710g;
        r106.f482711h = r100.f482711h;
        r106.f482712i = r100.f482712i;
        r102 = r106;
        goto L6
    }
}
