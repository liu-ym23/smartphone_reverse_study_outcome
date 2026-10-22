package jxc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static Bundle a(Object r100, Bundle r101) {
        Class<?> r102 = r100.getClass();
    L3:
        if (r102 == null) goto L14;
        if (r102 == Object.class) goto L14;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        Field r106 = r103[r105];
        b(r100, r106, r101);     // Catch: Throwable -> L11
    L12:
        r105 = r105 + 1;
    L11:
        r106.getName();
        goto L12
    L13:
        r102 = r102.getSuperclass();
    L14:
        return r101;
    }

    public static void b(Object r100, Field r101, Bundle r102) {
        if (Modifier.isTransient(r101.getModifiers()) == true) goto L6;
        boolean r103 = r101.isAccessible();
        r101.setAccessible(true);
        c(r101.getName(), r101.get(r100), r102);
        r101.setAccessible(r103);
        return;
    }

    public static void c(String r100, Object r101, Bundle r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r101 instanceof String) == false) goto L7;
        r102.putString(r100, (String) r101);
        return;
    L7:
        if ((r101 instanceof Integer) == false) goto L10;
        r102.putInt(r100, ((Integer) r101).intValue());
        return;
    L10:
        if ((r101 instanceof Short) == false) goto L13;
        r102.putShort(r100, ((Short) r101).shortValue());
        return;
    L13:
        if ((r101 instanceof Long) == false) goto L16;
        r102.putLong(r100, ((Long) r101).longValue());
        return;
    L16:
        if ((r101 instanceof Float) == false) goto L19;
        r102.putFloat(r100, ((Float) r101).floatValue());
        return;
    L19:
        if ((r101 instanceof Double) == false) goto L22;
        r102.putDouble(r100, ((Double) r101).doubleValue());
        return;
    L22:
        if ((r101 instanceof Boolean) == false) goto L25;
        r102.putBoolean(r100, ((Boolean) r101).booleanValue());
        return;
    L25:
        if ((r101 instanceof CharSequence) == false) goto L28;
        r102.putCharSequence(r100, (CharSequence) r101);
        return;
    L28:
        if ((r101 instanceof IBinder) == false) goto L31;
        r102.putBinder(r100, (IBinder) r101);
        return;
    L31:
        if ((r101 instanceof Parcelable) == false) goto L34;
        r102.putParcelable(r100, (Parcelable) r101);
        return;
    L34:
        if ((r101 instanceof byte[]) == false) goto L36;
        r102.putByteArray(r100, (byte[]) r101);
        return;
    L36:
        int r103 = 0;
        if ((r101 instanceof List) == false) goto L44;
        List r104 = (List) r101;
        Bundle r105 = new Bundle();
        r105.putInt("_val_type_", 1);
        r105.putInt("_list_size_", r104.size());
    L40:
        if (r103 >= r104.size()) goto L42;
        c("_list_item_" + r103, ListProtector.get(r104, r103), r105);
        r103 = r103 + 1;
        goto L40
    L42:
        r102.putBundle(r100, r105);
        return;
    L44:
        if ((r101 instanceof Serializable) == false) goto L47;
        r102.putSerializable(r100, (Serializable) r101);
        return;
    L47:
        if (r101.getClass() == Object.class) goto L65;
        Bundle r106 = new Bundle();
        a(r101, r106);
        r106.putInt("_val_type_", 0);
        r102.putBundle(r100, r106);
        return;
    }
}
