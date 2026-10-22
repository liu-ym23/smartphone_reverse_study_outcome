package com.bytedance.ee.bear.document.chatdraftdoc.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.locallife.cube.bridge.POINativeModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/QueryResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", POINativeModule.RESP_EXIST, "", "meta", "Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "<init>", "(ZLcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;)V", "getExist", "()Z", "getMeta", "()Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryResponse implements NonProguard {
    private final boolean exist;
    private final DocumentMeta meta;

    public static /* synthetic */ QueryResponse copy$default(QueryResponse r100, boolean r101, DocumentMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.exist;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.meta;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.exist;
    }

    public final DocumentMeta component2() {
        return this.meta;
    }

    public final QueryResponse copy(boolean r100, DocumentMeta r101) {
        return new QueryResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QueryResponse) == true) goto L8;
        return false;
    L8:
        QueryResponse r101 = (QueryResponse) r100;
        if (this.exist == r101.exist) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.exist == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        DocumentMeta r102 = this.meta;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "QueryResponse(exist=" + this.exist + ", meta=" + this.meta + ')';
    }

    public final boolean getExist() {
        return this.exist;
    }

    public final DocumentMeta getMeta() {
        return this.meta;
    }

    public QueryResponse(boolean r100, DocumentMeta r101) {
        this.exist = r100;
        this.meta = r101;
    }
}
