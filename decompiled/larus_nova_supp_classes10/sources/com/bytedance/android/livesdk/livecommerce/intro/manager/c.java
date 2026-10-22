package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(i r8, IntroCardScene r9, int r10) {
            r8.e(r9, null, null, null, null, null, null);
        }
    }

    boolean a(Integer r1);

    List<uh2.a> b();

    com.bytedance.android.livesdk.livecommerce.intro.event.j c();

    void d(LiveIntroResponse r1);

    void e(IntroCardScene r1, Pair<Long, Long> r2, sh2.b r3, String r4, Map<String, String> r5, Function2<? super LiveIntroResponse, ? super List<? extends uh2.a>, Unit> r6, sh2.a r7);

    void f(List<? extends uh2.a> r1);

    void g(String r1, String r2, boolean r3);

    boolean h(sh2.a r1);

    Integer j();
}
