package d59;

import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f467079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f467080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f467081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f467082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f467083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f467084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DoraDynamicViewModel.c f467085g;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f467079a, r101.f467079a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467080b, r101.f467080b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f467081c, r101.f467081c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f467082d, r101.f467082d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f467083e, r101.f467083e) == true) goto L24;
        return false;
    L24:
        if (this.f467084f == r101.f467084f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f467085g, r101.f467085g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f467079a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f467080b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f467081c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f467082d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.f467083e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f467084f == false) goto L25;
        int r115 = 1231;
    L27:
        return ((r114 + r115) * 31) + this.f467085g.hashCode();
    L25:
        r115 = 1237;
        goto L27
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
        return "CardInstance(name=" + this.f467079a + ", cardKey=" + this.f467080b + ", cardInstanceId=" + this.f467081c + ", templateType=" + this.f467082d + ", cardData=" + this.f467083e + ", connected=" + this.f467084f + ", connectStatus=" + this.f467085g + ')';
    }

    public /* synthetic */ c(int r100) {
        this(null, null, null, null, null, true, new DoraDynamicViewModel.c.d());
    }

    public c(String r100, String r101, String r102, String r103, j r104, boolean r105, DoraDynamicViewModel.c r106) {
        Intrinsics.checkNotNullParameter(r106, "connectStatus");
        this.f467079a = r100;
        this.f467080b = r101;
        this.f467081c = r102;
        this.f467082d = r103;
        this.f467083e = r104;
        this.f467084f = r105;
        this.f467085g = r106;
    }
}
