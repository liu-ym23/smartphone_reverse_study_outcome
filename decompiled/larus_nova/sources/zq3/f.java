package zq3;

import android.content.Context;
import android.net.Uri;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573300a = 0;

    public f() {
    }

    static {
    }

    public static BcmParams a(String r100, WindowV2ProductItemVO r101) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        BcmParams r102 = new BcmParams();
        r102.put("author_id", r100);
        r102.put("product_id", r101.f49463a);
        r102.put("promotion_id", r101.f49464b);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK, (String) r101.C.a(wn.a.f560427x));
        r102.put(com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO, (String) r101.C.a(wn.a.f560426w));
        r102.put(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product");
        return r102.merge((Map) r101.O.getValue());
    }

    public static String c(String r100, String r101, PageFinder r102, BcmParams r103) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Intrinsics.checkNotNullParameter(r101, "btmId");
        Intrinsics.checkNotNullParameter(r102, "pageFinder");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        String r105 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r101, r102, r103);
        if (r105 == null) goto L6;
        r104.appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r105);
    L6:
        return r104.build().toString();
    }

    public static void b(Context r100, ECWindowViewModel r101, String r102, String r103, PageFinder r104, WindowV2ProductItemVO r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "originSchema");
        Intrinsics.checkNotNullParameter(r103, "sourceBtmId");
        Intrinsics.checkNotNullParameter(r104, "pageFinder");
        if (r105 != null) goto L5;
        BcmParams r106 = null;
    L6:
        String r107 = c(r102, r103, r104, r106);
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(r100, r107);
        return;
    L5:
        r106 = a(r101.getShopParam().getAuthorId(), r105);
        goto L6
    }
}
