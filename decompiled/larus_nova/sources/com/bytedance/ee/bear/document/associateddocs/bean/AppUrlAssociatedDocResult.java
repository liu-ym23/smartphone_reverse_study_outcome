package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/AppUrlAssociatedDocResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "references", "Ljava/util/LinkedList;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/ReferenceDocInfo;", "<init>", "(Ljava/util/LinkedList;)V", "getReferences", "()Ljava/util/LinkedList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppUrlAssociatedDocResult implements NonProguard {
    private final LinkedList<ReferenceDocInfo> references;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppUrlAssociatedDocResult copy$default(AppUrlAssociatedDocResult r100, LinkedList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.references;
    L6:
        return r100.copy(r101);
    }

    public final LinkedList<ReferenceDocInfo> component1() {
        return this.references;
    }

    public final AppUrlAssociatedDocResult copy(LinkedList<ReferenceDocInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "references");
        return new AppUrlAssociatedDocResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppUrlAssociatedDocResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.references, ((AppUrlAssociatedDocResult) r100).references) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.references.hashCode();
    }

    public String toString() {
        return "AppUrlAssociatedDocResult(references=" + this.references + ')';
    }

    public final LinkedList<ReferenceDocInfo> getReferences() {
        return this.references;
    }

    public AppUrlAssociatedDocResult(LinkedList<ReferenceDocInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "references");
        this.references = r100;
    }
}
