package com.ss.android.lark.flow.passport.ui.widget.common;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "loadingDialog", "Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "getLoadingDialog", "()Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;", "setLoadingDialog", "(Lcom/ss/android/lark/flow/passport/ui/widget/common/LoadingDialog;)V", "isShowBlackOnWhiteStatusBar", "", "()Z", "setShowBlackOnWhiteStatusBar", "(Z)V", "initLoadingDialog", "", "showLoadingDialog", DyPayConstant.KEY_SHOW_LOADING, "hideLoadingDialog", "hideLoading", "Companion", "flow-passport-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlowBaseFragment extends Fragment {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f423830e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f423831d;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBaseFragment f423832a;

        public b(FlowBaseFragment r100) {
            this.f423832a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowBaseFragment r100 = this.f423832a;     // Catch: Throwable -> L4
            int r101 = FlowBaseFragment.f423830e;     // Catch: Throwable -> L4
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

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBaseFragment f423833a;

        public c(FlowBaseFragment r100) {
            this.f423833a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlowBaseFragment r100 = this.f423833a;     // Catch: Throwable -> L4
            int r101 = FlowBaseFragment.f423830e;     // Catch: Throwable -> L4
            r100.showLoading();     // Catch: Throwable -> L4
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

    public final void hideLoading() {
        f r100 = this.f423831d;
        if (r100 != null) goto L6;
        PassportLog.b("FlowBaseFragment", "loadingDialog is null");
        return;
    L6:
        if (r100.isShowing() == true) goto L8;
    L28:
        PassportLog.d("FlowBaseFragment", "isShowing=" + r100.isShowing() + ",isRemoving=" + isRemoving() + ",isDetached()=" + isDetached());
        return;
    L8:
        if (isRemoving() == true) goto L28;
        if (isDetached() == true) goto L28;
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
    }

    public final void showLoading() {
        boolean r100 = true;
        if (this.f423831d != null) goto L5;
        f r101 = new f(getActivity(), true);
        this.f423831d = r101;
        r101.setOnKeyListener(e.f423841a);
    L5:
        f r102 = this.f423831d;
        if (r102 != null) goto L8;
    L25:
        StringBuilder r103 = new StringBuilder("isShowing=");
        f r104 = this.f423831d;
        if (r104 == null) goto L28;
        Boolean r105 = Boolean.valueOf(r104.isShowing());
    L29:
        r103.append(r105);
        r103.append(",isRemoving=");
        r103.append(isRemoving());
        r103.append(",isDetached()=");
        r103.append(isDetached());
        PassportLog.d("FlowBaseFragment", r103.toString());
        return;
    L28:
        r105 = null;
        goto L29
    L8:
        if (r102 != null) goto L10;
    L12:
        r100 = false;
    L13:
        if (r100 == false) goto L25;
        if (isRemoving() == true) goto L25;
        if (isDetached() == true) goto L25;
        f r106 = this.f423831d;
        if (r106 != null) goto L21;
        return;
    L21:
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L24:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L10:
        if (r102.isShowing() == true) goto L12;
        goto L12
    }

    public final void S90() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        hideLoading();
        return;
    L5:
        UICallbackExecutor.post(new b(this));
    }

    public final void T90() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        showLoading();
        return;
    L5:
        UICallbackExecutor.post(new c(this));
    }

    public FlowBaseFragment() {
    }
}
