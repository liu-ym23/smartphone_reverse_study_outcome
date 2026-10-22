package com.bytedance.livesdk.ktvcommon.download.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f255974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MusicType f255976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f255977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f255978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f255979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f255980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f255981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f255982i;

    public f() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L24;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f255974a, r101.f255974a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255975b, r101.f255975b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255976c, r101.f255976c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255977d, r101.f255977d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f255978e, r101.f255978e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f255979f, r101.f255979f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f255980g, r101.f255980g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f255981h, r101.f255981h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f255982i, r101.f255982i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        m r100 = this.f255974a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255975b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MusicType r107 = this.f255976c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f255977d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f255978e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f255979f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f255980g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f255981h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f255982i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DownloadTaskParam(musicInfo=" + this.f255974a + ", songId=" + this.f255975b + ", resourceType=" + this.f255976c + ", url=" + this.f255977d + ", savePath=" + this.f255978e + ", fileName=" + this.f255979f + ", monitorScene=" + this.f255980g + ", extra=" + this.f255981h + ", localPath=" + this.f255982i + ")";
    }

    public f(m r100, String r101, MusicType r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "musicInfo");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r104, DBDefinition.SAVE_PATH);
        Intrinsics.checkNotNullParameter(r105, "fileName");
        Intrinsics.checkNotNullParameter(r106, DBDefinition.MONITOR_SCENE);
        Intrinsics.checkNotNullParameter("", "localPath");
        this.f255974a = r100;
        this.f255975b = r101;
        this.f255976c = r102;
        this.f255977d = r103;
        this.f255978e = r104;
        this.f255979f = r105;
        this.f255980g = r106;
        this.f255981h = null;
        this.f255982i = "";
        this.f255982i = r104 + '/' + r105;
    }
}
