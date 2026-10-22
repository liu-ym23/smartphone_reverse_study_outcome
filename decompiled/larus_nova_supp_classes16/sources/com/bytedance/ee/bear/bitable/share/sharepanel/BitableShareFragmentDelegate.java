package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.BitableShareParams;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView;
import com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.larksuite.component.universe_design.notice.UDNotice;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableShareFragmentDelegate extends com.bytedance.ee.bear.bitable.share.sharepanel.a implements CompoundButton.OnCheckedChangeListener {
    public BitableShareLinkShareSetView f;
    public com.bytedance.ee.bear.bitable.share.view.memberview.d g;
    public UDNotice h;
    public mu4.c i;
    public boolean j;
    public final Lazy k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BitableShareFragmentDelegate a;

        public b(BitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IShareMeta r3 = (IShareMeta) r2;
            BitableShareParams r0 = this.a.o();
            Intrinsics.checkNotNull(r3);
            r0.setBitableShareMeta(r3);
            this.a.z();
            this.a.D();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("BitableShareFragmentDelegate", "fetch share meta fails", (Throwable) r4, false);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ BitableShareFragmentDelegate a;

        public d(BitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            BitableSharePermission r6 = (BitableSharePermission) r5;
            BitableShareFragmentDelegate r0 = this.a;
            String r2 = r0.o().getToken();
            int r3 = this.a.o().getType();
            Intrinsics.checkNotNull(r6);
            r0.i = new mu4.c(r2, r3, r6);
            this.a.C(r6);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ BitableShareFragmentDelegate a;

        public e(BitableShareFragmentDelegate r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("BitableShareFragmentDelegate", "updatePermission()...error", r5, false);
            BitableShareFragmentDelegate r0 = this.a;
            Intrinsics.checkNotNull(r5);
            r0.x(r5);
            BitableShareFragmentDelegate r6 = this.a;
            com.bytedance.ee.bear.bitable.share.view.memberview.d r1 = r6.g;
            BitableShareLinkShareSetView r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("memberView");
            r1 = null;
        L5:
            r1.s();
            BitableShareLinkShareSetView r7 = r6.f;
            if (r7 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("linkShareSetView");
        L9:
            r2.s();
            return;
        L8:
            r2 = r7;
            goto L9
        }
    }

    static {
    }

    public final void D() {
        if (this.j == false) goto L6;
        tt5.a.k("BitableShareFragmentDelegate", "shareToken is empty!!!");
        this.i = new mu4.c(o().getToken(), o().getType(), new BitableSharePermission(0));
        C(new BitableSharePermission(0));
        return;
    L6:
        Disposable r0 = pu4.a.a(o().getToken(), o().getBitableShareMeta().getShareToken(), o().getTableId(), o().getViewId(), r().getShareType().getType()).observeOn(fo5.d.d()).subscribe(new d(this), new e(this));
        this.c.add(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.view.View, com.bytedance.ee.bear.bitable.share.view.BitableShareLinkShareSetView] */
    /* JADX WARN: Type inference failed for: r0v27, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v28, types: [android.widget.LinearLayout, com.bytedance.ee.bear.bitable.share.view.memberview.d] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.view.View, android.widget.LinearLayout, com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout, com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout] */
    /* JADX WARN: Type inference failed for: r15v0, types: [android.view.View, com.bytedance.ee.bear.bitable.share.view.BitableShareSwitchView] */
    /* JADX WARN: Type inference failed for: r1v29, types: [android.widget.LinearLayout] */
    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onViewCreated() {
        super.onViewCreated();
        p().AB(mu4.b.c(p().requireContext(), r().getShareType()));
        UDNotice r0 = new UDNotice(p().requireContext());
        this.h = r0;
        r0.setIcon(2131256187);
        UDNotice r1 = this.h;
        ?? r10 = 0;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dashboardNotice");
        r1 = null;
    L5:
        r1.setText(2131886838);
        LinearLayout r2 = p().Pf();
        View r3 = this.h;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dashboardNotice");
        r3 = null;
    L8:
        r2.addView(r3);
        ViewGroup r4 = this.h;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("dashboardNotice");
        r4 = null;
    L11:
        r4.setVisibility(8);
        if (com.bytedance.ee.bear.bitable.c.j() == false) goto L14;
        Fragment r12 = o().getSourceFragment();
    L15:
        ?? r13 = com.bytedance.ee.bear.bitable.share.sharepanel.a.t(p().requireContext());
        boolean r14 = false;
        r13.setHasDivider(false);
        final ?? r16 = new BitableShareSwitchView(p().requireContext());
        r16.S5(o().getToken(), o().getTableId(), o().getViewId(), o().getRecordId(), r().getShareType().getType(), o().getBitableShareMeta(), new BitableShareFragmentDelegate$onViewCreated$spaceSettingGroupLayout$1$1$1(r16, this), this);
        r13.addView(r16, new ViewGroup.LayoutParams(-1, -2));
        r13.addView((View) this.k.getValue());
        final ?? r5 = new BitableShareLinkShareSetView(p().requireContext(), r12);
        this.f = r5;
        r5.setUIDelegate(new BitableShareFragmentDelegate$onViewCreated$spaceSettingGroupLayout$1$2$1(this, r5));
        r5.setUnableClickListener(new BitableShareFragmentDelegate$onViewCreated$spaceSettingGroupLayout$1$2$2(this));
        r13.addView(r5, new ViewGroup.LayoutParams(-1, -2));
        p().Pf().addView(r13);
        ?? r6 = new com.bytedance.ee.bear.bitable.share.view.memberview.d(p().requireActivity(), r12, o().getType(), o().getToken(), o().getBitableShareMeta().getShareToken());
        Context r7 = r6.getContext();
        EShareType r8 = r().getShareType();
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "shareType");
        int[] r9 = mu4.b.a.a;
        if (r9[r8.ordinal()] != 3) goto L18;
        String r11 = r7.getString(2131886520);
    L19:
        r6.setInviteMemberTitle(r11);
        Context r17 = r6.getContext();
        EShareType r18 = r().getShareType();
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "shareType");
        if (r9[r18.ordinal()] != 3) goto L22;
        String r19 = r17.getString(2131886523);
    L23:
        r6.setManageMemberTitle(r19);
        r6.setUnableClickListener(new BitableShareFragmentDelegate$onViewCreated$1$1(this));
        this.g = r6;
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.topMargin = com.bytedance.ee.util.ui.n.d(16);
        ?? r21 = p().Pf();
        ih5.a r22 = this.g;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("memberView");
        r22 = null;
    L26:
        r21.addView(r22, r20);
        com.bytedance.ee.bear.bitable.share.view.memberview.d r23 = this.g;
        if (r23 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("memberView");
    L30:
        r10.setVisibility(8);
        z();
        if (o().getBitableShareMeta().getShareToken().length() != 0) goto L33;
        r14 = true;
    L33:
        this.j = r14;
        mu4.f.i();
        return;
    L29:
        r10 = r23;
        goto L30
    L22:
        r19 = r17.getString(2131886846);
        goto L23
    L18:
        r11 = r7.getString(2131886830);
        goto L19
    L14:
        r12 = null;
        goto L15
    }

    public final String i() {
        return mu4.b.b(p().requireContext(), r().getShareType(), o());
    }

    public final void initData() {
        if (o().getBitableShareMeta().getShareToken().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
    L8:
        int r1 = mu4.f.a;
        mu4.f.g(r().getShareType(), o().getBitableShareMeta().isOpen());
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onResume() {
        super.onResume();
        if (r().getShareType() != EShareType.DASHBOARD_REDIRECT) goto L5;
        Disposable r0 = ((com.bytedance.ee.bear.share.b) org.koin.java.a.c(com.bytedance.ee.bear.share.b.class, null, null, 6)).i(o().getToken(), o().getTableId(), o().getViewId(), Integer.valueOf(EShareType.DASHBOARD.getType()), null).subscribe(new b(this), c.a);
        this.c.add(r0);
        return;
    L5:
        D();
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void w() {
        if (r().isOpen() == false) goto L6;
        Toast.makeText(p().requireContext(), 2131886836, 0).show();
        return;
    }

    public final void z() {
        if (r().getShareType() == EShareType.DASHBOARD_REDIRECT) goto L5;
        E(o().getBitableShareMeta().isOpen());
        A(false);
        return;
    L5:
        A(true);
        y(false);
    }

    public final com.bytedance.ee.bear.share.export.f w1() {
        return this.i;
    }

    public BitableShareFragmentDelegate(com.bytedance.ee.bear.share.export.e r1) {
        super(r1);
        this.k = LazyKt.lazy(new BitableShareFragmentDelegate$linkShareSetingDivier$2(this));
    }

    public final void A(boolean r4) {
        ViewGroup r0 = this.h;
        Integer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dashboardNotice");
        r0 = null;
    L5:
        Integer r2 = 0;
        r2.intValue();
        if (r4 == false) goto L8;
        r1 = r2;
    L8:
        if (r1 == null) goto L10;
        int r5 = r1.intValue();
    L11:
        r0.setVisibility(r5);
        return;
    L10:
        r5 = 8;
        goto L11
    }

    public final void B(boolean r4) {
        ih5.a r0 = this.g;
        Integer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memberView");
        r0 = null;
    L5:
        Integer r2 = 0;
        r2.intValue();
        if (r4 == false) goto L8;
        r1 = r2;
    L8:
        if (r1 == null) goto L10;
        int r5 = r1.intValue();
    L11:
        r0.setVisibility(r5);
        return;
    L10:
        r5 = 8;
        goto L11
    }

    public final void C(BitableSharePermission r9) {
        BitableSharePermSetInfo r7 = new BitableSharePermSetInfo(o().getUrl(), o().getType(), o().getToken(), o().getBitableShareMeta(), r9, o().getBitableShareRecordInfo());
        BitableShareLinkShareSetView r0 = this.f;
        com.bytedance.ee.bear.bitable.share.view.memberview.d r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareSetView");
        r0 = null;
    L5:
        r0.setBitableSharePermSetInfo(r7);
        if (r().getShareType() != EShareType.DASHBOARD_REDIRECT) goto L9;
        B(false);
        return;
    L9:
        if (r9.b.isLinkShareClose() == false) goto L15;
        B(true);
        com.bytedance.ee.bear.bitable.share.view.memberview.d r2 = this.g;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("memberView");
    L14:
        r1.setBitableSharePermSetInfo(r7);
    L17:
        if (r9.a.canShare() == true) goto L21;
        tt5.a.h("BitableShareFragmentDelegate", "can not share");
        E(false);
        return;
    L21:
        return;
    L13:
        r1 = r2;
        goto L14
    L15:
        B(false);
        goto L17
    }

    public final void E(boolean r4) {
        BitableShareLinkShareSetView r0 = this.f;
        com.bytedance.ee.bear.bitable.share.view.memberview.d r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkShareSetView");
        r0 = null;
    L5:
        r0.setEnable(r4);
        View r2 = (View) this.k.getValue();
        if (r4 == false) goto L8;
        float r3 = 1.0f;
    L9:
        r2.setAlpha(r3);
        com.bytedance.ee.bear.bitable.share.view.memberview.d r5 = this.g;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("memberView");
    L13:
        r1.setEnable(r4);
        y(r4);
        return;
    L12:
        r1 = r5;
        goto L13
    L8:
        r3 = 0.3f;
        goto L9
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        if (r().getShareType() != EShareType.DASHBOARD_REDIRECT) goto L5;
        return;
    L5:
        E(r3);
        if (this.j == true) goto L8;
        return;
    L8:
        if (r().getShareToken().length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L15;
        this.j = false;
        D();
        o().setUrl(n(o().getBitableShareMeta().getShareToken()));
        return;
    L15:
        return;
    L10:
        r4 = false;
        goto L11
    }
}
