package iy0;

import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final IMainRoom a(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mainOrNull");
        return (IMainRoom) r100.castToOrNull(IMainRoom.class);
    }

    public static final boolean b(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGroupLive");
        IMainRoom r101 = (IMainRoom) r100.castToOrNull(IMainRoom.class);
        if (r101 == null) goto L9;
        com.bytedance.android.live.revenue.model.extension.main.c r102 = r101.getMainOthers();
        if (r102 == null) goto L9;
        IGroupLiveData r103 = r102.getGroupData();
        if (r103 == null) goto L9;
        return r103.isCurrentGroupLive();
    L9:
        return false;
    }
}
