package com.ss.android.lark.reaction.widget.detailwindow.bean;

import java.io.Serializable;
import java.util.Objects;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class DetailUserInfo implements Serializable {
    private String avatarKey;
    private String avatarUrl;
    private DescriptionType descType;
    private String description;
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
        public static final /* synthetic */ DescriptionType[] f439232a = null;

        static {
            DescriptionType r100 = new DescriptionType("DEFAULT", 0);
            DEFAULT = r100;
            DescriptionType r101 = new DescriptionType("BUSINESS", 1);
            BUSINESS = r101;
            DescriptionType r102 = new DescriptionType("LEAVE", 2);
            LEAVE = r102;
            DescriptionType r103 = new DescriptionType("MEETING", 3);
            MEETING = r103;
            f439232a = new DescriptionType[]{r100, r101, r102, r103};
        }

        public static DescriptionType[] values() {
            return (DescriptionType[]) f439232a.clone();
        }

        public static DescriptionType valueOf(String r100) {
            return (DescriptionType) a.a(DescriptionType.class, r100);
        }

        public DescriptionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.avatarKey, this.avatarUrl, this.userName, this.userId, Boolean.valueOf(this.isRegistered), this.description, this.descType, this.workStatusDesc});
    }

    public DetailUserInfo() {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        this.descType = DescriptionType.DEFAULT;
        this.workStatusDesc = "";
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public DescriptionType getDescType() {
        return this.descType;
    }

    public String getDescription() {
        return this.description;
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

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DetailUserInfo) == true) goto L8;
        return false;
    L8:
        DetailUserInfo r101 = (DetailUserInfo) r100;
        if (this.isRegistered == r101.isRegistered) goto L11;
    L25:
        return false;
    L11:
        if (Objects.equals(this.avatarKey, r101.avatarKey) == false) goto L25;
        if (Objects.equals(this.avatarUrl, r101.avatarUrl) == false) goto L25;
        if (Objects.equals(this.userName, r101.userName) == false) goto L25;
        if (Objects.equals(this.userId, r101.userId) == false) goto L25;
        if (Objects.equals(this.description, r101.description) == false) goto L25;
        if (this.descType != r101.descType) goto L25;
        if (Objects.equals(this.workStatusDesc, r101.workStatusDesc) == false) goto L25;
        return true;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public void setDescType(DescriptionType r100) {
        this.descType = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
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

    public DetailUserInfo(String r100, String r101, String r102) {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        this.descType = DescriptionType.DEFAULT;
        this.workStatusDesc = "";
        this.avatarKey = r100;
        this.userName = r101;
        this.userId = r102;
    }

    public DetailUserInfo(String r100, String r101, String r102, String r103, boolean r104, String r105, DescriptionType r106, String r107) {
        this.avatarKey = "";
        this.avatarUrl = "";
        this.userName = "";
        this.userId = "";
        this.description = "";
        DescriptionType r108 = DescriptionType.DEFAULT;
        this.avatarKey = r100;
        this.avatarUrl = r101;
        this.userName = r102;
        this.userId = r103;
        this.isRegistered = r104;
        this.description = r105;
        this.descType = r106;
        this.workStatusDesc = r107;
    }
}
