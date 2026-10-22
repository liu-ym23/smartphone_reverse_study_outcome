package com.larus.uaigc.createpage;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f371426a;

    public /* synthetic */ b0(FrameLayout r100) {
        this.f371426a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout r100 = this.f371426a;
        int r101 = CreationHalfChatFragment.f371364p;
        if (r100.getChildCount() != 0) goto L11;
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L7;
        ViewGroup r103 = (ViewGroup) r102;
    L8:
        if (r103 == null) goto L12;
        r103.removeView(r100);
        return;
    L12:
        return;
    L7:
        r103 = null;
        goto L8
    }
}
