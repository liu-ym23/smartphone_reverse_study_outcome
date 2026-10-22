package com.bytedance.lark.sdk.refactor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes20.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLong f254275a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f254276b = null;

    static {
        f254275a = new AtomicLong(System.currentTimeMillis());
        f254276b = new ConcurrentHashMap();
    }
}
