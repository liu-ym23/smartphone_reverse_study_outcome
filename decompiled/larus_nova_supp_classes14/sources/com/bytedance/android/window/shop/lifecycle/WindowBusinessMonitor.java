package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.window.base.utils.taskmanager.ECWindowTaskManager;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowBusinessMonitor {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final ECWindowViewModel r2, final WindowTabInfoProvider r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "dto");
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r4 = new WindowBusinessMonitor$doFirstTabMonitor$1(r2, r3);
        r1.getClass();
        ECWindowTaskManager.a(r4);
    }

    public static void b(final ECWindowViewModel r2, final WindowTabInfoProvider r3, final mq3.a r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "dto");
        Intrinsics.checkNotNullParameter(r4, "reqParam");
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r5 = new WindowBusinessMonitor$doTabResponseMonitor$1(r2, r3, r4);
        r1.getClass();
        ECWindowTaskManager.a(r5);
    }

    public static void c(final ECWindowViewModel r2, final CommerceBaseResponse r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r5 = new WindowBusinessMonitor$doWindowFailedMonitor$1(r2, r4, r3);
        r1.getClass();
        ECWindowTaskManager.a(r5);
    }
}
