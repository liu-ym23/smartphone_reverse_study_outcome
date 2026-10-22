package kotlinx.datetime.internal.format;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.c0;

/* JADX INFO: loaded from: classes42.dex */
public final class OptionalFormatStructure<T> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n<T> f505265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a<T, ? extends Object>> f505266c;

    public static final class a<T, E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f505267c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T, E> f505268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final E f505269b;

        /* JADX INFO: renamed from: kotlinx.datetime.internal.format.OptionalFormatStructure$a$a, reason: collision with other inner class name */
        public static final class C6592a {
        }

        static {
        }

        public a() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b r100, Object r101) {
            this.f505268a = r100;
            this.f505269b = r101;
        }
    }

    @Override // kotlinx.datetime.internal.format.n
    public final huc.e<T> a() {
        huc.e<T> r100 = this.f505265b.a();
        List<a<T, ? extends Object>> r101 = this.f505266c;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        a r104 = (a) r103.next();
        r102.add(new g(r104.f505269b, new OptionalFormatStructure$PropertyWithDefault$isDefaultComparisonPredicate$1(r104.f505268a)));
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r102, "predicates");
        if (r102.isEmpty() == false) goto L10;
        Object r105 = v.f505358a;
    L14:
        if ((r105 instanceof v) == false) goto L17;
        return new huc.c(this.f505264a);
    L17:
        return new huc.b(CollectionsKt.listOf(new Pair[]{TuplesKt.to(new OptionalFormatStructure$formatter$1(r105), new huc.c(this.f505264a)), TuplesKt.to(new OptionalFormatStructure$formatter$2(v.f505358a), r100)}));
    L10:
        if (r102.size() != 1) goto L12;
        r105 = (s) CollectionsKt.single(r102);
        goto L14
    L12:
        r105 = new i(r102);
        goto L14
    }

    public final int hashCode() {
        return (this.f505264a.hashCode() * 31) + this.f505265b.hashCode();
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [kotlinx.datetime.internal.format.r] */
    @Override // kotlinx.datetime.internal.format.n
    public final kotlinx.datetime.internal.format.parser.u<T> parser() {
        List r100 = CollectionsKt.emptyList();
        kotlinx.datetime.internal.format.parser.u[] r101 = new kotlinx.datetime.internal.format.parser.u[2];
        r101[0] = this.f505265b.parser();
        kotlinx.datetime.internal.format.parser.u[] r102 = new kotlinx.datetime.internal.format.parser.u[2];
        r102[0] = new j(this.f505264a).parser();
        if (((ArrayList) this.f505266c).isEmpty() == false) goto L5;
        List r103 = CollectionsKt.emptyList();
    L6:
        r102[1] = new kotlinx.datetime.internal.format.parser.u(r103, CollectionsKt.emptyList());
        r101[1] = kotlinx.datetime.internal.format.parser.q.a(CollectionsKt.listOf(r102));
        return new kotlinx.datetime.internal.format.parser.u(r100, CollectionsKt.listOf(r101));
    L5:
        r103 = CollectionsKt.listOf(new c0(new r(this)));
        goto L6
    }

    public final String toString() {
        return "Optional(" + this.f505264a + ", " + this.f505265b + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof OptionalFormatStructure) == false) goto L9;
        OptionalFormatStructure r101 = (OptionalFormatStructure) r100;
        if (Intrinsics.areEqual(this.f505264a, r101.f505264a) == false) goto L9;
        if (Intrinsics.areEqual(this.f505265b, r101.f505265b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public OptionalFormatStructure(String r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "onZero");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        this.f505264a = r100;
        this.f505265b = r101;
        List r102 = CollectionsKt.createListBuilder();
        o.a(r102, r101);
        List r103 = CollectionsKt.build(r102);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(((k) r105.next()).b());
        goto L4
    L6:
        List r106 = CollectionsKt.distinct(r104);
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L8:
        if (r108.hasNext() == false) goto L17;
        m r109 = (m) r108.next();
        int r110 = a.f505267c;
        Intrinsics.checkNotNullParameter(r109, "field");
        Object r111 = r109.getDefaultValue();
        if (r111 == null) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L16;
        r107.add(new a(r109.a(), r111));
        goto L8
    L16:
        throw new IllegalArgumentException(("The field '" + r109.getName() + "' does not define a default value").toString());
    L12:
        r112 = false;
        goto L13
    L17:
        this.f505266c = r107;
    }
}
