package w26;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558029e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f558025a, r101.f558025a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558026b, r101.f558026b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558027c, r101.f558027c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558028d, r101.f558028d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558029e, r101.f558029e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f558025a.hashCode() * 31) + this.f558026b.hashCode()) * 31) + this.f558027c.hashCode()) * 31) + this.f558028d.hashCode()) * 31) + this.f558029e.hashCode();
    }

    public final String toString() {
        return "AppInfo(appId=" + this.f558025a + ", appVersion=" + this.f558026b + ", installId=" + this.f558027c + ", did=" + this.f558028d + ", channel=" + this.f558029e + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appVersion");
        Intrinsics.checkNotNullParameter(r102, "installId");
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r104, "channel");
        this.f558025a = r100;
        this.f558026b = r101;
        this.f558027c = r102;
        this.f558028d = r103;
        this.f558029e = r104;
    }
}
