package com.bytedance.awemeopen.apps.framework.comment.util;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.infra.base.image.AoImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final void a(View r1, int r2) {
        if (r1 == null) goto L4;
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
    L5:
        if (r0 == null) goto L8;
        r0.height = r2;
    L8:
        if (r1 == null) goto L11;
        r1.requestLayout();
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static final void b(AoImageView r1, int r2, int r3) {
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        if (r0 == null) goto L6;
        r0.width = r2;
    L6:
        ViewGroup.LayoutParams r4 = r1.getLayoutParams();
        if (r4 == null) goto L10;
        r4.height = r3;
    L10:
        r1.requestLayout();
    }
}
