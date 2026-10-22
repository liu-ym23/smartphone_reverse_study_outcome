package u86;

import android.content.Context;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.bytedance.ies.xelement.viewpager.viewpager.CustomViewPagerNG;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends Pager<CustomViewPagerNG> {
    public Boolean M;

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(new CustomViewPagerNG(r100), r100);
        this.M = Boolean.FALSE;
    }

    public final void setForceCanScroll(boolean r100) {
        getMViewPager().setMForceCanScroll(r100);
    }

    public final void setPagerChangeAnimation(boolean r100) {
        getMViewPager().setMPagerChangeAnimation(r100);
    }

    @Override // com.bytedance.ies.xelement.viewpager.Pager
    public void setTabBarElementAdded(boolean r100) {
        this.M = Boolean.valueOf(r100);
    }

    public final void setViewPagerOverScrollMode(boolean r100) {
        if (r100 == false) goto L4;
        getMViewPager().setOverScrollMode(0);
        return;
    L4:
        getMViewPager().setOverScrollMode(2);
    }
}
