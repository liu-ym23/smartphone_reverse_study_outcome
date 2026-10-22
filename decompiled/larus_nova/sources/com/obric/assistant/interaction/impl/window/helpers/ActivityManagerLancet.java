package com.obric.assistant.interaction.impl.window.helpers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.WindowHost;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class ActivityManagerLancet {
    private static final String TAG = "ActivityManagerLancet";

    public static class MoveTaskToFrontRunnable implements Runnable {
        private final int flags;

        @Override // java.lang.Runnable
        public void run() {
            com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable__run$___twin___() {
            WindowHost r100 = WindowHost.INSTANCE;
            boolean r101 = r100.isShowing();
            boolean r102 = r100.isStashed();
            FLogger.f375446a.w(ActivityManagerLancet.TAG, "intercept moveTaskToFront with fake taskId=0, flags=" + this.flags + ", isShowing=" + r101 + ", isStashed=" + r102);
            r100.pop(WindowAnimationType.Slide);
        }

        public MoveTaskToFrontRunnable(int r100) {
            this.flags = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MoveTaskToFrontRunnable r100) {
            r100.com_obric_assistant_interaction_impl_window_helpers_ActivityManagerLancet$MoveTaskToFrontRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ActivityManagerLancet() {
    }

    public static void handleFakeMoveTaskToFront(int r100) {
        t0.e(new MoveTaskToFrontRunnable(r100));
    }

    public void moveTaskToFront(int r100, int r101) {
        if (r100 == 0) goto L5;
        Origin.callVoid();
        return;
    L5:
        handleFakeMoveTaskToFront(r101);
    }
}
