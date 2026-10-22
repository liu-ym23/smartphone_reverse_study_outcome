package com.ss.android.lark.utils;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes38.dex */
public class ViewUtils {
    private static final Handler VIEW_HANDLER = null;

    public static class ActionLoadingView extends AppCompatImageView {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ObjectAnimator f444675a;

        public ActionLoadingView(Context r100) {
            this(r100, null);
        }

        public ActionLoadingView(Context r100, AttributeSet r101) {
            this(r100, r101, 0);
        }

        @Override // android.view.View
        public final void onVisibilityChanged(View r100, int r101) {
            super.onVisibilityChanged(r100, r101);
            ObjectAnimator r102 = this.f444675a;
            if (r102 == null) goto L8;
            if (r101 != 0) goto L6;
            r102.start();
            return;
        L6:
            r102.end();
            return;
        }

        public ActionLoadingView(Context r100, AttributeSet r101, int r102) {
            super(r100, r101, r102);
            setImageResource(R.drawable.util_loading_icon);
            ObjectAnimator r103 = ObjectAnimator.ofFloat(this, "rotation", new float[]{0.0f, 360.0f});
            this.f444675a = r103;
            r103.setRepeatCount(-1);
            this.f444675a.setInterpolator(new LinearInterpolator());
            this.f444675a.setRepeatMode(1);
            this.f444675a.setDuration(1000);
            this.f444675a.start();
        }
    }

    public static class a extends b {
        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final int c() {
            return R.layout.util_action_loading;
        }

        public a(Context r100) {
            super(r100);
        }

        public a(Context r100, CharSequence r101) {
            super(r100, r101, true);
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void f(LKUIDialog r100, CharSequence r101) {
            if (TextUtils.isEmpty(r101) == false) goto L5;
            r101 = UIHelper.getString(R.string.Lark_Legacy_InLoading);
        L5:
            ((TextView) r100.findViewById(R.id.utilActionLoadingMsgTv)).setText(r101);
        }

        public a(Context r100, boolean r101) {
            super(r100, null, r101);
        }

        public a(Context r100, CharSequence r101, boolean r102) {
            super(r100, r101, r102);
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HandlerC5375b f444676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f444677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LKUIDialog f444678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CharSequence f444679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f444680e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f444681f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public DialogInterface.OnCancelListener f444682g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DialogInterface.OnDismissListener f444683h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f444684i;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f444685a;

            @Override // java.lang.Runnable
            public final void run() {
                b.b(this.f444685a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(b r100) {
                this.f444685a = r100;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.utils.ViewUtils$b$b, reason: collision with other inner class name */
        public static class HandlerC5375b extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference<b> f444686a;

            public HandlerC5375b(b r100) {
                this.f444686a = new WeakReference(r100);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message r100) {
                b r101 = this.f444686a.get();
                if (r101 != null) goto L6;
                return;
            L6:
                if (r100.what != 10086) goto L9;
                ViewUtils.runOnUiThread(new d1(r101));
                return;
            }
        }

        public b() {
            throw null;
        }

        public abstract int c();

        public com.larksuite.component.ui.dialog.d d(com.larksuite.component.ui.dialog.d r100) {
            return r100;
        }

        public abstract void f(LKUIDialog r100, CharSequence r101);

        public void e() {
            ViewUtils.runOnUiThread(new a(this));
        }

        public void h() {
            if (ViewUtils.isActivityAlive(this.f444677b) == true) goto L5;
            return;
        L5:
            this.f444676a.sendEmptyMessageDelayed(10086, this.f444681f);
        }

        public Context getContext() {
            return this.f444677b;
        }

        public b(Context r100) {
            this(r100, null, true);
        }

        public static View a(Window r100) {
            View r101 = r100.getDecorView();
            if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
            FLogger.f375446a.i("DecorViewLancet", "getDecorView");
            Thread r102 = ThreadMethodProxy.currentThread();
            if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
            com.larus.home.impl.utils.c.a(r102, "getDecorView");
        L7:
            return r101;
        }

        public static void b(b r100) {
            r100.f444684i = false;
            r100.f444676a.removeCallbacksAndMessages(null);
            if (ViewUtils.isActivityAlive(r100.f444677b) == false) goto L30;
            LKUIDialog r101 = r100.f444678c;
            if (r101 == null) goto L31;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L18:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r103 == null) goto L22;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
            goto L22
        L11:
            if (Looper.myLooper() == r102.getLooper()) goto L13;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        L31:
            return;
        }

        public void g(Window r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            r100.setDimAmount(0.0f);
            r100.setWindowAnimations(R.style.UtilLoadingAnim);
            r100.clearFlags(67108864);
            r100.addFlags(Integer.MIN_VALUE);
            if (this.f444680e == true) goto L7;
        L9:
            int r101 = 256;
        L10:
            int r102 = a(r100).getSystemUiVisibility();
            a(r100).setSystemUiVisibility(r101 | r102);
            r100.setStatusBarColor(0);
            r100.setNavigationBarColor(0);
            return;
        L7:
            if (Build.VERSION.SDK_INT < 23) goto L9;
            r101 = ErrorCode.EXECUTE_HYDRA_FAILED;
            goto L10
        }

        public b(Context r100, CharSequence r101, boolean r102) {
            this.f444676a = new HandlerC5375b(this);
            this.f444681f = 300;
            this.f444677b = r100;
            this.f444679d = r101;
            this.f444680e = r102;
            if (ViewUtils.isActivityAlive(r100) == true) goto L6;
            Log.w("ViewUtils", "context is not alive: " + r100);
            return;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public LKUIStatus f444687j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public FrameLayout f444688k;

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final int c() {
            return R.layout.util_page_loading;
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void e() {
            super.e();
            LKUIStatus r100 = this.f444687j;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void h() {
            super.h();
            LKUIStatus r100 = this.f444687j;
            if (r100 == null) goto L8;
            r100.e();
            View r101 = this.f444688k.getChildAt(0);
            if (r101 == null) goto L9;
            r101.setBackgroundColor(0);
            return;
        L9:
            return;
        }

        public c(Context r100) {
            super(r100);
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void g(Window r100) {
            r100.getAttributes().flags = 144;
            super.g(r100);
        }

        public c(Context r100, CharSequence r101) {
            super(r100, r101, true);
        }

        @Override // com.ss.android.lark.utils.ViewUtils.b
        public final void f(LKUIDialog r100, CharSequence r101) {
            if (TextUtils.isEmpty(r101) == false) goto L5;
            r101 = UIHelper.getString(R.string.Lark_Legacy_InLoading);
        L5:
            FrameLayout r102 = (FrameLayout) r100.findViewById(R.id.utilPageRootFl);
            this.f444688k = r102;
            LKUIStatus.b r103 = new LKUIStatus.b(r102);
            r103.f284257b = r101;
            LKUIStatus r104 = new LKUIStatus(r103);
            this.f444687j = r104;
            r104.e();
            View r105 = this.f444688k.getChildAt(0);
            if (r105 == null) goto L9;
            r105.setBackgroundColor(0);
            return;
        }

        public c(Context r100, boolean r101) {
            super(r100, null, r101);
        }

        public c(Context r100, CharSequence r101, boolean r102) {
            super(r100, r101, r102);
        }
    }

    public static class d implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f444689a;

        public d(b r100) {
            this.f444689a = new WeakReference(r100);
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            b r101 = this.f444689a.get();
            if (r101 == null) goto L9;
            DialogInterface.OnDismissListener r102 = r101.f444683h;
            if (r102 == null) goto L7;
            r102.onDismiss(r100);
        L7:
            b.b(r101);
            r101.f444682g = null;
            r101.f444683h = null;
            return;
        }
    }

    public ViewUtils() {
    }

    static {
        VIEW_HANDLER = new Handler(Looper.getMainLooper());
    }

    public static void showCommonErrorTip() {
        LKUIToast.show(LarkContext.getApplication(), R.string.Lark_Legacy_RecallMessageErr);
    }

    public static a createActionLoadingDialog(Context r100) {
        return new a(r100);
    }

    public static c createPageLoadingDialog(Context r100) {
        return new c(r100);
    }

    public static Activity getActivityByContext(Context r100) {
        if ((r100 instanceof Activity) == true) goto L5;
        if (r100 == null) goto L14;
        if (r100.getClass().getName().equals("com.android.internal.policy.DecorContext") == false) goto L14;
        Field r101 = r100.getClass().getDeclaredField("mActivityContext");     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        return (Activity) ((WeakReference) r101.get(r100)).get();
    L11:
        e = move-exception;
        e.printStackTrace();
    L14:
        if ((r100 instanceof ContextWrapper) == false) goto L20;
        if ((r100 instanceof Activity) == true) goto L18;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L14
    L18:
        return (Activity) r100;
    L20:
        return null;
    L5:
        return (Activity) r100;
    }

    public static Activity getActivityByView(View r100) {
        return getActivityByContext(r100.getContext());
    }

    public static boolean isActivityAlive(Activity r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.isFinishing() == true) goto L8;
        if (r100.isDestroyed() == true) goto L8;
        return true;
    }

    public static void runOnUiThread(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        VIEW_HANDLER.post(r100);
    }

    public static void showToastLong(int r100) {
        LKUIToast.show(LarkContext.getApplication(), r100, 3500);
    }

    public static void showToastShort(int r100) {
        LKUIToast.show(LarkContext.getApplication(), r100);
    }

    public static boolean isActivityAlive(Context r100) {
        return isActivityAlive(getActivityByContext(r100));
    }

    public static void showToastLong(String r100) {
        LKUIToast.show(LarkContext.getApplication(), r100, 3500);
    }

    public static void showToastShort(String r100) {
        LKUIToast.show(LarkContext.getApplication(), r100);
    }

    public static a createActionLoadingDialog(Context r100, CharSequence r101) {
        return new a(r100, r101);
    }

    public static c createPageLoadingDialog(Context r100, CharSequence r101) {
        return new c(r100, r101);
    }

    public static void runOnUiThreadDelayed(Runnable r100, long r101) {
        VIEW_HANDLER.postDelayed(r100, r101);
    }

    public static void setViewEnabled(View r100, boolean r101) {
        setViewEnabled(r100, r101, new View[]{null});
    }

    public static a createActionLoadingDialog(Context r100, boolean r101) {
        return new a(r100, r101);
    }

    public static c createPageLoadingDialog(Context r100, boolean r101) {
        return new c(r100, r101);
    }

    public static a createActionLoadingDialog(Context r100, CharSequence r101, boolean r102) {
        return new a(r100, r101, r102);
    }

    public static c createPageLoadingDialog(Context r100, CharSequence r101, boolean r102) {
        return new c(r100, r101, r102);
    }

    public static void setViewEnabled(View r100, boolean r101, View... r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r103 = 0;
        if (r102 == null) goto L13;
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        if (r100 == r102[r105]) goto L10;
        r105 = r105 + 1;
        goto L7
    L10:
        return;
    L13:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        ViewGroup r106 = (ViewGroup) r100;
        int r107 = r106.getChildCount();
    L15:
        if (r103 >= r107) goto L17;
        setViewEnabled(r106.getChildAt(r103), r101, r102);
        r103 = r103 + 1;
    L17:
        r100.setEnabled(r101);
    }
}
