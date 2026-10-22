package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements com.ss.android.lark.officesdk.minutes.ui.style.contract.c {
    public k() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean a() {
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void b(com.ss.android.lark.officesdk.minutes.ui.style.contract.i r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void c() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void d() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean e() {
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean f(com.ss.android.lark.officesdk.minutes.ui.style.contract.i r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.f436894c != MmRecordingSource.FEISHU_DOUBAO) goto L5;
    L7:
        return false;
    L5:
        if (r100.f436893b == true) goto L7;
        return true;
    }
}
