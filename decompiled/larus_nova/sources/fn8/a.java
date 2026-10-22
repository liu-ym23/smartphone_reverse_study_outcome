package fn8;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaItemAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichMediaItemAction f477932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RichMediaOverlayAlignment f477933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f477934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f477935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f477936e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f477932a == r101.f477932a) goto L12;
        return false;
    L12:
        if (this.f477933b == r101.f477933b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f477934c, r101.f477934c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477935d, r101.f477935d) == true) goto L21;
        return false;
    L21:
        if (this.f477936e == r101.f477936e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f477932a.hashCode() * 31) + this.f477933b.hashCode()) * 31;
        Integer r101 = this.f477934c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f477935d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f477936e == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RichMediaItemActionConfig(action=" + this.f477932a + ", alignment=" + this.f477933b + ", iconRes=" + this.f477934c + ", textRes=" + this.f477935d + ", showProgress=" + this.f477936e + ')';
    }

    public a(RichMediaItemAction r100, RichMediaOverlayAlignment r101, Integer r102, Integer r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = false;
    L11:
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "alignment");
        this.f477932a = r100;
        this.f477933b = r101;
        this.f477934c = r102;
        this.f477935d = r103;
        this.f477936e = r104;
    }
}
