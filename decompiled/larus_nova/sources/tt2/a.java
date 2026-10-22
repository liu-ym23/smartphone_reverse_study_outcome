package tt2;

import com.bytedance.android.livesdk.urge.UrgeSendGiftEventCode;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f547539a = null;

    static {
        int[] r100 = new int[UrgeSendGiftEventCode.values().length];
        f547539a = r100;
        r100[UrgeSendGiftEventCode.SUCCESS.ordinal()] = 1;
        r100[UrgeSendGiftEventCode.INSUFFICIENTFUND.ordinal()] = 2;
        r100[UrgeSendGiftEventCode.CANCEL.ordinal()] = 3;
    }
}
