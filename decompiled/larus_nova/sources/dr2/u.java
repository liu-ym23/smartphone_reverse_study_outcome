package dr2;

import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f469745a = null;

    static {
        int[] r100 = new int[RevHostPluginType.values().length];
        f469745a = r100;
        r100[RevHostPluginType.Player.ordinal()] = 1;
        r100[RevHostPluginType.XGPlayer.ordinal()] = 2;
        r100[RevHostPluginType.LITE_PLAYER_CONTAINER.ordinal()] = 3;
        r100[RevHostPluginType.LivePcdnDouyin.ordinal()] = 4;
    }
}
