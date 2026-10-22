package d05;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends vv4.a {

    /* JADX INFO: renamed from: d05.a$a, reason: collision with other inner class name */
    public static class C0211a implements tb5.i<Void> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C0211a() {
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

    public a() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.user.onMinaConfigChange", new C0211a());
        bindBridgeHandlerAutoUnbind("biz.user.onFGConfigChange", new e());
    }
}
