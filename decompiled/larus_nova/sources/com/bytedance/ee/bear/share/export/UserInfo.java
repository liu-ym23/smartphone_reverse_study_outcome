package com.bytedance.ee.bear.share.export;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class UserInfo implements Parcelable, MultiItemEntity, NonProguard {
    public static final int BLOCK_STATUS_BLOCK = 2;
    public static final int BLOCK_STATUS_BLOCKED = 1;
    public static final int BLOCK_STATUS_NORMAL = 0;
    public static final int BLOCK_STATUS_PRIVACY = 3;
    public static final int CAC_CONTROL = 2002;
    public static final Parcelable.Creator<UserInfo> CREATOR = null;
    public static final int OWNER_TYPE_APP = 19;
    public static final int OWNER_TYPE_AUTO_GRANTED_DEPARTMENT = 108;
    public static final int OWNER_TYPE_BASE_APP = 46;
    public static final int OWNER_TYPE_BEAR = 0;
    public static final int OWNER_TYPE_DEPARTMENT = 18;
    public static final int OWNER_TYPE_EMAIL = 29;
    public static final int OWNER_TYPE_FOLDER = 5;
    public static final int OWNER_TYPE_GROUP = 2;
    public static final int OWNER_TYPE_LEADER = 111;
    public static final int OWNER_TYPE_LINK = 8;
    public static final int OWNER_TYPE_MEETING = 9;
    public static final int OWNER_TYPE_PHOENIX_ADMIN = 26;
    public static final int OWNER_TYPE_PHOENIX_MEMBER = 27;
    public static final int OWNER_TYPE_SHARE_FOLDER = 11;
    public static final int OWNER_TYPE_SPACE = 16;
    public static final int OWNER_TYPE_SYNCED_BLOCK = 110;
    public static final int OWNER_TYPE_UNKNOWN = -99;
    public static final int OWNER_TYPE_UNREGISTER = 17;
    public static final int OWNER_TYPE_USER = 1;
    public static final int OWNER_TYPE_USERGROUP = 22;
    public static final int OWNER_TYPE_USERGROUP_STATIC = 30;
    public static final int OWNER_TYPE_VIDEO_CONFERENCE = 14;
    public static final int OWNER_TYPE_WIKI = 10;
    public static final int OWNER_TYPE_WIKI_ADMIN = 23;
    public static final int OWNER_TYPE_WIKI_MEMBER = 24;
    public static final int OWNER_TYPE_WIKI_MEMBER_NEW = 28;
    public static final int STATIC_USER_GROUP = 1;
    private static final int[] SUPPORTED_TYPES = null;
    public static final int TOOL_TIPS_TYPE_EDIT = 2;
    public static final int TOOL_TIPS_TYPE_READ = 1;
    private String avatarUrl;
    private String avatarkey;
    private int blockStatus;
    private boolean can_modify_perm;
    private boolean can_modify_role;
    private String cn_name;
    private String department;
    private String displayName;
    private String en_name;
    private String groupDescription;
    private boolean has_tips;
    private HashMap<String, String> i18nNames;
    private String iconToken;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f237021id;
    private String inviter_id;
    private boolean isExternal;
    private boolean isFriend;
    private boolean isOwner;
    private boolean isUserCountVisible;
    private boolean is_role_inherited;
    private boolean is_single_product;
    private String label;
    private String mailAddress;
    private String name;
    private String organizationTagValue;
    private int ownerType;
    private String permSource;
    private int permission;
    private String tempCountryCode;
    private String tempPhone;
    private String tenantId;
    private String tenantName;
    private String tenant_tag;
    private int tooltipsType;
    private int userCount;
    private String wikiDescription;

    public class a implements Parcelable.Creator<UserInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo createFromParcel(Parcel r100) {
            return new UserInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int r100) {
            return new UserInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f237021id, Integer.valueOf(this.ownerType)});
    }

    static {
        SUPPORTED_TYPES = new int[]{0, 1, 2, 5, 8, 9, 11, 10, 17, 14, 16, 18, 19, 24, 23, 26, 27, 28, 108, 110, 111};
        CREATOR = new a();
    }

    public String getCnName() {
        return ou5.a.d(Locale.CHINESE.getLanguage(), this.displayName, this.name, this.cn_name);
    }

    public String getDepartment() {
        String r100 = this.department;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getDisplayLabel() {
        if (this.isExternal == false) goto L5;
        String r100 = this.tenantName;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return "";
    L10:
        return r100;
    L5:
        r100 = this.label;
        goto L7
    }

    public String getEnName() {
        return ou5.a.d(Locale.ENGLISH.getLanguage(), this.displayName, this.name, this.en_name);
    }

    public String getGroupDescription() {
        String r100 = this.groupDescription;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return ShareMemberGroupType.GROUP_MEMBER.getType();
    }

    public boolean isApp() {
        if (this.ownerType != 19) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBlock() {
        int r100 = this.ownerType;
        if (r100 == 0) goto L6;
        if (r100 == 1) goto L6;
    L8:
        return false;
    L6:
        if (this.blockStatus == 0) goto L8;
        return true;
    }

    public boolean isCacControl() {
        if (this.blockStatus != 2002) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnknownType() {
        int[] r100 = SUPPORTED_TYPES;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        int r103 = r100[r102];
        if (this.ownerType == r103) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public boolean isUserType() {
        int r100 = this.ownerType;
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L6;
        return true;
    L6:
        if (r100 == 17) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    public String toString() {
        return "UserInfo{, permission=" + this.permission + ", isExternal=" + this.isExternal + ", isOwner=" + this.isOwner + '}';
    }

    public UserInfo() {
        this.isUserCountVisible = true;
        this.department = "";
        this.groupDescription = "";
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getAvatarkey() {
        return this.avatarkey;
    }

    public int getBlockStatus() {
        return this.blockStatus;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public HashMap<String, String> getI18nNames() {
        return this.i18nNames;
    }

    public String getIconToken() {
        return this.iconToken;
    }

    public String getId() {
        return this.f237021id;
    }

    public String getInviter_id() {
        return this.inviter_id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public String getName() {
        return this.name;
    }

    public String getOrganizationTagValue() {
        return this.organizationTagValue;
    }

    public int getOwnerType() {
        return this.ownerType;
    }

    public String getPermSource() {
        return this.permSource;
    }

    public int getPermission() {
        return this.permission;
    }

    public String getTempCountryCode() {
        return this.tempCountryCode;
    }

    public String getTempPhone() {
        return this.tempPhone;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public String getTenant_tag() {
        return this.tenant_tag;
    }

    public int getTooltipsType() {
        return this.tooltipsType;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public boolean getUserCountVisible() {
        return this.isUserCountVisible;
    }

    public String getWikiDescription() {
        return this.wikiDescription;
    }

    public boolean isCan_modify_perm() {
        return this.can_modify_perm;
    }

    public boolean isCan_modify_role() {
        return this.can_modify_role;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public boolean isHas_tips() {
        return this.has_tips;
    }

    public boolean isIs_role_inherited() {
        return this.is_role_inherited;
    }

    public boolean isIs_single_product() {
        return this.is_single_product;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public UserInfo(Parcel r100) {
        boolean r101 = true;
        this.isUserCountVisible = true;
        this.department = "";
        this.groupDescription = "";
        this.f237021id = r100.readString();
        this.name = r100.readString();
        this.cn_name = r100.readString();
        this.en_name = r100.readString();
        this.label = r100.readString();
        this.avatarUrl = r100.readString();
        this.ownerType = r100.readInt();
        this.permission = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isExternal = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.can_modify_perm = r103;
        this.tenantId = r100.readString();
        this.tenantName = r100.readString();
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isOwner = r104;
        this.inviter_id = r100.readString();
        if (r100.readByte() == 0) goto L17;
        boolean r105 = true;
    L18:
        this.is_role_inherited = r105;
        if (r100.readByte() == 0) goto L21;
        boolean r106 = true;
    L22:
        this.can_modify_role = r106;
        this.tenant_tag = r100.readString();
        if (r100.readByte() == 0) goto L25;
        boolean r107 = true;
    L26:
        this.is_single_product = r107;
        if (r100.readByte() == 0) goto L29;
        boolean r108 = true;
    L30:
        this.has_tips = r108;
        this.tempCountryCode = r100.readString();
        this.blockStatus = r100.readInt();
        if (r100.readByte() == 0) goto L33;
        boolean r109 = true;
    L34:
        this.isFriend = r109;
        this.tempPhone = r100.readString();
        this.permSource = r100.readString();
        this.userCount = r100.readInt();
        this.wikiDescription = r100.readString();
        this.tooltipsType = r100.readInt();
        this.displayName = r100.readString();
        this.avatarkey = r100.readString();
        this.organizationTagValue = r100.readString();
        this.mailAddress = r100.readString();
        this.iconToken = r100.readString();
        if (r100.readByte() != 0) goto L38;
        r101 = false;
    L38:
        this.isUserCountVisible = r101;
        this.i18nNames = r100.readHashMap(HashMap.class.getClassLoader());
        return;
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L23;
        UserInfo r101 = (UserInfo) r100;
        if (isUserType() == false) goto L17;
        if (r101.isUserType() == false) goto L17;
        return Objects.equals(this.f237021id, r101.f237021id);
    L17:
        if (Objects.equals(this.f237021id, r101.f237021id) == true) goto L19;
    L21:
        return false;
    L19:
        if (Objects.equals(Integer.valueOf(this.ownerType), Integer.valueOf(r101.ownerType)) == false) goto L21;
        return true;
    }

    public String getDisplayName(Locale r100) {
        int r101 = this.ownerType;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L12;
        if (r101 == 17) goto L12;
        return this.name;
    L12:
        if (TextUtils.isEmpty(getEnName()) == true) goto L14;
    L17:
        String r102 = r100.getLanguage();
        if (TextUtils.isEmpty(r102) == false) goto L25;
        if (TextUtils.isEmpty(getEnName()) == true) goto L23;
        return getEnName();
    L23:
        return getCnName();
    L25:
        if (Locale.CHINESE.getLanguage().equals(r102) == false) goto L32;
        if (TextUtils.isEmpty(getCnName()) == true) goto L30;
        return getCnName();
    L30:
        return getEnName();
    L32:
        if (TextUtils.isEmpty(getEnName()) == true) goto L35;
        return getEnName();
    L35:
        return getCnName();
    L14:
        if (TextUtils.isEmpty(getCnName()) == false) goto L17;
        return getName(r100.getLanguage());
    }

    public String getName(String r100) {
        return ou5.a.d(r100, this.displayName, this.name, this.en_name);
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setAvatarkey(String r100) {
        this.avatarkey = r100;
    }

    public void setBlockStatus(int r100) {
        this.blockStatus = r100;
    }

    public void setCan_modify_perm(boolean r100) {
        this.can_modify_perm = r100;
    }

    public void setCan_modify_role(boolean r100) {
        this.can_modify_role = r100;
    }

    public void setCnName(String r100) {
        this.cn_name = r100;
    }

    public void setDepartment(String r100) {
        this.department = r100;
    }

    public void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public void setEnName(String r100) {
        this.en_name = r100;
    }

    public void setExternal(boolean r100) {
        this.isExternal = r100;
    }

    public void setFriend(boolean r100) {
        this.isFriend = r100;
    }

    public void setGroupDescription(String r100) {
        this.groupDescription = r100;
    }

    public void setHas_tips(boolean r100) {
        this.has_tips = r100;
    }

    public void setI18nNames(HashMap<String, String> r100) {
        this.i18nNames = r100;
    }

    public void setIconToken(String r100) {
        this.iconToken = r100;
    }

    public void setId(String r100) {
        this.f237021id = r100;
    }

    public void setInviter_id(String r100) {
        this.inviter_id = r100;
    }

    public void setIs_role_inherited(boolean r100) {
        this.is_role_inherited = r100;
    }

    public void setIs_single_product(boolean r100) {
        this.is_single_product = r100;
    }

    public void setLabel(String r100) {
        this.label = r100;
    }

    public void setMailAddress(String r100) {
        this.mailAddress = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOrganizationTagValue(String r100) {
        this.organizationTagValue = r100;
    }

    public void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public void setOwnerType(int r100) {
        this.ownerType = r100;
    }

    public void setPermSource(String r100) {
        this.permSource = r100;
    }

    public void setPermission(int r100) {
        this.permission = r100;
    }

    public void setTempCountryCode(String r100) {
        this.tempCountryCode = r100;
    }

    public void setTempPhone(String r100) {
        this.tempPhone = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTenantName(String r100) {
        this.tenantName = r100;
    }

    public void setTenant_tag(String r100) {
        this.tenant_tag = r100;
    }

    public void setTooltipsType(int r100) {
        this.tooltipsType = r100;
    }

    public void setUserCount(int r100) {
        this.userCount = r100;
    }

    public void setUserCountVisible(boolean r100) {
        this.isUserCountVisible = r100;
    }

    public void setWikiDescription(String r100) {
        this.wikiDescription = r100;
    }

    public void setDisplayName(Locale r100, String r101) {
        int r102 = this.ownerType;
        if (r102 != 0) goto L5;
    L8:
        String r103 = r100.getLanguage();
        if (TextUtils.isEmpty(r103) == false) goto L12;
        setEnName(r101);
        return;
    L12:
        if (Locale.CHINESE.getLanguage().equals(r103) == false) goto L14;
        setCnName(r101);
        return;
    L14:
        setEnName(r101);
        return;
    L5:
        if (r102 == 1) goto L8;
        setName(r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f237021id);
        r100.writeString(this.name);
        r100.writeString(this.cn_name);
        r100.writeString(this.en_name);
        r100.writeString(this.label);
        r100.writeString(this.avatarUrl);
        r100.writeInt(this.ownerType);
        r100.writeInt(this.permission);
        r100.writeByte(this.isExternal ? 1 : 0);
        r100.writeByte(this.can_modify_perm ? 1 : 0);
        r100.writeString(this.tenantId);
        r100.writeString(this.tenantName);
        r100.writeByte(this.isOwner ? 1 : 0);
        r100.writeString(this.inviter_id);
        r100.writeByte(this.is_role_inherited ? 1 : 0);
        r100.writeByte(this.can_modify_role ? 1 : 0);
        r100.writeString(this.tenant_tag);
        r100.writeByte(this.is_single_product ? 1 : 0);
        r100.writeByte(this.has_tips ? 1 : 0);
        r100.writeString(this.tempCountryCode);
        r100.writeInt(this.blockStatus);
        r100.writeByte(this.isFriend ? 1 : 0);
        r100.writeString(this.tempPhone);
        r100.writeString(this.permSource);
        r100.writeInt(this.userCount);
        r100.writeString(this.wikiDescription);
        r100.writeInt(this.tooltipsType);
        r100.writeString(this.displayName);
        r100.writeString(this.avatarkey);
        r100.writeString(this.organizationTagValue);
        r100.writeString(this.mailAddress);
        r100.writeString(this.iconToken);
        r100.writeByte(this.isUserCountVisible ? 1 : 0);
        r100.writeMap(this.i18nNames);
    }
}
