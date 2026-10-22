package com.ss.android.lark.compose.groupqrcode.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadState f417738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f417739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f417740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f417741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f417742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f417743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f417744g;

    public a() {
        String r100 = null;
        this(r100, r100, r100, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f417738a == r101.f417738a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f417739b, r101.f417739b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f417740c, r101.f417740c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f417741d, r101.f417741d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f417742e, r101.f417742e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f417743f, r101.f417743f) == true) goto L27;
        return false;
    L27:
        if (this.f417744g == r101.f417744g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f417738a.hashCode() * 31) + this.f417739b.hashCode()) * 31) + this.f417740c.hashCode()) * 31) + this.f417741d.hashCode()) * 31) + this.f417742e.hashCode()) * 31) + this.f417743f.hashCode()) * 31;
        long r101 = this.f417744g;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GroupQrCodeState(loadState=" + this.f417738a + ", url=" + this.f417739b + ", chatId=" + this.f417740c + ", avatarKey=" + this.f417741d + ", chatName=" + this.f417742e + ", ownerName=" + this.f417743f + ", expireTime=" + this.f417744g + ')';
    }

    public /* synthetic */ a(String r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        LoadState r100 = LoadState.IDLE;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r105 = "";
    L26:
        this(r100, r101, r102, r103, r104, r105, 0);
        return;
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = r112;
        goto L23
    L17:
        r103 = r111;
        goto L19
    L13:
        r102 = r110;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public static a a(a r100, LoadState r110, String r111, String r112, long r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r110 = r100.f417738a;
    L5:
        LoadState r101 = r110;
        if ((r114 & 2) == 0) goto L8;
        r111 = r100.f417739b;
    L8:
        String r102 = r111;
        if ((r114 & 4) == 0) goto L11;
        String r103 = r100.f417740c;
    L13:
        if ((r114 & 8) == 0) goto L15;
        String r104 = r100.f417741d;
    L17:
        if ((r114 & 16) == 0) goto L19;
        String r105 = r100.f417742e;
    L21:
        if ((r114 & 32) == 0) goto L23;
        r112 = r100.f417743f;
    L23:
        String r106 = r112;
        if ((r114 & 64) == 0) goto L26;
        r113 = r100.f417744g;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "loadState");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "chatId");
        Intrinsics.checkNotNullParameter(r104, "avatarKey");
        Intrinsics.checkNotNullParameter(r105, "chatName");
        Intrinsics.checkNotNullParameter(r106, "ownerName");
        return new a(r101, r102, r103, r104, r105, r106, r113);
    L19:
        r105 = null;
        goto L21
    L15:
        r104 = null;
        goto L17
    L11:
        r103 = null;
        goto L13
    }

    public a(LoadState r100, String r101, String r102, String r103, String r104, String r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "loadState");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "chatId");
        Intrinsics.checkNotNullParameter(r103, "avatarKey");
        Intrinsics.checkNotNullParameter(r104, "chatName");
        Intrinsics.checkNotNullParameter(r105, "ownerName");
        this.f417738a = r100;
        this.f417739b = r101;
        this.f417740c = r102;
        this.f417741d = r103;
        this.f417742e = r104;
        this.f417743f = r105;
        this.f417744g = r106;
    }
}
