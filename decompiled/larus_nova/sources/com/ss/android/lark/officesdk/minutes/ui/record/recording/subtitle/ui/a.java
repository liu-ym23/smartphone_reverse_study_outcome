package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f436489a;

    public a(c r100) {
        this.f436489a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f436489a.f436492b.a();
        PopupWindow r101 = this.f436489a.f436498h;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
    }
}
