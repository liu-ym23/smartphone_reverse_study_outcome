package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import com.lynx.xelement.viewpager.Pager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import x6a.d;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends Pager<CustomViewPager> {
    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    @Override // com.lynx.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(new CustomViewPager(r100), r100);
    }

    public final void setForceCanScroll(boolean r100) {
        getMViewPager().setMForceCanScroll(r100);
    }

    public final void setPagerChangeAnimation(boolean r100) {
        getMViewPager().setMPagerChangeAnimation(r100);
    }

    public final void setViewPagerOverScrollMode(boolean r100) {
        if (r100 == false) goto L4;
        getMViewPager().setOverScrollMode(0);
        return;
    L4:
        getMViewPager().setOverScrollMode(2);
    }
}
