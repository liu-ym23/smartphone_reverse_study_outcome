package xo6;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(Bundle r100, String r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r102 != 0) goto L6;
        return;
    L6:
        if ((r102 instanceof Boolean) == false) goto L9;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L9:
        if ((r102 instanceof String) == false) goto L12;
        r100.putString(r101, (String) r102);
        return;
    L12:
        if ((r102 instanceof Integer) == false) goto L15;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L15:
        if ((r102 instanceof Short) == false) goto L18;
        r100.putShort(r101, ((Number) r102).shortValue());
        return;
    L18:
        if ((r102 instanceof Long) == false) goto L21;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L21:
        if ((r102 instanceof Byte) == false) goto L24;
        r100.putByte(r101, ((Number) r102).byteValue());
        return;
    L24:
        if ((r102 instanceof byte[]) == false) goto L27;
        r100.putByteArray(r101, (byte[]) r102);
        return;
    L27:
        if ((r102 instanceof Character) == false) goto L30;
        r100.putChar(r101, ((Character) r102).charValue());
        return;
    L30:
        if ((r102 instanceof char[]) == false) goto L33;
        r100.putCharArray(r101, (char[]) r102);
        return;
    L33:
        if ((r102 instanceof CharSequence) == false) goto L36;
        r100.putCharSequence(r101, (CharSequence) r102);
        return;
    L36:
        if ((r102 instanceof Float) == false) goto L39;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L39:
        if ((r102 instanceof Double) == false) goto L42;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L42:
        if ((r102 instanceof boolean[]) == false) goto L45;
        r100.putBooleanArray(r101, (boolean[]) r102);
        return;
    L45:
        if ((r102 instanceof int[]) == false) goto L48;
        r100.putIntArray(r101, (int[]) r102);
        return;
    L48:
        if ((r102 instanceof long[]) == false) goto L51;
        r100.putLongArray(r101, (long[]) r102);
        return;
    L51:
        if ((r102 instanceof double[]) == false) goto L54;
        r100.putDoubleArray(r101, (double[]) r102);
        return;
    L54:
        if ((r102 instanceof Parcelable) == false) goto L57;
        r100.putParcelable(r101, (Parcelable) r102);
        return;
    L57:
        if ((r102 instanceof Serializable) == false) goto L61;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L61:
        throw new IllegalStateException("Type of property " + r101 + " is not supported");
    }
}
