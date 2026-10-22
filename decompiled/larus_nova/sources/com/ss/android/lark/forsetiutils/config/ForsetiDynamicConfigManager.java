package com.ss.android.lark.forsetiutils.config;

import com.ss.android.lark.log.Log;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiDynamicConfigManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f424770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f424771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f424772c = null;

    static {
        f424770a = LazyKt.lazy(ForsetiDynamicConfigManager$blacklistedModels$2.INSTANCE);
        f424771b = LazyKt.lazy(ForsetiDynamicConfigManager$forsetiDynamicConfigDisabled$2.INSTANCE);
        f424772c = LazyKt.lazy(ForsetiDynamicConfigManager$dynamicConfig$2.INSTANCE);
    }

    public static List a() {
        ForsetiDynamicConfig r100 = (ForsetiDynamicConfig) f424772c.getValue();
        if (r100 == null) goto L8;
        List<String> r101 = r100.a();
        if (r101 == null) goto L8;
        List r102 = CollectionsKt.filterNotNull(r101);
        if (r102 == null) goto L8;
    L9:
        Log.i("ForsetiDynamicConfigManager", "getBlackList: value=" + r102);
        return r102;
    L8:
        r102 = (List) f424770a.getValue();
        goto L9
    }

    public static int b() {
        ForsetiDynamicConfig r100 = (ForsetiDynamicConfig) f424772c.getValue();
        if (r100 == null) goto L5;
        int r101 = r100.b();
    L6:
        Log.i("ForsetiDynamicConfigManager", "getLeftNavigationThreshold: value=" + r101);
        return r101;
    L5:
        r101 = MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME;
        goto L6
    }
}
