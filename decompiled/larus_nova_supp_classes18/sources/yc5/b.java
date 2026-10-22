package yc5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.j;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.g;
import org.json.JSONObject;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.bytedance.ee.bear.notification.a.b.InterfaceC0129b {
    public com.bytedance.ee.bear.notification.a.b a;
    public C0336b b;
    public final Context c;
    public final h d;
    public FrameLayout e;
    public final View f;
    public final a g;
    public String h;

    public interface a {
        String getModule();

        String m6();
    }

    /* JADX INFO: renamed from: yc5.b$b, reason: collision with other inner class name */
    public static class C0336b implements com.bytedance.ee.bear.notification.a.InterfaceC0127a {
        public final WeakReference<b> a;

        public C0336b(b r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.notification.a.InterfaceC0127a
        public final void closeNotification(String r3) {
            tt5.a.h("NotificationPresenter", "closeNotification()...nid = " + r3);
            b r0 = this.a.get();
            if (r0 != null) goto L6;
            tt5.a.h("NotificationPresenter", "NotificationPresenter is null");
            return;
        L6:
            final com.bytedance.ee.bear.notification.a.b r1 = r0.a;
            if (TextUtils.equals(r3, r1.g()) == false) goto L10;
            j.c(new d(r1));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.InterfaceC0127a
        public final void showNotification(final String r9, List<String> r10, final String r11) {
            tt5.a.h("NotificationPresenter", "showNotification()...nid = " + r9);
            final b r4 = this.a.get();
            if (r4 != null) goto L6;
            tt5.a.k("NotificationPresenter", "NotificationPresenter is null");
            return;
        L6:
            Iterator<String> r12 = r10.iterator();
        L8:
            if (r12.hasNext() == false) goto L12;
            if (TextUtils.equals("explorer", r12.next()) == false) goto L8;
            final boolean r3 = true;
        L13:
            final com.bytedance.ee.bear.notification.a.b r7 = r4.a;
            j.c(new c(r3, r4, r9, r11, r7));
            return;
        L12:
            r3 = false;
            goto L13
        }
    }

    public final void b() {
        tt5.a.h("NotificationPresenter", "destroy()...");
        if (this.b == null) goto L6;
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).c(this.b);
        return;
    }

    @Override // com.bytedance.ee.bear.notification.a.b.InterfaceC0129b
    public final void a(String r20) {
        tt5.a.h("NotificationPresenter", "onLinkClick()...");
        String r3 = this.h;
        String r7 = this.g.getModule();
        String r8 = this.g.m6();
        f.a r4 = f.a;
        Intrinsics.checkNotNullParameter(r3, "nid");
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r8, "subModule");
        JSONObject r15 = new JSONObject();
        e r13 = e.e;
        f.a.b(r4, new g(r15, r7, r8, "", r13.b, "", "", "", null));
        r15.put("location", "android_lark");
        r15.put("announcement_id", r3);
        r15.put("click", "open");
        r15.put("target", "none");
        tt5.a.b("ListAnalysis", "reportNotificationOpen, params = " + r15);
        com.bytedance.ee.bear.contract.d r0 = f.a.d();
        if (r0 == null) goto L6;
        r0.i("ccm_announcement_click", r15);
    L6:
        if (p.a().v6(r20) == true) goto L8;
        ((k) org.koin.java.a.a(k.class)).d(r20);
        return;
    L8:
        if (e.g(p.a().Z(r20).a) != r13.b) goto L10;
        h r2 = this.d;
        tt5.a.h("NotificationPresenter", "openSimpleWebView()...");
        r2.w2("/doc/simple_web").b(r20).e();
        return;
    L10:
        this.d.u5(r20);
    }

    public final void c(ConnectionService.NetworkState r3) {
        tt5.a.h("NotificationPresenter", "onNetworkStateChanged()...networkState = " + r3);
        if (this.e == null) goto L11;
        if (r3 != null) goto L6;
    L9:
        this.e.setVisibility(8);
        return;
    L6:
        if (r3.a() == false) goto L9;
        this.e.setVisibility(0);
        return;
    }

    public b(Context r1, View r2, a r3) {
        this.c = r1;
        this.d = (h) org.koin.java.a.a(h.class);
        this.f = r2;
        this.g = r3;
        tt5.a.h("NotificationPresenter", "init()...");
        this.a = ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).d();
        this.b = new C0336b(this);
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).b(this.b);
    }
}
