package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.R;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f435628a;

    public a(View r100) {
        this.f435628a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f435628a;     // Catch: Throwable -> L14
        View r101 = r100.findViewById(R.id.statusBarBackground);     // Catch: Throwable -> L14
        if (r101 == null) goto L6;
        r101.setVisibility(8);     // Catch: Throwable -> L14
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r100;     // Catch: Throwable -> L14
    L9:
        if (r102 == null) goto L17;
        View r103 = r102.getChildAt(0);     // Catch: Throwable -> L14
        if (r103 == null) goto L21;
        r103.setPadding(0, 0, 0, 0);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L17:
        return;
    L8:
        r102 = null;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
