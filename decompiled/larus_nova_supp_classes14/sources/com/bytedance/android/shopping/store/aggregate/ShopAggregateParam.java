package com.bytedance.android.shopping.store.aggregate;

import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.home.api.StoreBaseParam;
import com.bytedance.android.shopping.store.home.entity.FansClubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b.\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010N\u001a\u00020\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0004R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u0004R\u001e\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001a\u0010-\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u001a\u00103\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\u0004R\u001a\u00109\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR\u001a\u0010<\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001cR\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\u0004R\u001a\u0010B\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\u0004R\u001c\u0010H\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0007\"\u0004\bJ\u0010\u0004R\u001c\u0010K\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\u0004¨\u0006O"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/ShopAggregateParam;", "Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "secShopId", "", "(Ljava/lang/String;)V", "categoryId", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "categoryInfo", "Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;", "getCategoryInfo", "()Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;", "setCategoryInfo", "(Lcom/bytedance/android/shopping/store/aggregate/classification/CategoryInfo;)V", "categoryInfoStr", "getCategoryInfoStr", "setCategoryInfoStr", "classificationTabType", "getClassificationTabType", "setClassificationTabType", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "isSplitMode", "", "()Z", "setSplitMode", "(Z)V", "metaInfo", "getMetaInfo", "setMetaInfo", "pageHeightPercent", "", "getPageHeightPercent", "()Ljava/lang/Integer;", "setPageHeightPercent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageParams", "getPageParams", "setPageParams", "pageVersion", "getPageVersion", "setPageVersion", "productCnt", "getProductCnt", "()I", "setProductCnt", "(I)V", "getSecShopId", "selectIndex", "getSelectIndex", "setSelectIndex", "shopId", "getShopId", "setShopId", "showAddCart", "getShowAddCart", "setShowAddCart", "showCategoryTab", "getShowCategoryTab", "setShowCategoryTab", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "tabLabel", "getTabLabel", "setTabLabel", "tabName", "getTabName", "setTabName", "tabNameSecond", "getTabNameSecond", "setTabNameSecond", "tagData", "getTagData", "setTagData", "deepCopy", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregateParam extends StoreBaseParam {
    private String categoryId;
    private CategoryInfo categoryInfo;
    private String categoryInfoStr;
    private String classificationTabType;
    private String entranceInfo;
    private boolean isSplitMode;
    private String metaInfo;
    private Integer pageHeightPercent;
    private String pageParams;
    private String pageVersion;
    private int productCnt;
    private final String secShopId;
    private int selectIndex;
    private String shopId;
    private boolean showAddCart;
    private boolean showCategoryTab;
    private String sourceBtmToken;
    private String tabLabel;
    private String tabName;
    private String tabNameSecond;
    private String tagData;

    public final ShopAggregateParam deepCopy() {
        ShopAggregateParam r0 = new ShopAggregateParam(this.secShopId);
        r0.shopId = this.shopId;
        r0.showAddCart = this.showAddCart;
        r0.metaInfo = this.metaInfo;
        r0.tabNameSecond = this.tabNameSecond;
        r0.tabName = this.tabName;
        r0.pageHeightPercent = this.pageHeightPercent;
        r0.pageParams = this.pageParams;
        r0.tagData = this.tagData;
        r0.selectIndex = this.selectIndex;
        r0.categoryInfoStr = this.categoryInfoStr;
        CategoryInfo r1 = this.categoryInfo;
        FansClubInfo r2 = null;
        if (r1 == null) goto L5;
        CategoryInfo r3 = r1.deepCopy();
    L6:
        r0.categoryInfo = r3;
        r0.showCategoryTab = this.showCategoryTab;
        r0.tabLabel = this.tabLabel;
        r0.categoryId = this.categoryId;
        r0.classificationTabType = this.classificationTabType;
        r0.pageVersion = this.pageVersion;
        r0.productCnt = this.productCnt;
        r0.sourceBtmToken = this.sourceBtmToken;
        r0.entranceInfo = this.entranceInfo;
        r0.getStoreAccountParam().copyFrom(getStoreAccountParam());
        r0.setTabId(getTabId());
        r0.setDebugUrl(getDebugUrl());
        r0.getProductBasicRequestParam().copyFrom(getProductBasicRequestParam());
        r0.getStoreUIParam().copyFrom(getStoreUIParam());
        r0.getShareInfo().copyFrom(getShareInfo());
        r0.getStoreNaviParam().copyFrom(getStoreNaviParam());
        r0.setFromProfile(getFromProfile());
        r0.getPassThroughParams().clear();
        r0.getPassThroughParams().putAll(getPassThroughParams());
        r0.setSearchHint(getSearchHint());
        r0.setStoreDetailUrl(getStoreDetailUrl());
        r0.setStoreHomePageUrl(getStoreHomePageUrl());
        r0.setSearchParams(getSearchParams());
        r0.setEnterFrom(getEnterFrom());
        r0.setPageName(getPageName());
        r0.setTaskType(getTaskType());
        r0.setBcm(getBcm());
        r0.setTaskEnterFrom(getTaskEnterFrom());
        r0.setTempId(getTempId());
        r0.setEnterMethod(getEnterMethod());
        r0.setEntranceLocation(getEntranceLocation());
        r0.setPageType(getPageType());
        ECAdLogExtra r4 = getAdLogExtra();
        if (r4 == null) goto L9;
        ECAdLogExtra r5 = r4.deepCopy();
    L10:
        r0.setAdLogExtra(r5);
        r0.setFollowStatus(getFollowStatus());
        FansClubInfo r6 = getFansInfo();
        if (r6 == null) goto L13;
        r2 = r6.deepCopy();
    L13:
        r0.setFansInfo(r2);
        r0.setWhichAccount(getWhichAccount());
        r0.setRoomId(getRoomId());
        r0.setAnchorId(getAnchorId());
        r0.setPreGroupId(getPreGroupId());
        r0.setPreProductId(getPreProductId());
        r0.setPreRoomId(getPreRoomId());
        r0.setStoreSourcePage(getStoreSourcePage());
        r0.setStoreSourceMethod(getStoreSourceMethod());
        r0.setStoreGroupType(getStoreGroupType());
        r0.setLiveAnchorId(getLiveAnchorId());
        r0.setPageFrom(getPageFrom());
        r0.setExtraSchema(getExtraSchema());
        r0.setEcShare(isEcShare());
        r0.setShareContent(getShareContent());
        r0.setShareObject(getShareObject());
        r0.setProductId(getProductId());
        r0.setModuleLabel(getModuleLabel());
        r0.setEnterStoreEvent(getEnterStoreEvent());
        r0.setEcomJsonStr(getEcomJsonStr());
        r0.setEcomPitayaJsonStr(getEcomPitayaJsonStr());
        r0.isSplitMode = this.isSplitMode;
        return r0;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final CategoryInfo getCategoryInfo() {
        return this.categoryInfo;
    }

    public final String getCategoryInfoStr() {
        return this.categoryInfoStr;
    }

    public final String getClassificationTabType() {
        return this.classificationTabType;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getMetaInfo() {
        return this.metaInfo;
    }

    public final Integer getPageHeightPercent() {
        return this.pageHeightPercent;
    }

    public final String getPageParams() {
        return this.pageParams;
    }

    public final String getPageVersion() {
        return this.pageVersion;
    }

    public final int getProductCnt() {
        return this.productCnt;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final int getSelectIndex() {
        return this.selectIndex;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowAddCart() {
        return this.showAddCart;
    }

    public final boolean getShowCategoryTab() {
        return this.showCategoryTab;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getTabLabel() {
        return this.tabLabel;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabNameSecond() {
        return this.tabNameSecond;
    }

    public final String getTagData() {
        return this.tagData;
    }

    public final boolean isSplitMode() {
        return this.isSplitMode;
    }

    public ShopAggregateParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "secShopId");
        this.secShopId = r2;
        this.pageHeightPercent = 73;
        this.tabLabel = "";
    }

    public final void setCategoryId(String r1) {
        this.categoryId = r1;
    }

    public final void setCategoryInfo(CategoryInfo r1) {
        this.categoryInfo = r1;
    }

    public final void setCategoryInfoStr(String r1) {
        this.categoryInfoStr = r1;
    }

    public final void setClassificationTabType(String r1) {
        this.classificationTabType = r1;
    }

    public final void setEntranceInfo(String r1) {
        this.entranceInfo = r1;
    }

    public final void setMetaInfo(String r1) {
        this.metaInfo = r1;
    }

    public final void setPageHeightPercent(Integer r1) {
        this.pageHeightPercent = r1;
    }

    public final void setPageParams(String r1) {
        this.pageParams = r1;
    }

    public final void setPageVersion(String r1) {
        this.pageVersion = r1;
    }

    public final void setProductCnt(int r1) {
        this.productCnt = r1;
    }

    public final void setSelectIndex(int r1) {
        this.selectIndex = r1;
    }

    public final void setShopId(String r1) {
        this.shopId = r1;
    }

    public final void setShowAddCart(boolean r1) {
        this.showAddCart = r1;
    }

    public final void setShowCategoryTab(boolean r1) {
        this.showCategoryTab = r1;
    }

    public final void setSourceBtmToken(String r1) {
        this.sourceBtmToken = r1;
    }

    public final void setSplitMode(boolean r1) {
        this.isSplitMode = r1;
    }

    public final void setTabLabel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabLabel = r2;
    }

    public final void setTabName(String r1) {
        this.tabName = r1;
    }

    public final void setTabNameSecond(String r1) {
        this.tabNameSecond = r1;
    }

    public final void setTagData(String r1) {
        this.tagData = r1;
    }
}
