package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f436499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f436500b;

    public d(boolean r100, c r101) {
        this.f436499a = r100;
        this.f436500b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f436499a == false) goto L5;
        this.f436500b.f436492b.b();
    L6:
        PopupWindow r101 = this.f436500b.f436498h;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    L5:
        this.f436500b.f436492b.c();
        goto L6
    }
}
