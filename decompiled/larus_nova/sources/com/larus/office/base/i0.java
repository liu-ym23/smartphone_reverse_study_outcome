package com.larus.office.base;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.larkfeed.IOfficeSocialBridge;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i0 implements rza.a {
    public i0() {
    }

    @Override // rza.a
    public final void w0(Context r100, ActivityResultLauncher<String> r101, ActivityResultLauncher<Intent> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickLauncher");
        Intrinsics.checkNotNullParameter(r102, "pickSDKLauncher");
        r102.launch(IOfficeSocialBridge.f355120a.l(r100));
    }
}
