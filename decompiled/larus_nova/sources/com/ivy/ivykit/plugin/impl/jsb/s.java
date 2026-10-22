package com.ivy.ivykit.plugin.impl.jsb;

import androidx.core.app.NotificationCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class s implements id7.f {
    public s() {
    }

    @Override // id7.f
    public final void a(le7.a r100, me7.d r101) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
