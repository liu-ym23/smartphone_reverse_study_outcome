package m45;

import com.bytedance.ee.bear.document.vibra.VibrateMsg;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.AbsChameleonService;
import eu5.h;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {

    /* JADX INFO: renamed from: m45.a$a, reason: collision with other inner class name */
    public class C6768a implements i<VibrateMsg> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f511842a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public C6768a(a r100) {
            this.f511842a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            VibrateMsg r102 = (VibrateMsg) r100;
            tt5.a.h("VibrateWebService", "Vibrate:" + r102);
            if (r102 == null) goto L6;
            h.a(this.f511842a.getContext(), r102.time, r102.strength);
            return;
        }
    }

    public a() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.util.triggerShake", new C6768a(this));
    }
}
