package s10;

import ac2.k;
import com.bytedance.android.live.broadcastgame.opengame.network.a0;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements amc.i {
    public e() {
    }

    @Override // amc.i
    public final boolean b() {
        return false;
    }

    @Override // amc.i
    public final lmc.h c() {
        return null;
    }

    @Override // amc.i
    public final boolean d() {
        return false;
    }

    @Override // amc.i
    public final boolean enable() {
        return true;
    }

    @Override // amc.i
    public final String e() {
        StringBuilder r100 = new StringBuilder("https://");
        int r101 = a0.f60295a;
        r100.append(a0.a.a());
        r100.append("/webcast/im/gw/uplink/message/");
        return r100.toString();
    }

    @Override // amc.i
    public final long a() {
        return k.a();
    }
}
