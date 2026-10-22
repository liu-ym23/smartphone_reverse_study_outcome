package com.ss.android.ugc.aweme.sticker;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.creative.CreativeSuppressCheck;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010!\n\u0002\b-\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cBO\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fB\u0005¢\u0006\u0002\u0010\rJ\u0006\u0010a\u001a\u00020\u0007J\u0006\u0010b\u001a\u00020\u0007R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00038F@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001e\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001d\"\u0004\b%\u0010\u001fR\u001e\u0010&\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u001d\"\u0004\b(\u0010\u001fR\u001e\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\u001e\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001fR\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001d\"\u0004\b-\u0010\u001fR\u001e\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR \u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R \u00103\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R&\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001fR \u0010?\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0010\"\u0004\bA\u0010\u0012R \u0010B\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R \u0010E\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0010\"\u0004\bG\u0010\u0012R \u0010H\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0010\"\u0004\bJ\u0010\u0012R \u0010K\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0010\"\u0004\bM\u0010\u0012R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R \u0010P\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\"\u0010\u0002\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010X\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R \u0010[\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R \u0010^\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012¨\u0006d"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/StickerInfo;", "Ljava/io/Serializable;", "source", "", "key", "recId", "isMobileEffect", "", "isStackableEffect", "effectSource", "", "isEffectPassedModeration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;Z)V", "()V", "effectIntensity", "getEffectIntensity", "()Ljava/lang/String;", "setEffectIntensity", "(Ljava/lang/String;)V", "gradeKey", "getGradeKey", "setGradeKey", "hasDefaultProp", "getHasDefaultProp", "setHasDefaultProp", ShortVideoSegments.KEY_CURRENT_STICKER_IMPR_POSITION, "getImprPosition", "setImprPosition", "isAudioGraphOutput", "()Z", "setAudioGraphOutput", "(Z)V", "isAutoUseProp", "()Ljava/lang/Boolean;", "setAutoUseProp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setEffectPassedModeration", "isGameTypeSticker", "setGameTypeSticker", "setMobileEffect", "isMusicBeatSticker", "setMusicBeatSticker", "isOriginalSticker", "setOriginalSticker", "setStackableEffect", "isTextTypeSticker", "setTextTypeSticker", "mParentStickerId", "getMParentStickerId", "setMParentStickerId", "mentionUserInfo", "getMentionUserInfo", "setMentionUserInfo", "mentionUserInfoList", "", "getMentionUserInfoList", "()Ljava/util/List;", "setMentionUserInfoList", "(Ljava/util/List;)V", "needFilter", "getNeedFilter", "setNeedFilter", "propProvider", "getPropProvider", "setPropProvider", "propSearchParams", "getPropSearchParams", "setPropSearchParams", "propSource", "getPropSource", "setPropSource", "propTabId", "getPropTabId", "setPropTabId", "propZipSize", "getPropZipSize", "setPropZipSize", "getRecId", "setRecId", "selectedEffectIds", "getSelectedEffectIds", "setSelectedEffectIds", "getSource", "()Ljava/lang/Integer;", "setSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", ShortVideoSegments.KEY_CURRENT_STICKER_TAB_ORDER, "getTabOrder", "setTabOrder", "tabType", "getTabType", "setTabType", "welfareActivityId", "getWelfareActivityId", "setWelfareActivityId", "hasImprPosition", "hasTabOrder", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
@CreativeSuppressCheck
public final class StickerInfo implements Serializable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(ShortVideoSegments.KEY_EFFECT_INTENSITY)
    private String effectIntensity;

    @SerializedName("grade_key")
    private String gradeKey;

    @SerializedName("is_default_prop")
    private String hasDefaultProp;

    @SerializedName("prop_impr_position")
    private String imprPosition;

    @SerializedName("is_audio_graph_output")
    private boolean isAudioGraphOutput;

    @SerializedName(ShortVideoSegments.KEY_IS_AUTO_USE_PROP)
    private Boolean isAutoUseProp;

    @SerializedName("is_effect_passed_moderation")
    private boolean isEffectPassedModeration;

    @SerializedName("is_game_type_sticker")
    private boolean isGameTypeSticker;

    @SerializedName("is_mobile_effect")
    private boolean isMobileEffect;

    @SerializedName("is_music_beat")
    private boolean isMusicBeatSticker;

    @SerializedName("is_original_sticker")
    private boolean isOriginalSticker;

    @SerializedName("is_stackable_effect")
    private boolean isStackableEffect;

    @SerializedName("is_text_type_sticker")
    private boolean isTextTypeSticker;

    @SerializedName("prop_parent_id")
    private String mParentStickerId;

    @SerializedName("mention_user")
    private String mentionUserInfo;

    @SerializedName("mention_user_list")
    private List<String> mentionUserInfoList;
    private boolean needFilter;

    @SerializedName("prop_provider")
    private String propProvider;

    @SerializedName(ShortVideoSegments.KEY_PROP_SEARCH_PARAMS)
    private String propSearchParams;

    @SerializedName("prop_source")
    private String propSource;

    @SerializedName(ShortVideoSegments.PROP_TAB_ID)
    private String propTabId;

    @SerializedName("prop_zip_size")
    private String propZipSize;

    @SerializedName("rec_id")
    private String recId;

    @SerializedName("stackable_item_list")
    private String selectedEffectIds;

    @SerializedName("source")
    private Integer source;

    @SerializedName("prop_tab_order")
    private String tabOrder;

    @SerializedName("tab_type")
    private String tabType;

    @SerializedName("welfare_activity_id")
    private String welfareActivityId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/StickerInfo$Companion;", "", "()V", "serialVersionUID", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final String getGradeKey() {
        String r100 = this.gradeKey;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return "";
    L12:
        return this.gradeKey;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean hasImprPosition() {
        String r100 = this.imprPosition;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public final boolean hasTabOrder() {
        String r100 = this.tabOrder;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public StickerInfo() {
        this.needFilter = true;
        this.recId = "0";
        this.effectIntensity = "";
        this.hasDefaultProp = "";
        this.isAutoUseProp = Boolean.FALSE;
        this.tabType = "";
        this.isEffectPassedModeration = true;
    }

    public final String getEffectIntensity() {
        return this.effectIntensity;
    }

    public final String getHasDefaultProp() {
        return this.hasDefaultProp;
    }

    public final String getImprPosition() {
        return this.imprPosition;
    }

    public final String getMParentStickerId() {
        return this.mParentStickerId;
    }

    public final String getMentionUserInfo() {
        return this.mentionUserInfo;
    }

    public final List<String> getMentionUserInfoList() {
        return this.mentionUserInfoList;
    }

    public final boolean getNeedFilter() {
        return this.needFilter;
    }

    public final String getPropProvider() {
        return this.propProvider;
    }

    public final String getPropSearchParams() {
        return this.propSearchParams;
    }

    public final String getPropSource() {
        return this.propSource;
    }

    public final String getPropTabId() {
        return this.propTabId;
    }

    public final String getPropZipSize() {
        return this.propZipSize;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final String getSelectedEffectIds() {
        return this.selectedEffectIds;
    }

    public final Integer getSource() {
        return this.source;
    }

    public final String getTabOrder() {
        return this.tabOrder;
    }

    public final String getTabType() {
        return this.tabType;
    }

    public final String getWelfareActivityId() {
        return this.welfareActivityId;
    }

    public final boolean isAudioGraphOutput() {
        return this.isAudioGraphOutput;
    }

    public final Boolean isAutoUseProp() {
        return this.isAutoUseProp;
    }

    public final boolean isEffectPassedModeration() {
        return this.isEffectPassedModeration;
    }

    public final boolean isGameTypeSticker() {
        return this.isGameTypeSticker;
    }

    public final boolean isMobileEffect() {
        return this.isMobileEffect;
    }

    public final boolean isMusicBeatSticker() {
        return this.isMusicBeatSticker;
    }

    public final boolean isOriginalSticker() {
        return this.isOriginalSticker;
    }

    public final boolean isStackableEffect() {
        return this.isStackableEffect;
    }

    public final boolean isTextTypeSticker() {
        return this.isTextTypeSticker;
    }

    public final void setAudioGraphOutput(boolean r100) {
        this.isAudioGraphOutput = r100;
    }

    public final void setAutoUseProp(Boolean r100) {
        this.isAutoUseProp = r100;
    }

    public final void setEffectIntensity(String r100) {
        this.effectIntensity = r100;
    }

    public final void setEffectPassedModeration(boolean r100) {
        this.isEffectPassedModeration = r100;
    }

    public final void setGameTypeSticker(boolean r100) {
        this.isGameTypeSticker = r100;
    }

    public final void setGradeKey(String r100) {
        this.gradeKey = r100;
    }

    public final void setHasDefaultProp(String r100) {
        this.hasDefaultProp = r100;
    }

    public final void setImprPosition(String r100) {
        this.imprPosition = r100;
    }

    public final void setMParentStickerId(String r100) {
        this.mParentStickerId = r100;
    }

    public final void setMentionUserInfo(String r100) {
        this.mentionUserInfo = r100;
    }

    public final void setMentionUserInfoList(List<String> r100) {
        this.mentionUserInfoList = r100;
    }

    public final void setMobileEffect(boolean r100) {
        this.isMobileEffect = r100;
    }

    public final void setMusicBeatSticker(boolean r100) {
        this.isMusicBeatSticker = r100;
    }

    public final void setNeedFilter(boolean r100) {
        this.needFilter = r100;
    }

    public final void setOriginalSticker(boolean r100) {
        this.isOriginalSticker = r100;
    }

    public final void setPropProvider(String r100) {
        this.propProvider = r100;
    }

    public final void setPropSearchParams(String r100) {
        this.propSearchParams = r100;
    }

    public final void setPropSource(String r100) {
        this.propSource = r100;
    }

    public final void setPropTabId(String r100) {
        this.propTabId = r100;
    }

    public final void setPropZipSize(String r100) {
        this.propZipSize = r100;
    }

    public final void setRecId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recId = r100;
    }

    public final void setSelectedEffectIds(String r100) {
        this.selectedEffectIds = r100;
    }

    public final void setSource(Integer r100) {
        this.source = r100;
    }

    public final void setStackableEffect(boolean r100) {
        this.isStackableEffect = r100;
    }

    public final void setTabOrder(String r100) {
        this.tabOrder = r100;
    }

    public final void setTabType(String r100) {
        this.tabType = r100;
    }

    public final void setTextTypeSticker(boolean r100) {
        this.isTextTypeSticker = r100;
    }

    public final void setWelfareActivityId(String r100) {
        this.welfareActivityId = r100;
    }

    public StickerInfo(String r100, String r101, String r102, boolean r103, boolean r104, Integer r105, boolean r106) {
        this();
        this.propSource = r100;
        this.gradeKey = r101;
        if (r102 != null) goto L6;
        r102 = "0";
    L6:
        this.recId = r102;
        this.isMobileEffect = r103;
        this.isEffectPassedModeration = r106;
        this.isStackableEffect = r104;
        this.source = r105;
    }

    public /* synthetic */ StickerInfo(String r110, String r111, String r112, boolean r113, boolean r114, Integer r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r117 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r117 & 32) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r117 & 64) == 0) goto L17;
        boolean r103 = true;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
