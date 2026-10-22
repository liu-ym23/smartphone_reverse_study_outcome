package com.larus.utils;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final Bundle c(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Bundle r101 = new Bundle(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair<String, ? extends Object> r104 = r100[r103];
        b(r101, r104.component1(), r104.component2());
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public static final void a(Bundle r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "map");
        Iterator<Map.Entry<String, ? extends Object>> r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, ? extends Object> r103 = r102.next();
        b(r100, r103.getKey(), r103.getValue());
        goto L4
    }

    public static final void b(Bundle r100, String r101, Object r102) {
        if (r102 != null) goto L5;
        r100.putString(r101, null);
        return;
    L5:
        if ((r102 instanceof Boolean) == false) goto L8;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L8:
        if ((r102 instanceof Byte) == false) goto L11;
        r100.putByte(r101, ((Number) r102).byteValue());
        return;
    L11:
        if ((r102 instanceof Character) == false) goto L14;
        r100.putChar(r101, ((Character) r102).charValue());
        return;
    L14:
        if ((r102 instanceof Double) == false) goto L17;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L17:
        if ((r102 instanceof Float) == false) goto L20;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L20:
        if ((r102 instanceof Integer) == false) goto L23;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L23:
        if ((r102 instanceof Long) == false) goto L26;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L26:
        if ((r102 instanceof Short) == false) goto L29;
        r100.putShort(r101, ((Number) r102).shortValue());
        return;
    L29:
        if ((r102 instanceof Bundle) == false) goto L32;
        r100.putBundle(r101, (Bundle) r102);
        return;
    L32:
        if ((r102 instanceof CharSequence) == false) goto L35;
        r100.putCharSequence(r101, (CharSequence) r102);
        return;
    L35:
        if ((r102 instanceof Parcelable) == false) goto L38;
        r100.putParcelable(r101, (Parcelable) r102);
        return;
    L38:
        if ((r102 instanceof boolean[]) == false) goto L41;
        r100.putBooleanArray(r101, (boolean[]) r102);
        return;
    L41:
        if ((r102 instanceof byte[]) == false) goto L44;
        r100.putByteArray(r101, (byte[]) r102);
        return;
    L44:
        if ((r102 instanceof char[]) == false) goto L47;
        r100.putCharArray(r101, (char[]) r102);
        return;
    L47:
        if ((r102 instanceof double[]) == false) goto L50;
        r100.putDoubleArray(r101, (double[]) r102);
        return;
    L50:
        if ((r102 instanceof float[]) == false) goto L53;
        r100.putFloatArray(r101, (float[]) r102);
        return;
    L53:
        if ((r102 instanceof int[]) == false) goto L56;
        r100.putIntArray(r101, (int[]) r102);
        return;
    L56:
        if ((r102 instanceof long[]) == false) goto L59;
        r100.putLongArray(r101, (long[]) r102);
        return;
    L59:
        if ((r102 instanceof short[]) == false) goto L62;
        r100.putShortArray(r101, (short[]) r102);
        return;
    L62:
        if ((r102 instanceof Object[]) == false) goto L78;
        Class<?> r103 = r102.getClass().getComponentType();
        Intrinsics.checkNotNull(r103);
        if (Parcelable.class.isAssignableFrom(r103) == false) goto L67;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r100.putParcelableArray(r101, (Parcelable[]) r102);
        return;
    L67:
        if (String.class.isAssignableFrom(r103) == false) goto L70;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r100.putStringArray(r101, (String[]) r102);
        return;
    L70:
        if (CharSequence.class.isAssignableFrom(r103) == false) goto L73;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r100.putCharSequenceArray(r101, (CharSequence[]) r102);
        return;
    L73:
        if (Serializable.class.isAssignableFrom(r103) == false) goto L76;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L76:
        throw new IllegalArgumentException("Illegal value array type " + r103.getCanonicalName() + " for key \"" + r101 + Typography.quote);
    L78:
        if ((r102 instanceof Serializable) == false) goto L81;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L81:
        if ((r102 instanceof IBinder) == false) goto L84;
        r100.putBinder(r101, (IBinder) r102);
        return;
    L84:
        if ((r102 instanceof Size) == false) goto L87;
        r100.putSize(r101, (Size) r102);
        return;
    L87:
        if ((r102 instanceof SizeF) == false) goto L91;
        r100.putSizeF(r101, (SizeF) r102);
        return;
    L91:
        throw new IllegalArgumentException("Illegal value type " + r102.getClass().getCanonicalName() + " for key \"" + r101 + Typography.quote);
    }
}
