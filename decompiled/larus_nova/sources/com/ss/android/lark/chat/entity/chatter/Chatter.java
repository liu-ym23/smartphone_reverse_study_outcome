package com.ss.android.lark.chat.entity.chatter;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.export.entity.chatter.IChatterDesc;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public class Chatter implements uxb.a, OpenChatter, Serializable, Comparable, y28.b<Chatter> {
    public static final String BOT_TAG = "bot";
    private static final int FLAG_DEMISSION = 2;
    private static final long serialVersionUID = 7837580756091984831L;
    private boolean acceptSmsPhoneUrgent;
    private AccessInfo accessInfo;
    private String alias;
    private String anotherName;
    private String another_name;
    private String avatarKey;
    private AvatarMedal avatarMedal;
    private List<String> avatarUrls;
    private int botExtraType;
    private boolean canJoinGroup;
    private ChatterSensitiveInfo chatterSensitiveInfo;
    private ArrayList<String> commonLocales;
    private String creatorId;
    private List<ChatterCustomStatus> customStatus;
    private ChatterDescription description;
    private String enName;
    private String fullDepartmentName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f415177id;
    private boolean inContacts;
    private boolean isAgent;
    private boolean isAnonymous;
    private boolean isCollaboration;
    private boolean isCrossTenant;
    private boolean isDefaultAvatar;
    private boolean isFrozen;
    private boolean isRegistered;
    private boolean isSpecialFocus;
    private String localizedName;
    private String majorLanguage;
    private BotMutedInfo mutedInfo;
    private String name;
    private String namePinyin;
    private String namePy;
    private String nameWithAnotherName;
    private String openAppId;
    private UserPrivateDescription privateDescription;
    private boolean profileEnable;
    private int status;
    private TagData tagData;
    private String tenantId;
    private List<String> thumbnails;
    private TimeZone timeZone;
    private ChatterType type;
    private long updateTime;
    private long weight;
    private String withBotTag;
    private WorkStatus workStatus;
    private long zenModeEndTime;

    public static final enum ChatterType extends Enum<ChatterType> {
        public static final ChatterType AI = null;
        public static final ChatterType BOT = null;
        public static final ChatterType DOUBAO = null;
        public static final ChatterType KNOWLEDGE_AI = null;
        public static final ChatterType UNKNOWN = null;
        public static final ChatterType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatterType[] f415178a = null;
        private final int value;

        static {
            ChatterType r100 = new ChatterType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            ChatterType r102 = new ChatterType("BOT", 2, 2);
            BOT = r102;
            ChatterType r103 = new ChatterType("AI", 3, 3);
            AI = r103;
            ChatterType r104 = new ChatterType("DOUBAO", 4, 4);
            DOUBAO = r104;
            ChatterType r105 = new ChatterType("KNOWLEDGE_AI", 5, 1004);
            KNOWLEDGE_AI = r105;
            f415178a = new ChatterType[]{r100, r101, r102, r103, r104, r105};
        }

        public static ChatterType[] values() {
            return (ChatterType[]) f415178a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static ChatterType forNumber(int r100) {
            if (r100 == 1) goto L23;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L19;
            if (r100 == 4) goto L17;
            if (r100 == 1004) goto L15;
            return UNKNOWN;
        L15:
            return KNOWLEDGE_AI;
        L17:
            return DOUBAO;
        L19:
            return AI;
        L21:
            return BOT;
        L23:
            return USER;
        }

        public static ChatterType valueOf(String r100) {
            return (ChatterType) r27.a.a(ChatterType.class, r100);
        }

        public static ChatterType valueOf(int r100) {
            return forNumber(r100);
        }

        public ChatterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public o5b.a getAccess() {
        AccessInfo r100 = this.accessInfo;
        if (r100 != null) goto L7;
        o5b.a.f522151k2.getClass();
        return o5b.a.C7018a.f522153b;
    L7:
        return r100;
    }

    public String getAvatarKey() {
        String r100 = this.avatarKey;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public IChatterDesc getDesc() {
        ChatterDescription r100 = this.description;
        if (r100 != null) goto L7;
        IChatterDesc.F1.getClass();
        return IChatterDesc.a.f415387b;
    L7:
        return r100;
    }

    public String getNamePy() {
        if (TextUtils.isEmpty(this.namePy) == false) goto L6;
        return "#";
    L6:
        return this.namePy;
    }

    public boolean isCustomer() {
        return "0".equals(this.tenantId);
    }

    public void setDimission() {
        int r100 = this.status;
        if ((r100 & 2) != 0) goto L6;
        this.status = r100 | 2;
        return;
    }

    public boolean showAgentTag() {
        if (ChatterType.BOT == getType()) goto L5;
    L9:
        return false;
    L5:
        if ("bot".equals(this.withBotTag) == false) goto L9;
        if (this.isAgent == false) goto L9;
        return true;
    }

    public boolean showBotTag() {
        if (ChatterType.BOT == getType()) goto L5;
    L9:
        return false;
    L5:
        if ("bot".equals(this.withBotTag) == false) goto L9;
        if (this.isAgent == true) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Chatter{id='");
        r100.append(this.f415177id);
        r100.append("', name='");
        r100.append(this.name);
        r100.append("', status=");
        r100.append(this.status);
        r100.append(", type=");
        r100.append(this.type);
        r100.append(", withBotTag='");
        r100.append(this.withBotTag);
        r100.append("', boeExtType='");
        r100.append(this.botExtraType);
        r100.append("', isAgent='");
        r100.append(this.isAgent);
        r100.append("', inContacts=");
        r100.append(this.inContacts);
        r100.append(", canJoinGroup=");
        r100.append(this.canJoinGroup);
        r100.append(", profileEnable=");
        r100.append(this.profileEnable);
        r100.append(", tagData=");
        Object r101 = this.tagData;
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append('}');
        return r100.toString();
    }

    public Chatter() {
        this.description = new ChatterDescription();
        this.isCrossTenant = false;
        this.isCollaboration = false;
        this.isSpecialFocus = false;
        this.isDefaultAvatar = false;
        this.mutedInfo = null;
        this.tagData = null;
        this.fullDepartmentName = null;
        this.chatterSensitiveInfo = null;
        this.commonLocales = null;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isBot() {
        if (getType() != ChatterType.BOT) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBotAgent() {
        return showAgentTag();
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isDimission() {
        if (getType() != ChatterType.BOT) goto L6;
        return false;
    L6:
        if (getType() != ChatterType.AI) goto L9;
        return false;
    L9:
        if ((getStatus() & 2) != 2) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isUser() {
        if (getType() != ChatterType.USER) goto L5;
        return true;
    L5:
        return false;
    }

    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getAnotherName() {
        return this.anotherName;
    }

    public String getAnother_name() {
        return this.another_name;
    }

    public AvatarMedal getAvatarMedal() {
        return this.avatarMedal;
    }

    public List<String> getAvatarUrls() {
        return this.avatarUrls;
    }

    public int getBotExtraType() {
        return this.botExtraType;
    }

    public ChatterSensitiveInfo getChatterSensitiveInfo() {
        return this.chatterSensitiveInfo;
    }

    public List<String> getCommonLocales() {
        return this.commonLocales;
    }

    public List<ChatterCustomStatus> getCustomStatus() {
        return this.customStatus;
    }

    public ChatterDescription getDescription() {
        return this.description;
    }

    public String getEnName() {
        return this.enName;
    }

    public String getFullDepartmentName() {
        return this.fullDepartmentName;
    }

    public String getId() {
        return this.f415177id;
    }

    public String getLocalizedName() {
        return this.localizedName;
    }

    public String getMajorLanguage() {
        return this.majorLanguage;
    }

    public BotMutedInfo getMutedInfo() {
        return this.mutedInfo;
    }

    public String getName() {
        return this.name;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public String getNameWithAnotherName() {
        return this.nameWithAnotherName;
    }

    public String getOpenAppId() {
        return this.openAppId;
    }

    public UserPrivateDescription getPrivateDescription() {
        return this.privateDescription;
    }

    public boolean getRegistered() {
        return this.isRegistered;
    }

    public int getStatus() {
        return this.status;
    }

    public TagData getTagData() {
        return this.tagData;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public List<String> getThumbnails() {
        return this.thumbnails;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public ChatterType getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getWithBotTag() {
        return this.withBotTag;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isAcceptSmsPhoneUrgent() {
        return this.acceptSmsPhoneUrgent;
    }

    public boolean isAgent() {
        return this.isAgent;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public boolean isCanJoinGroup() {
        return this.canJoinGroup;
    }

    public boolean isCollaboration() {
        return this.isCollaboration;
    }

    public boolean isCrossTenant() {
        return this.isCrossTenant;
    }

    public boolean isDefaultAvatar() {
        return this.isDefaultAvatar;
    }

    public boolean isFrozen() {
        return this.isFrozen;
    }

    public boolean isInContacts() {
        return this.inContacts;
    }

    public boolean isProfileEnable() {
        return this.profileEnable;
    }

    @Override // com.ss.android.lark.chat.export.entity.chatter.OpenChatter
    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean isSpecialFocus() {
        return this.isSpecialFocus;
    }

    public int compareTo(Object r100) {
        if ((r100 instanceof Chatter) == false) goto L24;
        String r101 = this.localizedName;
        if (TextUtils.isEmpty(this.namePy) == false) goto L7;
    L9:
        Chatter r102 = (Chatter) r100;
        String r103 = r102.getNamePy();
        if (TextUtils.isEmpty(r103) == false) goto L12;
    L13:
        r103 = r102.getLocalizedName();
    L15:
        if (TextUtils.isEmpty(r101) == false) goto L17;
        return 0;
    L17:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        return 0;
    L19:
        if (r101.compareToIgnoreCase(r103) != 0) goto L23;
        return this.f415177id.compareTo(r102.getId());
    L23:
        return r101.compareToIgnoreCase(r103);
    L12:
        if (r103.equals("#") == false) goto L15;
    L7:
        if (this.namePy.equals("#") == true) goto L9;
        r101 = this.namePy;
        goto L9
    L24:
        return 0;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Chatter) == true) goto L5;
        return false;
    L5:
        return getId().equals(((Chatter) r100).getId());
    }

    public boolean exactlyCompare(Chatter r100) {
        boolean r101 = equals(r100);
        if (r101 == true) goto L5;
    L8:
        return r101;
    L5:
        if (TextUtils.equals(r100.getAvatarKey(), getAvatarKey()) == true) goto L8;
        return false;
    }

    public boolean isContentSame(Chatter r100) {
        if (y28.a.a(this.name, r100.getName()) == true) goto L6;
        return false;
    L6:
        if (y28.a.a(this.localizedName, r100.localizedName) == true) goto L9;
        return false;
    L9:
        if (y28.a.a(this.alias, r100.alias) == true) goto L12;
        return false;
    L12:
        if (this.status == r100.getStatus()) goto L15;
        return false;
    L15:
        if (y28.a.a(this.avatarKey, r100.getAvatarKey()) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r100.getUpdateTime()) goto L21;
        return false;
    L21:
        if (y28.a.a(this.namePy, r100.getNamePy()) == true) goto L24;
        return false;
    L24:
        if (y28.a.a(this.description, r100.getDescription()) == true) goto L27;
        return false;
    L27:
        if (y28.a.a(this.privateDescription, r100.getPrivateDescription()) == true) goto L30;
        return false;
    L30:
        if (y28.a.a(this.enName, r100.getEnName()) == true) goto L33;
        return false;
    L33:
        if (y28.a.a(this.workStatus, r100.getWorkStatus()) == true) goto L36;
        return false;
    L36:
        if (y28.a.a(this.customStatus, r100.getCustomStatus()) == true) goto L39;
        return false;
    L39:
        if (Objects.equals(this.avatarMedal, r100.avatarMedal) == true) goto L42;
        return false;
    L42:
        if (y28.a.c(this.mutedInfo, r100.mutedInfo) == true) goto L45;
        return false;
    L45:
        if (y28.a.a(this.tagData, r100.tagData) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((Chatter) r100);
    }

    public void setAcceptSmsPhoneUrgent(boolean r100) {
        this.acceptSmsPhoneUrgent = r100;
    }

    public void setAccessInfo(AccessInfo r100) {
        this.accessInfo = r100;
    }

    public void setAgent(boolean r100) {
        this.isAgent = r100;
    }

    public void setAlias(String r100) {
        this.alias = r100;
    }

    public void setAnonymous(boolean r100) {
        this.isAnonymous = r100;
    }

    public void setAnotherName(String r100) {
        this.anotherName = r100;
    }

    public void setAnother_name(String r100) {
        this.another_name = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarMedal(AvatarMedal r100) {
        this.avatarMedal = r100;
    }

    public void setAvatarUrls(List<String> r100) {
        this.avatarUrls = r100;
    }

    public void setBotExtraType(int r100) {
        this.botExtraType = r100;
    }

    public void setCanJoinGroup(boolean r100) {
        this.canJoinGroup = r100;
    }

    public void setChatterSensitiveInfo(ChatterSensitiveInfo r100) {
        this.chatterSensitiveInfo = r100;
    }

    public void setCollaboration(boolean r100) {
        this.isCollaboration = r100;
    }

    public void setCommonLocales(List<String> r100) {
        this.commonLocales = new ArrayList(r100);
    }

    public void setCreatorId(String r100) {
        this.creatorId = r100;
    }

    public void setCrossTenant(boolean r100) {
        this.isCrossTenant = r100;
    }

    public void setCustomStatus(List<ChatterCustomStatus> r100) {
        this.customStatus = r100;
    }

    public void setDefaultAvatar(boolean r100) {
        this.isDefaultAvatar = r100;
    }

    public void setDescription(ChatterDescription r100) {
        this.description = r100;
    }

    public void setEnName(String r100) {
        this.enName = r100;
    }

    public void setFrozen(boolean r100) {
        this.isFrozen = r100;
    }

    public void setFullDepartmentName(String r100) {
        this.fullDepartmentName = r100;
    }

    public void setId(String r100) {
        this.f415177id = r100;
    }

    public void setInContacts(boolean r100) {
        this.inContacts = r100;
    }

    public void setLocalizedName(String r100) {
        this.localizedName = r100;
    }

    public void setMajorLanguage(String r100) {
        this.majorLanguage = r100;
    }

    public void setMutedInfo(BotMutedInfo r100) {
        this.mutedInfo = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setNamePinyin(String r100) {
        this.namePinyin = r100;
    }

    public void setNamePy(String r100) {
        this.namePy = r100;
    }

    public void setNameWithAnotherName(String r100) {
        this.nameWithAnotherName = r100;
    }

    public void setOpenAppId(String r100) {
        this.openAppId = r100;
    }

    public void setPrivateDescription(UserPrivateDescription r100) {
        this.privateDescription = r100;
    }

    public void setProfileEnable(boolean r100) {
        this.profileEnable = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setSpecialFocus(boolean r100) {
        this.isSpecialFocus = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }

    public void setTagData(TagData r100) {
        this.tagData = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setThumbnails(List<String> r100) {
        this.thumbnails = r100;
    }

    public void setTimeZone(TimeZone r100) {
        this.timeZone = r100;
    }

    public void setType(ChatterType r100) {
        this.type = r100;
    }

    public void setUpdateTime(long r100) {
        this.updateTime = r100;
    }

    public void setWithBotTag(String r100) {
        this.withBotTag = r100;
    }

    public void setWorkStatus(WorkStatus r100) {
        this.workStatus = r100;
    }

    public void setZenModeEndTime(long r100) {
        this.zenModeEndTime = r100;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((Chatter) r100);
    }

    public boolean isItemSame(Chatter r100) {
        return equals(r100);
    }
}
