package com.bytedance.vmsdk.jsbridge.utils;

import androidx.collection.ArrayMap;
import java.util.HashMap;
import sp7.a;

/* JADX INFO: loaded from: classes3.dex */
public interface ReadableMap {
    ReadableArray getArray(String r100);

    ReadableArray getArray(String r100, ReadableArray r101);

    boolean getBoolean(String r100);

    boolean getBoolean(String r100, boolean r101);

    byte[] getByteArray(String r100);

    byte[] getByteArray(String r100, byte[] r101);

    double getDouble(String r100);

    double getDouble(String r100, double r101);

    a getDynamic(String r100);

    int getInt(String r100);

    int getInt(String r100, int r101);

    long getLong(String r100);

    long getLong(String r100, long r101);

    ReadableMap getMap(String r100);

    ReadableMap getMap(String r100, ReadableMap r101);

    NativeHostObject getNativeHostObject(String r100);

    String getString(String r100);

    String getString(String r100, String r101);

    ReadableType getType(String r100);

    boolean hasKey(String r100);

    boolean isNull(String r100);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    ArrayMap<String, Object> toArrayMap();

    HashMap<String, Object> toHashMap();
}
