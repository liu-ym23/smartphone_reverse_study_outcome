package com.bytedance.ee.bear.document.associateddocs.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/CreateAndAssociatedDocResult;", "Ljava/io/Serializable;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateAndAssociatedDocResult implements Serializable {
    private String url;

    public static /* synthetic */ CreateAndAssociatedDocResult copy$default(CreateAndAssociatedDocResult r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.url;
    }

    public final CreateAndAssociatedDocResult copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return new CreateAndAssociatedDocResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreateAndAssociatedDocResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.url, ((CreateAndAssociatedDocResult) r100).url) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "CreateAndAssociatedDocResult(url=" + this.url + ')';
    }

    public final String getUrl() {
        return this.url;
    }

    public CreateAndAssociatedDocResult(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.url = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }
}
