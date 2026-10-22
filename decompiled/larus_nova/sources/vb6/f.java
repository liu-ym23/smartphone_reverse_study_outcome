package vb6;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import fr2.u;
import kotlin.jvm.internal.Intrinsics;
import yb6.k;
import yb6.o;

/* JADX INFO: loaded from: classes19.dex */
public interface f extends bc6.b, wb6.a.h, wb6.a.InterfaceC8088a, wb6.a.c, yb6.a, wb6.a.e, k, yb6.d, yb6.c, o, u, wb6.a.b, yb6.b {

    public static final class a {
        public static void a(ec6.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "client");
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r100, "client");
            Intrinsics.checkNotNullParameter(r101, "source");
        }

        public static void b(ei6.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "client");
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r100, "client");
            Intrinsics.checkNotNullParameter(r101, "source");
        }
    }

    void H1();

    void H4(z0 r100);

    void M1();

    void M4(cc6.b r100);

    void Ra(com.bytedance.android.live.liveinteract.multianchor.model.b r100);

    @Override // bc6.b
    void W(long r100, OperateType r101);

    void X1(int r100, int r101, Exception r102);

    void Y4();

    void ag(h1 r100);

    @Override // bc6.b
    void c1(long r100, OperateType r101, BaseCheckException r102);

    void fe(z0 r100);

    void q2(int r100, int r101, int r102);

    void ra();

    void y1(z0 r100);

    void z2(z0 r100);
}
