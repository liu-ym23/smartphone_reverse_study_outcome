package yk5;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p extends yk5.b {
    public static final /* synthetic */ int t = 0;
    public final FragmentActivity k;
    public final TextView l;
    public final TextView m;
    public final View n;
    public final LottieAnimationView o;
    public final View p;
    public final int q;
    public float r;
    public float s;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ p a;

        public b(p r1) {
            this.a = r1;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            if (this.a.isShowing() == false) goto L25;
            sk5.d.b r5 = this.a.j;
            if (r5 == null) goto L7;
            ((vk5.b) r5).b();
        L7:
            p r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r6);
            goto L25
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r1 == null) goto L21;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L10:
            if (Looper.myLooper() == r0.getLooper()) goto L12;
            r0.post(DialogLancet.createDismissRunnable(r6));
        L25:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            int r0 = p.t;
            tt5.a.f("TimerTextAndTapOnBoardingDialog", (Throwable) r3, false);
        }
    }

    static {
    }

    @Override // yk5.b, android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        long r1 = r10.getDownTime();
        long r3 = r10.getEventTime();
        int r5 = r10.getAction();
        float r0 = r10.getX();
        float r6 = this.s + r0;
        float r2 = r10.getY();
        MotionEvent r4 = MotionEvent.obtain(r1, r3, r5, r6, this.r + r2, r10.getMetaState());
        this.k.dispatchTouchEvent(r4);
        if (r10.getAction() != 1) goto L22;
        Handler r7 = DialogLancet.resolveDialogHandler(this);
        if (r7 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        goto L22
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r8 == null) goto L18;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r7.getLooper()) goto L9;
        r7.post(DialogLancet.createDismissRunnable(this));
    L22:
        return super.dispatchTouchEvent(r10);
    }

    @Override // yk5.b, android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Window r5 = getWindow();
        if (r5 == null) goto L5;
        r5.addFlags(262144);
        r5.setGravity(8388659);
        r5.setLayout(-2, -2);
    L5:
        Flowable.just("").delay(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).map(new b(this)).subscribe(c.a, d.a);
    }

    public p(FragmentActivity r3, Window r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "currentActiveWindow");
        super(r3, r4, 2131953747);
        this.k = r3;
        View r5 = LayoutInflater.from(r3).inflate(2131564122, null);
        this.a = r5;
        this.l = (TextView) r5.findViewById(2131381458);
        this.m = (TextView) this.a.findViewById(2131381456);
        this.o = this.a.findViewById(2131388186);
        this.n = this.a.findViewById(2131381455);
        this.p = this.a.findViewById(2131381457);
        this.q = r3.getResources().getDimensionPixelSize(2131167883);
    }

    @Override // yk5.b
    public final void e(int r2, int r3, int r4) {
        this.p.setBackgroundTintList(ColorStateList.valueOf(r2));
        this.n.setBackgroundTintList(ColorStateList.valueOf(r2));
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.p.setOutlineSpotShadowColor(r3);
        this.p.setOutlineAmbientShadowColor(r3);
        this.n.setOutlineSpotShadowColor(r3);
        this.n.setOutlineAmbientShadowColor(r3);
        return;
    }
}
