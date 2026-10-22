package com.bytedance.ies.xbridge;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public interface v {
    t get(int r100);

    v getArray(int r100);

    boolean getBoolean(int r100);

    double getDouble(int r100);

    int getInt(int r100);

    XReadableMap getMap(int r100);

    String getString(int r100);

    XReadableType getType(int r100);

    int size();

    List<Object> toList();
}
