package com.ss.android.ugc.aweme.commercialize.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R \u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR \u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R \u00103\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001e\u00106\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R\u001e\u00109\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R \u0010;\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR \u0010>\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR \u0010A\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\f\"\u0004\bC\u0010\u000eR \u0010D\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\f\"\u0004\bF\u0010\u000eR \u0010G\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR \u0010J\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001c\u0010M\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR \u0010P\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR \u0010S\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR \u0010Y\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u000eR \u0010\\\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\f\"\u0004\b^\u0010\u000eR \u0010_\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010\u000eR \u0010b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\f\"\u0004\bd\u0010\u000eR\u001c\u0010e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\f\"\u0004\bg\u0010\u000eR \u0010h\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\f\"\u0004\bj\u0010\u000e¨\u0006k"}, d2 = {"Lcom/ss/android/ugc/aweme/commercialize/model/AdEventData;", "Ljava/io/Serializable;", "()V", "adId", "", "getAdId", "()J", "setAdId", "(J)V", "anchorId", "", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "blindAd", "", "getBlindAd", "()I", "setBlindAd", "(I)V", "carrierSource", "getCarrierSource", "setCarrierSource", "cid", "getCid", "setCid", "createChannel", "getCreateChannel", "setCreateChannel", "creativeId", "getCreativeId", "setCreativeId", "docId", "getDocId", "setDocId", "doubleColumnButtonRefer", "getDoubleColumnButtonRefer", "setDoubleColumnButtonRefer", "enableCardStrongStyle", "getEnableCardStrongStyle", "setEnableCardStrongStyle", "enterFrom", "getEnterFrom", "setEnterFrom", "groupId", "getGroupId", "setGroupId", "groupType", "getGroupType", "setGroupType", "hardtosoft", "getHardtosoft", "setHardtosoft", "imageMode", "getImageMode", "setImageMode", "isAladdin", "setAladdin", "listItemBackup", "getListItemBackup", "setListItemBackup", "listItemId", "getListItemId", "setListItemId", "listItemKey", "getListItemKey", "setListItemKey", "listResultType", "getListResultType", "setListResultType", "logExtra", "getLogExtra", "setLogExtra", "openSchema", "getOpenSchema", "setOpenSchema", "previousPage", "getPreviousPage", "setPreviousPage", "productId", "getProductId", "setProductId", "qponInfo", "Lcom/ss/android/ugc/aweme/commercialize/model/QponInfo;", "getQponInfo", "()Lcom/ss/android/ugc/aweme/commercialize/model/QponInfo;", "setQponInfo", "(Lcom/ss/android/ugc/aweme/commercialize/model/QponInfo;)V", "reqId", "getReqId", "setReqId", "resultSource", "getResultSource", "setResultSource", "roomId", "getRoomId", "setRoomId", "searchResultId", "getSearchResultId", "setSearchResultId", "sourceMethod", "getSourceMethod", "setSourceMethod", "tokenType", "getTokenType", "setTokenType", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AdEventData implements Serializable {

    @SerializedName("ad_id")
    private long adId;

    @SerializedName("anchor_id")
    private String anchorId;

    @SerializedName("blind_ad")
    private int blindAd;
    private String carrierSource;

    @SerializedName("cid")
    private String cid;

    @SerializedName("create_channel")
    private int createChannel;

    @SerializedName("creative_id")
    private long creativeId;

    @SerializedName("doc_id")
    private long docId;

    @SerializedName("double_column_button_refer")
    private String doubleColumnButtonRefer;

    @SerializedName("enable_card_strong_style")
    private int enableCardStrongStyle;

    @SerializedName("enter_from")
    private String enterFrom;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("group_type")
    private int groupType;

    @SerializedName("hardtosoft")
    private String hardtosoft;

    @SerializedName("image_mode")
    private int imageMode;

    @SerializedName(a.KEY_IS_ALADDIN)
    private int isAladdin;

    @SerializedName("list_item_id_backup")
    private String listItemBackup;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LIST_ITEM_ID)
    private String listItemId;

    @SerializedName("list_item_id_key")
    private String listItemKey;

    @SerializedName("list_result_type")
    private String listResultType;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName("open_schema")
    private String openSchema;
    private String previousPage;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("qpon_info")
    private QponInfo qponInfo;

    @SerializedName("req_id")
    private String reqId;

    @SerializedName("result_source")
    private String resultSource;

    @SerializedName("room_id")
    private String roomId;

    @SerializedName("search_result_id")
    private String searchResultId;
    private String sourceMethod;

    @SerializedName("token_type")
    private String tokenType;

    public AdEventData() {
        this.listResultType = "";
        this.openSchema = "";
        this.enterFrom = "";
        this.logExtra = "";
        this.resultSource = "";
        this.roomId = "";
        this.listItemId = "";
        this.anchorId = "";
        this.groupId = "";
        this.listItemKey = "";
        this.listItemBackup = "";
        this.tokenType = "";
        this.hardtosoft = "";
        this.searchResultId = "";
        this.reqId = "";
        this.productId = "";
        this.cid = "";
    }

    public final long getAdId() {
        return this.adId;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final int getBlindAd() {
        return this.blindAd;
    }

    public final String getCarrierSource() {
        return this.carrierSource;
    }

    public final String getCid() {
        return this.cid;
    }

    public final int getCreateChannel() {
        return this.createChannel;
    }

    public final long getCreativeId() {
        return this.creativeId;
    }

    public final long getDocId() {
        return this.docId;
    }

    public final String getDoubleColumnButtonRefer() {
        return this.doubleColumnButtonRefer;
    }

    public final int getEnableCardStrongStyle() {
        return this.enableCardStrongStyle;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getGroupType() {
        return this.groupType;
    }

    public final String getHardtosoft() {
        return this.hardtosoft;
    }

    public final int getImageMode() {
        return this.imageMode;
    }

    public final String getListItemBackup() {
        return this.listItemBackup;
    }

    public final String getListItemId() {
        return this.listItemId;
    }

    public final String getListItemKey() {
        return this.listItemKey;
    }

    public final String getListResultType() {
        return this.listResultType;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getOpenSchema() {
        return this.openSchema;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final QponInfo getQponInfo() {
        return this.qponInfo;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public final String getResultSource() {
        return this.resultSource;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchResultId() {
        return this.searchResultId;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final int isAladdin() {
        return this.isAladdin;
    }

    public final void setAdId(long r100) {
        this.adId = r100;
    }

    public final void setAladdin(int r100) {
        this.isAladdin = r100;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setBlindAd(int r100) {
        this.blindAd = r100;
    }

    public final void setCarrierSource(String r100) {
        this.carrierSource = r100;
    }

    public final void setCid(String r100) {
        this.cid = r100;
    }

    public final void setCreateChannel(int r100) {
        this.createChannel = r100;
    }

    public final void setCreativeId(long r100) {
        this.creativeId = r100;
    }

    public final void setDocId(long r100) {
        this.docId = r100;
    }

    public final void setDoubleColumnButtonRefer(String r100) {
        this.doubleColumnButtonRefer = r100;
    }

    public final void setEnableCardStrongStyle(int r100) {
        this.enableCardStrongStyle = r100;
    }

    public final void setEnterFrom(String r100) {
        this.enterFrom = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setGroupType(int r100) {
        this.groupType = r100;
    }

    public final void setHardtosoft(String r100) {
        this.hardtosoft = r100;
    }

    public final void setImageMode(int r100) {
        this.imageMode = r100;
    }

    public final void setListItemBackup(String r100) {
        this.listItemBackup = r100;
    }

    public final void setListItemId(String r100) {
        this.listItemId = r100;
    }

    public final void setListItemKey(String r100) {
        this.listItemKey = r100;
    }

    public final void setListResultType(String r100) {
        this.listResultType = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public final void setOpenSchema(String r100) {
        this.openSchema = r100;
    }

    public final void setPreviousPage(String r100) {
        this.previousPage = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setQponInfo(QponInfo r100) {
        this.qponInfo = r100;
    }

    public final void setReqId(String r100) {
        this.reqId = r100;
    }

    public final void setResultSource(String r100) {
        this.resultSource = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setSearchResultId(String r100) {
        this.searchResultId = r100;
    }

    public final void setSourceMethod(String r100) {
        this.sourceMethod = r100;
    }

    public final void setTokenType(String r100) {
        this.tokenType = r100;
    }
}
