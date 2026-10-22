package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.sidebar.homedrive.SidebarHomeDriveFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class NewShareFolderFragment extends i implements wc5.f.a, g0, d0c.c {
    public View p;
    public k1 q;
    public n1 r;
    public View s;
    public SubMenuViewPad t;

    @Override // wc5.d
    public final void Cu() {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // wc5.f.a
    public final void eF() {
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // wc5.d
    public final void t(int r1, int r2) {
    }

    @Override // wc5.f.a
    public final void Qi() {
        n1 r0 = this.r;
        if (r0 == null) goto L6;
        r0.Qi();
        return;
    }

    @Override // com.bytedance.ee.bear.list.share.g0
    public final void Ud() {
        if (qc5.a.f() == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L15;
        View r1 = this.s;
        if (r1 == null) goto L16;
        r1.setVisibility(0);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof SidebarHomeDriveFragment) == false) goto L9;
        r0 = true;
        goto L10
    }

    public final void Y90() {
        super.Y90();
        k1 r0 = this.q;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final boolean ca0() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof wc5.h) == false) goto L9;
        return true;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.share.i
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        tt5.a.h("NewShareFolderFragment", "onDestroy()...");
        k1 r0 = this.q;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m40provideComponent() {
        return provideComponent();
    }

    public NewShareFolderFragment() {
    }

    public final void V90(Bundle r8) {
        this.p = View.inflate(getContext(), 2131563486, null);
        if (getParentFragment() != null) goto L5;
    L7:
        aa0(this.p);
        tt5.a.h("NewShareFolderFragment", "initMVP()...");
        ce5.a r6 = new ce5.a(this);
        this.r = new n1(getContext(), this.p, this, r6);
        f1 r3 = new f1(this, getContext(), false, r6);
        k1 r9 = new k1(this.r, r3, getContext(), this, r6);
        this.q = r9;
        r9.create();
        if (qc5.a.f() == true) goto L10;
    L14:
        boolean r10 = false;
    L16:
        if (r10 == false) goto L18;
    L19:
        SmartRefreshLayout r11 = this.p.findViewById(2131378171);
        this.p.findViewById(2131378104).setVisibility(8);
        this.p.findViewById(2131378060).setVisibility(8);
        this.p.findViewById(2131378170).setVisibility(8);
        this.p.findViewById(2131378079).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L22;
        DigitDanceHeader r0 = new DigitDanceHeader(getContext());
        r0.setCustomText(getString(2131887957));
    L23:
        r11.G(r0, com.bytedance.ee.util.ui.n.d(60));
    L25:
        if (ca0() == false) goto L27;
        this.p.findViewById(2131374462).setVisibility(8);
        this.p.findViewById(2131378060).setVisibility(8);
    L27:
        this.s = this.p.findViewById(2131374421);
        View r12 = this.p.findViewById(2131374653);
        if (r12 == null) goto L31;
        r12.setOnClickListener(new q0());
    L31:
        if (ca0() == false) goto L36;
        SubMenuViewPad r13 = this.t;
        if (r13 == null) goto L37;
        r13.setViewDelegate(this);
        this.t.c();
        dd5.s1.a.a.a(this);
        return;
    L37:
        return;
    L36:
        return;
    L22:
        r0 = new CircleRefreshHeader(getContext());
        goto L23
    L18:
        if (ca0() == false) goto L25;
    L10:
        if (getParentFragment() == null) goto L14;
        if ((getParentFragment() instanceof SidebarHomeDriveFragment) == false) goto L14;
        r10 = true;
        goto L16
    L5:
        if (getParentFragment().getView() == null) goto L7;
        this.t = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        goto L7
    }

    @Override // wc5.f.a
    public final void WU(boolean r2) {
        n1 r0 = this.r;
        if (r0 == null) goto L6;
        r0.WU(r2);
        return;
    }

    public final void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h("NewShareFolderFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        k1 r0 = this.q;
        if (r0 == null) goto L5;
        r0.setUserVisibleHint(r3);
    L5:
        if (r3 == true) goto L7;
        return;
    L7:
        if (ca0() == true) goto L9;
        return;
    L9:
        if (this.t != null) goto L11;
        return;
    L11:
        if (ca0() == false) goto L19;
        SubMenuViewPad r4 = this.t;
        if (r4 == null) goto L20;
        r4.setViewDelegate(this);
        this.t.c();
        dd5.s1.a.a.a(this);
        return;
    L20:
        return;
    }
}
