package com.ss.android.lark.officesdk.launcher.base;

import android.app.Application;
import com.ss.android.lark.framework.assembly.appconfig.InitSettingsTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements b {
    public d() {
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final String name() {
        return "InitSettings";
    }

    @Override // com.ss.android.lark.officesdk.launcher.base.b
    public final void a(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        InitSettingsTask.l();
    }
}
