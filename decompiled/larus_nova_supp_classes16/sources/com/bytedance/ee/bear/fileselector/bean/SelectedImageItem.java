package com.bytedance.ee.bear.fileselector.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/bean/SelectedImageItem;", "Ljava/io/Serializable;", "uuid", "", "imgFile", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getUuid", "()Ljava/lang/String;", "setUuid", "(Ljava/lang/String;)V", "getImgFile", "setImgFile", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedImageItem implements Serializable {
    private int height;
    private String imgFile;
    private String uuid;
    private int width;

    public static /* synthetic */ SelectedImageItem copy$default(SelectedImageItem r0, String r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.uuid;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.imgFile;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.width;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.height;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.uuid;
    }

    public final String component2() {
        return this.imgFile;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final SelectedImageItem copy(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "imgFile");
        return new SelectedImageItem(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SelectedImageItem) == true) goto L8;
        return false;
    L8:
        SelectedImageItem r6 = (SelectedImageItem) r5;
        if (Intrinsics.areEqual(this.uuid, r6.uuid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imgFile, r6.imgFile) == true) goto L15;
        return false;
    L15:
        if (this.width == r6.width) goto L18;
        return false;
    L18:
        if (this.height == r6.height) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.uuid.hashCode() * 31) + this.imgFile.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        return "SelectedImageItem(uuid=" + this.uuid + ", imgFile=" + this.imgFile + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getImgFile() {
        return this.imgFile;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r1) {
        this.height = r1;
    }

    public final void setImgFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imgFile = r2;
    }

    public final void setUuid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uuid = r2;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }

    public SelectedImageItem(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "uuid");
        Intrinsics.checkNotNullParameter(r3, "imgFile");
        this.uuid = r2;
        this.imgFile = r3;
        this.width = r4;
        this.height = r5;
    }
}
