package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f437540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f437541b;

    public Context getContext() {
        return this.f437540a;
    }

    public d(Context r100) {
        this.f437540a = r100;
        Configuration r101 = r100.getResources().getConfiguration();
        this.f437541b = r101.uiMode;
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "origin config=" + r101);
    }

    public final void a(Context r100) {
        Configuration r101 = r100.getResources().getConfiguration();
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "merge config=" + r101);
        int r102 = this.f437541b;
        if (r102 != r101.uiMode) goto L5;
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "redirect pass");
        return;
    L5:
        r101.uiMode = r102;
        Resources r103 = r100.getResources();
        Resources r104 = r100.getResources();
        r103.updateConfiguration(r101, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()));
        com.ss.android.lark.officesdk.utils.di.j.e("DarkModeContextExtension", "redirect config=" + r100.getResources().getConfiguration());
    }
}
