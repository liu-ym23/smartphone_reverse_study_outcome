package com.bytedance.ee.bear.bitable.infoarch.swipe;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import com.ss.android.lark.slideback.SlideFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f213691a = 0;

    static {
    }

    public static void a(Activity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        View r102 = r100.findViewById(R.id.content);
        if (r102 == null) goto L5;
        ViewParent r103 = r102.getParent();
    L7:
        if ((r103 instanceof SlideFrameLayout) == false) goto L10;
        ViewParent r104 = r102.getParent();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.slideback.SlideFrameLayout");
        ((SlideFrameLayout) r104).setSlideable(r101);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
