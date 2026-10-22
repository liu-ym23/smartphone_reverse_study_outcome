package ln1;

import com.bytedance.android.livesdkapi.service.ILiveRoomPreloadService;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f509980a = null;

    static {
        int[] r100 = new int[ILiveRoomPreloadService.TriggerState.values().length];
        f509980a = r100;
        r100[ILiveRoomPreloadService.TriggerState.UNSELECT_TRIGGER.ordinal()] = 1;
        r100[ILiveRoomPreloadService.TriggerState.SELECTED_TRIGGER.ordinal()] = 2;
    }
}
