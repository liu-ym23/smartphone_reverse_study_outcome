package com.bytedance.android.livesdk.landscapeslide;

import com.bytedance.android.live.platformplayer.api.ILandSlideService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LandSlideService;", "Lcom/bytedance/android/live/platformplayer/api/ILandSlideService;", "", "isSlideAble", "", "getSelectedRoomId", "Lds0/d;", "session", "checkIsNotSupportLandFromDrawer", "roomSession", "", "showToast", "enableLand2Land", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandSlideService implements ILandSlideService {
    public LandSlideService() {
    }

    public long getSelectedRoomId() {
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r0 = LiveLandSlideContext.a.a();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getCurRoomId();
    }

    public boolean isSlideAble() {
        LiveLandSlideContext.Companion.getClass();
        return LiveLandSlideContext.a.b();
    }

    public boolean enableLand2Land() {
        return com.bytedance.android.livesdk.utils.landscape.b.a();
    }

    public boolean checkIsNotSupportLandFromDrawer(ds0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        LiveLandJumpContext.Companion.getClass();
        LiveLandJumpContext r0 = LiveLandJumpContext.a.a();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.checkIsNotSupportLandFromDrawer(r2);
    }

    public void showToast(ds0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "roomSession");
        LiveLandJumpContext.Companion.getClass();
        LiveLandJumpContext.a.c(r2);
    }
}
