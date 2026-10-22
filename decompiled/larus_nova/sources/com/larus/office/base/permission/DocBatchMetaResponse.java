package com.larus.office.base.permission;

import com.larus.office.base.preview.DocMeta;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/office/base/permission/DocBatchMetaResponse;", "Ljava/io/Serializable;", "docs", "", "Lcom/larus/office/base/preview/DocMeta;", "<init>", "(Ljava/util/List;)V", "getDocs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocBatchMetaResponse implements Serializable {
    private final List<DocMeta> docs;

    /* JADX WARN: Multi-variable type inference failed */
    public DocBatchMetaResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocBatchMetaResponse copy$default(DocBatchMetaResponse r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.docs;
    L6:
        return r100.copy(r101);
    }

    public final List<DocMeta> component1() {
        return this.docs;
    }

    public final DocBatchMetaResponse copy(List<DocMeta> r100) {
        return new DocBatchMetaResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocBatchMetaResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.docs, ((DocBatchMetaResponse) r100).docs) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<DocMeta> r100 = this.docs;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "DocBatchMetaResponse(docs=" + this.docs + ')';
    }

    public final List<DocMeta> getDocs() {
        return this.docs;
    }

    public DocBatchMetaResponse(List<DocMeta> r100) {
        this.docs = r100;
    }

    public /* synthetic */ DocBatchMetaResponse(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
