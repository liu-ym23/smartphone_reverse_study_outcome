package com.relax.relaxui.value;

import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.TemplateData;
import f6a.a;
import f6a.b;
import f6a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray, d {
    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> asArrayList() {
        return this;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public PiperData getPiperData(int r100) {
        return null;
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushNull() {
        add(null);
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> toArrayList() {
        return new ArrayList(this);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.lynx.react.bridge.ReadableArray
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

    public static JavaOnlyArray from(List r100) {
        return new JavaOnlyArray(r100);
    }

    public static JavaOnlyArray of(Object... r100) {
        return new JavaOnlyArray(Arrays.asList(r100));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public JavaOnlyArray getArray(int r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyArray) == false) goto L7;
        return (JavaOnlyArray) r101;
    L7:
        if ((r101 instanceof com.lynx.react.bridge.JavaOnlyArray) == false) goto L11;
        return from((com.lynx.react.bridge.JavaOnlyArray) r101);
    L11:
        return new JavaOnlyArray();
    }

    public Object getAt(int r100) {
        return get(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean getBoolean(int r100) {
        return ((Boolean) get(r100)).booleanValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte getByte(int r100) {
        return ((Number) get(r100)).byteValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte[] getByteArray(int r100) {
        return (byte[]) get(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public char getChar(int r100) {
        return (char) ((Number) get(r100)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public double getDouble(int r100) {
        return ((Number) get(r100)).doubleValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public a getDynamic(int r100) {
        return new b(this, r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public int getInt(int r100) {
        return ((Number) get(r100)).intValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public long getLong(int r100) {
        return ((Number) get(r100)).longValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableMap getMap(int r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyMap) == false) goto L7;
        return (JavaOnlyMap) r101;
    L7:
        if ((r101 instanceof com.lynx.react.bridge.JavaOnlyMap) == false) goto L11;
        return JavaOnlyMap.from((com.lynx.react.bridge.JavaOnlyMap) r101);
    L11:
        return new JavaOnlyMap();
    }

    public Object getObject(int r100) {
        return get(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public short getShort(int r100) {
        return ((Number) get(r100)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public String getString(int r100) {
        return (String) get(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
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
        if ((r101 instanceof Number) == true) goto L42;
        if ((r101 instanceof Character) == true) goto L42;
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
        throw new IllegalArgumentException("unsupported type " + r101.getClass() + " contained in JavaOnlyArray");
    L42:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r100) {
        return getType(r100).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean isNull(int r100) {
        if (get(r100) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushArray(WritableArray r100) {
        add(r100);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushBoolean(boolean r100) {
        add(Boolean.valueOf(r100));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushByteArray(byte[] r100) {
        add(r100);
    }

    public void pushByteArrayAsString(byte[] r100) {
        add(new String(r100));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushDouble(double r100) {
        add(Double.valueOf(r100));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushInt(int r100) {
        add(Integer.valueOf(r100));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushLong(long r100) {
        add(Long.valueOf(r100));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushMap(WritableMap r100) {
        add(r100);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushPiperData(PiperData r100) {
        add(r100);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushString(String r100) {
        add(r100);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushTemplateData(TemplateData r100) {
        add(r100);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public /* bridge */ /* synthetic */ ReadableArray getArray(int r100) {
        return getArray(r100);
    }
}
