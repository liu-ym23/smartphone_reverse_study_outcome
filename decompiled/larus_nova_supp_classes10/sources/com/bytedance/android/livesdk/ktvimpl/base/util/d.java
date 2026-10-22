package com.bytedance.android.livesdk.ktvimpl.base.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    static {
    }

    public static Fragment a(FragmentActivity r4) {
        Object r1 = null;
        if ((r4 instanceof FragmentActivity) == false) goto L22;
        Iterator r5 = r4.getSupportFragmentManager().getFragments().iterator();
    L6:
        if (r5.hasNext() == false) goto L16;
        Object r0 = r5.next();
        Fragment r2 = (Fragment) r0;
        if (r2.isAdded() == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L6;
        r1 = r0;
        goto L16
    L10:
        if (r2.isVisible() == false) goto L12;
        r3 = true;
    L16:
        return (Fragment) r1;
    L22:
        return null;
    }
}
