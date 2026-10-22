package com.hihonor.push.framework.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import com.hihonor.push.framework.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class MessageCodec {
    private static final String BUNDLE_NEXT = "_next_item_";
    private static final String BUNDLE_VALUE = "_value_";
    public static final String PACKED_TYPE = "_packed_type_";
    private static final String TAG = "MessageCodec";
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_NULL = -1;

    private MessageCodec() {
    }

    public static Bundle formMessageEntity(IMessageEntity r100, Bundle r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        Class<?> r102 = r100.getClass();
    L6:
        if (r102 == null) goto L16;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        Field r106 = r103[r105];
        if (r106.isAnnotationPresent(Packed.class) == false) goto L14;
        formMessageField(r100, r106, r101);     // Catch: Throwable -> L13
    L13:
        r106.getName();
    L14:
        r105 = r105 + 1;
        goto L8
    L15:
        r102 = r102.getSuperclass();
    L16:
        return r101;
    }

    private static void formMessageField(IMessageEntity r100, Field r101, Bundle r102) {
        boolean r103 = r101.isAccessible();
        r101.setAccessible(true);
        put(r101.getName(), r101.get(r100), r102);
        r101.setAccessible(r103);
    }

    private static Object newInstance(Field r100, Bundle r101) {
        Object r102 = r101.get(r100.getName());
        if ((r102 instanceof Bundle) == true) goto L14;
    L13:
        return r102;
    L14:
        Bundle r103 = (Bundle) r102;     // Catch: Exception -> L11
        int r104 = r103.getInt(PACKED_TYPE, -1);     // Catch: Exception -> L11
        if (r104 == 1) goto L7;
        if (r104 != 0) goto L13;
        return parseMessageEntity((Bundle) r102, (IMessageEntity) r100.getType().newInstance());
    L7:
        return parseGenericType(r100.getGenericType(), r103);
    L12:
        return null;
    }

    private static List<Object> parseGenericType(Type r100, Bundle r101) {
        ArrayList r102 = new ArrayList();
    L3:
        r101 = r101.getBundle(BUNDLE_NEXT);
        if (r101 == null) goto L22;
        Object r103 = r101.get(BUNDLE_VALUE);
        if (r103.getClass().isPrimitive() == true) goto L21;
        if ((r103 instanceof Serializable) == true) goto L21;
        if ((r103 instanceof Bundle) == false) goto L3;
        Bundle r104 = (Bundle) r103;
        int r105 = r104.getInt(PACKED_TYPE, -1);
        if (r105 == 1) goto L20;
        if (r105 != 0) goto L18;
        r103 = parseMessageEntity(r104, (IMessageEntity) ((Class) ((ParameterizedType) r100).getActualTypeArguments()[0]).newInstance());
        goto L21
    L18:
        throw new InstantiationException("Unknown type can not be supported");
    L20:
        throw new InstantiationException("Nested List can not be supported");
    L21:
        r102.add(r103);
        goto L3
    L22:
        return r102;
    }

    public static IMessageEntity parseMessageEntity(Bundle r100, IMessageEntity r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        r100.setClassLoader(r101.getClass().getClassLoader());
        Class<?> r102 = r101.getClass();
    L6:
        if (r102 == null) goto L16;
        Field[] r103 = r102.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        Field r106 = r103[r105];
        if (r106.isAnnotationPresent(Packed.class) == false) goto L14;
        parseMessageField(r101, r106, r100);     // Catch: Throwable -> L13
    L13:
        r106.getName();
    L14:
        r105 = r105 + 1;
        goto L8
    L15:
        r102 = r102.getSuperclass();
    L16:
        return r101;
    }

    private static void parseMessageField(IMessageEntity r100, Field r101, Bundle r102) {
        Object r103 = newInstance(r101, r102);
        if (r103 == null) goto L6;
        boolean r104 = r101.isAccessible();
        r101.setAccessible(true);
        r101.set(r100, r103);
        r101.setAccessible(r104);
        return;
    }

    private static void put(String r100, Object r101, Bundle r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (putGenericType(r100, r101, r102) == false) goto L7;
        return;
    L7:
        if ((r101 instanceof CharSequence) == false) goto L10;
        r102.putCharSequence(r100, (CharSequence) r101);
        return;
    L10:
        if ((r101 instanceof Parcelable) == false) goto L13;
        r102.putParcelable(r100, (Parcelable) r101);
        return;
    L13:
        if ((r101 instanceof byte[]) == false) goto L16;
        r102.putByteArray(r100, (byte[]) r101);
        return;
    L16:
        if ((r101 instanceof List) == false) goto L19;
        putList(r100, (List) r101, r102);
        return;
    L19:
        if ((r101 instanceof Serializable) == false) goto L22;
        r102.putSerializable(r100, (Serializable) r101);
        return;
    L22:
        if ((r101 instanceof IMessageEntity) == false) goto L25;
        Bundle r103 = formMessageEntity((IMessageEntity) r101, new Bundle());
        r103.putInt(PACKED_TYPE, 0);
        r102.putBundle(r100, r103);
        return;
    }

    private static boolean putGenericType(String r100, Object r101, Bundle r102) {
        if ((r101 instanceof String) == false) goto L7;
        r102.putString(r100, (String) r101);
        return true;
    L7:
        if ((r101 instanceof Integer) == false) goto L11;
        r102.putInt(r100, ((Integer) r101).intValue());
        return true;
    L11:
        if ((r101 instanceof Short) == false) goto L15;
        r102.putShort(r100, ((Short) r101).shortValue());
        return true;
    L15:
        if ((r101 instanceof Long) == false) goto L19;
        r102.putLong(r100, ((Long) r101).longValue());
        return true;
    L19:
        if ((r101 instanceof Float) == false) goto L23;
        r102.putFloat(r100, ((Float) r101).floatValue());
        return true;
    L23:
        if ((r101 instanceof Double) == false) goto L27;
        r102.putDouble(r100, ((Double) r101).doubleValue());
        return true;
    L27:
        if ((r101 instanceof Boolean) == true) goto L30;
        return false;
    L30:
        r102.putBoolean(r100, ((Boolean) r101).booleanValue());
        return true;
    }

    private static void putList(String r100, List r101, Bundle r102) {
        Iterator r103 = r101.iterator();
        Bundle r104 = null;
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r105 = r103.next();
        if (r104 != null) goto L8;
        r104 = new Bundle();
        r102.putBundle(r100, r104);
        r104.putInt(PACKED_TYPE, 1);
    L8:
        r104 = putNext(BUNDLE_VALUE, r104, r105);
        goto L4
    }

    private static Bundle putNext(String r100, Bundle r101, Object r102) {
        Bundle r103 = new Bundle();
        put(r100, r102, r103);
        r101.putBundle(BUNDLE_NEXT, r103);
        return r103;
    }
}
