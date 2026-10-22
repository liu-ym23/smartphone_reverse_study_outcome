package com.ss.android.ugc.aweme.poi.utils;

import android.text.TextUtils;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.bytedance.locallife.model.poi.resp.PoiStruct;
import com.bytedance.locallife.model.poi.resp.SimplePoiInfoStruct;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class PoiBundleBuilder {
    public String activityId;
    public HashMap<String, String> adParams;
    private String anchorContentJson;
    private String anchorId;
    public int anchorPopupViewType;
    private String anchorRelLogExtraParams;
    private String authorId;
    private long awemeLikeCount;
    private int awemeType;
    private String awemeid;
    public String backendType;
    private String bannerId;
    public String bizCode;
    public String brandId;
    public String carryExtraParams;
    private String challengeId;
    public String cityCode;
    private String clickMethod;
    public String coiReqId;
    public String collectionType;
    private String commentMode;
    private String contentSource;
    public String contentType;
    public String couponId;
    public String detailRank;
    private int displayStyle;
    public String distanceKM;
    public String districtCode;
    public Boolean enableVideoPip;
    private String enterFrom;
    private String enterId;
    private String enterMethod;
    private String enterSource;
    public String externalBdpLog;
    public String extraInfo;
    public HashMap<String, String> extraSessionParams;
    private String fSceneName;
    private String fTask;
    private String fToken;
    public int filterBy;
    public String forwardParams;
    public HashMap<String, String> forwardTypeV3Params;
    private int freshRelationTag;
    private String from;
    public int fromAds;
    public String fromGroupId;
    private String fromPoiId;
    private boolean fromRecommendCard;
    private String fromRoomId;
    public String fromUserId;
    public String genre;
    private double grouponDistance;
    private String grouponProductId;
    private boolean hasActivity;
    public boolean hasMpSpu;
    public boolean highlightTopRate;
    private String imChatType;
    private String imFeedType;
    private String imGroupOwnerType;
    private String imGroupType;
    private String imPrivateType;
    public String imprId;
    public long impressionId;
    private int inMall;
    public String ipName;
    public String ipTheme;
    public boolean isAnchorPopupShow;
    private boolean isClickPoiMiniAnchor;
    private String isCoupon;
    public String isFamiliarRecommend;
    private boolean isGrouponAnchor;
    private boolean isLifeItem;
    private boolean isMiniShowAnchor;
    private boolean isPreviewMode;
    private String isRecommendCard;
    private String isSpecialCity;
    public String leaderboardType;
    public String lifeBdxTag;
    public String lifeShareExt;
    public String locateRateId;
    private String logPb;
    private String minorTags;
    private String modalViewUrl;
    private Map<String, String> multiPoiMobParam;
    private int nearbyBubbleType;
    private Map<String, String> nearbyMobParams;
    public int optionType;
    private int order;
    public String outGroupType;
    public String outerGroupId;
    private String pagePoiBackendType;
    private String pagePoiId;
    private String pageType;
    private String poiBackendTypeCode;
    private String poiChannel;
    public Boolean poiDeviceSameCity;
    private String poiId;
    private String poiLabelType;
    public String poiLocationTypeOne;
    public String poiLocationTypeTwo;
    public String poiMapCardShowId;
    public String poiMapPageCardDistanceM;
    public String poiMapSessionId;
    private String poiName;
    private String poiType;
    public String prePageEnterId;
    public String prePoiEnterId;
    private String previousEnterFrom;
    private String previousEnterMethod;
    private String previousFromPage;
    private String previousModule;
    public String previousPage;
    public String previousPagePoiBackendType;
    public String previousPagePoiId;
    private String previousPageType;
    public String productSubType;
    private String queryType;
    public String rankCode;
    public String rankIndex;
    private String realAwemeId;
    private String relationTag;
    public long replyCommentId;
    private Map<String, String> requestHeaderParams;
    public String requestParams;
    public Integer retryTimesAfterTargetFound;
    private String scene;
    public int scrollOffset;
    public String scrollToComponent;
    public String scrollToSubview;
    private String searchKeyWord;
    private String searchParams;
    private int serviceIcon;
    private String serviceType;
    private String sessionId;
    public String showId;
    private String sonPoiId;
    public int sortBy;
    public String sortId;
    private int spuPlatformSources;
    private String sticker;
    public String subClass;
    private String suffix;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    public String f451366tab;
    public String tabId;
    private String tabName;
    public int tabRank;
    public String tabScene;
    private String tagShow;
    public String toUserId;
    public String topRateId;
    public HashMap<String, String> ugcMobParams;
    public int ugcSceneType;

    @AllowImpl
    public PoiBundle setup() {
        PoiBundle r100 = new PoiBundle();
        r100.enterSource = this.enterSource;
        r100.modalViewUrl = this.modalViewUrl;
        r100.fromAds = this.fromAds;
        r100.pagePoiId = this.pagePoiId;
        r100.poiId = this.poiId;
        r100.poiBackendTypeCode = this.poiBackendTypeCode;
        r100.pagePoiBackendType = this.pagePoiBackendType;
        r100.previousPageType = this.previousPageType;
        r100.previousPagePoiId = this.previousPagePoiId;
        r100.outGroupType = this.outGroupType;
        r100.outerGroupId = this.outerGroupId;
        r100.previousPagePoiBackendType = this.previousPagePoiBackendType;
        r100.poiDeviceSameCity = this.poiDeviceSameCity;
        r100.activityId = this.activityId;
        r100.couponId = this.couponId;
        r100.grouponProductId = this.grouponProductId;
        r100.grouponDistance = this.grouponDistance;
        r100.isGrouponAnchor = this.isGrouponAnchor;
        r100.isMiniShowAnchor = this.isMiniShowAnchor;
        r100.isClickPoiMiniAnchor = this.isClickPoiMiniAnchor;
        r100.anchorId = this.anchorId;
        r100.rankIndex = this.rankIndex;
        r100.subClass = this.subClass;
        r100.districtCode = this.districtCode;
        r100.sonPoiId = this.sonPoiId;
        r100.serviceType = this.serviceType;
        r100.enterId = this.enterId;
        r100.isRecommendCard = this.isRecommendCard;
        r100.minorTags = this.minorTags;
        r100.suffix = this.suffix;
        r100.poiType = this.poiType;
        r100.isSpecialCity = this.isSpecialCity;
        r100.poiName = this.poiName;
        String r101 = this.from;
        r100.from = r101;
        r100.previousEnterFrom = this.previousEnterFrom;
        r100.previousEnterMethod = this.previousEnterMethod;
        r100.previousModule = this.previousModule;
        r100.fromExtra = r101;
        r100.contentSource = this.contentSource;
        r100.fromRecommendCard = this.fromRecommendCard;
        r100.awemeid = this.awemeid;
        r100.awemeType = this.awemeType;
        r100.awemeLikeCount = this.awemeLikeCount;
        r100.fromGroupId = this.fromGroupId;
        r100.toUserId = this.toUserId;
        r100.fromUserId = this.fromUserId;
        r100.clickMethod = this.clickMethod;
        r100.isPreviewMode = this.isPreviewMode;
        r100.pageType = this.pageType;
        r100.spuPlatformSources = this.spuPlatformSources;
        r100.enterMethod = this.enterMethod;
        r100.serviceIcon = this.serviceIcon;
        r100.imChatType = this.imChatType;
        r100.imGroupType = this.imGroupType;
        r100.imGroupOwnerType = this.imGroupOwnerType;
        r100.imPrivateType = this.imPrivateType;
        r100.imFeedType = this.imFeedType;
        r100.adParams = this.adParams;
        r100.forwardTypeV3Params = this.forwardTypeV3Params;
        if (TextUtils.isEmpty(this.authorId) == true) goto L5;
        r100.authorId = this.authorId;
    L5:
        r100.awemeid = this.awemeid;
        r100.extraSessionParams = this.extraSessionParams;
        r100.poiChannel = this.poiChannel;
        r100.searchKeyWord = this.searchKeyWord;
        r100.logPb = this.logPb;
        r100.order = this.order;
        r100.isCoupon = this.isCoupon;
        r100.inMall = this.inMall;
        r100.bannerId = this.bannerId;
        r100.fromPoiId = this.fromPoiId;
        r100.poiLabelType = this.poiLabelType;
        r100.relationTag = this.relationTag;
        r100.contentType = this.contentType;
        r100.displayStyle = this.displayStyle;
        r100.hasActivity = this.hasActivity;
        r100.challengeId = this.challengeId;
        r100.sticker = this.sticker;
        r100.poiLocationTypeOne = this.poiLocationTypeOne;
        r100.poiLocationTypeTwo = this.poiLocationTypeTwo;
        r100.backendType = this.backendType;
        r100.cityCode = this.cityCode;
        r100.previousPage = this.previousPage;
        r100.distanceKm = this.distanceKM;
        r100.queryType = this.queryType;
        r100.searchParams = this.searchParams;
        r100.fTask = this.fTask;
        r100.fToken = this.fToken;
        r100.tagShow = this.tagShow;
        r100.anchorContentJson = this.anchorContentJson;
        r100.hasMpSpu = this.hasMpSpu;
        r100.fSceneName = this.fSceneName;
        r100.previousFromPage = this.previousFromPage;
        r100.tabName = this.tabName;
        r100.commentMode = this.commentMode;
        r100.sessionId = this.sessionId;
        r100.scene = this.scene;
        r100.freshRelationTag = this.freshRelationTag;
        r100.fromRoomId = this.fromRoomId;
        r100.collectionType = this.collectionType;
        r100.imprId = this.imprId;
        r100.replyCommentId = this.replyCommentId;
        r100.lifeExtraInfo = this.extraInfo;
        r100.poiMapSessionId = this.poiMapSessionId;
        r100.poiMapCardShowId = this.poiMapCardShowId;
        r100.poiMapPageCardDistanceM = this.poiMapPageCardDistanceM;
        r100.nearbyBubbleType = this.nearbyBubbleType;
        r100.ugcSceneType = this.ugcSceneType;
        r100.topRateId = this.topRateId;
        r100.locateRateId = this.locateRateId;
        r100.optionType = this.optionType;
        r100.sortBy = this.sortBy;
        r100.filterBy = this.filterBy;
        r100.impressionId = this.impressionId;
        r100.ugcMobParams = this.ugcMobParams;
        r100.highlightTopRate = this.highlightTopRate;
        r100.f451356tab = this.f451366tab;
        r100.genre = this.genre;
        r100.detailRank = this.detailRank;
        r100.rankCode = this.rankCode;
        r100.leaderboardType = this.leaderboardType;
        r100.ipName = this.ipName;
        r100.ipTheme = this.ipTheme;
        r100.isFamiliarRecommend = this.isFamiliarRecommend;
        r100.multiPoiMobParam = this.multiPoiMobParam;
        r100.nearbyMobParams = this.nearbyMobParams;
        r100.sortId = this.sortId;
        r100.prePoiEnterId = this.prePoiEnterId;
        r100.coiReqId = this.coiReqId;
        r100.prePageEnterId = this.prePageEnterId;
        r100.lifeShareExt = this.lifeShareExt;
        r100.requestParams = this.requestParams;
        r100.tabId = this.tabId;
        r100.tabScene = this.tabScene;
        r100.scrollToComponent = this.scrollToComponent;
        r100.scrollToSubview = this.scrollToSubview;
        r100.scrollOffset = this.scrollOffset;
        r100.tabRank = this.tabRank;
        r100.retryTimesAfterTargetFound = this.retryTimesAfterTargetFound;
        r100.realAwemeId = this.realAwemeId;
        r100.forwardParams = this.forwardParams;
        r100.brandId = this.brandId;
        r100.productSubType = this.productSubType;
        r100.externalBdpLog = this.externalBdpLog;
        r100.anchorPopupViewType = this.anchorPopupViewType;
        r100.isAnchorPopupShow = this.isAnchorPopupShow;
        r100.bizCode = this.bizCode;
        r100.carryExtraParams = this.carryExtraParams;
        r100.lifeBdxTag = this.lifeBdxTag;
        r100.requestHeaderParamsMap = this.requestHeaderParams;
        return r100;
    }

    public PoiBundleBuilder() {
        this.clickMethod = AdDownloadEventConfig.JsonKey.CLICK_LABEL;
        this.displayStyle = 0;
        this.fTask = "";
        this.fToken = "";
        this.fSceneName = "";
        this.previousFromPage = "";
        this.commentMode = "";
        this.freshRelationTag = -1;
        this.tagShow = "";
        this.anchorContentJson = "";
        this.fromRoomId = "";
        this.hasMpSpu = false;
        this.nearbyBubbleType = -1;
        this.retryTimesAfterTargetFound = null;
        this.anchorPopupViewType = -1;
    }

    @AllowImpl
    public PoiBundleBuilder activityId(String r100) {
        this.activityId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder adParams(HashMap<String, String> r100) {
        this.adParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder anchorContentJson(String r100) {
        this.anchorContentJson = r100;
        return this;
    }

    public PoiBundleBuilder anchorHasMpSpu(boolean r100) {
        this.hasMpSpu = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder anchorId(String r100) {
        this.anchorId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder anchorPopupViewType(int r100) {
        this.anchorPopupViewType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder anchorRelLogExtraParams(String r100) {
        this.anchorRelLogExtraParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder authorId(String r100) {
        this.authorId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder awemeId(String r100) {
        this.awemeid = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder awemeType(int r100) {
        this.awemeType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder backendType(String r100) {
        this.backendType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder bannerId(String r100) {
        this.bannerId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder bizCode(String r100) {
        this.bizCode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder brandId(String r100) {
        this.brandId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder carryExtraParams(String r100) {
        this.carryExtraParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder challengeId(String r100) {
        this.challengeId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder cityCode(String r100) {
        this.cityCode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder clickMethod(String r100) {
        this.clickMethod = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder coiReqId(String r100) {
        this.coiReqId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder collectionType(String r100) {
        this.collectionType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder commentMode(String r100) {
        this.commentMode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder contentSource(String r100) {
        this.contentSource = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder contentType(String r100) {
        this.contentType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder couponId(String r100) {
        this.couponId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder detailRank(String r100) {
        this.detailRank = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder displayStyle(int r100) {
        this.displayStyle = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder distanceKM(String r100) {
        this.distanceKM = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder districtCode(String r100) {
        this.districtCode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder enableVideoPip(boolean r100) {
        this.enableVideoPip = Boolean.valueOf(r100);
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder enterId(String r100) {
        this.enterId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder enterMethod(String r100) {
        this.enterMethod = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder extraInfo(String r100) {
        this.extraInfo = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder extraSessionParams(HashMap<String, String> r100) {
        this.extraSessionParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fSceneName(String r100) {
        this.fSceneName = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fTask(String r100) {
        this.fTask = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fToken(String r100) {
        this.fToken = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder filterBy(int r100) {
        this.filterBy = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder forwardParams(String r100) {
        this.forwardParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder forwardTypeV3Params(HashMap<String, String> r100) {
        this.forwardTypeV3Params = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder freshRelationTag(int r100) {
        this.freshRelationTag = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromAds(int r100) {
        this.fromAds = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromGroupId(String r100) {
        this.fromGroupId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromPage(String r100) {
        this.from = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromPoiId(String r100) {
        this.fromPoiId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromRecommendCard(Boolean r100) {
        this.fromRecommendCard = r100.booleanValue();
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromRoomId(String r100) {
        this.fromRoomId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder fromUserId(String r100) {
        this.fromUserId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder genre(String r100) {
        this.genre = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder grouponDistance(double r100) {
        this.grouponDistance = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder grouponProductId(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        this.grouponProductId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder hasActivity(boolean r100) {
        this.hasActivity = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder highlightTopRate(boolean r100) {
        this.highlightTopRate = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imChatType(String r100) {
        this.imChatType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imFeedType(String r100) {
        this.imFeedType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imGroupOwnerType(String r100) {
        this.imGroupOwnerType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imGroupType(String r100) {
        this.imGroupType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imPrivateType(String r100) {
        this.imPrivateType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder imprId(String r100) {
        this.imprId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder impressionId(long r100) {
        this.impressionId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder inMall(int r100) {
        this.inMall = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder ipName(String r100) {
        this.ipName = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder ipTheme(String r100) {
        this.ipTheme = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isAnchorPopupShow(boolean r100) {
        this.isAnchorPopupShow = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isClickPoiMiniAnchor(boolean r100) {
        this.isClickPoiMiniAnchor = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isCoupon(String r100) {
        this.isCoupon = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isFamiliarRecommend(String r100) {
        this.isFamiliarRecommend = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isGrouponAnchor(boolean r100) {
        this.isGrouponAnchor = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isLifeItem(boolean r100) {
        this.isLifeItem = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isMiniShowAnchor(boolean r100) {
        this.isMiniShowAnchor = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isRecommendCard(String r100) {
        this.isRecommendCard = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder isSpecialCity(String r100) {
        this.isSpecialCity = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder leaderboardType(String r100) {
        this.leaderboardType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder lifeBdxTag(String r100) {
        this.lifeBdxTag = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder locateRateId(String r100) {
        this.locateRateId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder logPb(String r100) {
        this.logPb = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder minorTags(String r100) {
        this.minorTags = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder multiPoiMobParam(Map<String, String> r100) {
        this.multiPoiMobParam = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder nearbyMobParam(Map<String, String> r100) {
        this.nearbyMobParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder optionType(int r100) {
        this.optionType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder order(int r100) {
        this.order = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder outerGroupId(String r100) {
        this.outerGroupId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder outerGroupType(String r100) {
        this.outGroupType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder pagePoiBackendType(String r100) {
        this.pagePoiBackendType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder pagePoiId(String r100) {
        this.pagePoiId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder pageType(String r100) {
        this.pageType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder perviousPagePoiBackendType(String r100) {
        this.previousPagePoiBackendType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiBackendTypeCode(String r100) {
        this.poiBackendTypeCode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiBundle(PoiBundle r100) {
        if (r100 == null) goto L6;
        this.backendType = r100.backendType;
        if (TextUtils.isEmpty(r100.cityCode) == true) goto L6;
        this.cityCode = r100.cityCode;
    L6:
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiChannel(String r100) {
        this.poiChannel = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiDeviceSameCity(Boolean r100) {
        this.poiDeviceSameCity = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiId(String r100) {
        this.poiId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiLabelType(String r100) {
        this.poiLabelType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiLocationType(String[] r100) {
        if (r100 != null) goto L4;
    L6:
        return this;
    L4:
        if (r100.length != 2) goto L6;
        this.poiLocationTypeOne = r100[0];
        this.poiLocationTypeTwo = r100[1];
        goto L6
    }

    @AllowImpl
    public PoiBundleBuilder poiMapCardShowId(String r100) {
        this.poiMapCardShowId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiMapPageCardDistanceM(String r100) {
        this.poiMapPageCardDistanceM = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiMapSessionId(String r100) {
        this.poiMapSessionId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiName(String r100) {
        this.poiName = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiStruct(PoiStruct r100) {
        if (r100 == null) goto L6;
        this.poiName = r100.poiName;
        this.poiId = r100.poiId;
        this.backendType = r100.getBackendTypeCode();
        if (r100.getAddress() == null) goto L6;
        this.cityCode = r100.getAddress().getCityCode();
    L6:
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder poiType(String r100) {
        this.poiType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder prePageEnterId(String r100) {
        this.prePageEnterId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder prePoiEnterId(String r100) {
        this.prePoiEnterId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder preview(boolean r100) {
        this.isPreviewMode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousEnterFrom(String r100) {
        this.previousEnterFrom = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousEnterMethod(String r100) {
        this.previousEnterMethod = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousFromPage(String r100) {
        this.previousFromPage = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousModule(String r100) {
        this.previousModule = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousPage(String r100) {
        this.previousPage = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousPagePoiId(String r100) {
        this.previousPagePoiId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder previousPageType(String r100) {
        this.previousPageType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder productSubType(String r100) {
        this.productSubType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder queryType(String r100) {
        this.queryType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder rankCode(String r100) {
        this.rankCode = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder rankIndex(String r100) {
        this.rankIndex = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder realAwemeId(String r100) {
        this.realAwemeId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder relationTag(String r100) {
        this.relationTag = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder replyCommentId(long r100) {
        this.replyCommentId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder requestHeaderParams(Map<String, String> r100) {
        this.requestHeaderParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder retryTimesAfterTargetFound(Integer r100) {
        this.retryTimesAfterTargetFound = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder scene(String r100) {
        this.scene = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder scrollOffset(int r100) {
        this.scrollOffset = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder scrollToComponent(String r100) {
        this.scrollToComponent = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder scrollToSubview(String r100) {
        this.scrollToSubview = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder searchKeyWord(String r100) {
        this.searchKeyWord = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder searchParams(String r100) {
        this.searchParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder serviceIcon(int r100) {
        this.serviceIcon = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder serviceType(String r100) {
        this.serviceType = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder sessionId(String r100) {
        this.sessionId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder setEnterSource(String r100) {
        this.enterSource = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder setExternalBdpLog(String r100) {
        this.externalBdpLog = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder setLifeShareExt(String r100) {
        this.lifeShareExt = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder setModalViewUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return this;
    L5:
        this.modalViewUrl = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder setRequestParams(String r100) {
        this.requestParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder showId(String r100) {
        this.showId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder simplePoiInfoStruct(SimplePoiInfoStruct r100) {
        if (r100 == null) goto L6;
        this.backendType = r100.getPoiBackendTypeCode();
        if (TextUtils.isEmpty(r100.getCityCode()) == true) goto L6;
        this.cityCode = r100.getCityCode();
    L6:
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder sonPoiId(String r100) {
        this.sonPoiId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder sortBy(int r100) {
        this.sortBy = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder sortId(String r100) {
        this.sortId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder spuPlatformSources(int r100) {
        this.spuPlatformSources = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder sticker(String r100) {
        this.sticker = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder subClass(String r100) {
        this.subClass = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder suffix(String r100) {
        this.suffix = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tab(String r100) {
        this.f451366tab = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tabId(String r100) {
        this.tabId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tabName(String r100) {
        this.tabName = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tabRank(int r100) {
        this.tabRank = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tabScene(String r100) {
        this.tabScene = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder tagShow(String r100) {
        this.tagShow = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder toUserId(String r100) {
        this.toUserId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder topRateId(String r100) {
        this.topRateId = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder ugcMobParams(HashMap<String, String> r100) {
        this.ugcMobParams = r100;
        return this;
    }

    @AllowImpl
    public PoiBundleBuilder ugcSceneType(int r100) {
        this.ugcSceneType = r100;
        return this;
    }
}
