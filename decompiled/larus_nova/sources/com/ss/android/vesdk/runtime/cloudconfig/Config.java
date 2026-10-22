package com.ss.android.vesdk.runtime.cloudconfig;

/* JADX INFO: loaded from: classes40.dex */
public class Config<T> {
    public static final int TYPE_FLOAT = 1;
    public static final int TYPE_INT = 0;
    public final T defaultValue;
    public final String key;
    public final int type;

    public Config(String r100, int r101, T r102) {
        this.key = r100;
        this.type = r101;
        this.defaultValue = r102;
    }
}
