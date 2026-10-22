package com.bytedance.ies.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.xelement.viewpager.Pager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG;", "Lcom/bytedance/ies/xelement/viewpager/viewpager/BaseCustomViewPager;", "", MapController.ITEM_LAYER_TAG, "", "setCurrentItem", "", RXScreenCaptureService.KEY_INDEX, "Z", "getMPagerChangeAnimation", "()Z", "setMPagerChangeAnimation", "(Z)V", "mPagerChangeAnimation", "Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG$a;", ce.f26395j, "Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG$a;", "getMTouchHandler", "()Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG$a;", "setMTouchHandler", "(Lcom/bytedance/ies/xelement/viewpager/viewpager/CustomViewPagerNG$a;)V", "mTouchHandler", ce.f26396k, "getMForceCanScroll", "setMForceCanScroll", "mForceCanScroll", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class CustomViewPagerNG extends BaseCustomViewPager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f250606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f250607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f250608k;

    public interface a {
        void onTouch(MotionEvent r100);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public final boolean getMForceCanScroll() {
        return this.f250608k;
    }

    public final boolean getMPagerChangeAnimation() {
        return this.f250606i;
    }

    public final a getMTouchHandler() {
        return this.f250607j;
    }

    public CustomViewPagerNG(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.f250606i = true;
        setOverScrollMode(2);
    }

    @Override // com.bytedance.ies.xelement.viewpager.viewpager.BaseCustomViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f250608k == false) goto L7;
        return true;
    L7:
        return super.canScrollHorizontally(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (getMAllowHorizontalGesture() == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getActionMasked());
    L5:
        if (r101 == null) goto L11;
        if (r101.intValue() != 1) goto L11;
        super.performClick();
    L11:
        if (getMAllowHorizontalGesture() == false) goto L15;
        boolean r102 = super.onTouchEvent(r100);
        a r103 = this.f250607j;
        if (r103 == null) goto L18;
        r103.onTouch(r100);
    L18:
        return r102;
    L15:
        Pager.g r104 = getMInterceptTouchEventListener();
        r102 = false;
        if (r104 == null) goto L18;
        r104.a(false);
        goto L18
    L4:
        r101 = null;
        goto L5
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r100) {
        PagerAdapter r101 = super.getAdapter();
        if (r101 != null) goto L5;
    L7:
        super.setCurrentItem(r100, this.f250606i);
        return;
    L5:
        if (this.f250591g == false) goto L7;
        r100 = (r101.getCount() - r100) - 1;
        goto L7
    }

    public final void setMForceCanScroll(boolean r100) {
        this.f250608k = r100;
    }

    public final void setMPagerChangeAnimation(boolean r100) {
        this.f250606i = r100;
    }

    public final void setMTouchHandler(a r100) {
        this.f250607j = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int r100, boolean r101) {
        PagerAdapter r102 = super.getAdapter();
        if (r102 != null) goto L5;
    L7:
        super.setCurrentItem(r100, r101);
        return;
    L5:
        if (this.f250591g == false) goto L7;
        r100 = (r102.getCount() - r100) - 1;
        goto L7
    }
}
