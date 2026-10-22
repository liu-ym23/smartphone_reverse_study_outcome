package com.bytedance.sysoptimizer;

import android.content.Context;
import android.view.LayoutInflater;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class LayoutInflaterAsyncCrashOptimizer {
    private static boolean hasFixed;

    public static final class FixLayoutInflaterAsyncHashMap<K, V> extends HashMap<K, V> {
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized void clear() {
            monitor-enter(this);
            super.clear();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public FixLayoutInflaterAsyncHashMap() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized V remove(Object r100) {
            monitor-enter(this);
            V r101 = (V) super.remove(r100);
            monitor-exit(this);
            return r101;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized V put(K r100, V r101) {
            monitor-enter(this);
            V r102 = (V) super.put(r100, r101);
            monitor-exit(this);
            return r102;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public LayoutInflaterAsyncCrashOptimizer() {
    }

    public static synchronized void fix(Context r100) {
        monitor-enter(LayoutInflaterAsyncCrashOptimizer.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (hasFixed == false) goto L9;
        monitor-exit(LayoutInflaterAsyncCrashOptimizer.class);
        return;
    L9:
        hasFixed = true;     // Catch: Throwable -> L16
        Field r101 = LayoutInflater.class.getDeclaredField("sConstructorMap");     // Catch: Exception -> L12 Throwable -> L16
        r101.setAccessible(true);     // Catch: Exception -> L12 Throwable -> L16
        r101.set(null, new FixLayoutInflaterAsyncHashMap());     // Catch: Exception -> L12 Throwable -> L16
    L14:
        monitor-exit(LayoutInflaterAsyncCrashOptimizer.class);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L14
    }
}
