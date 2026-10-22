package mr0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f514972a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f514973b = null;

    static {
        int[] r100 = new int[MountedMiniGameSource.values().length];
        f514972a = r100;
        MountedMiniGameSource r101 = MountedMiniGameSource.Toolbar;
        r100[r101.ordinal()] = 1;
        MountedMiniGameSource r102 = MountedMiniGameSource.ExplainCard;
        r100[r102.ordinal()] = 2;
        MountedMiniGameSource r103 = MountedMiniGameSource.GameLiveBtn;
        r100[r103.ordinal()] = 3;
        MountedMiniGameSource r104 = MountedMiniGameSource.InteractPanel;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[MountedMiniGameSource.values().length];
        f514973b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        r105[MountedMiniGameSource.Lottery.ordinal()] = 5;
    }
}
