package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.view.View;
import com.ss.android.lark.chat.entity.sticker.Sticker;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter f440915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f440916b;

    public f(OfficeCustomStickerAdapter r100, Sticker r101) {
        this.f440915a = r100;
        this.f440916b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f440915a.f440862b.b(this.f440916b);
    }
}
