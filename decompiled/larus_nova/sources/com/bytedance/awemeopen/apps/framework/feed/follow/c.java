package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f194746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f194747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f194748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f194749d;

    public c(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "mSkyLightTopContainer");
        this.f194746a = r100;
        this.f194747b = "FollowLiveSkyLightHelpe";
        this.f194748c = 300;
    }

    public static void a(final c r100, View r101, float r102, float r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        final boolean r104 = false;
        AoLogger.g(r100.f194747b, new Object[]{"adjust container translationY, start=" + r102 + ", end=" + r103});
        r101.animate().cancel();
        r101.setTag(Float.valueOf(r103));
        r101.setTranslationY(r102);
        ViewPropertyAnimator r105 = r101.animate().setDuration(r100.f194748c).setInterpolator(new com.bytedance.awemeopen.apps.framework.feed.follow.util.a()).translationY(r103).setListener(new b());
        final Boolean r106 = null;
        r105.withEndAction(new a(r100, r106, r104)).start();
    }
}
