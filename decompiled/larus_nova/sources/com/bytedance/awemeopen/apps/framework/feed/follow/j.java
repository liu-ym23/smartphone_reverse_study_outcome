package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f194755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f194756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f194757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f194758d;

    public j(View r100) {
        Intrinsics.checkNotNullParameter(r100, "indicator");
        this.f194755a = r100;
        this.f194758d = (int) r100.getResources().getDimension(R.dimen.homepage_common_tab_indicator_width);
    }

    public final void a(View r100) {
        this.f194756b = r100;
        boolean r101 = true;
        if (r100 == null) goto L17;
        if (r100.getWidth() != 0) goto L12;
        if (this.f194757c == true) goto L17;
        ViewTreeObserver r102 = r100.getViewTreeObserver();
        if (r102 == null) goto L17;
        r102.addOnGlobalLayoutListener(new i(this));
        this.f194757c = true;
        goto L17
    L12:
        if (this.f194755a.getWidth() <= 0) goto L14;
        int r103 = this.f194755a.getWidth();
    L15:
        this.f194755a.setX((r100.getX() + (r100.getWidth() / 2)) - (r103 / 2));
        goto L17
    L14:
        r103 = this.f194758d;
    L17:
        if (this.f194755a.getAlpha() == 1.0f) goto L20;
        r101 = false;
    L20:
        if (r101 == true) goto L23;
        this.f194755a.animate().alpha(1.0f).start();
        return;
    }
}
