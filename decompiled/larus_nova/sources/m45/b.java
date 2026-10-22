package m45;

import com.bytedance.ee.bear.document.vibra.VibrateMsg;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import eu5.h;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends vv4.a {

    public class a implements i<VibrateMsg> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f511843a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(b r100) {
            this.f511843a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            VibrateMsg r102 = (VibrateMsg) r100;
            tt5.a.h("VibrateWebService", "Vibrate:" + r102);
            if (r102 == null) goto L6;
            h.a(this.f511843a.getContext(), r102.time, r102.strength);
            return;
        }
    }

    public b() {
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r100) {
        super.onAttachToWeb(r100);
        bindBridgeHandlerAutoUnbind("biz.util.triggerShake", new a(this));
    }
}
