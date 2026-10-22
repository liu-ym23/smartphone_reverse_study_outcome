package la6;

import androidx.camera.video.AudioStats;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String a(Object r110) {
        if (r110 != null) goto L6;
        return null;
    L6:
        if ((r110 instanceof String) == true) goto L45;
        boolean r100 = true;
        if ((r110 instanceof Double) == false) goto L18;
        Number r111 = (Number) r110;
        long r101 = (long) r111.doubleValue();
        double r102 = r111.doubleValue();
        double r103 = r101;
        Intrinsics.checkNotNull(Double.valueOf(r102), "null cannot be cast to non-null type kotlin.Double");
        if (r102 == r103) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L47;
        return String.valueOf(r101);
    L47:
        return String.valueOf(r111.doubleValue());
    L18:
        if ((r110 instanceof Float) == false) goto L27;
        Number r112 = (Number) r110;
        long r104 = (long) r112.floatValue();
        float r105 = r112.floatValue();
        float r106 = r104;
        Intrinsics.checkNotNull(Float.valueOf(r105), "null cannot be cast to non-null type kotlin.Float");
        if (r105 == r106) goto L23;
        r100 = false;
    L23:
        if (r100 == false) goto L49;
        return String.valueOf(r104);
    L49:
        return String.valueOf(r112.floatValue());
    L27:
        if ((r110 instanceof Long) == false) goto L30;
        return r110.toString();
    L30:
        if ((r110 instanceof Integer) == false) goto L33;
        return r110.toString();
    L33:
        if ((r110 instanceof Short) == false) goto L36;
        return r110.toString();
    L36:
        if ((r110 instanceof Byte) == false) goto L39;
        return r110.toString();
    L39:
        if ((r110 instanceof Boolean) == false) goto L42;
        return r110.toString();
    L42:
        if ((r110 instanceof Character) == true) goto L44;
        return null;
    L44:
        return r110.toString();
    L45:
        return (String) r110;
    }

    @JvmStatic
    public static final boolean b(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof String) == false) goto L11;
        if (((CharSequence) r100).length() <= 0) goto L23;
    L9:
        return true;
    L23:
        return false;
    L11:
        if ((r100 instanceof Boolean) == false) goto L14;
        return ((Boolean) r100).booleanValue();
    L14:
        if ((r100 instanceof Number) == false) goto L9;
        double r101 = ((Number) r100).doubleValue();
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        boolean r102 = true;
    L19:
        if (r102 == false) goto L21;
        return false;
    L21:
        if (Double.isNaN(r101) == false) goto L9;
        return false;
    L18:
        r102 = false;
        goto L19
    }
}
