package jy9;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f501064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f501065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f501066f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f501061a, r101.f501061a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501062b, r101.f501062b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f501063c, r101.f501063c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501064d, r101.f501064d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f501065e, r101.f501065e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f501066f, r101.f501066f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f501061a.hashCode() * 31) + this.f501062b.hashCode()) * 31;
        String r101 = this.f501063c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        z r105 = this.f501064d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Message r108 = this.f501065e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f501066f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "EditFunctionReport(buttonName=" + this.f501061a + ", buttonType=" + this.f501062b + ", curBotId=" + this.f501063c + ", config=" + this.f501064d + ", message=" + this.f501065e + ", imageEditFunctionId=" + this.f501066f + ')';
    }

    public /* synthetic */ y(String r100, String r101, String r110, z r111, Message r112) {
        this(r100, r101, r110, r111, r112, null);
    }

    public y(String r100, String r101, String r102, z r103, Message r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "buttonName");
        Intrinsics.checkNotNullParameter(r101, "buttonType");
        this.f501061a = r100;
        this.f501062b = r101;
        this.f501063c = r102;
        this.f501064d = r103;
        this.f501065e = r104;
        this.f501066f = r105;
    }
}
