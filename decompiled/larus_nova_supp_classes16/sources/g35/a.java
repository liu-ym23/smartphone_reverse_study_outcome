package g35;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.persistence.JsPreference;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.AbsChameleonService;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public ml5.b a;

    /* JADX INFO: renamed from: g35.a$a, reason: collision with other inner class name */
    public class C0232a implements i<JsPreference> {
        public final /* synthetic */ a a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public C0232a(a r1) {
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

    public class b implements i<JsPreference> {
        public final /* synthetic */ a a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(a r1) {
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

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        this.a = new ml5.b("JSPreference");
        bindBridgeHandlerAutoUnbind("biz.util.setPreference", new b(this));
        bindBridgeHandlerAutoUnbind("biz.util.getPreference", new C0232a(this));
    }
}
