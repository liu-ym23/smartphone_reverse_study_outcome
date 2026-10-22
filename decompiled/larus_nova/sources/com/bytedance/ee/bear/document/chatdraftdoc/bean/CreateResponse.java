package com.bytedance.ee.bear.document.chatdraftdoc.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/CreateResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", "meta", "Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "fullQuote", "", "<init>", "(Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;Z)V", "getMeta", "()Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "getFullQuote", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateResponse implements NonProguard {
    private final boolean fullQuote;
    private final DocumentMeta meta;

    public static /* synthetic */ CreateResponse copy$default(CreateResponse r100, DocumentMeta r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.meta;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.fullQuote;
    L9:
        return r100.copy(r101, r102);
    }

    public final DocumentMeta component1() {
        return this.meta;
    }

    public final boolean component2() {
        return this.fullQuote;
    }

    public final CreateResponse copy(DocumentMeta r100, boolean r101) {
        return new CreateResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreateResponse) == true) goto L8;
        return false;
    L8:
        CreateResponse r101 = (CreateResponse) r100;
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L12;
        return false;
    L12:
        if (this.fullQuote == r101.fullQuote) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        DocumentMeta r100 = this.meta;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.fullQuote == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreateResponse(meta=" + this.meta + ", fullQuote=" + this.fullQuote + ')';
    }

    public final boolean getFullQuote() {
        return this.fullQuote;
    }

    public final DocumentMeta getMeta() {
        return this.meta;
    }

    public CreateResponse(DocumentMeta r100, boolean r101) {
        this.meta = r100;
        this.fullQuote = r101;
    }

    public /* synthetic */ CreateResponse(DocumentMeta r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = false;
    L5:
        this(r100, r101);
    }
}
