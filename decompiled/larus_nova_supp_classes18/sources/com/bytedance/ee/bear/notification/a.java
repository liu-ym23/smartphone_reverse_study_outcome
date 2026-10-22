package com.bytedance.ee.bear.notification;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$a, reason: collision with other inner class name */
    public interface InterfaceC0127a {
        void closeNotification(String r1);

        void showNotification(String r1, List<String> r2, String r3);
    }

    public interface b {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$b$a, reason: collision with other inner class name */
        public interface InterfaceC0128a {
            void a(String r1);
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$b$b, reason: collision with other inner class name */
        public interface InterfaceC0129b {
            void a(String r1);
        }

        void a();

        List<String> b();

        void c(String r1, String r2);

        void d(InterfaceC0129b r1);

        View e(Context r1);

        void f(InterfaceC0128a r1);

        String g();
    }

    void a(String r1);

    void b(InterfaceC0127a r1);

    void c(InterfaceC0127a r1);

    b d();
}
