package mh0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f513828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f513829b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f513828a = r100;
        r100[DynamicUpdateType.LOAD.ordinal()] = 1;
        r100[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        int[] r101 = new int[DynamicGetType.values().length];
        f513829b = r101;
        r101[DynamicGetType.ROOM.ordinal()] = 1;
    }
}
