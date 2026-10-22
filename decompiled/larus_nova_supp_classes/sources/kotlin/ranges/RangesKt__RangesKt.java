package kotlin.ranges;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\n*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\u0087\n¢\u0006\u0002\u0010\r\u001a@\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0007*\u00020\b\"\u0018\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00070\u000e*\b\u0012\u0004\u0012\u0002H\u00070\u000b*\u0002H\t2\b\u0010\f\u001a\u0004\u0018\u0001H\u0007H\u0087\n¢\u0006\u0002\u0010\u000f\u001a0\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00070\n\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0087\u0002\u001a\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0087\u0002\u001a0\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000e\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0011*\u0002H\u00072\u0006\u0010\u0012\u001a\u0002H\u0007H\u0087\u0002¢\u0006\u0002\u0010\u0018\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0015H\u0087\u0002\u001a\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0016H\u0087\u0002¨\u0006\u0019"}, d2 = {"checkStepIsPositive", XmlPullParser.NO_NAMESPACE, "isPositive", XmlPullParser.NO_NAMESPACE, "step", XmlPullParser.NO_NAMESPACE, "contains", "T", XmlPullParser.NO_NAMESPACE, "R", "Lkotlin/ranges/ClosedRange;", XmlPullParser.NO_NAMESPACE, "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "Lkotlin/ranges/OpenEndRange;", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "rangeTo", XmlPullParser.NO_NAMESPACE, "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "rangeUntil", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/ranges/RangesKt")
class RangesKt__RangesKt {
    public RangesKt__RangesKt() {
    }

    public static final void checkStepIsPositive(boolean r2, Number r3) {
        Intrinsics.checkNotNullParameter(r3, "step");
        if (r2 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Step must be positive, was: " + r3 + '.');
    }

    private static final <T, R extends ClosedRange<T> & Iterable<? extends T>> boolean contains(R r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains((Comparable) r2) == false) goto L7;
        return true;
    }

    public static final <T extends Comparable<? super T>> ClosedRange<T> rangeTo(T r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "that");
        return new ComparableRange(r1, r2);
    }

    public static final <T extends Comparable<? super T>> OpenEndRange<T> rangeUntil(T r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "that");
        return new ComparableOpenEndRange(r1, r2);
    }

    private static final <T, R extends OpenEndRange<T> & Iterable<? extends T>> boolean contains(R r1, T r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.contains((Comparable) r2) == false) goto L7;
        return true;
    }

    public static ClosedFloatingPointRange<Double> rangeTo(double r1, double r3) {
        return new ClosedDoubleRange(r1, r3);
    }

    public static final OpenEndRange<Double> rangeUntil(double r1, double r3) {
        return new OpenEndDoubleRange(r1, r3);
    }

    public static ClosedFloatingPointRange<Float> rangeTo(float r1, float r2) {
        return new ClosedFloatRange(r1, r2);
    }

    public static final OpenEndRange<Float> rangeUntil(float r1, float r2) {
        return new OpenEndFloatRange(r1, r2);
    }
}
