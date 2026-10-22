package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingMapUtilKt {
    public static final PolarisFileWrapper c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "mm_map");
        if (r101.exists() == true) goto L5;
        r101.mkdirs();
    L5:
        return r101;
    }

    public static final boolean a(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == false) goto L5;
        String r102 = "mm_map_snapshot_dark.png";
    L6:
        PolarisFileWrapper r103 = new PolarisFileWrapper(c(r100), r102);
        if (r103.exists() == true) goto L11;
        return false;
    L11:
        return r103.delete();
    L5:
        r102 = "mm_map_snapshot_light.png";
        goto L6
    }

    public static final void b(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "logTag");
        Intrinsics.checkNotNullParameter(r102, "from");
        lvb.a.e(r101, "[deleteMapFiles] from=" + r102 + ", dark=" + a(r100, true) + ", light=" + a(r100, false));
    }

    public static final Object d(Context r100, boolean r101, Continuation<? super Boolean> r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordingMapUtilKt$isSnapShotFileExist$2(r101, r100, null), r102);
    }
}
