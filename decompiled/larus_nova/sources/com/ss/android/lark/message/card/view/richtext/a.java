package com.ss.android.lark.message.card.view.richtext;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static boolean a(View r100) {
        long r101 = System.currentTimeMillis();
        Object r102 = r100.getTag(R.id.last_click_time);
        boolean r103 = false;
        if (r102 != null) goto L6;
        r100.setTag(R.id.last_click_time, Long.valueOf(r101));
    L10:
        return r103;
    L6:
        if ((r101 - ((Long) r102).longValue()) >= 500) goto L8;
        r103 = true;
    L8:
        if (r103 == true) goto L10;
        r100.setTag(R.id.last_click_time, Long.valueOf(r101));
        goto L10
    }
}
