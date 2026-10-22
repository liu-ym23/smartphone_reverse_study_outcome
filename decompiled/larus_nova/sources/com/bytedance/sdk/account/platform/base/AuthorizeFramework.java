package com.bytedance.sdk.account.platform.base;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizeFramework {
    private static Context appContext;
    private static Map<Class, IAuthorizeService> serviceHashMap;
    private static final Map<Class, List<Runnable>> serviceInitListener = null;

    public AuthorizeFramework() {
    }

    static {
        serviceHashMap = new ConcurrentHashMap();
        serviceInitListener = new ConcurrentHashMap();
    }

    public static <T extends IAuthorizeService> T getService(Class<T> r100) {
        return (T) serviceHashMap.get(r100);
    }

    private static void notifyInitFinish(Class<? extends IAuthorizeService> r100) {
        monitor-enter(r100);
        Map<Class, List<Runnable>> r101 = serviceInitListener;     // Catch: Throwable -> L11
        List<Runnable> r102 = r101.get(r100);     // Catch: Throwable -> L11
        r101.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        Iterator<Runnable> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        r103.next().run();
        goto L8
    L17:
        return;
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void addInitListener(Class<? extends IAuthorizeService> r100, Runnable r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (getService(r100) == null) goto L8;
        r101.run();
        return;
    L8:
        monitor-enter(r100);
    L20:
        th = move-exception;
        throw th;
    L10:
        if (getService(r100) == null) goto L14;
        r101.run();     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
        return;
    L14:
        Map<Class, List<Runnable>> r102 = serviceInitListener;     // Catch: Throwable -> L20
        List<Runnable> r103 = r102.get(r100);     // Catch: Throwable -> L20
        if (r103 != null) goto L17;
        r103 = new ArrayList();     // Catch: Throwable -> L20
        r102.put(r100, r103);     // Catch: Throwable -> L20
    L17:
        r103.add(r101);     // Catch: Throwable -> L20
        monitor-exit(r100);     // Catch: Throwable -> L20
    }

    public static <T extends IAuthorizeService, W extends AuthorizeCreator<T>> T createService(Context r100, W r101) {
        return (T) r101.createService(r100);
    }

    public static <T extends AuthorizeIniter> void init(Context r100, T... r101) {
        appContext = r100;
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        r101[r103].init(r100);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public static <T extends IAuthorizeService> void registerService(Class<T> r100, IAuthorizeService r101) {
        if (r101 == null) goto L5;
        serviceHashMap.put(r100, r101);
        notifyInitFinish(r100);
        return;
    }
}
