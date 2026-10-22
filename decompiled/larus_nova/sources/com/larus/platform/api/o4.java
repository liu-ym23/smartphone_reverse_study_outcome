package com.larus.platform.api;

import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f365215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThirdPartyMusicPlatform f365216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f365218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f365219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f365221g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o4) == true) goto L8;
        return false;
    L8:
        o4 r101 = (o4) r100;
        if (this.f365215a == r101.f365215a) goto L12;
        return false;
    L12:
        if (this.f365216b == r101.f365216b) goto L15;
        return false;
    L15:
        if (this.f365217c == r101.f365217c) goto L18;
        return false;
    L18:
        if (this.f365218d == r101.f365218d) goto L21;
        return false;
    L21:
        if (this.f365219e == r101.f365219e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365220f, r101.f365220f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f365221g, r101.f365221g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f365215a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f365216b.hashCode()) * 31;
        if (this.f365217c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f365218d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f365219e == true) goto L18;
        r100 = 1237;
    L18:
        int r107 = (((r106 + r100) * 31) + this.f365220f.hashCode()) * 31;
        String r108 = this.f365221g;
        if (r108 != null) goto L21;
        int r109 = 0;
    L23:
        return r107 + r109;
    L21:
        r109 = r108.hashCode();
        goto L23
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
        return "MusicAuthResultData(isNeedReSendOrReply=" + this.f365215a + ", authSource=" + this.f365216b + ", isMessageIdFromQuery=" + this.f365217c + ", result=" + this.f365218d + ", isRefused=" + this.f365219e + ", messageId=" + this.f365220f + ", cvsId=" + this.f365221g + ')';
    }

    public o4(boolean r100, ThirdPartyMusicPlatform r101, boolean r102, boolean r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "authSource");
        Intrinsics.checkNotNullParameter(r105, "messageId");
        this.f365215a = r100;
        this.f365216b = r101;
        this.f365217c = r102;
        this.f365218d = r103;
        this.f365219e = r104;
        this.f365220f = r105;
        this.f365221g = null;
    }
}
