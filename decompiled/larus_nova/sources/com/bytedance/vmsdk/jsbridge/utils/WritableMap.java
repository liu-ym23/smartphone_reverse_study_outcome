package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes3.dex */
public interface WritableMap extends ReadableMap {
    void merge(ReadableMap r100);

    void putArray(String r100, WritableArray r101);

    void putBoolean(String r100, boolean r101);

    void putByteArray(String r100, byte[] r101);

    void putByteArrayAsString(byte[] r100, byte[] r101);

    void putDouble(String r100, double r101);

    void putInt(String r100, int r101);

    void putLong(String r100, long r101);

    void putMap(String r100, WritableMap r101);

    void putNativeHostObject(String r100, NativeHostObject r101);

    void putNull(String r100);

    void putString(String r100, String r101);
}
