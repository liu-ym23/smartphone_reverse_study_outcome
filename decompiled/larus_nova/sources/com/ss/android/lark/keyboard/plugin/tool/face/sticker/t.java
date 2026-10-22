package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class t implements StickerPageAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StickerPageFragment f429736a;

    public /* synthetic */ t(StickerPageFragment r100) {
        this.f429736a = r100;
    }

    public final void a(Context r100, int r101, int r102, String r103, ImageView r104, int r105, String r106) {
        StickerPageFragment r107 = this.f429736a;
        int r108 = StickerPageFragment.f429695s;
        WeakReference<k> r109 = r107.f429700h;
        if (r109 != null) goto L5;
        k r110 = null;
    L6:
        if (r110 == null) goto L10;
        r110.c();
        return;
    L10:
        return;
    L5:
        r110 = r109.get();
        goto L6
    }
}
