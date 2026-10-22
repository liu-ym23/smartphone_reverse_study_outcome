package kotlin.collections;

import android.util.EventsUtils;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"getOrImplicitDefault", "V", "K", XmlPullParser.NO_NAMESPACE, "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", XmlPullParser.NO_NAMESPACE, "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt {
    public MapsKt__MapWithDefaultKt() {
    }

    public static <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> r2, K r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof MapWithDefault) == true) goto L5;
        V r0 = r2.get(r3);
        if (r0 == null) goto L9;
    L13:
        return r0;
    L9:
        if (r2.containsKey(r3) == true) goto L13;
        throw new NoSuchElementException("Key " + r3 + " is missing in the map.");
    L5:
        return (V) ((MapWithDefault) r2).getOrImplicitDefault(r3);
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> r1, Function1<? super K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if ((r1 instanceof MapWithDefault) == false) goto L6;
        return withDefault(((MapWithDefault) r1).getMap(), r2);
    L6:
        return new MapWithDefaultImpl(r1, r2);
    }

    public static <K, V> Map<K, V> withDefaultMutable(Map<K, V> r1, Function1<? super K, ? extends V> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if ((r1 instanceof MutableMapWithDefault) == false) goto L6;
        return MapsKt.withDefaultMutable(((MutableMapWithDefault) r1).getMap(), r2);
    L6:
        return new MutableMapWithDefaultImpl(r1, r2);
    }
}
