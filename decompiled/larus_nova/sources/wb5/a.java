package wb5;

import android.graphics.RectF;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f558980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f558981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f558983g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558977a, r101.f558977a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558978b, r101.f558978b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558979c, r101.f558979c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558980d, r101.f558980d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558981e, r101.f558981e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558982f, r101.f558982f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558983g, r101.f558983g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f558977a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f558978b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f558979c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        RectF r110 = this.f558980d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        View r113 = this.f558981e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f558982f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f558983g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "EnterpriseTopicParams(query=" + this.f558977a + ", locale=" + this.f558978b + ", abbrId=" + this.f558979c + ", rect=" + this.f558980d + ", anchorView=" + this.f558981e + ", chatId=" + this.f558982f + ", clientArgs=" + this.f558983g + ')';
    }

    public a(String r100, String r101, RectF r102, View r103, String r104) {
        this.f558977a = r100;
        this.f558978b = null;
        this.f558979c = r101;
        this.f558980d = r102;
        this.f558981e = r103;
        this.f558982f = null;
        this.f558983g = r104;
    }
}
