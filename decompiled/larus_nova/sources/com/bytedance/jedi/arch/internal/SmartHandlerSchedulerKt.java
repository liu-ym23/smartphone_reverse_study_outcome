package com.bytedance.jedi.arch.internal;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\f\u001a\u00020\r2\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0080\bø\u0001\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "SMART_MAIN", "Lcom/bytedance/jedi/arch/internal/SmartHandlerScheduler;", "getSMART_MAIN", "()Lcom/bytedance/jedi/arch/internal/SmartHandlerScheduler;", PullConfiguration.PROCESS_NAME_MAIN, "", "getMain", "()Z", "runOnUI", "", "block", "Lkotlin/Function0;", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SmartHandlerSchedulerKt {
    private static final Handler MAIN_HANDLER = null;
    private static final SmartHandlerScheduler SMART_MAIN = null;

    static {
        Handler r100 = new Handler(Looper.getMainLooper());
        MAIN_HANDLER = r100;
        SMART_MAIN = new SmartHandlerScheduler(r100, false);
    }

    public static final boolean getMain() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Handler getMAIN_HANDLER() {
        return MAIN_HANDLER;
    }

    public static final SmartHandlerScheduler getSMART_MAIN() {
        return SMART_MAIN;
    }

    public static final void runOnUI(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        if (getMain() == false) goto L5;
        r100.invoke();
        return;
    L5:
        getMAIN_HANDLER().post(new AnonymousClass1(r100));
    }
}
