package com.bytedance.livesdk.ktvcommon.download.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f255963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f255964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f255965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f255966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadState f255967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DownloadPriority f255968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f255969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f255970h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f255971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f255972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f255973k;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L28;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f255963a, r101.f255963a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255964b, r101.f255964b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f255965c, r101.f255965c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255966d, r101.f255966d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f255967e, r101.f255967e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f255968f, r101.f255968f) == true) goto L18;
        return false;
    L18:
        if (this.f255969g == r101.f255969g) goto L20;
        return false;
    L20:
        if (this.f255970h == r101.f255970h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f255971i, r101.f255971i) == true) goto L24;
        return false;
    L24:
        if (this.f255972j == r101.f255972j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f255973k, r101.f255973k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f255963a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f255964b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f255965c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        f r110 = this.f255966d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        DownloadState r113 = this.f255967e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        DownloadPriority r116 = this.f255968f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.f255969g;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f255970h;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        List<String> r123 = this.f255971i;
        if (r123 == null) goto L29;
        int r124 = r123.hashCode();
    L30:
        int r125 = (((r122 + r124) * 31) + this.f255972j) * 31;
        String r126 = this.f255973k;
        if (r126 == null) goto L34;
        r101 = r126.hashCode();
    L34:
        return r125 + r101;
    L29:
        r124 = 0;
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
        return "DownloadTaskInfo(taskId=" + this.f255963a + ", batchId=" + this.f255964b + ", songId=" + this.f255965c + ", param=" + this.f255966d + ", state=" + this.f255967e + ", priority=" + this.f255968f + ", submitTime=" + this.f255969g + ", lastActiveTime=" + this.f255970h + ", batchIds=" + this.f255971i + ", progress=" + this.f255972j + ", downloadId=" + this.f255973k + ")";
    }

    public e(String r100, String r101, String r102, f r103, DownloadState r104, DownloadPriority r105, long r106, long r110, List r111) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "batchId");
        Intrinsics.checkNotNullParameter(r102, "songId");
        Intrinsics.checkNotNullParameter(r103, "param");
        Intrinsics.checkNotNullParameter(r104, "state");
        Intrinsics.checkNotNullParameter(r105, "priority");
        Intrinsics.checkNotNullParameter(r111, "batchIds");
        Intrinsics.checkNotNullParameter("", "downloadId");
        this.f255963a = r100;
        this.f255964b = r101;
        this.f255965c = r102;
        this.f255966d = r103;
        this.f255967e = r104;
        this.f255968f = r105;
        this.f255969g = r106;
        this.f255970h = r110;
        this.f255971i = r111;
        this.f255972j = 0;
        this.f255973k = "";
    }
}
