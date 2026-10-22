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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010#\u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableProRoleDetailFragmentV2;", "Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "<init>", "()V", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "getRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "setRole", "(Lcom/bytedance/ee/bear/bitable/pro/Role;)V", "needPadding", "", "getNeedPadding", "()Z", "setNeedPadding", "(Z)V", "callback", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;", "getCallback", "()Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;", "setCallback", "(Lcom/bytedance/ee/bear/bitable/pro/roledetail/IRoleDetailCallback;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableProRoleDetailLayoutV2Binding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "update", LiveCommonConstants.REASON_ON_DEDTROY, "initRoleDetailV1", "initRoleDetailV2", "wrapRoleDetailList", "Landroid/widget/LinearLayout;", "roleDetailList", "Lcom/bytedance/ee/bear/bitable/pro/roledetail/RoleDetailList;", "RoleDetailPagerAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProRoleDetailFragmentV2 extends BaseBitableProFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Role f215234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f215235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ku4.b f215236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BitableProRoleDetailLayoutV2Binding f215237i;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableProRoleDetailFragmentV2$RoleDetailPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "views", "", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Ljava/util/List;Landroid/content/Context;)V", "getViews", "()Ljava/util/List;", "getContext", "()Landroid/content/Context;", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "position", "", "destroyItem", "", "getCount", "getPageTitle", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoleDetailPagerAdapter extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<LinearLayout> f215238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f215239b;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f215238a.size();
        }

        public final Context getContext() {
            return this.f215239b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int r100) {
            if (r100 != 0) goto L5;
            return this.f215239b.getString(R.string.Bitable_AdvancedPermissions_DataPerm_Tab);
        L5:
            return this.f215239b.getString(R.string.Bitable_AdvancedPermUpgrade_Others_OtherFunctionsAccess_Tab);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public RoleDetailPagerAdapter(List<? extends LinearLayout> r100, Context r101) {
            Intrinsics.checkNotNullParameter(r100, "views");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f215238a = r100;
            this.f215239b = r101;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            LinearLayout r102 = (LinearLayout) ListProtector.get(this.f215238a, r101);
            r100.addView(r102);
            return r102;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "object");
            return Intrinsics.areEqual(r100, r101);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "object");
            r100.removeView((View) r102);
        }
    }

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableProRoleDetailFragmentV2 f215240c;

        public a(BitableProRoleDetailFragmentV2 r100) {
            this.f215240c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f215240c.T90(R.anim.facade_slide_right_out);
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableProRoleDetailFragmentV2 f215241c;

        public b(BitableProRoleDetailFragmentV2 r100) {
            this.f215241c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            this.f215241c.T90(R.anim.facade_slide_right_out);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableProRoleDetailFragmentV2 f215242a;

        public c(BitableProRoleDetailFragmentV2 r100) {
            this.f215242a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ku4.b r101 = this.f215242a.f215236h;
            if (r101 == null) goto L8;
            e r102 = r101.a();
            if (r102 == null) goto L9;
            r102.run();
            return;
        L9:
            return;
        }
    }

    public final void V90() {
        BitableProRoleDetailLayoutV2Binding r100 = this.f215237i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        BaseTitleBar r101 = r100.f211020c;
        r101.setTitle(this.f215234f.getName());
        r101.setLeftClickListener(new a(this));
        BitableProRoleDetailLayoutV2Binding r102 = this.f215237i;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L8:
        UDTabLayout r103 = r102.f211019b;
        Intrinsics.checkNotNull(r103);
        m.z(r103, false);
        BitableProRoleDetailLayoutV2Binding r104 = this.f215237i;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        ViewPager r105 = r104.f211021d;
        ArrayList r106 = new ArrayList();
        RoleDetailList r107 = new RoleDetailList(r105.getContext(), null, 6, 0);
        r107.v(ku4.a.a(r107.getContext()));
        r107.w(ku4.a.b(this.f215234f, r107.getContext()));
        Unit r108 = Unit.INSTANCE;
        r106.add(X90(r107));
        r105.setAdapter(new RoleDetailPagerAdapter(r106, r105.getContext()));
    }

    public final void W90() {
        BitableProRoleDetailLayoutV2Binding r100 = this.f215237i;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        BaseTitleBar r101 = r100.f211020c;
        r101.setTitle(this.f215234f.getName());
        r101.setLeftClickListener(new b(this));
        BitableProRoleDetailLayoutV2Binding r102 = this.f215237i;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L8:
        UDTabLayout r103 = r102.f211019b;
        Intrinsics.checkNotNull(r103);
        m.z(r103, true);
        BitableProRoleDetailLayoutV2Binding r104 = this.f215237i;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L11:
        ViewPager r105 = r104.f211021d;
        ArrayList r106 = new ArrayList();
        RoleDetailList r107 = new RoleDetailList(r105.getContext(), null, 6, 0);
        r107.v(ku4.a.a(r107.getContext()));
        r107.w(ku4.a.b(this.f215234f, r107.getContext()));
        Unit r108 = Unit.INSTANCE;
        r106.add(X90(r107));
        RoleDetailList r109 = new RoleDetailList(r105.getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r109.getContext(), PerfLog.PARAM_KEY_CONTEXT_ID);
        r109.v(new ArrayList());
        Role r110 = this.f215234f;
        Context r111 = r109.getContext();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r112 = new ArrayList();
        BaseRule r113 = r110.getBaseRule();
        if (r113 == null) goto L14;
        r112.add(new RoleDetailItemData(r111.getString(R.string.Bitable_AdvancedPermissions_Copy_Title_Mob), r113.getCopyPermDesc(r111), "OtherPerm", false, 8, null));
        r112.add(new RoleDetailItemData(r111.getString(R.string.Bitable_AdvancedPermissions_Export_Title_Mob), r113.getExportPermDesc(r111), "OtherPerm", false, 8, null));
    L14:
        r109.w(r112);
        r106.add(X90(r109));
        r105.setAdapter(new RoleDetailPagerAdapter(r106, r105.getContext()));
        BitableProRoleDetailLayoutV2Binding r114 = this.f215237i;
        if (r114 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L17:
        UDTabLayout r115 = r114.f211019b;
        Intrinsics.checkNotNull(r105);
        new UDTabLayoutCoordinator(r115, r105).attach();
    }

    public BitableProRoleDetailFragmentV2() {
        this.f215234f = new Role(null, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16383, null);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ku4.b r100 = this.f215236h;
        if (r100 == null) goto L6;
        r100.onClose();
        return;
    }

    public final LinearLayout X90(RoleDetailList r100) {
        LinearLayout r101 = new LinearLayout(getContext());
        r101.setOrientation(1);
        ku4.b r102 = this.f215236h;
        if (r102 == null) goto L5;
        e r103 = r102.a();
    L6:
        if (r103 == null) goto L8;
        UDNotice r104 = new UDNotice(r101.getContext());
        r104.V5(R.style.UDNotice_Warning);
        r104.setIconColorful(true);
        r104.setIcon(R.drawable.ud_icon_warning_colorful);
        r104.setText(xo5.a.c(r104.getContext(), R.string.Bitable_AdvancedPerm_SystemRole_NoAccessPermForThisRole_Desc_Mob, "Enable", ""));
        r104.setTextButton(r104.getContext().getString(R.string.Bitable_AdvancedPerm_SystemRole_EnableNow_Button_Mob));
        r104.setTextButtonPosition(UDNotice.TextButtonPosition.AUTO);
        r104.setTextButtonListener(new c(this));
        r101.addView(r104);
    L8:
        m.u(r100, n.d(4), false);
        r101.addView(r100);
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        int r102 = R.id.tab_layout;
        UDTabLayout r103 = (UDTabLayout) ViewBindings.findChildViewById(r100, R.id.tab_layout);
        if (r103 == null) goto L18;
        r102 = R.id.titleBar;
        BaseTitleBar r104 = (BaseTitleBar) ViewBindings.findChildViewById(r100, R.id.titleBar);
        if (r104 == null) goto L18;
        r102 = R.id.view_pager;
        ViewPager r105 = (ViewPager) ViewBindings.findChildViewById(r100, R.id.view_pager);
        if (r105 == null) goto L18;
        this.f215237i = new BitableProRoleDetailLayoutV2Binding((LinearLayout) r100, r103, r104, r105);
        if (this.f215235g == false) goto L12;
        r100.setPadding(0, k.e(getContext()), 0, 0);
    L12:
        if (this.f215234f.getBaseRule() != null) goto L14;
        V90();
    L15:
        int r106 = d.f215166a;
        d.b("ccm_bitable_premium_permission_rulesetting_view", new JSONObject());
        return;
    L14:
        W90();
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r102)));
    }

    public final void update(Role r100, ku4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "role");
        this.f215234f = r100;
        this.f215236h = r101;
        if (r100.getBaseRule() != null) goto L5;
        V90();
        return;
    L5:
        W90();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_pro_role_detail_layout_v2, r101, false);
    }
}
