package kotlin.ranges;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\r\u001a#\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n¢\u0006\u0002\b*\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b-\u0010.\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b0\u00101\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b2\u00103\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\b4\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b5\u00106\u001a\u001c\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\b:\u0010;\u001a\u001c\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\b<\u0010=\u001a\u001c\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004¢\u0006\u0004\b?\u0010@\u001a\u001c\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010C\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010C\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0011\u0010G\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010G\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0012\u0010I\u001a\u00020\u0005*\u00020%H\u0087\b¢\u0006\u0002\u0010J\u001a\u0019\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010L\u001a\u0012\u0010I\u001a\u00020\b*\u00020/H\u0087\b¢\u0006\u0002\u0010M\u001a\u0019\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010N\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u001a\f\u0010P\u001a\u000208*\u000208H\u0007\u001a\f\u0010P\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Q\u001a\u000208*\u0002082\u0006\u0010Q\u001a\u00020RH\u0087\u0004\u001a\u0015\u0010Q\u001a\u00020>*\u00020>2\u0006\u0010Q\u001a\u00020SH\u0087\u0004\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\bU\u0010V\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010T\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004¢\u0006\u0004\bY\u0010Z\u001a\u001c\u0010T\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", FilterData.FilterOptionItem.Type.RANGE, "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", RemoteMessageConst.TO, "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", SoloKtvContext.SOLO_PAGE_FIRST, "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    public URangesKt___URangesKt() {
    }

    public static final int first(UIntProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == true) goto L7;
        return r100.m10676getFirstpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r100 + " is empty.");
    }

    public static final UInt firstOrNull(UIntProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m9538boximpl(r100.m10676getFirstpVg5ArA());
    }

    public static final int last(UIntProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == true) goto L7;
        return r100.m10677getLastpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r100 + " is empty.");
    }

    public static final UInt lastOrNull(UIntProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m9538boximpl(r100.m10677getLastpVg5ArA());
    }

    private static final int random(UIntRange r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return random(r100, Random.Default);
    }

    private static final UInt randomOrNull(UIntRange r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return randomOrNull(r100, Random.Default);
    }

    public static final UIntProgression reversed(UIntProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return UIntProgression.Companion.m10678fromClosedRangeNkh28Cs(r100.m10677getLastpVg5ArA(), r100.m10676getFirstpVg5ArA(), -r100.getStep());
    }

    public static final long first(ULongProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == true) goto L7;
        return r100.m10685getFirstsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r100 + " is empty.");
    }

    public static final ULong firstOrNull(ULongProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m9617boximpl(r100.m10685getFirstsVKNKU());
    }

    public static final long last(ULongProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == true) goto L7;
        return r100.m10686getLastsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r100 + " is empty.");
    }

    public static final ULong lastOrNull(ULongProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m9617boximpl(r100.m10686getLastsVKNKU());
    }

    private static final long random(ULongRange r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return random(r100, Random.Default);
    }

    private static final ULong randomOrNull(ULongRange r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return randomOrNull(r100, Random.Default);
    }

    public static final ULongProgression reversed(ULongProgression r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ULongProgression.Companion.m10687fromClosedRange7ftBX0g(r100.m10686getLastsVKNKU(), r100.m10685getFirstsVKNKU(), -r100.getStep());
    }

    /* JADX INFO: renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m10694coerceAtLeast5PvTz6A(short r100, short r101) {
        if (Intrinsics.compare(r100 & 65535, 65535 & r101) < 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m10695coerceAtLeastJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) < 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m10696coerceAtLeastKr8caGY(byte r100, byte r101) {
        if (Intrinsics.compare(r100 & UByte.MAX_VALUE, r101 & UByte.MAX_VALUE) < 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m10697coerceAtLeasteb3DHEI(long r100, long r101) {
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) < 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m10698coerceAtMost5PvTz6A(short r100, short r101) {
        if (Intrinsics.compare(r100 & 65535, 65535 & r101) > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m10699coerceAtMostJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m10700coerceAtMostKr8caGY(byte r100, byte r101) {
        if (Intrinsics.compare(r100 & UByte.MAX_VALUE, r101 & UByte.MAX_VALUE) > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m10701coerceAtMosteb3DHEI(long r100, long r101) {
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    /* JADX INFO: renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m10702coerceInJPwROB0(long r100, ClosedRange<ULong> r101) {
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if ((r101 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((ULong) RangesKt.coerceIn(ULong.m9617boximpl(r100), (ClosedFloatingPointRange) r101)).m9675unboximpl();
    L7:
        if (r101.isEmpty() == true) goto L16;
        long r102 = r100 ^ Long.MIN_VALUE;
        if (Long.compare(r102, ((ULong) r101.getStart()).m9675unboximpl() ^ Long.MIN_VALUE) >= 0) goto L12;
        return ((ULong) r101.getStart()).m9675unboximpl();
    L12:
        if (Long.compare(r102, ((ULong) r101.getEndInclusive()).m9675unboximpl() ^ Long.MIN_VALUE) > 0) goto L14;
        return r100;
    L14:
        return ((ULong) r101.getEndInclusive()).m9675unboximpl();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r101 + '.');
    }

    /* JADX INFO: renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m10707coerceInwuiCnnA(int r100, ClosedRange<UInt> r101) {
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        if ((r101 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((UInt) RangesKt.coerceIn(UInt.m9538boximpl(r100), (ClosedFloatingPointRange) r101)).m9596unboximpl();
    L7:
        if (r101.isEmpty() == true) goto L16;
        int r102 = r100 ^ Integer.MIN_VALUE;
        if (Integer.compare(r102, ((UInt) r101.getStart()).m9596unboximpl() ^ Integer.MIN_VALUE) >= 0) goto L12;
        return ((UInt) r101.getStart()).m9596unboximpl();
    L12:
        if (Integer.compare(r102, ((UInt) r101.getEndInclusive()).m9596unboximpl() ^ Integer.MIN_VALUE) > 0) goto L14;
        return r100;
    L14:
        return ((UInt) r101.getEndInclusive()).m9596unboximpl();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r101 + '.');
    }

    /* JADX INFO: renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m10708contains68kG9v0(UIntRange r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        return r100.m10681containsWZ4Q5Ns(UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m10709containsGYNo2lE(ULongRange r100, ULong r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.m10690containsVKZWuLQ(r101.m9675unboximpl()) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m10710containsGab390E(ULongRange r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        return r100.m10690containsVKZWuLQ(ULong.m9623constructorimpl(((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m10711containsULbyJY(ULongRange r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        return r100.m10690containsVKZWuLQ(ULong.m9623constructorimpl(((long) r101) & 255));
    }

    /* JADX INFO: renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m10712containsZsK3CEQ(UIntRange r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        return r100.m10681containsWZ4Q5Ns(UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m10713containsbiwQdVI(UIntRange r100, UInt r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.m10681containsWZ4Q5Ns(r101.m9596unboximpl()) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m10714containsfz5IDCE(UIntRange r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        if (ULong.m9623constructorimpl(r101 >>> 32) == 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.m10681containsWZ4Q5Ns(UInt.m9544constructorimpl((int) r101)) == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m10715containsuhHAxoY(ULongRange r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$contains");
        return r100.m10690containsVKZWuLQ(ULong.m9623constructorimpl(((long) r101) & 65535));
    }

    /* JADX INFO: renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m10716downTo5PvTz6A(short r100, short r101) {
        return UIntProgression.Companion.m10678fromClosedRangeNkh28Cs(UInt.m9544constructorimpl(r100 & 65535), UInt.m9544constructorimpl(r101 & 65535), -1);
    }

    /* JADX INFO: renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m10717downToJ1ME1BU(int r100, int r101) {
        return UIntProgression.Companion.m10678fromClosedRangeNkh28Cs(r100, r101, -1);
    }

    /* JADX INFO: renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m10718downToKr8caGY(byte r100, byte r101) {
        return UIntProgression.Companion.m10678fromClosedRangeNkh28Cs(UInt.m9544constructorimpl(r100 & UByte.MAX_VALUE), UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE), -1);
    }

    /* JADX INFO: renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m10719downToeb3DHEI(long r100, long r101) {
        return ULongProgression.Companion.m10687fromClosedRange7ftBX0g(r100, r101, -1);
    }

    public static final int random(UIntRange r100, Random r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "random");
        return URandomKt.nextUInt(r101, r100);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    public static final UInt randomOrNull(UIntRange r100, Random r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "random");
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return UInt.m9538boximpl(URandomKt.nextUInt(r101, r100));
    }

    public static final ULongProgression step(ULongProgression r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r111 <= 0) goto L5;
        boolean r100 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r100, Long.valueOf(r111));
        ULongProgression.Companion r101 = ULongProgression.Companion;
        long r102 = r110.m10685getFirstsVKNKU();
        long r103 = r110.m10686getLastsVKNKU();
        if (r110.getStep() > 0) goto L11;
        r111 = -r111;
    L11:
        return r101.m10687fromClosedRange7ftBX0g(r102, r103, r111);
    L5:
        r100 = false;
        goto L6
    }

    /* JADX INFO: renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m10720until5PvTz6A(short r100, short r101) {
        int r102 = r101 & 65535;
        if (Intrinsics.compare(r102, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m9544constructorimpl(r100 & 65535), UInt.m9544constructorimpl(UInt.m9544constructorimpl(r102) - 1), null);
    }

    /* JADX INFO: renamed from: until-J1ME1BU, reason: not valid java name */
    public static UIntRange m10721untilJ1ME1BU(int r100, int r101) {
        if (Integer.compare(r101 ^ Integer.MIN_VALUE, Integer.MIN_VALUE) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(r100, UInt.m9544constructorimpl(r101 - 1), null);
    }

    /* JADX INFO: renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m10722untilKr8caGY(byte r100, byte r101) {
        int r102 = r101 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r102, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m9544constructorimpl(r100 & UByte.MAX_VALUE), UInt.m9544constructorimpl(UInt.m9544constructorimpl(r102) - 1), null);
    }

    /* JADX INFO: renamed from: until-eb3DHEI, reason: not valid java name */
    public static ULongRange m10723untileb3DHEI(long r100, long r101) {
        if (Long.compare(r101 ^ Long.MIN_VALUE, Long.MIN_VALUE) > 0) goto L7;
        return ULongRange.Companion.getEMPTY();
    L7:
        return new ULongRange(r100, ULong.m9623constructorimpl(r101 - ULong.m9623constructorimpl(((long) 1) & BodyPartID.bodyIdMax)), null);
    }

    public static final long random(ULongRange r100, Random r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "random");
        return URandomKt.nextULong(r101, r100);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    public static final ULong randomOrNull(ULongRange r100, Random r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "random");
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return ULong.m9617boximpl(URandomKt.nextULong(r101, r100));
    }

    public static final UIntProgression step(UIntProgression r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 <= 0) goto L5;
        boolean r102 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r102, Integer.valueOf(r101));
        UIntProgression.Companion r103 = UIntProgression.Companion;
        int r104 = r100.m10676getFirstpVg5ArA();
        int r105 = r100.m10677getLastpVg5ArA();
        if (r100.getStep() > 0) goto L11;
        r101 = -r101;
    L11:
        return r103.m10678fromClosedRangeNkh28Cs(r104, r105, r101);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m10703coerceInVKSA0NQ(short r100, short r101, short r102) {
        int r103 = r101 & 65535;
        int r104 = r102 & 65535;
        if (Intrinsics.compare(r103, r104) > 0) goto L12;
        int r105 = 65535 & r100;
        if (Intrinsics.compare(r105, r103) >= 0) goto L8;
        return r101;
    L8:
        if (Intrinsics.compare(r105, r104) <= 0) goto L10;
        return r102;
    L10:
        return r100;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m9774toStringimpl(r102) + " is less than minimum " + UShort.m9774toStringimpl(r101) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m10704coerceInWZ9TVnA(int r100, int r101, int r102) {
        int r103 = r101 ^ Integer.MIN_VALUE;
        int r104 = r102 ^ Integer.MIN_VALUE;
        if (Integer.compare(r103, r104) > 0) goto L12;
        int r105 = Integer.MIN_VALUE ^ r100;
        if (Integer.compare(r105, r103) >= 0) goto L8;
        return r101;
    L8:
        if (Integer.compare(r105, r104) <= 0) goto L10;
        return r102;
    L10:
        return r100;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m9590toStringimpl(r102) + " is less than minimum " + UInt.m9590toStringimpl(r101) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m10705coerceInb33U2AM(byte r100, byte r101, byte r102) {
        int r103 = r101 & UByte.MAX_VALUE;
        int r104 = r102 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r103, r104) > 0) goto L12;
        int r105 = r100 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r105, r103) >= 0) goto L8;
        return r101;
    L8:
        if (Intrinsics.compare(r105, r104) <= 0) goto L10;
        return r102;
    L10:
        return r100;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m9511toStringimpl(r102) + " is less than minimum " + UByte.m9511toStringimpl(r101) + '.');
    }

    /* JADX INFO: renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m10706coerceInsambcqE(long r100, long r101, long r110) {
        long r102 = r101 ^ Long.MIN_VALUE;
        long r103 = r110 ^ Long.MIN_VALUE;
        if (Long.compare(r102, r103) > 0) goto L12;
        long r104 = Long.MIN_VALUE ^ r100;
        if (Long.compare(r104, r102) >= 0) goto L8;
        return r101;
    L8:
        if (Long.compare(r104, r103) <= 0) goto L10;
        return r110;
    L10:
        return r100;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m9669toStringimpl(r110) + " is less than minimum " + ULong.m9669toStringimpl(r101) + '.');
    }
}
