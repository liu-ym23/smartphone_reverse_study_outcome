package com.bytedance.android.shopping.sku.outer.business.cart.repo;

import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJÄ\u0001\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00102\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0002H'Jt\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00152\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00102\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0002H'¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/sku/outer/business/cart/repo/SkuOuterAddToCartApi;", "", "", "ecomPageType", "promotionId", "productId", "originType", "originId", "comboId", "comboNum", "specDesc", "deviceId", "extra", "authorId", "secAuthorId", "channelId", "", "channelType", "bcmChain", "foodTakeoutCustomPropertyList", "foodTakeoutSalePackageList", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/SsResponse;", "Lcom/bytedance/android/shopping/sku/outer/business/cart/repo/SkuOuterAddToCartResponse;", "addShopCart", "addShopCartNew", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SkuOuterAddToCartApi {
    public static final a a = null;

    public static final class a {
        public static final SkuOuterAddToCartApi a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = (SkuOuterAddToCartApi) n.a.create("https://aweme.snssdk.com", SkuOuterAddToCartApi.class);
        }
    }

    static {
        a = a.b;
    }

    @FormUrlEncoded
    @POST("https://ec.snssdk.com/cart/cartAdd")
    Observable<SsResponse<SkuOuterAddToCartResponse>> addShopCart(@Query("ecom_page_type") String r1, @Field("campaign_id") String r2, @Field(PdpOpenThirdParam.KEY_PRODUCT_ID) String r3, @Field("origin_type") String r4, @Field("origin_id") String r5, @Field("combo_id") String r6, @Field("combo_num") String r7, @Field("spec_desc") String r8, @Field("device_id") String r9, @Field("extra") String r10, @Field("author_id") String r11, @Field(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID) String r12, @Field("product_channel_id") String r13, @Field("product_channel_type") int r14, @Field("bcm_chain") String r15, @Field("custom_property_list") String r16, @Field("sale_package_list") String r17);

    @FormUrlEncoded
    @POST("https://ec.snssdk.com/cart/cartAdd_new")
    Observable<SsResponse<String>> addShopCartNew(@Field(PdpOpenThirdParam.KEY_PRODUCT_ID) String r1, @Field("combo_id") String r2, @Field("combo_num") String r3, @Field("extra") String r4, @Field("product_channel_id") String r5, @Field("product_channel_type") int r6, @Field("bcm_chain") String r7, @Field("custom_property_list") String r8, @Field("sale_package_list") String r9);
}
