package com.ss.android.lark.search.dto.info;

import android.text.TextUtils;
import com.bytedance.lark.pb.search.v2.ExplanationTag;
import com.bytedance.lark.pb.search.v2.ResultSourceType;
import com.bytedance.lark.pb.search.v2.SearchEntityType;
import com.bytedance.lark.pb.search.v2.SearchResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.doc.entity.Icon;
import com.ss.android.lark.pb.urecommend.IconStyle;
import com.ss.android.lark.search.dto.DataSource;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.Source;
import com.ss.android.lark.utils.y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class SearchBaseInfo implements Serializable {
    private static final long serialVersionUID = -2947780791814807881L;
    private String avatarKey;
    private IconStyle avatarStyle;
    private String avatarUrl;
    private boolean baseOnResult;
    private String bid;
    private transient HashMap<String, Object> clickEventExtraParams;
    private DataSource.Type dataSource;
    private String entityType;
    private List<ExplanationTag> explanationTags;
    private ExtraInfoSummary extraInfoSummary;
    private Map<String, Object> extraParams;
    private String extraTitle;
    private List<String> extraTitleHitTerms;
    private ArrayList<TagContent> extraTitleTagList;
    private String filterStatus;
    private String grammarType;
    private boolean guessYouWant;
    private boolean hasMore;
    private int headerId;
    private String headerLabel;
    private Icon icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f440161id;
    private String imageUrl;
    private String imprId;
    private boolean isChatInsideShow;
    private boolean isCrossTenant;
    private boolean isCrossWithKa;
    private boolean isFirstInfoForInit;
    private boolean isPickerShow;
    private boolean isRemind;
    private boolean isSectionResult;
    private boolean isSpotlight;
    private boolean isVoiceInput;
    private boolean mIsRequired;
    private boolean mIsSelected;
    private String matchedChineseNameSegment;
    private int newMsgCount;
    private boolean onlySpotlight;
    private String ownedCardTitle;
    private SearchEntityType pbType;
    private String query;
    private String rawTitle;
    private SearchResult.RecallScene recallScene;
    private String renderDSL;
    private String renderData;
    private String requestId;
    private Scene.Type scene;
    private String searchLocation;
    private String sectionID;
    private int sectionType;
    private String session;
    private boolean showBadge;
    private transient HashMap<String, Object> showEventExtraParams;
    private boolean singleChoice;
    private Source.Type source;
    private ResultSourceType sourceType;
    private int spotlightDataInServerPos;
    private String subTitle;
    private List<String> subTitleHitTerms;
    private ArrayList<TagContent> subTitleTagList;
    private TagData tagData;
    private long timeStamp;
    private String title;
    private List<String> titleHitTerms;
    private ArrayList<TagContent> titleTagList;
    private String trackingMeta;
    protected int type;
    private int valueForFeedback;

    public String getResultTypeForReport() {
        return "none";
    }

    public String getSubResultTypeForReport() {
        return "none";
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f440161id, Integer.valueOf(this.type)});
    }

    public boolean isValid() {
        return true;
    }

    public void resetDefaultValue() {
    }

    public String getTagForReport() {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.type;
        if (r101 != 13) goto L6;
        r100.append("link,");
    L9:
        if (this.guessYouWant == false) goto L12;
        r100.append("guess,");
    L12:
        if (this.isSpotlight == false) goto L17;
        r100.append("spotlight,");
        if (this.onlySpotlight == false) goto L17;
        r100.append("onlyspotlight,");
    L17:
        if (TextUtils.isEmpty(this.ownedCardTitle) == true) goto L20;
        r100.append(this.ownedCardTitle);
    L20:
        return r100.toString();
    L6:
        if (r101 != 10) goto L9;
        r100.append("helpdesk,");
        goto L9
    }

    public SearchBaseInfo() {
        this.source = Source.Type.UNKNOWN;
        this.dataSource = DataSource.Type.UNKNOWN;
        this.isSectionResult = false;
        this.guessYouWant = false;
        this.mIsRequired = false;
        this.mIsSelected = false;
        this.singleChoice = false;
        this.headerId = Integer.MIN_VALUE;
        this.imprId = "";
        this.searchLocation = "";
        this.extraParams = null;
        this.showEventExtraParams = null;
        this.clickEventExtraParams = null;
        this.avatarStyle = IconStyle.CIRCLE;
        this.ownedCardTitle = "";
        this.baseOnResult = false;
        this.renderDSL = "";
        this.renderData = "";
        this.tagData = null;
        this.isFirstInfoForInit = false;
        this.isSpotlight = false;
        this.onlySpotlight = false;
        this.recallScene = SearchResult.RecallScene.DEFAULT;
    }

    public String getEntityIdForReport() {
        return y.b(getId());
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public IconStyle getAvatarStyle() {
        return this.avatarStyle;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getBid() {
        return this.bid;
    }

    public HashMap<String, Object> getClickEventExtraParams() {
        return this.clickEventExtraParams;
    }

    public DataSource.Type getDataSource() {
        return this.dataSource;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public List<ExplanationTag> getExplanationTags() {
        return this.explanationTags;
    }

    public ExtraInfoSummary getExtraInfoSummary() {
        return this.extraInfoSummary;
    }

    public Map<String, Object> getExtraParams() {
        return this.extraParams;
    }

    public String getExtraTitle() {
        return this.extraTitle;
    }

    public List<String> getExtraTitleHitTerms() {
        return this.extraTitleHitTerms;
    }

    public ArrayList<TagContent> getExtraTitleTagList() {
        return this.extraTitleTagList;
    }

    public String getFilterStatus() {
        return this.filterStatus;
    }

    public String getGrammarType() {
        return this.grammarType;
    }

    public int getHeaderId() {
        return this.headerId;
    }

    public String getHeaderLabel() {
        return this.headerLabel;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.f440161id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getImprId() {
        return this.imprId;
    }

    public String getMatchedChineseNameSegment() {
        return this.matchedChineseNameSegment;
    }

    public int getNewMsgCount() {
        return this.newMsgCount;
    }

    public String getOwnedCardTitle() {
        return this.ownedCardTitle;
    }

    public SearchEntityType getPbType() {
        return this.pbType;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRawTitle() {
        return this.rawTitle;
    }

    public SearchResult.RecallScene getRecallScene() {
        return this.recallScene;
    }

    public String getRenderDSL() {
        return this.renderDSL;
    }

    public String getRenderData() {
        return this.renderData;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Scene.Type getScene() {
        return this.scene;
    }

    public String getSearchLocation() {
        return this.searchLocation;
    }

    public String getSectionID() {
        return this.sectionID;
    }

    public int getSectionType() {
        return this.sectionType;
    }

    public String getSession() {
        return this.session;
    }

    public HashMap<String, Object> getShowEventExtraParams() {
        return this.showEventExtraParams;
    }

    public Source.Type getSource() {
        return this.source;
    }

    public ResultSourceType getSourceType() {
        return this.sourceType;
    }

    public int getSpotlightDataInServerPos() {
        return this.spotlightDataInServerPos;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public List<String> getSubTitleHitTerms() {
        return this.subTitleHitTerms;
    }

    public ArrayList<TagContent> getSubTitleTagList() {
        return this.subTitleTagList;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getTitleHitTerms() {
        return this.titleHitTerms;
    }

    public ArrayList<TagContent> getTitleTagList() {
        return this.titleTagList;
    }

    public String getTrackingMeta() {
        return this.trackingMeta;
    }

    public int getType() {
        return this.type;
    }

    public int getValueForFeedback() {
        return this.valueForFeedback;
    }

    public boolean isBaseOnResult() {
        return this.baseOnResult;
    }

    public boolean isChatInsideShow() {
        return this.isChatInsideShow;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isCrossWithKa() {
        return this.isCrossWithKa;
    }

    public boolean isFirstInfoForInit() {
        return this.isFirstInfoForInit;
    }

    public boolean isGuessYouWant() {
        return this.guessYouWant;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public boolean isOnlySpotlight() {
        return this.onlySpotlight;
    }

    public boolean isPickerShow() {
        return this.isPickerShow;
    }

    public boolean isRemind() {
        return this.isRemind;
    }

    public boolean isRequired() {
        return this.mIsRequired;
    }

    public boolean isSectionResult() {
        return this.isSectionResult;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public boolean isShowBadge() {
        return this.showBadge;
    }

    public boolean isSingleChoice() {
        return this.singleChoice;
    }

    public boolean isSpotlight() {
        return this.isSpotlight;
    }

    public boolean isVoiceInput() {
        return this.isVoiceInput;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        boolean r101 = false;
        if (r100 != null) goto L8;
        return false;
    L8:
        SearchBaseInfo r102 = (SearchBaseInfo) r100;
        String r103 = this.f440161id;
        if (r103 == null) goto L11;
        boolean r104 = r103.equals(r102.f440161id);
    L15:
        int r105 = this.headerId;
        if (r105 == Integer.MIN_VALUE) goto L23;
        int r106 = r102.headerId;
        if (r106 == Integer.MIN_VALUE) goto L23;
        if (r105 == r106) goto L23;
        boolean r107 = false;
    L24:
        if (r104 == false) goto L30;
        if (this.type != r102.type) goto L30;
        if (r107 == false) goto L30;
        r101 = true;
    L30:
        if (getClass() == r100.getClass()) goto L33;
        if (r101 == false) goto L33;
        return true;
    L33:
        return r101;
    L23:
        r107 = true;
        goto L24
    L11:
        if (r102.f440161id != null) goto L13;
        r104 = true;
        goto L15
    L13:
        r104 = false;
        goto L15
    }

    public void required(boolean r100) {
        this.mIsRequired = r100;
    }

    public void selected(boolean r100) {
        this.mIsSelected = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarStyle(IconStyle r100) {
        this.avatarStyle = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setBaseOnResult(boolean r100) {
        this.baseOnResult = r100;
    }

    public void setBid(String r100) {
        this.bid = r100;
    }

    public void setChatInsideShow(boolean r100) {
        this.isChatInsideShow = r100;
    }

    public void setClickEventExtraParams(HashMap<String, Object> r100) {
        this.clickEventExtraParams = r100;
    }

    public void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public void setCrossWithKa(boolean r100) {
        this.isCrossWithKa = r100;
    }

    public void setDataSource(DataSource.Type r100) {
        this.dataSource = r100;
    }

    public void setEntityType(String r100) {
        this.entityType = r100;
    }

    public void setExplanationTags(List<ExplanationTag> r100) {
        this.explanationTags = r100;
    }

    public void setExtraInfoSummary(ExtraInfoSummary r100) {
        this.extraInfoSummary = r100;
    }

    public void setExtraParams(Map<String, Object> r100) {
        this.extraParams = r100;
    }

    public void setExtraTitle(String r100) {
        this.extraTitle = r100;
    }

    public void setExtraTitleHitTerms(List<String> r100) {
        this.extraTitleHitTerms = r100;
    }

    public void setExtraTitleTagList(ArrayList<TagContent> r100) {
        this.extraTitleTagList = r100;
    }

    public void setFilterStatus(String r100) {
        this.filterStatus = r100;
    }

    public void setFirstInfoForInit(boolean r100) {
        this.isFirstInfoForInit = r100;
    }

    public void setGrammarType(String r100) {
        this.grammarType = r100;
    }

    public void setGuessYouWant(boolean r100) {
        this.guessYouWant = r100;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setHeaderId(int r100) {
        this.headerId = r100;
    }

    public void setHeaderLabel(String r100) {
        this.headerLabel = r100;
    }

    public void setIcon(Icon r100) {
        this.icon = r100;
    }

    public void setId(String r100) {
        this.f440161id = r100;
    }

    public void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public void setImprId(String r100) {
        this.imprId = r100;
    }

    public void setMatchedChineseNameSegment(String r100) {
        this.matchedChineseNameSegment = r100;
    }

    public void setNewMsgCount(int r100) {
        this.newMsgCount = r100;
    }

    public void setOnlySpotlight(boolean r100) {
        this.onlySpotlight = r100;
    }

    public void setOwnedCardTitle(String r100) {
        this.ownedCardTitle = r100;
    }

    public void setPbType(SearchEntityType r100) {
        this.pbType = r100;
    }

    public void setPickerShow(boolean r100) {
        this.isPickerShow = r100;
    }

    public void setQuery(String r100) {
        this.query = r100;
    }

    public void setRawTitle(String r100) {
        this.rawTitle = r100;
    }

    public void setRecallScene(SearchResult.RecallScene r100) {
        this.recallScene = r100;
    }

    public void setRemind(boolean r100) {
        this.isRemind = r100;
    }

    public void setRenderDSL(String r100) {
        this.renderDSL = r100;
    }

    public void setRenderData(String r100) {
        this.renderData = r100;
    }

    public void setRequestId(String r100) {
        this.requestId = r100;
    }

    public void setScene(Scene.Type r100) {
        this.scene = r100;
    }

    public void setSearchLocation(String r100) {
        this.searchLocation = r100;
    }

    public void setSectionID(String r100) {
        this.sectionID = r100;
    }

    public void setSectionResult(boolean r100) {
        this.isSectionResult = r100;
    }

    public void setSectionType(int r100) {
        this.sectionType = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setShowBadge(boolean r100) {
        this.showBadge = r100;
    }

    public void setShowEventExtraParams(HashMap<String, Object> r100) {
        this.showEventExtraParams = r100;
    }

    public void setSingleChoice(boolean r100) {
        this.singleChoice = r100;
    }

    public void setSource(Source.Type r100) {
        this.source = r100;
    }

    public void setSourceType(ResultSourceType r100) {
        this.sourceType = r100;
    }

    public void setSpotlight(boolean r100) {
        this.isSpotlight = r100;
        if (r100 == false) goto L6;
        this.onlySpotlight = true;
        return;
    }

    public void setSpotlightDataInServerPos(int r100) {
        this.spotlightDataInServerPos = r100;
    }

    public void setSubTitle(String r100) {
        this.subTitle = r100;
    }

    public void setSubTitleHitTerms(List<String> r100) {
        this.subTitleHitTerms = r100;
    }

    public void setSubTitleTagList(ArrayList<TagContent> r100) {
        this.subTitleTagList = r100;
    }

    public void setTagData(TagData r100) {
        this.tagData = r100;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setTitleHitTerms(List<String> r100) {
        this.titleHitTerms = r100;
    }

    public void setTitleTagList(ArrayList<TagContent> r100) {
        this.titleTagList = r100;
    }

    public void setTrackingMeta(String r100) {
        this.trackingMeta = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setValueForFeedback(int r100) {
        this.valueForFeedback = r100;
    }

    public void setVoiceInput(boolean r100) {
        this.isVoiceInput = r100;
    }

    public boolean compareBotId(SearchOpenAppInfo r100, SearchChatterInfo r101) {
        String r102 = r101.getBotId();
        if (r100.getAbilities() != null) goto L5;
        return false;
    L5:
        if (r100.getAbilities().size() == 1) goto L7;
        return false;
    L7:
        if (((SearchOpenAppInfo.SearchOpenAppAbility) ListProtector.get(r100.getAbilities(), 0)).getType() == 1) goto L9;
        return false;
    L9:
        if (TextUtils.equals(r102, ((SearchOpenAppInfo.SearchOpenAppAbility) ListProtector.get(r100.getAbilities(), 0)).getRequiredInfo()) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
