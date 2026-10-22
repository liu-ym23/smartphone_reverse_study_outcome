package xp2;

import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f564699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f564700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f564702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564703e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L16;
        e r101 = (e) r100;
        if (this.f564699a == r101.f564699a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f564700b, r101.f564700b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f564701c, r101.f564701c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f564702d, r101.f564702d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f564703e, r101.f564703e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f564699a * 31;
        String r101 = this.f564700b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f564701c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        k r108 = this.f564702d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f564703e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "RevInteractEntranceCell(interactType=" + this.f564699a + ", title=" + this.f564700b + ", desc=" + this.f564701c + ", icon=" + this.f564702d + ", extra=" + this.f564703e + ")";
    }

    public e(int r100, String r101, String r102, k r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r104, "extra");
        this.f564699a = r100;
        this.f564700b = r101;
        this.f564701c = r102;
        this.f564702d = r103;
        this.f564703e = r104;
    }
}
