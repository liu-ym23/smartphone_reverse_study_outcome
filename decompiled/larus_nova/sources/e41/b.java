package e41;

import com.bytedance.android.live.revlink.impl.pk.feedview.utils.ILiveRoomMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470977a = 0;

    static {
    }

    public static boolean a(IRoom r100, boolean r101) {
        if (r101 == false) goto L8;
        if (r100 != null) goto L6;
    L12:
        return false;
    L6:
        if (r100.getLiveRoomMode() != ILiveRoomMode.ThirdParty.getValue()) goto L12;
        return true;
    L8:
        if (r100 == null) goto L12;
        if (r100.isThirdParty() != true) goto L12;
        return true;
    }
}
