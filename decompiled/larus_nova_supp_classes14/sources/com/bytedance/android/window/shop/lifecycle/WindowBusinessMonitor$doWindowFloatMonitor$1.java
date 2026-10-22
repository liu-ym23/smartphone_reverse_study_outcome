package com.bytedance.android.window.shop.lifecycle;

import com.bytedance.android.ec.window.base.utils.taskmanager.ECWindowTaskManager;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.lynx.tasm.q1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowBusinessMonitor$doWindowFloatMonitor$1 extends q1 {
    public final /* synthetic */ ECWindowViewModel a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;

    public final void onLoadFailed(final String r3) {
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r2 = new WindowBusinessMonitor$doWindowFloatMonitor$1$onLoadFailed$1(this, r3);
        r1.getClass();
        ECWindowTaskManager.a(r2);
    }

    public final void onTimingSetup(final Map<String, Object> r3) {
        Lazy r0 = ECWindowTaskManager.a;
        ECWindowTaskManager r1 = ECWindowTaskManager.a.a();
        Function0<Unit> r2 = new WindowBusinessMonitor$doWindowFloatMonitor$1$onTimingSetup$1(this, r3);
        r1.getClass();
        ECWindowTaskManager.a(r2);
    }

    public WindowBusinessMonitor$doWindowFloatMonitor$1(ECWindowViewModel r1, long r2, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
