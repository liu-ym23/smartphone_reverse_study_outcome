package com.larus.bmhome.rc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/rc/FileResourceMeta;", "", "fileName", "", "md5", LocationMonitorConst.IDENTIFIER, "url", "size", "", "parseExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getMd5", "getIdentifier", "getUrl", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParseExtra", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/bmhome/rc/FileResourceMeta;", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileResourceMeta {

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private final String identifier;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private final String f313536md5;

    @SerializedName("parse_extra")
    private final String parseExtra;

    @SerializedName("size")
    private final Long size;

    @SerializedName("url")
    private final String url;

    public FileResourceMeta() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FileResourceMeta copy$default(FileResourceMeta r100, String r101, String r102, String r103, String r104, Long r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.fileName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f313536md5;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.identifier;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.url;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.size;
    L17:
        Long r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.parseExtra;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.fileName;
    }

    public final String component2() {
        return this.f313536md5;
    }

    public final String component3() {
        return this.identifier;
    }

    public final String component4() {
        return this.url;
    }

    public final Long component5() {
        return this.size;
    }

    public final String component6() {
        return this.parseExtra;
    }

    public final FileResourceMeta copy(String r100, String r110, String r111, String r112, Long r113, String r114) {
        return new FileResourceMeta(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileResourceMeta) == true) goto L8;
        return false;
    L8:
        FileResourceMeta r101 = (FileResourceMeta) r100;
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313536md5, r101.f313536md5) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.identifier, r101.identifier) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parseExtra, r101.parseExtra) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.fileName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f313536md5;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.identifier;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.url;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.size;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.parseExtra;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "FileResourceMeta(fileName=" + this.fileName + ", md5=" + this.f313536md5 + ", identifier=" + this.identifier + ", url=" + this.url + ", size=" + this.size + ", parseExtra=" + this.parseExtra + ')';
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getMd5() {
        return this.f313536md5;
    }

    public final String getParseExtra() {
        return this.parseExtra;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public FileResourceMeta(String r100, String r101, String r102, String r103, Long r104, String r105) {
        this.fileName = r100;
        this.f313536md5 = r101;
        this.identifier = r102;
        this.url = r103;
        this.size = r104;
        this.parseExtra = r105;
    }

    public /* synthetic */ FileResourceMeta(String r100, String r101, String r102, String r103, Long r110, String r111, int r112, DefaultConstructorMarker r113) {
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
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        r110 = 0L;
    L21:
        Long r107 = r110;
        if ((r112 & 32) == 0) goto L24;
        String r115 = null;
    L25:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
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
