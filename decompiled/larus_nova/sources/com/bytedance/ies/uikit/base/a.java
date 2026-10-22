package com.bytedance.ies.uikit.base;

import android.app.Activity;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static void a(Activity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof SSActivity) == false) goto L7;
        ((SSActivity) r100).A1(R.anim.slide_in_left, R.anim.slide_out_right);
        return;
    L7:
        r100.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public static void b(Activity r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = R.anim.slide_out_left;
        int r103 = R.anim.slide_in_right;
        if (r101 == 0) goto L17;
        if (r101 != 1) goto L9;
        r102 = 0;
        r103 = 0;
        goto L17
    L9:
        if (r101 != 2) goto L11;
        r103 = R.anim.slide_in_right_bottom;
        r102 = R.anim.slide_out_left_top;
        goto L17
    L11:
        if (r101 != 3) goto L17;
        r103 = R.anim.slide_in_left;
        r102 = R.anim.slide_out_right;
    L17:
        if ((r100 instanceof SSActivity) == false) goto L19;
        ((SSActivity) r100).A1(r103, r102);
        return;
    L19:
        r100.overridePendingTransition(r103, r102);
    }
}
