package com.ss.android.lark.widget.photopicker;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.chat.entity.message.Message;
import java.io.File;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f447524a;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void A();

        String B();

        String C();

        File D();

        boolean E();

        boolean F();

        void G();

        Map H();

        void I();

        h J();

        boolean K();

        void L();

        void M();

        void a();

        void b();

        void c();

        Message d();

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        void m8699d();

        int e();

        File f();

        InterfaceC5419f g();

        b getChatDependency();

        Context getContext();

        e getForwardDependency();

        g getSecurityComplianceDependency();

        String getSession();

        String getUserId();

        void h();

        boolean i();

        boolean isPrimaryHost();

        void j();

        void k();

        void l();

        void m();

        a n();

        c o();

        void p();

        void q();

        void r();

        void s();

        boolean t();

        void u();

        int v();

        void w();

        ByteString x();

        void y();

        void z();
    }

    public interface e {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopicker.f$f, reason: collision with other inner class name */
    public interface InterfaceC5419f {
    }

    public interface g {
    }

    public interface h {
        void a();

        void b();

        boolean isInMeeting();
    }

    public f() {
    }

    public static d a() {
        if (f447524a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f447524a != null) goto L9;
        f447524a = (d) ClaymoreServiceLoader.loadFirst(d.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f447524a;
    }
}
