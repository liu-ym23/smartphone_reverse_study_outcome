package g35;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.persistence.JsPreference;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.AbsChameleonService;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ml5.b f479814a;

    /* JADX INFO: renamed from: g35.a$a, reason: collision with other inner class name */
    public class C5981a implements i<JsPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f479815a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public C5981a(a r100) {
            this.f479815a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JsPreference r102 = (JsPreference) r100;
            if (r102 == null) goto L8;
            String r103 = r102.getKey();
            if (r103 == null) goto L9;
            JSONObject r104 = new JSONObject();
            r104.put2("value", this.f479815a.f479814a.a(r103, new JSONObject().toString()));
            r101.b(r104);
            return;
        L9:
            return;
        }
    }

    public class b implements i<JsPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f479816a;

        @Override // tb5.i, tb5.o
        public final BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public b(a r100) {
            this.f479816a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            JsPreference r102 = (JsPreference) r100;
            String r103 = r102.getKey();
            String r104 = r102.getValue();
            if (r103 == null) goto L7;
            if (r104 == null) goto L8;
            this.f479816a.f479814a.b(r103, r104);
            return;
        L8:
            return;
        }
    }

    public a() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        this.f479814a = new ml5.b("JSPreference");
        bindBridgeHandlerAutoUnbind("biz.util.setPreference", new b(this));
        bindBridgeHandlerAutoUnbind("biz.util.getPreference", new C5981a(this));
    }
}
