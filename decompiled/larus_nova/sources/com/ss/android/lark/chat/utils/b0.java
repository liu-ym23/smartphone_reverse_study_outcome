package com.ss.android.lark.chat.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes35.dex */
public final class b0 {
    public static int b(float r100) {
        if (r100 <= 0.0f) goto L7;
        r100 = UIHelper.dp2px(r100);
    L7:
        return (int) r100;
    }

    public static ConstraintLayout.LayoutParams a(float r100, float r101, int r102, int r103) {
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(b(r100), b(r101));
        float r105 = 0;
        r104.setMargins(b(r105), b(r102), b(r105), b(r103));
        return r104;
    }
}
