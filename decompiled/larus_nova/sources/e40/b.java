package e40;

import com.bytedance.android.live.cloudgrouplive.rtc.AnchorGroupLiveStatus;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f470962a = null;

    static {
        int[] r100 = new int[AnchorGroupLiveStatus.values().length];
        f470962a = r100;
        r100[AnchorGroupLiveStatus.WAITING.ordinal()] = 1;
        r100[AnchorGroupLiveStatus.READY.ordinal()] = 2;
        r100[AnchorGroupLiveStatus.PERFORMING.ordinal()] = 3;
    }
}
