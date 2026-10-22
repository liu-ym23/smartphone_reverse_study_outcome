package com.bytedance.commerce.uikit.base;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import eg4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/commerce/uikit/base/ImmersiveAppCompatDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "uikit_release"}, k = 1, mv = {1, 4, 0})
public class ImmersiveAppCompatDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f202939a;

    public final void J0() {
        Window r100 = getWindow();
        if (r100 == null) goto L6;
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = null;
        this.f202939a = new a(r100, r101);
        I0(r100).getViewTreeObserver().addOnPreDrawListener(this.f202939a);
        return;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Window r100 = getWindow();
        if (r100 == null) goto L12;
        View r101 = I0(r100);
        if (r101 == null) goto L13;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.isAlive() == false) goto L15;
        r102.removeOnPreDrawListener(this.f202939a);
        return;
    L15:
        return;
    L13:
        return;
    }

    public static View I0(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View r100) {
        super.setContentView(r100);
        r100.setFitsSystemWindows(false);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        J0();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int r100) {
        super.setContentView(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L5:
        J0();
    }

    public ImmersiveAppCompatDialog(Context r100, int r101) {
        super(r100, r101);
    }
}
