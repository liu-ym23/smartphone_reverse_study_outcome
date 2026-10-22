package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.bytedance.ee.bear.bitable.pro.BitableProViewModel;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultRoleFragment;", "Lcom/bytedance/ee/bear/bitable/common/fragment/BaseActionPanelFragment;", "<init>", "()V", "roleListFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRoleListFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRoleListFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "disableStrategySelectFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getDisableStrategySelectFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setDisableStrategySelectFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "disableStrategyFromXml", "Landroid/widget/RelativeLayout;", "getDisableStrategyFromXml", "()Landroid/widget/RelativeLayout;", "setDisableStrategyFromXml", "(Landroid/widget/RelativeLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/bitable/pro/BitableProViewModel;", "defaultRoleAdapter", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultRoleAdapter;", "selectDisableStrategy", "", "roleList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lkotlin/collections/ArrayList;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onCreateContentView", "container", "Landroid/view/ViewGroup;", "initPanelStyle", "initView", "parseArguments", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultRoleFragment extends BaseActionPanelFragment {
    public static final /* synthetic */ int N = 0;
    public RecyclerView G;
    public AppCompatImageView H;
    public RelativeLayout I;
    public BitableProViewModel J;
    public BitableDefaultRoleAdapter K;
    public boolean L;
    public ArrayList<Role> M;

    public static final class a {
    }

    static {
    }

    public final RecyclerView ya0() {
        View r0 = this.G;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131384741);
    L8:
        this.G = (RecyclerView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (RecyclerView) r0;
    }

    public BitableDefaultRoleFragment() {
        this.M = new ArrayList();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.G = null;
        this.H = null;
        this.I = null;
    }

    public final View la0(CommonActionPanelLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        return LayoutInflater.from(requireContext()).inflate(2131558949, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onCreate(r2);
        this.J = (BitableProViewModel) q.a(this, BitableProViewModel.class);
        this.K = new BitableDefaultRoleAdapter(new AnonymousClass1(this));
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        boolean r4 = r3.getBoolean("select_disable_strategy");
    L6:
        this.L = r4;
        Bundle r5 = getArguments();
        if (r5 == null) goto L9;
        Serializable r6 = r5.getSerializable("role_list");
    L10:
        if (r6 == null) goto L13;
        this.M = (ArrayList) r6;
        return;
    L13:
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r5, r6);
        pa0(2131100545);
        ((BaseActionPanelFragment) this).p = 1;
        View r1 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, null, Float.valueOf(0.2f), Float.valueOf(0.9f), 1);
        va0(getString(2131886214));
        int r3 = 0;
        sa0(0, new Pair(2131254124, null), 2131102418, new BitableDefaultRoleFragment$initPanelStyle$1(this));
        ya0().setLayoutManager(new LinearLayoutManagerWrapper(getContext()));
        RecyclerView r7 = ya0();
        RecyclerView.Adapter r0 = this.K;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultRoleAdapter");
        r0 = null;
    L5:
        r7.setAdapter(r0);
        com.larksuite.component.ignition.widget.setting_group.a.b(ya0(), 0, true, 2131100548);
        RecyclerView r8 = ya0();
        if (this.M.isEmpty() == false) goto L8;
        int r9 = 8;
    L9:
        r8.setVisibility(r9);
        BitableDefaultRoleAdapter r10 = this.K;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("defaultRoleAdapter");
        r10 = null;
    L12:
        r10.setNewData(this.M);
        View r11 = this.H;
        if (r11 != null) goto L19;
        View r12 = getView();
        if (r12 == null) goto L17;
        r11 = r12.findViewById(2131369122);
    L18:
        this.H = (AppCompatImageView) r11;
        goto L19
    L17:
        r11 = null;
    L19:
        AppCompatImageView r13 = (AppCompatImageView) r11;
        if (this.L == true) goto L23;
        r3 = 8;
    L23:
        r13.setVisibility(r3);
        View r14 = this.I;
        if (r14 != null) goto L29;
        View r16 = getView();
        if (r16 == null) goto L28;
        r1 = r16.findViewById(2131369121);
    L28:
        this.I = (RelativeLayout) r1;
        r14 = r1;
    L29:
        ((RelativeLayout) r14).setOnClickListener(new e(this));
        return;
    L8:
        r9 = 0;
        goto L9
    }
}
