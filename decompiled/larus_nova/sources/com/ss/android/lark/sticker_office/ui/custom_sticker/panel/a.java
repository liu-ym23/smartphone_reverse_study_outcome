package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter f440904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter.AddViewHolder f440905b;

    public a(OfficeCustomStickerAdapter r100, OfficeCustomStickerAdapter.AddViewHolder r101) {
        this.f440904a = r100;
        this.f440905b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f440904a.f440862b.c(this.f440905b.itemView);
    }
}
