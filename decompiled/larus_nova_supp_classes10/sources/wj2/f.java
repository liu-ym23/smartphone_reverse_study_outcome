package wj2;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r3, String r4) {
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        Integer r1 = r0.getEC_LIVE_ADD_CART_ANIMATION_OPT();
        if (r1 != null) goto L6;
    L9:
        Integer r2 = r0.getEC_LIVE_ADD_CART_ANIMATION_RETAIL_OPT();
        if (r2 != null) goto L13;
    L17:
        return false;
    L13:
        if (r2.intValue() != 1) goto L17;
        boolean r5 = EntryController.M1;
        if (EntryController.a.b(r3, r4).U != 1) goto L17;
        return true;
    L6:
        if (r1.intValue() != 1) goto L9;
        boolean r6 = EntryController.M1;
        if (EntryController.a.b(r3, r4).U != 0) goto L9;
        return true;
    }
}
