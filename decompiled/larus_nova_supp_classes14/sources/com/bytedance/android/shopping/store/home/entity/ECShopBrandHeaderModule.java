package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopBrandHeaderModule;", "Ljava/io/Serializable;", "", "moduleType", "I", "getModuleType", "()I", "Lim/v;", "liveInfo", "Lim/v;", "getLiveInfo", "()Lim/v;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "coverInfo", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCoverInfo", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "mainTitle", "Ljava/lang/String;", "getMainTitle", "()Ljava/lang/String;", "mainTitleIcon", "getMainTitleIcon", "subTitle", "getSubTitle", "jumpUrl", "getJumpUrl", "", "isAnchored", "Z", "()Z", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopBrandHeaderModule implements Serializable {

    @SerializedName("cover_info")
    private final ECUrlModel coverInfo;

    @SerializedName("is_anchored")
    private final boolean isAnchored;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("live_info")
    private final im.v liveInfo;

    @SerializedName("main_title")
    private final String mainTitle;

    @SerializedName("main_title_icon")
    private final ECUrlModel mainTitleIcon;

    @SerializedName("module_type")
    private final int moduleType;

    @SerializedName("sub_title")
    private final String subTitle;

    public ECShopBrandHeaderModule() {
        this.moduleType = -1;
    }

    public final ECUrlModel getCoverInfo() {
        return this.coverInfo;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final im.v getLiveInfo() {
        return this.liveInfo;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final ECUrlModel getMainTitleIcon() {
        return this.mainTitleIcon;
    }

    public final int getModuleType() {
        return this.moduleType;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final boolean isAnchored() {
        return this.isAnchored;
    }
}
