package dxb;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470510a = 0;

    static {
    }

    public static void d(cxb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        c.a r101 = c.f470456a;
        int r102 = com.ss.android.lark.officesdk.utils.di.l.f437227a;
        ntb.o r103 = com.ss.android.lark.officesdk.utils.di.l.a.a();
        if (r103 == null) goto L6;
        ntb.o.a r104 = r103.d();
        if (r104 == null) goto L6;
    L7:
        if (r100 != null) goto L22;
        Map<String, Object> r105 = null;
    L12:
        if (r105 == null) goto L16;
        boolean r106 = true;
        if ((!r105.isEmpty()) != true) goto L16;
    L17:
        if (r106 == false) goto L19;
        r104.b();     // Catch: Throwable -> L9
    L19:
        r104.flush();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        r106 = false;
        goto L17
    L22:
        r105 = r100.getCommonParams();     // Catch: Throwable -> L9
    L6:
        r104 = new com.ss.android.lark.officesdk.utils.di.k();
        goto L7
    }

    public static void b(g r100, Uri r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        String r102 = com.ss.android.lark.officesdk.utils.di.p.a(r101);
        String r103 = com.ss.android.lark.officesdk.utils.di.p.c(r101.toString());
        r100.a("host", r102);
        r100.a("current_url", r103);
    }

    public static void c(g r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        b(r100, UriProtector.parse(r101));
    }

    public static void a(cxb.a r100, g r101, String r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getBizType();
    L6:
        if (Intrinsics.areEqual(r103, b.f470452b.a()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        Uri r104 = UriProtector.parse(r102);     // Catch: Exception -> L11
        r101.a("host", r104.getHost());     // Catch: Exception -> L11
        List<String> r105 = com.ss.android.lark.officesdk.utils.di.p.f437230a;     // Catch: Exception -> L11
        r101.a("path", com.ss.android.lark.officesdk.utils.di.p.b(r104.getPath()));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.b("WebMonitorManager", "add url exception " + e);
        return;
    L17:
        return;
    L4:
        r103 = null;
        goto L6
    }
}
