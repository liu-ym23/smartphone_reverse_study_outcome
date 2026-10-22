package com.larus.utils;

import android.app.Activity;
import android.transition.AutoTransition;
import android.transition.Transition;
import androidx.core.app.ActivityCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375378a = 0;

    static {
    }

    public d() {
    }

    public static void a(Activity r100, l2a.c r101, l2a.d r102, com.larus.video.impl.douyin.j r103, l2a.f r104, int r105) {
        Transition r106 = r101;
        if ((r105 & 2) == 0) goto L5;
        r106 = new AutoTransition();
    L5:
        Transition r107 = r102;
        if ((r105 & 4) == 0) goto L8;
        r107 = new AutoTransition();
    L8:
        Function0 r108 = r103;
        if ((r105 & 8) == 0) goto L11;
        r108 = new a();
    L11:
        final Function0 r109 = r104;
        if ((r105 & 16) == 0) goto L14;
        r109 = new b();
    L14:
        Intrinsics.checkNotNullParameter(r106, "enterTransition");
        Intrinsics.checkNotNullParameter(r107, "exitTransition");
        Intrinsics.checkNotNullParameter(r108, "onExitTransitionStart");
        Intrinsics.checkNotNullParameter(r109, "onEnterSharedElementEnd");
        if (r100 == null) goto L19;
        r107.addListener(new c(r108));
        r100.getWindow().setSharedElementEnterTransition(r106);
        r100.getWindow().setSharedElementReturnTransition(r107);
        ActivityCompat.setEnterSharedElementCallback(r100, new ActivityTransition$configTransition$4(r109));
        return;
    }
}
