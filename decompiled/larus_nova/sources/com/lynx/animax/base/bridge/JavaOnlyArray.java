package com.lynx.animax.base.bridge;

import java.util.ArrayList;
import r4a.a;

/* JADX INFO: loaded from: classes32.dex */
public class JavaOnlyArray extends ArrayList<Object> implements a {
    public ArrayList<Object> asArrayList() {
        return this;
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return super.size();
    }

    public JavaOnlyArray() {
    }

    public String getString(int r100) {
        return (String) get(r100);
    }

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
        if ((r101 instanceof Number) == true) goto L38;
        if ((r101 instanceof Character) == true) goto L38;
        if ((r101 instanceof String) == false) goto L28;
        return ReadableType.String;
    L28:
        if ((r101 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r101 instanceof byte[]) == false) goto L36;
        return ReadableType.ByteArray;
    L36:
        throw new IllegalArgumentException("unsupported type " + r101.getClass() + " contained in JavaOnlyArray");
    L38:
        return ReadableType.Number;
    }

    public int getTypeIndex(int r100) {
        return getType(r100).ordinal();
    }

    public void pushArray(JavaOnlyArray r100) {
        add(r100);
    }

    public void pushByteArrayAsString(byte[] r100) {
        add(new String(r100));
    }

    public void pushString(String r100) {
        add(r100);
    }
}
