package com.larus.platform.api.fileselect;

import com.google.gson.Gson;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/larus/platform/api/fileselect/DriveUplinkInfo;", "Ljava/io/Serializable;", "url", "", "fileToken", "fileName", "fileType", "", "ccmType", "uplinkWay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getFileToken", "getFileName", "getFileType", "()I", "getCcmType", "getUplinkWay", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveUplinkInfo implements Serializable {
    private final int ccmType;
    private final String fileName;
    private final String fileToken;
    private final int fileType;
    private final String uplinkWay;
    private final String url;

    public DriveUplinkInfo() {
        this(null, null, null, 0, 0, null, 63, null);
    }

    public static /* synthetic */ DriveUplinkInfo copy$default(DriveUplinkInfo r100, String r101, String r102, String r103, int r104, int r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.fileToken;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.fileName;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.fileType;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.ccmType;
    L17:
        int r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.uplinkWay;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.fileToken;
    }

    public final String component3() {
        return this.fileName;
    }

    public final int component4() {
        return this.fileType;
    }

    public final int component5() {
        return this.ccmType;
    }

    public final String component6() {
        return this.uplinkWay;
    }

    public final DriveUplinkInfo copy(String r100, String r110, String r111, int r112, int r113, String r114) {
        return new DriveUplinkInfo(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DriveUplinkInfo) == true) goto L8;
        return false;
    L8:
        DriveUplinkInfo r101 = (DriveUplinkInfo) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L18;
        return false;
    L18:
        if (this.fileType == r101.fileType) goto L21;
        return false;
    L21:
        if (this.ccmType == r101.ccmType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uplinkWay, r101.uplinkWay) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.fileToken;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.fileName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((((r106 + r108) * 31) + this.fileType) * 31) + this.ccmType) * 31;
        String r110 = this.uplinkWay;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(new Gson().toJson(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final int getCcmType() {
        return this.ccmType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getUplinkWay() {
        return this.uplinkWay;
    }

    public final String getUrl() {
        return this.url;
    }

    public DriveUplinkInfo(String r100, String r101, String r102, int r103, int r104, String r105) {
        this.url = r100;
        this.fileToken = r101;
        this.fileName = r102;
        this.fileType = r103;
        this.ccmType = r104;
        this.uplinkWay = r105;
    }

    public /* synthetic */ DriveUplinkInfo(String r100, String r101, String r102, int r103, int r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r106 = 0;
    L19:
        if ((r112 & 16) == 0) goto L21;
        int r107 = 12;
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
