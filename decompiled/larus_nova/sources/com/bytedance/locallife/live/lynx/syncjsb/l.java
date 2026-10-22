package com.bytedance.locallife.live.lynx.syncjsb;

import android.app.Activity;
import com.byted.cast.common.sink.ISendResultListener;
import com.bytedance.locallife.biz.utils.ToastUtils;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "showToast";
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = y.d(r100, "message");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        Activity r103 = LiveLifeSaaSUtil.s().getCurrentActivity();
        if (r103 == null) goto L16;
        Lazy r104 = ToastUtils.f256981a;
        ToastUtils.a(r103, r101, 0);
    L16:
        return a.d(this, null, 3);
    L11:
        return a.b(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL);
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
