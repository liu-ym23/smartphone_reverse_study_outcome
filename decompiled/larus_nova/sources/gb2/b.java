package gb2;

import com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom;
import com.bytedance.android.livesdkapi.depend.model.live.ClientComponent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final ClientComponent a(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$clientComponentData");
        Intrinsics.checkNotNullParameter(r100, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r101 = (ICommunityMainRoom) r100.castToOrNull(ICommunityMainRoom.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getClientComponentData();
    }

    public static final RoomPublicScreenInfo b(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$publicScreenInfo");
        Intrinsics.checkNotNullParameter(r100, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r101 = (ICommunityMainRoom) r100.castToOrNull(ICommunityMainRoom.class);
        if (r101 == null) goto L7;
        IRoomPlatformComponentsData r102 = r101.getRoomPlatformComponentsData();
        if (r102 == null) goto L7;
        return r102.getPublicScreenInfo();
    L7:
        return null;
    }

    public static final RoomAvator c(IRoom r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$roomAvatar");
        Intrinsics.checkNotNullParameter(r100, "$this$communityMainRoomOrNull");
        ICommunityMainRoom r101 = (ICommunityMainRoom) r100.castToOrNull(ICommunityMainRoom.class);
        if (r101 == null) goto L7;
        IRoomPlatformComponentsData r102 = r101.getRoomPlatformComponentsData();
        if (r102 == null) goto L7;
        return r102.getRoomAvator();
    L7:
        return null;
    }
}
