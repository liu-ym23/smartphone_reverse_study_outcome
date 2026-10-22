package u31;

import b30.o;
import b30.p;
import b30.q;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kc0.g;
import kotlin.jvm.internal.Intrinsics;
import xs2.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements g {
    public a() {
    }

    @Override // kc0.g
    public final void c() {
        Intrinsics.checkNotNullParameter("", "source");
        o r100 = new o("");
        b.a().post(r100);
    }

    @Override // kc0.g
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
        q r101 = new q(r100);
        b.a().post(r101);
    }

    @Override // kc0.g
    public final void d(boolean r100) {
        b30.g r101 = new b30.g(true);
        b.a().post(r101);
    }

    @Override // kc0.g
    public final void b(int r100, int r101) {
        p r102 = new p(r100, r101);
        b.a().post(r102);
    }
}
