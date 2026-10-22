package vv4;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f557395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f557396b;

    public final void c() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator r100 = ((ArrayList) this.f557396b).iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        m r101 = (m) r100.next();
        r100.remove();
        if (this.f557395a == null) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onDetachWebService:" + r101);
        r101.onDetachFromWeb(this.f557395a);
        goto L4
    L7:
        com.ss.android.lark.officesdk.utils.di.j.b("WebServiceManager", "onDetachWebService WEB NULL");
        goto L4
    L9:
        this.f557395a = null;
    }

    public final void d() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onWebBringToBackground");
        Iterator r100 = ((ArrayList) this.f557396b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((m) r100.next()).onUserVisibleChanged(this.f557395a, false);
        goto L4
    }

    public final void e() {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onWebBringToFront");
        Iterator r100 = ((ArrayList) this.f557396b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((m) r100.next()).onUserVisibleChanged(this.f557395a, true);
        goto L4
    }

    public n() {
        this.f557396b = new ArrayList();
    }

    public final <P extends m> P a(Class<P> r100) {
        List<m> r101 = this.f557396b;
        if (r101 == null) goto L11;
        if (r100 == null) goto L11;
        Iterator r102 = ((ArrayList) r101).iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        P r103 = (P) r102.next();
        if (r103.getClass() != r100) goto L7;
        return r103;
    L11:
        com.ss.android.lark.officesdk.utils.di.j.f("WebServiceManager", "WebService not found with type:" + r100);
        return null;
    }

    public final void b(k r100, List<m> r101) {
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", WidgetCostModule.TYPE_ON_CREATE);
        this.f557395a = r100;
        if (r101 == null) goto L13;
        Iterator<m> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        m r103 = r102.next();
        if (((ArrayList) this.f557396b).contains(r103) == true) goto L6;
        ((ArrayList) this.f557396b).add(r103);
        if (this.f557395a == null) goto L11;
        com.ss.android.lark.officesdk.utils.di.j.e("WebServiceManager", "onAttachWebService:" + r103);
        r103.onAttachToWeb(null, this.f557395a);
        goto L6
    L11:
        com.ss.android.lark.officesdk.utils.di.j.b("WebServiceManager", "onAttachWebService WEB NULL");
        goto L6
    L22:
        return;
    }
}
