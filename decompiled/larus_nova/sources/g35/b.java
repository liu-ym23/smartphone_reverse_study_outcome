package g35;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.persistence.JsPreference;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends vv4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ml5.b f479817a;

    public class a implements i<JsPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f479818a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(b r100) {
            this.f479818a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JsPreference r102 = (JsPreference) r100;
            if (r102 == null) goto L8;
            String r103 = r102.getKey();
            if (r103 == null) goto L9;
            JSONObject r104 = new JSONObject();
            r104.put2("value", this.f479818a.f479817a.a(r103, new JSONObject().toString()));
            r101.b(r104);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: g35.b$b, reason: collision with other inner class name */
    public class C5982b implements i<JsPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f479819a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C5982b(b r100) {
            this.f479819a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JsPreference r102 = (JsPreference) r100;
            String r103 = r102.getKey();
            String r104 = r102.getValue();
            if (r103 == null) goto L7;
            if (r104 == null) goto L8;
            this.f479819a.f479817a.b(r103, r104);
            return;
        L8:
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        this.f479817a = new ml5.b("JSPreference");
        bindBridgeHandlerAutoUnbind("biz.util.setPreference", new C5982b(this));
        bindBridgeHandlerAutoUnbind("biz.util.getPreference", new a(this));
    }
}
