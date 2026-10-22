package com.bytedance.ee.bear.list.star;

import ae5.j;
import ae5.n;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cd5.e;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dd5.s1;
import e0c.l;
import f0c.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class HomeFavoriteFragment extends j implements d0c.c {
    public n x;
    public SubMenuViewPad y;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final int da0() {
        return 2131563493;
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final void ga0() {
        if (this.y != null) goto L5;
        return;
    L5:
        if (isVisible() == false) goto L17;
        n r0 = this.x;
        if (r0 == null) goto L18;
        this.y.setViewDelegate(r0);
        SubMenuViewPad r1 = this.y;
        if (r1.h != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L11:
        ImageView r2 = r1.h;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r2 = null;
    L14:
        r2.setVisibility(8);
        s1.a.a.a(this.x);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final void W90() {
        super.W90();
        if (this.x == null) goto L14;
        SubMenuViewPad r0 = this.y;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.h != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L9:
        ImageView r1 = r0.h;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r1 = null;
    L12:
        r1.setVisibility(0);
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m54provideComponent() {
        return provideComponent();
    }

    public HomeFavoriteFragment() {
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final void ca0(SmartRefreshLayout r4) {
        if (ea0() == true) goto L5;
        return;
    L5:
        if (findViewById(2131378060) == null) goto L8;
        findViewById(2131378060).setVisibility(8);
    L8:
        if (findViewById(2131378170) == null) goto L11;
        findViewById(2131378170).setVisibility(8);
    L11:
        if (findViewById(2131378061) == null) goto L14;
        findViewById(2131378061).setVisibility(8);
    L14:
        if (findViewById(2131378079) == null) goto L17;
        findViewById(2131378079).setMinimumHeight(0);
    L17:
        if (findViewById(2131374280) == null) goto L20;
        findViewById(2131374280).setVisibility(8);
    L20:
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L22;
        DigitDanceHeader r0 = new DigitDanceHeader(getContext());
        r0.setCustomText(getString(2131887957));
    L23:
        r4.G(r0, com.bytedance.ee.util.ui.n.d(65));
        return;
    L22:
        r0 = new CircleRefreshHeader(getContext());
        goto L23
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (ForsetiHelper.n() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L16;
        ga0();
        return;
    L16:
        return;
    L7:
        if (getParentFragment() == null) goto L11;
        if ((getParentFragment() instanceof wc5.h) == false) goto L11;
        r2 = true;
        goto L12
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.onViewCreated(r1, r2);
        if (getParentFragment() != null) goto L5;
    L7:
        ga0();
        return;
    L5:
        if (getParentFragment().getView() == null) goto L7;
        this.y = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final e ba0(LazyBaseFragment r3, Context r4, AppBarLayout r5) {
        if (ea0() == true) goto L5;
        new ae5.l(r3, r4, r5, new ce5.a(this));
    L5:
        n r0 = new n(r3, r4, r5, new ce5.a(this));
        this.x = r0;
        return r0;
    }
}
