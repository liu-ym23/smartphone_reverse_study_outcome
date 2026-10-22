package fla;

import android.graphics.drawable.Drawable;
import com.obric.oui.selection.OActionSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OActionSheet.Companion.ItemStyle f477750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f477751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f477753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Integer, Unit> f477754e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f477750a == r101.f477750a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f477751b, r101.f477751b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f477752c, r101.f477752c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477753d, r101.f477753d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f477754e, r101.f477754e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f477750a.hashCode() * 31;
        Drawable r101 = this.f477751b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f477752c.hashCode()) * 31;
        Integer r105 = this.f477753d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Function1<Integer, Unit> r108 = this.f477754e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActionSheetItemData(style=" + this.f477750a + ", icon=" + this.f477751b + ", title=" + this.f477752c + ", textColor=" + this.f477753d + ", clickAction=" + this.f477754e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(OActionSheet.Companion.ItemStyle r100, Drawable r101, String r102, Integer r103, Function1<? super Integer, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "style");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f477750a = r100;
        this.f477751b = r101;
        this.f477752c = r102;
        this.f477753d = r103;
        this.f477754e = r104;
    }

    public /* synthetic */ a(OActionSheet.Companion.ItemStyle r100, Drawable r110, String r111, Function1 r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        Drawable r101 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        Function1 r102 = null;
    L10:
        this(r100, r101, r111, null, r102);
        return;
    L9:
        r102 = r112;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
