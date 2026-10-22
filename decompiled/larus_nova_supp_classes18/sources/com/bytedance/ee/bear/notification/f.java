package com.bytedance.ee.bear.notification;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.notification.view.NotificationView;
import com.bytedance.mt.protector.impl.PatternProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements com.bytedance.ee.bear.notification.a {
    public final Map<com.bytedance.ee.bear.notification.a.InterfaceC0127a, g.a> a;

    public class a implements com.bytedance.ee.bear.notification.a.b {
        public NotificationView a;

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void a() {
            NotificationView r0 = this.a;
            if (r0 == null) goto L6;
            r0.getClass();
            tt5.a.b("NotificationView", "closeNotification");
            r0.y = null;
            r0.setText("");
            r0.setVisibility(8);
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final List<String> b() {
            NotificationView r0 = this.a;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getLinkUrls();
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final String g() {
            NotificationView r0 = this.a;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.getNotificationId();
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void d(com.bytedance.ee.bear.notification.a.b.InterfaceC0129b r3) {
            NotificationView r0 = this.a;
            if (r0 == null) goto L6;
            r0.setOnLinkClickListener(new d(r3));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final View e(Context r2) {
            if (this.a != null) goto L6;
            this.a = new NotificationView(r2);
        L6:
            return this.a;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void f(com.bytedance.ee.bear.notification.a.b.InterfaceC0128a r3) {
            NotificationView r0 = this.a;
            if (r0 == null) goto L6;
            r0.setOnCloseListener(new e(r3));
            return;
        }

        @Override // com.bytedance.ee.bear.notification.a.b
        public final void c(String r13, String r14) {
            final NotificationView r0 = this.a;
            if (r0 == null) goto L62;
            r0.getClass();
            tt5.a.b("NotificationView", "showNotification");
            r0.y = r13;
            r0.Z5();
            Matcher r1 = PatternProtector.compile("<a[^<>]*>[^<>]*</a>").matcher(r14);
            com.bytedance.ee.bear.notification.view.a r2 = new com.bytedance.ee.bear.notification.view.a(r14);
        L6:
            if (r1.find() == false) goto L31;
            int r3 = r1.start();
            int r5 = r1.end();
            String r6 = r14.substring(r3, r5);
            XmlPullParser r7 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: IOException -> L27 Throwable -> L29
            r7.setInput(new StringReader(r6));     // Catch: IOException -> L27 Throwable -> L29
            int r8 = r7.getEventType();     // Catch: IOException -> L27 Throwable -> L29
            String r9 = "";
            String r10 = "";
        L11:
            if (r8 == 1) goto L22;
            String r11 = r7.getName();     // Catch: IOException -> L27 Throwable -> L29
            if (r8 == 2) goto L19;
            if (r8 != 4) goto L21;
            tt5.a.b("ALinkParser", "pullParser: parse text");     // Catch: IOException -> L27 Throwable -> L29
            r9 = r7.getText();     // Catch: IOException -> L27 Throwable -> L29
        L21:
            r8 = r7.next();     // Catch: IOException -> L27 Throwable -> L29
            goto L11
        L19:
            if ("a".equals(r11) == false) goto L21;
            tt5.a.b("ALinkParser", "pullParser: parse start tag");     // Catch: IOException -> L27 Throwable -> L29
            r10 = r7.getAttributeValue(null, "href");     // Catch: IOException -> L27 Throwable -> L29
            goto L21
        L22:
            String r4 = r14.substring(r3, r5);     // Catch: IOException -> L27 Throwable -> L29
            int r12 = r2.a.indexOf(r4);     // Catch: IOException -> L27 Throwable -> L29
            int r15 = r4.length() + r12;     // Catch: IOException -> L27 Throwable -> L29
            r2.a = new StringBuilder(r2.a).replace(r12, r15, r9).toString();     // Catch: IOException -> L27 Throwable -> L29
            com.bytedance.ee.bear.notification.view.a.C0130a r16 = new com.bytedance.ee.bear.notification.view.a.C0130a(r10, r12, r9.length() + r12);     // Catch: IOException -> L27 Throwable -> L29
            if (r2.b != null) goto L25;
            r2.b = new ArrayList();     // Catch: IOException -> L27 Throwable -> L29
        L25:
            ((ArrayList) r2.b).add(r16);     // Catch: IOException -> L27 Throwable -> L29
        L29:
            e = move-exception;
            tt5.a.e("ALinkParser", "error when parse xml", e, false);
            goto L6
        L31:
            r0.B = r2;
            r0.setText(r2.a);
            if (hu5.a.d(r2.b) == true) goto L41;
            Iterator r17 = ((ArrayList) r2.b).iterator();
        L35:
            if (r17.hasNext() == false) goto L41;
            final com.bytedance.ee.bear.notification.view.a.C0130a r18 = (com.bytedance.ee.bear.notification.view.a.C0130a) r17.next();
            if (TextUtils.isEmpty(r18.a) == true) goto L35;
            int r19 = r18.b;
            int r20 = r18.c;
            if (r19 >= r20) goto L35;
            r0.S5(r19, r20, new ek5.b(r0, r18));
        L41:
            r0.setVisibility(0);
            return;
        }
    }

    public class b implements g.a {
        public final /* synthetic */ com.bytedance.ee.bear.notification.a.InterfaceC0127a a;

        public b(com.bytedance.ee.bear.notification.a.InterfaceC0127a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.notification.g.a
        public final void closeNotification(String r2) {
            this.a.closeNotification(r2);
        }

        @Override // com.bytedance.ee.bear.notification.g.a
        public final void showNotification(String r2, List<String> r3, String r4) {
            this.a.showNotification(r2, r3, r4);
        }
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final com.bytedance.ee.bear.notification.a.b d() {
        return new a();
    }

    public f() {
        this.a = new HashMap();
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void a(String r2) {
        ((g) org.koin.java.a.a(g.class)).a(r2);
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void b(com.bytedance.ee.bear.notification.a.InterfaceC0127a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        g.a r0 = (g.a) ((HashMap) this.a).remove(r3);
        if (r0 == null) goto L7;
        ((g) org.koin.java.a.a(g.class)).c(r0);
    L7:
        b r1 = new b(r3);
        ((g) org.koin.java.a.a(g.class)).b(r1);
        ((HashMap) this.a).put(r3, r1);
    }

    @Override // com.bytedance.ee.bear.notification.a
    public final void c(com.bytedance.ee.bear.notification.a.InterfaceC0127a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        g.a r3 = (g.a) ((HashMap) this.a).remove(r2);
        if (r3 == null) goto L8;
        ((g) org.koin.java.a.a(g.class)).c(r3);
        return;
    }
}
