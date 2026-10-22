package mx4;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final NetService a;
    public final NetService.d<DocumentListInfo> b;
    public NetService.f c;

    public h() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        this.a = r0;
        this.b = r0.Vc(new u());
    }
}
