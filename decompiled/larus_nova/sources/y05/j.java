package y05;

import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;

/* JADX INFO: loaded from: classes16.dex */
public final class j extends AbsChameleonService {
    public j() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final void onAttach(IChameleonHandlerContext r100) {
        super.onAttach(r100);
        bindBridgeHandlerAutoUnbind("biz.util.fetchDomainConfig", new i((s45.c) org.koin.java.a.a(s45.c.class), r100));
    }
}
