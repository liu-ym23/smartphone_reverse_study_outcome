package com.larus.dora.impl.ota.g2;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e5 {
    private final String backupUrl;
    private final List<String> backupUrls;
    private final long buildTime;
    private final String descriptionDetail;
    private final String descriptionText;
    private final String descriptionType;
    private final String fileName;
    private final d5 identity;
    private final String mainUrl;
    private final boolean nuttxFirmware;
    private final String taskId;
    private final String traceId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e5) == true) goto L8;
        return false;
    L8:
        e5 r101 = (e5) r100;
        if (Intrinsics.areEqual(this.identity, r101.identity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainUrl, r101.mainUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backupUrl, r101.backupUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.backupUrls, r101.backupUrls) == true) goto L30;
        return false;
    L30:
        if (this.buildTime == r101.buildTime) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.descriptionText, r101.descriptionText) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.descriptionType, r101.descriptionType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.descriptionDetail, r101.descriptionDetail) == true) goto L42;
        return false;
    L42:
        if (this.nuttxFirmware == r101.nuttxFirmware) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.identity.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.mainUrl.hashCode()) * 31) + this.backupUrl.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.backupUrls.hashCode()) * 31;
        long r101 = this.buildTime;
        int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.descriptionText.hashCode()) * 31) + this.descriptionType.hashCode()) * 31) + this.descriptionDetail.hashCode()) * 31;
        if (this.nuttxFirmware == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public final String toString() {
        return "PackageSpec(identity=" + this.identity + ", fileName=" + this.fileName + ", mainUrl=" + this.mainUrl + ", backupUrl=" + this.backupUrl + ", traceId=" + this.traceId + ", taskId=" + this.taskId + ", backupUrls=" + this.backupUrls + ", buildTime=" + this.buildTime + ", descriptionText=" + this.descriptionText + ", descriptionType=" + this.descriptionType + ", descriptionDetail=" + this.descriptionDetail + ", nuttxFirmware=" + this.nuttxFirmware + ')';
    }

    public final String a() {
        return this.backupUrl;
    }

    public final List<String> b() {
        return this.backupUrls;
    }

    public final long c() {
        return this.buildTime;
    }

    public final String d() {
        return this.descriptionDetail;
    }

    public final String e() {
        return this.descriptionText;
    }

    public final String f() {
        return this.descriptionType;
    }

    public final String g() {
        return this.fileName;
    }

    public final d5 h() {
        return this.identity;
    }

    public final String i() {
        return this.mainUrl;
    }

    public final boolean j() {
        return this.nuttxFirmware;
    }

    public final String k() {
        return this.taskId;
    }

    public final String l() {
        return this.traceId;
    }

    public e5(d5 r100, String r101, String r102, String r103, String r104, String r105, List<String> r106, long r107, String r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, DownloadHelper.IDENTITY);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "mainUrl");
        Intrinsics.checkNotNullParameter(r103, "backupUrl");
        Intrinsics.checkNotNullParameter(r104, "traceId");
        Intrinsics.checkNotNullParameter(r105, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r106, "backupUrls");
        Intrinsics.checkNotNullParameter(r110, "descriptionText");
        Intrinsics.checkNotNullParameter(r111, "descriptionType");
        Intrinsics.checkNotNullParameter(r112, "descriptionDetail");
        this.identity = r100;
        this.fileName = r101;
        this.mainUrl = r102;
        this.backupUrl = r103;
        this.traceId = r104;
        this.taskId = r105;
        this.backupUrls = r106;
        this.buildTime = r107;
        this.descriptionText = r110;
        this.descriptionType = r111;
        this.descriptionDetail = r112;
        this.nuttxFirmware = r113;
    }
}
