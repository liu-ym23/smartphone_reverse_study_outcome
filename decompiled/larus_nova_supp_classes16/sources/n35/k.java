package n35;

import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends AbsChameleonService {
    public final String a;

    public static final class a {
    }

    static {
    }

    public k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsbCheckKey");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(vv4.k r3) {
        Intrinsics.checkNotNullParameter(r3, "web");
        super.onAttachToWeb(r3);
        bindBridgeHandlerAutoUnbind("biz.util.setData", new m(this.a));
        bindBridgeHandlerAutoUnbind("biz.util.getData", new j());
        bindBridgeHandlerAutoUnbind("biz.util.collectData", new b());
        bindBridgeHandlerAutoUnbind("biz.util.collectDataV2", new e());
        bindBridgeHandlerAutoUnbind("biz.util.setDataV2", new o35.l(this.a));
        bindBridgeHandlerAutoUnbind("biz.util.getDataV2", new o35.d());
        IChameleonHandlerContext r4 = r3.getWebView();
        if ((r4 instanceof IChameleonHandlerContext) == false) goto L5;
        IChameleonHandlerContext r5 = r4;
    L6:
        bindBridgeHandlerAutoUnbind("biz.util.getOfflineCreatedDoc", new h25.e(r5));
        return;
    L5:
        r5 = null;
        goto L6
    }
}
