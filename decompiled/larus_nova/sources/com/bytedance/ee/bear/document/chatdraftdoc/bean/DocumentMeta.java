package com.bytedance.ee.bear.document.chatdraftdoc.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/DocumentMeta;", "Lcom/bytedance/ee/util/io/NonProguard;", "objId", "", "objType", "", "title", "token", "url", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getObjId", "()Ljava/lang/String;", "getObjType", "()I", "getTitle", "getToken", "getUrl", "toString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMeta implements NonProguard {

    @SerializedName("obj_id")
    private final String objId;

    @SerializedName("obj_type")
    private final int objType;
    private final String title;
    private final String token;
    private final String url;

    public static /* synthetic */ DocumentMeta copy$default(DocumentMeta r100, String r101, int r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.objId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.objType;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.title;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.token;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.url;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
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

    public final DocumentMeta copy(String r100, int r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "objId");
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r112, "url");
        return new DocumentMeta(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocumentMeta) == true) goto L8;
        return false;
    L8:
        DocumentMeta r101 = (DocumentMeta) r100;
        if (Intrinsics.areEqual(this.objId, r101.objId) == true) goto L12;
        return false;
    L12:
        if (this.objType == r101.objType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L23;
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

    public DocumentMeta(String r100, int r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "objId");
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r104, "url");
        this.objId = r100;
        this.objType = r101;
        this.title = r102;
        this.token = r103;
        this.url = r104;
    }

    public /* synthetic */ DocumentMeta(String r100, int r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r113 & 4) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r113 & 8) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r113 & 16) == 0) goto L17;
        String r105 = "";
    L18:
        this(r102, r101, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
