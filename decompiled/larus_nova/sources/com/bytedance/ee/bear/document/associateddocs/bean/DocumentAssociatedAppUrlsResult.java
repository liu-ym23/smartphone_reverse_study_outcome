package com.bytedance.ee.bear.document.associateddocs.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/DocumentAssociatedAppUrlsResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "bp", "", "hasMore", "", "references", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/Reference;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;ZLjava/util/ArrayList;)V", "getBp", "()Ljava/lang/String;", "getHasMore", "()Z", "getReferences", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentAssociatedAppUrlsResult implements NonProguard {

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private final String f218990bp;
    private final boolean hasMore;
    private final ArrayList<Reference> references;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocumentAssociatedAppUrlsResult copy$default(DocumentAssociatedAppUrlsResult r100, String r101, boolean r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f218990bp;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hasMore;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.references;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f218990bp;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final ArrayList<Reference> component3() {
        return this.references;
    }

    public final DocumentAssociatedAppUrlsResult copy(String r100, @JSONField(name = "has_more") boolean r101, ArrayList<Reference> r102) {
        Intrinsics.checkNotNullParameter(r100, "bp");
        Intrinsics.checkNotNullParameter(r102, "references");
        return new DocumentAssociatedAppUrlsResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocumentAssociatedAppUrlsResult) == true) goto L8;
        return false;
    L8:
        DocumentAssociatedAppUrlsResult r101 = (DocumentAssociatedAppUrlsResult) r100;
        if (Intrinsics.areEqual(this.f218990bp, r101.f218990bp) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r101.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.references, r101.references) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.f218990bp.hashCode() * 31;
        if (this.hasMore == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.references.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "DocumentAssociatedAppUrlsResult(bp=" + this.f218990bp + ", hasMore=" + this.hasMore + ", references=" + this.references + ')';
    }

    public final String getBp() {
        return this.f218990bp;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final ArrayList<Reference> getReferences() {
        return this.references;
    }

    public DocumentAssociatedAppUrlsResult(String r100, @JSONField(name = "has_more") boolean r101, ArrayList<Reference> r102) {
        Intrinsics.checkNotNullParameter(r100, "bp");
        Intrinsics.checkNotNullParameter(r102, "references");
        this.f218990bp = r100;
        this.hasMore = r101;
        this.references = r102;
    }
}
