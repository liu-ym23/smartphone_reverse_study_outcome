package com.bytedance.ee.bear.share.export;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    private String id;
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
        public final UserInfo createFromParcel(Parcel r2) {
            return new UserInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int r1) {
            return new UserInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, Integer.valueOf(this.ownerType)});
    }

    static {
        SUPPORTED_TYPES = new int[]{0, 1, 2, 5, 8, 9, 11, 10, 17, 14, 16, 18, 19, 24, 23, 26, 27, 28, OWNER_TYPE_AUTO_GRANTED_DEPARTMENT, OWNER_TYPE_SYNCED_BLOCK, 111};
        CREATOR = new a();
    }

    public String getCnName() {
        return ou5.a.d(Locale.CHINESE.getLanguage(), this.displayName, this.name, this.cn_name);
    }

    public String getDepartment() {
        String r0 = this.department;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public String getDisplayLabel() {
        if (this.isExternal == false) goto L5;
        String r0 = this.tenantName;
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        return "";
    L10:
        return r0;
    L5:
        r0 = this.label;
        goto L7
    }

    public String getEnName() {
        return ou5.a.d(Locale.ENGLISH.getLanguage(), this.displayName, this.name, this.en_name);
    }

    public String getGroupDescription() {
        String r0 = this.groupDescription;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

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
        int r0 = this.ownerType;
        if (r0 == 0) goto L6;
        if (r0 == 1) goto L6;
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
        int[] r0 = SUPPORTED_TYPES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r0[r3];
        if (this.ownerType == r4) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public boolean isUserType() {
        int r0 = this.ownerType;
        if (r0 == 0) goto L10;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 == 17) goto L12;
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
        return this.id;
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

    public UserInfo(Parcel r4) {
        boolean r0 = true;
        this.isUserCountVisible = true;
        this.department = "";
        this.groupDescription = "";
        this.id = r4.readString();
        this.name = r4.readString();
        this.cn_name = r4.readString();
        this.en_name = r4.readString();
        this.label = r4.readString();
        this.avatarUrl = r4.readString();
        this.ownerType = r4.readInt();
        this.permission = r4.readInt();
        if (r4.readByte() == 0) goto L5;
        boolean r1 = true;
    L6:
        this.isExternal = r1;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.can_modify_perm = r2;
        this.tenantId = r4.readString();
        this.tenantName = r4.readString();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.isOwner = r3;
        this.inviter_id = r4.readString();
        if (r4.readByte() == 0) goto L17;
        boolean r5 = true;
    L18:
        this.is_role_inherited = r5;
        if (r4.readByte() == 0) goto L21;
        boolean r6 = true;
    L22:
        this.can_modify_role = r6;
        this.tenant_tag = r4.readString();
        if (r4.readByte() == 0) goto L25;
        boolean r7 = true;
    L26:
        this.is_single_product = r7;
        if (r4.readByte() == 0) goto L29;
        boolean r8 = true;
    L30:
        this.has_tips = r8;
        this.tempCountryCode = r4.readString();
        this.blockStatus = r4.readInt();
        if (r4.readByte() == 0) goto L33;
        boolean r9 = true;
    L34:
        this.isFriend = r9;
        this.tempPhone = r4.readString();
        this.permSource = r4.readString();
        this.userCount = r4.readInt();
        this.wikiDescription = r4.readString();
        this.tooltipsType = r4.readInt();
        this.displayName = r4.readString();
        this.avatarkey = r4.readString();
        this.organizationTagValue = r4.readString();
        this.mailAddress = r4.readString();
        this.iconToken = r4.readString();
        if (r4.readByte() != 0) goto L38;
        r0 = false;
    L38:
        this.isUserCountVisible = r0;
        this.i18nNames = r4.readHashMap(HashMap.class.getClassLoader());
        return;
    L33:
        r9 = false;
        goto L34
    L29:
        r8 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L23;
        UserInfo r6 = (UserInfo) r5;
        if (isUserType() == false) goto L17;
        if (r6.isUserType() == false) goto L17;
        return Objects.equals(this.id, r6.id);
    L17:
        if (Objects.equals(this.id, r6.id) == true) goto L19;
    L21:
        return false;
    L19:
        if (Objects.equals(Integer.valueOf(this.ownerType), Integer.valueOf(r6.ownerType)) == false) goto L21;
        return true;
    }

    public String getDisplayName(Locale r3) {
        int r0 = this.ownerType;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (r0 == 17) goto L12;
        return this.name;
    L12:
        if (TextUtils.isEmpty(getEnName()) == true) goto L14;
    L17:
        String r4 = r3.getLanguage();
        if (TextUtils.isEmpty(r4) == false) goto L25;
        if (TextUtils.isEmpty(getEnName()) == true) goto L23;
        return getEnName();
    L23:
        return getCnName();
    L25:
        if (Locale.CHINESE.getLanguage().equals(r4) == false) goto L32;
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
        return getName(r3.getLanguage());
    }

    public String getName(String r4) {
        return ou5.a.d(r4, this.displayName, this.name, this.en_name);
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setAvatarkey(String r1) {
        this.avatarkey = r1;
    }

    public void setBlockStatus(int r1) {
        this.blockStatus = r1;
    }

    public void setCan_modify_perm(boolean r1) {
        this.can_modify_perm = r1;
    }

    public void setCan_modify_role(boolean r1) {
        this.can_modify_role = r1;
    }

    public void setCnName(String r1) {
        this.cn_name = r1;
    }

    public void setDepartment(String r1) {
        this.department = r1;
    }

    public void setDisplayName(String r1) {
        this.displayName = r1;
    }

    public void setEnName(String r1) {
        this.en_name = r1;
    }

    public void setExternal(boolean r1) {
        this.isExternal = r1;
    }

    public void setFriend(boolean r1) {
        this.isFriend = r1;
    }

    public void setGroupDescription(String r1) {
        this.groupDescription = r1;
    }

    public void setHas_tips(boolean r1) {
        this.has_tips = r1;
    }

    public void setI18nNames(HashMap<String, String> r1) {
        this.i18nNames = r1;
    }

    public void setIconToken(String r1) {
        this.iconToken = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setInviter_id(String r1) {
        this.inviter_id = r1;
    }

    public void setIs_role_inherited(boolean r1) {
        this.is_role_inherited = r1;
    }

    public void setIs_single_product(boolean r1) {
        this.is_single_product = r1;
    }

    public void setLabel(String r1) {
        this.label = r1;
    }

    public void setMailAddress(String r1) {
        this.mailAddress = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setOrganizationTagValue(String r1) {
        this.organizationTagValue = r1;
    }

    public void setOwner(boolean r1) {
        this.isOwner = r1;
    }

    public void setOwnerType(int r1) {
        this.ownerType = r1;
    }

    public void setPermSource(String r1) {
        this.permSource = r1;
    }

    public void setPermission(int r1) {
        this.permission = r1;
    }

    public void setTempCountryCode(String r1) {
        this.tempCountryCode = r1;
    }

    public void setTempPhone(String r1) {
        this.tempPhone = r1;
    }

    public void setTenantId(String r1) {
        this.tenantId = r1;
    }

    public void setTenantName(String r1) {
        this.tenantName = r1;
    }

    public void setTenant_tag(String r1) {
        this.tenant_tag = r1;
    }

    public void setTooltipsType(int r1) {
        this.tooltipsType = r1;
    }

    public void setUserCount(int r1) {
        this.userCount = r1;
    }

    public void setUserCountVisible(boolean r1) {
        this.isUserCountVisible = r1;
    }

    public void setWikiDescription(String r1) {
        this.wikiDescription = r1;
    }

    public void setDisplayName(Locale r3, String r4) {
        int r0 = this.ownerType;
        if (r0 != 0) goto L5;
    L8:
        String r5 = r3.getLanguage();
        if (TextUtils.isEmpty(r5) == false) goto L12;
        setEnName(r4);
        return;
    L12:
        if (Locale.CHINESE.getLanguage().equals(r5) == false) goto L14;
        setCnName(r4);
        return;
    L14:
        setEnName(r4);
        return;
    L5:
        if (r0 == 1) goto L8;
        setName(r4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.id);
        r1.writeString(this.name);
        r1.writeString(this.cn_name);
        r1.writeString(this.en_name);
        r1.writeString(this.label);
        r1.writeString(this.avatarUrl);
        r1.writeInt(this.ownerType);
        r1.writeInt(this.permission);
        r1.writeByte(this.isExternal ? 1 : 0);
        r1.writeByte(this.can_modify_perm ? 1 : 0);
        r1.writeString(this.tenantId);
        r1.writeString(this.tenantName);
        r1.writeByte(this.isOwner ? 1 : 0);
        r1.writeString(this.inviter_id);
        r1.writeByte(this.is_role_inherited ? 1 : 0);
        r1.writeByte(this.can_modify_role ? 1 : 0);
        r1.writeString(this.tenant_tag);
        r1.writeByte(this.is_single_product ? 1 : 0);
        r1.writeByte(this.has_tips ? 1 : 0);
        r1.writeString(this.tempCountryCode);
        r1.writeInt(this.blockStatus);
        r1.writeByte(this.isFriend ? 1 : 0);
        r1.writeString(this.tempPhone);
        r1.writeString(this.permSource);
        r1.writeInt(this.userCount);
        r1.writeString(this.wikiDescription);
        r1.writeInt(this.tooltipsType);
        r1.writeString(this.displayName);
        r1.writeString(this.avatarkey);
        r1.writeString(this.organizationTagValue);
        r1.writeString(this.mailAddress);
        r1.writeString(this.iconToken);
        r1.writeByte(this.isUserCountVisible ? 1 : 0);
        r1.writeMap(this.i18nNames);
    }
}
