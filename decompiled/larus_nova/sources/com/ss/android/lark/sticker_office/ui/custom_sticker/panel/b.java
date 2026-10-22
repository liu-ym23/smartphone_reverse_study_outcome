package com.ss.android.lark.sticker_office.ui.custom_sticker.panel;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomStickerAdapter f440906a;

    public b(OfficeCustomStickerAdapter r100) {
        this.f440906a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        OfficeEmojiPreviewPopWindow r102 = this.f440906a.f440866f;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return false;
    L10:
        int r104 = r101.getActionMasked();
        if (r104 != 1) goto L13;
    L21:
        ViewParent r105 = r100.getParent();
        if (r105 == null) goto L24;
        r105.requestDisallowInterceptTouchEvent(false);
    L24:
        return true;
    L13:
        if (r104 != 2) goto L15;
        ViewParent r106 = r100.getParent();
        if (r106 == null) goto L20;
        r106.requestDisallowInterceptTouchEvent(true);
    L20:
        return true;
    L15:
        if (r104 == 3) goto L21;
        return false;
    L5:
        if (r102.isShowing() != true) goto L7;
        r103 = true;
        goto L8
    }
}
