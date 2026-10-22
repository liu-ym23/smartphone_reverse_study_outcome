package eya;

import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f474824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f474825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f474826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f474827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f474828f;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f474823a, r101.f474823a) == true) goto L12;
        return false;
    L12:
        if (this.f474824b == r101.f474824b) goto L15;
        return false;
    L15:
        if (this.f474825c == r101.f474825c) goto L18;
        return false;
    L18:
        if (this.f474826d == r101.f474826d) goto L21;
        return false;
    L21:
        if (this.f474827e == r101.f474827e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474828f, r101.f474828f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f474823a.hashCode() * 31) + this.f474824b) * 31) + this.f474825c) * 31;
        int r101 = 1231;
        if (this.f474826d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f474827e == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Function0<Unit> r105 = this.f474828f;
        if (r105 != null) goto L13;
        int r106 = 0;
    L15:
        return r104 + r106;
    L13:
        r106 = r105.hashCode();
        goto L15
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PanelItemConfig(id=" + this.f474823a + ", iconRes=" + this.f474824b + ", nameRes=" + this.f474825c + ", enabled=" + this.f474826d + ", visible=" + this.f474827e + ", onClick=" + this.f474828f + ')';
    }

    public a(Function0 r100) {
        Intrinsics.checkNotNullParameter("plus_location", "id");
        this.f474823a = "plus_location";
        this.f474824b = R.drawable.doubao_ic_location_panel_item;
        this.f474825c = R.string.Lark_Chat_InputwindowExpansionLocation;
        this.f474826d = true;
        this.f474827e = true;
        this.f474828f = r100;
    }
}
