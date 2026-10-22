package com.ss.android.lark.compose.groupinfo;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f417713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f417716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f417717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f417718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f417719g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f417713a, r101.f417713a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417714b, r101.f417714b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417715c, r101.f417715c) == true) goto L18;
        return false;
    L18:
        if (this.f417716d == r101.f417716d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f417717e, r101.f417717e) == true) goto L24;
        return false;
    L24:
        if (this.f417718f == r101.f417718f) goto L27;
        return false;
    L27:
        if (this.f417719g == r101.f417719g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f417713a.hashCode() * 31) + this.f417714b.hashCode()) * 31) + this.f417715c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f417716d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f417717e.hashCode()) * 31;
        long r104 = this.f417718f;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f417719g == true) goto L11;
        r101 = 1237;
    L11:
        return r105 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "GroupInfoState(initialChatName=" + this.f417713a + ", initialAvatarKey=" + this.f417714b + ", chatName=" + this.f417715c + ", canEdit=" + this.f417716d + ", selectedImageUri=" + this.f417717e + ", avatarRefreshKey=" + this.f417718f + ", isUpdating=" + this.f417719g + ')';
    }

    public e(String r100, String r101, String r102, boolean r103, String r104, long r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "initialChatName");
        Intrinsics.checkNotNullParameter(r101, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r102, "chatName");
        Intrinsics.checkNotNullParameter(r104, "selectedImageUri");
        this.f417713a = r100;
        this.f417714b = r101;
        this.f417715c = r102;
        this.f417716d = r103;
        this.f417717e = r104;
        this.f417718f = r105;
        this.f417719g = r106;
    }

    public static e a(e r110, String r111, String r112, String r113, long r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = r110.f417713a;
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = r110.f417714b;
    L10:
        String r102 = r101;
        if ((r116 & 4) == 0) goto L13;
        String r103 = r110.f417715c;
    L15:
        if ((r116 & 8) == 0) goto L17;
        boolean r104 = r110.f417716d;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r110.f417717e;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r110.f417718f;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r117 = r110.f417719g;
    L30:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "initialChatName");
        Intrinsics.checkNotNullParameter(r102, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r103, "chatName");
        Intrinsics.checkNotNullParameter(r105, "selectedImageUri");
        return new e(r100, r102, r103, r104, r105, r106, r117);
    L29:
        r117 = r115;
        goto L30
    L25:
        r106 = r114;
        goto L27
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
