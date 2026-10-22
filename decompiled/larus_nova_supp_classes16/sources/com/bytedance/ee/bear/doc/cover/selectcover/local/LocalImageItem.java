package com.bytedance.ee.bear.doc.cover.selectcover.local;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001e¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/local/LocalImageItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "contentType", "", "uuid", "filePath", "fileName", "fileSize", "", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JII)V", "getContentType", "()Ljava/lang/String;", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getFilePath", "setFilePath", "getFileName", "setFileName", "getFileSize", "()J", "setFileSize", "(J)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalImageItem implements NonProguard {
    private final String contentType;
    private String fileName;
    private String filePath;
    private long fileSize;
    private int height;
    private String uuid;
    private int width;

    public static /* synthetic */ LocalImageItem copy$default(LocalImageItem r9, String r10, String r11, String r12, String r13, long r14, int r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.contentType;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.uuid;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.filePath;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r4 = r9.fileName;
    L19:
        if ((r18 & 16) == 0) goto L21;
        long r5 = r9.fileSize;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.width;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.height;
    L31:
        return r9.copy(r1, r2, r3, r4, r5, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r5 = r14;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
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

    public final LocalImageItem copy(String r11, String r12, String r13, String r14, long r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "contentType");
        Intrinsics.checkNotNullParameter(r12, "uuid");
        Intrinsics.checkNotNullParameter(r13, "filePath");
        Intrinsics.checkNotNullParameter(r14, "fileName");
        return new LocalImageItem(r11, r12, r13, r14, r16, r17, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LocalImageItem) == true) goto L8;
        return false;
    L8:
        LocalImageItem r9 = (LocalImageItem) r8;
        if (Intrinsics.areEqual(this.contentType, r9.contentType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uuid, r9.uuid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filePath, r9.filePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L21;
        return false;
    L21:
        if (this.fileSize == r9.fileSize) goto L24;
        return false;
    L24:
        if (this.width == r9.width) goto L27;
        return false;
    L27:
        if (this.height == r9.height) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.contentType.hashCode() * 31) + this.uuid.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31;
        long r1 = this.fileSize;
        return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.width) * 31) + this.height;
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

    public final void setFileName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setFilePath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.filePath = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setUuid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uuid = r2;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public LocalImageItem(String r2, String r3, String r4, String r5, long r6, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "contentType");
        Intrinsics.checkNotNullParameter(r3, "uuid");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r5, "fileName");
        this.contentType = r2;
        this.uuid = r3;
        this.filePath = r4;
        this.fileName = r5;
        this.fileSize = r6;
        this.width = r8;
        this.height = r9;
    }
}
