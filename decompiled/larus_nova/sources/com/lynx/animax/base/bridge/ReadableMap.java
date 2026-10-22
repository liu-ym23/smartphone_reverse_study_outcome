package com.lynx.animax.base.bridge;

import java.util.HashMap;
import r4a.a;

/* JADX INFO: loaded from: classes32.dex */
public interface ReadableMap {
    HashMap<String, Object> asHashMap();

    a getArray(String r100);

    double getDouble(String r100, double r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100);

    ReadableType getType(String r100);
}
