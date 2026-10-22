package com.bytedance.ee.bear.document.chatdraftdoc.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "objId", "", "objType", "", "title", "token", "url", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getObjId", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getToken", "getUrl", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMeta implements NonProguard {

    @SerializedName("obj_id")
    private final String objId;

    @SerializedName("obj_type")
    private final int objType;
    private final String title;
    private final String token;
    private final String url;

    public static /* synthetic */ DocumentMeta copy$default(DocumentMeta r3, String r4, int r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.objId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.objType;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.title;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.token;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.url;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.objId;
    }

    public final int component2() {
        return this.objType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.token;
    }

    public final String component5() {
        return this.url;
    }

    public final DocumentMeta copy(String r8, int r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "objId");
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r11, "token");
        Intrinsics.checkNotNullParameter(r12, "url");
        return new DocumentMeta(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocumentMeta) == true) goto L8;
        return false;
    L8:
        DocumentMeta r6 = (DocumentMeta) r5;
        if (Intrinsics.areEqual(this.objId, r6.objId) == true) goto L12;
        return false;
    L12:
        if (this.objType == r6.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.objId.hashCode() * 31) + this.objType) * 31) + this.title.hashCode()) * 31) + this.token.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "Meta{objId=" + b.k(this.objId) + ", objType=" + this.objType + ", url=" + b.k(this.url) + '}';
    }

    public final String getObjId() {
        return this.objId;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUrl() {
        return this.url;
    }

    public DocumentMeta(String r2, int r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "objId");
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "token");
        Intrinsics.checkNotNullParameter(r6, "url");
        this.objId = r2;
        this.objType = r3;
        this.title = r4;
        this.token = r5;
        this.url = r6;
    }

    public /* synthetic */ DocumentMeta(String r8, int r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r13 & 8) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r13 & 16) == 0) goto L17;
        String r6 = "";
    L18:
        this(r2, r9, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r2 = r8;
        goto L7
    }
}
