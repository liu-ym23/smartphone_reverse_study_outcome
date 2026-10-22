package gta;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f482683a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        super.handleMessage(r100);
        boolean r101 = true;
        if (r100.what != 1) goto L37;
        g r102 = this.f482683a.f482692e;
        if (r102 == null) goto L32;
        Object r103 = r100.obj;
        if ((r103 instanceof String) == false) goto L32;
        String r104 = (String) r103;
        String r105 = r102.f482705b;
        if (r104 != null) goto L14;
        if (r105 != null) goto L13;
        boolean r106 = true;
    L15:
        e r107 = this.f482683a;
        if (r107.f482690c == true) goto L18;
    L20:
        r101 = false;
    L21:
        if (r106 == false) goto L32;
        if (r101 == false) goto L32;
        g r108 = this.f482683a.f482692e;
        r108.f482710g = System.currentTimeMillis();
        e r109 = this.f482683a;
        b r110 = r109.f482694g;
        g r111 = r109.f482692e;
        r110.getClass();
        if (r111 == null) goto L30;
        r111.a();
        String r112 = r111.a();
        if (r112 != null) goto L35;
        r112 = "";
    L35:
        SharedPreferences.Editor r113 = r110.f482682a.getSharedPreferences(kta.b.f506097a, 0).edit();     // Catch: Throwable -> L34
        r113.putString("key_task_session", r112);     // Catch: Throwable -> L34
        r113.apply();     // Catch: Throwable -> L34
    L30:
        e.a(this.f482683a, r104);
        this.f482683a.getClass();
        return;
    L18:
        if (r107.f482689b == false) goto L20;
    L13:
        r106 = false;
        goto L15
    L14:
        r106 = r104.equals(r105);
    L32:
        this.f482683a.f482694g.a();
        this.f482683a.getClass();
        return;
    }

    public c(e r100, Looper r101) {
        this.f482683a = r100;
        super(r101);
    }
}
