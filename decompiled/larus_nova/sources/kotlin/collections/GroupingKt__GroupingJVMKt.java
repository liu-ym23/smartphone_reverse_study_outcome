package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingJVMKt() {
    }

    public static <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.sourceIterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        K r103 = r100.keyOf(r102.next());
        Object r104 = r101.get(r103);
        if (r104 == null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L13;
        r104 = new Ref.IntRef();
    L13:
        Ref.IntRef r106 = (Ref.IntRef) r104;
        r106.element++;
        r101.put(r103, r106);
        goto L4
    L8:
        if (r101.containsKey(r103) == true) goto L10;
        r105 = true;
        goto L11
    L14:
        Iterator<T> r107 = r101.entrySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L19;
        Map.Entry r108 = (Map.Entry) r107.next();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r108).setValue(Integer.valueOf(((Ref.IntRef) r108.getValue()).element));
        goto L16
    L19:
        return TypeIntrinsics.asMutableMap(r101);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> r100, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "f");
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        Map.Entry r103 = (Map.Entry) r102.next();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r103).setValue(r101.invoke(r103));
        goto L4
    L7:
        return TypeIntrinsics.asMutableMap(r100);
    }
}
