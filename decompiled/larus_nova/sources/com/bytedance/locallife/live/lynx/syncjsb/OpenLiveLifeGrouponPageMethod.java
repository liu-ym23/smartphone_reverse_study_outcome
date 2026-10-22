package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.util.j0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class OpenLiveLifeGrouponPageMethod extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "openLiveLifeGrouponPage";
    }

    public OpenLiveLifeGrouponPageMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(final HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        j0.h(new OpenLiveLifeGrouponPageMethod$handleMethod$1(r100, this));
        return a.d(this, null, 3);
    }
}
