package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.goodsshelves.manager.ShelfDefaultTabManager;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.locallife.live.util.w;
import com.bytedance.locallife.live.util.y;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class FilterTabInfoMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "filterTabInfo";
    }

    public FilterTabInfoMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Integer r101 = w.b(r100, "tabId");
        if (r101 == null) goto L5;
        final int r102 = r101.intValue();
    L6:
        final boolean r103 = y.a(r100, "need_showing", false);
        j0.h(new FilterTabInfoMethod$handleMethod$1(this, r102, r103));
        return a.d(this, null, 3);
    L5:
        r102 = ShelfDefaultTabManager.b();
        goto L6
    }
}
