package m9b;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f512655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f512657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f512658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f512659e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f512655a, r101.f512655a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512656b, r101.f512656b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f512657c, r101.f512657c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f512658d, r101.f512658d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f512659e, r101.f512659e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f512655a.hashCode() * 31) + this.f512656b.hashCode()) * 31) + this.f512657c.hashCode()) * 31) + this.f512658d.hashCode()) * 31) + this.f512659e.hashCode();
    }

    public final String toString() {
        return "OfficeInviteExternalCardRenderModel(userName=" + this.f512655a + ", tenantText=" + this.f512656b + ", userAvatarKey=" + this.f512657c + ", loginUserId=" + this.f512658d + ", qrBitmap=" + this.f512659e + ')';
    }

    public a(String r100, String r101, String r102, String r103, Bitmap r104) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "tenantText");
        Intrinsics.checkNotNullParameter(r102, "userAvatarKey");
        Intrinsics.checkNotNullParameter(r103, "loginUserId");
        Intrinsics.checkNotNullParameter(r104, "qrBitmap");
        this.f512655a = r100;
        this.f512656b = r101;
        this.f512657c = r102;
        this.f512658d = r103;
        this.f512659e = r104;
    }
}
