package com.bytedance.ee.bear.bitable.pro.roledetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.bitable.pro.d;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.framework.utils.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0016J\u0012\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001a\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/roledetail/BitableProRoleDetailFragment;", "Lcom/bytedance/ee/bear/bitable/pro/BaseBitableProFragment;", "<init>", "()V", "defaultRoleLayoutFromXml", "Landroid/widget/LinearLayout;", "getDefaultRoleLayoutFromXml", "()Landroid/widget/LinearLayout;", "setDefaultRoleLayoutFromXml", "(Landroid/widget/LinearLayout;)V", "defaultRoleTitleFromXml", "Landroid/widget/TextView;", "getDefaultRoleTitleFromXml", "()Landroid/widget/TextView;", "setDefaultRoleTitleFromXml", "(Landroid/widget/TextView;)V", "defaultRoleDescFromXml", "getDefaultRoleDescFromXml", "setDefaultRoleDescFromXml", "roleNameTvFromXml", "getRoleNameTvFromXml", "setRoleNameTvFromXml", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "tableRoleRecyclerFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getTableRoleRecyclerFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setTableRoleRecyclerFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "clearFromXmlViewCache", "", "onDestroyView", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onBackPressed", "", "getStatusBarColorRes", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProRoleDetailFragment extends BaseBitableProFragment {
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public TextView i;
    public BaseTitleBar j;
    public RecyclerView k;
    public Role l;

    public static final class a extends t {
        public final /* synthetic */ BitableProRoleDetailFragment c;

        public a(BitableProRoleDetailFragment r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            this.c.T90(2130772293);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final int U90() {
        return 2131100545;
    }

    public final RecyclerView V90() {
        View r0 = this.k;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131388075);
    L8:
        this.k = (RecyclerView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RecyclerView) r0;
    }

    public BitableProRoleDetailFragment() {
        this.l = new Role(null, null, null, null, null, null, null, null, null, 0, false, 0, false, null, 16383, null);
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        super.onBackPressed();
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        Object r4 = r3.getSerializable("extra_role");
    L6:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.Role");
        this.l = (Role) r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.pro.BaseBitableProFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        View r5 = this.f;
        View r6 = null;
        if (r5 != null) goto L9;
        View r7 = getView();
        if (r7 == null) goto L7;
        r5 = r7.findViewById(2131368740);
    L8:
        this.f = (LinearLayout) r5;
        goto L9
    L7:
        r5 = null;
    L9:
        LinearLayout r8 = (LinearLayout) r5;
        if (this.l.isDefault() == false) goto L12;
        int r0 = 0;
    L13:
        r8.setVisibility(r0);
        if (this.l.isDefaultTypeEdit() == false) goto L31;
        View r9 = this.g;
        if (r9 != null) goto L22;
        View r10 = getView();
        if (r10 == null) goto L20;
        r9 = r10.findViewById(2131368741);
    L21:
        this.g = (TextView) r9;
        goto L22
    L20:
        r9 = null;
    L22:
        ((TextView) r9).setText(2131886141);
        View r11 = this.h;
        if (r11 != null) goto L29;
        View r12 = getView();
        if (r12 == null) goto L27;
        r11 = r12.findViewById(2131368739);
    L28:
        this.h = (TextView) r11;
        goto L29
    L27:
        r11 = null;
    L29:
        ((TextView) r11).setText(2131886140);
    L47:
        View r13 = this.i;
        if (r13 != null) goto L54;
        View r14 = getView();
        if (r14 == null) goto L52;
        r13 = r14.findViewById(2131384736);
    L53:
        this.i = (TextView) r13;
        goto L54
    L52:
        r13 = null;
    L54:
        ((TextView) r13).setText(this.l.getName());
        View r16 = this.j;
        if (r16 != null) goto L60;
        View r17 = getView();
        if (r17 == null) goto L59;
        r6 = r17.findViewById(2131388775);
    L59:
        this.j = (BaseTitleBar) r6;
        r16 = r6;
    L60:
        ((BaseTitleBar) r16).setLeftClickListener(new a(this));
        V90().setAdapter(new BitableRoleTablePermAdapter(this.l.getTableRoleList()));
        V90().setLayoutManager(new LinearLayoutManagerWrapper(requireContext()));
        RecyclerView r18 = V90();
        int r19 = com.larksuite.component.ignition.widget.setting_group.a.a;
        Intrinsics.checkNotNullParameter(r18, "recyclerView");
        Intrinsics.checkNotNullParameter(r18, "recyclerView");
        com.larksuite.component.ignition.widget.setting_group.a.b(r18, UIUtils.dp2px(r18.getContext(), 16.0f), true, 2131100568);
        int r20 = d.a;
        d.b("ccm_bitable_premium_permission_rulesetting_view", new JSONObject());
        return;
    L31:
        if (this.l.isDefaultTypeRead() == false) goto L47;
        View r21 = this.g;
        if (r21 != null) goto L39;
        View r22 = getView();
        if (r22 == null) goto L37;
        r21 = r22.findViewById(2131368741);
    L38:
        this.g = (TextView) r21;
        goto L39
    L37:
        r21 = null;
    L39:
        ((TextView) r21).setText(2131886145);
        View r23 = this.h;
        if (r23 != null) goto L46;
        View r24 = getView();
        if (r24 == null) goto L44;
        r23 = r24.findViewById(2131368739);
    L45:
        this.h = (TextView) r23;
        goto L46
    L44:
        r23 = null;
    L46:
        ((TextView) r23).setText(2131886144);
        goto L47
    L12:
        r0 = 8;
        goto L13
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131559124, r3, false);
    }
}
