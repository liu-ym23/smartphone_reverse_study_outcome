package m45;

import com.bytedance.ee.bear.document.vibra.VibrateMsg;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.AbsChameleonService;
import eu5.h;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: m45.a$a, reason: collision with other inner class name */
    public class C0253a implements i<VibrateMsg> {
        public final /* synthetic */ a a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C0253a(a r1) {
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

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r2) {
        super.onAttachToWeb(r2);
        bindBridgeHandlerAutoUnbind("biz.util.triggerShake", new C0253a(this));
    }
}
