package com.bytedance.vmsdk.jsbridge.utils;

import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import sp7.c;

/* JADX INFO: loaded from: classes3.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {

    /* JADX INFO: loaded from: classes22.dex */
    public class a implements ReadableMapKeySetIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<String> f272502a;

        @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
        public final boolean hasNextKey() {
            return this.f272502a.hasNext();
        }

        @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
        public final String nextKey() {
            return this.f272502a.next();
        }

        public a(JavaOnlyMap r100) {
            this.f272502a = r100.keySet().iterator();
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272503a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f272503a = r100;
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f272503a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f272503a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f272503a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f272503a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f272503a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f272503a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f272503a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f272503a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new a(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ArrayMap<String, Object> toArrayMap() {
        ArrayMap<String, Object> r100 = new ArrayMap();
        r100.putAll(this);
        return r100;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap(this);
    }

    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        if (size() != 0) goto L5;
        return r100;
    L5:
        Iterator r101 = keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L22;
        String r102 = (String) r101.next();
        Object r103 = get(r102);
        if (getType(r102) == ReadableType.Map) goto L11;
        if (getType(r102) == ReadableType.Array) goto L14;
        if (getType(r102) == ReadableType.Null) goto L17;
        r100.putOpt(r102, r103);     // Catch: Exception -> L20
        goto L7
    L17:
        r100.putOpt(r102, JSONObject.NULL);     // Catch: Exception -> L20
        goto L7
    L14:
        r100.putOpt(r102, ((JavaOnlyArray) r103).toJSONArray());     // Catch: Exception -> L20
        goto L7
    L11:
        r100.putOpt(r102, ((JavaOnlyMap) r103).toJSONObject());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.toString();
        goto L7
    L22:
        return r100;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int size() {
        return super.size();
    }

    public JavaOnlyMap() {
    }

    public JavaOnlyMap(Map r100) {
        super(r100);
    }

    public static JavaOnlyMap deepClone(ReadableMap r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L17;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        switch(b.f272503a[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L4;
        };
    L8:
        r101.putByteArray(r103, (byte[]) r100.getByteArray(r103).clone());
        goto L4
    L9:
        r101.putArray(r103, JavaOnlyArray.deepClone(r100.getArray(r103)));
        goto L4
    L10:
        r101.putMap(r103, deepClone(r100.getMap(r103)));
        goto L4
    L11:
        r101.putString(r103, r100.getString(r103));
        goto L4
    L12:
        r101.putDouble(r103, r100.getDouble(r103));
        goto L4
    L13:
        r101.putLong(r103, r100.getLong(r103));
        goto L4
    L14:
        r101.putInt(r103, r100.getInt(r103));
        goto L4
    L15:
        r101.putBoolean(r103, r100.getBoolean(r103));
        goto L4
    L16:
        r101.putNull(r103);
        goto L4
    L17:
        return r101;
    }

    public static JavaOnlyMap from(Map r100) {
        return new JavaOnlyMap(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public JavaOnlyArray getArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyArray) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r100);
    L5:
        return (JavaOnlyArray) r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Boolean) == true) goto L5;
        if (r101 == null) goto L10;
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r100);
    L10:
        throw new NullPointerException("key: " + r100);
    L5:
        return ((Boolean) r101).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof byte[]) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r100);
    L5:
        return (byte[]) r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == true) goto L5;
        if (r101 == null) goto L10;
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r100);
    L10:
        throw new NullPointerException("key: " + r100);
    L5:
        return ((Number) r101).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public sp7.a getDynamic(String r100) {
        c r101 = c.f542906c.acquire();
        if (r101 != null) goto L5;
        r101 = new c();
    L5:
        r101.f542907a = this;
        r101.f542908b = r100;
        return r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == true) goto L5;
        if (r101 == null) goto L10;
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r100);
    L10:
        throw new NullPointerException("key: " + r100);
    L5:
        return ((Number) r101).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == true) goto L5;
        if (r101 == null) goto L10;
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r100);
    L10:
        throw new NullPointerException("key: " + r100);
    L5:
        return ((Number) r101).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof ReadableMap) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r100);
    L5:
        return (ReadableMap) r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public NativeHostObject getNativeHostObject(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof NativeHostObject) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + r100);
    L5:
        return (NativeHostObject) r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof String) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.String, key: " + r100);
    L5:
        return (String) r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableType getType(String r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r101 instanceof Integer) == false) goto L11;
        return ReadableType.Int;
    L11:
        if ((r101 instanceof Long) == false) goto L15;
        return ReadableType.Long;
    L15:
        if ((r101 instanceof Number) == true) goto L50;
        if ((r101 instanceof Character) == true) goto L50;
        if ((r101 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r101 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r101 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r101 instanceof ReadableArray) == false) goto L36;
        return ReadableType.Array;
    L36:
        if ((r101 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r101 instanceof sp7.a) == false) goto L44;
        return ((sp7.a) r101).getType();
    L44:
        if ((r101 instanceof NativeHostObject) == false) goto L48;
        return ReadableType.NativeHostObject;
    L48:
        throw new IllegalArgumentException("Invalid value " + r101.toString() + " for key " + r100 + "contained in JavaOnlyMap");
    L50:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r100) {
        return getType(r100).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean hasKey(String r100) {
        return containsKey(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean isNull(String r100) {
        if (get(r100) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void merge(ReadableMap r100) {
        putAll((JavaOnlyMap) r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNull(String r100) {
        put(r100, null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public /* bridge */ /* synthetic */ ReadableArray getArray(String r100) {
        return getArray(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableArray getArray(String r100, ReadableArray r101) {
        Object r102 = get(r100);
        if ((r102 instanceof ReadableArray) == true) goto L5;
        return r101;
    L5:
        return (ReadableArray) r102;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String r100, boolean r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Boolean) == true) goto L5;
        return r101;
    L5:
        return ((Boolean) r102).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String r100, byte[] r101) {
        Object r102 = get(r100);
        if ((r102 instanceof byte[]) == true) goto L5;
        return r101;
    L5:
        return (byte[]) r102;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String r100, double r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == true) goto L5;
        return r101;
    L5:
        return ((Number) r102).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String r100, int r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == true) goto L5;
        return r101;
    L5:
        return ((Number) r102).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String r100, long r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == true) goto L5;
        return r101;
    L5:
        return ((Number) r102).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String r100, ReadableMap r101) {
        Object r102 = get(r100);
        if ((r102 instanceof ReadableMap) == true) goto L5;
        return r101;
    L5:
        return (ReadableMap) r102;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String r100, String r101) {
        Object r102 = get(r100);
        if ((r102 instanceof String) == true) goto L5;
        return r101;
    L5:
        return (String) r102;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putArray(String r100, WritableArray r101) {
        put(r100, r101);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putBoolean(String r100, boolean r101) {
        put(r100, Boolean.valueOf(r101));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArray(String r100, byte[] r101) {
        put(r100, r101);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArrayAsString(byte[] r100, byte[] r101) {
        put(new String(r100), new String(r101));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putDouble(String r100, double r101) {
        put(r100, Double.valueOf(r101));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putInt(String r100, int r101) {
        put(r100, Integer.valueOf(r101));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putLong(String r100, long r101) {
        put(r100, Long.valueOf(r101));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putMap(String r100, WritableMap r101) {
        put(r100, r101);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNativeHostObject(String r100, NativeHostObject r101) {
        put(r100, r101);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putString(String r100, String r101) {
        put(r100, r101);
    }
}
