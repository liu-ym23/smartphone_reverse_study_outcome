package cq;

import androidx.camera.video.AudioStats;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final String a(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L45;
        boolean r101 = true;
        if ((r100 instanceof Double) == false) goto L18;
        Number r102 = (Number) r100;
        long r103 = (long) r102.doubleValue();
        if (r102.doubleValue() == r103) goto L14;
        r101 = false;
    L14:
        if (r101 == false) goto L47;
        return String.valueOf(r103);
    L47:
        return r100.toString();
    L18:
        if ((r100 instanceof Float) == false) goto L27;
        Number r104 = (Number) r100;
        long r105 = (long) r104.floatValue();
        if (r104.floatValue() == r105) goto L23;
        r101 = false;
    L23:
        if (r101 == false) goto L49;
        return String.valueOf(r105);
    L49:
        return r100.toString();
    L27:
        if ((r100 instanceof Long) == false) goto L30;
        return r100.toString();
    L30:
        if ((r100 instanceof Integer) == false) goto L33;
        return r100.toString();
    L33:
        if ((r100 instanceof Short) == false) goto L36;
        return r100.toString();
    L36:
        if ((r100 instanceof Byte) == false) goto L39;
        return r100.toString();
    L39:
        if ((r100 instanceof Boolean) == false) goto L42;
        return r100.toString();
    L42:
        if ((r100 instanceof Character) == true) goto L44;
        return null;
    L44:
        return r100.toString();
    L45:
        return (String) r100;
    }

    @JvmStatic
    public static final boolean b(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof String) == false) goto L11;
        if (((CharSequence) r100).length() <= 0) goto L21;
    L19:
        return true;
    L21:
        return false;
    L11:
        if ((r100 instanceof Boolean) == false) goto L14;
        return ((Boolean) r100).booleanValue();
    L14:
        if ((r100 instanceof Number) == false) goto L19;
        double r101 = ((Number) r100).doubleValue();
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L18;
        return false;
    L18:
        if (Double.isNaN(r101) == false) goto L19;
        return false;
    }
}
