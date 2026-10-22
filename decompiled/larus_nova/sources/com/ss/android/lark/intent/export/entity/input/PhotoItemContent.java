package com.ss.android.lark.intent.export.entity.input;

import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/PhotoItemContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "id", "", "url", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getId", "()Ljava/lang/String;", "getUrl", "getWidth", "()I", "getHeight", "isValid", "", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoItemContent implements Serializable, IContentValid {
    private final int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f428142id;
    private final String url;
    private final int width;

    public static /* synthetic */ PhotoItemContent copy$default(PhotoItemContent r100, String r101, String r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f428142id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.url;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.width;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.height;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f428142id;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final PhotoItemContent copy(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        return new PhotoItemContent(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoItemContent) == true) goto L8;
        return false;
    L8:
        PhotoItemContent r101 = (PhotoItemContent) r100;
        if (Intrinsics.areEqual(this.f428142id, r101.f428142id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (this.width == r101.width) goto L18;
        return false;
    L18:
        if (this.height == r101.height) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.f428142id.hashCode() * 31;
        String r101 = this.url;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.width) * 31) + this.height;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        if (this.url == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("PhotoItemContent(id='");
        r100.append(this.f428142id);
        r100.append("', url=");
        String r101 = this.url;
        if (r101 == null) goto L6;
        String r102 = a.a(r101);
        if (r102 == null) goto L6;
    L7:
        r100.append(r102);
        r100.append(", width=");
        r100.append(this.width);
        r100.append(", height=");
        r100.append(this.height);
        r100.append(')');
        return r100.toString();
    L6:
        r102 = "null";
        goto L7
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.f428142id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public PhotoItemContent(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f428142id = r100;
        this.url = r101;
        this.width = r102;
        this.height = r103;
    }
}
