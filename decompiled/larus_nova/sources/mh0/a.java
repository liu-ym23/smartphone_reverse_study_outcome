package mh0;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f513820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f513821b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f513820a = r100;
        r100[DynamicUpdateType.AUDIOCHAT_STAGE.ordinal()] = 1;
        r100[DynamicUpdateType.SUBTITLE.ordinal()] = 2;
        int[] r101 = new int[DynamicGetType.values().length];
        f513821b = r101;
        r101[DynamicGetType.SUBTITLE.ordinal()] = 1;
    }
}
