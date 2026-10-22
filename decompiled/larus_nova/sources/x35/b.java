package x35;

import com.ss.android.lark.chameleon.AbsChameleonService;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends AbsChameleonService {
    public b() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.statistics.reportEvent", new a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)));
    }
}
