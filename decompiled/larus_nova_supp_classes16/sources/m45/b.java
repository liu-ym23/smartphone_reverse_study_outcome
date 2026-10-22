package m45;

import com.bytedance.ee.bear.document.vibra.VibrateMsg;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import eu5.h;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends vv4.a {

    public class a implements i<VibrateMsg> {
        public final /* synthetic */ b a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(b r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            VibrateMsg r4 = (VibrateMsg) r2;
            tt5.a.h("VibrateWebService", "Vibrate:" + r4);
            if (r4 == null) goto L6;
            h.a(this.a.getContext(), r4.time, r4.strength);
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.util.triggerShake", new a(this));
    }
}
