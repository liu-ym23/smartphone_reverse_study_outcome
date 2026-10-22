package com.larus.aweme.impl.main_bot;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.aweme.impl.databinding.LarusDouyinWrapperFragmentLayoutBinding;
import com.larus.utils.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DouYinWrapperFragment f294806a;

    public /* synthetic */ c(DouYinWrapperFragment r100) {
        this.f294806a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DouYinWrapperFragment r100 = this.f294806a;
        int r101 = DouYinWrapperFragment.f294784n;
        Context r102 = r100.getContext();
        View r103 = null;
        if ((r102 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r104 = (FragmentActivity) r102;
    L6:
        if (r104 == null) goto L31;
        int r105 = u.b(r104);
        if (r105 != 0) goto L14;
        LarusDouyinWrapperFragmentLayoutBinding r106 = r100.f294785d;
        if (r106 == null) goto L32;
        View r107 = r106.f294760c;
        if (r107 == null) goto L33;
        r107.setVisibility(8);
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (r105 <= 0) goto L35;
        LarusDouyinWrapperFragmentLayoutBinding r108 = r100.f294785d;
        if (r108 == null) goto L20;
        View r109 = r108.f294760c;
        if (r109 == null) goto L20;
        r109.setVisibility(0);
    L20:
        LarusDouyinWrapperFragmentLayoutBinding r110 = r100.f294785d;
        if (r110 == null) goto L25;
        View r111 = r110.f294760c;
        if (r111 == null) goto L25;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
    L26:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r112;
        r113.height = r105;
        LarusDouyinWrapperFragmentLayoutBinding r114 = r100.f294785d;
        if (r114 == null) goto L29;
        r103 = r114.f294760c;
    L29:
        Intrinsics.checkNotNull(r103);
        r103.setLayoutParams(r113);
        return;
    L25:
        r112 = null;
        goto L26
    L35:
        return;
    L31:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
