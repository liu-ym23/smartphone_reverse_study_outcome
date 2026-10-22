package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.d0;
import kotlinx.datetime.internal.format.parser.x;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SignedIntFieldFormatDirective<Target> implements k<Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<Target, Integer> f505273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f505274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f505275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f505276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f505277e;

    @Override // kotlinx.datetime.internal.format.k
    public final huc.e<Target> a() {
        SignedIntFieldFormatDirective$formatter$formatter$1 r100 = new SignedIntFieldFormatDirective$formatter$formatter$1(this.f505273a.a());
        Integer r101 = this.f505274b;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        huc.g r103 = new huc.g(r100, r102);
        Integer r104 = this.f505276d;
        if (r104 == null) goto L10;
        r104.intValue();
        return new huc.h(r103);
    L10:
        return r103;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // kotlinx.datetime.internal.format.k
    public final kotlinx.datetime.internal.format.parser.u<Target> parser() {
        Integer r100 = this.f505274b;
        Integer r101 = this.f505275c;
        Integer r102 = this.f505276d;
        b<Target, Integer> r110 = this.f505273a.a();
        String r111 = this.f505273a.getName();
        Integer r112 = this.f505277e;
        Intrinsics.checkNotNullParameter(r110, "setter");
        Intrinsics.checkNotNullParameter(r111, "name");
        List r113 = CollectionsKt.mutableListOf(new kotlinx.datetime.internal.format.parser.u[]{kotlinx.datetime.internal.format.parser.t.a(r100, r101, r102, r110, r111, true)});
        if (r112 == null) goto L5;
        r113.add(kotlinx.datetime.internal.format.parser.t.b(r100, r112, r102, r110, r111));
        r113.add(new kotlinx.datetime.internal.format.parser.u(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.r[]{new x(Marker.ANY_NON_NULL_MARKER), new kotlinx.datetime.internal.format.parser.j(CollectionsKt.listOf(new d0(Integer.valueOf(r112.intValue() + 1), r101, r110, r111, false)))}), CollectionsKt.emptyList()));
    L7:
        return new kotlinx.datetime.internal.format.parser.u(CollectionsKt.emptyList(), r113);
    L5:
        r113.add(kotlinx.datetime.internal.format.parser.t.b(r100, r101, r102, r110, r111));
        goto L7
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, Integer> b() {
        return this.f505273a;
    }

    public SignedIntFieldFormatDirective(p r100, Integer r101, Integer r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "field");
        this.f505273a = r100;
        this.f505274b = r101;
        this.f505275c = null;
        this.f505276d = r102;
        this.f505277e = r103;
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("The minimum number of digits (" + r101 + ") is negative").toString());
    L5:
        if (r101.intValue() >= 0) goto L8;
        r104 = false;
        goto L9
    }
}
