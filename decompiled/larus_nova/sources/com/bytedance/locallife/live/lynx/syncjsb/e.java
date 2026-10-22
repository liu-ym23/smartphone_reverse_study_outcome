package com.bytedance.locallife.live.lynx.syncjsb;

import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.locallife.live.util.w;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends com.bytedance.locallife.live.lynx.syncjsb.a {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "live_local_life_room_info";
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return com.bytedance.locallife.live.lynx.syncjsb.a.d(this, w.h(LiveLocalLifeUtil.e(this.f260599a)), 1);
    }
}
