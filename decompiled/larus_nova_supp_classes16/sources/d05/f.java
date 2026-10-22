package d05;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.AbsChameleonService;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends AbsChameleonService {

    public static class a implements tb5.i<Void> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            Void r6 = (Void) r4;
            if (r5 != null) goto L5;
            tt5.a.d("MinaConfigHandler", "handle, callback is null");
            return;
        L5:
            JSONObject r0 = JSON.parseObject((String) com.bytedance.ee.bear.appsetting.c.a.a.d("app_config", "{}"));
            tt5.a.b("MinaConfigHandler", "callback = " + r0);
            r5.b(r0);
        }
    }

    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.user.onMinaConfigChange", new a());
        bindBridgeHandlerAutoUnbind("biz.user.onFGConfigChange", new j());
    }
}
