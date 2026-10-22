package com.bytedance.mira.log;

/* JADX INFO: loaded from: classes21.dex */
public interface IMiraEventReport {
    public static final int RESOLVE_CACHE_ERROR = 42000;
    public static final int RESOLVE_START = 40000;
    public static final int RESOLVE_SUCCESS = 41000;

    void reportEvent(int r100, String r101, int r102, long r103, int r104, Throwable r105, long r106);
}
