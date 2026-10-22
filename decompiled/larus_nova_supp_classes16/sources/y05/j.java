package y05;

import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j extends AbsChameleonService {
    public j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(IChameleonHandlerContext r3) {
        super.onAttach(r3);
        bindBridgeHandlerAutoUnbind("biz.util.fetchDomainConfig", new i((s45.c) org.koin.java.a.a(s45.c.class), r3));
    }
}
