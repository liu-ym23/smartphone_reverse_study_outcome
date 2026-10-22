package sj1;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.ui.q6;
import com.bytedance.android.livesdk.config.yb1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q6 f542274a;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // sj1.a
    public final void V8(yj1.a r100) {
        q6 r101 = this.f542274a;
        if (r101 == null) goto L6;
        r101.a();
        q6 r102 = this.f542274a;
        r102.f113914d = 0;
        r102.f113917g.f71515a = 0;
        r100.f568056c.tp(null);
        return;
    }

    @Override // sj1.a
    public final void fq(com.bytedance.android.livesdk.room.b r100, yj1.a r101) {
        if (yb1.b() == false) goto L11;
        Bundle r102 = r100.f510497d;
        if (r101.f568056c == null) goto L12;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.containsKey(ILiveRoomPlayFragmentConstant.FEED_LIVE_VIEW_STUB) == true) goto L14;
        r101.f568056c.tp(this.f542274a);
        ALogger.d("InteractPreloadService", "[layoutLoad] set pre load manager to player widget " + this.f542274a);
        return;
    L14:
        return;
    L12:
        return;
    }
}
