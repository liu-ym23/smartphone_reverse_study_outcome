package kx;

import android.content.Context;
import com.bytedance.android.latch.LatchProcessOptions;
import com.lynx.tasm.LynxView;
import lx.c;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends com.bytedance.android.latch.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C6624a f506524c = null;

    /* JADX INFO: renamed from: kx.a$a, reason: collision with other inner class name */
    public static final class C6624a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C6624a f506525b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.latch.xbridge.internal.a.C0931a f506526a;

        static {
            f506525b = new C6624a();
        }

        public C6624a() {
            this.f506526a = com.bytedance.android.latch.xbridge.internal.a.f58505e;
        }
    }

    public interface b extends com.bytedance.android.latch.a.d {
        void y(LynxView r100);
    }

    static {
        f506524c = C6624a.f506525b;
    }

    c a(LatchProcessOptions r100);

    b c(Context r100, String r101, com.bytedance.android.latch.a.b r102, LatchProcessOptions r103);
}
