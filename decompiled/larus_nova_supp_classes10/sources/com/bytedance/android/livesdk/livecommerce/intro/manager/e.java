package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface e {
    Observable<LiveIntroResponse> a(com.bytedance.android.livesdk.livecommerce.room.model.e r1, IntroCardScene r2, boolean r3, boolean r4, Pair<Long, Long> r5, sh2.b r6, String r7, Map<String, String> r8);
}
