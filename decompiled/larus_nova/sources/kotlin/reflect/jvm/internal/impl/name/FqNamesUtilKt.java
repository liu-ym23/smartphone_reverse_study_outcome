package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class FqNamesUtilKt {

    /* JADX INFO: loaded from: classes42.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[State.values().length];
            r100[State.BEGINNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[State.AFTER_DOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[State.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final boolean isValidJavaFqName(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        State r101 = State.BEGINNING;
        int r102 = 0;
    L7:
        if (r102 >= r100.length()) goto L28;
        char r103 = r100.charAt(r102);
        int r104 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L23;
        if (r104 != 3) goto L21;
        if (r103 != '.') goto L18;
        r101 = State.AFTER_DOT;
    L26:
        r102 = r102 + 1;
        goto L7
    L18:
        if (Character.isJavaIdentifierPart(r103) == true) goto L26;
        return false;
    L21:
        throw new NoWhenBranchMatchedException();
    L23:
        if (Character.isJavaIdentifierStart(r103) == false) goto L24;
        r101 = State.MIDDLE;
        goto L26
    L24:
        return false;
    L28:
        if (r101 == State.AFTER_DOT) goto L38;
        return true;
    L38:
        return false;
    }

    public static final FqName parentOrNull(FqName r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isRoot() == false) goto L6;
        return null;
    L6:
        return r100.parent();
    }

    public static final <V> V findValueForMostSpecificFqname(FqName r100, Map<FqName, ? extends V> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "values");
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> r103 = r101.entrySet().iterator();
    L3:
        boolean r104 = true;
        if (r103.hasNext() == false) goto L14;
        Map.Entry<FqName, ? extends V> r105 = r103.next();
        FqName r106 = r105.getKey();
        if (Intrinsics.areEqual(r100, r106) == false) goto L8;
    L11:
        if (r104 == false) goto L3;
        r102.put(r105.getKey(), r105.getValue());
        goto L3
    L8:
        if (isChildOf(r100, r106) == true) goto L11;
        r104 = false;
        goto L11
    L14:
        if ((!r102.isEmpty()) == true) goto L17;
        r102 = null;
    L17:
        if (r102 != null) goto L19;
        return null;
    L19:
        Iterator r107 = r102.entrySet().iterator();
        if (r107.hasNext() == true) goto L22;
        Object r108 = null;
    L31:
        Map.Entry r109 = (Map.Entry) r108;
        if (r109 != null) goto L34;
        return null;
    L34:
        return (V) r109.getValue();
    L22:
        r108 = r107.next();
        if (r107.hasNext() == false) goto L31;
        int r110 = tail((FqName) ((Map.Entry) r108).getKey(), r100).asString().length();
    L26:
        Object r111 = r107.next();
        int r112 = tail((FqName) ((Map.Entry) r111).getKey(), r100).asString().length();
        if (r110 <= r112) goto L30;
        r108 = r111;
        r110 = r112;
    L30:
        if (r107.hasNext() == true) goto L26;
        goto L31
    }

    public static final boolean isChildOf(FqName r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        return Intrinsics.areEqual(parentOrNull(r100), r101);
    }

    public static final boolean isSubpackageOf(FqName r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        if (Intrinsics.areEqual(r100, r101) == false) goto L6;
        return true;
    L6:
        if (r101.isRoot() == false) goto L9;
        return true;
    L9:
        return isSubpackageOf(r100.asString(), r101.asString());
    }

    public static final FqName tail(FqName r100, FqName r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (isSubpackageOf(r100, r101) == true) goto L5;
        return r100;
    L5:
        if (r101.isRoot() == false) goto L8;
        return r100;
    L8:
        if (Intrinsics.areEqual(r100, r101) == false) goto L11;
        return FqName.ROOT;
    L11:
        return new FqName(r100.asString().substring(r101.asString().length() + 1));
    }

    private static final boolean isSubpackageOf(String r100, String r101) {
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == true) goto L5;
        return false;
    L5:
        if (r100.charAt(r101.length()) != '.') goto L9;
        return true;
    L9:
        return false;
    }
}
