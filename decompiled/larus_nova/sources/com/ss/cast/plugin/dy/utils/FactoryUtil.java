package com.ss.cast.plugin.dy.utils;

import com.bytedance.ies.ugc.appcontext.AppContextManager;
import com.ss.cast.plugin.dy.factory.DouYinSourceFactory;
import com.ss.cast.plugin.dy.factory.DyLiteSourceFactory;
import com.ss.cast.plugin.dy.factory.SourceFactory;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes40.dex */
public final class FactoryUtil {
    private static final String TAG = "FactoryUtil";

    private FactoryUtil() {
    }

    public static synchronized SourceFactory newDefaultSourceFactoryInst() {
        monitor-enter(FactoryUtil.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (PlatformUtil.isDouYin() == false) goto L10;
        DouYinSourceFactory r100 = new DouYinSourceFactory();     // Catch: Throwable -> L17
        monitor-exit(FactoryUtil.class);
        return r100;
    L10:
        if (PlatformUtil.isDouYinLite() == false) goto L14;
        DyLiteSourceFactory r101 = new DyLiteSourceFactory();     // Catch: Throwable -> L17
        monitor-exit(FactoryUtil.class);
        return r101;
    L14:
        Lazy r102 = AppContextManager.f248843a;     // Catch: Throwable -> L17
        DouYinSourceFactory r103 = new DouYinSourceFactory();     // Catch: Throwable -> L17
        monitor-exit(FactoryUtil.class);
        return r103;
    }
}
