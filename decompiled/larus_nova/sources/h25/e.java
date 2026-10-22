package h25;

import com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler;
import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends GetCreatedDocHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IChameleonHandlerContext f483595b;

    @Override // com.bytedance.ee.bear.document.offline.create.GetCreatedDocHandler
    public final BearUrl a() {
        IChameleonHandlerContext r100 = this.f483595b;
        if (r100 == null) goto L7;
        o45.a r101 = (o45.a) r100.getWebService(o45.a.class);
        if (r101 == null) goto L7;
        return r101.f521964a;
    L7:
        return null;
    }

    public e(IChameleonHandlerContext r100) {
        this.f483595b = r100;
    }
}
