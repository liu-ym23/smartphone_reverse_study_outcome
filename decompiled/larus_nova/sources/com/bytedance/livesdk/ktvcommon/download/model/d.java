package com.bytedance.livesdk.ktvcommon.download.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MusicType f255958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f255959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f255960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f255961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f255962g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f255956a, r101.f255956a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255957b, r101.f255957b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255958c, r101.f255958c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255959d, r101.f255959d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f255960e, r101.f255960e) == true) goto L16;
        return false;
    L16:
        if (this.f255961f == r101.f255961f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f255962g, r101.f255962g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f255956a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255957b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        MusicType r107 = this.f255958c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f255959d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f255960e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.f255961f) * 31;
        String r116 = this.f255962g;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "DownloadResult(taskId=" + this.f255956a + ", songId=" + this.f255957b + ", resourceType=" + this.f255958c + ", url=" + this.f255959d + ", localPath=" + this.f255960e + ", errorCode=" + this.f255961f + ", errorMsg=" + this.f255962g + ")";
    }

    public d(String r100, String r101, MusicType r102, String r103, String r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "resourceType");
        Intrinsics.checkNotNullParameter(r103, "url");
        Intrinsics.checkNotNullParameter(r104, "localPath");
        Intrinsics.checkNotNullParameter(r106, "errorMsg");
        this.f255956a = r100;
        this.f255957b = r101;
        this.f255958c = r102;
        this.f255959d = r103;
        this.f255960e = r104;
        this.f255961f = r105;
        this.f255962g = r106;
    }
}
