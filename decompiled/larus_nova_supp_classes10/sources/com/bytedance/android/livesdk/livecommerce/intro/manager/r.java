package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements e {
    public final e a;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.e
    public final Observable<LiveIntroResponse> a(com.bytedance.android.livesdk.livecommerce.room.model.e r11, IntroCardScene r12, boolean r13, boolean r14, Pair<Long, Long> r15, sh2.b r16, String r17, Map<String, String> r18) {
        Intrinsics.checkNotNullParameter(r11, "roomInfo");
        Intrinsics.checkNotNullParameter(r12, "cardScene");
        return this.a.a(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public r() {
        t r0 = new t();
        Intrinsics.checkNotNullParameter(r0, "dataSource");
        this.a = r0;
    }
}
