package com.ss.cast.plugin.dy.utils;

import com.bytedance.ies.ugc.appcontext.AppContextManager;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes40.dex */
public final class PlatformUtil {
    private PlatformUtil() {
    }

    public static boolean isDouYin() {
        Lazy r100 = AppContextManager.f248843a;
        return true;
    }

    public static boolean isDouYinLite() {
        Lazy r100 = AppContextManager.f248843a;
        return false;
    }
}
