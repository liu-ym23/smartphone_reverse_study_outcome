package jy8;

import com.larus.canvas.service.bean.Icon;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f500960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f500962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f500963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Icon f500964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f500965f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f500960a == r101.f500960a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f500961b, r101.f500961b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f500962c, r101.f500962c) == true) goto L18;
        return false;
    L18:
        if (this.f500963d == r101.f500963d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f500964e, r101.f500964e) == true) goto L24;
        return false;
    L24:
        if (this.f500965f == r101.f500965f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f500960a;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f500961b.hashCode()) * 31) + this.f500962c.hashCode()) * 31;
        int r102 = 1231;
        if (this.f500963d == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r101 + r103) * 31;
        Icon r105 = this.f500964e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f500965f == true) goto L15;
        r102 = 1237;
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = 1237;
        goto L6
    }

    public final String toString() {
        return "DropDownBoxSelectItem(id=" + this.f500960a + ", itemName=" + this.f500961b + ", desc=" + this.f500962c + ", isSelected=" + this.f500963d + ", icon=" + this.f500964e + ", showDivider=" + this.f500965f + ')';
    }

    public e(long r100, String r101, String r102, boolean r103, Icon r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "itemName");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        this.f500960a = r100;
        this.f500961b = r101;
        this.f500962c = r102;
        this.f500963d = r103;
        this.f500964e = r104;
        this.f500965f = r105;
    }
}
