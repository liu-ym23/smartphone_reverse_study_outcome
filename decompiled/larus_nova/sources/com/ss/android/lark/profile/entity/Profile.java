package com.ss.android.lark.profile.entity;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.lark.pb.contact.v1.GetUserProfileResponse;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class Profile implements Serializable {
    public static final String[] DEFAULT_FIELD_KEY = null;
    public static final String TYPE_ALIAS = "B-ALIAS";
    public static final String TYPE_CALENDAR = "B-CALENDARSCHEDULE";
    public static final String TYPE_CHATGROUPNICKNAME = "B-CHATGROUPNICKNAME";
    public static final String TYPE_CITY = "B-CITY";
    public static final String TYPE_DEPARTMENT = "B-DEPARTMENT";
    public static final String TYPE_DESCRIPTION = "B-DESCRIPTION";
    public static final String TYPE_EMAIL = "B-EMAIL";
    public static final String TYPE_FRIENDAPPLYREASON = "B-FRIENDAPPLYREASON";
    public static final String TYPE_FRIENDLINK = "B-FRIENDLINK";
    public static final String TYPE_GENDER = "B-GENDER";
    public static final String TYPE_KEY_POSITION = "B-POSITION";
    public static final String TYPE_KEY_UNIT = "B-UNIT";
    public static final String TYPE_LEADER = "B-LEADER";
    public static final String TYPE_MORE = "B-MORE";
    private static final long serialVersionUID = 2832176776710183791L;
    private AccessInfo accessInfo;
    private String alias;
    private String applicationReason;
    private String avatarKey;
    private GetUserProfileResponse.Company.CertificationInfo certificationInfo;
    private String city;
    private String contactApplicationId;
    private String contactToken;
    private HashMap<String, CustomProfileField> customField;
    private String department;
    private ChatterDescription description;
    private List<String> displayFieldList;
    private String email;
    private String employeeId;
    private String enName;
    private String gender;
    private int genderType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f438834id;
    private boolean isAdmin;
    private boolean isFriend;
    private boolean isRequestUserApplied;
    private boolean isResigned;
    private boolean isTargetUserApplied;
    private boolean isTopicGroupAdmin;
    private String leaderEnName;
    private String leaderId;
    private String leaderLocalizedName;
    private String leaderName;
    private String leaderUrl;
    private String localizedName;
    private DepartmentList mDepartmentMetaList;
    private OrgUnit mOrgUnit;
    private Position mPosition;
    private String microAppProfileUrl;
    private String name;
    private String organization;
    private String profile;
    private STATUE status;
    private String tenant;
    private String tenantId;
    private TenantNameStatus tenantNameStatus;
    private WorkStatus workStatus;
    private long zenModeEndTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        public static final int DEFAULT = 0;
        public static final int FEMALE = 2;
        public static final int MALE = 1;
    }

    public static final enum STATUE extends Enum<STATUE> {
        public static final STATUE ON_BUSINESS = null;
        public static final STATUE ON_DEFAULT = null;
        public static final STATUE ON_LEAVE = null;
        public static final STATUE ON_MEETING = null;
        public static final STATUE ON_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATUE[] f438835a = null;
        private int value;

        static {
            STATUE r100 = new STATUE("ON_DEFAULT", 0, 0);
            ON_DEFAULT = r100;
            STATUE r101 = new STATUE("ON_BUSINESS", 1, 1);
            ON_BUSINESS = r101;
            STATUE r102 = new STATUE("ON_LEAVE", 2, 2);
            ON_LEAVE = r102;
            STATUE r103 = new STATUE("ON_MEETING", 3, 3);
            ON_MEETING = r103;
            STATUE r104 = new STATUE("ON_UNKNOWN", 4, -1);
            ON_UNKNOWN = r104;
            f438835a = new STATUE[]{r100, r101, r102, r103, r104};
        }

        public static STATUE[] values() {
            return (STATUE[]) f438835a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static STATUE forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return ON_UNKNOWN;
        L12:
            return ON_MEETING;
        L14:
            return ON_LEAVE;
        L16:
            return ON_BUSINESS;
        L18:
            return ON_DEFAULT;
        }

        public static STATUE valueOf(String r100) {
            return (STATUE) a.a(STATUE.class, r100);
        }

        public static STATUE valueOf(int r100) {
            return forNumber(r100);
        }

        public STATUE(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        DEFAULT_FIELD_KEY = new String[]{TYPE_DESCRIPTION, TYPE_CALENDAR, TYPE_CHATGROUPNICKNAME, TYPE_DEPARTMENT, TYPE_EMAIL, TYPE_LEADER, TYPE_CITY, TYPE_ALIAS, TYPE_FRIENDAPPLYREASON, TYPE_FRIENDLINK, TYPE_MORE, TYPE_KEY_UNIT, TYPE_KEY_POSITION};
    }

    public boolean hasApplicationReason() {
        return !TextUtils.isEmpty(this.applicationReason);
    }

    public boolean hasDepartment() {
        return !TextUtils.isEmpty(this.department);
    }

    public boolean hasEmail() {
        return !TextUtils.isEmpty(this.email);
    }

    public boolean hasLeader() {
        if (this.leaderName == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasProfile() {
        if (TextUtils.isEmpty(this.microAppProfileUrl) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(this.profile) == false) goto L8;
        return false;
    }

    public boolean hasTenant() {
        return !TextUtils.isEmpty(this.tenant);
    }

    public boolean isValid() {
        if (this.f438834id == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Profile() {
        this.f438834id = null;
        this.name = null;
        this.enName = null;
        this.gender = null;
        this.email = null;
        this.profile = null;
        this.microAppProfileUrl = null;
        this.department = null;
        this.tenant = null;
        this.tenantId = null;
        this.organization = null;
        this.leaderName = null;
        this.leaderEnName = null;
        this.leaderUrl = null;
        this.leaderId = null;
        this.isAdmin = false;
        this.isTopicGroupAdmin = false;
        this.employeeId = null;
        this.contactToken = null;
        this.contactApplicationId = null;
        this.applicationReason = null;
        this.city = null;
        this.description = null;
        this.workStatus = null;
    }

    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getApplicationReason() {
        return this.applicationReason;
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public GetUserProfileResponse.Company.CertificationInfo getCertificationInfo() {
        return this.certificationInfo;
    }

    public String getCity() {
        return this.city;
    }

    public String getContactApplicationId() {
        return this.contactApplicationId;
    }

    public String getContactToken() {
        return this.contactToken;
    }

    public HashMap<String, CustomProfileField> getCustomField() {
        return this.customField;
    }

    public String getDepartment() {
        return this.department;
    }

    public DepartmentList getDepartmentMetaList() {
        return this.mDepartmentMetaList;
    }

    public ChatterDescription getDescription() {
        return this.description;
    }

    public List<String> getDisplayFieldList() {
        return this.displayFieldList;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public String getEnName() {
        return this.enName;
    }

    public String getGender() {
        return this.gender;
    }

    public int getGenderType() {
        return this.genderType;
    }

    public String getId() {
        return this.f438834id;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public boolean getIsTopicGroupAdmin() {
        return this.isTopicGroupAdmin;
    }

    public String getLeaderEnName() {
        return this.leaderEnName;
    }

    public String getLeaderId() {
        return this.leaderId;
    }

    public String getLeaderLocalizedName() {
        return this.leaderLocalizedName;
    }

    public String getLeaderName() {
        return this.leaderName;
    }

    public String getLeaderUrl() {
        return this.leaderUrl;
    }

    public String getLocalizedName() {
        return this.localizedName;
    }

    public String getMicroAppProfileUrl() {
        return this.microAppProfileUrl;
    }

    public String getName() {
        return this.name;
    }

    public OrgUnit getOrgUnit() {
        return this.mOrgUnit;
    }

    public String getOrganization() {
        return this.organization;
    }

    public Position getPosition() {
        return this.mPosition;
    }

    public String getProfile() {
        return this.profile;
    }

    public STATUE getStatus() {
        return this.status;
    }

    public String getTenant() {
        return this.tenant;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public TenantNameStatus getTenantNameStatus() {
        return this.tenantNameStatus;
    }

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public long getZenModeEndTime() {
        return this.zenModeEndTime;
    }

    public boolean isFriend() {
        return this.isFriend;
    }

    public boolean isRequestUserApplied() {
        return this.isRequestUserApplied;
    }

    public boolean isResigned() {
        return this.isResigned;
    }

    public boolean isTargetUserApplied() {
        return this.isTargetUserApplied;
    }

    public void setAccessInfo(AccessInfo r100) {
        this.accessInfo = r100;
    }

    public void setAlias(String r100) {
        this.alias = r100;
    }

    public void setApplicationReason(String r100) {
        this.applicationReason = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setCertificationInfo(GetUserProfileResponse.Company.CertificationInfo r100) {
        this.certificationInfo = r100;
    }

    public void setCity(String r100) {
        this.city = r100;
    }

    public void setContactApplicationId(String r100) {
        this.contactApplicationId = r100;
    }

    public void setContactToken(String r100) {
        this.contactToken = r100;
    }

    public void setCustomField(HashMap<String, CustomProfileField> r100) {
        this.customField = r100;
    }

    public void setDepartment(String r100) {
        this.department = r100;
    }

    public void setDepartmentMetaList(DepartmentList r100) {
        this.mDepartmentMetaList = r100;
    }

    public void setDescription(ChatterDescription r100) {
        this.description = r100;
    }

    public void setDisplayFieldList(List<String> r100) {
        this.displayFieldList = r100;
    }

    public void setEmail(String r100) {
        this.email = r100;
    }

    public void setEmployeeId(String r100) {
        this.employeeId = r100;
    }

    public void setEnName(String r100) {
        this.enName = r100;
    }

    public void setGender(String r100) {
        this.gender = r100;
    }

    public void setGenderType(int r100) {
        this.genderType = r100;
    }

    public void setId(String r100) {
        this.f438834id = r100;
    }

    public void setIsAdmin(boolean r100) {
        this.isAdmin = r100;
    }

    public void setIsFriend(boolean r100) {
        this.isFriend = r100;
    }

    public void setIsRequestUserApplied(boolean r100) {
        this.isRequestUserApplied = r100;
    }

    public void setIsResigned(boolean r100) {
        this.isResigned = r100;
    }

    public void setIsTargetUserApplied(boolean r100) {
        this.isTargetUserApplied = r100;
    }

    public void setIsTopicGroupAdmin(boolean r100) {
        this.isTopicGroupAdmin = r100;
    }

    public void setLeaderEnName(String r100) {
        this.leaderEnName = r100;
    }

    public void setLeaderId(String r100) {
        this.leaderId = r100;
    }

    public void setLeaderLocalizedName(String r100) {
        this.leaderLocalizedName = r100;
    }

    public void setLeaderName(String r100) {
        this.leaderName = r100;
    }

    public void setLeaderUrl(String r100) {
        this.leaderUrl = r100;
    }

    public void setLocalizedName(String r100) {
        this.localizedName = r100;
    }

    public void setMicroAppProfileUrl(String r100) {
        this.microAppProfileUrl = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOrgUnit(OrgUnit r100) {
        this.mOrgUnit = r100;
    }

    public void setOrganization(String r100) {
        this.organization = r100;
    }

    public void setPosition(Position r100) {
        this.mPosition = r100;
    }

    public void setProfile(String r100) {
        this.profile = r100;
    }

    public void setStatus(STATUE r100) {
        this.status = r100;
    }

    public void setTenant(String r100) {
        this.tenant = r100;
    }

    public void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public void setTenantNameStatus(TenantNameStatus r100) {
        this.tenantNameStatus = r100;
    }

    public void setWorkStatus(WorkStatus r100) {
        this.workStatus = r100;
    }

    public void setZenModeEndTime(long r100) {
        this.zenModeEndTime = r100;
    }
}
