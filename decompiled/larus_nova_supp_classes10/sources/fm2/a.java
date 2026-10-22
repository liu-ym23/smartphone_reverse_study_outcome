package fm2;

import com.bytedance.android.livesdkapi.feed.arch.PreViewRoomControllerLifeCycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[PreViewRoomControllerLifeCycle.values().length];
        a = r0;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_START_VIEW.ordinal()] = 1;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_PAUSE.ordinal()] = 2;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_BIND_START.ordinal()] = 3;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_INJECT_HANDLE_FUN.ordinal()] = 4;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_ON_BIND_END.ordinal()] = 5;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_SELECT.ordinal()] = 6;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_UN_SELECT.ordinal()] = 7;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_VIEW_HOLDER_UN_BIND.ordinal()] = 8;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_BEHAVIOR_LOAD.ordinal()] = 9;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_WIDGET_LOADED.ordinal()] = 10;
        r0[PreViewRoomControllerLifeCycle.PREVIEW_SPECIFIC_BEHAVIOR_UN_LOAD.ordinal()] = 11;
        r0[PreViewRoomControllerLifeCycle.CLEAR_ROOM_CONTROLLER.ordinal()] = 12;
    }
}
