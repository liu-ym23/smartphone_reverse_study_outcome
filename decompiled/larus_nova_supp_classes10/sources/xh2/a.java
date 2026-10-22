package xh2;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static int a() {
        return ((Number) EComABUtils.getLiveSettingValue(EComABUtils.AB_LIVE_LIST_PRELOAD_TIME, 0)).intValue();
    }

    public static boolean b() {
        Integer r1 = (Integer) EComABUtils.getLiveSettingValue(EComABUtils.AB_LIVE_LIST_CACHE_OPT_CLIENT_AI, 0);
        if (r1 != null) goto L6;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.intValue() != 2) goto L13;
    L11:
        return true;
    L13:
        return false;
    L6:
        if (r1.intValue() == 1) goto L11;
        goto L7
    }

    static {
    }
}
