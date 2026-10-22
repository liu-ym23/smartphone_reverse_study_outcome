package com.bytedance.bmmt.base;

/* JADX INFO: loaded from: classes8.dex */
public interface RefCounted {
    void release();

    void retain();
}
