package androidx.activity;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$ReportFullyDrawnExecutorApi1 implements ComponentActivity$ReportFullyDrawnExecutor {
    final Handler mHandler;

    @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
    public void activityDestroyed() {
    }

    @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
    public void viewCreated(View r1) {
    }

    public ComponentActivity$ReportFullyDrawnExecutorApi1() {
        this.mHandler = createHandler();
    }

    private Handler createHandler() {
        Looper r0 = Looper.myLooper();
        if (r0 != null) goto L6;
        r0 = Looper.getMainLooper();
    L6:
        return new Handler(r0);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r2) {
        this.mHandler.postAtFrontOfQueue(r2);
    }
}
