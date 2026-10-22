package com.ss.android.lark.appcontext.applifecycle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f408824b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Object, Object> f408825a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f408826a = null;

        static {
            f408826a = new b();
        }
    }

    static {
        f408824b = new Object();
    }

    public b() {
        this.f408825a = new ConcurrentHashMap();
    }
}
