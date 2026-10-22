package com.bytedance.awemeopen.infra.base.net.download;

import android.content.Context;
import com.bytedance.awemeopen.infra.base.net.AoRequestHelper;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class BdpDownloadModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, BdpDownloadTask> f198692a = null;

    static {
        f198692a = new ConcurrentHashMap();
    }

    public static int a(Context r100, AoDownloadRequest r101, AoDownloadCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "request");
        final int r103 = AoRequestHelper.INSTANCE.generateRequestId();
        final BdpDownloadTask r104 = new BdpDownloadTask(r103, r100, r101, r102);
        Integer r105 = Integer.valueOf(r103);
        f198692a.put(r105, r104);
        AoPool.a(new BdpDownloadModule$queue$1(r104, r103));
        return r103;
    }
}
