package wra;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.alipay.sdk.m.u.i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static String b(Bundle r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        StringBuilder r101 = new StringBuilder(128);
        r101.append("Bundle[{");
        a(r100, r101);
        r101.append("}]");
        return r101.toString();
    }

    public static void a(Bundle r100, StringBuilder r101) {
        Iterator<String> r102 = r100.keySet().iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L46;
        String r104 = r102.next();
        if (r103 == true) goto L8;
        r101.append(", ");
    L8:
        r101.append(r104);
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        Object r105 = r100.get(r104);
        if ((r105 instanceof int[]) == false) goto L12;
        r101.append(Arrays.toString((int[]) r105));
    L45:
        r103 = false;
        goto L4
    L12:
        if ((r105 instanceof byte[]) == false) goto L18;
        byte[] r106 = (byte[]) r105;
        if (r106.length >= 102400) goto L16;
        r101.append(Arrays.toString(r106));
        goto L45
    L16:
        r101.append("byte[] in Bundle is too long, limit for 100K");
        goto L45
    L18:
        if ((r105 instanceof boolean[]) == false) goto L21;
        r101.append(Arrays.toString((boolean[]) r105));
        goto L45
    L21:
        if ((r105 instanceof short[]) == false) goto L24;
        r101.append(Arrays.toString((short[]) r105));
        goto L45
    L24:
        if ((r105 instanceof long[]) == false) goto L27;
        r101.append(Arrays.toString((long[]) r105));
        goto L45
    L27:
        if ((r105 instanceof float[]) == false) goto L30;
        r101.append(Arrays.toString((float[]) r105));
        goto L45
    L30:
        if ((r105 instanceof double[]) == false) goto L33;
        r101.append(Arrays.toString((double[]) r105));
        goto L45
    L33:
        if ((r105 instanceof String[]) == false) goto L36;
        r101.append(Arrays.toString((String[]) r105));
        goto L45
    L36:
        if ((r105 instanceof CharSequence[]) == false) goto L39;
        r101.append(Arrays.toString((CharSequence[]) r105));
        goto L45
    L39:
        if ((r105 instanceof Parcelable[]) == false) goto L42;
        r101.append(Arrays.toString((Parcelable[]) r105));
        goto L45
    L42:
        if ((r105 instanceof Bundle) == false) goto L44;
        r101.append(b((Bundle) r105));
        goto L45
    L44:
        r101.append(r105);
        goto L45
    }

    public static void c(Intent r100, StringBuilder r101) {
        String r102 = r100.getAction();
        boolean r103 = false;
        if (r102 == null) goto L5;
        r101.append("act=");
        r101.append(r102);
        boolean r104 = false;
    L6:
        Set<String> r105 = r100.getCategories();
        if (r105 == null) goto L18;
        if (r104 == true) goto L10;
        r101.append(' ');
    L10:
        r101.append("cat=[");
        Iterator<String> r106 = r105.iterator();
        boolean r107 = true;
    L12:
        if (r106.hasNext() == false) goto L17;
        String r108 = r106.next();
        if (r107 == true) goto L16;
        r101.append(',');
    L16:
        r101.append(r108);
        r107 = false;
        goto L12
    L17:
        r101.append("]");
        r104 = false;
    L18:
        Uri r109 = r100.getData();
        if (r109 == null) goto L33;
        if (r104 == true) goto L22;
        r101.append(' ');
    L22:
        r101.append("dat=");
        Method r110 = Uri.class.getDeclaredMethod("toSafeString", new Class[0]);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        r110.setAccessible(true);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
        String r111 = (String) r110.invoke(r109, new Object[0]);     // Catch: IllegalAccessException -> L25 InvocationTargetException -> L27 NoSuchMethodException -> L29
    L32:
        r101.append(r111);
        r104 = false;
        goto L33
    L25:
        e = move-exception;
        e.printStackTrace();
    L31:
        r111 = r109.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = move-exception;
        e.printStackTrace();
    L33:
        String r112 = r100.getType();
        if (r112 == null) goto L38;
        if (r104 == true) goto L37;
        r101.append(' ');
    L37:
        r101.append("typ=");
        r101.append(r112);
        r104 = false;
    L38:
        int r113 = r100.getFlags();
        if (r113 == 0) goto L43;
        if (r104 == true) goto L42;
        r101.append(' ');
    L42:
        r101.append("flg=0x");
        r101.append(Integer.toHexString(r113));
        r104 = false;
    L43:
        String r114 = r100.getPackage();
        if (r114 == null) goto L48;
        if (r104 == true) goto L47;
        r101.append(' ');
    L47:
        r101.append("pkg=");
        r101.append(r114);
        r104 = false;
    L48:
        ComponentName r115 = r100.getComponent();
        if (r115 == null) goto L53;
        if (r104 == true) goto L52;
        r101.append(' ');
    L52:
        r101.append("cmp=");
        r101.append(r115.flattenToShortString());
        r104 = false;
    L53:
        Rect r116 = r100.getSourceBounds();
        if (r116 == null) goto L59;
        if (r104 == true) goto L57;
        r101.append(' ');
    L57:
        r101.append("bnds=");
        r101.append(r116.toShortString());
        r104 = false;
    L59:
        if (r100.getClipData() == null) goto L63;
        if (r104 == true) goto L62;
        r101.append(' ');
    L62:
        r101.append("(has clip)");
    L64:
        Bundle r117 = r100.getExtras();
        if (r117 == null) goto L69;
        if (r103 == true) goto L68;
        r101.append(' ');
    L68:
        r101.append("extras={");
        a(r117, r101);
        r101.append('}');
    L69:
        Intent r118 = r100.getSelector();
        if (r118 == null) goto L78;
        r101.append(" sel=");
        c(r118, r101);
        r101.append(i.f25855d);
        return;
    L78:
        return;
    L63:
        r103 = r104;
        goto L64
    L5:
        r104 = true;
        goto L6
    }
}
