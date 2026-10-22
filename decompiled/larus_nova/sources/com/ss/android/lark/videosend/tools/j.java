package com.ss.android.lark.videosend.tools;

import android.app.Application;
import android.os.StatFs;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LimitDisk f445016a = null;

    static {
        f445016a = VideoSettingUtils.e().getLimitDisk();
    }

    @JvmStatic
    public static final long a() {
        int r100 = l.f445018a;
        Application r101 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r101);
        int r102 = com.suite.lark.platform.component.storage.file.dirs.h.f460642c;
        com.suite.lark.platform.component.storage.file.dirs.h r103 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(r101);
        r103.c(l.b());
        String r104 = r103.b(new a()).getRealPath();
        FileUtils.t(r104);     // Catch: Throwable -> L5
        StatFs r105 = new StatFs(r104);     // Catch: Throwable -> L5
        return r105.getBlockSizeLong() * r105.getAvailableBlocksLong();
    L5:
        return 0;
    }

    @JvmStatic
    public static final boolean b(long r100) {
        long r101 = a();
        LimitDisk r102 = f445016a;
        long r103 = RangesKt.coerceAtLeast(r100 * ((long) r102.getFreeMultiple()), r102.getFreeSize());
        if (r101 <= r103) goto L5;
        boolean r104 = true;
    L6:
        Log.i("VideoDiskSpaceUtils", "oneVideoHasSaveSpace(), hasSaveSpace=" + r104 + ", needSize=" + r103 + ", freeSize=" + r101);
        return r104;
    L5:
        r104 = false;
        goto L6
    }
}
