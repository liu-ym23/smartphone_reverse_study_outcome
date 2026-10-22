package com.bytedance.live.layout;

import android.graphics.RectF;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdjustBase f255198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutScale f255199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutAlign f255200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f255201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f255202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f255203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f255204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayoutStrategy f255205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f255206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f255207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f255208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f255209l;

    public c(AdjustBase r100, LayoutScale r101, LayoutAlign r102, int r103, int r104, float r105, RectF r106, LayoutStrategy r107, RectF r110, boolean r111, boolean r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "scale");
        Intrinsics.checkNotNullParameter(r102, "align");
        Intrinsics.checkNotNullParameter(r106, GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        Intrinsics.checkNotNullParameter(r107, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r110, "uiContainer");
        this.f255198a = r100;
        this.f255199b = r101;
        this.f255200c = r102;
        this.f255201d = r103;
        this.f255202e = r104;
        this.f255203f = r105;
        this.f255204g = r106;
        this.f255205h = r107;
        this.f255206i = r110;
        this.f255207j = r111;
        this.f255208k = r112;
        this.f255209l = r113;
    }
}
