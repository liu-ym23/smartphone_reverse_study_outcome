package c85;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.ss.android.lark.passportc.entity.UserSession;
import w75.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a<FM extends w75.a> implements e<FM> {
    public final t a;
    public final com.bytedance.ee.bear.drive.config.strategy.d b;
    public final com.bytedance.ee.bear.drive.report.a c;
    public final a95.a d;

    @Override // c85.e
    public final void b(w75.c<FM> r2) {
        e(r2, a(r2));
    }

    public a(com.bytedance.ee.bear.drive.config.strategy.d r1, a95.a r2) {
        this.d = r2;
        this.a = t.l();
        this.b = r1;
        this.c = o75.b.a().Tb();
    }

    @Override // c85.e
    public final boolean c(w75.c<FM> r10, e.a r11) {
        this.c.b(r10.getFileToken(), "local_cache", this.b);
        w75.a r0 = r10.getDetails();
        String r1 = a(r10);
        e(r10, r1);
        UserSession r2 = this.d.b;
        boolean r4 = !TextUtils.equals(this.b.getPreviewFileSourceType(), "2");
        t r6 = this.a;
        a95.a r7 = this.d;
        r6.getClass();
        DriveCache r5 = t.i(r1, r4, r7);
        if (r5 != null) goto L5;
    L27:
        f85.a r3 = t.a(r0.c().a, r5, "", this.d);
        if (d(r5, r10) == false) goto L42;
        if (r11 != null) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == false) goto L42;
        this.c.s("local_cache", r3, this.b);
        r0.k = r3.a();
        r0.l = r3.b();
        r0.f(true);
        if (TextUtils.equals(((f85.a.C0229a) r3.a).b, r0.c().b) == true) goto L37;
        t r13 = this.a;
        String r14 = r0.c().b;
        r13.getClass();
        t.q(r1, r14);
    L37:
        if ((this.b instanceof com.bytedance.ee.bear.drive.config.strategy.g) == true) goto L39;
    L41:
        return true;
    L39:
        if (r5.getType() == 2) goto L41;
        tt5.a.h("DRIVE_PREVIEW_FLOW", "convertCacheTypeSync");
        t r16 = this.a;
        int r8 = r5.getType();
        UserSession r9 = this.d.b;
        r16.getClass();
        ((com.bytedance.ee.bear.drive.services.c) org.koin.java.a.a(com.bytedance.ee.bear.drive.services.c.class)).T5(r1, r8, 2, r9);
        goto L41
    L31:
        r12 = r11.isCacheValid(this.b, r3);
    L42:
        return false;
    L5:
        if (r5.r == true) goto L7;
    L9:
        boolean r17 = false;
    L10:
        if (r17 == false) goto L12;
    L20:
        StringBuilder r18 = new StringBuilder("Download findCacheFile() is wps cache, ignore it, wps=");
        if (r5.r == true) goto L23;
    L25:
        boolean r19 = false;
    L26:
        r18.append(r19);
        tt5.a.h("DriveComponent", r18.toString());
        r5 = null;
        goto L27
    L23:
        if (z75.b.d(r5.b, r2) == true) goto L25;
        r19 = true;
        goto L26
    L12:
        if ("3".equals(r5.f) == true) goto L14;
    L18:
        boolean r20 = false;
    L19:
        if (r20 == false) goto L27;
    L14:
        if ("txt".equalsIgnoreCase(r5.d) == false) goto L18;
        if ("txt".equalsIgnoreCase(r5.h) == false) goto L18;
        r20 = true;
        goto L19
    L7:
        if (z75.b.d(r5.b, r2) == true) goto L9;
        r17 = true;
        goto L10
    }

    public boolean d(DriveCache r5, w75.c<FM> r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r6.B() == null) goto L25;
        String r1 = r5.d;
        if (TextUtils.equals(r5.k, r6.getFileToken()) == true) goto L10;
        return false;
    L10:
        if (TextUtils.equals(r5.e, r6.h()) == true) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r1) == false) goto L14;
        return false;
    L14:
        if (r1.equalsIgnoreCase(r6.B()) == true) goto L16;
        return false;
    L16:
        if (TextUtils.equals(r5.q, r6.getDetails().r) == false) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    }

    public final void e(w75.c<FM> r4, String r5) {
        com.bytedance.ee.bear.drive.config.strategy.d r0 = this.b;
        Application r1 = eu5.b.a;
        r4.getFileSize();
        DriveFilePath r2 = r0.h(r1);
        r2.cacheName(r5);
        com.bytedance.ee.bear.drive.config.strategy.d r3 = this.b;
        Application r6 = eu5.b.a;
        r4.getFileSize();
        DriveFilePath r7 = r3.h(r6);
        r7.cacheName(r5 + "_temp");
        r4.g(r2);
        r4.m(r7);
    }
}
