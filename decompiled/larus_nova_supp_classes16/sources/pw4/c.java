package pw4;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.g5;
import com.bytedance.ee.bear.document.offline.sync.h0;
import com.bytedance.ee.bear.document.q1;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import j25.p;
import j25.q;
import j25.t;
import java.util.Map;
import k25.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements v45.a {
    public c() {
    }

    @Override // v45.a
    public final void c() {
    }

    @Override // v45.a
    public final boolean a(String r1) {
        return g5.d(r1);
    }

    @Override // v45.a
    public final String b(String r3) {
        q r4 = e0.m().x(r3);
        if (r4 == null) goto L17;
        String r5 = r4.d;
        if (ay4.d.a().i(r5).exists() == false) goto L8;
        tt5.a.h("DriveFileProtocolImpl", "getFilePathByLocalUrl success.");
        return r5;
    L8:
        tt5.a.h("DriveFileProtocolImpl", "invalid path.");
        e0 r0 = e0.m();
        r0.getClass();
        ((p) r0.q().d()).b(r5);     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        iu5.d.c(e);
        return null;
    L17:
        return null;
    }

    @Override // v45.a
    public final String d(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return f(r2);
    }

    @Override // v45.a
    public final boolean e(String r1) {
        return q1.a(r1);
    }

    @Override // v45.a
    public final String f(String r3) {
        q r4 = e0.m().y(r3);
        if (r4 == null) goto L17;
        String r5 = r4.d;
        if (ay4.d.a().i(r5).exists() == false) goto L8;
        tt5.a.h("DriveFileProtocolImpl", "getFilePathByNetUrl success");
        return r5;
    L8:
        tt5.a.h("DriveFileProtocolImpl", "invalid path.");
        e0 r0 = e0.m();
        r0.getClass();
        ((p) r0.q().d()).b(r5);     // Catch: Exception -> L11
        return null;
    L11:
        e = move-exception;
        iu5.d.c(e);
        return null;
    L17:
        return null;
    }

    @Override // v45.a
    public final boolean g(String r6) {
        if (h0.m.booleanValue() == false) goto L28;
        if (TextUtils.isEmpty(r6) == false) goto L34;
    L20:
        boolean r0 = false;
    L21:
        if (r0 == false) goto L23;
        return true;
    L23:
        if (g5.b(r6) == true) goto L37;
        return false;
    L37:
        return true;
    L34:
        Uri r1 = UriProtector.parse(r6);     // Catch: Exception -> L18
        if (r1 == null) goto L20;
        if ("image".equalsIgnoreCase(UriProtector.getQueryParameter(r1, "type")) == false) goto L11;
    L10:
        r0 = true;
        goto L21
    L11:
        String r2 = r1.getPath();     // Catch: Exception -> L18
        if (r2 == null) goto L20;
        if (r2.contains("/api/box/stream/download/all/") == true) goto L10;
        if (r2.contains("/api/box/stream/download/preview/") == false) goto L20;
    L18:
        e = move-exception;
        tt5.a.f("ImageUtil", e, false);
        goto L20
    L28:
        if (g5.c(r6) == false) goto L30;
        return true;
    L30:
        if (g5.b(r6) == true) goto L39;
        return false;
    L39:
        return true;
    }

    @Override // v45.a
    public final String h(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if (g5.d(r2) == false) goto L9;
        return b(r2);
    L9:
        if (q1.a(r2) == true) goto L11;
        return null;
    L11:
        return f(r2);
    }

    @Override // v45.a
    public final Flowable<Boolean> i(String r2, String r3, Map<String, String> r4) {
        return t.a(r2, r4, false, r3);
    }
}
