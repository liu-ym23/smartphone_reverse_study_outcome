package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMember;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "ownerId", "", "getOwnerId", "()Ljava/lang/String;", "setOwnerId", "(Ljava/lang/String;)V", "ownerType", "", "getOwnerType", "()Ljava/lang/Integer;", "setOwnerType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "permission", "getPermission", "setPermission", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "avatarKey", "getAvatarKey", "setAvatarKey", "showName", "getShowName", "setShowName", "departmentName", "getDepartmentName", "setDepartmentName", "covertTo", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/UserInfo;", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermMember implements NonProguard {
    public static final a Companion = null;
    public static final int PERM_TRUE = 1;
    private String avatarKey;
    private String avatarUrl;
    private String departmentName;
    private String ownerId;
    private Integer ownerType;
    private Integer permission;
    private String showName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PermMember() {
    }

    public final UserInfo covertTo() {
        UserInfo r0 = new UserInfo();
        r0.setUserId(this.ownerId);
        r0.setUserName(this.showName);
        Integer r1 = this.ownerType;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        r0.setOwnerType(r2);
        r0.setAvatarUrl(this.avatarUrl);
        r0.setAvatarKey(this.avatarKey);
        return r0;
    L5:
        r2 = 0;
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getDepartmentName() {
        return this.departmentName;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final Integer getOwnerType() {
        return this.ownerType;
    }

    public final Integer getPermission() {
        return this.permission;
    }

    public final String getShowName() {
        return this.showName;
    }

    @JvmStatic
    public static final PermMember covertFrom(UserInfo r2) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        PermMember r0 = new PermMember();
        r0.setOwnerId(r2.getUserId());
        r0.setOwnerType(Integer.valueOf(r2.getOwnerType()));
        r0.setPermission(1);
        r0.setAvatarUrl(r2.getAvatarUrl());
        r0.setAvatarKey(r2.getAvatarKey());
        r0.setShowName(r2.getUserName());
        r0.setDepartmentName(r2.getDepartment());
        return r0;
    }

    public final void setAvatarKey(String r1) {
        this.avatarKey = r1;
    }

    public final void setAvatarUrl(String r1) {
        this.avatarUrl = r1;
    }

    public final void setDepartmentName(String r1) {
        this.departmentName = r1;
    }

    public final void setOwnerId(String r1) {
        this.ownerId = r1;
    }

    public final void setOwnerType(Integer r1) {
        this.ownerType = r1;
    }

    public final void setPermission(Integer r1) {
        this.permission = r1;
    }

    public final void setShowName(String r1) {
        this.showName = r1;
    }
}
