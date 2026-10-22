package com.bytedance.ee.bear.middleground.comment.export.bean;

import android.text.TextUtils;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public static final /* synthetic */ DescriptionType[] a = null;

        static {
            DescriptionType r0 = new DescriptionType("DEFAULT", 0);
            DEFAULT = r0;
            DescriptionType r1 = new DescriptionType("BUSINESS", 1);
            BUSINESS = r1;
            DescriptionType r3 = new DescriptionType("LEAVE", 2);
            LEAVE = r3;
            DescriptionType r5 = new DescriptionType("MEETING", 3);
            MEETING = r5;
            a = new DescriptionType[]{r0, r1, r3, r5};
        }

        public static DescriptionType[] values() {
            return (DescriptionType[]) a.clone();
        }

        public static DescriptionType valueOf(String r1) {
            return (DescriptionType) r27.a.a(DescriptionType.class, r1);
        }

        public DescriptionType(String r1, int r2) {
            super(r1, r2);
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

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        ReactionDetailUserInfo r6 = (ReactionDetailUserInfo) r5;
        if (Objects.equals(this.userId, r6.userId) == true) goto L13;
    L15:
        return false;
    L13:
        if (TextUtils.equals(this.userName, r6.userName) == false) goto L15;
        return true;
    }

    public void setAnonymous(boolean r1) {
        this.anonymous = r1;
    }

    public void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public void setDescType(DetailUserInfo.DescriptionType r1) {
        this.descType = r1;
    }

    public void setDescription(String r1) {
        this.description = r1;
    }

    public void setDisplay_name(DisplayName r1) {
        this.display_name = r1;
    }

    public void setRegistered(boolean r1) {
        this.isRegistered = r1;
    }

    public void setUserId(String r1) {
        this.userId = r1;
    }

    public void setUserName(String r1) {
        this.userName = r1;
    }

    public void setWorkStatusDesc(String r1) {
        this.workStatusDesc = r1;
    }
}
