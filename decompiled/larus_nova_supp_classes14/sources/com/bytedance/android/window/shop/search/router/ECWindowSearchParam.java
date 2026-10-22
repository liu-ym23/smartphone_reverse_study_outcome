package com.bytedance.android.window.shop.search.router;

import com.bytedance.android.ec.window.base.common.param.WindowAccountParam;
import com.bytedance.android.ec.window.base.common.param.WindowProductBasicRequestParam;
import com.bytedance.android.ec.window.base.repository.vo.WindowSearchSuggestWord;
import com.bytedance.android.shopping.extensions.k;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008b\u0001B<\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001b\u0010\u001e\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010 \u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001a\u00104\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u0010\"\u0004\b8\u0010\u0012R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010\u0012R$\u0010<\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\u000e\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010\u000e\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u000e\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R$\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u000e\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012R$\u0010K\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u000e\u001a\u0004\bL\u0010\u0010\"\u0004\bM\u0010\u0012R$\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u000e\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010\u0012R$\u0010R\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010\u000e\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R$\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\u000e\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R$\u0010^\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\"\u0010a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010 \u001a\u0004\ba\u0010!\"\u0004\bb\u0010#R$\u0010c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010\u000e\u001a\u0004\bd\u0010\u0010\"\u0004\be\u0010\u0012R$\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010\u000e\u001a\u0004\bg\u0010\u0010\"\u0004\bh\u0010\u0012R\"\u0010i\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010 \u001a\u0004\bi\u0010!\"\u0004\bj\u0010#R$\u0010k\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u000e\u001a\u0004\bl\u0010\u0010\"\u0004\bm\u0010\u0012R\"\u0010n\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010 \u001a\u0004\bo\u0010!\"\u0004\bp\u0010#R\u0017\u0010r\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR*\u0010x\u001a\n\u0012\u0004\u0012\u00020w\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u001c\u0010~\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010\u000e\u001a\u0004\b\u007f\u0010\u0010R\u001f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010\u000e\u001a\u0005\b\u0081\u0001\u0010\u0010R\u001f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000e\u001a\u0005\b\u0083\u0001\u0010\u0010R\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u000e\u001a\u0005\b\u0085\u0001\u0010\u0010R\u0014\u0010\u0086\u0001\u001a\u00020Q8F¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u008c\u0001"}, d2 = {"Lcom/bytedance/android/window/shop/search/router/ECWindowSearchParam;", "Ljava/io/Serializable;", "", "key", "", "value", "", "putPassThroughParam", "T", "getPassThroughParam", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isPreview", "entranceInfo", "Ljava/lang/String;", "getEntranceInfo", "()Ljava/lang/String;", "setEntranceInfo", "(Ljava/lang/String;)V", "searchHint", "getSearchHint", "setSearchHint", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "Lcom/bytedance/android/ec/window/base/common/param/WindowAccountParam;", "storeAccountParam$delegate", "Lkotlin/Lazy;", "getStoreAccountParam", "()Lcom/bytedance/android/ec/window/base/common/param/WindowAccountParam;", "storeAccountParam", "isStoreHotSearch", "Z", "()Z", "setStoreHotSearch", "(Z)V", "enterMethod", "getEnterMethod", "setEnterMethod", "enterFrom", "getEnterFrom", "setEnterFrom", "", "passThroughParams", "Ljava/util/Map;", "getPassThroughParams", "()Ljava/util/Map;", "isHistory", "setHistory", "searchSource", "getSearchSource", "setSearchSource", "pageName", "getPageName", "entranceLocation", "getEntranceLocation", "setEntranceLocation", "enterFromSecond", "getEnterFromSecond", "setEnterFromSecond", "searchParams", "getSearchParams", "setSearchParams", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "tabNameSecond", "getTabNameSecond", "setTabNameSecond", "tabLabel", "getTabLabel", "setTabLabel", "tabName", "getTabName", "setTabName", "tempId", "getTempId", "setTempId", "", "followStatus", "Ljava/lang/Integer;", "getFollowStatus", "()Ljava/lang/Integer;", "setFollowStatus", "(Ljava/lang/Integer;)V", "storeSourcePage", "getStoreSourcePage", "setStoreSourcePage", "storeSourceMethod", "getStoreSourceMethod", "setStoreSourceMethod", "storeGroupType", "getStoreGroupType", "setStoreGroupType", "isEcShare", "setEcShare", "shareContent", "getShareContent", "setShareContent", "shareObject", "getShareObject", "setShareObject", "isFromSug", "setFromSug", "groupId", "getGroupId", "setGroupId", "enableHideFloatLive", "getEnableHideFloatLive", "setEnableHideFloatLive", "Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "productBasicRequestParam", "Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "getProductBasicRequestParam", "()Lcom/bytedance/android/ec/window/base/common/param/WindowProductBasicRequestParam;", "", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWord;", "searchSuggestWords", "Ljava/util/List;", "getSearchSuggestWords", "()Ljava/util/List;", "setSearchSuggestWords", "(Ljava/util/List;)V", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "shopId", "getShopId", "secShopId", "getSecShopId", "isFromAd", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowSearchParam implements Serializable {
    public static final a Companion = null;
    public static final String KEY_ENABLE_HIDE_FLOAT_LIVE = "enable_hide_float_live";
    private String anchorId;

    @SerializedName("author_id")
    private final String authorId;
    private boolean enableHideFloatLive;
    private String enterFrom;
    private String enterFromSecond;
    private String enterMethod;
    private String entranceInfo;
    private String entranceLocation;
    private Integer followStatus;
    private String groupId;
    private boolean isEcShare;
    private boolean isFromSug;
    private boolean isHistory;
    private boolean isStoreHotSearch;
    private final String pageName;
    private final Map<String, Object> passThroughParams;
    private final WindowProductBasicRequestParam productBasicRequestParam;
    private String roomId;
    private String searchHint;
    private String searchKeyword;
    private String searchParams;
    private String searchSource;
    private List<WindowSearchSuggestWord> searchSuggestWords;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName("sec_shop_id")
    private final String secShopId;
    private String shareContent;
    private String shareObject;

    @SerializedName("shop_id")
    private final String shopId;
    private final Lazy storeAccountParam$delegate;
    private String storeGroupType;
    private String storeSourceMethod;
    private String storeSourcePage;
    private String tabLabel;
    private String tabName;
    private String tabNameSecond;
    private String tempId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECWindowSearchParam() {
        this(null, null, null, null, 15, null);
    }

    public final WindowAccountParam getStoreAccountParam() {
        return (WindowAccountParam) this.storeAccountParam$delegate.getValue();
    }

    public final int isFromAd() {
        JSONObject r0 = k.w(this.entranceInfo);
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.optInt("is_from_ad", 0);
    }

    public final boolean isPreview() {
        if (this.productBasicRequestParam.getTmpId() != null) goto L15;
        String r0 = this.productBasicRequestParam.getToken();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L15:
        return true;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final boolean getEnableHideFloatLive() {
        return this.enableHideFloatLive;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromSecond() {
        return this.enterFromSecond;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final Map<String, Object> getPassThroughParams() {
        return this.passThroughParams;
    }

    public final WindowProductBasicRequestParam getProductBasicRequestParam() {
        return this.productBasicRequestParam;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchHint() {
        return this.searchHint;
    }

    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSearchSource() {
        return this.searchSource;
    }

    public final List<WindowSearchSuggestWord> getSearchSuggestWords() {
        return this.searchSuggestWords;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSecShopId() {
        return this.secShopId;
    }

    public final String getShareContent() {
        return this.shareContent;
    }

    public final String getShareObject() {
        return this.shareObject;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getStoreGroupType() {
        return this.storeGroupType;
    }

    public final String getStoreSourceMethod() {
        return this.storeSourceMethod;
    }

    public final String getStoreSourcePage() {
        return this.storeSourcePage;
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

    public final String getTempId() {
        return this.tempId;
    }

    public final boolean isEcShare() {
        return this.isEcShare;
    }

    public final boolean isFromSug() {
        return this.isFromSug;
    }

    public final boolean isHistory() {
        return this.isHistory;
    }

    public final boolean isStoreHotSearch() {
        return this.isStoreHotSearch;
    }

    public final <T> T getPassThroughParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        T r3 = (T) this.passThroughParams.get(r2);
        if ((r3 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    public final void setAnchorId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.anchorId = r2;
    }

    public final void setEcShare(boolean r1) {
        this.isEcShare = r1;
    }

    public final void setEnableHideFloatLive(boolean r1) {
        this.enableHideFloatLive = r1;
    }

    public final void setEnterFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFrom = r2;
    }

    public final void setEnterFromSecond(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterFromSecond = r2;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setEntranceInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceInfo = r2;
    }

    public final void setEntranceLocation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entranceLocation = r2;
    }

    public final void setFollowStatus(Integer r1) {
        this.followStatus = r1;
    }

    public final void setFromSug(boolean r1) {
        this.isFromSug = r1;
    }

    public final void setGroupId(String r1) {
        this.groupId = r1;
    }

    public final void setHistory(boolean r1) {
        this.isHistory = r1;
    }

    public final void setRoomId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.roomId = r2;
    }

    public final void setSearchHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchHint = r2;
    }

    public final void setSearchKeyword(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.searchKeyword = r2;
    }

    public final void setSearchParams(String r1) {
        this.searchParams = r1;
    }

    public final void setSearchSource(String r1) {
        this.searchSource = r1;
    }

    public final void setSearchSuggestWords(List<WindowSearchSuggestWord> r1) {
        this.searchSuggestWords = r1;
    }

    public final void setShareContent(String r1) {
        this.shareContent = r1;
    }

    public final void setShareObject(String r1) {
        this.shareObject = r1;
    }

    public final void setStoreGroupType(String r1) {
        this.storeGroupType = r1;
    }

    public final void setStoreHotSearch(boolean r1) {
        this.isStoreHotSearch = r1;
    }

    public final void setStoreSourceMethod(String r1) {
        this.storeSourceMethod = r1;
    }

    public final void setStoreSourcePage(String r1) {
        this.storeSourcePage = r1;
    }

    public final void setTabLabel(String r1) {
        this.tabLabel = r1;
    }

    public final void setTabName(String r1) {
        this.tabName = r1;
    }

    public final void setTabNameSecond(String r1) {
        this.tabNameSecond = r1;
    }

    public final void setTempId(String r1) {
        this.tempId = r1;
    }

    public final void putPassThroughParam(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.passThroughParams.put(r2, r3);
    }

    public ECWindowSearchParam(String r1, String r2, String r3, String r4) {
        this.authorId = r1;
        this.secAuthorId = r2;
        this.shopId = r3;
        this.secShopId = r4;
        this.entranceInfo = "";
        this.searchHint = "";
        this.searchKeyword = "";
        this.storeAccountParam$delegate = LazyKt.lazy(ECWindowSearchParam$storeAccountParam$2.INSTANCE);
        this.enterMethod = "";
        this.enterFrom = "";
        this.passThroughParams = new LinkedHashMap();
        this.pageName = "store_page";
        this.entranceLocation = "";
        this.enterFromSecond = "";
        this.roomId = "";
        this.anchorId = "";
        this.followStatus = -1;
        this.productBasicRequestParam = new WindowProductBasicRequestParam();
    }

    public /* synthetic */ ECWindowSearchParam(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }
}
