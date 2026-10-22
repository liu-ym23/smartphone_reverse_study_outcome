package com.bytedance.badger.collect.impl.utils;

import com.bytedance.badger.collect.impl.abs.Singleton;

/* JADX INFO: loaded from: classes47.dex */
public class RequestIdGenerator {
    private static Singleton<String> requestIdSingleTon;

    public RequestIdGenerator() {
    }

    private static Singleton<String> createReqIdSingleton() {
        return new AnonymousClass1();
    }

    public static String getRequestId() {
        return requestIdSingleTon.get(new Object[0]);
    }

    static {
        requestIdSingleTon = createReqIdSingleton();
    }

    public static void clearReqId() {
        requestIdSingleTon = createReqIdSingleton();
    }
}
