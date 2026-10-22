package com.ss.android.lark.forwardv3.utils;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f425568a = 0;

    static {
    }

    public static boolean b() {
        boolean r100 = a("lark.forward.mention_preview", false);
        Log.i("FGUtils", "FG key: core.forward.mention_preview: " + r100);
        return r100;
    }

    public static boolean c() {
        boolean r100 = a("core.forward.message_reference_update", false);
        Log.i("FGUtils", "FG key: core.forward.create_group_loading: " + r100);
        return !r100;
    }

    public static void d() {
        Log.i("FGUtils", "FG key: im.forward.recentview.recentforward, is " + a("im.forward.recentview.recentforward", false));
    }

    public static boolean a(String r100, boolean r101) {
        return FeatureGatingModule.getFeatureGatingService().isEnable(r100, r101);
    }
}
