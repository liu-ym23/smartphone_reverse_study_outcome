package llc;

import com.ss.ugc.effectplatform.bridge.network.INetworkClient;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements com.ss.ugc.effectplatform.bridge.network.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.bridge.network.b f509818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final INetworkClient f509819b;

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void cancel(String r100) {
        this.f509818a.cancel(r100);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public final NetResponse fetchFromNetwork(NetRequest r100) {
        return this.f509819b.fetchFromNetwork(r100);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void pause(String r100) {
        this.f509818a.pause(r100);
    }

    public d(b r100, INetworkClient r101) {
        this.f509818a = r100;
        this.f509819b = r101;
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final NetResponse a(NetRequest r100, String r101, String r102, com.ss.ugc.effectplatform.bridge.network.a r103) {
        return this.f509818a.a(r100, r101, r102, r103);
    }
}
