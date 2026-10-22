package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "Ljava/io/Serializable;", "filePointer", "", "isFileUseUri", "", "displayName", "mimeType", "size", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getFilePointer", "()Ljava/lang/String;", "()Z", "getDisplayName", "getMimeType", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "equals", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceUploadSelection implements Serializable {
    private final String displayName;
    private final String filePointer;
    private final boolean isFileUseUri;
    private final String mimeType;
    private final Long size;

    public static /* synthetic */ OfficeSpaceUploadSelection copy$default(OfficeSpaceUploadSelection r3, String r4, boolean r5, String r6, String r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.filePointer;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.isFileUseUri;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.displayName;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.mimeType;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.size;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.filePointer;
    }

    public final boolean component2() {
        return this.isFileUseUri;
    }

    public final String component3() {
        return this.displayName;
    }

    public final String component4() {
        return this.mimeType;
    }

    public final Long component5() {
        return this.size;
    }

    public final OfficeSpaceUploadSelection copy(String r8, boolean r9, String r10, String r11, Long r12) {
        Intrinsics.checkNotNullParameter(r8, "filePointer");
        Intrinsics.checkNotNullParameter(r10, "displayName");
        return new OfficeSpaceUploadSelection(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSpaceUploadSelection) == true) goto L8;
        return false;
    L8:
        OfficeSpaceUploadSelection r6 = (OfficeSpaceUploadSelection) r5;
        if (Intrinsics.areEqual(this.filePointer, r6.filePointer) == true) goto L12;
        return false;
    L12:
        if (this.isFileUseUri == r6.isFileUseUri) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mimeType, r6.mimeType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.filePointer.hashCode() * 31;
        if (this.isFileUseUri == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.displayName.hashCode()) * 31;
        String r3 = this.mimeType;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        Long r7 = this.size;
        if (r7 == null) goto L15;
        r4 = r7.hashCode();
    L15:
        return r6 + r4;
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeSpaceUploadSelection(filePointer=" + this.filePointer + ", isFileUseUri=" + this.isFileUseUri + ", displayName=" + this.displayName + ", mimeType=" + this.mimeType + ", size=" + this.size + ')';
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getFilePointer() {
        return this.filePointer;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Long getSize() {
        return this.size;
    }

    public final boolean isFileUseUri() {
        return this.isFileUseUri;
    }

    public OfficeSpaceUploadSelection(String r2, boolean r3, String r4, String r5, Long r6) {
        Intrinsics.checkNotNullParameter(r2, "filePointer");
        Intrinsics.checkNotNullParameter(r4, "displayName");
        this.filePointer = r2;
        this.isFileUseUri = r3;
        this.displayName = r4;
        this.mimeType = r5;
        this.size = r6;
    }
}
