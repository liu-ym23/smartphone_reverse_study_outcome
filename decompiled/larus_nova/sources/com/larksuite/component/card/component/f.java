package com.larksuite.component.card.component;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class f {
    public static final ReadableArray a(ReadableMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.asHashMap().get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if ((r102 instanceof ReadableArray) == true) goto L8;
        return null;
    L8:
        return (ReadableArray) r102;
    }

    public static final Boolean b(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Boolean) == true) goto L7;
        return null;
    L7:
        return (Boolean) r102;
    }

    public static final Byte d(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Byte.valueOf(r103.byteValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final Character e(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Character.valueOf((char) r103.intValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final Double f(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Double.valueOf(r103.doubleValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final Integer g(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r103.intValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final Long i(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Long.valueOf(r103.longValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final ReadableMap j(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof ReadableMap) == true) goto L7;
        return null;
    L7:
        return (ReadableMap) r102;
    }

    public static final ReadableMap k(ReadableMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r102 = r100.asHashMap().get(r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if ((r102 instanceof ReadableMap) == true) goto L8;
        return null;
    L8:
        return (ReadableMap) r102;
    }

    public static final Short l(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        return Short.valueOf(r103.shortValue());
    L5:
        r103 = null;
        goto L6
    }

    public static final String m(ReadableArray r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r102 = ListProtector.get(r100.asArrayList(), r101);
        if ((r102 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) r102;
    }

    public static final Boolean c(ReadableMap r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.asHashMap().get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if ((r103 instanceof Boolean) == true) goto L8;
        boolean r104 = true;
        if ((r103 instanceof Number) == false) goto L18;
        if (((Number) r103).intValue() != 0) goto L16;
        r104 = false;
    L16:
        return Boolean.valueOf(r104);
    L18:
        if ((r103 instanceof String) == false) goto L32;
        String r105 = (String) r103;
        if (StringsKt.equals(r105, "true", true) == true) goto L31;
        if (StringsKt.equals(r105, BdpAppEventConstant.YES, true) == true) goto L31;
        if (StringsKt.equals(r105, "false", true) == true) goto L29;
        if (StringsKt.equals(r105, BdpAppEventConstant.NO, true) == false) goto L32;
    L29:
        return Boolean.FALSE;
    L31:
        return Boolean.TRUE;
    L32:
        return r102;
    L8:
        return (Boolean) r103;
    }

    public static final Integer h(ReadableMap r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.asHashMap().get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if ((r103 instanceof Number) == false) goto L10;
        return Integer.valueOf(((Number) r103).intValue());
    L10:
        if ((r103 instanceof Boolean) == false) goto L14;
        return Integer.valueOf(((Boolean) r103).booleanValue() ? 1 : 0);
    L14:
        if ((r103 instanceof String) == true) goto L20;
    L19:
        return r102;
    L20:
        return Integer.valueOf(CastIntegerProtector.parseInt((String) r103));
    L17:
        e = move-exception;
        Log.d("LynxDataExtension", "safeGetInt exception: " + e.getMessage());
        goto L19
    }

    public static final String n(ReadableMap r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Object r103 = r100.asHashMap().get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if ((r103 instanceof String) == false) goto L10;
        return (String) r103;
    L10:
        if ((r103 instanceof Boolean) == false) goto L17;
        if (((Boolean) r103).booleanValue() == false) goto L14;
        return "true";
    L14:
        return "false";
    L17:
        if ((r103 instanceof Number) == true) goto L19;
        return r102;
    L19:
        return r103.toString();
    }
}
