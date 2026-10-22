package com.bytedance.ee.bear.notification;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$a, reason: collision with other inner class name */
    public interface InterfaceC3374a {
        void closeNotification(String r100);

        void showNotification(String r100, List<String> r101, String r102);
    }

    public interface b {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$b$a, reason: collision with other inner class name */
        public interface InterfaceC3375a {
            void a(String r100);
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.notification.a$b$b, reason: collision with other inner class name */
        public interface InterfaceC3376b {
            void a(String r100);
        }

        void a();

        List<String> b();

        void c(String r100, String r101);

        void d(InterfaceC3376b r100);

        View e(Context r100);

        void f(InterfaceC3375a r100);

        String g();
    }

    void a(String r100);

    void b(InterfaceC3374a r100);

    void c(InterfaceC3374a r100);

    b d();
}
