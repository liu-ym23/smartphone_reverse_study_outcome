package com.bytedance.live.livelink.kmp.impl.base.event;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.utils.LiveWrappedLogUtil$LogLevelWrapper;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255275a = null;

    static {
        int[] r100 = new int[LiveWrappedLogUtil$LogLevelWrapper.values().length];
        f255275a = r100;
        r100[LiveWrappedLogUtil$LogLevelWrapper.LOG_LEVEL_TRACE.ordinal()] = 1;
        r100[LiveWrappedLogUtil$LogLevelWrapper.LOG_LEVEL_DEBUG.ordinal()] = 2;
        r100[LiveWrappedLogUtil$LogLevelWrapper.LOG_LEVEL_INFO.ordinal()] = 3;
        r100[LiveWrappedLogUtil$LogLevelWrapper.LOG_LEVEL_WARNING.ordinal()] = 4;
        r100[LiveWrappedLogUtil$LogLevelWrapper.LOG_LEVEL_ERROR.ordinal()] = 5;
    }
}
