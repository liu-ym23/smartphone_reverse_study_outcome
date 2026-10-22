package com.ss.android.lark.intent.export.entity.donate;

import com.ss.android.lark.utils.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/DocDonateEntity;", "Lcom/ss/android/lark/intent/export/entity/donate/ScreenDonateEntity;", "docId", "", "docName", "docUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDocId", "()Ljava/lang/String;", "getDocName", "getDocUrl", "parser", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;", "(Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;)Ljava/lang/Object;", "toDesc", "toString", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDonateEntity extends ScreenDonateEntity {
    private final String docId;
    private final String docName;
    private final String docUrl;

    public static /* synthetic */ DocDonateEntity copy$default(DocDonateEntity r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.docId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.docName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.docUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.docId;
    }

    public final String component2() {
        return this.docName;
    }

    public final String component3() {
        return this.docUrl;
    }

    public final DocDonateEntity copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "docId");
        Intrinsics.checkNotNullParameter(r101, "docName");
        Intrinsics.checkNotNullParameter(r102, "docUrl");
        return new DocDonateEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocDonateEntity) == true) goto L8;
        return false;
    L8:
        DocDonateEntity r101 = (DocDonateEntity) r100;
        if (Intrinsics.areEqual(this.docId, r101.docId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.docName, r101.docName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.docUrl, r101.docUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.docId.hashCode() * 31) + this.docName.hashCode()) * 31) + this.docUrl.hashCode();
    }

    public String toString() {
        return "DocDonateEntity(docUrl='" + y.a(this.docUrl) + "')";
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public String toDesc() {
        return toString();
    }

    public final String getDocId() {
        return this.docId;
    }

    public final String getDocName() {
        return this.docName;
    }

    public final String getDocUrl() {
        return this.docUrl;
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public <R> R parser(IDonateEntityVisitor<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        return r100.visit(this);
    }

    public DocDonateEntity(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "docId");
        Intrinsics.checkNotNullParameter(r101, "docName");
        Intrinsics.checkNotNullParameter(r102, "docUrl");
        super(DonateType.DOC);
        this.docId = r100;
        this.docName = r101;
        this.docUrl = r102;
    }
}
