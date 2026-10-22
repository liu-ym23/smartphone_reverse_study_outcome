package com.bytedance.ee.bear.notification;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.notification.view.NotificationView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements com.bytedance.ee.bear.notification.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<com.bytedance.ee.bear.notification.a.InterfaceC3374a, g.a> f235112a;

    public class a implements com.bytedance.ee.bear.notification.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NotificationView f235113a;

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void a() {
            NotificationView r100 = this.f235113a;
            if (r100 == null) goto L6;
            r100.getClass();
            tt5.a.b("NotificationView", "closeNotification");
            r100.f235145y = null;
            r100.setText("");
            r100.setVisibility(8);
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final List<String> b() {
            NotificationView r100 = this.f235113a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getLinkUrls();
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final String g() {
            NotificationView r100 = this.f235113a;
            if (r100 != null) goto L5;
            return null;
        L5:
            return r100.getNotificationId();
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void d(com.bytedance.ee.bear.notification.a.b.InterfaceC3376b r100) {
            NotificationView r101 = this.f235113a;
            if (r101 == null) goto L6;
            r101.setOnLinkClickListener(new d(r100));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final View e(Context r100) {
            if (this.f235113a != null) goto L6;
            this.f235113a = new NotificationView(r100);
        L6:
            return this.f235113a;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void f(com.bytedance.ee.bear.notification.a.b.InterfaceC3375a r100) {
            NotificationView r101 = this.f235113a;
            if (r101 == null) goto L6;
            r101.setOnCloseListener(new e(r100));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void c(String r110, String r111) {
            final NotificationView r100 = this.f235113a;
            if (r100 == null) goto L62;
            r100.getClass();
            tt5.a.b("NotificationView", "showNotification");
            r100.f235145y = r110;
            r100.Z5();
            Matcher r101 = PatternProtector.compile("<a[^<>]*>[^<>]*</a>").matcher(r111);
            com.bytedance.ee.bear.notification.view.a r102 = new com.bytedance.ee.bear.notification.view.a(r111);
        L6:
            if (r101.find() == false) goto L31;
            int r103 = r101.start();
            int r104 = r101.end();
            String r105 = r111.substring(r103, r104);
            XmlPullParser r106 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: IOException -> L27 Throwable -> L29
            r106.setInput(new StringReader(r105));     // Catch: IOException -> L27 Throwable -> L29
            int r107 = r106.getEventType();     // Catch: IOException -> L27 Throwable -> L29
            String r108 = "";
            String r109 = "";
        L11:
            if (r107 == 1) goto L22;
            String r112 = r106.getName();     // Catch: IOException -> L27 Throwable -> L29
            if (r107 == 2) goto L19;
            if (r107 != 4) goto L21;
            tt5.a.b("ALinkParser", "pullParser: parse text");     // Catch: IOException -> L27 Throwable -> L29
            r108 = r106.getText();     // Catch: IOException -> L27 Throwable -> L29
        L21:
            r107 = r106.next();     // Catch: IOException -> L27 Throwable -> L29
            goto L11
        L19:
            if (BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY.equals(r112) == false) goto L21;
            tt5.a.b("ALinkParser", "pullParser: parse start tag");     // Catch: IOException -> L27 Throwable -> L29
            r109 = r106.getAttributeValue(null, "href");     // Catch: IOException -> L27 Throwable -> L29
            goto L21
        L22:
            String r113 = r111.substring(r103, r104);     // Catch: IOException -> L27 Throwable -> L29
            int r114 = r102.f235147a.indexOf(r113);     // Catch: IOException -> L27 Throwable -> L29
            int r115 = r113.length() + r114;     // Catch: IOException -> L27 Throwable -> L29
            r102.f235147a = new StringBuilder(r102.f235147a).replace(r114, r115, r108).toString();     // Catch: IOException -> L27 Throwable -> L29
            com.bytedance.ee.bear.notification.view.a.C3377a r116 = new com.bytedance.ee.bear.notification.view.a.C3377a(r109, r114, r108.length() + r114);     // Catch: IOException -> L27 Throwable -> L29
            if (r102.f235148b != null) goto L25;
            r102.f235148b = new ArrayList();     // Catch: IOException -> L27 Throwable -> L29
        L25:
            ((ArrayList) r102.f235148b).add(r116);     // Catch: IOException -> L27 Throwable -> L29
        L29:
            e = move-exception;
            tt5.a.e("ALinkParser", "error when parse xml", e, false);
            goto L6
        L31:
            r100.B = r102;
            r100.setText(r102.f235147a);
            if (hu5.a.d(r102.f235148b) == true) goto L41;
            Iterator r117 = ((ArrayList) r102.f235148b).iterator();
        L35:
            if (r117.hasNext() == false) goto L41;
            final com.bytedance.ee.bear.notification.view.a.C3377a r118 = (com.bytedance.ee.bear.notification.view.a.C3377a) r117.next();
            if (TextUtils.isEmpty(r118.f235149a) == true) goto L35;
            int r119 = r118.f235150b;
            int r120 = r118.f235151c;
            if (r119 >= r120) goto L35;
            r100.S5(r119, r120, new ek5.b(r100, r118));
        L41:
            r100.setVisibility(0);
            return;
        }
    }

    public class b implements g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.notification.a.InterfaceC3374a f235114a;

        public b(com.bytedance.ee.bear.notification.a.InterfaceC3374a r100) {
            this.f235114a = r100;
        }

        @Override // com.bytedance.ee.bear.notification.g.a
        public final void closeNotification(String r100) {
            this.f235114a.closeNotification(r100);
        }

        @Override // com.bytedance.ee.bear.notification.g.a
        public final void showNotification(String r100, List<String> r101, String r102) {
            this.f235114a.showNotification(r100, r101, r102);
        }
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final com.bytedance.ee.bear.notification.a.b d() {
        return new a();
    }

    public f() {
        this.f235112a = new HashMap();
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void a(String r100) {
        ((g) org.koin.java.a.a(g.class)).a(r100);
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void b(com.bytedance.ee.bear.notification.a.InterfaceC3374a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        g.a r101 = (g.a) ((HashMap) this.f235112a).remove(r100);
        if (r101 == null) goto L7;
        ((g) org.koin.java.a.a(g.class)).c(r101);
    L7:
        b r102 = new b(r100);
        ((g) org.koin.java.a.a(g.class)).b(r102);
        ((HashMap) this.f235112a).put(r100, r102);
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void c(com.bytedance.ee.bear.notification.a.InterfaceC3374a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        g.a r101 = (g.a) ((HashMap) this.f235112a).remove(r100);
        if (r101 == null) goto L8;
        ((g) org.koin.java.a.a(g.class)).c(r101);
        return;
    }
}
