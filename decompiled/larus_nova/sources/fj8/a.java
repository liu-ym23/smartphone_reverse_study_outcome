package fj8;

import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f477481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f477482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f477483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ButtonStatus f477484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f477485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f477486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f477487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f477488h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f477481a == r101.f477481a) goto L12;
        return false;
    L12:
        if (this.f477482b == r101.f477482b) goto L15;
        return false;
    L15:
        if (this.f477483c == r101.f477483c) goto L18;
        return false;
    L18:
        if (this.f477484d == r101.f477484d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f477485e, r101.f477485e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f477486f, r101.f477486f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f477487g, r101.f477487g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f477488h, r101.f477488h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f477481a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f477482b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f477483c == true) goto L15;
        r100 = 1237;
    L15:
        return ((((((((((r104 + r100) * 31) + this.f477484d.hashCode()) * 31) + this.f477485e.hashCode()) * 31) + this.f477486f.hashCode()) * 31) + this.f477487g.hashCode()) * 31) + this.f477488h.hashCode();
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BrowserControlBlockInput(isFold=" + this.f477481a + ", forceHideArrow=" + this.f477482b + ", disableHeaderInteraction=" + this.f477483c + ", buttonStatus=" + this.f477484d + ", title=" + this.f477485e + ", url=" + this.f477486f + ", leftDarkIcon=" + this.f477487g + ", leftLightIcon=" + this.f477488h + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, ButtonStatus r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r103, "buttonStatus");
        Intrinsics.checkNotNullParameter(r104, "title");
        Intrinsics.checkNotNullParameter(r105, "url");
        Intrinsics.checkNotNullParameter(r106, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r107, "leftLightIcon");
        this.f477481a = r100;
        this.f477482b = r101;
        this.f477483c = r102;
        this.f477484d = r103;
        this.f477485e = r104;
        this.f477486f = r105;
        this.f477487g = r106;
        this.f477488h = r107;
    }
}
