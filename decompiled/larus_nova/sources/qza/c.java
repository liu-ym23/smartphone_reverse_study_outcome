package qza;

import android.graphics.Bitmap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f535383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f535386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f535387f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f535382a, r101.f535382a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535383b, r101.f535383b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535384c, r101.f535384c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535385d, r101.f535385d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535386e, r101.f535386e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535387f, r101.f535387f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f535382a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f535383b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f535384c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f535385d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Unit> r113 = this.f535386e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f535387f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "OnlinePushNotificationData(scene=" + this.f535382a + ", icon=" + this.f535383b + ", title=" + this.f535384c + ", content=" + this.f535385d + ", clickAction=" + this.f535386e + ", rightActionText=" + this.f535387f + ')';
    }

    public c() {
        this("", null, "", "", null, "");
    }

    public c(String r100, Bitmap r101, String r102, String r103, Function0<Unit> r104, String r105) {
        this.f535382a = r100;
        this.f535383b = r101;
        this.f535384c = r102;
        this.f535385d = r103;
        this.f535386e = r104;
        this.f535387f = r105;
    }
}
