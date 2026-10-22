package kotlin.collections;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001aH\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", XmlPullParser.NO_NAMESPACE, "T", XmlPullParser.NO_NAMESPACE, "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", XmlPullParser.NO_NAMESPACE, "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", XmlPullParser.NO_NAMESPACE, "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", XmlPullParser.NO_NAMESPACE, "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", XmlPullParser.NO_NAMESPACE, "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public ArraysKt__ArraysKt() {
    }

    public static <T> String contentDeepToString(T[] r2) {
        if (r2 != null) goto L5;
        return "null";
    L5:
        StringBuilder r1 = new StringBuilder((RangesKt.coerceAtMost(r2.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(r2, r1, new ArrayList());
        return r1.toString();
    }

    public static final <T> List<T> flatten(T[][] r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r5[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        ArrayList r4 = new ArrayList(r3);
        int r6 = r5.length;
    L6:
        if (r1 >= r6) goto L8;
        CollectionsKt.addAll(r4, r5[r1]);
        r1 = r1 + 1;
        goto L6
    L8:
        return r4;
    }

    private static final boolean isNullOrEmpty(Object[] r2) {
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.length != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r3 = false;
        goto L8
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        ArrayList r0 = new ArrayList(r6.length);
        ArrayList r1 = new ArrayList(r6.length);
        int r2 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        Pair<? extends T, ? extends R> r4 = r6[r3];
        r0.add(r4.getFirst());
        r1.add(r4.getSecond());
        r3 = r3 + 1;
        goto L3
    L6:
        return TuplesKt.to(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean contentDeepEquals(T[] r7, T[] r8) {
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (r7 == 0) goto L116;
        if (r8 == 0) goto L116;
        if (r7.length != r8.length) goto L116;
        int r2 = r7.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L115;
        Object[] r4 = r7[r3];
        Object[] r5 = r8[r3];
        if (r4 == r5) goto L113;
        if (r4 == 0) goto L114;
        if (r5 == 0) goto L114;
        if ((r4 instanceof Object[]) == false) goto L27;
        if ((r5 instanceof Object[]) == false) goto L27;
        if (ArraysKt.contentDeepEquals(r4, r5) == true) goto L113;
        return false;
    L27:
        if ((r4 instanceof byte[]) == false) goto L34;
        if ((r5 instanceof byte[]) == false) goto L34;
        if (Arrays.equals((byte[]) r4, (byte[]) r5) == true) goto L113;
        return false;
    L34:
        if ((r4 instanceof short[]) == false) goto L41;
        if ((r5 instanceof short[]) == false) goto L41;
        if (Arrays.equals((short[]) r4, (short[]) r5) == true) goto L113;
        return false;
    L41:
        if ((r4 instanceof int[]) == false) goto L48;
        if ((r5 instanceof int[]) == false) goto L48;
        if (Arrays.equals((int[]) r4, (int[]) r5) == true) goto L113;
        return false;
    L48:
        if ((r4 instanceof long[]) == false) goto L55;
        if ((r5 instanceof long[]) == false) goto L55;
        if (Arrays.equals((long[]) r4, (long[]) r5) == true) goto L113;
        return false;
    L55:
        if ((r4 instanceof float[]) == false) goto L62;
        if ((r5 instanceof float[]) == false) goto L62;
        if (Arrays.equals((float[]) r4, (float[]) r5) == true) goto L113;
        return false;
    L62:
        if ((r4 instanceof double[]) == false) goto L69;
        if ((r5 instanceof double[]) == false) goto L69;
        if (Arrays.equals((double[]) r4, (double[]) r5) == true) goto L113;
        return false;
    L69:
        if ((r4 instanceof char[]) == false) goto L76;
        if ((r5 instanceof char[]) == false) goto L76;
        if (Arrays.equals((char[]) r4, (char[]) r5) == true) goto L113;
        return false;
    L76:
        if ((r4 instanceof boolean[]) == false) goto L83;
        if ((r5 instanceof boolean[]) == false) goto L83;
        if (Arrays.equals((boolean[]) r4, (boolean[]) r5) == true) goto L113;
        return false;
    L83:
        if ((r4 instanceof UByteArray) == false) goto L90;
        if ((r5 instanceof UByteArray) == false) goto L90;
        if (UArraysKt.contentEquals-kV0jMPg(((UByteArray) r4).unbox-impl(), ((UByteArray) r5).unbox-impl()) == true) goto L113;
        return false;
    L90:
        if ((r4 instanceof UShortArray) == false) goto L97;
        if ((r5 instanceof UShortArray) == false) goto L97;
        if (UArraysKt.contentEquals-FGO6Aew(((UShortArray) r4).unbox-impl(), ((UShortArray) r5).unbox-impl()) == true) goto L113;
        return false;
    L97:
        if ((r4 instanceof UIntArray) == false) goto L104;
        if ((r5 instanceof UIntArray) == false) goto L104;
        if (UArraysKt.contentEquals-KJPZfPQ(((UIntArray) r4).unbox-impl(), ((UIntArray) r5).unbox-impl()) == true) goto L113;
        return false;
    L104:
        if ((r4 instanceof ULongArray) == false) goto L111;
        if ((r5 instanceof ULongArray) == false) goto L111;
        if (UArraysKt.contentEquals-lec5QzE(((ULongArray) r4).unbox-impl(), ((ULongArray) r5).unbox-impl()) == true) goto L113;
        return false;
    L111:
        if (Intrinsics.areEqual(r4, r5) == true) goto L113;
        return false;
    L114:
        return false;
    L113:
        r3 = r3 + 1;
        goto L12
    L115:
        return true;
    L116:
        return false;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Object[] r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultValue");
        if (r1.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r1;
    L8:
        return r2.invoke();
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] r4, StringBuilder r5, List<Object[]> r6) {
        if (r6.contains(r4) == false) goto L6;
        r5.append("[...]");
        return;
    L6:
        r6.add(r4);
        r5.append('[');
        int r0 = r4.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L54;
        if (r1 == 0) goto L10;
        r5.append(", ");
    L10:
        Object[] r2 = r4[r1];
        if (r2 != 0) goto L14;
        r5.append("null");
    L53:
        r1 = r1 + 1;
        goto L7
    L14:
        if ((r2 instanceof Object[]) == false) goto L17;
        contentDeepToStringInternal$ArraysKt__ArraysKt(r2, r5, r6);
        goto L53
    L17:
        if ((r2 instanceof byte[]) == false) goto L20;
        r5.append(Arrays.toString((byte[]) r2));
        goto L53
    L20:
        if ((r2 instanceof short[]) == false) goto L23;
        r5.append(Arrays.toString((short[]) r2));
        goto L53
    L23:
        if ((r2 instanceof int[]) == false) goto L26;
        r5.append(Arrays.toString((int[]) r2));
        goto L53
    L26:
        if ((r2 instanceof long[]) == false) goto L29;
        r5.append(Arrays.toString((long[]) r2));
        goto L53
    L29:
        if ((r2 instanceof float[]) == false) goto L32;
        r5.append(Arrays.toString((float[]) r2));
        goto L53
    L32:
        if ((r2 instanceof double[]) == false) goto L35;
        r5.append(Arrays.toString((double[]) r2));
        goto L53
    L35:
        if ((r2 instanceof char[]) == false) goto L38;
        r5.append(Arrays.toString((char[]) r2));
        goto L53
    L38:
        if ((r2 instanceof boolean[]) == false) goto L41;
        r5.append(Arrays.toString((boolean[]) r2));
        goto L53
    L41:
        if ((r2 instanceof UByteArray) == false) goto L44;
        r5.append(UArraysKt.contentToString-2csIQuQ(((UByteArray) r2).unbox-impl()));
        goto L53
    L44:
        if ((r2 instanceof UShortArray) == false) goto L47;
        r5.append(UArraysKt.contentToString-d-6D3K8(((UShortArray) r2).unbox-impl()));
        goto L53
    L47:
        if ((r2 instanceof UIntArray) == false) goto L50;
        r5.append(UArraysKt.contentToString-XUkPCBk(((UIntArray) r2).unbox-impl()));
        goto L53
    L50:
        if ((r2 instanceof ULongArray) == false) goto L52;
        r5.append(UArraysKt.contentToString-uLth9ew(((ULongArray) r2).unbox-impl()));
        goto L53
    L52:
        r5.append(r2.toString());
        goto L53
    L54:
        r5.append(']');
        ListProtector.remove(r6, CollectionsKt.getLastIndex(r6));
    }
}
