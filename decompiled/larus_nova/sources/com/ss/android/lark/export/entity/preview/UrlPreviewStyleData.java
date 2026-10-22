package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006HÆ\u0003J3\u0010\f\u001a\u00020\u00002(\b\u0002\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R1\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewStyleData;", "Ljava/io/Serializable;", "previewStyleData", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/export/entity/preview/PreviewData;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getPreviewStyleData", "()Ljava/util/HashMap;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewStyleData implements Serializable {
    private final HashMap<Integer, PreviewData> previewStyleData;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewStyleData copy$default(UrlPreviewStyleData r100, HashMap r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.previewStyleData;
    L6:
        return r100.copy(r101);
    }

    public final HashMap<Integer, PreviewData> component1() {
        return this.previewStyleData;
    }

    public final UrlPreviewStyleData copy(HashMap<Integer, PreviewData> r100) {
        Intrinsics.checkNotNullParameter(r100, "previewStyleData");
        return new UrlPreviewStyleData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewStyleData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.previewStyleData, ((UrlPreviewStyleData) r100).previewStyleData) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.previewStyleData.hashCode();
    }

    public String toString() {
        return "UrlPreviewStyleData(previewStyleData=" + this.previewStyleData + ')';
    }

    public final HashMap<Integer, PreviewData> getPreviewStyleData() {
        return this.previewStyleData;
    }

    public UrlPreviewStyleData(HashMap<Integer, PreviewData> r100) {
        Intrinsics.checkNotNullParameter(r100, "previewStyleData");
        this.previewStyleData = r100;
    }
}
