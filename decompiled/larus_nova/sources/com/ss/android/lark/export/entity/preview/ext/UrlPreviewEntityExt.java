package com.ss.android.lark.export.entity.preview.ext;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt;", "Ljava/io/Serializable;", "docInfo", "Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$DocInfo;", "rootIdVariant", "Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$UrlPreviewComponentRootDisplayVariant;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$DocInfo;Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$UrlPreviewComponentRootDisplayVariant;)V", "getDocInfo", "()Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$DocInfo;", "getRootIdVariant", "()Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$UrlPreviewComponentRootDisplayVariant;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "DocInfo", "UrlPreviewComponentRootDisplayVariant", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewEntityExt implements Serializable {
    private final DocInfo docInfo;
    private final UrlPreviewComponentRootDisplayVariant rootIdVariant;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$DocInfo;", "Ljava/io/Serializable;", "fileName", "", "fileToken", "fileType", "", "mountPoint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getFileName", "()Ljava/lang/String;", "getFileToken", "getFileType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMountPoint", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$DocInfo;", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DocInfo implements Serializable {
        private final String fileName;
        private final String fileToken;
        private final Long fileType;
        private final String mountPoint;

        public static /* synthetic */ DocInfo copy$default(DocInfo r100, String r101, String r102, Long r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.fileName;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.fileToken;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.fileType;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.mountPoint;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.fileName;
        }

        public final String component2() {
            return this.fileToken;
        }

        public final Long component3() {
            return this.fileType;
        }

        public final String component4() {
            return this.mountPoint;
        }

        public final DocInfo copy(String r100, String r101, Long r102, String r103) {
            return new DocInfo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof DocInfo) == true) goto L8;
            return false;
        L8:
            DocInfo r101 = (DocInfo) r100;
            if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.fileType, r101.fileType) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.mountPoint, r101.mountPoint) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r100 = this.fileName;
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
            Long r107 = this.fileType;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.mountPoint;
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
            return "DocInfo(fileName=" + this.fileName + ", fileToken=" + this.fileToken + ", fileType=" + this.fileType + ", mountPoint=" + this.mountPoint + ')';
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getFileToken() {
            return this.fileToken;
        }

        public final Long getFileType() {
            return this.fileType;
        }

        public final String getMountPoint() {
            return this.mountPoint;
        }

        public DocInfo(String r100, String r101, Long r102, String r103) {
            this.fileName = r100;
            this.fileToken = r101;
            this.fileType = r102;
            this.mountPoint = r103;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ext/UrlPreviewEntityExt$UrlPreviewComponentRootDisplayVariant;", "Ljava/io/Serializable;", "defaultRootId", "", "compactRootId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDefaultRootId", "()Ljava/lang/String;", "getCompactRootId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UrlPreviewComponentRootDisplayVariant implements Serializable {
        private final String compactRootId;
        private final String defaultRootId;

        public static /* synthetic */ UrlPreviewComponentRootDisplayVariant copy$default(UrlPreviewComponentRootDisplayVariant r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.defaultRootId;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.compactRootId;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.defaultRootId;
        }

        public final String component2() {
            return this.compactRootId;
        }

        public final UrlPreviewComponentRootDisplayVariant copy(String r100, String r101) {
            return new UrlPreviewComponentRootDisplayVariant(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UrlPreviewComponentRootDisplayVariant) == true) goto L8;
            return false;
        L8:
            UrlPreviewComponentRootDisplayVariant r101 = (UrlPreviewComponentRootDisplayVariant) r100;
            if (Intrinsics.areEqual(this.defaultRootId, r101.defaultRootId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.compactRootId, r101.compactRootId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r100 = this.defaultRootId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.compactRootId;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "UrlPreviewComponentRootDisplayVariant(defaultRootId=" + this.defaultRootId + ", compactRootId=" + this.compactRootId + ')';
        }

        public final String getCompactRootId() {
            return this.compactRootId;
        }

        public final String getDefaultRootId() {
            return this.defaultRootId;
        }

        public UrlPreviewComponentRootDisplayVariant(String r100, String r101) {
            this.defaultRootId = r100;
            this.compactRootId = r101;
        }
    }

    public static /* synthetic */ UrlPreviewEntityExt copy$default(UrlPreviewEntityExt r100, DocInfo r101, UrlPreviewComponentRootDisplayVariant r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.docInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.rootIdVariant;
    L9:
        return r100.copy(r101, r102);
    }

    public final DocInfo component1() {
        return this.docInfo;
    }

    public final UrlPreviewComponentRootDisplayVariant component2() {
        return this.rootIdVariant;
    }

    public final UrlPreviewEntityExt copy(DocInfo r100, UrlPreviewComponentRootDisplayVariant r101) {
        return new UrlPreviewEntityExt(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewEntityExt) == true) goto L8;
        return false;
    L8:
        UrlPreviewEntityExt r101 = (UrlPreviewEntityExt) r100;
        if (Intrinsics.areEqual(this.docInfo, r101.docInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rootIdVariant, r101.rootIdVariant) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        DocInfo r100 = this.docInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlPreviewComponentRootDisplayVariant r104 = this.rootIdVariant;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UrlPreviewEntityExt(docInfo=" + this.docInfo + ", rootIdVariant=" + this.rootIdVariant + ')';
    }

    public final DocInfo getDocInfo() {
        return this.docInfo;
    }

    public final UrlPreviewComponentRootDisplayVariant getRootIdVariant() {
        return this.rootIdVariant;
    }

    public UrlPreviewEntityExt(DocInfo r100, UrlPreviewComponentRootDisplayVariant r101) {
        this.docInfo = r100;
        this.rootIdVariant = r101;
    }
}
