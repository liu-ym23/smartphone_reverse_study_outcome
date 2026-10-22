package d05;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends vv4.a {

    /* JADX INFO: renamed from: d05.a$a, reason: collision with other inner class name */
    public static class C5613a implements tb5.i<Void> {
        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C5613a() {
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            if (r101 != null) goto L5;
            tt5.a.d("MinaConfigHandler", "handle, callback is null");
            return;
        L5:
            JSONObject r103 = JSON.parseObject((String) com.bytedance.ee.bear.appsetting.c.a.f206237a.d("app_config", SliceInitService.DEFAULT_SWITCH));
            tt5.a.b("MinaConfigHandler", "callback = " + r103);
            r101.b(r103);
        }
    }

    public a() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.user.onMinaConfigChange", new C5613a());
        bindBridgeHandlerAutoUnbind("biz.user.onFGConfigChange", new e());
    }
}
