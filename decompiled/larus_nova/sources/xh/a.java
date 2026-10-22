package xh;

import com.google.gson.Gson;
import com.ss.android.cert.manager.constants.EventConstant;
import dm.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f563841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal<String> f563842b;

    public a() {
        this.f563841a = new Gson();
        this.f563842b = new ThreadLocal();
    }

    public final void g(Object r100) {
        Intrinsics.checkNotNullParameter("good_list", EventConstant.Key.MODULE);
        b r101 = new b();
        r101.c("good_list");
        r101.b("long_press_cell_blank");
        r101.a(r100);
        f(4, r101);
    }

    public final void a(String r100, b.a r101) {
        b r102 = new b();
        r102.c(r100);
        r102.b("api_request_begin");
        r102.a(r101);
        f(4, r102);
    }

    public final void b(String r100, b.C8238b r101) {
        b r102 = new b();
        r102.c(r100);
        r102.b("api_request_fail");
        r102.a(r101);
        f(5, r102);
    }

    public final void c(String r100, b.c r101) {
        b r102 = new b();
        r102.c(r100);
        r102.b("api_request_success");
        r102.a(r101);
        f(4, r102);
    }

    public final void f(int r100, b r101) {
        String r102 = this.f563842b.get();
        String r103 = "";
        if (r102 == null) goto L5;
        this.f563842b.remove();
    L23:
        String r104 = this.f563841a.toJson(r101);     // Catch: Throwable -> L10
        if (r104 == null) goto L12;
        r103 = r104;
    L12:
        if (r103.length() > 3072) goto L14;
        e(r100, r102, r103);
        return;
    L14:
        ArrayList r105 = new ArrayList();
    L15:
        int r106 = 0;
        if (r103.length() <= 3072) goto L18;
        r105.add(r103.substring(0, 3072));
        r103 = r103.substring(3072);
        goto L15
    L18:
        r105.add(r103);
        int r107 = r105.size();
        Iterator r108 = r105.iterator();
    L20:
        if (r108.hasNext() == false) goto L27;
        String r109 = (String) r108.next();
        StringBuilder r110 = new StringBuilder("[Part ");
        r106 = r106 + 1;
        r110.append(r106);
        r110.append('/');
        r110.append(r107);
        r110.append("] ");
        r110.append(r109);
        e(r100, r102, r110.toString());
        goto L20
    L27:
        return;
    L10:
        r103 = "toJson error";
        goto L12
    L5:
        r102 = "";
        goto L23
    }

    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        String r102 = "page_hide_".concat(r101);
        b r103 = new b();
        r103.c(r100);
        r103.b(r102);
        r103.a(null);
        f(4, r103);
    }

    public static void e(int r100, String r101, String r102) {
        if (r100 != 3) goto L5;
        dm.a.a(r101).a(r102);
        return;
    L5:
        if (r100 != 4) goto L7;
        dm.a.a(r101).i(r102);
        return;
    L7:
        if (r100 != 5) goto L9;
        dm.a.a(r101).w(r102, null);
        return;
    L9:
        if (r100 != 6) goto L20;
        dm.a.a(r101).b(r102, null);
        return;
    L20:
        d r103 = dm.a.a(r101).f469203a;     // Catch: Exception -> L13
        r103.g(2, r103.d(), r103.e(), r103.c(), r102, null);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        dm.c.b(e);
    }

    public final void d(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        b r103 = new b();
        r103.c(r100);
        r103.b("click_" + r101);
        r103.a(r102);
        f(4, r103);
    }

    public final void j(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        String r103 = "page_show_".concat(r101);
        b r104 = new b();
        r104.c(r100);
        r104.b(r103);
        r104.a(r102);
        f(4, r104);
    }

    public final void h(String r100, String r101, b.d r102, int r103) {
        b r104 = new b();
        r104.c(r100);
        r104.b("msg_recv_" + r101);
        r104.a(r102);
        f(r103, r104);
    }
}
