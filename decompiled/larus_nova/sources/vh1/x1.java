package vh1;

import com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.PreloadType;
import com.bytedance.android.livesdk.room.state.WidgetLevel;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f554944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f554945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f554946c = null;

    static {
        int[] r100 = new int[WidgetLevel.values().length];
        f554944a = r100;
        r100[WidgetLevel.FS.ordinal()] = 1;
        r100[WidgetLevel.P0.ordinal()] = 2;
        r100[WidgetLevel.P1.ordinal()] = 3;
        r100[WidgetLevel.P2.ordinal()] = 4;
        r100[WidgetLevel.ALL.ordinal()] = 5;
        int[] r101 = new int[PreloadType.values().length];
        f554945b = r101;
        PreloadType r102 = PreloadType.PRE_REQUEST_ROOM_PRELOAD;
        r101[r102.ordinal()] = 1;
        PreloadType r103 = PreloadType.PRE_REQUEST_ROOM_BACKEND;
        r101[r103.ordinal()] = 2;
        PreloadType r104 = PreloadType.PRE_ENTER_ROOM;
        r101[r104.ordinal()] = 3;
        int[] r105 = new int[PreloadType.values().length];
        f554946c = r105;
        r105[r102.ordinal()] = 1;
        r105[r103.ordinal()] = 2;
        r105[r104.ordinal()] = 3;
    }
}
