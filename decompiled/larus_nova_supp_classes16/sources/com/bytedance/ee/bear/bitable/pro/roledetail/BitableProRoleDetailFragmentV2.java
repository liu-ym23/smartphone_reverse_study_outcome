package com.bytedance.ee.bear.bitable.pro.roledetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.bitable.databinding.BitableProRoleDetailLayoutV2Binding;
import com.bytedance.ee.bear.bitable.lynx.pro.e;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment;
import com.bytedance.ee.bear.bitable.pro.BaseRule;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.bitable.pro.d;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.k;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larksuite.component.universe_design.tab.UDTabLayoutCoordinator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010#\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableProRoleDetailFragmentV2;", "Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "<init>", "()V", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "getRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "setRole", "(Lcom/bytedance/ee/bear/bitable/pro/Role;)V", "needPadding", "", "getNeedPadding", "()Z", "setNeedPadding", "(Z)V", "callback", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableProRoleDetailLayoutV2Binding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "update", "onDestroy", "initRoleDetailV1", "initRoleDetailV2", "wrapRoleDetailList", "Landroid/widget/LinearLayout;", "roleDetailList", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailList;", "RoleDetailPagerAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProRoleDetailFragmentV2 extends BaseBitableProFragment {
    public Role f;
    public boolean g;
    public ku4.b h;
    public BitableProRoleDetailLayoutV2Binding i;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableProRoleDetailFragmentV2$RoleDetailPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "views", "", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Ljava/util/List;Landroid/content/Context;)V", "getViews", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "", "instantiateItem", "container", "Landroid/view/ViewGroup;", "position", "", "destroyItem", "", "getCount", "getPageTitle", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoleDetailPagerAdapter extends PagerAdapter {
        public final List<LinearLayout> a;
        public final Context b;

        public final int getCount() {
            return this.a.size();
        }

        public final Context getContext() {
            return this.b;
        }

        public final CharSequence getPageTitle(int r2) {
            if (r2 != 0) goto L5;
            return this.b.getString(2131886232);
        L5:
            return this.b.getString(2131886112);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RoleDetailPagerAdapter(List<? extends LinearLayout> r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, "views");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            this.b = r3;
        }

        public final Object instantiateItem(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "container");
            LinearLayout r4 = (LinearLayout) ListProtector.get(this.a, r3);
            r2.addView(r4);
            return r4;
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "object");
            return Intrinsics.areEqual(r2, r3);
        }

        public final void destroyItem(ViewGroup r1, int r2, Object r3) {
            Intrinsics.checkNotNullParameter(r1, "container");
            Intrinsics.checkNotNullParameter(r3, "object");
            r1.removeView((View) r3);
        }
    }

    public static final class a extends t {
        public final /* synthetic */ BitableProRoleDetailFragmentV2 c;

        public a(BitableProRoleDetailFragmentV2 r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.T90(2130772293);
        }
    }

    public static final class b extends t {
        public final /* synthetic */ BitableProRoleDetailFragmentV2 c;

        public b(BitableProRoleDetailFragmentV2 r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.T90(2130772293);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BitableProRoleDetailFragmentV2 a;

        public c(BitableProRoleDetailFragmentV2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ku4.b r2 = this.a.h;
            if (r2 == null) goto L8;
            e r3 = r2.a();
            if (r3 == null) goto L9;
            r3.run();
            return;
        L9:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewGroup, com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView, com.bytedance.ee.bear.bitable.pro.roledetail.RoleDetailList] */
    public final void V90() {
        BitableProRoleDetailLayoutV2Binding r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        BaseTitleBar r1 = r0.c;
        r1.setTitle(this.f.getName());
        r1.setLeftClickListener(new a(this));
        BitableProRoleDetailLayoutV2Binding r2 = this.i;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        UDTabLayout r3 = r2.b;
        Intrinsics.checkNotNull(r3);
        m.z(r3, false);
        BitableProRoleDetailLayoutV2Binding r4 = this.i;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        ViewPager r5 = r4.d;
        ArrayList r6 = new ArrayList();
        ?? r7 = new RoleDetailList(r5.getContext(), null, 6, 0);
        r7.v(ku4.a.a(r7.getContext()));
        r7.w(ku4.a.b(this.f, r7.getContext()));
        Unit r8 = Unit.INSTANCE;
        r6.add(X90(r7));
        r5.setAdapter(new RoleDetailPagerAdapter(r6, r5.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.ViewGroup, com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView, com.bytedance.ee.bear.bitable.pro.roledetail.RoleDetailList] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.ViewGroup, com.bytedance.ee.bear.bitable.common.widgets.group.MultiItemGroupView, com.bytedance.ee.bear.bitable.pro.roledetail.RoleDetailList] */
    public final void W90() {
        BitableProRoleDetailLayoutV2Binding r1 = this.i;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        BaseTitleBar r2 = r1.c;
        r2.setTitle(this.f.getName());
        r2.setLeftClickListener(new b(this));
        BitableProRoleDetailLayoutV2Binding r3 = this.i;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        UDTabLayout r4 = r3.b;
        Intrinsics.checkNotNull(r4);
        m.z(r4, true);
        BitableProRoleDetailLayoutV2Binding r5 = this.i;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        ViewPager r6 = r5.d;
        ArrayList r7 = new ArrayList();
        ?? r8 = new RoleDetailList(r6.getContext(), null, 6, 0);
        r8.v(ku4.a.a(r8.getContext()));
        r8.w(ku4.a.b(this.f, r8.getContext()));
        Unit r9 = Unit.INSTANCE;
        r7.add(X90(r8));
        ?? r10 = new RoleDetailList(r6.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r10.getContext(), "context");
        r10.v(new ArrayList());
        Role r11 = this.f;
        Context r12 = r10.getContext();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "context");
        ArrayList r13 = new ArrayList();
        BaseRule r14 = r11.getBaseRule();
        if (r14 == null) goto L14;
        r13.add(new RoleDetailItemData(r12.getString(2131886227), r14.getCopyPermDesc(r12), "OtherPerm", false, 8, null));
        r13.add(new RoleDetailItemData(r12.getString(2131886234), r14.getExportPermDesc(r12), "OtherPerm", false, 8, null));
    L14:
        r10.w(r13);
        r7.add(X90(r10));
        r6.setAdapter(new RoleDetailPagerAdapter(r7, r6.getContext()));
        BitableProRoleDetailLayoutV2Binding r16 = this.i;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L17:
        UDTabLayout r17 = r16.b;
        Intrinsics.checkNotNull(r6);
        new UDTabLayoutCoordinator(r17, r6).attach();
    }

    public BitableProRoleDetailFragmentV2() {
        this.f = new Role(null, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16383, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        ku4.b r0 = this.h;
        if (r0 == null) goto L6;
        r0.onClose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinearLayout X90(RoleDetailList r7) {
        LinearLayout r0 = new LinearLayout(getContext());
        r0.setOrientation(1);
        ku4.b r2 = this.h;
        if (r2 == null) goto L5;
        e r3 = r2.a();
    L6:
        if (r3 == null) goto L8;
        UDNotice r4 = new UDNotice(r0.getContext());
        r4.V5(2131953855);
        r4.setIconColorful(true);
        r4.setIcon(2131256185);
        r4.setText(xo5.a.c(r4.getContext(), 2131886118, "Enable", ""));
        r4.setTextButton(r4.getContext().getString(2131886117));
        r4.setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
        r4.setTextButtonListener(new c(this));
        r0.addView(r4);
    L8:
        m.u(r7, n.d(4), false);
        r0.addView(r7);
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r6);
        int r7 = 2131388030;
        UDTabLayout r0 = ViewBindings.findChildViewById(r5, 2131388030);
        if (r0 == null) goto L18;
        r7 = 2131388775;
        BaseTitleBar r1 = ViewBindings.findChildViewById(r5, 2131388775);
        if (r1 == null) goto L18;
        r7 = 2131392567;
        ViewPager r2 = ViewBindings.findChildViewById(r5, 2131392567);
        if (r2 == null) goto L18;
        this.i = new BitableProRoleDetailLayoutV2Binding((LinearLayout) r5, r0, r1, r2);
        if (this.g == false) goto L12;
        r5.setPadding(0, k.e(getContext()), 0, 0);
    L12:
        if (this.f.getBaseRule() != null) goto L14;
        V90();
    L15:
        int r8 = d.a;
        d.b("ccm_bitable_premium_permission_rulesetting_view", new JSONObject());
        return;
    L14:
        W90();
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r7)));
    }

    public final void update(Role r2, ku4.b r3) {
        Intrinsics.checkNotNullParameter(r2, "role");
        this.f = r2;
        this.h = r3;
        if (r2.getBaseRule() != null) goto L5;
        V90();
        return;
    L5:
        W90();
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559125, r3, false);
    }
}
