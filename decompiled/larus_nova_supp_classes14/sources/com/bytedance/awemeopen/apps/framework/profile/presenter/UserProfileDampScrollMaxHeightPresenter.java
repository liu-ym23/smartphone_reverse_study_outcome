package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DmtViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.tablayout.DmtTabLayout;
import com.bytedance.awemeopen.bizmodels.profile.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/presenter/UserProfileDampScrollMaxHeightPresenter;", "Lf04/a;", "", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/bytedance/awemeopen/apps/framework/base/view/scrollablelayout/DampScrollableLayout$d;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileDampScrollMaxHeightPresenter extends f04.a<Unit> implements ViewPager.OnPageChangeListener, DampScrollableLayout.d {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final DampScrollableLayout e;
    public final RelativeLayout f;
    public final DmtTabLayout g;
    public final DmtViewPager h;
    public boolean i;

    @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
    public final boolean c() {
        this.i = true;
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
        if (this.i == false) goto L6;
        this.i = false;
        m();
        return;
    }

    @Override // f04.a
    public final void k() {
        this.h.v(this);
        this.e.e(this);
    }

    public final void m() {
        DampScrollableLayout r0 = this.e;
        f04.a r1 = g(g0.class);
        Intrinsics.checkNotNull(r1);
        g0 r2 = (g0) r1;
        User r3 = r2.i;
        if (r2.d.b.isBlockOrPrivateUser(r3) == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        r0.setCanScrollUp(true);
        r0.setMaxScrollHeight(r2.h);
        return;
    L11:
        xx3.b.a r5 = this.d.e.ga0().f(this.d.b.currentSelectedIndex());
        if (r5 != null) goto L15;
        return;
    L15:
        if ((r5 instanceof xx3.b.a) == false) goto L17;
        xx3.b.a r6 = r5;
    L18:
        if (r6 != null) goto L20;
        return;
    L20:
        RecyclerView r7 = r6.tA();
        if ((r7 instanceof RecyclerView) == true) goto L23;
        return;
    L23:
        if (r7.getChildCount() != 0) goto L25;
        r0.setMaxScrollHeight(((this.f.getTop() + this.g.getHeight()) + r6.XI()) - this.d.a.getMeasuredHeight());
        return;
    L25:
        RecyclerView.LayoutManager r8 = r7.getLayoutManager();
        Intrinsics.checkNotNull(r8);
        View r9 = r8.getChildAt(r7.getChildCount() - 1);
        if (r9 == null) goto L31;
        r0.setMaxScrollHeight(((r9.getBottom() + this.f.getTop()) + this.g.getHeight()) - this.d.a.getMeasuredHeight());
        return;
    L31:
        return;
    L17:
        r6 = null;
        goto L18
    L5:
        if (x54.b.c(r2.e) == false) goto L7;
        r4 = true;
        goto L8
    }

    public UserProfileDampScrollMaxHeightPresenter(com.bytedance.awemeopen.apps.framework.profile.m r2) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        super(r2.a);
        this.d = r2;
        this.e = (DampScrollableLayout) i(2131385230);
        this.f = (RelativeLayout) i(2131383196);
        this.g = (DmtTabLayout) i(2131392060);
        this.h = (DmtViewPager) i(2131392076);
        this.i = true;
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "unit");
        this.h.b(this);
        this.e.d(this);
    }

    public final void onPageSelected(int r1) {
        m();
    }
}
