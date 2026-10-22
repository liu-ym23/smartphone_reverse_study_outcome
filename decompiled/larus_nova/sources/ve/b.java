package ve;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements c<a> {
    public b() {
    }

    @Override // am3.c
    public final a decode(g r100) throws Exception {
        a r101 = new a();
        r101.targetOpenIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L30;
        if (r103 != 1) goto L8;
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.msgType = r100.i();
        goto L3
    L10:
        if (r103 != 8) goto L12;
        r101.ecomNotice = h.c(r100);
        goto L3
    L12:
        if (r103 != 10) goto L14;
        r101.updateType = r100.i();
        goto L3
    L14:
        if (r103 != 26) goto L16;
        r101.updatedCartInfo = com.bytedance.android.ec.adapter.api.message.model.a.a(r100);
        goto L3
    L16:
        if (r103 != 5000) goto L18;
        r101.targetOpenIds.add(h.c(r100));
        goto L3
    L18:
        if (r103 != 21) goto L20;
        r101.commerceAuthorityChangeToast = h.c(r100);
        goto L3
    L20:
        if (r103 != 22) goto L21;
        r101.traceTimeMetric = de.c.a(r100);
        goto L3
    L21:
        h.e(r100);
        goto L3
    L30:
        r100.d(r102);
        return r101;
    }
}
