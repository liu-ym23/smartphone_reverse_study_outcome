package vv4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n {
    public k a;
    public final List<m> b;

    public final void c() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onDestroy");
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        m r2 = (m) r0.next();
        r0.remove();
        if (this.a == null) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onDetachWebService:" + r2);
        r2.onDetachFromWeb(this.a);
        goto L4
    L7:
        com.ss.android.lark.officesdk.utils.di.j.b("WebServiceManager", "onDetachWebService WEB NULL");
        goto L4
    L9:
        this.a = null;
    }

    public final void d() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onWebBringToBackground");
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((m) r0.next()).onUserVisibleChanged(this.a, false);
        goto L4
    }

    public final void e() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onWebBringToFront");
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((m) r0.next()).onUserVisibleChanged(this.a, true);
        goto L4
    }

    public n() {
        this.b = new ArrayList();
    }

    public final <P extends m> P a(Class<P> r4) {
        List<m> r0 = this.b;
        if (r0 == null) goto L11;
        if (r4 == null) goto L11;
        Iterator r1 = ((ArrayList) r0).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        P r2 = (P) r1.next();
        if (r2.getClass() != r4) goto L7;
        return r2;
    L11:
        com.ss.android.lark.officesdk.utils.di.j.f("WebServiceManager", "WebService not found with type:" + r4);
        return null;
    }

    public final void b(k r4, List<m> r5) {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onCreate");
        this.a = r4;
        if (r5 == null) goto L13;
        Iterator<m> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L22;
        m r7 = r6.next();
        if (((ArrayList) this.b).contains(r7) == true) goto L6;
        ((ArrayList) this.b).add(r7);
        if (this.a == null) goto L11;
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onAttachWebService:" + r7);
        r7.onAttachToWeb(null, this.a);
        goto L6
    L11:
        com.ss.android.lark.officesdk.utils.di.j.b("WebServiceManager", "onAttachWebService WEB NULL");
        goto L6
    L22:
        return;
    }
}
