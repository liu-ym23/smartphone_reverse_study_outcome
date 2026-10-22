package joa;

import android.os.Parcel;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    static {
    }

    public static boolean b(int r100) {
        if (r100 != 2) goto L5;
    L17:
        return true;
    L5:
        if (r100 == 4) goto L17;
        if (r100 == 21) goto L17;
        if (r100 == 11) goto L17;
        if (r100 == 12) goto L17;
        if (r100 == 16) goto L17;
        if (r100 == 17) goto L17;
        return false;
    }

    public static int a(int r100, int r101) throws IllegalArgumentException {
        if (r101 != 0) goto L4;
        return r100;
    L4:
        if (r101 > 0) goto L6;
    L9:
        if (r101 >= 0) goto L15;
        if (r100 < (Integer.MIN_VALUE - r101)) goto L15;
        return r100 + r101;
    L15:
        throw new IllegalArgumentException("Addition overflow: " + r100 + " + " + r101);
    L6:
        if (r100 > (Integer.MAX_VALUE - r101)) goto L9;
        return r100 + r101;
    }

    @JvmStatic
    public static final Object c(Parcel r100, ClassLoader r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r102 = r100.dataPosition();
        if (b(r100.readInt()) == false) goto L7;
        int r103 = r100.readInt();
        if (r103 < 0) goto L7;
        Integer r104 = Integer.valueOf(a(r100.dataPosition(), r103));
    L14:
        r100.setDataPosition(r102);     // Catch: Exception -> L10
        return r100.readValue(r101);
    L11:
        if (r104 == null) goto L13;
        r100.setDataPosition(r104.intValue());
    L13:
        return null;
    L7:
        r104 = null;
        goto L14
    }

    @JvmStatic
    public static final void d(Parcel r100, ClassLoader r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        int r102 = r100.dataPosition();
        if (b(r100.readInt()) == false) goto L8;
        int r103 = r100.readInt();
        if (r103 >= 0) goto L7;
        return;
    L7:
        r100.setDataPosition(a(r100.dataPosition(), r103));
        return;
    L8:
        r100.setDataPosition(r102);
        r100.readValue(r101);
    }
}
