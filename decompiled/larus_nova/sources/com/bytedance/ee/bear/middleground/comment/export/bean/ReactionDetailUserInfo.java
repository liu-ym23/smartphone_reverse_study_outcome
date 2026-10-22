package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.text.TextUtils;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class ReactionDetailUserInfo implements BaseJSModel {
    private boolean anonymous;
    private String avatarKey;
    private String avatarUrl;
    private DetailUserInfo.DescriptionType descType;
    private String description;
    private DisplayName display_name;
    private boolean isRegistered;
    private String userId;
    private String userName;
    private String workStatusDesc;

    public static final enum DescriptionType extends Enum<DescriptionType> {
        public static final DescriptionType BUSINESS = null;
        public static final DescriptionType DEFAULT = null;
        public static final DescriptionType LEAVE = null;
        public static final DescriptionType MEETING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DescriptionType[] f231360a = null;

        static {
            DescriptionType r100 = new DescriptionType("DEFAULT", 0);
            DEFAULT = r100;
            DescriptionType r101 = new DescriptionType("BUSINESS", 1);
            BUSINESS = r101;
            DescriptionType r102 = new DescriptionType("LEAVE", 2);
            LEAVE = r102;
            DescriptionType r103 = new DescriptionType("MEETING", 3);
            MEETING = r103;
            f231360a = new DescriptionType[]{r100, r101, r102, r103};
        }

        public static DescriptionType[] values() {
            return (DescriptionType[]) f231360a.clone();
        }

        public static DescriptionType valueOf(String r100) {
            return (DescriptionType) r27.a.a(DescriptionType.class, r100);
        }

        public DescriptionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId});
    }

    public String toString() {
        return "ReactionDetailUserInfo{anonymous=" + this.anonymous + ", avatarKey='" + this.avatarKey + "', avatarUrl='" + this.avatarUrl + "', userName='" + this.userName + "', userId='" + this.userId + "', isRegistered=" + this.isRegistered + ", descType=" + this.descType + ", workStatusDesc='" + this.workStatusDesc + "'}";
    }

    public ReactionDetailUserInfo() {
        this.anonymous = false;
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        this.descType = DetailUserInfo.DescriptionType.DEFAULT;
        this.workStatusDesc = "";
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public DetailUserInfo.DescriptionType getDescType() {
        return this.descType;
    }

    public String getDescription() {
        return this.description;
    }

    public DisplayName getDisplay_name() {
        return this.display_name;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWorkStatusDesc() {
        return this.workStatusDesc;
    }

    public boolean isAnonymous() {
        return this.anonymous;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        ReactionDetailUserInfo r101 = (ReactionDetailUserInfo) r100;
        if (Objects.equals(this.userId, r101.userId) == true) goto L13;
    L15:
        return false;
    L13:
        if (TextUtils.equals(this.userName, r101.userName) == false) goto L15;
        return true;
    }

    public void setAnonymous(boolean r100) {
        this.anonymous = r100;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setDescType(DetailUserInfo.DescriptionType r100) {
        this.descType = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setDisplay_name(DisplayName r100) {
        this.display_name = r100;
    }

    public void setRegistered(boolean r100) {
        this.isRegistered = r100;
    }

    public void setUserId(String r100) {
        this.userId = r100;
    }

    public void setUserName(String r100) {
        this.userName = r100;
    }

    public void setWorkStatusDesc(String r100) {
        this.workStatusDesc = r100;
    }
}
