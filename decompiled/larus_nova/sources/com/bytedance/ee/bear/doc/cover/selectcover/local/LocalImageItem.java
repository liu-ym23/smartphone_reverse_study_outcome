package com.bytedance.ee.bear.doc.cover.selectcover.local;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "contentType", "", ST.UUID_DEVICE, "filePath", "fileName", "fileSize", "", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JII)V", "getContentType", "()Ljava/lang/String;", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "getFileName", "setFileName", "getFileSize", "()J", "setFileSize", "(J)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalImageItem implements NonProguard {
    private final String contentType;
    private String fileName;
    private String filePath;
    private long fileSize;
    private int height;
    private String uuid;
    private int width;

    public static /* synthetic */ LocalImageItem copy$default(LocalImageItem r100, String r110, String r111, String r112, String r113, long r114, int r115, int r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.contentType;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.uuid;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.filePath;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.fileName;
    L19:
        if ((r117 & 16) == 0) goto L21;
        long r105 = r100.fileSize;
    L23:
        if ((r117 & 32) == 0) goto L25;
        int r106 = r100.width;
    L27:
        if ((r117 & 64) == 0) goto L29;
        int r107 = r100.height;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.contentType;
    }

    public final String component2() {
        return this.uuid;
    }

    public final String component3() {
        return this.filePath;
    }

    public final String component4() {
        return this.fileName;
    }

    public final long component5() {
        return this.fileSize;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final LocalImageItem copy(String r110, String r111, String r112, String r113, long r114, int r115, int r116) {
        Intrinsics.checkNotNullParameter(r110, "contentType");
        Intrinsics.checkNotNullParameter(r111, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r112, "filePath");
        Intrinsics.checkNotNullParameter(r113, "fileName");
        return new LocalImageItem(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalImageItem) == true) goto L8;
        return false;
    L8:
        LocalImageItem r101 = (LocalImageItem) r100;
        if (Intrinsics.areEqual(this.contentType, r101.contentType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uuid, r101.uuid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L21;
        return false;
    L21:
        if (this.fileSize == r101.fileSize) goto L24;
        return false;
    L24:
        if (this.width == r101.width) goto L27;
        return false;
    L27:
        if (this.height == r101.height) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.contentType.hashCode() * 31) + this.uuid.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31;
        long r101 = this.fileSize;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "LocalImageItem(contentType=" + this.contentType + ", uuid=" + this.uuid + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setFileName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileName = r100;
    }

    public final void setFilePath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.filePath = r100;
    }

    public final void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setUuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uuid = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public LocalImageItem(String r100, String r101, String r102, String r103, long r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r102, "filePath");
        Intrinsics.checkNotNullParameter(r103, "fileName");
        this.contentType = r100;
        this.uuid = r101;
        this.filePath = r102;
        this.fileName = r103;
        this.fileSize = r104;
        this.width = r105;
        this.height = r106;
    }
}
