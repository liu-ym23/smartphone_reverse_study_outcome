package mh0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f513836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f513837b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f513836a = r100;
        r100[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 1;
        r100[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 2;
        r100[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 3;
        int[] r101 = new int[DynamicGetType.values().length];
        f513837b = r101;
        r101[DynamicGetType.LINKMIC.ordinal()] = 1;
        r101[DynamicGetType.SEAT.ordinal()] = 2;
        r101[DynamicGetType.FRAME_INFO.ordinal()] = 3;
    }
}
