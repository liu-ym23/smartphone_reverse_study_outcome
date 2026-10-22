package com.ss.android.lark.flow.passport.ui.widget.common;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0004J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "loadingDialog", "Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "getLoadingDialog", "()Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "setLoadingDialog", "(Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;)V", "isShowBlackOnWhiteStatusBar", "", "()Z", "setShowBlackOnWhiteStatusBar", "(Z)V", "initLoadingDialog", "", "showLoadingDialog", DyPayConstant.KEY_SHOW_LOADING, "hideLoadingDialog", "hideLoading", "Companion", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlowBaseActivity extends FragmentActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f423826c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f423827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f423828b;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBaseActivity f423829a;

        public b(FlowBaseActivity r100) {
            this.f423829a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowBaseActivity r100 = this.f423829a;     // Catch: Throwable -> L4
            int r101 = FlowBaseActivity.f423826c;     // Catch: Throwable -> L4
            r100.hideLoading();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void hideLoading() {
        f r100 = this.f423827a;
        if (r100 != null) goto L6;
        PassportLog.b("FlowBaseActivity", "loadingDialog is null");
        return;
    L6:
        if (r100.isShowing() == true) goto L8;
        return;
    L8:
        if (isFinishing() == false) goto L10;
        return;
    L10:
        if (isDestroyed() == true) goto L34;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r102 == null) goto L25;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        if (Looper.myLooper() == r101.getLooper()) goto L16;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public final void showLoading() {
        f r100 = this.f423827a;
        if (r100 != null) goto L5;
        f r101 = new f(this, this.f423828b);
        this.f423827a = r101;
        r101.setOnKeyListener(c.f423839a);
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isShowing() == false) goto L9;
        return;
    L9:
        if (isFinishing() == false) goto L11;
        return;
    L11:
        if (isDestroyed() == false) goto L13;
        return;
    L13:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L19;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L19:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L16:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public FlowBaseActivity() {
        this.f423828b = true;
    }

    public final void y1() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        hideLoading();
        return;
    L5:
        UICallbackExecutor.post(new b(this));
    }
}
