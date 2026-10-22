package ji7;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import ci7.l;
import ci7.p;
import ci7.x;
import com.bytedance.applog.AppLog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import gi7.g;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mi7.h;
import mi7.k;
import mi7.m;
import mi7.n;
import mi7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements e {
    public d() {
    }

    public static boolean c(Uri r100) {
        if (r100 != null) goto L14;
        return false;
    L14:
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    L6:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, "ug_attr_lxft")) == false) goto L9;
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, "ug_attr_lxft_repair")) == false) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean d(Uri r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return "zlink".equals(r100.getHost());
    }

    public static boolean e(Uri r100) {
        if (r100 != null) goto L11;
        return false;
    L11:
        String r101 = UriProtector.getQueryParameter(r100, "zlink");     // Catch: Throwable -> L7
    L10:
        return !TextUtils.isEmpty(r101);
    L7:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L10
    }

    @Override // ji7.e
    public final boolean a(Uri r100) {
        if (d(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (e(r100) == true) goto L10;
        if (c(r100) == true) goto L10;
        return false;
    }

    @Override // ji7.e
    public final void b(Uri r100, k.a r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Application r102 = l.f23871a;
        if (ZlinkApi.INSTANCE.isInited() == false) goto L7;
        l.b(r100, true);
    L9:
        if (x.f23891a != null) goto L11;
        x.f23891a = new CopyOnWriteArrayList();
    L11:
        x.f23891a.add(r100);
        m.a(1, r100.toString(), r101);
        String r103 = null;
        if (c(r100) == false) goto L37;
        mi7.e.c("DeepLinkResolver", "attribute schema");
        if (mi7.b.a(l.a()) == false) goto L37;
        AtomicBoolean r104 = g.f481468a;
        mi7.e.a("SchemaFirstLaunchReporter", "report " + r100);
        IZlinkDepend r105 = p.a();
        if (r105 == null) goto L37;
        if (g.f481468a.compareAndSet(false, true) == false) goto L37;
        if (TextUtils.isEmpty(r105.getDeviceId()) == false) goto L35;
        mi7.e.a("SchemaFirstLaunchReporter", "addDidCallBack " + r100);
        if (o.b(l.a()) == false) goto L37;
        if (g.f481469b != null) goto L27;
        g.f481469b = new gi7.f(r100);     // Catch: Throwable -> L29
    L27:
        jta.g.b(g.f481469b);     // Catch: Throwable -> L29
        mi7.e.a("SchemaFirstLaunchReporter", "addDeviceRegisterListener success " + r100);     // Catch: Throwable -> L29
    L30:
        if (g.f481470c != null) goto L33;
        g.f481470c = new gi7.e(r100);     // Catch: Throwable -> L32
    L33:
        AppLog.addDataObserver(g.f481470c);     // Catch: Throwable -> L32
        mi7.e.a("SchemaFirstLaunchReporter", "addAppLogDataObserver success " + r100);     // Catch: Throwable -> L32
        goto L37
    L35:
        g.a(r100, null);
    L37:
        if (d(r100) == false) goto L69;
        mi7.e.c("DeepLinkResolver", "multi scheme");
        String r106 = UriProtector.getQueryParameter(r100, "zlink_token");     // Catch: Exception -> L44
        r103 = UriProtector.getQueryParameter(r100, "default_scheme");     // Catch: Exception -> L42
    L48:
        if (TextUtils.isEmpty(r106) == true) goto L54;
        String r107 = r100.toString();
        IZlinkDepend r108 = p.a();
        if (r108 != null) goto L52;
        mi7.e.b("DeepLinkResolver", "unbelievable!!! IZlinkDepend is null");
        return;
    L52:
        h.a(new c(this, r107, r103, r108));
        return;
    L54:
        if (TextUtils.isEmpty(r103) == true) goto L60;
        IZlinkDepend r109 = p.a();
        if (r109 != null) goto L58;
        return;
    L58:
        if (n.a(r103) == false) goto L73;
        mi7.e.a("DeepLinkResolver", "host deal result= " + r109.dealWithSchema(r103));
        return;
    L73:
        return;
    L60:
        mi7.e.b("DeepLinkResolver", "please check!!! zLinkToken为空，兜底schema为空");
        return;
    L42:
        Exception e100 = e;
    L46:
        e100.printStackTrace();
    L44:
        e = move-exception;
        e100 = e;
        r106 = null;
        goto L46
    L69:
        return;
    L7:
        ((CopyOnWriteArraySet) fi7.d.f477414d).add(new ci7.n(r100));
        goto L9
    }
}
