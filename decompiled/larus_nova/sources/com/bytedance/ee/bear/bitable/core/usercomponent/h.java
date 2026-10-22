package com.bytedance.ee.bear.bitable.core.usercomponent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f210611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f210612b;

    public h() {
        this.f210611a = new AtomicBoolean(false);
        this.f210612b = new ConcurrentHashMap();
    }
}
