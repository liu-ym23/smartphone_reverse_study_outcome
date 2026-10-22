package ppc;

import com.ss.android.lark.image.entity.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f530242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f530243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Image f530244d;

    public a() {
        this("", "", "", null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f530241a, r101.f530241a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530242b, r101.f530242b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530243c, r101.f530243c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530244d, r101.f530244d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f530241a.hashCode() * 31) + this.f530242b.hashCode()) * 31) + this.f530243c.hashCode()) * 31;
        Image r101 = this.f530244d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoubaoBasicPreviewData(title=" + this.f530241a + ", content=" + this.f530242b + ", description=" + this.f530243c + ", avatar=" + this.f530244d + ')';
    }

    public a(String r100, String r101, String r102, Image r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "description");
        this.f530241a = r100;
        this.f530242b = r101;
        this.f530243c = r102;
        this.f530244d = r103;
    }
}
