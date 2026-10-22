package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class MessageCodec {
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    public MessageCodec() {
    }

    private Object a(Field r100, Bundle r101) {
        Object r102 = r101.get(r100.getName());
        if ((r102 instanceof Bundle) == true) goto L14;
    L13:
        return r102;
    L14:
        Bundle r103 = (Bundle) r102;     // Catch: Exception -> L11
        int r104 = r103.getInt(VAL_TYPE, -1);     // Catch: Exception -> L11
        if (r104 == 1) goto L7;
        if (r104 != 0) goto L13;
        Bundle r105 = (Bundle) r102;     // Catch: Exception -> L11
        return decode(r105, (IMessageEntity) r100.getType().newInstance());
    L7:
        return readList(r100.getGenericType(), r103);
    L12:
        return null;
    }

    public IMessageEntity decode(Bundle r100, IMessageEntity r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        r100.setClassLoader(getClass().getClassLoader());
        Class<?> r102 = r101.getClass();
    L5:
        if (r102 == null) goto L15;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L14;
        Field r106 = r103[r105];
        if (r106.isAnnotationPresent(Packed.class) == false) goto L13;
        a(r101, r106, r100);     // Catch: Throwable -> L12
    L12:
        r106.getName();
    L13:
        r105 = r105 + 1;
        goto L7
    L14:
        r102 = r102.getSuperclass();
        goto L5
    L15:
        return r101;
    }

    public Bundle encode(IMessageEntity r100, Bundle r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        Class<?> r102 = r100.getClass();
    L5:
        if (r102 == null) goto L15;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L14;
        Field r106 = r103[r105];
        if (r106.isAnnotationPresent(Packed.class) == false) goto L13;
        b(r100, r106, r101);     // Catch: Throwable -> L12
    L12:
        r106.getName();
    L13:
        r105 = r105 + 1;
        goto L7
    L14:
        r102 = r102.getSuperclass();
        goto L5
    L15:
        return r101;
    }

    public List<Object> readList(Type r100, Bundle r101) throws InstantiationException, IllegalAccessException {
        ArrayList r102 = new ArrayList();
        Bundle r103 = r101.getBundle("_next_item_");
    L3:
        if (r103 == null) goto L23;
        Object r104 = r103.get("_value_");
        if (r104.getClass().isPrimitive() == false) goto L7;
    L21:
        r102.add(r104);
    L22:
        r103 = r103.getBundle("_next_item_");
        goto L3
    L7:
        if ((r104 instanceof String) == true) goto L21;
        if ((r104 instanceof Serializable) == true) goto L21;
        if ((r104 instanceof Bundle) == false) goto L22;
        Bundle r105 = (Bundle) r104;
        int r106 = r105.getInt(VAL_TYPE, -1);
        if (r106 == 1) goto L20;
        if (r106 != 0) goto L18;
        r102.add(decode(r105, (IMessageEntity) ((Class) ((ParameterizedType) r100).getActualTypeArguments()[0]).newInstance()));
        goto L22
    L18:
        throw new InstantiationException("Unknown type can not be supported");
    L20:
        throw new InstantiationException("Nested List can not be supported");
    L23:
        return r102;
    }

    private boolean a(String r100, Object r101, Bundle r102) {
        if ((r101 instanceof String) == false) goto L6;
        r102.putString(r100, (String) r101);
        return true;
    L6:
        if ((r101 instanceof Integer) == false) goto L9;
        r102.putInt(r100, ((Integer) r101).intValue());
        return true;
    L9:
        if ((r101 instanceof Short) == false) goto L12;
        r102.putShort(r100, ((Short) r101).shortValue());
        return true;
    L12:
        if ((r101 instanceof Long) == false) goto L15;
        r102.putLong(r100, ((Long) r101).longValue());
        return true;
    L15:
        if ((r101 instanceof Float) == false) goto L18;
        r102.putFloat(r100, ((Float) r101).floatValue());
        return true;
    L18:
        if ((r101 instanceof Double) == false) goto L21;
        r102.putDouble(r100, ((Double) r101).doubleValue());
        return true;
    L21:
        if ((r101 instanceof Boolean) == false) goto L25;
        r102.putBoolean(r100, ((Boolean) r101).booleanValue());
        return true;
    L25:
        return false;
    }

    private void b(IMessageEntity r100, Field r101, Bundle r102) throws IllegalAccessException {
        boolean r103 = r101.isAccessible();
        r101.setAccessible(true);
        writeValue(r101.getName(), r101.get(r100), r102);
        r101.setAccessible(r103);
    }

    public void writeList(String r100, List r101, Bundle r102) {
        Iterator r103 = r101.iterator();
        Bundle r104 = null;
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r105 = r103.next();
        if (r104 != null) goto L8;
        r104 = new Bundle();
        r102.putBundle(r100, r104);
        r104.putInt(VAL_TYPE, 1);
    L8:
        r104 = a("_value_", r104, r105);
        goto L4
    }

    public void writeValue(String r100, Object r101, Bundle r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (a(r100, r101, r102) == false) goto L8;
        return;
    L8:
        if ((r101 instanceof CharSequence) == false) goto L11;
        r102.putCharSequence(r100, (CharSequence) r101);
        return;
    L11:
        if ((r101 instanceof Parcelable) == false) goto L14;
        r102.putParcelable(r100, (Parcelable) r101);
        return;
    L14:
        if ((r101 instanceof byte[]) == false) goto L17;
        r102.putByteArray(r100, (byte[]) r101);
        return;
    L17:
        if ((r101 instanceof List) == false) goto L20;
        writeList(r100, (List) r101, r102);
        return;
    L20:
        if ((r101 instanceof Serializable) == false) goto L23;
        r102.putSerializable(r100, (Serializable) r101);
        return;
    L23:
        if ((r101 instanceof IMessageEntity) == false) goto L26;
        Bundle r103 = encode((IMessageEntity) r101, new Bundle());
        r103.putInt(VAL_TYPE, 0);
        r102.putBundle(r100, r103);
        return;
    }

    private void a(IMessageEntity r100, Field r101, Bundle r102) throws IllegalAccessException {
        Object r103 = a(r101, r102);
        if (r103 == null) goto L6;
        boolean r104 = r101.isAccessible();
        r101.setAccessible(true);
        r101.set(r100, r103);
        r101.setAccessible(r104);
        return;
    }

    private Bundle a(String r100, Bundle r101, Object r102) {
        Bundle r103 = new Bundle();
        writeValue(r100, r102, r103);
        r101.putBundle("_next_item_", r103);
        return r103;
    }
}
