package com.bytedance.vmsdk.jsbridge.utils;

import java.util.ArrayList;
import sp7.a;

/* JADX INFO: loaded from: classes3.dex */
public interface ReadableArray {
    ReadableArray getArray(int r100);

    boolean getBoolean(int r100);

    byte getByte(int r100);

    byte[] getByteArray(int r100);

    char getChar(int r100);

    double getDouble(int r100);

    a getDynamic(int r100);

    int getInt(int r100);

    long getLong(int r100);

    ReadableMap getMap(int r100);

    NativeHostObject getNativeHostObject(int r100);

    short getShort(int r100);

    String getString(int r100);

    ReadableType getType(int r100);

    boolean isNull(int r100);

    int size();

    ArrayList<Object> toArrayList();
}
