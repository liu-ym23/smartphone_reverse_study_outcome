package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J)\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\nHÆ\u0003JI\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/export/entity/preview/Type;", "previewPropertyData", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/export/entity/preview/PreviewData;", "Lkotlin/collections/HashMap;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Ljava/util/HashMap;Lcom/ss/android/lark/widget/richtext/RichText;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getPreviewPropertyData", "()Ljava/util/HashMap;", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewPropertyData implements Serializable {
    private final HashMap<Integer, PreviewData> previewPropertyData;
    private final RichText richText;
    private final Type type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewPropertyData copy$default(UrlPreviewPropertyData r100, Type r101, HashMap r102, RichText r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.previewPropertyData;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.richText;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Type component1() {
        return this.type;
    }

    public final HashMap<Integer, PreviewData> component2() {
        return this.previewPropertyData;
    }

    public final RichText component3() {
        return this.richText;
    }

    public final UrlPreviewPropertyData copy(Type r100, HashMap<Integer, PreviewData> r101, RichText r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "previewPropertyData");
        return new UrlPreviewPropertyData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewPropertyData) == true) goto L8;
        return false;
    L8:
        UrlPreviewPropertyData r101 = (UrlPreviewPropertyData) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewPropertyData, r101.previewPropertyData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.richText, r101.richText) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.type.hashCode() * 31) + this.previewPropertyData.hashCode()) * 31;
        RichText r101 = this.richText;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "UrlPreviewPropertyData(type=" + this.type + ", previewPropertyData=" + this.previewPropertyData + ", richText=" + this.richText + ')';
    }

    public final HashMap<Integer, PreviewData> getPreviewPropertyData() {
        return this.previewPropertyData;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final Type getType() {
        return this.type;
    }

    public UrlPreviewPropertyData(Type r100, HashMap<Integer, PreviewData> r101, RichText r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "previewPropertyData");
        this.type = r100;
        this.previewPropertyData = r101;
        this.richText = r102;
    }
}
