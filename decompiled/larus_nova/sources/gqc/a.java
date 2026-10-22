package gqc;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.log.ZeusLogger;
import mqc.t;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f482286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f482287b;

    public final void a() {
        c.e(this.f482286a);     // Catch: Throwable -> L10
        t r100 = t.c();     // Catch: Throwable -> L25
        r100.p(System.currentTimeMillis());     // Catch: Throwable -> L25
        String r101 = mqc.b.a(this.f482286a);     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r100.o(r101);     // Catch: Throwable -> L25
    L7:
        r100.n("SECONDARY_DEX2OAT_33P");     // Catch: Throwable -> L25
    L8:
        b r102 = this.f482287b;
    L9:
        r102.f482289a.set(false);
        return;
    L10:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_DEX2OAT, "SecondaryDex2oatTrigger performSecondaryDex2Oat33P failed.", th);     // Catch: Throwable -> L18
        t r103 = t.c();     // Catch: Throwable -> L26
        r103.p(System.currentTimeMillis());     // Catch: Throwable -> L26
        String r104 = mqc.b.a(this.f482286a);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r104) == true) goto L15;
        r103.o(r104);     // Catch: Throwable -> L26
    L15:
        r103.n("SECONDARY_DEX2OAT_33P");     // Catch: Throwable -> L26
    L16:
        r102 = this.f482287b;
    L18:
        th = move-exception;
        t r105 = t.c();     // Catch: Throwable -> L27
        r105.p(System.currentTimeMillis());     // Catch: Throwable -> L27
        String r106 = mqc.b.a(this.f482286a);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r106) == true) goto L22;
        r105.o(r106);     // Catch: Throwable -> L27
    L22:
        r105.n("SECONDARY_DEX2OAT_33P");     // Catch: Throwable -> L27
    L23:
        this.f482287b.f482289a.set(false);
        throw th;
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

    public a(b r100, Context r101) {
        this.f482287b = r100;
        this.f482286a = r101;
    }
}
