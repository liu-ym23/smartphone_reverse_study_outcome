package zq3;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public f() {
    }

    static {
    }

    public static BcmParams a(String r2, WindowV2ProductItemVO r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        BcmParams r0 = new BcmParams();
        r0.put("author_id", r2);
        r0.put("product_id", r3.a);
        r0.put("promotion_id", r3.b);
        r0.put("buyin_track", (String) r3.C.a(wn.a.x));
        r0.put("c_biz_combo", (String) r3.C.a(wn.a.w));
        r0.put("bst_group_type", "product");
        return r0.merge((Map) r3.O.getValue());
    }

    public static String c(String r1, String r2, PageFinder r3, BcmParams r4) {
        Intrinsics.checkNotNullParameter(r1, "originSchema");
        Intrinsics.checkNotNullParameter(r2, "btmId");
        Intrinsics.checkNotNullParameter(r3, "pageFinder");
        Uri.Builder r5 = UriProtector.parse(r1).buildUpon();
        String r6 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r2, r3, r4);
        if (r6 == null) goto L6;
        r5.appendQueryParameter("source_btm_token", r6);
    L6:
        return r5.build().toString();
    }

    public static void b(Context r1, ECWindowViewModel r2, String r3, String r4, PageFinder r5, WindowV2ProductItemVO r6) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "originSchema");
        Intrinsics.checkNotNullParameter(r4, "sourceBtmId");
        Intrinsics.checkNotNullParameter(r5, "pageFinder");
        if (r6 != null) goto L5;
        BcmParams r7 = null;
    L6:
        String r8 = c(r3, r4, r5, r7);
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r1, r8);
        return;
    L5:
        r7 = a(r2.getShopParam().getAuthorId(), r6);
        goto L6
    }
}
