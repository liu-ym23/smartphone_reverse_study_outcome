package com.bytedance.locallife.live.lynx.syncjsb;

import com.byted.cast.common.sink.ISendResultListener;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class ShowLocalToastMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "showLocalToast";
    }

    public ShowLocalToastMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        final String r101 = y.d(r100, "message");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        j0.h(new ShowLocalToastMethod$handleMethod$1(r101));
        return a.d(this, null, 3);
    L11:
        return a.b(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
