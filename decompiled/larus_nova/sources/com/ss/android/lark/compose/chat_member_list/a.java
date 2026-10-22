package com.ss.android.lark.compose.chat_member_list;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f417330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f417331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f417332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417333d;

    public a() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f417330a == r101.f417330a) goto L12;
        return false;
    L12:
        if (this.f417331b == r101.f417331b) goto L15;
        return false;
    L15:
        if (this.f417332c == r101.f417332c) goto L18;
        return false;
    L18:
        if (this.f417333d == r101.f417333d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f417330a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f417331b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f417332c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f417333d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatMemberStatusTagState(isOnLeave=" + this.f417330a + ", isExternal=" + this.f417331b + ", isFrozen=" + this.f417332c + ", isResigned=" + this.f417333d + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f417330a = r100;
        this.f417331b = r101;
        this.f417332c = r102;
        this.f417333d = r103;
    }
}
