package p83;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.k;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH$buyButtonOnClickListener$1;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import n83.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r110, FragmentActivity r111, ECOrderTrackerData r112, ProductPurchaseInfo r113, ProductDetailPageParams r114, BaseSimilarProductCardVH$buyButtonOnClickListener$1.a r115, int r116) {
            if ((r116 & 8) == 0) goto L5;
            ProductDetailPageParams r100 = null;
        L7:
            if ((r116 & 64) == 0) goto L9;
            BaseSimilarProductCardVH$buyButtonOnClickListener$1.a r101 = null;
        L10:
            r110.d(r111, r112, r113, r100, null, null, r101, null);
            return;
        L9:
            r101 = r115;
            goto L10
        L5:
            r100 = r114;
            goto L7
        }

        public static /* synthetic */ void b(d r110, Context r210, ECProductInfo r211, ECAwemeItemInfo r212, JSONObject r213, ECAdLogExtra r214, ECBoltParam r215, String r216, String r217, String r218, ECProductDetailPageShowStyle r219, ECLubanData r310, ECLogExtraData r311, JSONObject r312, ECUIParam r313, Boolean r314) {
            r110.b(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, null, null, Boolean.FALSE);
        }
    }

    void a(Context r100, String r101, h r102);

    @Deprecated(message = "请接入新版schema")
    void b(Context r100, ECProductInfo r101, ECAwemeItemInfo r102, JSONObject r103, ECAdLogExtra r104, ECBoltParam r105, String r106, String r107, String r108, ECProductDetailPageShowStyle r110, ECLubanData r111, ECLogExtraData r112, JSONObject r113, ECUIParam r114, Boolean r115, m r116, String r117, Boolean r118);

    String c(Context r100, String r101, h r102);

    boolean checkQrcodePromotionSource(Context r100, String r101);

    void clearRoomLifecycleData();

    void d(FragmentActivity r100, ECOrderTrackerData r101, ProductPurchaseInfo r102, ProductDetailPageParams r103, BtmItemBuilder r104, com.bytedance.android.btm.api.model.d r105, nl.d r106, Function1<? super SkuProductDetailInfo, Unit> r107);

    void e();

    void enterGalleryViewer(int r100, View r101, List<? extends k> r102, Function0<Unit> r103);

    void f();

    View g();

    String getSearchSimilarBlackInstructionSchema();

    String getSearchSimilarWhiteInstructionSchema();

    void requestShowSimilarProductGuide();

    void showAwemeDetailLynxWidget(Context r100, String r101, Function1<? super JSONObject, Unit> r102, ViewGroup r103);

    void showSearchSimilarAuthorizationDialog(Context r100, String r101);
}
