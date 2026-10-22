package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements vl8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f309500a;

    public g(h r100) {
        this.f309500a = r100;
    }

    @Override // vl8.f
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h r101 = this.f309500a;
        a r102 = r101.f309501a;
        if (r102 == null) goto L8;
        b r103 = r101.f309502b;
        if (r103 == null) goto L9;
        r103.b(r100, r102);
        return;
    L9:
        return;
    }

    @Override // vl8.f
    public final void b(Context r100, vl8.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onStateChanged");
        h r102 = this.f309500a;
        a r103 = r102.f309501a;
        if (r103 == null) goto L8;
        b r104 = r102.f309502b;
        if (r104 == null) goto L9;
        r104.c(r100, r103, r101);
        return;
    L9:
        return;
    }
}
