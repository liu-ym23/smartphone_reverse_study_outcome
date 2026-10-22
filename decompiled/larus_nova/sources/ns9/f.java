package ns9;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f520371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f520372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f520374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f520375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<d> f520376f;

    public f() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f520371a, r101.f520371a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520372b, r101.f520372b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520373c, r101.f520373c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520374d, r101.f520374d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f520375e, r101.f520375e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f520376f, r101.f520376f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f520371a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f520372b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f520373c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f520374d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((((r109 + r101) * 31) + this.f520375e.hashCode()) * 31) + this.f520376f.hashCode();
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
        return "ReachContent(layout=" + this.f520371a + ", title=" + this.f520372b + ", icon=" + this.f520373c + ", subtitle=" + this.f520374d + ", actions=" + this.f520375e + ", buttons=" + this.f520376f + ')';
    }

    public /* synthetic */ f(String r100, String r101, String r110, List r111, List r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 4) == 0) goto L8;
        String r102 = null;
    L10:
        if ((r113 & 8) == 0) goto L12;
        String r103 = null;
    L14:
        if ((r113 & 16) == 0) goto L16;
        r111 = CollectionsKt.emptyList();
    L16:
        List r104 = r111;
        if ((r113 & 32) == 0) goto L19;
        r112 = CollectionsKt.emptyList();
    L19:
        this(null, r100, r102, r103, r104, r112);
        return;
    L12:
        r103 = r110;
        goto L14
    L8:
        r102 = r101;
        goto L10
    }

    public f(Integer r100, String r101, String r102, String r103, List<b> r104, List<d> r105) {
        Intrinsics.checkNotNullParameter(r104, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r105, "buttons");
        this.f520371a = r100;
        this.f520372b = r101;
        this.f520373c = r102;
        this.f520374d = r103;
        this.f520375e = r104;
        this.f520376f = r105;
    }
}
