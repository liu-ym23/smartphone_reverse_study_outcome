package e84;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<SERVICE> implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f471300b;

    /* JADX INFO: loaded from: classes8.dex */
    public class a extends i84.r<Boolean> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f471301c;

        public a(b r100) {
            this.f471301c = r100;
        }

        @Override // i84.r
        public final Boolean a(Object[] r100) {
            boolean r101 = false;
            Context r102 = (Context) r100[0];
            String r103 = this.f471301c.f471299a;
            if (r102.getPackageManager().getPackageInfo(r103, 128) == null) goto L7;
            r101 = true;
        L7:
            return Boolean.valueOf(r101);
        }
    }

    public abstract Intent b(Context r100);

    public abstract u.b<SERVICE, String> c();

    public b(String r100) {
        this.f471300b = new a(this);
        this.f471299a = r100;
    }

    @Override // e84.m
    public final boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return this.f471300b.b(new Object[]{r100}).booleanValue();
    }

    @Override // e84.m
    public m.a getOaid(Context r100) {
        Intent r101 = b(r100);
        u.b<SERVICE, String> r102 = c();
        CountDownLatch r103 = new CountDownLatch(1);
        u.a r104 = new u.a(r103, r102);     // Catch: Throwable -> L13
        if (r100.bindService(r101, r104, 1) == false) goto L21;
        r103.await();     // Catch: Throwable -> L13
        String r105 = r102.a(r104.f471351c);     // Catch: Throwable -> L11
        r100.unbindService(r104);     // Catch: Throwable -> L9
    L22:
        String r106 = r105;
        if (TextUtils.isEmpty(r106) == true) goto L46;
        m.a r107 = new m.a();
        r107.f471323a = r106;
        return r107;
    L46:
        return null;
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        th = th;
    L44:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r104 == null) goto L21;
        r100.unbindService(r104);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = move-exception;
        if (r104 != null) goto L34;
    L33:
        throw th;
    L34:
        r100.unbindService(r104);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.printStackTrace();
    L21:
        r105 = null;
    L13:
        th = th;
        r104 = null;
        goto L44
    }
}
