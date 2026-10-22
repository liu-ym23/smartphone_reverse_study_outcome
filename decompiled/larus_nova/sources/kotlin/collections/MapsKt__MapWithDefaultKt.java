package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt {
    public MapsKt__MapWithDefaultKt() {
    }

    public static <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> r100, K r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof MapWithDefault) == true) goto L5;
        V r102 = r100.get(r101);
        if (r102 == null) goto L9;
    L13:
        return r102;
    L9:
        if (r100.containsKey(r101) == true) goto L13;
        throw new NoSuchElementException("Key " + r101 + " is missing in the map.");
    L5:
        return (V) ((MapWithDefault) r100).getOrImplicitDefault(r101);
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> r100, Function1<? super K, ? extends V> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if ((r100 instanceof MapWithDefault) == false) goto L6;
        return withDefault(((MapWithDefault) r100).getMap(), r101);
    L6:
        return new MapWithDefaultImpl(r100, r101);
    }

    public static <K, V> Map<K, V> withDefaultMutable(Map<K, V> r100, Function1<? super K, ? extends V> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if ((r100 instanceof MutableMapWithDefault) == false) goto L6;
        return MapsKt.withDefaultMutable(((MutableMapWithDefault) r100).getMap(), r101);
    L6:
        return new MutableMapWithDefaultImpl(r100, r101);
    }
}
