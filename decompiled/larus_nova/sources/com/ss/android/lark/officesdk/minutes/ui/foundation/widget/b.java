package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmCoveredEditTextView f435749a;

    public b(MmCoveredEditTextView r100) {
        this.f435749a = r100;
    }

    public final void a() {
        long r100 = SystemClock.uptimeMillis();
        MmCoveredEditTextView r101 = this.f435749a;
        long r102 = r100 - r101.f435649i;
        if (r101.isFocused() == false) goto L16;
        MmCoveredEditTextView r103 = this.f435749a;
        if (r103.f435648h == true) goto L16;
        if (r103.f435647g == true) goto L16;
        if (0 <= r102) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L16;
        int r105 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onKeyboardHide", "ignore keyboard hide before shown, elapsed=" + r102, null, 8);
        return;
    L11:
        if (r102 >= 1001) goto L13;
        r104 = true;
    L16:
        MmCoveredEditTextView r106 = this.f435749a;
        r106.f435648h = false;
        r106.clearFocus();
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
}
