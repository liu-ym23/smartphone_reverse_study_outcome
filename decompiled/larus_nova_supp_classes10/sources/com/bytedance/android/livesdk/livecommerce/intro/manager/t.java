package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements e {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ IntroCardScene a;

        public a(IntroCardScene r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ((LiveIntroResponse) r2).setCardReqScene(this.a);
        }
    }

    public t() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.e
    public final Observable<LiveIntroResponse> a(com.bytedance.android.livesdk.livecommerce.room.model.e r14, IntroCardScene r15, boolean r16, boolean r17, Pair<Long, Long> r18, sh2.b r19, String r20, Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r14, "roomInfo");
        Intrinsics.checkNotNullParameter(r15, "cardScene");
        int r1 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("[query] queryIntro for scene=" + r15);
        sh2.d r12 = new sh2.d(r20, r14.roomId(), r14.a(), r14.getGroupId(), r14.c(), r14.d(), r14.e("live_popup_card"), r17, r19, r15);
        String r0 = vi2.h.a;
        if (TextUtils.isEmpty(r12.a) == false) goto L11;
        IntroCardScene r2 = r12.j;
        if (r2 != IntroCardScene.ENTER_ROOM) goto L8;
        String r3 = si2.g.Z;
    L12:
        OptCardUtil.b(null, "getPopIntro");
        return vi2.h.e(r12.b, r12.c, r3, new vi2.i(r12, r21, r3, r16)).doOnNext(new a(r15));
    L8:
        if (r2 != IntroCardScene.REFRESH_MESSAGE) goto L10;
        r3 = si2.g.b0;
        goto L12
    L10:
        r3 = si2.g.a0;
        goto L12
    L11:
        r3 = r12.a;
        goto L12
    }
}
