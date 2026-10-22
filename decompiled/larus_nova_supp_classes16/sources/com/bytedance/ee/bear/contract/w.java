package com.bytedance.ee.bear.contract;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements com.bytedance.ee.bear.k {
    public final Map<String, a> a;
    public String b;
    public a15.a c;
    public String d;
    public final Map<Integer, a15.a> e;

    public static class a {
        public final String a;
        public final String b;
        public final String c;

        public a(String r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public w() {
        this.a = new ConcurrentHashMap();
        this.b = null;
        this.e = new HashMap();
    }

    public final String b() {
        return this.d;
    }

    public final String m() {
        return this.b;
    }

    public final void c(int r1) {
        v(r1);
        this.c.p();
    }

    public final void d(int r1) {
        v(r1);
        this.c.c();
    }

    public final void e(String r1) {
        this.d = r1;
    }

    public final boolean f(DocumentPluginHost r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        IEditionUserPermission r4 = (IEditionUserPermission) ((w05.b) r3.getHostAbility(w05.b.class)).getDocumentInfoProvider().l().getValue();
        if (r4 != null) goto L8;
        return false;
    L8:
        return r4.canOperateEntity();
    }

    public final void j(String r1) {
        this.b = r1;
    }

    public final void k(int r1) {
        v(r1);
        this.c.g();
    }

    public final void n(int r1) {
        v(r1);
        this.c.m();
    }

    public final void r(int r1) {
        v(r1);
        this.c.e();
    }

    public final boolean u(DocumentPluginHost r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        IEditionUserPermission r4 = (IEditionUserPermission) ((w05.b) r3.getHostAbility(w05.b.class)).getDocumentInfoProvider().l().getValue();
        if (r4 != null) goto L8;
        return false;
    L8:
        return r4.canRenameAndCreateEdition();
    }

    public final void v(int r3) {
        Map<Integer, a15.a> r0 = this.e;
        HashMap r1 = (HashMap) r0;
        if (r1.get(Integer.valueOf(r3)) != null) goto L5;
        this.c = a15.a.a((d) org.koin.java.a.a(d.class), r3);
        Map<Integer, a15.a> r2 = this.e;
        HashMap r4 = (HashMap) r2;
        r4.put(Integer.valueOf(r3), this.c);
        return;
    L5:
        Map<Integer, a15.a> r5 = this.e;
        HashMap r6 = (HashMap) r5;
        this.c = (a15.a) r6.get(Integer.valueOf(r3));
    }

    public final void h(int r1, String r2) {
        v(r1);
        this.c.l(r2);
    }

    public final void l(String r2, String r3) {
        String r4 = z05.f.b(r2, r3);
        if (((ConcurrentHashMap) this.a).get(r4) == null) goto L6;
        ((ConcurrentHashMap) this.a).remove(r2);
        return;
    }

    public final void o(int r1, String r2) {
        v(r1);
        this.c.f(r2);
    }

    public final String s(String r1, String r2) {
        String r3 = z05.f.b(r1, r2);
        a r4 = (a) ((ConcurrentHashMap) this.a).get(r3);
        if (r4 != null) goto L5;
        return "";
    L5:
        return r4.b;
    }

    public final String t(String r1, String r2) {
        String r3 = z05.f.b(r1, r2);
        a r4 = (a) ((ConcurrentHashMap) this.a).get(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.c;
    }

    public final boolean p(String r1, String r2, boolean r3) {
        String r4 = z05.f.b(r1, r2);
        a r5 = (a) ((ConcurrentHashMap) this.a).get(r4);
        if (r5 == null) goto L5;
        String r6 = r5.a;
    L6:
        if (r6 == null) goto L11;
        if (r3 == false) goto L10;
        return false;
    L10:
        return z05.i.d(r6);
    L11:
        return false;
    L5:
        r6 = null;
        goto L6
    }

    public final void i(int r1, String r2, String r3, String r4) {
        v(r1);
        this.c.n(r2, r3, r4);
    }

    public final String a(FragmentActivity r3, String r4, int r5, String r6, Locale r7) {
        z05.g r8 = z05.f.c(r4, r6);
        if (r8 != null) goto L6;
        return "";
    L6:
        String r9 = r8.e;
        if (TextUtils.isEmpty(r9) == false) goto L9;
        String r10 = r8.c;
        String r0 = r8.d;
        r9 = ou5.a.b(((i0) org.koin.java.a.a(i0.class)).a(), r10, r0);
    L9:
        v(r5);
        this.c.j();
        return z05.i.a(r3, r9, r8.h, r7);
    }

    public final void g(String r2, String r3, String r4, String r5, String r6) {
        l(r6, r4);
        a r0 = new a(r2, r3, r5);
        String r7 = z05.f.b(r6, r4);
        ((ConcurrentHashMap) this.a).put(r7, r0);
    }

    public final void q(int r7, String r8, String r9, String r10, String r11, String r12) {
        v(r7);
        this.c.h(r8, r9, r10, r11, r12);
    }
}
