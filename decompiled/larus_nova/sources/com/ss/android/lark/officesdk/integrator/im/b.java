package com.ss.android.lark.officesdk.integrator.im;

import android.content.Context;
import com.ss.android.lark.usersetting.service.timeformat.TimeFormatSetting;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {
    public b() {
    }

    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final boolean a() {
        if (com.ss.android.lark.usersetting.service.e.a.f444639a.f().getTimeFormat() != TimeFormatSetting.TimeFormat.TWELVE_HOUR) goto L5;
        return true;
    L5:
        return false;
    }
}
