package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.livesdk.livecommerce.model.CategoryInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\bD\u0010EJ\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\"\u00105\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010-\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\"\u00108\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010-\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\"\u0010;\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010 \u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R\"\u0010>\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010 \u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R\"\u0010B\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010-\u001a\u0004\bB\u0010/\"\u0004\bC\u00101¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategory;", "Ljava/io/Serializable;", "Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/flow/a$a;", "", "isAllTab", "", "getType", "", "getTypeString", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "", "promotionIds", "Ljava/util/List;", "getPromotionIds", "()Ljava/util/List;", "setPromotionIds", "(Ljava/util/List;)V", "categoryType", "getCategoryType", "setCategoryType", "uniqueIndex", "getUniqueIndex", "setUniqueIndex", "enhanceType", "I", "getEnhanceType", "()I", "setEnhanceType", "(I)V", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategoryImage;", "image", "Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategoryImage;", "getImage", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategoryImage;", "setImage", "(Lcom/bytedance/android/livesdk/livecommerce/network/response/PromotionCategoryImage;)V", "disableAppend", "Z", "getDisableAppend", "()Z", "setDisableAppend", "(Z)V", "hasPromotions", "getHasPromotions", "setHasPromotions", "needReload", "getNeedReload", "setNeedReload", "selected", "getSelected", "setSelected", "viewType", "getViewType", "setViewType", "tabRow", "getTabRow", "setTabRow", "a", "isResorted", "setResorted", "<init>", "()V", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCategory implements Serializable, com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.a.InterfaceC0074a {
    public static final String ALL_TAB_UNIQUE_INDEX = "";
    public static final String CATEGORY_TYPE_CUSTOM = "12";
    public static final String CATEGORY_TYPE_FIRST = "1";
    public static final String CATEGORY_TYPE_FRONT = "21";
    public static final String CATEGORY_TYPE_SECOND = "2";
    public static final String CATEGORY_TYPE_TEMPLATE = "11";
    public static final a Companion = null;
    public transient boolean a;

    @SerializedName(LocationMonitorConst.TYPE)
    private String categoryType;

    @SerializedName("disable_append")
    private boolean disableAppend;

    @SerializedName("enhance_type")
    private int enhanceType;
    private boolean hasPromotions;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private PromotionCategoryImage image;

    @SerializedName("name")
    private String name;
    private boolean needReload;

    @SerializedName("promotion_ids")
    private List<String> promotionIds;
    private boolean selected;
    private int tabRow;

    @SerializedName("unique_index")
    private String uniqueIndex;
    private int viewType;

    public static final class a {
        public a() {
        }

        public static PromotionCategory a(CategoryInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "categoryInfo");
            PromotionCategory r0 = new PromotionCategory();
            r0.setId(String.valueOf(r3.id));
            String r1 = r3.name;
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            r0.setName(r1);
            String r4 = r3.uniqueIndex;
            if (r4 == null) goto L9;
            r2 = r4;
        L9:
            r0.setUniqueIndex(r2);
            r0.setCategoryType(String.valueOf(r3.categoryType));
            r0.setNeedReload(r3.needReload);
            r0.setDisableAppend(r3.disableAppend);
            return r0;
        }

        public static boolean b(String r1) {
            if (r1 != null) goto L4;
        L7:
            return true;
        L4:
            if (Intrinsics.areEqual(r1, "") == true) goto L7;
            return false;
        }
    }

    static {
        Companion = new a();
    }

    public final String getTypeString() {
        int r0 = this.viewType;
        if (r0 != 0) goto L5;
        return "normal_tab";
    L5:
        if (r0 == 1) goto L7;
        return "";
    L7:
        return "more";
    }

    public final boolean isAllTab() {
        if (Intrinsics.areEqual(this.id, BDLocationException.ERROR_TIMEOUT) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.uniqueIndex, "") == true) goto L8;
        return false;
    }

    public PromotionCategory() {
        this.id = "";
        this.name = "";
        this.categoryType = "";
        this.uniqueIndex = "";
        this.hasPromotions = true;
        this.tabRow = -1;
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final boolean getDisableAppend() {
        return this.disableAppend;
    }

    public final int getEnhanceType() {
        return this.enhanceType;
    }

    public final boolean getHasPromotions() {
        return this.hasPromotions;
    }

    public final String getId() {
        return this.id;
    }

    public final PromotionCategoryImage getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedReload() {
        return this.needReload;
    }

    public final List<String> getPromotionIds() {
        return this.promotionIds;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getTabRow() {
        return this.tabRow;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.iron.widgets.flow.a.InterfaceC0074a
    public int getType() {
        return this.viewType;
    }

    public final String getUniqueIndex() {
        return this.uniqueIndex;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final boolean isResorted() {
        return this.a;
    }

    public final void setCategoryType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.categoryType = r2;
    }

    public final void setDisableAppend(boolean r1) {
        this.disableAppend = r1;
    }

    public final void setEnhanceType(int r1) {
        this.enhanceType = r1;
    }

    public final void setHasPromotions(boolean r1) {
        this.hasPromotions = r1;
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setImage(PromotionCategoryImage r1) {
        this.image = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNeedReload(boolean r1) {
        this.needReload = r1;
    }

    public final void setPromotionIds(List<String> r1) {
        this.promotionIds = r1;
    }

    public final void setResorted(boolean r1) {
        this.a = r1;
    }

    public final void setSelected(boolean r1) {
        this.selected = r1;
    }

    public final void setTabRow(int r1) {
        this.tabRow = r1;
    }

    public final void setUniqueIndex(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uniqueIndex = r2;
    }

    public final void setViewType(int r1) {
        this.viewType = r1;
    }
}
