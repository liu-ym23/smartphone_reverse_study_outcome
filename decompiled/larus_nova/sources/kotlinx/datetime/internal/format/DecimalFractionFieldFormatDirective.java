package kotlinx.datetime.internal.format;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DecimalFractionFieldFormatDirective<Target> implements k<Target> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<Target, guc.a> f505256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f505259d;

    @Override // kotlinx.datetime.internal.format.k
    public final huc.e<Target> a() {
        return new huc.d(new DecimalFractionFieldFormatDirective$formatter$1(this.f505256a.a()), this.f505257b, this.f505258c, this.f505259d);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final kotlinx.datetime.internal.format.parser.u<Target> parser() {
        return new kotlinx.datetime.internal.format.parser.u(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.j(CollectionsKt.listOf(new kotlinx.datetime.internal.format.parser.d(this.f505257b, this.f505258c, this.f505256a.a(), this.f505256a.getName())))), CollectionsKt.emptyList());
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, guc.a> b() {
        return this.f505256a;
    }

    public DecimalFractionFieldFormatDirective(p r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "field");
        Intrinsics.checkNotNullParameter(r101, "zerosToAdd");
        this.f505256a = r100;
        this.f505257b = 1;
        this.f505258c = 9;
        this.f505259d = r101;
    }
}
