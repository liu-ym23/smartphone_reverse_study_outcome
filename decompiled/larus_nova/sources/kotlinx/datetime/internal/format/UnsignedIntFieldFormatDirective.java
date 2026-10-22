package kotlinx.datetime.internal.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class UnsignedIntFieldFormatDirective<Target> implements k<Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w<Target> f505278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f505280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f505281d;

    @Override // kotlinx.datetime.internal.format.k
    public final huc.e<Target> a() {
        huc.j r100 = new huc.j(new UnsignedIntFieldFormatDirective$formatter$formatter$1(this.f505278a.f505359a), this.f505279b);
        Integer r101 = this.f505280c;
        if (r101 == null) goto L6;
        r101.intValue();
        return new huc.h(r100);
    L6:
        return r100;
    }

    @Override // kotlinx.datetime.internal.format.k
    public final kotlinx.datetime.internal.format.parser.u<Target> parser() {
        Integer r100 = Integer.valueOf(this.f505279b);
        Integer r101 = Integer.valueOf(this.f505281d);
        Integer r102 = this.f505280c;
        w<Target> r103 = this.f505278a;
        return kotlinx.datetime.internal.format.parser.t.b(r100, r101, r102, r103.f505359a, r103.f505362d);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final /* bridge */ /* synthetic */ m b() {
        return this.f505278a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnsignedIntFieldFormatDirective(w<? super Target> r100, int r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "field");
        this.f505278a = r100;
        this.f505279b = r101;
        this.f505280c = r102;
        int r103 = r100.f505365g;
        this.f505281d = r103;
        boolean r104 = true;
        if (r101 < 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L25;
        if (r103 < r101) goto L9;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L23;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.intValue() > r101) goto L17;
        r104 = false;
    L17:
        if (r104 == false) goto L20;
        return;
    L20:
        throw new IllegalArgumentException(("The space padding (" + r102 + ") should be more than the minimum number of digits (" + r101 + ')').toString());
    L23:
        throw new IllegalArgumentException(("The maximum number of digits (" + r103 + ") is less than the minimum number of digits (" + r101 + ')').toString());
    L9:
        r106 = false;
        goto L11
    L25:
        throw new IllegalArgumentException(("The minimum number of digits (" + r101 + ") is negative").toString());
    L5:
        r105 = false;
        goto L6
    }
}
