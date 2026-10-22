package com.larus.commercecredit.impl.page;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseCommerceCreditFragment f325752a;

    public /* synthetic */ b(BaseCommerceCreditFragment r100) {
        this.f325752a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final BaseCommerceCreditFragment r100 = this.f325752a;
        int r101 = BaseCommerceCreditFragment.f325725e;
        Dialog r102 = r100.getDialog();     // Catch: Throwable -> L18 Exception -> L20
        if (r102 == null) goto L25;
        View r103 = r102.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L18 Exception -> L20
        if (r103 == null) goto L25;
        T r104 = r100.f325726d;     // Catch: Throwable -> L18 Exception -> L20
        if (r104 == 0) goto L25;
        View r105 = r104.getRoot();     // Catch: Throwable -> L18 Exception -> L20
        if (r105 == null) goto L25;
        int r106 = r100.U90();     // Catch: Throwable -> L18 Exception -> L20
        if (r106 <= 0) goto L25;
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();     // Catch: Throwable -> L18 Exception -> L20
        r107.height = r106;     // Catch: Throwable -> L18 Exception -> L20
        r103.setLayoutParams(r107);     // Catch: Throwable -> L18 Exception -> L20
        final BottomSheetBehavior r108 = BottomSheetBehavior.from(r103);     // Catch: Throwable -> L18 Exception -> L20
        r108.setPeekHeight(r106);     // Catch: Throwable -> L18 Exception -> L20
        r103.requestLayout();     // Catch: Throwable -> L18 Exception -> L20
        r105.requestLayout();     // Catch: Throwable -> L18 Exception -> L20
        new Handler(Looper.getMainLooper()).post(new d(r108, r100));     // Catch: Throwable -> L18 Exception -> L20
    L25:
        r100.W90();
        return;
    L20:
        T r109 = r100.f325726d;     // Catch: Throwable -> L18
        if (r109 == 0) goto L25;
        View r110 = r109.getRoot();     // Catch: Throwable -> L18
        if (r110 == null) goto L25;
        r110.requestLayout();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r100.W90();
        throw th;
    }
}
