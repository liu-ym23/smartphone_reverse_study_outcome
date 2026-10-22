package com.bytedance.router;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.listener.error.ErrorType;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f267538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f267539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f267540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q97.b f267541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f267542e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f267543a = null;

        static {
            f267543a = new d();
        }
    }

    public d() {
        g r100 = new g("snssdk143");
        r100.b(f.f267546a);
        if (TextUtils.isEmpty("bt.service") == true) goto L9;
        if (r100.f267550d != null) goto L7;
        r100.f267550d = new HashMap();
    L7:
        ((HashMap) r100.f267550d).put("bt.service", t97.e.class);
    L9:
        if (TextUtils.isEmpty("bt.broadcast") == false) goto L11;
    L14:
        this.f267539b = r100;
        this.f267538a = new e();
        this.f267540c = new b();
        this.f267541d = new q97.b();
        return;
    L11:
        if (r100.f267550d != null) goto L13;
        r100.f267550d = new HashMap();
    L13:
        ((HashMap) r100.f267550d).put("bt.broadcast", t97.c.class);
        goto L14
    }

    public Context getContext() {
        return this.f267542e;
    }

    public final boolean a(c r100) {
        String r101 = r100.f267529c;
        g r102 = this.f267539b;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L4:
        boolean r103 = false;
    L24:
        if (r103 == false) goto L26;
        return true;
    L26:
        this.f267539b.toString();
        return false;
    L5:
        Uri r104 = UriProtector.parse(r101);
        if (r104.isHierarchical() == false) goto L4;
        String r105 = r104.getScheme();
        if (TextUtils.isEmpty(r105) == false) goto L12;
    L10:
        r103 = true;
        goto L24
    L12:
        if (r105.equals(r102.f267547a) == true) goto L10;
        String[] r106 = r102.f267548b;
        if (r106 == null) goto L4;
        if (r106.length <= 0) goto L4;
        int r107 = r106.length;
        int r108 = 0;
    L19:
        if (r108 >= r107) goto L4;
        if (r105.equals(r106[r108]) == true) goto L10;
        r108 = r108 + 1;
        goto L19
    }

    public final c c(c r100) {
        String r101 = r100.f267529c;
        if (u97.b.c(r101) == false) goto L5;
        String r102 = this.f267539b.f267547a;
        if (TextUtils.isEmpty(UriProtector.parse(r101).getScheme()) == true) goto L9;
    L12:
        r100.b(r101);
        return r100;
    L9:
        if (r101.startsWith("//") == false) goto L11;
        r101 = r102 + ':' + r101;
        goto L12
    L11:
        r101 = r102 + "://" + r101;
        goto L12
    L5:
        return null;
    }

    public final void b(Context r110, c r111) {
        if (a(r111) == true) goto L7;
        r97.a.a(ErrorType.PARAMERROR, r111, "参数或者url有误");
        return;
    L7:
        if (this.f267540c.b(r110, r111) == false) goto L9;
        return;
    L9:
        c r100 = c(r111);
        if (r100 != null) goto L13;
        r97.a.a(ErrorType.PARAMERROR, r111, "参数或者url有误");
        return;
    L13:
        String r101 = this.f267538a.a(r100.f267529c);
        if (TextUtils.isEmpty(r101) == false) goto L20;
        monitor-enter(this);
        monitor-exit(this);
        r97.a.a(ErrorType.NOTFOUND, r111, "当前传入的path找不到目标类");
        return;
    L20:
        if (TextUtils.isEmpty(r101) == false) goto L22;
        r97.a.a(ErrorType.NOTFOUND, r111, "当前传入的path找不到目标类");
    L22:
        String r102 = r100.f267529c;
        g r103 = this.f267539b;
        t97.b r104 = null;
        Class r105 = null;
        r105 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        r104 = null;
        if (TextUtils.isEmpty(r102) == true) goto L76;
        Uri r106 = UriProtector.parse(r102);
        if (r106.isHierarchical() == false) goto L76;
        String r107 = r106.getScheme();
        if (TextUtils.isEmpty(r107) == true) goto L76;
        String r108 = r106.getHost();
        if (TextUtils.isEmpty(r108) == true) goto L76;
        if (r107.equals(r103.f267547a) == true) goto L45;
        String[] r109 = r103.f267548b;
        if (r109 != null) goto L40;
    L47:
        boolean r112 = false;
    L48:
        if (r112 == true) goto L51;
        String.format("RouteFactory#createRoute router cannot support this scheme protocol: %s\nRouteConfig:\n%s", new Object[]{r102, r103.toString()});
        goto L76
    L51:
        if (r108.startsWith("bt.") == true) goto L53;
        r105 = t97.d.a(r101);     // Catch: Throwable -> L64 ClassNotFoundException -> L66
    L68:
        if (r105 != null) goto L70;
    L75:
        r104 = new t97.a();
        goto L76
    L70:
        if (Service.class.isAssignableFrom(r105) == false) goto L73;
        r104 = new t97.e();
        goto L76
    L73:
        if (BroadcastReceiver.class.isAssignableFrom(r105) == false) goto L75;
        r104 = new t97.c();
        goto L76
    L66:
        e = move-exception;
        e.printStackTrace();
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L68
    L53:
        if (TextUtils.isEmpty(r108) == false) goto L55;
        Class r113 = null;
    L56:
        if (r113 == null) goto L76;
        r104 = (t97.b) r113.newInstance();     // Catch: Exception -> L60
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L76
    L55:
        r113 = (Class) ((HashMap) r103.f267550d).get(r108);
        goto L56
    L40:
        if (r109.length <= 0) goto L47;
        int r114 = r109.length;
        int r115 = 0;
    L42:
        if (r115 >= r114) goto L47;
        if (r107.equals(r109[r115]) == true) goto L45;
        r115 = r115 + 1;
    L45:
        r112 = true;
    L76:
        if (r104 == null) goto L78;
        e r116 = this.f267538a;
        r104.f545104b = r100;
        String r117 = r100.f267529c;
        r104.f545103a = r117;
        UriProtector.parse(r117);
        r104.f545105c = r116;
    L78:
        if (r104 != null) goto L88;
        r97.a.a(ErrorType.PARAMERROR, r111, "参数或者url有误");
        return;
    L88:
        ((t97.f) r104).b(r110);     // Catch: Exception -> L83
        return;
    L83:
        e = move-exception;
        e.printStackTrace();
        r97.a.a(ErrorType.EXCEPTION, r111, e.getMessage());
    }
}
