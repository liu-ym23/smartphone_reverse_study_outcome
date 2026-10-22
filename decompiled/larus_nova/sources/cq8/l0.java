package cq8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class l0 extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f464881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f464883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f464884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.b0 f464886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f464887j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<y0> f464888k;

    public l0() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r101 = (l0) r100;
        if (Intrinsics.areEqual(this.f464880c, r101.f464880c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464881d, r101.f464881d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f464882e, r101.f464882e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f464883f, r101.f464883f) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f464884g, r101.f464884g) == true) goto L24;
        return false;
    L24:
        if (this.f464885h == r101.f464885h) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f464886i, r101.f464886i) == true) goto L30;
        return false;
    L30:
        if (this.f464887j == r101.f464887j) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f464888k, r101.f464888k) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f464880c.hashCode() * 31) + this.f464881d.hashCode()) * 31) + this.f464882e.hashCode()) * 31;
        String r101 = this.f464883f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f464884g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f464885h == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        com.larus.bmhome.actionbar.model.b0 r110 = this.f464886i;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return ((((r109 + r102) * 31) + this.f464887j) * 31) + this.f464888k.hashCode();
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultiSelectorDescriptor(widgetId=" + this.f464880c + ", actionChannel=" + this.f464881d + ", version=" + this.f464882e + ", subTitle=" + this.f464883f + ", marginTop=" + this.f464884g + ", enableBottomLine=" + this.f464885h + ", template=" + this.f464886i + ", instructionType=" + this.f464887j + ", childWidgetEntry=" + this.f464888k + ')';
    }

    @Override // cq8.a0
    public final String a() {
        return this.f464882e;
    }

    public l0(String r100, com.larus.bmhome.instruction.core.impl.base.b.C4081b r101, String r102, Integer r103, boolean r104, com.larus.bmhome.actionbar.model.b0 r105, int r106, List r110) {
        String r107 = a0.a.a();
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        Intrinsics.checkNotNullParameter(r101, "actionChannel");
        Intrinsics.checkNotNullParameter(r107, "version");
        Intrinsics.checkNotNullParameter(r110, "childWidgetEntry");
        super("MultiSelectorDescriptor");
        this.f464880c = r100;
        this.f464881d = r101;
        this.f464882e = r107;
        this.f464883f = r102;
        this.f464884g = r103;
        this.f464885h = r104;
        this.f464886i = r105;
        this.f464887j = r106;
        this.f464888k = r110;
    }
}
