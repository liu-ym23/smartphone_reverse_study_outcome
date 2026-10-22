package com.bytedance.locallife.live.lynx.jsb;

import com.byted.cast.common.sink.ISendResultListener;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends a {
    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final String a() {
        return "log";
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.jsb.a
    public final void d(HashMap<String, Object> r100, Function1<? super Map<String, ? extends Object>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Object r102 = r100.get("message");
        if ((r102 instanceof String) == false) goto L5;
        String r103 = (String) r102;
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L16;
        a.c(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_MESSAGE_NULL, r101);
        return;
    L16:
        if (LiveLifeSaaSUtil.A() == true) goto L18;
    L18:
        a.e(r101);
        return;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
