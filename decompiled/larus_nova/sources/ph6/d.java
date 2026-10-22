package ph6;

import com.bytedance.live.bizlink.api.platformapi.host.InteractStateChangeType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f529281a = null;

    static {
        int[] r100 = new int[InteractStateChangeType.values().length];
        f529281a = r100;
        r100[InteractStateChangeType.BackToNormal.ordinal()] = 1;
        r100[InteractStateChangeType.PauseNormalPlay.ordinal()] = 2;
        r100[InteractStateChangeType.PauseNormalStreamPush.ordinal()] = 3;
        r100[InteractStateChangeType.ResumeNormalStreamPush.ordinal()] = 4;
    }
}
