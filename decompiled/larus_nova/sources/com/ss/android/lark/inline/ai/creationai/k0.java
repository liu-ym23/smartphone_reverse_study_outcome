package com.ss.android.lark.inline.ai.creationai;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class k0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g0 f427140a;

    public k0(g0 r100) {
        this.f427140a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Log.i("SubPanelController", "click panel view");
        long r101 = System.currentTimeMillis();
        g0 r102 = this.f427140a;
        if ((r101 - r102.f427126q) >= 200) goto L7;
        int r103 = r102.f427125p + 1;
        r102.f427125p = r103;
        if (r103 < 5) goto L8;
        r102.f427111b.l();
        this.f427140a.f427125p = 0;
    L8:
        this.f427140a.f427126q = r101;
        return;
    L7:
        r102.f427125p = 1;
        goto L8
    }
}
