package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.CurrentUserInfo;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.AuctionInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo;", "", "()V", "bizId", "", "buttonLabel", "", "currentUserInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionUserInfo;", "endTime", "", "incrPriceList", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionIncrPrice;", "jumpUrl", "price", "priceLabel", "productId", "status", "toECPromotionAuctionInfo", "Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;", "ECV2AuctionImg", "ECV2AuctionIncrPrice", "ECV2AuctionUserInfo", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECV2AuctionInfo {

    @SerializedName("biz_id")
    public int bizId;

    @SerializedName("button_label")
    public String buttonLabel;

    @SerializedName("current_user_info")
    public ECV2AuctionUserInfo currentUserInfo;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("incr_price_lists")
    public List<ECV2AuctionIncrPrice> incrPriceList;

    @SerializedName("jump_url")
    public String jumpUrl;

    @SerializedName("price")
    public long price;

    @SerializedName("price_label")
    public String priceLabel;

    @SerializedName("product_id")
    public long productId;

    @SerializedName("status")
    public int status;

    @ProtoMessage("live.Img")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionImg;", "", "()V", "height", "", "urlList", "", "", "width", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ECV2AuctionImg {

        @SerializedName("height")
        public int height;

        @SerializedName("url_list")
        public List<String> urlList;

        @SerializedName("width")
        public int width;

        public ECV2AuctionImg() {
        }
    }

    @ProtoMessage("live.IncrPriceList")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionIncrPrice;", "", "()V", "price", "", "range", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ECV2AuctionIncrPrice {

        @SerializedName("price")
        public long price;

        @SerializedName("range")
        public long range;

        public ECV2AuctionIncrPrice() {
        }
    }

    @ProtoMessage("live.CurrentUserInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionUserInfo;", "", "()V", "userId", "", "userName", "", "userPic", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuctionInfo$ECV2AuctionImg;", "toCurrentUser", "Lcom/bytedance/android/ec/model/response/CurrentUserInfo;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ECV2AuctionUserInfo {

        @SerializedName("user_id")
        public long userId;

        @SerializedName("user_name")
        public String userName;

        @SerializedName("user_pic")
        public ECV2AuctionImg userPic;

        public ECV2AuctionUserInfo() {
        }

        public final CurrentUserInfo toCurrentUser() {
            CurrentUserInfo r0 = new CurrentUserInfo();
            r0.setUserName(this.userName);
            ECV2AuctionImg r1 = this.userPic;
            if (r1 == null) goto L5;
            ECUrlModel r2 = new ECUrlModel();
            r2.setWidth(r1.width);
            r2.setHeight(r1.height);
            r2.setUrlList(r1.urlList);
            r0.setUserPic(r2);
        L5:
            r0.setUserId(this.userId);
            return r0;
        }
    }

    public ECV2AuctionInfo() {
    }

    public final ECPromotionAuctionInfo toECPromotionAuctionInfo() {
        ECPromotionAuctionInfo r0 = new ECPromotionAuctionInfo();
        r0.setPrice(Long.valueOf(this.price));
        r0.setPriceLabel(this.priceLabel);
        r0.setStatus(Integer.valueOf(this.status));
        r0.setJumpUrl(this.jumpUrl);
        ECV2AuctionUserInfo r1 = this.currentUserInfo;
        if (r1 == null) goto L5;
        CurrentUserInfo r2 = r1.toCurrentUser();
    L6:
        r0.setCurrentUserInfo(r2);
        r0.setButtonLabel(this.buttonLabel);
        r0.setProductId(String.valueOf(this.productId));
        r0.setBizId(this.bizId);
        r0.setEndTime(this.endTime);
        return r0;
    L5:
        r2 = null;
        goto L6
    }
}
