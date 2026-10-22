package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.ObservableInterval;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ScreenshotCountDownDialog extends Dialog {
    public static final /* synthetic */ int f = 0;
    public TextView a;
    public Disposable b;
    public int c;
    public Function0<Unit> d;
    public int e;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public ScreenshotCountDownDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954212);
        this.d = ScreenshotCountDownDialog$countDownListener$1.INSTANCE;
        this.e = 3;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        Window r10 = getWindow();
        if (r10 == null) goto L5;
        r10.setLayout(-2, -2);
    L5:
        setCancelable(false);
        setContentView(2131560671);
        TextView r11 = (TextView) findViewById(2131368039);
        this.a = r11;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L8:
        r11.setText(String.valueOf(this.e));
        Disposable r12 = this.b;
        if (r12 == null) goto L11;
        r12.dispose();
    L11:
        this.c = this.e;
        TextView r13 = this.a;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L14:
        r13.setText(String.valueOf(this.c));
        Animation r14 = AnimationUtils.loadAnimation(getContext(), 2130772254);
        this.b = RxJavaPlugins.onAssembly(new ObservableInterval(500, 1000, TimeUnit.MILLISECONDS, Schedulers.io())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.view.countdown.a(this, r14), b.a);
    }
}
