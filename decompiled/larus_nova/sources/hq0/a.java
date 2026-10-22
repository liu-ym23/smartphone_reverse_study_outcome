package hq0;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f486493a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f486494b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f486495c = null;

    static {
        int[] r100 = new int[MountedMiniAppSource.values().length];
        f486493a = r100;
        MountedMiniAppSource r101 = MountedMiniAppSource.ConnectionPanel;
        r100[r101.ordinal()] = 1;
        MountedMiniAppSource r102 = MountedMiniAppSource.ExplainCard;
        r100[r102.ordinal()] = 2;
        MountedMiniAppSource r103 = MountedMiniAppSource.ExplainCardButton;
        r100[r103.ordinal()] = 3;
        MountedMiniAppSource r104 = MountedMiniAppSource.ToolbarDirectMicroApp;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[MountedMiniAppSource.values().length];
        f486494b = r105;
        r105[r101.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
        r105[r103.ordinal()] = 3;
        r105[r104.ordinal()] = 4;
        int[] r106 = new int[MountedMiniAppSource.values().length];
        f486495c = r106;
        r106[r102.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
    }
}
