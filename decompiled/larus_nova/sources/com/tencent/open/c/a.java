package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes31.dex */
public class a extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f461744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f461745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f461746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC5543a f461747d;

    /* JADX INFO: renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC5543a {
        void a();

        void a(int r100);
    }

    static {
        f461744a = a.class.getName();
    }

    public a(Context r100) {
        super(r100);
        this.f461745b = null;
        this.f461746c = false;
        this.f461747d = null;
        this.f461745b = new Rect();
    }

    public static View INVOKEVIRTUAL_com_tencent_open_c_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public void a(InterfaceC5543a r100) {
        this.f461747d = r100;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r101);
        Activity r103 = (Activity) getContext();
        INVOKEVIRTUAL_com_tencent_open_c_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r103.getWindow()).getWindowVisibleDisplayFrame(this.f461745b);
        int r104 = this.f461745b.top;
        int r105 = (r103.getWindowManager().getDefaultDisplay().getHeight() - r104) - r102;
        InterfaceC5543a r106 = this.f461747d;
        if (r106 == null) goto L9;
        if (r102 == 0) goto L9;
        if (r105 <= 100) goto L8;
        r106.a((Math.abs(this.f461745b.height()) - getPaddingBottom()) - getPaddingTop());
        goto L9
    L8:
        r106.a();
    L9:
        super.onMeasure(r100, r101);
    }
}
