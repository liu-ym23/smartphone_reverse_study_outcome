package com.bytedance.awemeopen.apps.framework.comment.util;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.infra.base.image.AoImageView;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final void a(View r100, int r101) {
        if (r100 == null) goto L4;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L5:
        if (r102 == null) goto L8;
        r102.height = r101;
    L8:
        if (r100 == null) goto L11;
        r100.requestLayout();
        return;
    L11:
        return;
    L4:
        r102 = null;
        goto L5
    }

    public static final void b(AoImageView r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L6;
        r103.width = r101;
    L6:
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if (r104 == null) goto L10;
        r104.height = r102;
    L10:
        r100.requestLayout();
    }
}
