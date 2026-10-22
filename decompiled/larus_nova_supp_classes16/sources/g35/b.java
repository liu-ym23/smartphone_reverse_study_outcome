package g35;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.persistence.JsPreference;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends vv4.a {
    public ml5.b a;

    public class a implements i<JsPreference> {
        public final /* synthetic */ b a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            JsPreference r6 = (JsPreference) r4;
            if (r6 == null) goto L8;
            String r7 = r6.getKey();
            if (r7 == null) goto L9;
            JSONObject r0 = new JSONObject();
            r0.put("value", this.a.a.a(r7, new JSONObject().toString()));
            r5.b(r0);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: g35.b$b, reason: collision with other inner class name */
    public class C0233b implements i<JsPreference> {
        public final /* synthetic */ b a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C0233b(b r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            JsPreference r4 = (JsPreference) r2;
            String r5 = r4.getKey();
            String r6 = r4.getValue();
            if (r5 == null) goto L7;
            if (r6 == null) goto L8;
            this.a.a.b(r5, r6);
            return;
        L8:
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        this.a = new ml5.b("JSPreference");
        bindBridgeHandlerAutoUnbind("biz.util.setPreference", new C0233b(this));
        bindBridgeHandlerAutoUnbind("biz.util.getPreference", new a(this));
    }
}
