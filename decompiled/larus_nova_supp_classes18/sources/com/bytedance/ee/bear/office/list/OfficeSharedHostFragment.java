package com.bytedance.ee.bear.office.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.list.share.SharedFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import dd5.f1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 62\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u00016B\u0007¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0016J\u0012\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\nH\u0016J,\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020\u0015H\u0002J\n\u00104\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u00105\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/office/list/OfficeSharedHostFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/office/list/OfficeListRefreshDelegate;", "Lcom/bytedance/ee/bear/list/homepage/IHomeFragment;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionStateListener;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionHost;", "Lcom/bytedance/ee/bear/list/list/multiselect/IListSelectionOverlayPaddingHost;", "<init>", "()V", "containerId", "", "refreshHost", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "bindRefreshLayout", "onOfficePageSelected", "onOfficeTabReselected", "", "onSelectionStateChanged", "state", "Lcom/bytedance/ee/bear/list/list/multiselect/BaseListMultiSelectState;", "refreshHeader", "onViewScrollBy", "dx", "dy", "requestEnterSelection", "document", "Lcom/bytedance/ee/bear/list/dto/Document;", "requestToggleSelection", "requestExitSelection", "isInSelectionMode", "updateSelectionOverlayBottomPadding", "bottomPaddingPx", "requestSelectPanelAction", "action", "Lcom/bytedance/ee/bear/list/list/multiselect/ListSelectPanelAction;", "documents", "", "source", "Lcom/bytedance/ee/bear/list/list/multiselect/ListSelectPanelSource;", "attachSharedFragment", "bindRefreshLayoutToChild", "currentChild", "currentSelectionHost", "Companion", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSharedHostFragment extends Fragment implements k, wc5.d, ed5.f, ed5.d, ed5.e {
    public int d;
    public View e;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        cd(null);
        this.d = -1;
        super.onDestroyView();
    }

    public OfficeSharedHostFragment() {
        this.d = -1;
    }

    @Override // wc5.d
    public final void Cu() {
        wc5.d r0 = getParentFragment();
        if ((r0 instanceof wc5.d) == false) goto L5;
        wc5.d r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.Cu();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final Fragment S90() {
        return getChildFragmentManager().findFragmentByTag("office_shared_child");
    }

    public final ed5.d T90() {
        ed5.d r0 = S90();
        if ((r0 instanceof ed5.d) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // ed5.d
    public final boolean ZT() {
        ed5.d r0 = T90();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.ZT() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final void gM() {
        Fragment r0 = S90();
        StringBuilder r1 = new StringBuilder("forward page selected, child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeSharedHost", r1.toString());
        f1.c(r0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // ed5.d
    public final void xk() {
        ed5.d r0 = T90();
        if (r0 == null) goto L6;
        r0.xk();
        return;
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final boolean xn() {
        Fragment r0 = S90();
        StringBuilder r1 = new StringBuilder("forward tab reselected, child=");
        if (r0 == null) goto L5;
        String r2 = r0.getClass().getSimpleName();
    L6:
        r1.append(r2);
        tt5.a.h("OfficeSharedHost", r1.toString());
        int r3 = f1.a;
        return f1.d(r0, this.e);
    L5:
        r2 = null;
        goto L6
    }

    @Override // ed5.d
    public final void Dt(Document r2) {
        ed5.d r0 = T90();
        if (r0 == null) goto L6;
        r0.Dt(r2);
        return;
    }

    @Override // ed5.f
    public final void It(ed5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        ed5.f r0 = getParentFragment();
        if ((r0 instanceof ed5.f) == false) goto L5;
        ed5.f r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.It(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ed5.e
    public final void c10(int r3) {
        ed5.e r0 = S90();
        if ((r0 instanceof ed5.e) == false) goto L5;
        ed5.e r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.c10(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.office.list.k
    public final void cd(View r3) {
        this.e = r3;
        StringBuilder r0 = new StringBuilder("bind refresh host, hasRefreshHost=");
        if (r3 == null) goto L5;
        boolean r4 = true;
    L6:
        r0.append(r4);
        tt5.a.h("OfficeSharedHost", r0.toString());
        int r5 = f1.a;
        f1.a(S90(), this.e);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // ed5.d
    public final void sT(Document r2) {
        ed5.d r0 = T90();
        if (r0 == null) goto L6;
        r0.sT(r2);
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        if (getChildFragmentManager().findFragmentByTag("office_shared_child") != null) goto L12;
        SharedFragment r6 = new SharedFragment();
        Bundle r1 = getArguments();
        if (r1 != null) goto L7;
        r1 = new Bundle();
    L7:
        r6.setArguments(new Bundle(r1));
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        int r2 = this.d;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "office_shared_child", r2) == true) goto L11;
        r0.replace(r2, r6, "office_shared_child");
    L11:
        r0.commitNow();
        int r7 = f1.a;
        f1.a(S90(), this.e);
        return;
    L12:
        int r8 = f1.a;
        f1.a(S90(), this.e);
    }

    @Override // wc5.d
    public final void t(int r3, int r4) {
        wc5.d r0 = getParentFragment();
        if ((r0 instanceof wc5.d) == false) goto L5;
        wc5.d r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.t(r3, r4);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r2, List<Document> r3, ed5.g r4) {
        ed5.d r0 = T90();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.KL(r2, r3, r4) != true) goto L7;
        return true;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        this.d = View.generateViewId();
        FrameLayout r4 = new FrameLayout(requireContext());
        r4.setId(this.d);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return r4;
    }
}
