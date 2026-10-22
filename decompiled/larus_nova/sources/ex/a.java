package ex;

import android.content.Context;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.jsb2.internal.c;
import com.bytedance.ies.web.jsbridge2.d0;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends com.bytedance.android.latch.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C5828a f474617b = null;

    /* JADX INFO: renamed from: ex.a$a, reason: collision with other inner class name */
    public static final class C5828a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C5828a f474618b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.a f474619a;

        static {
            f474618b = new C5828a();
        }

        public C5828a() {
            this.f474619a = c.f58410e;
        }
    }

    public interface b extends com.bytedance.android.latch.a.d {
        void f(d0 r100);
    }

    static {
        f474617b = C5828a.f474618b;
    }

    fx.b a(LatchProcessOptions r100);

    b b(Context r100, String r101, com.bytedance.android.annie.lynx.service.latch.c r102, LatchProcessOptions r103);
}
