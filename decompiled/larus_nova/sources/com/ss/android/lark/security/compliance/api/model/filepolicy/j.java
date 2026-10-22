package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RefreshContext f440412a;

    public final RefreshContext getContext() {
        return this.f440412a;
    }

    public j(RefreshContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f440412a = r100;
    }
}
