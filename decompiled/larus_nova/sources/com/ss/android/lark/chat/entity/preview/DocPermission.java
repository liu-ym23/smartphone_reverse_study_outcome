package com.ss.android.lark.chat.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocPermission;", "Ljava/io/Serializable;", "permissionCode", "", "permissionName", "", "isSet", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getPermissionCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPermissionName", "()Ljava/lang/String;", "()Z", "equals", "other", "", "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermission implements Serializable {
    private final boolean isSet;
    private final Integer permissionCode;
    private final String permissionName;

    public DocPermission() {
        this(null, null, false, 7, null);
    }

    public int hashCode() {
        Integer r100 = this.permissionCode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        String r104 = this.permissionName;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        if (this.isSet == false) goto L12;
        int r106 = 1231;
    L14:
        return r105 + r106;
    L12:
        r106 = 1237;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    public final Integer getPermissionCode() {
        return this.permissionCode;
    }

    public final String getPermissionName() {
        return this.permissionName;
    }

    public final boolean isSet() {
        return this.isSet;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocPermission) == true) goto L8;
        return false;
    L8:
        DocPermission r101 = (DocPermission) r100;
        if (Intrinsics.areEqual(this.permissionCode, r101.permissionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permissionName, r101.permissionName) == true) goto L15;
        return false;
    L15:
        if (this.isSet == r101.isSet) goto L17;
        return false;
    L17:
        return true;
    }

    public DocPermission(Integer r100, String r101, boolean r102) {
        this.permissionCode = r100;
        this.permissionName = r101;
        this.isSet = r102;
    }

    public /* synthetic */ DocPermission(Integer r100, String r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
