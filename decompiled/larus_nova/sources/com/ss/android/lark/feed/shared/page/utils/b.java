package com.ss.android.lark.feed.shared.page.utils;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static boolean b() {
        return heb.a.f484903a.getFeatureGatingDependency().isEnable("lark.feed.anim.disable");
    }

    public static void a(RecyclerView r100) {
        if (b() == false) goto L7;
        if (r100 == null) goto L8;
        r100.getItemAnimator().setRemoveDuration(0);
        r100.getItemAnimator().setMoveDuration(0);
        return;
    L8:
        return;
    }
}
