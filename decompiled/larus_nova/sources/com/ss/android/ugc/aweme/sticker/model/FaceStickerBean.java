package com.ss.android.ugc.aweme.sticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.tools.utils.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class FaceStickerBean implements Parcelable {
    public static final Parcelable.Creator<FaceStickerBean> CREATOR = null;
    public static final String MAIN_PANEL = "main_panel";
    public static final FaceStickerBean NONE = null;
    public static final String SLIDE_BAR = "slide_bar";
    public static final int SOURCE_AME_MOBILE_EFFECT = 102;
    public static final int SOURCE_DESIGNER = 1;
    public static final int SOURCE_DIY_CUSTOM = 10001;
    public static final int SOURCE_INNER = 0;
    public static final int SOURCE_LIGHT_BEAUTY = 6;
    public static final int SOURCE_MOBILE_EFFECT = 101;
    public static final String TAB_TYPE = "tab_type";
    public static final int TYPE_COLLECT = 1;
    public static final int TYPE_MODEO = -1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SCHEMA = 2;
    public static String sCurPropSource;
    public static String sCurPropSourceKey;
    public static String sSlideCurrentEffectId;

    @SerializedName("ad_raw_data")
    private String adRawData;

    @SerializedName("children")
    List<String> children;
    private String customizedBuzExtra;
    private String customizedPropIconPath;
    private String customizedPropId;
    private String customizedPropPath;

    @SerializedName("designer_id")
    private String designerId;
    private String diyType;

    @SerializedName("effect_publish_time")
    private Long effectPublishTime;

    @SerializedName("effect_type")
    int effectType;

    @SerializedName("extra")
    private String extra;
    FaceStickerCommerceBean faceStickerCommerceBean;

    @SerializedName(ShareType.FILE_URL)
    UrlModel fileUrl;

    @SerializedName("force_bind_music_path")
    private String forceBindMusicPath;

    @SerializedName("grade_key")
    private String gradeKey;

    @SerializedName("hint")
    String hint;

    @SerializedName("hint_icon")
    UrlModel hintIcon;

    @SerializedName("icon_url")
    UrlModel iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    String f454277id;

    @SerializedName("is_busi")
    private boolean isBusi;
    private boolean isEffectPassedModeration;

    @SerializedName("is_force_bind_music")
    private boolean isForceBind;
    private boolean isMobileEffect;
    public boolean isSelected;
    private boolean isStackableEffect;
    public String mLocalPath;

    @SerializedName("mention_user")
    private String mentionUserInfo;
    List<String> musicIds;

    @SerializedName("name")
    String name;

    @SerializedName("parent")
    String parentId;

    @SerializedName("prop_provider")
    private String propProvider;
    String propSource;

    @SerializedName("prop_zip_size")
    private String propZipSize;

    @SerializedName("rec_id")
    String recId;

    @SerializedName("requirements")
    private List<String> requirements;

    @SerializedName("resource_id")
    private String resourceID;

    @SerializedName("schema")
    private String schema;

    @SerializedName("sdk_extra")
    private String sdkExtra;

    @SerializedName("source")
    private int source;

    @SerializedName("sticker_id")
    long stickerId;
    private String tabType;
    List<String> tags;
    private String templatePropId;

    @SerializedName("type")
    long type;
    List<String> types;

    @SerializedName("usage_scenario")
    int usageScenario;

    @SerializedName("use_audio_graph_sticker")
    private boolean useVoiceRecognizeSticker;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        NONE = new FaceStickerBean();
        CREATOR = new AnonymousClass1();
    }

    public String getPropSource() {
        String r100 = this.propSource;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public List<String> getTags() {
        if (b.a(this.tags) == false) goto L6;
        return new ArrayList();
    L6:
        return this.tags;
    }

    public List<String> getTypes() {
        if (b.a(this.types) == false) goto L6;
        return new ArrayList();
    L6:
        return this.types;
    }

    public int hashCode() {
        long r100 = this.stickerId;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public boolean suportLive() {
        int r100 = this.usageScenario;
        if (r100 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public boolean supportVideo() {
        int r100 = this.usageScenario;
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public FaceStickerBean() {
        this.requirements = new ArrayList();
        this.tabType = MAIN_PANEL;
        this.isMobileEffect = false;
        this.isEffectPassedModeration = true;
        this.isStackableEffect = false;
        this.isSelected = false;
    }

    public String getAdRawData() {
        return this.adRawData;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public String getCustomizedBuzExtra() {
        return this.customizedBuzExtra;
    }

    public String getCustomizedPropIconPath() {
        return this.customizedPropIconPath;
    }

    public String getCustomizedPropId() {
        return this.customizedPropId;
    }

    public String getCustomizedPropPath() {
        return this.customizedPropPath;
    }

    public String getDesignerId() {
        return this.designerId;
    }

    public String getDiyType() {
        return this.diyType;
    }

    public Long getEffectPublishTime() {
        return this.effectPublishTime;
    }

    public int getEffectType() {
        return this.effectType;
    }

    public String getExtra() {
        return this.extra;
    }

    public FaceStickerCommerceBean getFaceStickerCommerceBean() {
        return this.faceStickerCommerceBean;
    }

    public UrlModel getFileUrl() {
        return this.fileUrl;
    }

    public String getForceBindMusicPath() {
        return this.forceBindMusicPath;
    }

    public String getGradeKey() {
        return this.gradeKey;
    }

    public String getHint() {
        return this.hint;
    }

    public UrlModel getHintIcon() {
        return this.hintIcon;
    }

    public UrlModel getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.f454277id;
    }

    public String getLocalPath() {
        return this.mLocalPath;
    }

    public String getMentionUserInfo() {
        return this.mentionUserInfo;
    }

    public List<String> getMusicIds() {
        return this.musicIds;
    }

    public String getName() {
        return this.name;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getPropProvider() {
        return this.propProvider;
    }

    public String getPropZipSize() {
        return this.propZipSize;
    }

    public String getRecId() {
        return this.recId;
    }

    public List<String> getRequirements() {
        return this.requirements;
    }

    public String getResourceID() {
        return this.resourceID;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSdkExtra() {
        return this.sdkExtra;
    }

    public int getSource() {
        return this.source;
    }

    public long getStickerId() {
        return this.stickerId;
    }

    public String getTabType() {
        return this.tabType;
    }

    public String getTemplatePropId() {
        return this.templatePropId;
    }

    public long getType() {
        return this.type;
    }

    public boolean isBusi() {
        return this.isBusi;
    }

    public boolean isEffectPassedModeration() {
        return this.isEffectPassedModeration;
    }

    public boolean isForceBind() {
        return this.isForceBind;
    }

    public boolean isMobileEffect() {
        return this.isMobileEffect;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isStackableEffect() {
        return this.isStackableEffect;
    }

    public boolean isUseVoiceRecognizeSticker() {
        return this.useVoiceRecognizeSticker;
    }

    public FaceStickerBean(Parcel r100) {
        this.requirements = new ArrayList();
        this.tabType = MAIN_PANEL;
        boolean r101 = false;
        this.isMobileEffect = false;
        this.isEffectPassedModeration = true;
        this.isStackableEffect = false;
        this.isSelected = false;
        this.f454277id = r100.readString();
        this.stickerId = r100.readLong();
        this.name = r100.readString();
        this.iconUrl = (UrlModel) r100.readSerializable();
        this.fileUrl = (UrlModel) r100.readSerializable();
        this.hint = r100.readString();
        this.hintIcon = (UrlModel) r100.readSerializable();
        this.type = r100.readLong();
        this.usageScenario = r100.readInt();
        this.types = r100.createStringArrayList();
        this.mLocalPath = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isSelected = r102;
        this.tags = r100.createStringArrayList();
        this.effectType = r100.readInt();
        this.schema = r100.readString();
        this.source = r100.readInt();
        this.designerId = r100.readString();
        this.extra = r100.readString();
        this.sdkExtra = r100.readString();
        this.musicIds = r100.createStringArrayList();
        this.adRawData = r100.readString();
        this.forceBindMusicPath = r100.readString();
        if (r100.readByte() == 0) goto L9;
        r101 = true;
    L9:
        this.isForceBind = r101;
        this.gradeKey = r100.readString();
        this.recId = r100.readString();
        this.requirements = r100.createStringArrayList();
        this.mentionUserInfo = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FaceStickerBean) == true) goto L9;
        return false;
    L9:
        if (this.stickerId == ((FaceStickerBean) r100).stickerId) goto L13;
        return false;
    L13:
        return true;
    }

    public void setAdRawData(String r100) {
        this.adRawData = r100;
    }

    public void setBusi(boolean r100) {
        this.isBusi = r100;
    }

    public void setChildren(List<String> r100) {
        this.children = r100;
    }

    public void setCustomizedBuzExtra(String r100) {
        this.customizedBuzExtra = r100;
    }

    public void setCustomizedPropIconPath(String r100) {
        this.customizedPropIconPath = r100;
    }

    public void setCustomizedPropId(String r100) {
        this.customizedPropId = r100;
    }

    public void setCustomizedPropPath(String r100) {
        this.customizedPropPath = r100;
    }

    public void setDesignerId(String r100) {
        this.designerId = r100;
    }

    public void setDiyType(String r100) {
        this.diyType = r100;
    }

    public void setEffectPassedModeration(boolean r100) {
        this.isEffectPassedModeration = r100;
    }

    public void setEffectPublishTime(Long r100) {
        this.effectPublishTime = r100;
    }

    public void setEffectType(int r100) {
        this.effectType = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setFaceStickerCommerceBean(FaceStickerCommerceBean r100) {
        this.faceStickerCommerceBean = r100;
    }

    public void setFileUrl(UrlModel r100) {
        this.fileUrl = r100;
    }

    public void setForceBind(boolean r100) {
        this.isForceBind = r100;
    }

    public void setForceBindMusicPath(String r100) {
        this.forceBindMusicPath = r100;
    }

    public void setGradeKey(String r100) {
        this.gradeKey = r100;
    }

    public void setHint(String r100) {
        this.hint = r100;
    }

    public void setHintIcon(UrlModel r100) {
        this.hintIcon = r100;
    }

    public void setIconUrl(UrlModel r100) {
        this.iconUrl = r100;
    }

    public void setId(String r100) {
        this.f454277id = r100;
    }

    public void setLocalPath(String r100) {
        this.mLocalPath = r100;
    }

    public void setMentionUserInfo(String r100) {
        this.mentionUserInfo = r100;
    }

    public void setMobileEffect(boolean r100) {
        this.isMobileEffect = r100;
    }

    public void setMusicIds(List<String> r100) {
        this.musicIds = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setParentId(String r100) {
        this.parentId = r100;
    }

    public void setPropProvider(String r100) {
        this.propProvider = r100;
    }

    public void setPropSource(String r100) {
        this.propSource = r100;
    }

    public void setPropZipSize(String r100) {
        this.propZipSize = r100;
    }

    public void setRecId(String r100) {
        this.recId = r100;
    }

    public void setRequirements(List<String> r100) {
        this.requirements = r100;
    }

    public void setResourceID(String r100) {
        this.resourceID = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSdkExtra(String r100) {
        this.sdkExtra = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setStackableEffect(boolean r100) {
        this.isStackableEffect = r100;
    }

    public void setStickerId(long r100) {
        this.stickerId = r100;
        if (this.templatePropId != null) goto L5;
        return;
    L5:
        if (String.valueOf(r100).equals(this.templatePropId) == true) goto L9;
        this.stickerId = CastLongProtector.parseLong(this.templatePropId);
        return;
    }

    public void setTabType(String r100) {
        this.tabType = r100;
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTemplatePropId(String r100) {
        this.templatePropId = r100;
        if (String.valueOf(this.stickerId).equals(r100) == true) goto L6;
        this.stickerId = CastLongProtector.parseLong(r100);
        return;
    }

    public void setType(long r100) {
        this.type = r100;
    }

    public void setTypes(List<String> r100) {
        this.types = r100;
    }

    public void setUseVoiceRecognizeSticker(boolean r100) {
        this.useVoiceRecognizeSticker = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f454277id);
        r100.writeLong(this.stickerId);
        r100.writeString(this.name);
        r100.writeSerializable(this.iconUrl);
        r100.writeSerializable(this.fileUrl);
        r100.writeString(this.hint);
        r100.writeSerializable(this.hintIcon);
        r100.writeLong(this.type);
        r100.writeInt(this.usageScenario);
        r100.writeStringList(this.types);
        r100.writeString(this.mLocalPath);
        r100.writeByte(this.isSelected ? 1 : 0);
        r100.writeStringList(this.tags);
        r100.writeInt(this.effectType);
        r100.writeString(this.schema);
        r100.writeInt(this.source);
        r100.writeString(this.designerId);
        r100.writeString(this.extra);
        r100.writeString(this.sdkExtra);
        r100.writeStringList(this.musicIds);
        r100.writeString(this.adRawData);
        r100.writeString(this.forceBindMusicPath);
        r100.writeByte(this.isForceBind ? 1 : 0);
        r100.writeString(this.gradeKey);
        r100.writeString(this.recId);
        r100.writeStringList(this.requirements);
        r100.writeString(this.mentionUserInfo);
    }
}
