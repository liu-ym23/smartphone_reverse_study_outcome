package com.ss.android.ugc.aweme.discover.model.commodity.select;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\"\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u0007¢\u0006\u0004\be\u0010fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\be\u0010gJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u0006\u0010\n\u001a\u00020\u0000R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\"\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R$\u00100\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\"\u00109\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001f\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\"\u0010<\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!\"\u0004\b>\u0010#R*\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR$\u0010Q\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR$\u0010T\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010I\u001a\u0004\bU\u0010K\"\u0004\bV\u0010MR$\u0010W\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u00101\u001a\u0004\bX\u00103\"\u0004\bY\u00105R\"\u0010Z\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\r\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R$\u0010`\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010I\u001a\u0004\b^\u0010K\"\u0004\b_\u0010MR$\u0010d\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010I\u001a\u0004\bb\u0010K\"\u0004\bc\u0010M¨\u0006i"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "deepCopyParcel", "", "enableScroll", "Z", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "enableCeiling", "getEnableCeiling", "setEnableCeiling", "enableCenterAlignment", "getEnableCenterAlignment", "setEnableCenterAlignment", "enableShow", "Ljava/lang/Boolean;", "getEnableShow", "()Ljava/lang/Boolean;", "setEnableShow", "(Ljava/lang/Boolean;)V", "height", "I", "getHeight", "()I", "setHeight", "(I)V", "leftPadding", "getLeftPadding", "setLeftPadding", "rightPadding", "getRightPadding", "setRightPadding", "topPadding", "getTopPadding", "setTopPadding", "bottomPadding", "getBottomPadding", "setBottomPadding", "fontSize", "Ljava/lang/Integer;", "getFontSize", "()Ljava/lang/Integer;", "setFontSize", "(Ljava/lang/Integer;)V", "innerWidthMargin", "getInnerWidthMargin", "setInnerWidthMargin", "miniSpace", "getMiniSpace", "setMiniSpace", "itemGap", "getItemGap", "setItemGap", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "renderItemList", "Ljava/util/List;", "getRenderItemList", "()Ljava/util/List;", "setRenderItemList", "(Ljava/util/List;)V", "", "widthStrategy", "Ljava/lang/String;", "getWidthStrategy", "()Ljava/lang/String;", "setWidthStrategy", "(Ljava/lang/String;)V", "queryId", "getQueryId", "setQueryId", "bgStartColor", "getBgStartColor", "setBgStartColor", "bgEndColor", "getBgEndColor", "setBgEndColor", "topCornerRadius", "getTopCornerRadius", "setTopCornerRadius", "withoutQuickFilter", "getWithoutQuickFilter", "setWithoutQuickFilter", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getImprId", "setImprId", "imprId", "b", "getGroupId", "setGroupId", "groupId", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenderLine implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;
    public static final String STRATEGY_ALIGN_LEFT = "fromAlignLeft";
    public static final String STRATEGY_CONTENT = "fromContent";
    public static final String STRATEGY_CONTENT_SCROLL_NOT = "fromContentCannotScroll";
    public static final String STRATEGY_LAST_ITEM_FIXED_AT_END = "fromServerLastItemFixedAtEnd";
    public static final String STRATEGY_SCREEN_WIDTH_DIVIDE_EQUALLY = "screenWidthDivideEqually";
    public static final String STRATEGY_SERVER = "fromServer";
    public static final String STRATEGY_SERVER_IS_SIMPLE = "fromServerIsSimple";
    public static final String STRATEGY_SERVER_LINE = "fromServerInline";
    public static final String STRATEGY_SERVER_SPACE_FIXED = "fromServerSpaceFixed";
    public static final String STRATEGY_SERVER_TITLE = "fromServerTitle";
    public static final String STRATEGY_SLIDABLE_CONTENT = "fromSlidableContent";
    public static final String STRATEGY_TAB_QUICK_FILTER_COMBINED = "tabQuickFilterCombined";
    public static final String STRATEGY_TAB_QUICK_FILTER_COMBINED_V2 = "tabQuickFilterCombinedV2";
    public static final String STRATEGY_TAB_SORT_FILTER_COMBINED = "tabSortFilterCombined";
    public static final String STRATEGY_TAB_SORT_FILTER_COMBINED_V2 = "tabSortFilterCombinedV2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f450544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient String f450545b;

    @SerializedName("bg_end_color")
    private String bgEndColor;

    @SerializedName("bg_start_color")
    private String bgStartColor;

    @SerializedName("bottom_padding")
    private int bottomPadding;

    @SerializedName("enable_ceiling")
    private boolean enableCeiling;

    @SerializedName("enable_center_alignment")
    private boolean enableCenterAlignment;

    @SerializedName("enable_scroll")
    private boolean enableScroll;

    @SerializedName("enable_show")
    private Boolean enableShow;

    @SerializedName("font_size")
    private Integer fontSize;

    @SerializedName("height")
    private int height;

    @SerializedName("inner_width_margin")
    private Integer innerWidthMargin;

    @SerializedName("item_gap")
    private int itemGap;

    @SerializedName("left_padding")
    private int leftPadding;

    @SerializedName("mini_space")
    private int miniSpace;

    @SerializedName("query_id")
    private String queryId;

    @SerializedName(ChameleonOpenTracker.Stage.RENDER)
    private List<RenderItem> renderItemList;

    @SerializedName("right_padding")
    private int rightPadding;

    @SerializedName("top_corner_radius")
    private Integer topCornerRadius;

    @SerializedName("top_padding")
    private int topPadding;

    @SerializedName("component_width_strategy")
    private String widthStrategy;

    @SerializedName("without_quick_filter")
    private boolean withoutQuickFilter;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0014\u0010\r\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "", "STRATEGY_ALIGN_LEFT", "Ljava/lang/String;", "STRATEGY_CONTENT", "STRATEGY_CONTENT_SCROLL_NOT", "STRATEGY_LAST_ITEM_FIXED_AT_END", "STRATEGY_SCREEN_WIDTH_DIVIDE_EQUALLY", "STRATEGY_SERVER", "STRATEGY_SERVER_IS_SIMPLE", "STRATEGY_SERVER_LINE", "STRATEGY_SERVER_SPACE_FIXED", "STRATEGY_SERVER_TITLE", "STRATEGY_SLIDABLE_CONTENT", "STRATEGY_TAB_QUICK_FILTER_COMBINED", "STRATEGY_TAB_QUICK_FILTER_COMBINED_V2", "STRATEGY_TAB_SORT_FILTER_COMBINED", "STRATEGY_TAB_SORT_FILTER_COMBINED_V2", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<RenderLine> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final RenderLine createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RenderLine(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final RenderLine[] newArray(int r100) {
            return new RenderLine[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RenderLine() {
        this.miniSpace = -1;
        this.itemGap = -1;
        this.widthStrategy = STRATEGY_SERVER;
    }

    public final RenderLine deepCopyParcel() {
        Parcel r100 = Parcel.obtain();
        writeToParcel(r100, 0);     // Catch: Throwable -> L6
        r100.setDataPosition(0);     // Catch: Throwable -> L6
        CREATOR.getClass();     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r100, "parcel");     // Catch: Throwable -> L6
        RenderLine r101 = new RenderLine(r100);     // Catch: Throwable -> L6
        r100.recycle();
        return r101;
    L6:
        th = move-exception;
        r100.recycle();
        throw th;
    }

    public final String getBgEndColor() {
        return this.bgEndColor;
    }

    public final String getBgStartColor() {
        return this.bgStartColor;
    }

    public final int getBottomPadding() {
        return this.bottomPadding;
    }

    public final boolean getEnableCeiling() {
        return this.enableCeiling;
    }

    public final boolean getEnableCenterAlignment() {
        return this.enableCenterAlignment;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final Boolean getEnableShow() {
        return this.enableShow;
    }

    public final Integer getFontSize() {
        return this.fontSize;
    }

    public final String getGroupId() {
        return this.f450545b;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImprId() {
        return this.f450544a;
    }

    public final Integer getInnerWidthMargin() {
        return this.innerWidthMargin;
    }

    public final int getItemGap() {
        return this.itemGap;
    }

    public final int getLeftPadding() {
        return this.leftPadding;
    }

    public final int getMiniSpace() {
        return this.miniSpace;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final List<RenderItem> getRenderItemList() {
        return this.renderItemList;
    }

    public final int getRightPadding() {
        return this.rightPadding;
    }

    public final Integer getTopCornerRadius() {
        return this.topCornerRadius;
    }

    public final int getTopPadding() {
        return this.topPadding;
    }

    public final String getWidthStrategy() {
        return this.widthStrategy;
    }

    public final boolean getWithoutQuickFilter() {
        return this.withoutQuickFilter;
    }

    public RenderLine(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        boolean r101 = false;
        byte r102 = (byte) 0;
        if (r100.readByte() == r102) goto L5;
        boolean r103 = true;
    L6:
        this.enableScroll = r103;
        if (r100.readByte() == r102) goto L9;
        boolean r104 = true;
    L10:
        this.enableCeiling = r104;
        if (r100.readByte() == r102) goto L13;
        boolean r105 = true;
    L14:
        this.enableCenterAlignment = r105;
        Object r106 = r100.readValue(Boolean.TYPE.getClassLoader());
        Object r107 = null;
        if ((r106 instanceof Boolean) == true) goto L17;
        r106 = null;
    L17:
        this.enableShow = (Boolean) r106;
        this.height = r100.readInt();
        this.leftPadding = r100.readInt();
        this.rightPadding = r100.readInt();
        this.topPadding = r100.readInt();
        this.bottomPadding = r100.readInt();
        Class r108 = Integer.TYPE;
        Object r109 = r100.readValue(r108.getClassLoader());
        if ((r109 instanceof Integer) == true) goto L20;
        r109 = null;
    L20:
        this.fontSize = (Integer) r109;
        Object r110 = r100.readValue(r108.getClassLoader());
        if ((r110 instanceof Integer) == true) goto L23;
        r110 = null;
    L23:
        this.innerWidthMargin = (Integer) r110;
        this.miniSpace = r100.readInt();
        this.itemGap = r100.readInt();
        this.renderItemList = r100.createTypedArrayList(RenderItem.CREATOR);
        this.widthStrategy = r100.readString();
        this.queryId = r100.readString();
        this.bgStartColor = r100.readString();
        this.bgEndColor = r100.readString();
        Object r111 = r100.readValue(r108.getClassLoader());
        if ((r111 instanceof Integer) == false) goto L27;
        r107 = r111;
    L27:
        this.topCornerRadius = (Integer) r107;
        if (r100.readByte() == r102) goto L30;
        r101 = true;
    L30:
        this.withoutQuickFilter = r101;
        return;
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public final void setBgEndColor(String r100) {
        this.bgEndColor = r100;
    }

    public final void setBgStartColor(String r100) {
        this.bgStartColor = r100;
    }

    public final void setBottomPadding(int r100) {
        this.bottomPadding = r100;
    }

    public final void setEnableCeiling(boolean r100) {
        this.enableCeiling = r100;
    }

    public final void setEnableCenterAlignment(boolean r100) {
        this.enableCenterAlignment = r100;
    }

    public final void setEnableScroll(boolean r100) {
        this.enableScroll = r100;
    }

    public final void setEnableShow(Boolean r100) {
        this.enableShow = r100;
    }

    public final void setFontSize(Integer r100) {
        this.fontSize = r100;
    }

    public final void setGroupId(String r100) {
        this.f450545b = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setImprId(String r100) {
        this.f450544a = r100;
    }

    public final void setInnerWidthMargin(Integer r100) {
        this.innerWidthMargin = r100;
    }

    public final void setItemGap(int r100) {
        this.itemGap = r100;
    }

    public final void setLeftPadding(int r100) {
        this.leftPadding = r100;
    }

    public final void setMiniSpace(int r100) {
        this.miniSpace = r100;
    }

    public final void setQueryId(String r100) {
        this.queryId = r100;
    }

    public final void setRenderItemList(List<RenderItem> r100) {
        this.renderItemList = r100;
    }

    public final void setRightPadding(int r100) {
        this.rightPadding = r100;
    }

    public final void setTopCornerRadius(Integer r100) {
        this.topCornerRadius = r100;
    }

    public final void setTopPadding(int r100) {
        this.topPadding = r100;
    }

    public final void setWidthStrategy(String r100) {
        this.widthStrategy = r100;
    }

    public final void setWithoutQuickFilter(boolean r100) {
        this.withoutQuickFilter = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeByte(this.enableScroll ? 1 : 0);
        r100.writeByte(this.enableCeiling ? 1 : 0);
        r100.writeByte(this.enableCenterAlignment ? 1 : 0);
        r100.writeValue(this.enableShow);
        r100.writeInt(this.height);
        r100.writeInt(this.leftPadding);
        r100.writeInt(this.rightPadding);
        r100.writeInt(this.topPadding);
        r100.writeInt(this.bottomPadding);
        r100.writeValue(this.fontSize);
        r100.writeValue(this.innerWidthMargin);
        r100.writeInt(this.miniSpace);
        r100.writeInt(this.itemGap);
        r100.writeTypedList(this.renderItemList);
        r100.writeString(this.widthStrategy);
        r100.writeString(this.queryId);
        r100.writeString(this.bgStartColor);
        r100.writeString(this.bgEndColor);
        r100.writeValue(this.topCornerRadius);
        r100.writeByte(this.withoutQuickFilter ? 1 : 0);
    }
}
