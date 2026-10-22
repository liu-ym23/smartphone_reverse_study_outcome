package d25;

import com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler;
import f25.n;
import f25.s;
import g25.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends vv4.a implements vv4.e {
    public final List<vv4.e> a;

    public e() {
        this.a = new ArrayList();
    }

    @Override // vv4.e
    public final void a(String r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((vv4.e) r0.next()).a(r3);
        goto L4
    }

    @Override // vv4.a
    public final void onAttachToWeb(k r3) {
        super.onAttachToWeb(r3);
        s r0 = new s(false, r3);
        ((ArrayList) this.a).add(r0);
        bindBridgeHandlerAutoUnbind("biz.util.setData", r0);
        bindBridgeHandlerAutoUnbind("biz.util.getData", new n(false));
        i r4 = new i(false);
        ((ArrayList) this.a).add(r4);
        bindBridgeHandlerAutoUnbind("biz.util.setDataV2", r4);
        bindBridgeHandlerAutoUnbind("biz.util.getDataV2", new g25.c(false));
        bindBridgeHandlerAutoUnbind("biz.util.collectData", new n35.b());
        bindBridgeHandlerAutoUnbind("biz.util.collectDataV2", new n35.e());
        bindBridgeHandlerAutoUnbind("biz.util.setOfflineName", new m25.d());
        bindBridgeHandlerAutoUnbind("biz.util.getOfflineCreatedDoc", new GetCreatedDocHandler());
    }
}
