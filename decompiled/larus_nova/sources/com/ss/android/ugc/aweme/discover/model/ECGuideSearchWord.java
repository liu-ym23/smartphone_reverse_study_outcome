package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001dB\u0011\u0012\b\b\u0002\u0010a\u001a\u000205¢\u0006\u0004\bb\u0010cJ\b\u0010\u0004\u001a\u00020\u0003H\u0017J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R,\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\b\u001a\u0004\b3\u0010\n\"\u0004\b4\u0010\fR*\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b6\u00107\u0012\u0004\b<\u0010=\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R0\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010\u000f\u001a\u0004\b?\u0010\u0011\"\u0004\b@\u0010\u0013R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\"\u0010R\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010J\u001a\u0004\bR\u0010L\"\u0004\bS\u0010NR\"\u0010T\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010J\u001a\u0004\bT\u0010L\"\u0004\bU\u0010NR\"\u0010V\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010J\u001a\u0004\bW\u0010L\"\u0004\bX\u0010NR$\u0010Y\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\b\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\"\u0010\\\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010J\u001a\u0004\b\\\u0010L\"\u0004\b]\u0010NR\"\u0010^\u001a\u00020H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010J\u001a\u0004\b_\u0010L\"\u0004\b`\u0010N¨\u0006e"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ECGuideSearchWord;", "Lcom/ss/android/ugc/aweme/discover/model/GsTypeData;", "", "", "toString", "", "getPreloadImages", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "transparentParam", "Ljava/util/Map;", "getTransparentParam", "()Ljava/util/Map;", "setTransparentParam", "(Ljava/util/Map;)V", "queryId", "getQueryId", "setQueryId", "type", "getType", "setType", EffectConfiguration.KEY_SEARCH_WORD, "getWord", "setWord", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "wordImage", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "getWordImage", "()Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "setWordImage", "(Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;)V", "Lcom/ss/android/ugc/aweme/discover/model/ECGsIconStruct;", "icon", "Lcom/ss/android/ugc/aweme/discover/model/ECGsIconStruct;", "getIcon", "()Lcom/ss/android/ugc/aweme/discover/model/ECGsIconStruct;", "setIcon", "(Lcom/ss/android/ugc/aweme/discover/model/ECGsIconStruct;)V", "Lcom/ss/android/ugc/aweme/discover/model/GSAttachedText;", "attachedTextList", "Ljava/util/List;", "getAttachedTextList", "()Ljava/util/List;", "setAttachedTextList", "(Ljava/util/List;)V", "searchKeyword", "getSearchKeyword", "setSearchKeyword", "", "searchMode", "Ljava/lang/Integer;", "getSearchMode", "()Ljava/lang/Integer;", "setSearchMode", "(Ljava/lang/Integer;)V", "getSearchMode$annotations", "()V", "logInfo", "getLogInfo", "setLogInfo", "Lcom/ss/android/ugc/aweme/discover/model/GsLabel;", "label", "Lcom/ss/android/ugc/aweme/discover/model/GsLabel;", "getLabel", "()Lcom/ss/android/ugc/aweme/discover/model/GsLabel;", "setLabel", "(Lcom/ss/android/ugc/aweme/discover/model/GsLabel;)V", "", "selectable", "Z", "getSelectable", "()Z", "setSelectable", "(Z)V", "selected", "getSelected", "setSelected", "isExpandMinHeightForAttachedText", "setExpandMinHeightForAttachedText", "isExpandMinHeightForLabel", "setExpandMinHeightForLabel", "hasLabel", "getHasLabel", "setHasLabel", "viewWord", "getViewWord", "setViewWord", "isHeader", "setHeader", "shouldMob", "getShouldMob", "setShouldMob", "viewType", "<init>", "(I)V", "SearchMode", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGuideSearchWord extends GsTypeData {

    @SerializedName("attached_text")
    private List<GSAttachedText> attachedTextList;
    private boolean hasLabel;

    @SerializedName("icon")
    private ECGsIconStruct icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f450484id;
    private boolean isExpandMinHeightForAttachedText;
    private boolean isExpandMinHeightForLabel;
    private boolean isHeader;

    @SerializedName("gs_label")
    private GsLabel label;

    @SerializedName("log_info")
    private Map<String, ? extends Object> logInfo;

    @SerializedName("query_id")
    private String queryId;

    @SerializedName("search_keyword")
    private String searchKeyword;

    @SerializedName("search_mode")
    private Integer searchMode;
    private boolean selectable;
    private boolean selected;
    private boolean shouldMob;

    @SerializedName("transparent_param")
    private Map<String, ? extends Object> transparentParam;

    @SerializedName("type")
    private String type;
    private String viewWord;

    @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
    private String word;

    @SerializedName("words_image")
    private UrlModel wordImage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ECGuideSearchWord$SearchMode;", "", "Companion", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SearchMode {
        public static final Companion Companion = null;
        public static final int REPLACE_SEARCH_WORD = 1;
        public static final int SPLICING_SEARCH_WORD = 0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/ECGuideSearchWord$SearchMode$Companion;", "", "<init>", "()V", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f450485a = null;

            private Companion() {
            }

            static {
                f450485a = new Companion();
            }
        }

        static {
            Companion = Companion.f450485a;
        }
    }

    public ECGuideSearchWord() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @SearchMode
    public static /* synthetic */ void getSearchMode$annotations() {
    }

    @AllowImpl
    public List<String> getPreloadImages() {
        ArrayList r100 = new ArrayList();
        UrlModel r101 = this.wordImage;
        if (r101 == null) goto L11;
        if (r101 == null) goto L9;
        List<String> r102 = r101.getUrlList();
        if (r102 == null) goto L9;
        String r103 = (String) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L9;
    L10:
        r100.add(r103);
    L9:
        r103 = "";
    L11:
        return r100;
    }

    @AllowImpl
    public String toString() {
        String r100 = this.word;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        return "";
    }

    public final List<GSAttachedText> getAttachedTextList() {
        return this.attachedTextList;
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    public final ECGsIconStruct getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f450484id;
    }

    public final GsLabel getLabel() {
        return this.label;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final String getSearchKeyword() {
        return this.searchKeyword;
    }

    public final Integer getSearchMode() {
        return this.searchMode;
    }

    public final boolean getSelectable() {
        return this.selectable;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final boolean getShouldMob() {
        return this.shouldMob;
    }

    public final Map<String, Object> getTransparentParam() {
        return this.transparentParam;
    }

    public final String getType() {
        return this.type;
    }

    public final String getViewWord() {
        return this.viewWord;
    }

    public final String getWord() {
        return this.word;
    }

    public final UrlModel getWordImage() {
        return this.wordImage;
    }

    public final boolean isExpandMinHeightForAttachedText() {
        return this.isExpandMinHeightForAttachedText;
    }

    public final boolean isExpandMinHeightForLabel() {
        return this.isExpandMinHeightForLabel;
    }

    public final boolean isHeader() {
        return this.isHeader;
    }

    public ECGuideSearchWord(int r100) {
        super(r100);
        this.selectable = true;
        this.shouldMob = true;
    }

    public final void setAttachedTextList(List<GSAttachedText> r100) {
        this.attachedTextList = r100;
    }

    public final void setExpandMinHeightForAttachedText(boolean r100) {
        this.isExpandMinHeightForAttachedText = r100;
    }

    public final void setExpandMinHeightForLabel(boolean r100) {
        this.isExpandMinHeightForLabel = r100;
    }

    public final void setHasLabel(boolean r100) {
        this.hasLabel = r100;
    }

    public final void setHeader(boolean r100) {
        this.isHeader = r100;
    }

    public final void setIcon(ECGsIconStruct r100) {
        this.icon = r100;
    }

    public final void setId(String r100) {
        this.f450484id = r100;
    }

    public final void setLabel(GsLabel r100) {
        this.label = r100;
    }

    public final void setLogInfo(Map<String, ? extends Object> r100) {
        this.logInfo = r100;
    }

    public final void setQueryId(String r100) {
        this.queryId = r100;
    }

    public final void setSearchKeyword(String r100) {
        this.searchKeyword = r100;
    }

    public final void setSearchMode(Integer r100) {
        this.searchMode = r100;
    }

    public final void setSelectable(boolean r100) {
        this.selectable = r100;
    }

    public final void setSelected(boolean r100) {
        this.selected = r100;
    }

    public final void setShouldMob(boolean r100) {
        this.shouldMob = r100;
    }

    public final void setTransparentParam(Map<String, ? extends Object> r100) {
        this.transparentParam = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public final void setViewWord(String r100) {
        this.viewWord = r100;
    }

    public final void setWord(String r100) {
        this.word = r100;
    }

    public final void setWordImage(UrlModel r100) {
        this.wordImage = r100;
    }

    public /* synthetic */ ECGuideSearchWord(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 1;
    L5:
        this(r100);
    }
}
