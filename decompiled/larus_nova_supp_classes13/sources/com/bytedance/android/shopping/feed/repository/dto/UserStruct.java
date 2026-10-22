package com.bytedance.android.shopping.feed.repository.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR \u0010!\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR\u001e\u0010*\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001e\u0010-\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001e\u00100\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001e\u00103\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001a¨\u00066"}, d2 = {"Lcom/bytedance/android/shopping/feed/repository/dto/UserStruct;", "Ljava/io/Serializable;", "()V", "avatarMedium", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getAvatarMedium", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setAvatarMedium", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "bindPhone", "", "getBindPhone", "()Ljava/lang/String;", "setBindPhone", "(Ljava/lang/String;)V", "followStatus", "", "getFollowStatus", "()I", "setFollowStatus", "(I)V", "hasOrders", "", "getHasOrders", "()Z", "setHasOrders", "(Z)V", "nickname", "getNickname", "setNickname", "secUid", "getSecUid", "setSecUid", "shopMicroApp", "getShopMicroApp", "setShopMicroApp", "uid", "getUid", "setUid", "withCommerceEntry", "getWithCommerceEntry", "setWithCommerceEntry", "withCommerceNewbieTask", "getWithCommerceNewbieTask", "setWithCommerceNewbieTask", "withFusionShopEntry", "getWithFusionShopEntry", "setWithFusionShopEntry", "withItemCommerceEntry", "getWithItemCommerceEntry", "setWithItemCommerceEntry", "withNewGoods", "getWithNewGoods", "setWithNewGoods", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserStruct implements Serializable {

    @SerializedName("avatar_medium")
    private ECUrlModel avatarMedium;

    @SerializedName("bind_phone")
    private String bindPhone;

    @SerializedName(PdpOpenThirdParam.KEY_FOLLOW_STATUS)
    private int followStatus;

    @SerializedName("has_orders")
    private boolean hasOrders;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("sec_uid")
    private String secUid;

    @SerializedName("shop_micro_app")
    private String shopMicroApp;

    @SerializedName("uid")
    private String uid;

    @SerializedName("with_commerce_entry")
    private boolean withCommerceEntry;

    @SerializedName("with_commerce_newbie_task")
    private boolean withCommerceNewbieTask;

    @SerializedName("with_fusion_shop_entry")
    private boolean withFusionShopEntry;

    @SerializedName("with_item_commerce_entry")
    private boolean withItemCommerceEntry;

    @SerializedName("with_new_goods")
    private boolean withNewGoods;

    public UserStruct() {
    }

    public final ECUrlModel getAvatarMedium() {
        return this.avatarMedium;
    }

    public final String getBindPhone() {
        return this.bindPhone;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getHasOrders() {
        return this.hasOrders;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final String getShopMicroApp() {
        return this.shopMicroApp;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean getWithCommerceEntry() {
        return this.withCommerceEntry;
    }

    public final boolean getWithCommerceNewbieTask() {
        return this.withCommerceNewbieTask;
    }

    public final boolean getWithFusionShopEntry() {
        return this.withFusionShopEntry;
    }

    public final boolean getWithItemCommerceEntry() {
        return this.withItemCommerceEntry;
    }

    public final boolean getWithNewGoods() {
        return this.withNewGoods;
    }

    public final void setAvatarMedium(ECUrlModel r1) {
        this.avatarMedium = r1;
    }

    public final void setBindPhone(String r1) {
        this.bindPhone = r1;
    }

    public final void setFollowStatus(int r1) {
        this.followStatus = r1;
    }

    public final void setHasOrders(boolean r1) {
        this.hasOrders = r1;
    }

    public final void setNickname(String r1) {
        this.nickname = r1;
    }

    public final void setSecUid(String r1) {
        this.secUid = r1;
    }

    public final void setShopMicroApp(String r1) {
        this.shopMicroApp = r1;
    }

    public final void setUid(String r1) {
        this.uid = r1;
    }

    public final void setWithCommerceEntry(boolean r1) {
        this.withCommerceEntry = r1;
    }

    public final void setWithCommerceNewbieTask(boolean r1) {
        this.withCommerceNewbieTask = r1;
    }

    public final void setWithFusionShopEntry(boolean r1) {
        this.withFusionShopEntry = r1;
    }

    public final void setWithItemCommerceEntry(boolean r1) {
        this.withItemCommerceEntry = r1;
    }

    public final void setWithNewGoods(boolean r1) {
        this.withNewGoods = r1;
    }
}
