package com.larksuite.component.card.component.avatar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J<\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/larksuite/component/card/component/avatar/AvatarProps;", "", "personID", "", "size", "", "avatarKey", "clickable", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "getPersonID", "()Ljava/lang/String;", "getSize", "()I", "getAvatarKey", "getClickable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)Lcom/larksuite/component/card/component/avatar/AvatarProps;", "equals", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarProps {
    private final String avatarKey;
    private final Boolean clickable;
    private final String personID;
    private final int size;

    public static /* synthetic */ AvatarProps copy$default(AvatarProps r100, String r101, int r102, String r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.personID;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.size;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.avatarKey;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.clickable;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.personID;
    }

    public final int component2() {
        return this.size;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final Boolean component4() {
        return this.clickable;
    }

    public final AvatarProps copy(String r100, int r101, String r102, Boolean r103) {
        return new AvatarProps(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AvatarProps) == true) goto L8;
        return false;
    L8:
        AvatarProps r101 = (AvatarProps) r100;
        if (Intrinsics.areEqual(this.personID, r101.personID) == true) goto L12;
        return false;
    L12:
        if (this.size == r101.size) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickable, r101.clickable) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.personID;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.size) * 31;
        String r104 = this.avatarKey;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.clickable;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AvatarProps(personID=" + this.personID + ", size=" + this.size + ", avatarKey=" + this.avatarKey + ", clickable=" + this.clickable + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final Boolean getClickable() {
        return this.clickable;
    }

    public final String getPersonID() {
        return this.personID;
    }

    public final int getSize() {
        return this.size;
    }

    public AvatarProps(String r100, int r101, String r102, Boolean r103) {
        this.personID = r100;
        this.size = r101;
        this.avatarKey = r102;
        this.clickable = r103;
    }

    public /* synthetic */ AvatarProps(String r100, int r101, String r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = Boolean.FALSE;
    L11:
        this(r100, r101, r102, r103);
    }
}
