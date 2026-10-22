package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntry;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "offset", "", "length", "previewId", "", "previewEntity", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "<init>", "(IILjava/lang/String;Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;)V", "getOffset", "()I", "getLength", "getPreviewId", "()Ljava/lang/String;", "getPreviewEntity", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "isItemSame", "", "diffable", "isContentSame", "equals", "other", "", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreViewEntry implements Serializable, b<UrlPreViewEntry> {
    private final int length;
    private final int offset;
    private final UrlInlinePreviewEntity previewEntity;
    private final String previewId;

    public static /* synthetic */ UrlPreViewEntry copy$default(UrlPreViewEntry r100, int r101, int r102, String r103, UrlInlinePreviewEntity r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.offset;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.length;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.previewId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.previewEntity;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.offset;
    }

    public final int component2() {
        return this.length;
    }

    public final String component3() {
        return this.previewId;
    }

    public final UrlInlinePreviewEntity component4() {
        return this.previewEntity;
    }

    public final UrlPreViewEntry copy(int r100, int r101, String r102, UrlInlinePreviewEntity r103) {
        Intrinsics.checkNotNullParameter(r102, "previewId");
        return new UrlPreViewEntry(r100, r101, r102, r103);
    }

    public String toString() {
        return "UrlPreViewEntry(offset=" + this.offset + ", length=" + this.length + ", previewId=" + this.previewId + ", previewEntity=" + this.previewEntity + ')';
    }

    public int hashCode() {
        int r100 = ((((this.offset * 31) + this.length) * 31) + this.previewId.hashCode()) * 31;
        UrlInlinePreviewEntity r101 = this.previewEntity;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final int getLength() {
        return this.length;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final UrlInlinePreviewEntity getPreviewEntity() {
        return this.previewEntity;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreViewEntry) == true) goto L8;
        return false;
    L8:
        UrlPreViewEntry r101 = (UrlPreViewEntry) r100;
        if (this.offset == r101.offset) goto L12;
        return false;
    L12:
        if (this.length == r101.length) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewId, r101.previewId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewEntity, r101.previewEntity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isContentSame(UrlPreViewEntry r100) {
        String r101 = this.previewId;
        if (r100 == null) goto L5;
        String r102 = r100.previewId;
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L10;
        return false;
    L10:
        if (a.c(this.previewEntity, r100.previewEntity) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public boolean isItemSame(UrlPreViewEntry r100) {
        String r101 = this.previewId;
        if (r100 == null) goto L5;
        String r102 = r100.previewId;
    L7:
        if (Intrinsics.areEqual(r101, r102) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UrlPreViewEntry) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UrlPreViewEntry) r100);
    }

    public UrlPreViewEntry(int r100, int r101, String r102, UrlInlinePreviewEntity r103) {
        Intrinsics.checkNotNullParameter(r102, "previewId");
        this.offset = r100;
        this.length = r101;
        this.previewId = r102;
        this.previewEntity = r103;
    }
}
