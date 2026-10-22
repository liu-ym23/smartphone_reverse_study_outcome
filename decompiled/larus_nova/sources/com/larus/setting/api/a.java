package com.larus.setting.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.platform.api.d0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f367889a = null;

    static {
        f367889a = new a();
    }

    public a() {
    }

    @Override // com.larus.platform.api.d0
    public final void d() {
        SettingService.f367887a.i();
    }

    @Override // com.larus.platform.api.d0
    public final void c(Fragment r100, View r101, String r102, by7.e r103) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "currentPage");
        SettingService.f367887a.c(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.d0
    public final void b(Context r110, String r111, by7.e r112, String r113, String r114, String r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        SettingService.f367887a.b(r110, r111, r112, r113, r114, r115, r116);
    }
}
