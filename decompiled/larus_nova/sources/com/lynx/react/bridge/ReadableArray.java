package com.lynx.react.bridge;

import f6a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public interface ReadableArray {
    ArrayList<Object> asArrayList();

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

    PiperData getPiperData(int r100);

    short getShort(int r100);

    String getString(int r100);

    ReadableType getType(int r100);

    boolean isNull(int r100);

    int size();

    ArrayList<Object> toArrayList();
}
