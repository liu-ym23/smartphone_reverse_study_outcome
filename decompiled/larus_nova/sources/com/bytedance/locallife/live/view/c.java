package com.bytedance.locallife.live.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f260815c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f260816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f260817b;

    public static final class a {
    }

    static {
    }

    public c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f260816a = r100;
        r100.getContext();
        if ((r100.getBackground() instanceof GradientDrawable) == false) goto L5;
        Drawable r101 = r100.getBackground();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r102 = (GradientDrawable) r101;
    L6:
        r102.mutate();
        this.f260817b = r102;
        return;
    L5:
        r102 = new GradientDrawable();
        goto L6
    }
}
