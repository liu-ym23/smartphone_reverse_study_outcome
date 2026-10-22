package com.lynx.jsbridge;

import android.os.Bundle;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class Arguments {

    public static class a extends AbstractList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f381249a;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return Array.getLength(this.f381249a);
        }

        public a(Object r100) {
            this.f381249a = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public final Object get(int r100) {
            return Array.get(this.f381249a, r100);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381250a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f381250a = r100;
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f381250a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f381250a[ReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f381250a[ReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f381250a[ReadableType.Map.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f381250a[ReadableType.Array.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public Arguments() {
    }

    public static WritableArray createArray() {
        return new JavaOnlyArray();
    }

    public static WritableMap createMap() {
        return new JavaOnlyMap();
    }

    public static WritableArray fromArray(Object r100) {
        WritableArray r101 = createArray();
        int r102 = 0;
        if ((r100 instanceof String[]) == false) goto L8;
        String[] r103 = (String[]) r100;
        int r104 = r103.length;
    L5:
        if (r102 >= r104) goto L32;
        r101.pushString(r103[r102]);
        r102 = r102 + 1;
    L32:
        return r101;
    L8:
        if ((r100 instanceof Bundle[]) == false) goto L13;
        Bundle[] r105 = (Bundle[]) r100;
        int r106 = r105.length;
    L10:
        if (r102 >= r106) goto L32;
        r101.pushMap(fromBundle(r105[r102]));
        r102 = r102 + 1;
        goto L10
    L13:
        if ((r100 instanceof int[]) == false) goto L18;
        int[] r107 = (int[]) r100;
        int r108 = r107.length;
    L15:
        if (r102 >= r108) goto L32;
        r101.pushInt(r107[r102]);
        r102 = r102 + 1;
        goto L15
    L18:
        if ((r100 instanceof float[]) == false) goto L23;
        float[] r109 = (float[]) r100;
        int r110 = r109.length;
    L20:
        if (r102 >= r110) goto L32;
        r101.pushDouble(r109[r102]);
        r102 = r102 + 1;
        goto L20
    L23:
        if ((r100 instanceof double[]) == false) goto L28;
        double[] r111 = (double[]) r100;
        int r112 = r111.length;
    L25:
        if (r102 >= r112) goto L32;
        r101.pushDouble(r111[r102]);
        r102 = r102 + 1;
        goto L25
    L28:
        if ((r100 instanceof boolean[]) == false) goto L34;
        boolean[] r113 = (boolean[]) r100;
        int r114 = r113.length;
    L30:
        if (r102 >= r114) goto L32;
        r101.pushBoolean(r113[r102]);
        r102 = r102 + 1;
        goto L30
    L34:
        throw new IllegalArgumentException("Unknown array type " + r100.getClass());
    }

    public static WritableMap fromBundle(Bundle r100) {
        WritableMap r101 = createMap();
        Iterator<String> r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L31;
        String r103 = r102.next();
        Object r104 = r100.get(r103);
        if (r104 == null) goto L7;
        if (r104.getClass().isArray() == true) goto L10;
        if ((r104 instanceof String) == true) goto L13;
        if ((r104 instanceof Number) == true) goto L17;
        if ((r104 instanceof Boolean) == true) goto L22;
        if ((r104 instanceof Bundle) == true) goto L25;
        if ((r104 instanceof List) == false) goto L30;
        r101.putArray(r103, fromList((List) r104));
        goto L4
    L30:
        throw new IllegalArgumentException("Could not convert " + r104.getClass());
    L25:
        r101.putMap(r103, fromBundle((Bundle) r104));
        goto L4
    L22:
        r101.putBoolean(r103, ((Boolean) r104).booleanValue());
        goto L4
    L17:
        if ((r104 instanceof Integer) == true) goto L18;
        r101.putDouble(r103, ((Number) r104).doubleValue());
        goto L4
    L18:
        r101.putInt(r103, ((Integer) r104).intValue());
        goto L4
    L13:
        r101.putString(r103, (String) r104);
        goto L4
    L10:
        r101.putArray(r103, fromArray(r104));
        goto L4
    L7:
        r101.putNull(r103);
        goto L4
    L31:
        return r101;
    }

    public static JavaOnlyArray fromJavaArgs(Object[] r100) {
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L32;
        Object r103 = r100[r102];
        if (r103 != null) goto L8;
        r101.pushNull();
    L29:
        r102 = r102 + 1;
        goto L4
    L8:
        Class<?> r104 = r103.getClass();
        if (r104 != Boolean.class) goto L12;
        r101.pushBoolean(((Boolean) r103).booleanValue());
        goto L29
    L12:
        if (r104 != Integer.class) goto L15;
        r101.pushDouble(((Integer) r103).doubleValue());
        goto L29
    L15:
        if (r104 != Double.class) goto L18;
        r101.pushDouble(((Double) r103).doubleValue());
        goto L29
    L18:
        if (r104 != Float.class) goto L21;
        r101.pushDouble(((Float) r103).doubleValue());
        goto L29
    L21:
        if (r104 != String.class) goto L24;
        r101.pushString(r103.toString());
        goto L29
    L24:
        if (r104 != JavaOnlyMap.class) goto L27;
        r101.pushMap((JavaOnlyMap) r103);
        goto L29
    L27:
        if (r104 != JavaOnlyArray.class) goto L31;
        r101.pushArray((JavaOnlyArray) r103);
        goto L29
    L31:
        throw new RuntimeException("Cannot convert argument of type " + r104);
    L32:
        return r101;
    }

    public static WritableArray fromList(List r100) {
        WritableArray r101 = createArray();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L31;
        Object r103 = r102.next();
        if (r103 == null) goto L7;
        if (r103.getClass().isArray() == true) goto L10;
        if ((r103 instanceof Bundle) == true) goto L13;
        if ((r103 instanceof List) == true) goto L16;
        if ((r103 instanceof String) == true) goto L19;
        if ((r103 instanceof Integer) == true) goto L22;
        if ((r103 instanceof Number) == true) goto L25;
        if ((r103 instanceof Boolean) == false) goto L30;
        r101.pushBoolean(((Boolean) r103).booleanValue());
        goto L4
    L30:
        throw new IllegalArgumentException("Unknown value type " + r103.getClass());
    L25:
        r101.pushDouble(((Number) r103).doubleValue());
        goto L4
    L22:
        r101.pushInt(((Integer) r103).intValue());
        goto L4
    L19:
        r101.pushString((String) r103);
        goto L4
    L16:
        r101.pushArray(fromList((List) r103));
        goto L4
    L13:
        r101.pushMap(fromBundle((Bundle) r103));
        goto L4
    L10:
        r101.pushArray(fromArray(r103));
        goto L4
    L7:
        r101.pushNull();
        goto L4
    L31:
        return r101;
    }

    public static JavaOnlyArray makeNativeArray(List r100) {
        JavaOnlyArray r101 = new JavaOnlyArray();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L31;
        Object r103 = makeNativeObject(r102.next());
        if (r103 == null) goto L10;
        if ((r103 instanceof Boolean) == true) goto L13;
        if ((r103 instanceof Integer) == true) goto L16;
        if ((r103 instanceof Double) == true) goto L19;
        if ((r103 instanceof String) == true) goto L22;
        if ((r103 instanceof JavaOnlyArray) == true) goto L25;
        if ((r103 instanceof JavaOnlyMap) == false) goto L30;
        r101.pushMap((JavaOnlyMap) r103);
        goto L7
    L30:
        throw new IllegalArgumentException("Could not convert " + r103.getClass());
    L25:
        r101.pushArray((JavaOnlyArray) r103);
        goto L7
    L22:
        r101.pushString((String) r103);
        goto L7
    L19:
        r101.pushDouble(((Double) r103).doubleValue());
        goto L7
    L16:
        r101.pushInt(((Integer) r103).intValue());
        goto L7
    L13:
        r101.pushBoolean(((Boolean) r103).booleanValue());
        goto L7
    L10:
        r101.pushNull();
        goto L7
    L31:
        return r101;
    }

    public static JavaOnlyMap makeNativeMap(Map<String, Object> r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Object> r103 = r102.next();
        addEntry(r101, r103.getKey(), r103.getValue());
        goto L7
    L9:
        return r101;
    }

    private static Object makeNativeObject(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Float) == true) goto L31;
        if ((r100 instanceof Long) == true) goto L31;
        if ((r100 instanceof Byte) == true) goto L31;
        if ((r100 instanceof Short) == true) goto L31;
        if (r100.getClass().isArray() == false) goto L19;
        return makeNativeArray(r100);
    L19:
        if ((r100 instanceof List) == false) goto L23;
        return makeNativeArray((List) r100);
    L23:
        if ((r100 instanceof Map) == false) goto L27;
        return makeNativeMap((Map) r100);
    L27:
        if ((r100 instanceof Bundle) == true) goto L29;
        return r100;
    L29:
        return makeNativeMap((Bundle) r100);
    L31:
        return Double.valueOf(((Number) r100).doubleValue());
    }

    public static Bundle toBundle(ReadableMap r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ReadableMapKeySetIterator r101 = r100.keySetIterator();
        Bundle r102 = new Bundle();
    L7:
        if (r101.hasNextKey() == false) goto L18;
        String r103 = r101.nextKey();
        switch(b.f381250a[r100.getType(r103).ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L11:
        throw new IllegalArgumentException("Could not convert object with key: " + r103 + ".");
    L13:
        r102.putBundle(r103, toBundle(r100.getMap(r103)));
        goto L7
    L14:
        r102.putString(r103, r100.getString(r103));
        goto L7
    L15:
        r102.putDouble(r103, r100.getDouble(r103));
        goto L7
    L16:
        r102.putBoolean(r103, r100.getBoolean(r103));
        goto L7
    L17:
        r102.putString(r103, null);
        goto L7
    L12:
        r102.putSerializable(r103, toList(r100.getArray(r103)));
        goto L7
    L18:
        return r102;
    }

    public static ArrayList toList(ReadableArray r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L22;
        switch(b.f381250a[r100.getType(r102).ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        r101.add(toList(r100.getArray(r102)));
    L21:
        r102 = r102 + 1;
        goto L7
    L13:
        r101.add(toBundle(r100.getMap(r102)));
        goto L21
    L14:
        r101.add(r100.getString(r102));
        goto L21
    L15:
        double r103 = r100.getDouble(r102);
        if (r103 != Math.rint(r103)) goto L18;
        r101.add(Integer.valueOf((int) r103));
        goto L21
    L18:
        r101.add(Double.valueOf(r103));
        goto L21
    L19:
        r101.add(Boolean.valueOf(r100.getBoolean(r102)));
        goto L21
    L20:
        r101.add(null);
        goto L21
    L11:
        throw new IllegalArgumentException("Could not convert object in array.");
    L22:
        return r101;
    }

    public static <T> JavaOnlyArray makeNativeArray(Object r100) {
        if (r100 != null) goto L6;
        return new JavaOnlyArray();
    L6:
        return makeNativeArray(new a(r100));
    }

    public static JavaOnlyMap makeNativeMap(Bundle r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        String r103 = r102.next();
        addEntry(r101, r103, r100.get(r103));
        goto L7
    L9:
        return r101;
    }

    private static void addEntry(JavaOnlyMap r100, String r101, Object r102) {
        Object r103 = makeNativeObject(r102);
        if (r103 != null) goto L6;
        r100.putNull(r101);
        return;
    L6:
        if ((r103 instanceof Boolean) == false) goto L9;
        r100.putBoolean(r101, ((Boolean) r103).booleanValue());
        return;
    L9:
        if ((r103 instanceof Integer) == false) goto L12;
        r100.putInt(r101, ((Integer) r103).intValue());
        return;
    L12:
        if ((r103 instanceof Number) == false) goto L15;
        r100.putDouble(r101, ((Number) r103).doubleValue());
        return;
    L15:
        if ((r103 instanceof String) == false) goto L18;
        r100.putString(r101, (String) r103);
        return;
    L18:
        if ((r103 instanceof JavaOnlyArray) == false) goto L21;
        r100.putArray(r101, (JavaOnlyArray) r103);
        return;
    L21:
        if ((r103 instanceof JavaOnlyMap) == false) goto L25;
        r100.putMap(r101, (JavaOnlyMap) r103);
        return;
    L25:
        throw new IllegalArgumentException("Could not convert " + r103.getClass());
    }
}
