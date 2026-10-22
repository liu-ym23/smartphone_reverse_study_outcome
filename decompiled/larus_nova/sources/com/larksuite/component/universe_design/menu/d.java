package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements c.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f285129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.e f285130b;

    @Override // com.larksuite.component.universe_design.menu.c.g
    public final ViewGroup create(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = h.f285139a;
        View r102 = this.f285129a;
        c.e r103 = this.f285130b;
        UDDimension r104 = r103.f285094h;
        UDDimension r105 = r103.f285095i;
        UDDimension r106 = r103.f285096j;
        UDDimension r107 = r103.f285097k;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "customView");
        Intrinsics.checkNotNullParameter(r104, "leftPadding");
        Intrinsics.checkNotNullParameter(r105, "topPadding");
        Intrinsics.checkNotNullParameter(r106, "rightPadding");
        Intrinsics.checkNotNullParameter(r107, "bottomPadding");
        FrameLayout r108 = new FrameLayout(r100);
        r108.setBackground(ContextCompat.getDrawable(r100, R.drawable.ud_menu_container_bg));
        r108.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r108.setPadding((int) r104.toPixels(r100), (int) r105.toPixels(r100), (int) r106.toPixels(r100), (int) r107.toPixels(r100));
        r108.addView(r102);
        return r108;
    }

    public d(View r100, c.e r101) {
        this.f285129a = r100;
        this.f285130b = r101;
    }
}
