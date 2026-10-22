package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.keva.Keva;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "getGenericKey";
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = w.f(r100, "lynxGetKey");
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (r101.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return a.b("key isNullOrEmpty");
    L13:
        return a.d(this, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("lynxGetValue", Keva.getRepo("live_local_life").getString(r101, ""))}), 1);
    L8:
        r102 = false;
        goto L9
    }
}
