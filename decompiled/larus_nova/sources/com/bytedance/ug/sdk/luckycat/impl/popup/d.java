package com.bytedance.ug.sdk.luckycat.impl.popup;

import android.view.View;
import com.bytedance.ug.sdk.luckycat.impl.lynx.CloseType;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LuckyCatPopupFragment f271420a;

    public d(LuckyCatPopupFragment r100) {
        this.f271420a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.ug.sdk.luckycat.impl.lynx.a r101 = this.f271420a.f271416i;
        if (r101 == null) goto L6;
        r101.Zf(CloseType.CLOSE_BY_USER);
        return;
    }
}
