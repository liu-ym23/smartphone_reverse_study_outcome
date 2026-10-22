package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public final FrameLayout a;
    public final String b;
    public final long c;
    public boolean d;

    public c(FrameLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "mSkyLightTopContainer");
        this.a = r3;
        this.b = "FollowLiveSkyLightHelpe";
        this.c = 300;
    }

    public static void a(final c r4, View r5, float r6, float r7) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "container");
        final boolean r3 = false;
        AoLogger.g(r4.b, new Object[]{"adjust container translationY, start=" + r6 + ", end=" + r7});
        r5.animate().cancel();
        r5.setTag(Float.valueOf(r7));
        r5.setTranslationY(r6);
        ViewPropertyAnimator r8 = r5.animate().setDuration(r4.c).setInterpolator(new com.bytedance.awemeopen.apps.framework.feed.follow.util.a()).translationY(r7).setListener(new b());
        final Boolean r9 = null;
        r8.withEndAction(new a(r4, r9, r3)).start();
    }
}
