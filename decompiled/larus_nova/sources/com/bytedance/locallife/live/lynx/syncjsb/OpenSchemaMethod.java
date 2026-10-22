package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class OpenSchemaMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "openSchema";
    }

    public OpenSchemaMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        final String r101 = y.d(r100, "url");
        final int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        Integer r104 = y.b(r100, "show_live_window_when_open_next_page");
        if (r104 == null) goto L15;
        r102 = r104.intValue();
    L15:
        final String r105 = y.d(r100, "show_live_window_request_page");
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        j0.h(new OpenSchemaMethod$handleMethod$1(r102, r105, r101));
        return a.d(this, null, 3);
    L11:
        return a.b("url is null or empty");
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
