package com.ss.android.lark.profile.v2.entity;

import com.bytedance.lark.pb.basic.v1.AvatarMedal;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.ss.android.lark.profile.entity.WorkStatus;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 o2\u00020\u0001:\u0005opqrsB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001c\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00104\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010=\u001a\u0016\u0012\u0004\u0012\u00020?\u0018\u00010>j\n\u0012\u0004\u0012\u00020?\u0018\u0001`@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\r\"\u0004\bG\u0010\u000fR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010*\"\u0004\bO\u0010,R\u001c\u0010P\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR\u001a\u0010S\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR\u001a\u0010V\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010*\"\u0004\bW\u0010,R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R \u0010^\u001a\b\u0012\u0004\u0012\u00020`0_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\r\"\u0004\bg\u0010\u000fR\u001a\u0010h\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010*\"\u0004\bi\u0010,R\u001a\u0010j\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010*\"\u0004\bk\u0010,R\u001a\u0010l\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0007\"\u0004\bn\u0010\t¨\u0006t"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/UserInfo;", "Ljava/io/Serializable;", "<init>", "()V", "friendStatus", "", "getFriendStatus", "()I", "setFriendStatus", "(I)V", "tenantName", "", "getTenantName", "()Ljava/lang/String;", "setTenantName", "(Ljava/lang/String;)V", "contactToken", "getContactToken", "setContactToken", "contactApplicationId", "getContactApplicationId", "setContactApplicationId", "leaderId", "getLeaderId", "setLeaderId", "gender", "getGender", "setGender", "userId", "getUserId", "setUserId", "userName", "getUserName", "setUserName", "nameWithAnotherName", "getNameWithAnotherName", "setNameWithAnotherName", "tenantId", "getTenantId", "setTenantId", "isResigned", "", "()Z", "setResigned", "(Z)V", "doNotDisturbEndTime", "", "getDoNotDisturbEndTime", "()Ljava/lang/Long;", "setDoNotDisturbEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "frozen", "getFrozen", "setFrozen", "workStatus", "Lcom/ss/android/lark/profile/entity/WorkStatus;", "getWorkStatus", "()Lcom/ss/android/lark/profile/entity/WorkStatus;", "setWorkStatus", "(Lcom/ss/android/lark/profile/entity/WorkStatus;)V", "customStatus", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "Lkotlin/collections/ArrayList;", "getCustomStatus", "()Ljava/util/ArrayList;", "setCustomStatus", "(Ljava/util/ArrayList;)V", "avatarKey", "getAvatarKey", "setAvatarKey", "avatarMedal", "Lcom/bytedance/lark/pb/basic/v1/AvatarMedal;", "getAvatarMedal", "()Lcom/bytedance/lark/pb/basic/v1/AvatarMedal;", "setAvatarMedal", "(Lcom/bytedance/lark/pb/basic/v1/AvatarMedal;)V", "isTenantCertification", "setTenantCertification", "tenantCertificationUrl", "getTenantCertificationUrl", "setTenantCertificationUrl", "certificateStatus", "getCertificateStatus", "setCertificateStatus", "isHasTenantCertification", "setHasTenantCertification", "certificationInfo", "Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$UserInfo$CertificationInfo;", "getCertificationInfo", "()Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$UserInfo$CertificationInfo;", "setCertificationInfo", "(Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$UserInfo$CertificationInfo;)V", "customTagFields", "", "Lcom/bytedance/lark/pb/contact/v2/GetUserProfileResponse$CustomImage;", "getCustomTagFields", "()Ljava/util/List;", "setCustomTagFields", "(Ljava/util/List;)V", "nameCardId", "getNameCardId", "setNameCardId", "isBlocked", "setBlocked", "isBeBlocked", "setBeBlocked", "userTag", "getUserTag", "setUserTag", "Companion", "Gender", "FriendStatus", "BlockStatus", "UserTag", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserInfo implements Serializable {
    public static final int BLOCK_DOUBLE = 4;
    public static final int BLOCK_FORWARD = 2;
    public static final int BLOCK_NONE = 1;
    public static final int BLOCK_REVERSE = 3;
    public static final int BLOCK_UNKNOWN = 0;
    public static final a Companion = null;
    public static final int FRIEND_STATUS_DOUBLE = 1;
    public static final int FRIEND_STATUS_FORWARD = 2;
    public static final int FRIEND_STATUS_NONE = 4;
    public static final int FRIEND_STATUS_REVERSE = 3;
    public static final int FRIEND_STATUS_UNKNOWN = 0;
    public static final int GENDER_TYPE_FEMALE = 2;
    public static final int GENDER_TYPE_MALE = 1;
    public static final int GENDER_TYPE_UNKNOWN = 0;
    public static final String NONE_NAME_CARD_ID = "0";
    public static final int U_TAG_DEFAULT = 0;
    public static final int U_TAG_PARENT = 2;
    public static final int U_TAG_STUDENT = 1;
    private String avatarKey;
    private AvatarMedal avatarMedal;
    private int certificateStatus;
    private GetUserProfileResponse.UserInfo.CertificationInfo certificationInfo;
    private String contactApplicationId;
    private String contactToken;
    private ArrayList<Chatter.ChatterCustomStatus> customStatus;
    private List<GetUserProfileResponse.CustomImage> customTagFields;
    private Long doNotDisturbEndTime;
    private int friendStatus;
    private boolean frozen;
    private int gender;
    private boolean isBeBlocked;
    private boolean isBlocked;
    private boolean isHasTenantCertification;
    private boolean isResigned;
    private boolean isTenantCertification;
    private String leaderId;
    private String nameCardId;
    private String nameWithAnotherName;
    private String tenantCertificationUrl;
    private String tenantId;
    private String tenantName;
    private String userId;
    private String userName;
    private int userTag;
    private WorkStatus workStatus;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/UserInfo$BlockStatus;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BlockStatus {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/UserInfo$FriendStatus;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface FriendStatus {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/UserInfo$Gender;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Gender {
    }

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/UserInfo$UserTag;", "", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface UserTag {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UserInfo() {
        this.customTagFields = CollectionsKt.emptyList();
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final AvatarMedal getAvatarMedal() {
        return this.avatarMedal;
    }

    public final int getCertificateStatus() {
        return this.certificateStatus;
    }

    public final GetUserProfileResponse.UserInfo.CertificationInfo getCertificationInfo() {
        return this.certificationInfo;
    }

    public final String getContactApplicationId() {
        return this.contactApplicationId;
    }

    public final String getContactToken() {
        return this.contactToken;
    }

    public final ArrayList<Chatter.ChatterCustomStatus> getCustomStatus() {
        return this.customStatus;
    }

    public final List<GetUserProfileResponse.CustomImage> getCustomTagFields() {
        return this.customTagFields;
    }

    public final Long getDoNotDisturbEndTime() {
        return this.doNotDisturbEndTime;
    }

    public final int getFriendStatus() {
        return this.friendStatus;
    }

    public final boolean getFrozen() {
        return this.frozen;
    }

    public final int getGender() {
        return this.gender;
    }

    public final String getLeaderId() {
        return this.leaderId;
    }

    public final String getNameCardId() {
        return this.nameCardId;
    }

    public final String getNameWithAnotherName() {
        return this.nameWithAnotherName;
    }

    public final String getTenantCertificationUrl() {
        return this.tenantCertificationUrl;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getTenantName() {
        return this.tenantName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final int getUserTag() {
        return this.userTag;
    }

    public final WorkStatus getWorkStatus() {
        return this.workStatus;
    }

    public final boolean isBeBlocked() {
        return this.isBeBlocked;
    }

    public final boolean isBlocked() {
        return this.isBlocked;
    }

    public final boolean isHasTenantCertification() {
        return this.isHasTenantCertification;
    }

    public final boolean isResigned() {
        return this.isResigned;
    }

    public final boolean isTenantCertification() {
        return this.isTenantCertification;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setAvatarMedal(AvatarMedal r100) {
        this.avatarMedal = r100;
    }

    public final void setBeBlocked(boolean r100) {
        this.isBeBlocked = r100;
    }

    public final void setBlocked(boolean r100) {
        this.isBlocked = r100;
    }

    public final void setCertificateStatus(int r100) {
        this.certificateStatus = r100;
    }

    public final void setCertificationInfo(GetUserProfileResponse.UserInfo.CertificationInfo r100) {
        this.certificationInfo = r100;
    }

    public final void setContactApplicationId(String r100) {
        this.contactApplicationId = r100;
    }

    public final void setContactToken(String r100) {
        this.contactToken = r100;
    }

    public final void setCustomStatus(ArrayList<Chatter.ChatterCustomStatus> r100) {
        this.customStatus = r100;
    }

    public final void setCustomTagFields(List<GetUserProfileResponse.CustomImage> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.customTagFields = r100;
    }

    public final void setDoNotDisturbEndTime(Long r100) {
        this.doNotDisturbEndTime = r100;
    }

    public final void setFriendStatus(int r100) {
        this.friendStatus = r100;
    }

    public final void setFrozen(boolean r100) {
        this.frozen = r100;
    }

    public final void setGender(int r100) {
        this.gender = r100;
    }

    public final void setHasTenantCertification(boolean r100) {
        this.isHasTenantCertification = r100;
    }

    public final void setLeaderId(String r100) {
        this.leaderId = r100;
    }

    public final void setNameCardId(String r100) {
        this.nameCardId = r100;
    }

    public final void setNameWithAnotherName(String r100) {
        this.nameWithAnotherName = r100;
    }

    public final void setResigned(boolean r100) {
        this.isResigned = r100;
    }

    public final void setTenantCertification(boolean r100) {
        this.isTenantCertification = r100;
    }

    public final void setTenantCertificationUrl(String r100) {
        this.tenantCertificationUrl = r100;
    }

    public final void setTenantId(String r100) {
        this.tenantId = r100;
    }

    public final void setTenantName(String r100) {
        this.tenantName = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public final void setUserName(String r100) {
        this.userName = r100;
    }

    public final void setUserTag(int r100) {
        this.userTag = r100;
    }

    public final void setWorkStatus(WorkStatus r100) {
        this.workStatus = r100;
    }
}
