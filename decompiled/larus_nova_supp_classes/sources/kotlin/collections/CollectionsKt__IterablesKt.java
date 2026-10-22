package kotlin.collections;

import android.util.EventsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Iterable", XmlPullParser.NO_NAMESPACE, "T", "iterator", "Lkotlin/Function0;", XmlPullParser.NO_NAMESPACE, "collectionSizeOrDefault", XmlPullParser.NO_NAMESPACE, "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "flatten", XmlPullParser.NO_NAMESPACE, "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public CollectionsKt__IterablesKt() {
    }

    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> r1) {
        Intrinsics.checkNotNullParameter(r1, "iterator");
        return new Iterable.1(r1);
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof Collection) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((Collection) r1).size());
    }

    public static <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<? extends Iterable<? extends T>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, r3.next());
        goto L4
    L6:
        return r0;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = CollectionsKt.collectionSizeOrDefault(r4, 10);
        ArrayList r1 = new ArrayList(r0);
        ArrayList r2 = new ArrayList(r0);
        Iterator<? extends Pair<? extends T, ? extends R>> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r3 = r5.next();
        r1.add(r3.getFirst());
        r2.add(r3.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r1, r2);
    }

    public static <T> int collectionSizeOrDefault(Iterable<? extends T> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof Collection) == true) goto L5;
        return r2;
    L5:
        return ((Collection) r1).size();
    }
}
