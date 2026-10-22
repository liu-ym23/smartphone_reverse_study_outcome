package wi1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.h31;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements kn2.e {
    public j() {
    }

    @Override // kn2.e
    public final void a(kn2.k r100, int r101, int r102) {
        h31 r103 = com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106238a;
        ALogger.i("InnerFeedEmptyRecommendGuideUtil", "oldState = " + r101 + ", newState = " + r102);
        if (r101 == 2) goto L5;
    L11:
        if (r101 == 2) goto L13;
        return;
    L13:
        if (r102 != 5) goto L19;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106240c = "loading";
        return;
    L19:
        return;
    L5:
        if (r102 != 3) goto L11;
        if (r100 != null) goto L8;
    L10:
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106240c = "end";
        return;
    L8:
        if (r100.f504168l == false) goto L10;
        com.bytedance.android.livesdk.chatroom.followrecommendguide.a.f106240c = "more";
    }
}
