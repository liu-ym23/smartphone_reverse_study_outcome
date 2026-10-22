package com.bytedance.bdturing;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f201793a;

    public d(c r100) {
        this.f201793a = r100;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        int r103 = r102.getKeyCode();
        int r104 = r102.getAction();
        if (r103 == 4) goto L5;
        return false;
    L5:
        if (r104 == 1) goto L7;
        return false;
    L7:
        if (this.f201793a.f201745e.getVisibility() != 0) goto L9;
        c r105 = this.f201793a;
        r105.f201759s = EventReport.CloseType.CLOSE_FB_SYSTEM;
        return false;
    L9:
        VerifyWebView r106 = this.f201793a.f201743c;
        if (r106 != null) goto L12;
    L15:
        c r107 = this.f201793a;
        r107.f201759s = EventReport.CloseType.CLOSE_REASON_BACK;
        return false;
    L12:
        if (r106.canGoBack() == false) goto L15;
        this.f201793a.f201743c.goBack();
        return true;
    }
}
