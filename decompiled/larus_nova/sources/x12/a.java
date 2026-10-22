package x12;

import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveDataKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final IGroupLiveData a(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$groupLiveData");
        if ((r100 instanceof IRoom) == true) goto L5;
        r100 = null;
    L5:
        IRoom r101 = (IRoom) r100;
        if (r101 == null) goto L13;
        IMainRoom r102 = (IMainRoom) r101.castToOrNull(IMainRoom.class);
        if (r102 == null) goto L14;
        com.bytedance.android.live.revenue.model.extension.main.c r103 = r102.getMainOthers();
        if (r103 != null) goto L12;
        return null;
    L12:
        return r103.getGroupLiveData();
    L14:
        return null;
    L13:
        return null;
    }

    public static final boolean b(IRoomBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGroupLive");
        IGroupLiveData r101 = a(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return IGroupLiveDataKt.isGroupLiveKmp(r101);
    }
}
