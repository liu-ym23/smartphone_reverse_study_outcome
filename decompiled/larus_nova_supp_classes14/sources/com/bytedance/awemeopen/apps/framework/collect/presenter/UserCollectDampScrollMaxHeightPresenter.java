package com.bytedance.awemeopen.apps.framework.collect.presenter;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.apps.framework.collect.i;
import f04.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import xx3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/presenter/UserCollectDampScrollMaxHeightPresenter;", "Lf04/a;", "", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/bytedance/awemeopen/apps/framework/base/view/scrollablelayout/DampScrollableLayout$d;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserCollectDampScrollMaxHeightPresenter extends a<Unit> implements ViewPager.OnPageChangeListener, DampScrollableLayout.d {
    public final i d;
    public final DampScrollableLayout e;
    public final RelativeLayout f;
    public final RtlViewPager g;
    public boolean h;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
    public final boolean c() {
        this.h = true;
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
    public final void e(int r1) {
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
    public final void d() {
        if (this.h == false) goto L6;
        this.h = false;
        m();
        return;
    }

    @Override // f04.a
    public final void k() {
        this.g.v(this);
        this.e.e(this);
    }

    public final void m() {
        DampScrollableLayout r0 = this.e;
        b.a r1 = this.d.e.ga0().f(this.d.b.currentSelectedIndex());
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r1 instanceof b.a) == false) goto L8;
        b.a r2 = r1;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        RecyclerView r3 = r2.tA();
        if ((r3 instanceof RecyclerView) == true) goto L14;
        return;
    L14:
        if (r3.getChildCount() != 0) goto L16;
        r0.setMaxScrollHeight((this.f.getTop() + r2.XI()) - this.d.a.getMeasuredHeight());
        return;
    L16:
        RecyclerView.LayoutManager r4 = r3.getLayoutManager();
        Intrinsics.checkNotNull(r4);
        View r5 = r4.getChildAt(r3.getChildCount() - 1);
        if (r5 == null) goto L22;
        r0.setMaxScrollHeight((r5.getBottom() + this.f.getTop()) - this.d.a.getMeasuredHeight());
        return;
    L22:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public UserCollectDampScrollMaxHeightPresenter(i r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = (DampScrollableLayout) i(2131385230);
        this.f = (RelativeLayout) i(2131367132);
        this.g = (RtlViewPager) i(2131392076);
        this.h = true;
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.g.b(this);
        this.e.d(this);
    }

    public final void onPageSelected(int r1) {
        m();
    }
}
