package com.obric.assistant.settings.provider;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q extends zla.e {
    @Override // zla.e
    public final int g(int r100) {
        return R.layout.obric_dialog_button_vertical_double_primary_light;
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 1);
    }
}
