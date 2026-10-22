package mx4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.u;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f516240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetService.d<DocumentListInfo> f516241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public NetService.f f516242c;

    public h() {
        NetService r100 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        this.f516240a = r100;
        this.f516241b = r100.Vc(new u());
    }
}
