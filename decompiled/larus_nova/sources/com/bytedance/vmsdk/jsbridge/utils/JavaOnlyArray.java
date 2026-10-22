package com.bytedance.vmsdk.jsbridge.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import sp7.b;

/* JADX INFO: loaded from: classes3.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray {

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272501a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f272501a = r100;
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f272501a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f272501a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f272501a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f272501a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f272501a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f272501a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f272501a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f272501a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushNull() {
        add(null);
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public ArrayList<Object> toArrayList() {
        return new ArrayList(this);
    }

    public JSONArray toJSONArray() {
        JSONArray r100 = new JSONArray();
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L16;
        Object r103 = get(r102);
        if (getType(r102) != ReadableType.Map) goto L9;
        r100.put(((JavaOnlyMap) r103).toJSONObject());     // Catch: Exception -> L13
    L15:
        r102 = r102 + 1;
        goto L3
    L9:
        if (getType(r102) != ReadableType.Array) goto L11;
        r100.put(((JavaOnlyArray) r103).toJSONArray());     // Catch: Exception -> L13
        goto L15
    L11:
        r100.put(r103);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.toString();
        goto L15
    L16:
        return r100;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public int size() {
        return super.size();
    }

    public JavaOnlyArray() {
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
    }

    public JavaOnlyArray(List r100) {
        super(r100);
    }

    public static JavaOnlyArray deepClone(ReadableArray r100) {
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        ReadableType r104 = r100.getType(r103);
        switch(a.f272501a[r104.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L16;
        };
    L7:
        r101.pushByteArray((byte[]) r100.getByteArray(r103).clone());
        goto L16
    L8:
        r101.pushArray(deepClone(r100.getArray(r103)));
        goto L16
    L9:
        r101.pushMap(JavaOnlyMap.deepClone(r100.getMap(r103)));
        goto L16
    L10:
        r101.pushString(r100.getString(r103));
        goto L16
    L11:
        r101.pushDouble(r100.getDouble(r103));
        goto L16
    L12:
        r101.pushLong(r100.getLong(r103));
        goto L16
    L13:
        r101.pushInt(r100.getInt(r103));
        goto L16
    L14:
        r101.pushBoolean(r100.getBoolean(r103));
        goto L16
    L15:
        r101.pushNull();
    L16:
        r103 = r103 + 1;
        goto L3
    L17:
        return r101;
    }

    public static JavaOnlyArray from(List r100) {
        return new JavaOnlyArray(r100);
    }

    public static JavaOnlyArray of(Object... r100) {
        if (r100 != null) goto L6;
        return new JavaOnlyArray();
    L6:
        return new JavaOnlyArray(Arrays.asList(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public JavaOnlyArray getArray(int r100) {
        return (JavaOnlyArray) get(r100);
    }

    public Object getAt(int r100) {
        return get(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public boolean getBoolean(int r100) {
        return ((Boolean) get(r100)).booleanValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public byte getByte(int r100) {
        return ((Number) get(r100)).byteValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public byte[] getByteArray(int r100) {
        return (byte[]) get(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public char getChar(int r100) {
        return (char) ((Number) get(r100)).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public double getDouble(int r100) {
        return ((Number) get(r100)).doubleValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public sp7.a getDynamic(int r100) {
        b r101 = b.f542903c.acquire();
        if (r101 != null) goto L5;
        r101 = new b();
    L5:
        r101.f542904a = this;
        r101.f542905b = r100;
        return r101;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public int getInt(int r100) {
        return ((Number) get(r100)).intValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public long getLong(int r100) {
        return ((Number) get(r100)).longValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public JavaOnlyMap getMap(int r100) {
        return (JavaOnlyMap) get(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public NativeHostObject getNativeHostObject(int r100) {
        return (NativeHostObject) get(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public short getShort(int r100) {
        return ((Number) get(r100)).shortValue();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public String getString(int r100) {
        return (String) get(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public ReadableType getType(int r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r101 instanceof Boolean) == false) goto L11;
        return ReadableType.Boolean;
    L11:
        if ((r101 instanceof Integer) == false) goto L15;
        return ReadableType.Int;
    L15:
        if ((r101 instanceof Long) == false) goto L19;
        return ReadableType.Long;
    L19:
        if ((r101 instanceof Number) == true) goto L46;
        if ((r101 instanceof Character) == true) goto L46;
        if ((r101 instanceof String) == false) goto L28;
        return ReadableType.String;
    L28:
        if ((r101 instanceof ReadableArray) == false) goto L32;
        return ReadableType.Array;
    L32:
        if ((r101 instanceof ReadableMap) == false) goto L36;
        return ReadableType.Map;
    L36:
        if ((r101 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r101 instanceof NativeHostObject) == true) goto L42;
        return null;
    L42:
        return ReadableType.NativeHostObject;
    L46:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r100) {
        return getType(r100).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public boolean isNull(int r100) {
        if (get(r100) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushArray(WritableArray r100) {
        add(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushBoolean(boolean r100) {
        add(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushByteArray(byte[] r100) {
        add(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushByteArrayAsString(byte[] r100) {
        add(new String(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushDouble(double r100) {
        add(Double.valueOf(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushInt(int r100) {
        add(Integer.valueOf(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushLong(long r100) {
        add(Long.valueOf(r100));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushMap(WritableMap r100) {
        add(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void pushString(String r100) {
        add(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableArray
    public void putNativeHostObject(NativeHostObject r100) {
        add(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r100) {
        return getArray(r100);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableArray
    public /* bridge */ /* synthetic */ ReadableMap getMap(int r100) {
        return getMap(r100);
    }
}
