package com.larksuite.component.ui.toast.loading;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u000eH\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larksuite/component/ui/toast/loading/LKUILoadingToastImpl;", "Lcom/larksuite/component/ui/dialog/LKUIDialog;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isBlock", "", "<init>", "(Landroid/content/Context;Z)V", "handler", "Landroid/os/Handler;", "mContent", "Lcom/larksuite/component/ui/toast/loading/LKUILoadingToastImpl$LoadingContent;", "mContext", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onMakeText", "text", "", DyPayConstant.KEY_SHOW_LOADING, "cancel", "success", "fail", "scheduleDismiss", "delay", "", "handleDismiss", "dismiss", "show", "duration", "postShow", "handleShow", "resetDismissDuration", "Companion", "LoadingContent", "ToastMessageHandler", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKUILoadingToastImpl extends LKUIDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f284478h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f284479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f284480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f284481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f284482g;

    public static final class a {
    }

    public static final class b extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f284483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImageView f284484b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284485c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f284486d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ValueAnimator f284487e;

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f284485c != 1) goto L5;
            ValueAnimator r100 = this.f284487e;
            Intrinsics.checkNotNull(r100);
            r100.start();
            return;
        L5:
            ValueAnimator r101 = this.f284487e;
            Intrinsics.checkNotNull(r101);
            r101.cancel();
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f284485c = -1;
            float r101 = j08.b.a(getContext(), 124);
            float r102 = j08.b.a(getContext(), 40);
            FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
            setMinimumWidth((int) r101);
            setMinimumHeight((int) r102);
            r103.gravity = 81;
            setLayoutParams(r103);
            int r104 = (int) j08.b.a(getContext(), 5.0f);
            int r105 = r104 * 4;
            setPadding(r105, r104, r105, r104);
            int r106 = (int) j08.b.a(getContext(), 20.0f);
            FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r106, r106);
            this.f284484b = new ImageView(getContext());
            TextView r108 = new TextView(getContext());
            r108.setTextColor(-1);
            r108.setTextSize(14.0f);
            r108.setMaxLines(4);
            r108.setEllipsize(TextUtils.TruncateAt.END);
            this.f284483a = r108;
            FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(-2, -2);
            r109.setMarginStart((int) j08.b.a(getContext(), 10.0f));
            LinearLayout r110 = new LinearLayout(getContext());
            r110.setGravity(16);
            r110.setOrientation(0);
            FrameLayout.LayoutParams r111 = new FrameLayout.LayoutParams(-2, -2);
            r111.gravity = 17;
            r110.addView(this.f284484b, r107);
            r110.addView(this.f284483a, r109);
            addView(r110, r111);
            GradientDrawable r112 = new GradientDrawable();
            r112.setShape(0);
            r112.setColor(j08.b.b(getContext().getResources().getColor(R.color.lkui_N1000), 1.0f));
            r112.setCornerRadius(j08.b.a(getContext(), 50));
            setBackground(r112);
            ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            r113.addUpdateListener(this);
            r113.setDuration(1000);
            r113.setRepeatMode(1);
            r113.setRepeatCount(-1);
            r113.setInterpolator(new LinearInterpolator());
            this.f284487e = r113;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            this.f284486d = ((Float) r101).floatValue();
            if (this.f284485c != 1) goto L5;
            ImageView r102 = this.f284484b;
            Intrinsics.checkNotNull(r102);
            r102.setRotation(this.f284486d);
        L5:
            postInvalidate();
        }
    }

    public static final class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<LKUILoadingToastImpl> f284488a;

        public c(WeakReference<LKUILoadingToastImpl> r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            super(Looper.getMainLooper());
            this.f284488a = r100;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            switch(r100.what) {
                case 61441: goto L17;
                case 61442: goto L5;
                default: goto L51;
            };
        L5:
            LKUILoadingToastImpl r101 = this.f284488a.get();
            if (r101 == null) goto L38;
            Context r102 = r101.f284482g;
            if ((r102 instanceof Activity) == false) goto L13;
            if (((Activity) r102).isFinishing() == false) goto L13;
            return;
        L13:
            if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L42;
            DialogLancet.handleBlockedDialogShow(r101);
            return;
        L42:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
        L16:
            DialogLancet.beforeDialogShow(r101);
            r101.show();
            DialogLancet.afterDialogShow(r101);
            return;
        L38:
            return;
        L17:
            LKUILoadingToastImpl r103 = this.f284488a.get();
            if (r103 == null) goto L47;
            int r104 = LKUILoadingToastImpl.f284478h;
            if (r103.isShowing() == false) goto L48;
            Handler r105 = DialogLancet.resolveDialogHandler(r103);
            if (r105 != null) goto L24;
        L26:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L29 Exception -> L31
        L35:
            DialogLancet.afterDialogDismiss(r103);
            return;
        L29:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L31:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L29
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L29
            if (r106 == null) goto L35;
            d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L29
            goto L35
        L24:
            if (Looper.myLooper() == r105.getLooper()) goto L26;
            r105.post(DialogLancet.createDismissRunnable(r103));
            return;
        L48:
            return;
        L47:
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.component.ui.dialog.LKUIDialog, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        Message r100 = Message.obtain(this.f284480e, 61441);
        this.f284480e.sendMessageDelayed(r100, 0);
    }

    @Override // com.larksuite.component.ui.dialog.LKUIDialog, com.larksuite.component.universe_design.dialog.UDDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        ValueAnimator r101 = this.f284481f.f284487e;
        if (r101 == null) goto L26;
        Intrinsics.checkNotNull(r101);
        r101.cancel();
        return;
    L26:
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r102 == null) goto L16;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f284480e.removeMessages(61441);
        i08.a.a();
    }

    public LKUILoadingToastImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.LKUI_ToastDialog);
        this.f284479d = true;
        this.f284480e = new c(new WeakReference(this));
        this.f284482g = r100;
        this.f284481f = new b(r100);
    }

    @Override // com.larksuite.component.ui.dialog.LKUIDialog, com.larksuite.component.universe_design.dialog.UDDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        b r101 = this.f284481f;
        setContentView(r101, r101.getLayoutParams());
        setCanceledOnTouchOutside(!this.f284479d);
        setCancelable(!this.f284479d);
        if (this.f284479d == true) goto L7;
        Window r102 = getWindow();
        if (r102 == null) goto L7;
        r102.setFlags(8, 8);
    L7:
        Window r103 = getWindow();
        Intrinsics.checkNotNull(r103);
        WindowManager.LayoutParams r104 = r103.getAttributes();
        int r105 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f284481f.measure(r105, r105);
        Integer r106 = i08.c.f487896a;
        Context r107 = getContext();
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (i08.c.f487897b != null) goto L10;
        Toast r108 = new Toast(r107);
        i08.c.f487896a = Integer.valueOf(r108.getYOffset());
        i08.c.f487897b = Integer.valueOf(r108.getGravity());
    L10:
        Integer r109 = i08.c.f487897b;
        Intrinsics.checkNotNull(r109);
        r104.gravity = r109.intValue();
        Context r110 = getContext();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (i08.c.f487896a != null) goto L13;
        Toast r111 = new Toast(r110);
        i08.c.f487896a = Integer.valueOf(r111.getYOffset());
        i08.c.f487897b = Integer.valueOf(r111.getGravity());
    L13:
        Integer r112 = i08.c.f487896a;
        Intrinsics.checkNotNull(r112);
        r104.y = r112.intValue() + ((int) j08.b.a(getContext(), 40.0f));
        Window r113 = getWindow();
        if (r113 == null) goto L17;
        r113.setAttributes(r104);
        return;
    }
}
