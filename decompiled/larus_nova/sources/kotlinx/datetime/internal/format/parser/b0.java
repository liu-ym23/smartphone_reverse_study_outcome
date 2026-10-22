package kotlinx.datetime.internal.format.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class b0<Output> implements r<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.datetime.internal.format.parser.a<Output, String> f505302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f505303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f505304c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Pair<String, a>> f505305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f505306b;

        public a() {
            this(null);
        }

        public a(Object r100) {
            ArrayList r101 = new ArrayList();
            Intrinsics.checkNotNullParameter(r101, "children");
            this.f505305a = r101;
            this.f505306b = false;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((String) ((Pair) r100).getFirst(), (String) ((Pair) r101).getFirst());
        }
    }

    public static final void b(a r100) {
        Iterator<Pair<String, a>> r101 = r100.f505305a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        b(r101.next().component2());
        goto L4
    L6:
        ArrayList r102 = new ArrayList();
        Iterator<Pair<String, a>> r103 = r100.f505305a.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Pair<String, a> r104 = r103.next();
        String r105 = r104.component1();
        a r106 = r104.component2();
        if (r106.f505306b == true) goto L14;
        if (r106.f505305a.size() != 1) goto L14;
        Pair r107 = (Pair) CollectionsKt.single(r106.f505305a);
        String r108 = (String) r107.component1();
        r102.add(TuplesKt.to(r105 + r108, (a) r107.component2()));
    L14:
        r102.add(TuplesKt.to(r105, r106));
        goto L8
    L15:
        r100.f505305a.clear();
        r100.f505305a.addAll(CollectionsKt.sortedWith(r102, new b()));
    }

    public b0(Collection r110, NamedUnsignedIntFieldFormatDirective.a r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "strings");
        Intrinsics.checkNotNullParameter(r111, "setter");
        Intrinsics.checkNotNullParameter(r112, "whatThisExpects");
        this.f505302a = r111;
        this.f505303b = r112;
        this.f505304c = new a(null);
        Iterator r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L24;
        String r114 = (String) r113.next();
        if (r114.length() <= 0) goto L8;
        boolean r100 = true;
    L9:
        if (r100 == false) goto L23;
        a r101 = this.f505304c;
        int r102 = r114.length();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L18;
        char r104 = r114.charAt(r103);
        List<Pair<String, a>> r105 = r101.f505305a;
        final String r106 = String.valueOf(r104);
        int r107 = CollectionsKt.binarySearch(r105, 0, r105.size(), new StringSetParserOperation$special$$inlined$binarySearchBy$default$1(r106));
        if (r107 >= 0) goto L15;
        a r108 = new a(null);
        ListProtector.add(r101.f505305a, (-r107) - 1, TuplesKt.to(String.valueOf(r104), r108));
        r101 = r108;
    L16:
        r103 = r103 + 1;
        goto L11
    L15:
        r101 = (a) ((Pair) ListProtector.get(r101.f505305a, r107)).getSecond();
        goto L16
    L18:
        if ((!r101.f505306b) == false) goto L21;
        r101.f505306b = true;
        goto L4
    L21:
        throw new IllegalArgumentException(("The string '" + r114 + "' was passed several times").toString());
    L23:
        throw new IllegalArgumentException(("Found an empty string in " + this.f505303b).toString());
    L8:
        r100 = false;
        goto L9
    L24:
        b(this.f505304c);
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public final Object a(c r110, final CharSequence r111, final int r112) {
        Intrinsics.checkNotNullParameter(r111, "input");
        a r100 = this.f505304c;
        final Ref.IntRef r101 = new Ref.IntRef();
        r101.element = r112;
        Integer r102 = null;
    L4:
        if (r101.element > r111.length()) goto L14;
        if (r100.f505306b == false) goto L8;
        r102 = Integer.valueOf(r101.element);
    L8:
        Iterator<Pair<String, a>> r103 = r100.f505305a.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Pair<String, a> r104 = r103.next();
        String r105 = r104.component1();
        a r106 = r104.component2();
        if (StringsKt.startsWith$default(r111, r105, r101.element, false, 4, null) == false) goto L10;
        r101.element += r105.length();
        r100 = r106;
    L14:
        if (r102 == null) goto L19;
        final kotlinx.datetime.internal.format.parser.a<Output, String> r107 = this.f505302a;
        final String r113 = r111.subSequence(r112, r102.intValue()).toString();
        int r108 = r102.intValue();
        final String r114 = r107.c(r110, r113);
        if (r114 != null) goto L18;
        int r115 = l.f505334a;
        return Integer.valueOf(r108);
    L18:
        int r109 = l.f505334a;
        return l.a.a(r112, new s(r114, r113, r107));
    L19:
        int r116 = l.f505334a;
        return l.a.a(r112, new a0(this, r111, r112, r101));
    }
}
