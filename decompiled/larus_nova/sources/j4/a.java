package j4;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import d3.a0;
import m4.c;

/* JADX INFO: loaded from: classes43.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6391a f497160a = null;

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public static final class C6391a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C6391a f497161a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static a f497162b;

        static {
            f497161a = new C6391a();
        }

        public C6391a() {
        }

        public static a a() {
            if (f497162b != null) goto L6;
            com.bytedance.ai.applet.base.log.a.d("ai_bridge", "bridge monitor is not registered!", null);
        L6:
            return f497162b;
        }
    }

    static {
        f497160a = C6391a.f497161a;
    }

    void a(String r100);

    void b(String r100, ProtocolMessage r101);

    void c(String r100);

    void d(String r100);

    void e(String r100, long r101);

    void f(String r100, a0 r101, String r102);

    void g(String r100, long r101, a0 r102, String r103, c r104);

    void h(String r100);

    void i(String r100, c r101);

    void j(String r100);

    void k(String r100, ContainerType r101);

    void l(String r100, c r101);

    void markError(String r100);
}
