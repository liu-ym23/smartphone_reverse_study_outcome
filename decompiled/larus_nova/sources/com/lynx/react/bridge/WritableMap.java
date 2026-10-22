package com.lynx.react.bridge;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public interface WritableMap extends ReadableMap {
    void merge(ReadableMap r100);

    void putArray(String r100, WritableArray r101);

    void putBoolean(String r100, boolean r101);

    void putByteArray(String r100, byte[] r101);

    void putByteArrayAsString(byte[] r100, byte[] r101);

    void putByteBuffer(String r100, ByteBuffer r101);

    void putDouble(String r100, double r101);

    void putInt(String r100, int r101);

    void putLong(String r100, long r101);

    void putMap(String r100, WritableMap r101);

    void putNull(String r100);

    void putPiperData(String r100, PiperData r101);

    void putString(String r100, String r101);
}
