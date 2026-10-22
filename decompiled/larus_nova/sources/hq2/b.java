package hq2;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.revenue.interactivity.PublicScreenMessageType;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f486496a = null;

    static {
        int[] r100 = new int[PublicScreenMessageType.values().length];
        f486496a = r100;
        r100[PublicScreenMessageType.DISABLE_GIFT_NOTICE.ordinal()] = 1;
        int[] r101 = new int[PublicScreenHeatState.values().length];
        r101[PublicScreenHeatState.DEFAULT.ordinal()] = 1;
        r101[PublicScreenHeatState.HOT.ordinal()] = 2;
        r101[PublicScreenHeatState.COLD.ordinal()] = 3;
    }
}
