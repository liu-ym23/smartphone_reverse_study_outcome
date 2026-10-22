package el2;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements o {
    public f() {
    }

    @Override // el2.o
    public final String a() {
        return PromotionCategory.CATEGORY_TYPE_SECOND;
    }

    @Override // el2.o
    public final String getBioType() {
        return "1";
    }

    @Override // el2.o
    public final String getSdkVersion() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }
}
