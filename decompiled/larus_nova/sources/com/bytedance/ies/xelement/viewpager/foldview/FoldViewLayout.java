package com.bytedance.ies.xelement.viewpager.foldview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.xelement.viewpager.CustomAppBarLayout;
import com.bytedance.ies.xelement.viewpager.FoldToolbarLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/foldview/FoldViewLayout;", "Lcom/bytedance/ies/xelement/viewpager/FoldToolbarLayout;", "Lcom/bytedance/ies/xelement/viewpager/CustomAppBarLayout;", "", "getLayoutIntRes", "", "scrollEnable", "", "setScrollEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class FoldViewLayout extends FoldToolbarLayout<CustomAppBarLayout> {
    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public int getLayoutIntRes() {
        return R.layout.x_foldtoolbar_layout;
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public FoldViewLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
    }

    @Override // com.bytedance.ies.xelement.viewpager.FoldToolbarLayout
    public void setScrollEnable(boolean r100) {
        setMScrollEnable(r100);
        ViewGroup.LayoutParams r101 = getMCollapsingToolbarLayout().getLayoutParams();
        if ((r101 instanceof AppBarLayout.LayoutParams) == false) goto L9;
        if (r100 == true) goto L6;
        ((AppBarLayout.LayoutParams) r101).setScrollFlags(0);
    L7:
        getMCollapsingToolbarLayout().setLayoutParams(r101);
        return;
    L6:
        ((AppBarLayout.LayoutParams) r101).setScrollFlags(getMInitScrollFlag());
        goto L7
    }
}
