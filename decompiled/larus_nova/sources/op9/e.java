package op9;

import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {
    public static final String a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = MathKt.roundToInt((r100.f524790a.f514740i * 1.0f) / 1000);
        int r102 = r101 % 60;
        int r103 = r101 / 60;
        int r104 = r103 / 60;
        int r105 = r103 % 60;
        if (r104 != 0) goto L5;
        StringCompanionObject r106 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r105), Integer.valueOf(r102)}, 2));
    L5:
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r104), Integer.valueOf(r105), Integer.valueOf(r102)}, 3));
    }

    public static final c b(mp9.b r110, c r111, com.larus.photopicker.v2.impl.viewmodel.d r210) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        LinkedHashMap r100 = new LinkedHashMap();
        Iterator<T> r101 = r110.f514731f.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L52;
        Map.Entry r102 = (Map.Entry) r101.next();
        MediaTab r103 = (MediaTab) r102.getKey();
        List r104 = (List) r102.getValue();
        if (r111 == 0) goto L10;
        Map<MediaTab, List<d>> r105 = r111.f524789c;
        if (r105 == null) goto L10;
        List<d> r106 = r105.get(r103);
    L12:
        if (r106 == null) goto L17;
        List<d> r107 = r106;
        Map r112 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r107, 10)), 16));
        Iterator r108 = r107.iterator();
    L15:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        r112.put(Long.valueOf(((d) r109).f524790a.f514732a), r109);
    L18:
        List r113 = r104;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L20:
        if (r115.hasNext() == false) goto L50;
        mp9.c r116 = (mp9.c) r115.next();
        d r117 = (d) r112.get(Long.valueOf(r116.f514732a));
        if (r117 == null) goto L24;
        d r118 = d.a(r117, r116, false, 0, false, 30);
    L49:
        r114.add(r118);
        r210 = r210;
        goto L20
    L24:
        if (r210 == null) goto L26;
        boolean r119 = r210.g(r116.f514732a);
    L27:
        if (r210 == null) goto L47;
        long r120 = r116.f514732a;
        Set<d> r121 = r210.f364704f.getValue();
        if (r121 != null) goto L31;
    L30:
        int r122 = -1;
    L48:
        r118 = c(r116, r119, r122);
        goto L49
    L31:
        Iterator<T> r123 = r121.iterator();
        int r124 = 0;
    L33:
        if (r123.hasNext() == false) goto L44;
        Object r125 = r123.next();
        if (r124 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        if (((d) r125).f524790a.f514732a != r120) goto L40;
        boolean r126 = true;
    L41:
        if (r126 == true) goto L42;
        r124 = r124 + 1;
        goto L33
    L42:
        int r127 = r124;
    L45:
        if (r127 == (-1)) goto L30;
        r122 = r127 + 1;
        goto L48
    L40:
        r126 = false;
        goto L41
    L44:
        r127 = -1;
        goto L45
    L47:
        r122 = 0;
        goto L48
    L26:
        r119 = false;
        goto L27
    L50:
        r100.put(r103, r114);
        goto L4
    L17:
        r112 = MapsKt.emptyMap();
    L10:
        r106 = null;
        goto L12
    L52:
        return new c(r110.f514726a, r110, r100);
    }

    public static final d c(mp9.c r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new d(r100, r101, r102, null, 24);
    }
}
