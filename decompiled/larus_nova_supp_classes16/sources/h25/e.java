package h25;

import com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends GetCreatedDocHandler {
    public final IChameleonHandlerContext b;

    @Override // com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler
    public final BearUrl a() {
        IChameleonHandlerContext r0 = this.b;
        if (r0 == null) goto L7;
        o45.a r1 = (o45.a) r0.getWebService(o45.a.class);
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return null;
    }

    public e(IChameleonHandlerContext r1) {
        this.b = r1;
    }
}
