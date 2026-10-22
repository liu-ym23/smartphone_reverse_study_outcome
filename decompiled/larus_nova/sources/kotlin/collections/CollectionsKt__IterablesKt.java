package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Iterable", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "flatten", "", ChameleonOpenTracker.Stage.UNZIP, "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.CollectionsKt__IterablesKt$Iterable$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Function0<Iterator<T>> $iterator;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.$iterator.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function0<? extends Iterator<? extends T>> r100) {
            this.$iterator = r100;
        }
    }

    public CollectionsKt__IterablesKt() {
    }

    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "iterator");
        return new AnonymousClass1(r100);
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Collection) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((Collection) r100).size());
    }

    public static <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList();
        Iterator<? extends Iterable<? extends T>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        CollectionsKt.addAll(r101, r102.next());
        goto L4
    L6:
        return r101;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = CollectionsKt.collectionSizeOrDefault(r100, 10);
        ArrayList r102 = new ArrayList(r101);
        ArrayList r103 = new ArrayList(r101);
        Iterator<? extends Pair<? extends T, ? extends R>> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r105 = r104.next();
        r102.add(r105.getFirst());
        r103.add(r105.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r102, r103);
    }

    public static <T> int collectionSizeOrDefault(Iterable<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Collection) == true) goto L5;
        return r101;
    L5:
        return ((Collection) r100).size();
    }
}
