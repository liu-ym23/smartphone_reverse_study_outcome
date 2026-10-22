package com.bytedance.ee.bear.quoto;

import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements Runnable {
    public final /* synthetic */ f a;

    public final void a() {
        if (this.a.a.isAdded() == true) goto L6;
        tt5.a.h("QuotaFragment", "notifyHeightChange... isAdded is false");
        return;
    L6:
        tt5.a.h("QuotaFragment", "notifyHeightChange...");
        if ((this.a.a.getDialog() instanceof BottomSheetDialog) == false) goto L9;
        BottomSheetDialog r0 = this.a.a.getDialog();
    L10:
        ViewGroup r1 = (ViewGroup) r0.findViewById(2131368870);
        if (r1 == null) goto L16;
        CoordinatorLayout r2 = r1.getParent();
        BottomSheetBehavior.from(r1).setPeekHeight(r1.getHeight());
        if ((r2 instanceof CoordinatorLayout) == false) goto L17;
        r2.getParent().requestLayout();
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r0 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(f r1) {
        this.a = r1;
    }
}
