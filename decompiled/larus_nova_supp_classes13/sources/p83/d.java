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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r11, FragmentActivity r12, ECOrderTrackerData r13, ProductPurchaseInfo r14, ProductDetailPageParams r15, BaseSimilarProductCardVH$buyButtonOnClickListener$1.a r16, int r17) {
            if ((r17 & 8) == 0) goto L5;
            ProductDetailPageParams r6 = null;
        L7:
            if ((r17 & 64) == 0) goto L9;
            BaseSimilarProductCardVH$buyButtonOnClickListener$1.a r9 = null;
        L10:
            r11.d(r12, r13, r14, r6, null, null, r9, null);
            return;
        L9:
            r9 = r16;
            goto L10
        L5:
            r6 = r15;
            goto L7
        }

        public static /* synthetic */ void b(d r19, Context r20, ECProductInfo r21, ECAwemeItemInfo r22, JSONObject r23, ECAdLogExtra r24, ECBoltParam r25, String r26, String r27, String r28, ECProductDetailPageShowStyle r29, ECLubanData r30, ECLogExtraData r31, JSONObject r32, ECUIParam r33, Boolean r34) {
            r19.b(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, null, null, Boolean.FALSE);
        }
    }

    void a(Context r1, String r2, h r3);

    @Deprecated(message = "请接入新版schema")
    void b(Context r1, ECProductInfo r2, ECAwemeItemInfo r3, JSONObject r4, ECAdLogExtra r5, ECBoltParam r6, String r7, String r8, String r9, ECProductDetailPageShowStyle r10, ECLubanData r11, ECLogExtraData r12, JSONObject r13, ECUIParam r14, Boolean r15, m r16, String r17, Boolean r18);

    String c(Context r1, String r2, h r3);

    boolean checkQrcodePromotionSource(Context r1, String r2);

    void clearRoomLifecycleData();

    void d(FragmentActivity r1, ECOrderTrackerData r2, ProductPurchaseInfo r3, ProductDetailPageParams r4, BtmItemBuilder r5, com.bytedance.android.btm.api.model.d r6, nl.d r7, Function1<? super SkuProductDetailInfo, Unit> r8);

    void e();

    void enterGalleryViewer(int r1, View r2, List<? extends k> r3, Function0<Unit> r4);

    void f();

    View g();

    String getSearchSimilarBlackInstructionSchema();

    String getSearchSimilarWhiteInstructionSchema();

    void requestShowSimilarProductGuide();

    void showAwemeDetailLynxWidget(Context r1, String r2, Function1<? super JSONObject, Unit> r3, ViewGroup r4);

    void showSearchSimilarAuthorizationDialog(Context r1, String r2);
}
