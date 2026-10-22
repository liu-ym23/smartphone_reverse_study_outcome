package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreTabSourceConfig;", "Ljava/io/Serializable;", "", "sourceProductId", "Ljava/lang/String;", "getSourceProductId", "()Ljava/lang/String;", "setSourceProductId", "(Ljava/lang/String;)V", "", "customIdType", "Ljava/lang/Integer;", "getCustomIdType", "()Ljava/lang/Integer;", "setCustomIdType", "(Ljava/lang/Integer;)V", "customIds", "getCustomIds", "setCustomIds", "activeTabType", "getActiveTabType", "setActiveTabType", "activeSortType", "getActiveSortType", "setActiveSortType", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "activatePickType", "I", "getActivatePickType", "()I", "setActivatePickType", "(I)V", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreTabSourceConfig implements Serializable {
    public static final a Companion = null;

    @SerializedName("activate_pick_type")
    private int activatePickType;

    @SerializedName("activate_sort_type")
    private Integer activeSortType;

    @SerializedName("activate_tab_type")
    private Integer activeTabType;

    @SerializedName("custom_id_type")
    private Integer customIdType;

    @SerializedName("custom_ids")
    private String customIds;

    @SerializedName("entrance_location")
    private String entranceLocation;

    @SerializedName("source_product_id")
    private String sourceProductId;

    @SerializedName("pre_store_group_type")
    private String storeGroupType;

    @SerializedName("pre_store_source_page")
    private String storeSourcePage;

    public static final class a {
        public a() {
        }

        public static ECStoreTabSourceConfig a(ECStoreParam r2) {
            Intrinsics.checkNotNullParameter(r2, "storeParam");
            ECStoreTabSourceConfig r0 = new ECStoreTabSourceConfig();
            r0.setSourceProductId(r2.getStoreNaviParam().getSourceProductId());
            r0.setCustomIdType(r2.getProductBasicRequestParam().getCustomIdType());
            r0.setCustomIds(r2.getProductBasicRequestParam().getCustomIds());
            r0.setActiveTabType(r2.getTabId());
            r0.setActiveSortType(r2.getSortType());
            r0.setEntranceLocation(r2.getEntranceLocation());
            r0.setStoreSourcePage(r2.getStoreSourcePage());
            r0.setStoreGroupType(r2.getStoreGroupType());
            Integer r3 = r2.getPickType();
            if (r3 == null) goto L5;
            int r4 = r3.intValue();
        L6:
            r0.setActivatePickType(r4);
            return r0;
        L5:
            r4 = 0;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreTabSourceConfig() {
    }

    public final int getActivatePickType() {
        return this.activatePickType;
    }

    public final Integer getActiveSortType() {
        return this.activeSortType;
    }

    public final Integer getActiveTabType() {
        return this.activeTabType;
    }

    public final Integer getCustomIdType() {
        return this.customIdType;
    }

    public final String getCustomIds() {
        return this.customIds;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final String getSourceProductId() {
        return this.sourceProductId;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
    }

    public final void setActivatePickType(int r1) {
        this.activatePickType = r1;
    }

    public final void setActiveSortType(Integer r1) {
        this.activeSortType = r1;
    }

    public final void setActiveTabType(Integer r1) {
        this.activeTabType = r1;
    }

    public final void setCustomIdType(Integer r1) {
        this.customIdType = r1;
    }

    public final void setCustomIds(String r1) {
        this.customIds = r1;
    }

    public final void setEntranceLocation(String r1) {
        this.entranceLocation = r1;
    }

    public final void setSourceProductId(String r1) {
        this.sourceProductId = r1;
    }

    public final void setStoreGroupType(String r1) {
        this.storeGroupType = r1;
    }

    public final void setStoreSourcePage(String r1) {
        this.storeSourcePage = r1;
    }
}
