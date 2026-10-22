package com.bytedance.bmf_mods.downloader.custom.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JM\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/bmf_mods/downloader/custom/bean/CakeCook;", "", "name", "", "version", "type", "", "status", "fileType", "fileUrl", "Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;)V", "getFileType", "()Ljava/lang/String;", "getFileUrl", "()Lcom/bytedance/bmf_mods/downloader/custom/bean/FileUrl;", "getName", "getStatus", "()I", "getType", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "bmf_mods_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CakeCook {

    @SerializedName("file_type")
    private final String fileType;

    @SerializedName(ShareType.FILE_URL)
    private final FileUrl fileUrl;

    @SerializedName("name")
    private final String name;

    @SerializedName("status")
    private final int status;

    @SerializedName("type")
    private final int type;

    @SerializedName("version")
    private final String version;

    public CakeCook() {
        this(null, null, 0, 0, null, null, 63, null);
    }

    public static /* synthetic */ CakeCook copy$default(CakeCook r100, String r101, String r102, int r103, int r104, String r105, FileUrl r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.name;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.version;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.type;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.status;
    L14:
        int r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.fileType;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.fileUrl;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.version;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.status;
    }

    public final String component5() {
        return this.fileType;
    }

    public final FileUrl component6() {
        return this.fileUrl;
    }

    public final CakeCook copy(String r100, String r110, int r111, int r112, String r113, FileUrl r114) {
        return new CakeCook(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CakeCook) == true) goto L8;
        return false;
    L8:
        CakeCook r101 = (CakeCook) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L18;
        return false;
    L18:
        if (this.status == r101.status) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileType, r101.fileType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fileUrl, r101.fileUrl) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.version;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.type) * 31) + this.status) * 31;
        String r107 = this.fileType;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        FileUrl r110 = this.fileUrl;
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
        return "CakeCook(name=" + this.name + ", version=" + this.version + ", type=" + this.type + ", status=" + this.status + ", fileType=" + this.fileType + ", fileUrl=" + this.fileUrl + ')';
    }

    public final String getFileType() {
        return this.fileType;
    }

    public final FileUrl getFileUrl() {
        return this.fileUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public CakeCook(String r100, String r101, int r102, int r103, String r104, FileUrl r105) {
        this.name = r100;
        this.version = r101;
        this.type = r102;
        this.status = r103;
        this.fileType = r104;
        this.fileUrl = r105;
    }

    public /* synthetic */ CakeCook(String r100, String r101, int r102, int r103, String r110, FileUrl r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r112 & 8) == 0) goto L17;
        int r106 = 1;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        FileUrl r115 = null;
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
