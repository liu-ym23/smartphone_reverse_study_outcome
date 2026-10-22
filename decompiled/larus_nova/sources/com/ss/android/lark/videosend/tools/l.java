package com.ss.android.lark.videosend.tools;

import android.content.Context;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f445018a = 0;

    static {
    }

    @JvmStatic
    public static final com.ss.android.lark.vfs.h b() {
        VFSFiles r100 = VFSFiles.f444819b;
        boolean r101 = c();
        r100.getClass();
        return VFSFiles.b(r101);
    }

    public static boolean c() {
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.messenger.storage.transfer.video");
        Log.i("VideoStorage", "videoStorage isEnable:" + r100);
        return r100;
    }

    @JvmStatic
    public static final VFSPath a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.suite.lark.platform.component.storage.file.dirs.h.f460642c;
        com.suite.lark.platform.component.storage.file.dirs.h r102 = com.suite.lark.platform.component.storage.file.dirs.h.a.a(r100);
        r102.c(b());
        return r102.b(new b());
    }
}
