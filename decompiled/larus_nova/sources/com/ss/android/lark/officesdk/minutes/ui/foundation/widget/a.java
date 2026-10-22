package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.inputmethod.InputMethodManager;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmCoveredEditTextView f435748a;

    public a(MmCoveredEditTextView r100) {
        this.f435748a = r100;
    }

    public final void a() {
        Object r100 = this.f435748a.getContext().getSystemService("input_method");     // Catch: Exception -> L10
        if ((r100 instanceof InputMethodManager) == false) goto L6;
        InputMethodManager r101 = (InputMethodManager) r100;     // Catch: Exception -> L10
    L7:
        if (r101 == null) goto L15;
        r101.hideSoftInputFromWindow(this.f435748a.getWindowToken(), 0);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L6:
        r101 = null;
    L10:
        e = move-exception;
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.FOUNDATION, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "error=" + e.getMessage(), null);
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
