package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.chat.entity.sticker.Sticker;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sticker.core.model.StickerFileInfo;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter f440911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Sticker f440912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f440913c;

    public d(OfficeCustomStickerAdapter r100, Sticker r101, AppCompatImageView r102) {
        this.f440911a = r100;
        this.f440912b = r101;
        this.f440913c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeCustomStickerAdapter r101 = this.f440911a;
        Sticker r102 = this.f440912b;
        int r103 = OfficeCustomStickerAdapter.f440860l;
        r101.getClass();
        StickerFileInfo r104 = com.ss.android.lark.sticker.core.di.c.a().Uc(r102.getOriginImageKey());
        if (r104 != null) goto L5;
        Log.e("OfficeCustomStickerAdapter", "getLocalStickerFileInfo fail, stickerId: " + r102.getStickerId());
        com.ss.android.lark.keyboard.plugin.tool.face.d r105 = null;
    L6:
        if (r105 == null) goto L9;
        this.f440911a.f440862b.a(this.f440913c, r105);
        return;
    L9:
        return;
    L5:
        com.ss.android.lark.keyboard.plugin.tool.face.d.a r106 = new com.ss.android.lark.keyboard.plugin.tool.face.d.a(r104.getKey());
        r106.f429654b = r104.getUrl();
        r106.f429655c = r104.getFilePath();
        r106.f429656d = r102.getOriginImageWidth();
        r106.f429657e = r102.getOriginImageHeight();
        r105 = new com.ss.android.lark.keyboard.plugin.tool.face.d(r106);
        goto L6
    }
}
