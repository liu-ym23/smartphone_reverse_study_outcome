package fm2;

import com.bytedance.android.livesdkapi.feed.arch.PreViewRoomControllerLifeCycle;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f477777a = null;

    static {
        int[] r100 = new int[PreViewRoomControllerLifeCycle.values().length];
        f477777a = r100;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_START_VIEW.ordinal()] = 1;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_PAUSE.ordinal()] = 2;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_BIND_START.ordinal()] = 3;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_INJECT_HANDLE_FUN.ordinal()] = 4;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_BIND_END.ordinal()] = 5;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_SELECT.ordinal()] = 6;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_UN_SELECT.ordinal()] = 7;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_UN_BIND.ordinal()] = 8;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_BEHAVIOR_LOAD.ordinal()] = 9;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_WIDGET_LOADED.ordinal()] = 10;
        r100[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD.ordinal()] = 11;
        r100[PreViewRoomControllerLifeCycle.CLEAR_ROOM_CONTROLLER.ordinal()] = 12;
    }
}
