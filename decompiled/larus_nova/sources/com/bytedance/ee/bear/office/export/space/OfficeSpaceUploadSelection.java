package com.bytedance.ee.bear.office.export.space;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012JD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "Ljava/io/Serializable;", "filePointer", "", "isFileUseUri", "", CommonConstant.KEY_DISPLAY_NAME, DBDefinition.MIME_TYPE, "size", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getFilePointer", "()Ljava/lang/String;", "()Z", "getDisplayName", "getMimeType", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/bytedance/ee/bear/office/export/space/OfficeSpaceUploadSelection;", "equals", "other", "", "hashCode", "", "toString", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSpaceUploadSelection implements Serializable {
    private final String displayName;
    private final String filePointer;
    private final boolean isFileUseUri;
    private final String mimeType;
    private final Long size;

    public static /* synthetic */ OfficeSpaceUploadSelection copy$default(OfficeSpaceUploadSelection r100, String r101, boolean r102, String r103, String r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.filePointer;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.isFileUseUri;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.displayName;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.mimeType;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.size;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final OfficeSpaceUploadSelection copy(String r100, boolean r101, String r110, String r111, Long r112) {
        Intrinsics.checkNotNullParameter(r100, "filePointer");
        Intrinsics.checkNotNullParameter(r110, CommonConstant.KEY_DISPLAY_NAME);
        return new OfficeSpaceUploadSelection(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeSpaceUploadSelection) == true) goto L8;
        return false;
    L8:
        OfficeSpaceUploadSelection r101 = (OfficeSpaceUploadSelection) r100;
        if (Intrinsics.areEqual(this.filePointer, r101.filePointer) == true) goto L12;
        return false;
    L12:
        if (this.isFileUseUri == r101.isFileUseUri) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mimeType, r101.mimeType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.filePointer.hashCode() * 31;
        if (this.isFileUseUri == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.displayName.hashCode()) * 31;
        String r103 = this.mimeType;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        Long r107 = this.size;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return r106 + r104;
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
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

    public OfficeSpaceUploadSelection(String r100, boolean r101, String r102, String r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "filePointer");
        Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
        this.filePointer = r100;
        this.isFileUseUri = r101;
        this.displayName = r102;
        this.mimeType = r103;
        this.size = r104;
    }
}
