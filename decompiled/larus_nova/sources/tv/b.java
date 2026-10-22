package tv;

import com.bytedance.android.gamecp.host_api.cloudgame.IXPlayApiForLive$IQueueState;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f547663a = null;

    static {
        int[] r100 = new int[IXPlayApiForLive$IQueueState.values().length];
        f547663a = r100;
        r100[IXPlayApiForLive$IQueueState.ERROR.ordinal()] = 1;
        r100[IXPlayApiForLive$IQueueState.INQUEUE.ordinal()] = 2;
        r100[IXPlayApiForLive$IQueueState.DEQUEUE.ordinal()] = 3;
        r100[IXPlayApiForLive$IQueueState.RANKING.ordinal()] = 4;
        r100[IXPlayApiForLive$IQueueState.READY.ordinal()] = 5;
        r100[IXPlayApiForLive$IQueueState.EXPIRE.ordinal()] = 6;
    }
}
