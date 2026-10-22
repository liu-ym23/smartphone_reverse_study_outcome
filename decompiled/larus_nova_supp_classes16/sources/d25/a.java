package d25;

import android.content.Context;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.route.b {

    /* JADX INFO: renamed from: d25.a$a, reason: collision with other inner class name */
    public static final class C0212a {
    }

    static {
    }

    public a() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    public final String e(BearUrl r1, RouteBean r2) {
        return "/doc/default/route";
    }

    public static boolean h(int r2) {
        ArrayList r0 = new ArrayList();
        r0.add(Integer.valueOf(sbb.e.g.b));
        r0.add(Integer.valueOf(sbb.e.o.b));
        r0.add(Integer.valueOf(sbb.e.i.b));
        r0.add(Integer.valueOf(sbb.e.k.b));
        r0.add(Integer.valueOf(sbb.e.h.b));
        r0.add(Integer.valueOf(sbb.e.n.b));
        r0.add(Integer.valueOf(sbb.e.m.b));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r2 != ((Number) r1.next()).intValue()) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean b(Context r7, BearUrl r8, RouteBean r9) {
        if (j.a.a.getNetworkState().a() == true) goto L24;
        if (r8 != null) goto L22;
        return false;
    L22:
        int r0 = sbb.e.e(r8.a).b;     // Catch: Throwable -> L19
        if (h(r0) == false) goto L25;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();     // Catch: Throwable -> L19
        if (jg5.e.a.a.g() == false) goto L15;
        BaseEntity r1 = new BaseEntity(r8.b, sbb.e.d(r0), BizDomain.FileBizDomainCCM, "");     // Catch: Throwable -> L19
        boolean r10 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r1, "VIEW"), null).getAllow();     // Catch: Throwable -> L19
    L16:
        if (r10 == true) goto L26;
        tt5.a.h("OfflineSafeInterceptor", "shouldIntecept execute");     // Catch: Throwable -> L19
        PostCard r11 = ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/doc/default/route");     // Catch: Throwable -> L19
        r11.l("offline_safe_deny", true);     // Catch: Throwable -> L19
        r11.e();     // Catch: Throwable -> L19
        return true;
    L26:
        return false;
    L15:
        r10 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CONTENT_PREVIEW", FileBizDomain.FileBizDomainCCM, r0, r8.b).a;     // Catch: Throwable -> L19
        goto L16
    L25:
        return false;
    L19:
        th = move-exception;
        tt5.a.f("OfflineSafeInterceptor", th, false);
        return false;
    L24:
        return false;
    }
}
