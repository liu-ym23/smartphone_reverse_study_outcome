package lu2;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IRoom f510828a = null;

    static {
        f510828a = (IRoom) vh7.f.c(IRoom.class);
    }

    public static final EpisodeExtraInfo a(IRoom r100) {
        IEpisodeExtraInfo r101 = null;
        if (r100 == null) goto L5;
        IEpisodeExtraInfo r102 = r100.getEpisodeComponentData();
    L7:
        if ((r102 instanceof EpisodeExtraInfo) == false) goto L11;
        r101 = r102;
    L11:
        return (EpisodeExtraInfo) r101;
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean b(IRoom r100) {
        if (r100 == null) goto L12;
        EpisodeExtraInfo r101 = a(r100);
        if (r101 == null) goto L12;
        VSLinkedRoomInfo r102 = r101.getVsLinkedRoomInfo();
        if (r102 == null) goto L12;
        List<VSLinkedRoomNode> r103 = r102.getRooms();
        if (r103 == null) goto L12;
        if ((!r103.isEmpty()) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean c(IRoom r100) {
        if (r100 == null) goto L10;
        IEpisodeExtraInfo r101 = r100.getEpisodeComponentData();
        if (r101 == null) goto L10;
        List<IVSCameraInfo> r102 = r101.getCameraInfos();
        if (r102 == null) goto L10;
        if ((!r102.isEmpty()) != true) goto L10;
        return true;
    L10:
        return false;
    }

    public static final boolean d(IRoom r100) {
        Object r101 = null;
        if (r100 == null) goto L15;
        IEpisodeExtraInfo r102 = r100.getEpisodeComponentData();
        if (r102 == null) goto L15;
        List<IVSCameraInfo> r103 = r102.getCameraInfos();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (((IVSCameraInfo) r105).isPaidCamera() == false) goto L10;
        r101 = r105;
    L14:
        r101 = (IVSCameraInfo) r101;
    L15:
        if (r101 == null) goto L17;
        return true;
    L17:
        return false;
    }

    public static final boolean e(IRoom r100) {
        if (r100 == null) goto L20;
        EpisodeExtraInfo r101 = a(r100);
        if (r101 == null) goto L20;
        VSLinkedRoomInfo r102 = r101.getVsLinkedRoomInfo();
        if (r102 == null) goto L20;
        List<VSLinkedRoomNode> r103 = r102.getRooms();
        if (r103 == null) goto L20;
        if ((!r103.isEmpty()) != true) goto L20;
        EpisodeExtraInfo r104 = a(r100);
        if (r104 == null) goto L16;
        VSLinkedRoomInfo r105 = r104.getVsLinkedRoomInfo();
        if (r105 == null) goto L16;
        Boolean r106 = r105.isMainRoom();
    L18:
        if (Intrinsics.areEqual(r106, Boolean.FALSE) == false) goto L20;
        return true;
    L16:
        r106 = null;
    L20:
        return false;
    }

    public static final IRoom f(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$room");
        return (IRoom) r100.get("data_room", f510828a);
    }
}
