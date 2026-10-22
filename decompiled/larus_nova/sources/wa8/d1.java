package wa8;

import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f558846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<CreationReferenceMediaType, g1> f558847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<h1> f558848d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d1) == true) goto L8;
        return false;
    L8:
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.f558845a, r101.f558845a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558846b, r101.f558846b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558847c, r101.f558847c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558848d, r101.f558848d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f558845a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        f1 r104 = this.f558846b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((r103 + r101) * 31) + this.f558847c.hashCode()) * 31) + this.f558848d.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationReferenceCapability(displayText=" + this.f558845a + ", mediaInfo=" + this.f558846b + ", mediaRules=" + this.f558847c + ", mixedRules=" + this.f558848d + ')';
    }

    public final Integer c() {
        Set<CreationReferenceMediaType> r100 = this.f558847c.keySet();
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        g1 r104 = this.f558847c.get((CreationReferenceMediaType) r103);
        if (r104 == null) goto L10;
        Integer r105 = r104.f558859b;
        if (r105 == null) goto L10;
        r101.put(r103, Integer.valueOf(r105.intValue()));
    L10:
        return null;
    L12:
        if ((!r101.isEmpty()) == true) goto L15;
        r101 = null;
    L15:
        if (r101 != null) goto L17;
        return null;
    L17:
        int r106 = CollectionsKt.sumOfInt(r101.values());
        Iterator<T> r107 = this.f558848d.iterator();
        int r108 = r106;
    L19:
        if (r107.hasNext() == false) goto L32;
        h1 r109 = (h1) r107.next();
        Integer r110 = r109.f558873b;
        if (r110 == null) goto L19;
        int r111 = r110.intValue();
        Iterator<T> r112 = r109.f558872a.iterator();
        int r113 = 0;
    L24:
        if (r112.hasNext() == false) goto L30;
        Integer r114 = (Integer) r101.get((CreationReferenceMediaType) r112.next());
        if (r114 == null) goto L28;
        int r115 = r114.intValue();
    L29:
        r113 = r113 + r115;
        goto L24
    L28:
        r115 = 0;
        goto L29
    L30:
        r108 = Math.min(r108, (r106 - r113) + r111);
        goto L19
    L32:
        return Integer.valueOf(r108);
    }

    public final boolean a(CreationReferenceMediaType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        g1 r101 = d(r100);
        if (r101 == null) goto L13;
        Integer r102 = r101.f558859b;
        if (r102 != null) goto L7;
        return false;
    L7:
        if (r102.intValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L15;
        return true;
    L15:
        return false;
    L9:
        r103 = false;
        goto L10
    L13:
        return false;
    }

    public final g1 d(CreationReferenceMediaType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.f558847c.get(r100);
    }

    public final boolean b(final CreationReferenceMediaType r100, Map<CreationReferenceMediaType, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "currentCounts");
        g1 r102 = d(r100);
        if (r102 == null) goto L43;
        Integer r103 = r102.f558859b;
        if (r103 == null) goto L44;
        int r104 = r103.intValue();
        if (r104 <= 0) goto L45;
        Integer r105 = r101.get(r100);
        if (r105 == null) goto L11;
        int r106 = RangesKt.coerceAtLeast(r105.intValue(), 0);
    L12:
        if (r106 >= r104) goto L46;
        Iterator r107 = SequencesKt.filter(CollectionsKt.asSequence(this.f558848d), new c1(r100)).iterator();
    L15:
        boolean r108 = true;
        if (r107.hasNext() == false) goto L32;
        h1 r109 = (h1) r107.next();
        Integer r110 = r109.f558873b;
        if (r110 == null) goto L30;
        int r111 = r110.intValue();
        Iterator<T> r112 = r109.f558872a.iterator();
        int r113 = 0;
    L21:
        if (r112.hasNext() == false) goto L27;
        Integer r114 = r101.get((CreationReferenceMediaType) r112.next());
        if (r114 == null) goto L25;
        int r115 = RangesKt.coerceAtLeast(r114.intValue(), 0);
    L26:
        r113 = r113 + r115;
        goto L21
    L25:
        r115 = 0;
        goto L26
    L27:
        if (r113 < r111) goto L30;
        r108 = false;
    L30:
        if (r108 == true) goto L15;
        return false;
    L32:
        return true;
    L46:
        return false;
    L11:
        r106 = 0;
        goto L12
    L45:
        return false;
    L44:
        return false;
    L43:
        return false;
    }

    public d1(String r100, f1 r101, Map<CreationReferenceMediaType, g1> r102, List<h1> r103) {
        Intrinsics.checkNotNullParameter(r102, "mediaRules");
        Intrinsics.checkNotNullParameter(r103, "mixedRules");
        this.f558845a = r100;
        this.f558846b = r101;
        this.f558847c = r102;
        this.f558848d = r103;
    }
}
