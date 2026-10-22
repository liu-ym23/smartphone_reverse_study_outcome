package com.larus.platform.model.album;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0017JH\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "Ljava/io/Serializable;", "type", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "width", "", "height", "durationSeconds", "", "fileSize", "", "<init>", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;)V", "getType", "()Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getDurationSeconds", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Long;)Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "equals", "", "other", "", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationReferenceAlbumAttachment implements Serializable {
    private final Double durationSeconds;
    private final Long fileSize;
    private final Integer height;
    private final CreationReferenceAlbumMediaType type;
    private final Integer width;

    public static /* synthetic */ CreationReferenceAlbumAttachment copy$default(CreationReferenceAlbumAttachment r100, CreationReferenceAlbumMediaType r101, Integer r102, Integer r103, Double r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        Integer r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        Integer r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.durationSeconds;
    L14:
        Double r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.fileSize;
    L17:
        CreationReferenceAlbumMediaType r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final CreationReferenceAlbumMediaType component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final Double component4() {
        return this.durationSeconds;
    }

    public final Long component5() {
        return this.fileSize;
    }

    public final CreationReferenceAlbumAttachment copy(CreationReferenceAlbumMediaType r100, Integer r101, Integer r110, Double r111, Long r112) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new CreationReferenceAlbumAttachment(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationReferenceAlbumAttachment) == true) goto L8;
        return false;
    L8:
        CreationReferenceAlbumAttachment r101 = (CreationReferenceAlbumAttachment) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.durationSeconds, r101.durationSeconds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.type.hashCode() * 31;
        Integer r101 = this.width;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.height;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Double r108 = this.durationSeconds;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.fileSize;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationReferenceAlbumAttachment(type=" + this.type + ", width=" + this.width + ", height=" + this.height + ", durationSeconds=" + this.durationSeconds + ", fileSize=" + this.fileSize + ')';
    }

    public final Double getDurationSeconds() {
        return this.durationSeconds;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final CreationReferenceAlbumMediaType getType() {
        return this.type;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public CreationReferenceAlbumAttachment(CreationReferenceAlbumMediaType r100, Integer r101, Integer r102, Double r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.width = r101;
        this.height = r102;
        this.durationSeconds = r103;
        this.fileSize = r104;
    }
}
