package com.ss.android.lark.widget.span;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/widget/span/AtUserGroupInfo;", "Lcom/ss/android/lark/widget/span/TextStyleInfo;", "userGroupId", "", "userGroupName", "", "permissionStatus", "", "<init>", "(JLjava/lang/String;I)V", "getUserGroupId", "()J", "getUserGroupName", "()Ljava/lang/String;", "getPermissionStatus", "()I", "equals", "", "other", "", "hashCode", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtUserGroupInfo extends TextStyleInfo {
    private final int permissionStatus;
    private final long userGroupId;
    private final String userGroupName;

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        long r101 = this.userGroupId;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.userGroupName.hashCode()) * 31) + this.permissionStatus;
    }

    public final int getPermissionStatus() {
        return this.permissionStatus;
    }

    public final long getUserGroupId() {
        return this.userGroupId;
    }

    public final String getUserGroupName() {
        return this.userGroupName;
    }

    @Override // com.ss.android.lark.widget.span.TextStyleInfo, com.ss.android.lark.widget.span.SpanInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(AtUserGroupInfo.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.span.AtUserGroupInfo");
        AtUserGroupInfo r102 = (AtUserGroupInfo) r100;
        if (this.userGroupId == r102.userGroupId) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.userGroupName, r102.userGroupName) == true) goto L22;
        return false;
    L22:
        if (this.permissionStatus == r102.permissionStatus) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public AtUserGroupInfo(long r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "userGroupName");
        this.userGroupId = r100;
        this.userGroupName = r101;
        this.permissionStatus = r102;
    }
}
