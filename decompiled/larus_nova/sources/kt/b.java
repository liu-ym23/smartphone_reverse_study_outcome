package kt;

import com.bytedance.android.gamecp.common.model.GameStageType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f506000a = null;

    static {
        int[] r100 = new int[GameStageType.values().length];
        f506000a = r100;
        r100[GameStageType.NONE.ordinal()] = 1;
        r100[GameStageType.DOWNLOAD.ordinal()] = 2;
        r100[GameStageType.TEST.ordinal()] = 3;
        r100[GameStageType.RESERVATION.ordinal()] = 4;
    }
}
