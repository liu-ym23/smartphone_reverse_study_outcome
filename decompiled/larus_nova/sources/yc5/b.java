package yc5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.j;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lc5.f;
import lc5.g;
import org.json.JSONObject;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements com.bytedance.ee.bear.notification.a.b.InterfaceC3376b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ee.bear.notification.a.b f567137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C8325b f567138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f567139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f567140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f567141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f567142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f567143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f567144h;

    public interface a {
        String getModule();

        String m6();
    }

    /* JADX INFO: renamed from: yc5.b$b, reason: collision with other inner class name */
    public static class C8325b implements com.bytedance.ee.bear.notification.a.InterfaceC3374a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f567145a;

        public C8325b(b r100) {
            this.f567145a = new WeakReference(r100);
        }

        @Override // com.bytedance.ee.bear.notification.a.InterfaceC3374a
        public final void closeNotification(String r100) {
            tt5.a.h("NotificationPresenter", "closeNotification()...nid = " + r100);
            b r101 = this.f567145a.get();
            if (r101 != null) goto L6;
            tt5.a.h("NotificationPresenter", "NotificationPresenter is null");
            return;
        L6:
            final com.bytedance.ee.bear.notification.a.b r102 = r101.f567137a;
            if (TextUtils.equals(r100, r102.g()) == false) goto L10;
            j.c(new d(r102));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.InterfaceC3374a
        public final void showNotification(final String r100, List<String> r110, final String r111) {
            tt5.a.h("NotificationPresenter", "showNotification()...nid = " + r100);
            final b r101 = this.f567145a.get();
            if (r101 != null) goto L6;
            tt5.a.k("NotificationPresenter", "NotificationPresenter is null");
            return;
        L6:
            Iterator<String> r112 = r110.iterator();
        L8:
            if (r112.hasNext() == false) goto L12;
            if (TextUtils.equals(FileInfoPuller.CALLER_EXPLORER, r112.next()) == false) goto L8;
            final boolean r102 = true;
        L13:
            final com.bytedance.ee.bear.notification.a.b r103 = r101.f567137a;
            j.c(new c(r102, r101, r100, r111, r103));
            return;
        L12:
            r102 = false;
            goto L13
        }
    }

    public final void b() {
        tt5.a.h("NotificationPresenter", "destroy()...");
        if (this.f567138b == null) goto L6;
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).c(this.f567138b);
        return;
    }

    @Override // com.bytedance.ee.bear.notification.a.b.InterfaceC3376b
    public final void a(String r210) {
        tt5.a.h("NotificationPresenter", "onLinkClick()...");
        String r100 = this.f567144h;
        String r101 = this.f567143g.getModule();
        String r102 = this.f567143g.m6();
        f.a r103 = f.f508440a;
        Intrinsics.checkNotNullParameter(r100, "nid");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r102, "subModule");
        JSONObject r110 = new JSONObject();
        e r111 = e.f541294e;
        f.a.b(r103, new g(r110, r101, r102, "", r111.f541317b, "", "", "", null));
        r110.put("location", "android_lark");
        r110.put("announcement_id", r100);
        r110.put("click", "open");
        r110.put(PickerReporterConstants.KEY.TARGET, "none");
        tt5.a.b("ListAnalysis", "reportNotificationOpen, params = " + r110);
        com.bytedance.ee.bear.contract.d r104 = f.a.d();
        if (r104 == null) goto L6;
        r104.i("ccm_announcement_click", r110);
    L6:
        if (p.a().v6(r210) == true) goto L8;
        ((k) org.koin.java.a.a(k.class)).d(r210);
        return;
    L8:
        if (e.g(p.a().Z(r210).f222560a) != r111.f541317b) goto L10;
        h r105 = this.f567140d;
        tt5.a.h("NotificationPresenter", "openSimpleWebView()...");
        r105.w2("/doc/simple_web").b(r210).e();
        return;
    L10:
        this.f567140d.u5(r210);
    }

    public final void c(ConnectionService.NetworkState r100) {
        tt5.a.h("NotificationPresenter", "onNetworkStateChanged()...networkState = " + r100);
        if (this.f567141e == null) goto L11;
        if (r100 != null) goto L6;
    L9:
        this.f567141e.setVisibility(8);
        return;
    L6:
        if (r100.a() == false) goto L9;
        this.f567141e.setVisibility(0);
        return;
    }

    public b(Context r100, View r101, a r102) {
        this.f567139c = r100;
        this.f567140d = (h) org.koin.java.a.a(h.class);
        this.f567142f = r101;
        this.f567143g = r102;
        tt5.a.h("NotificationPresenter", "init()...");
        this.f567137a = ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).d();
        this.f567138b = new C8325b(this);
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.a(com.bytedance.ee.bear.notification.a.class)).b(this.f567138b);
    }
}
