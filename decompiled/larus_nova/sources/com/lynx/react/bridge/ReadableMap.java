package com.lynx.react.bridge;

import com.lynx.tasm.TemplateData;
import f6a.a;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    ReadableArray getArray(String r100);

    ReadableArray getArray(String r100, ReadableArray r101);

    boolean getBoolean(String r100);

    boolean getBoolean(String r100, boolean r101);

    byte[] getByteArray(String r100);

    byte[] getByteArray(String r100, byte[] r101);

    ByteBuffer getByteBuffer(String r100);

    ByteBuffer getByteBuffer(String r100, ByteBuffer r101);

    double getDouble(String r100);

    double getDouble(String r100, double r101);

    a getDynamic(String r100);

    int getInt(String r100);

    int getInt(String r100, int r101);

    long getLong(String r100);

    long getLong(String r100, long r101);

    ReadableMap getMap(String r100);

    ReadableMap getMap(String r100, ReadableMap r101);

    PiperData getPiperData(String r100);

    PiperData getPiperData(String r100, PiperData r101);

    String getString(String r100);

    String getString(String r100, String r101);

    TemplateData getTemplateData(String r100);

    ReadableType getType(String r100);

    boolean hasKey(String r100);

    boolean isNull(String r100);

    ReadableMapKeySetIterator keySetIterator();

    int size();

    HashMap<String, Object> toHashMap();
}
