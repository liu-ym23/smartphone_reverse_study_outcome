package h84;

import android.accounts.Account;
import android.content.Context;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.u;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends j {
    public static void a(Context r100, u r101, o0 r102) {
        if (r101.f199615c == false) goto L6;
        String r103 = i84.a.b("dp", r101);
    L11:
        if (r102.B == false) goto L13;
        r103 = r103 + "_local";
    L13:
        p r104 = new p();
        r104.f484144a = r103 + ".dat";
        r104.f484145b = r101.a(r102);
        r104.f484147d = r102.F;
        r104.f484146c = r102.B;
        Account r105 = r102.f199752y;
        String r106 = i84.a.b("", r101);
        r104.f484148e = r105;
        r104.f484149f = r106;
        r104.f484150g = false;
        r104.f484151h = r102;
        if (r101.f199615c == true) goto L16;
        g84.a r107 = new d(r100, r104);
    L17:
        g84.c r108 = (g84.c) g84.e.a(g84.c.class, r102.a());
        if (r108 == null) goto L20;
        r107 = (g84.a) r108.d();
    L20:
        g84.e.b(g84.a.class, r107, r102.a());
        return;
    L16:
        r107 = new l(r100, r104);
        goto L17
    L6:
        if (r102.O == false) goto L8;
        String r109 = "device_parameters";
    L9:
        r103 = i84.a.b(r109, r101);
        goto L11
    L8:
        r109 = "device_parameters_" + r102.f199728a;
        goto L9
    }
}
