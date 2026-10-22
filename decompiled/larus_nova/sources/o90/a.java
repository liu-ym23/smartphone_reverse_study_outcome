package o90;

import com.bytedance.android.live.base.model.UrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UrlModel f522431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f522432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f522433e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f522429a, r101.f522429a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f522430b, r101.f522430b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f522431c, r101.f522431c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522432d, r101.f522432d) == true) goto L14;
        return false;
    L14:
        if (this.f522433e == r101.f522433e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f522429a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522430b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        UrlModel r107 = this.f522431c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f522432d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((r109 + r101) * 31) + this.f522433e;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BeautyTemplateModel(key=" + this.f522429a + ", name=" + this.f522430b + ", url=" + this.f522431c + ", id=" + this.f522432d + ", position=" + this.f522433e + ")";
    }

    public a(String r100, String r101, UrlModel r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "id");
        this.f522429a = r100;
        this.f522430b = r101;
        this.f522431c = r102;
        this.f522432d = r103;
        this.f522433e = r104;
    }
}
