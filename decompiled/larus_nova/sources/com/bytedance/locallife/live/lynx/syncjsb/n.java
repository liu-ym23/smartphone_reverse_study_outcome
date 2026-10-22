package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n extends com.bytedance.locallife.live.lynx.syncjsb.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "switchHalfScreenMode";
    }

    public n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        Integer r101 = w.b(r100, "page_type");
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        String r103 = w.f(r100, "current_screen_mode");
        if (r103 != null) goto L9;
        r103 = "0";
    L9:
        vn6.b.a(new fv6.b(r103, r102));
        return com.bytedance.locallife.live.lynx.syncjsb.a.d(this, null, 3);
    L5:
        r102 = 1;
        goto L6
    }
}
