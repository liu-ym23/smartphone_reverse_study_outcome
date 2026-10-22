package com.bytedance.vmsdk.jsbridge.utils;

/* JADX INFO: loaded from: classes3.dex */
public interface WritableArray extends ReadableArray {
    void pushArray(WritableArray r100);

    void pushBoolean(boolean r100);

    void pushByteArray(byte[] r100);

    void pushByteArrayAsString(byte[] r100);

    void pushDouble(double r100);

    void pushInt(int r100);

    void pushLong(long r100);

    void pushMap(WritableMap r100);

    void pushNull();

    void pushString(String r100);

    void putNativeHostObject(NativeHostObject r100);
}
