package com.bytedance.ee.bear.document.toolbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes16.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavBarBottomInsetCompatEntity f222344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f222345b;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pcb.a f222346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ocb.a f222347b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f222346a.c(this.f222347b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f222346a.a(this.f222347b);
        }

        public a(pcb.a r100, l r101) {
            this.f222346a = r100;
            this.f222347b = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f222348a = null;

        static {
            f222348a = new n();
        }
    }

    public n() {
        this.f222344a = null;
    }

    public final View a(View r100, int r101) {
        tt5.a.h("ToolbarCompatHelper", "doCompat sEntity=" + this.f222344a + " " + this.f222345b);
        return b(r100, r101, false);
    }

    public final void c(final FragmentActivity r100, NavBarBottomInsetCompatEntity r101) {
        this.f222344a = r101;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEnable() == false) goto L15;
        if (r100 == null) goto L16;
        View r102 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L12:
        r102.post(new m(this, r100));
        return;
    L16:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ee.bear.document.toolbar.l] */
    public final View b(View r110, final int r111, final boolean r112) {
        NavBarBottomInsetCompatEntity r100 = this.f222344a;
        if (r100 != null) goto L5;
    L29:
        return r110;
    L5:
        if (r100.isEnable() == false) goto L29;
        if (this.f222345b <= this.f222344a.getMinLimit()) goto L29;
        if (this.f222345b > this.f222344a.getMinHeight()) goto L29;
        final Context r101 = r110.getContext();
        final FrameLayout r102 = new FrameLayout(r101);
        r102.setId(View.generateViewId());
        r102.setTag("CompatNavBarLayout");
        if (r112 == false) goto L13;
    L15:
        r102.addView(r110);
        final pcb.a r113 = pcb.a.AbstractC7181a.b((Activity) r101);
        if (r112 == true) goto L22;
        r102.setPadding(r102.getPaddingLeft(), r102.getPaddingTop(), r102.getPaddingRight(), this.f222344a.getPadding());
        if (r113.isKeyboardShowing() == false) goto L20;
        ColorDrawable r103 = null;
    L21:
        r102.setBackground(r103);
    L27:
        r102.addOnAttachStateChangeListener(new a(r113, new l(this, r112, r102, r113, r101, r111)));
        return r102;
    L20:
        r103 = new ColorDrawable(com.bytedance.ee.util.ui.n.h(r101, r111));
        goto L21
    L22:
        int r104 = r102.getPaddingLeft();
        int r105 = r102.getPaddingTop();
        int r106 = r102.getPaddingRight();
        if (r113.isKeyboardShowing() == false) goto L25;
        int r107 = this.f222344a.getPadding();
    L26:
        r102.setPadding(r104, r105, r106, r107);
        goto L27
    L25:
        r107 = 0;
        goto L26
    L13:
        if (r110.getParent() == null) goto L15;
        ((ViewGroup) r110.getParent()).removeView(r110);
        goto L15
    }
}
