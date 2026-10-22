package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ComponentActivity$ReportFullyDrawnExecutorApi16Impl implements ComponentActivity$ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
    final long mEndWatchTimeMillis;
    boolean mOnDrawScheduled;
    Runnable mRunnable;
    final /* synthetic */ ComponentActivity this$0;

    public static /* synthetic */ void a(ComponentActivity$ReportFullyDrawnExecutorApi16Impl r0) {
        r0.lambda$execute$0();
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private /* synthetic */ void lambda$execute$0() {
        Runnable r0 = this.mRunnable;
        if (r0 == null) goto L6;
        r0.run();
        this.mRunnable = null;
        return;
    }

    @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
    public void activityDestroyed() {
        INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).removeCallbacks(this);
        INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).getViewTreeObserver().removeOnDrawListener(this);
    }

    public void androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl__run$___twin___() {
        INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).getViewTreeObserver().removeOnDrawListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        Runnable r0 = this.mRunnable;
        if (r0 == null) goto L8;
        r0.run();
        this.mRunnable = null;
        if (this.this$0.mFullyDrawnReporter.isFullyDrawnReported() == false) goto L11;
        this.mOnDrawScheduled = false;
        INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).post(this);
        return;
    L11:
        return;
    L8:
        if (SystemClock.uptimeMillis() <= this.mEndWatchTimeMillis) goto L13;
        this.mOnDrawScheduled = false;
        INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow()).post(this);
        return;
    }

    public ComponentActivity$ReportFullyDrawnExecutorApi16Impl(ComponentActivity r5) {
        this.this$0 = r5;
        this.mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        this.mOnDrawScheduled = false;
    }

    public static View INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_apm_impl_protector_RunnableLancet_run(ComponentActivity$ReportFullyDrawnExecutorApi16Impl r1) {
        r1.androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        this.mRunnable = r3;
        View r4 = INVOKEVIRTUAL_androidx_activity_ComponentActivity$ReportFullyDrawnExecutorApi16Impl_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.this$0.getWindow());
        if (this.mOnDrawScheduled == true) goto L5;
        r4.postOnAnimation(new e(this));
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        r4.invalidate();
        return;
    L7:
        r4.postInvalidate();
    }

    @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
    public void viewCreated(View r2) {
        if (this.mOnDrawScheduled == true) goto L6;
        this.mOnDrawScheduled = true;
        r2.getViewTreeObserver().addOnDrawListener(this);
        return;
    }
}
