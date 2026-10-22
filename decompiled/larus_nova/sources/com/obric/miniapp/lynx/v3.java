package com.obric.miniapp.lynx;

import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;
import com.larus.utils.logger.FLogger;
import com.obric.oui.forms.OEditText;
import com.obric.oui.searchbar.v2.OSearchBar;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class v3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUISearchBarUI f398310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSearchBar f398311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OEditText f398312c;

    public /* synthetic */ v3(LynxOUISearchBarUI r100, OSearchBar r101, OEditText r102) {
        this.f398310a = r100;
        this.f398311b = r101;
        this.f398312c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxOUISearchBarUI r100 = this.f398310a;
        OSearchBar r101 = this.f398311b;
        OEditText r102 = this.f398312c;
        int r103 = LynxOUISearchBarUI.f397986i;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        r101.clearFocus();     // Catch: Throwable -> L20
        r102.clearFocus();     // Catch: Throwable -> L20
        e6 r105 = r100.f397988b;     // Catch: Throwable -> L20
        if (r105 == null) goto L6;
        r105.requestFocus();     // Catch: Throwable -> L20
    L6:
        IBinder r106 = r102.getWindowToken();     // Catch: Throwable -> L20
        Boolean r107 = null;
        if (r106 != null) goto L12;
        e6 r108 = r100.f397988b;     // Catch: Throwable -> L20
        if (r108 == null) goto L11;
        r106 = r108.getWindowToken();     // Catch: Throwable -> L20
        goto L12
    L11:
        r106 = null;
    L12:
        Object r109 = r102.getContext().getSystemService("input_method");     // Catch: Throwable -> L20
        if ((r109 instanceof InputMethodManager) == false) goto L15;
        InputMethodManager r110 = (InputMethodManager) r109;     // Catch: Throwable -> L20
    L16:
        if (r110 == null) goto L18;
        r107 = Boolean.valueOf(r110.hideSoftInputFromWindow(r106, 0));     // Catch: Throwable -> L20
    L18:
        Object r111 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L20
    L22:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L28;
        FLogger.f375446a.w("LynxOUISearchBarUI", "clearFocusAndHideIme failed", r112);
        return;
    L28:
        return;
    L15:
        r110 = null;
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
