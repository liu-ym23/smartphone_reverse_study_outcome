package com.ivy.ivykit.plugin.impl.applet;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements com.bytedance.ies.bullet.service.webkit.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f278373a;

    public e(List r100) {
        this.f278373a = r100;
    }

    @Override // com.bytedance.ies.bullet.service.webkit.c
    public final com.bytedance.ies.bullet.service.webkit.a a(com.bytedance.ies.bullet.service.webkit.d r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new d(r100, this.f278373a);
    }
}
