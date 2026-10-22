package di8;

import com.larus.bmhome.chat.nestedmenu.ui.NestedMenuPopup;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f468803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, List<d0>> f468804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedMenuPopup f468805c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (Intrinsics.areEqual(this.f468803a, r101.f468803a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468804b, r101.f468804b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f468805c, r101.f468805c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f468803a.hashCode() * 31) + this.f468804b.hashCode()) * 31) + this.f468805c.hashCode();
    }

    public final String toString() {
        return "NestedMenuPresentationState(config=" + this.f468803a + ", models=" + this.f468804b + ", popup=" + this.f468805c + ')';
    }

    public static m0 a(m0 r100, LinkedHashMap r101) {
        c0 r102 = r100.f468803a;
        NestedMenuPopup r103 = r100.f468805c;
        Intrinsics.checkNotNullParameter(r102, "config");
        Intrinsics.checkNotNullParameter(r101, "models");
        Intrinsics.checkNotNullParameter(r103, "popup");
        return new m0(r102, r101, r103);
    }

    public m0(c0 r100, LinkedHashMap<String, List<d0>> r101, NestedMenuPopup r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "models");
        Intrinsics.checkNotNullParameter(r102, "popup");
        this.f468803a = r100;
        this.f468804b = r101;
        this.f468805c = r102;
    }
}
