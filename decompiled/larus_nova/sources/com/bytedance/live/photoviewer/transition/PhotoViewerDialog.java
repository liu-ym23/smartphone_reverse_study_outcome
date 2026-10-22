package com.bytedance.live.photoviewer.transition;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class PhotoViewerDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f255688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f255689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TransitionPagerAdapter<?> f255690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f255691d;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (isShowing() == false) goto L7;
        TransitionPagerAdapter<?> r100 = this.f255690c;
        if (r100 == null) goto L7;
        r100.onDestroy();
    L7:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r101.getLooper()) goto L12;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    public PhotoViewerDialog(Context r100) {
        super(r100);
        FrameLayout r101 = new FrameLayout(r100);
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f255689b = r101;
        this.f255691d = true;
        RecyclerView r102 = new RecyclerView(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f255688a = r102;
        final LinearLayoutManager r103 = new LinearLayoutManager(r100);
        r103.setOrientation(0);
        r102.setLayoutManager(r103);
        new PagerSnapHelper().attachToRecyclerView(r102);
        r101.addView(r102, 0);
        r102.addOnScrollListener(new AnonymousClass3(this, r103));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(this.f255689b);
        Window r101 = getWindow();
        if (r101 == null) goto L14;
        View r102 = r101.getDecorView();
        if (c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == c.f346341a) goto L9;
        c.a(r103, "getDecorView");
    L9:
        r102.setPadding(0, 0, 0, 0);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.clearFlags(2);
        this.f255689b.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.f255691d == false) goto L12;
        this.f255689b.getBackground().setAlpha(0);
        return;
    L12:
        this.f255689b.getBackground().setAlpha(255);
        return;
    }

    public final void a(int r100, Rect r101) {
        if (isShowing() == true) goto L34;
        TransitionPagerAdapter<?> r102 = this.f255690c;
        if (r102 == null) goto L23;
        if (r100 >= r102.getItemCount()) goto L23;
        this.f255688a.scrollToPosition(r100);
        if (r101 == null) goto L18;
        TransitionPagerAdapter<?> r103 = this.f255690c;
        if (r103 == null) goto L18;
        if (r100 >= r103.getItemCount()) goto L18;
        r103.f255714a = true;
        r103.f255715b = Integer.valueOf(r100);
        r103.f255716c = r101;
    L18:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L21:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
        return;
    L23:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L26:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
        return;
    }
}
