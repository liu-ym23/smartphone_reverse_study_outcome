package r2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f535706e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f535702a, r101.f535702a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535703b, r101.f535703b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535704c, r101.f535704c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535705d, r101.f535705d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535706e, r101.f535706e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f535702a.hashCode() * 31) + this.f535703b.hashCode()) * 31) + this.f535704c.hashCode()) * 31) + this.f535705d.hashCode()) * 31) + this.f535706e.hashCode();
    }

    public final String toString() {
        return "AppletChatActionBarItem(id=" + this.f535702a + ", title=" + this.f535703b + ", iconUrl=" + this.f535704c + ", darkModeIconUrl=" + this.f535705d + ", behavior=" + this.f535706e + ')';
    }

    public e(String r100, String r101, String r102, String r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "iconUrl");
        Intrinsics.checkNotNullParameter(r103, "darkModeIconUrl");
        Intrinsics.checkNotNullParameter(r104, "behavior");
        this.f535702a = r100;
        this.f535703b = r101;
        this.f535704c = r102;
        this.f535705d = r103;
        this.f535706e = r104;
    }
}
