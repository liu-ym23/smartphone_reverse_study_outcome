package com.bytedance.ee.bear.doc.blockeditpanel.view;

import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import ey4.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010-\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010.\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0012\u00104\u001a\u00020\u001f2\b\b\u0002\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0014\u0010<\u001a\u0004\u0018\u0001032\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020\u0014H\u0016J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010:\u001a\u0002032\u0006\u0010A\u001a\u00020\u000eH\u0002J\u0012\u0010B\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u000eH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010H\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u000103H\u0016J\u000e\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/view/BlockEditPanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/doc/blockeditpanel/listener/OnClosePanelListener;", "<init>", "()V", "rootView", "Landroid/widget/FrameLayout;", "viewModel", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dp16", "", "dp14", "dp8", "lastHeight", "lastWidth", "forceMatchParentWidth", "", "isInForseti", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initRootViewHeightListener", "initPanelMenusObserver", "addPanelHeightInfo", "panelId", "", "measuredHeight", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateWidth", "getPanelWidthCompat", "configuration", "getPanelWidth", "getPanelWidthInForseti", "isHighlightPanel", "initHighlightObserver", "getChildPanels", "", "Lcom/bytedance/ee/bear/doc/blockeditpanel/view/panel/BaseBlockEditPanel;", "shrinkBehindPanelsWidth", "ignoreTopPanel", "shrinkBehindPanelsHeight", "getPanelHeightWithOrientation", "createHeightAnimator", "Landroid/animation/ValueAnimator;", "panel", "targetHeight", "createEditPanel", "eMenuPanelId", "Lcom/bytedance/ee/bear/doc/blockeditpanel/model/EMenuPanelId;", "onBackPressed", "removePanel", "currentPanelLevel", "onPanelClosed", "editView", "resetPanelAnimator", "index", "onPanelStartClose", "editPanel", "onTriangleButtonClick", "setForceMatchParentWidth", "force", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockEditPanelFragment extends BaseFragment implements dy4.c {
    public static final /* synthetic */ int n = 0;
    public FrameLayout e;
    public final Lazy f;
    public final int g;
    public final int h;
    public final int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ BaseBlockEditPanel a;

        public b(BaseBlockEditPanel r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
            Object r1 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
            r0.height = ((Integer) r1).intValue();
            this.a.setLayoutParams(r0);
            FrameLayout r2 = (FrameLayout) this.a.findViewById(2131371428);
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            Object r5 = r4.getAnimatedValue();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
            r3.height = ((Integer) r5).intValue();
            r2.setLayoutParams(r3);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BlockEditPanelFragment a;
        public final /* synthetic */ BaseBlockEditPanel b;
        public final /* synthetic */ int c;

        public c(BlockEditPanelFragment r1, BaseBlockEditPanel r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            FrameLayout r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.removeView(this.b);
        L5:
            this.a.Z90().onCloseEditPanel(this.c);
            FrameLayout r1 = this.a.e;
            boolean r2 = false;
            if (r1 != null) goto L8;
        L10:
            if (r2 == false) goto L12;
            this.a.Z90().onDestroyEditPanel();
        L12:
            tt5.a.h("BlockEditPanelFragment", "removeView end: resetPanelAnimator");
            this.a.ba0(this.c - 1);
            return;
        L8:
            if (r1.getChildCount() != 0) goto L10;
            r2 = true;
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BaseBlockEditPanel a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ int c;
        public final /* synthetic */ BlockEditPanelFragment d;

        public d(BaseBlockEditPanel r1, Ref.IntRef r2, int r3, BlockEditPanelFragment r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.a.getMeasuredWidth();
            this.a.animate().setDuration(100).scaleX((r0 - (((this.b.element - this.c) - 1) * this.d.g)) / r0).setInterpolator(new AccelerateInterpolator()).start();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ BlockEditPanelFragment a;

        public e(BlockEditPanelFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BlockEditPanelFragment r0 = this.a;     // Catch: Throwable -> L8
            int r1 = BlockEditPanelFragment.n;     // Catch: Throwable -> L8
            if (Intrinsics.areEqual(r0.Z90().getActive().getValue(), Boolean.TRUE) == false) goto L11;
            BlockEditPanelFragment r2 = this.a;     // Catch: Throwable -> L8
            if (r2.j <= 0) goto L15;
            r2.Z90().onPanelHeightChanged(this.a.j);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    @Override // dy4.c
    public final void ag() {
        ca0(true);
    }

    public final List<BaseBlockEditPanel> V90() {
        ArrayList r0 = new ArrayList();
        FrameLayout r1 = this.e;
        if (r1 != null) goto L5;
        return r0;
    L5:
        if (r1 == null) goto L11;
        int r2 = r1.getChildCount();
        if (r2 == 0) goto L11;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L11;
        View r4 = r1.getChildAt(r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        r0.add((BaseBlockEditPanel) r4);
        r3 = r3 + 1;
    L11:
        return r0;
    }

    public final BlockEditPanelViewModel Z90() {
        return (BlockEditPanelViewModel) this.f.getValue();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L8;
        int r2 = r0.getChildCount() - 1;
        if (r2 <= 0) goto L7;
        Z90().onClickBack(r2);
        View r1 = r0.getChildAt(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        aa0((BaseBlockEditPanel) r1, r2);
        goto L8
    L7:
        Z90().onCloseEditPanel(0);
        Z90().onDestroyEditPanel();
    L8:
        return true;
    }

    @Override // dy4.c
    public final void sg() {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L9;
        int r1 = r0.getChildCount() - 1;
        if (r1 <= 0) goto L7;
        Z90().onClickTriangleButton(r1);
        View r2 = r0.getChildAt(r1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        aa0((BaseBlockEditPanel) r2, r1);
        return;
    L7:
        Z90().onCloseEditPanel(0);
        Z90().onDestroyEditPanel();
        return;
    }

    public BlockEditPanelFragment() {
        this.f = LazyKt.lazy(new BlockEditPanelFragment$viewModel$2(this));
        this.g = n.d(16);
        this.h = n.d(14);
        this.i = n.d(8);
    }

    @Override // dy4.c
    public final void LH(BaseBlockEditPanel r4) {
        tt5.a.h("BlockEditPanelFragment", "onClose BlockEditPanelView.");
        int r0 = CollectionsKt.indexOf(V90(), r4);
        if (r0 == (-1)) goto L10;
        if (r0 <= 0) goto L6;
        Z90().onPullingDown(r0);
    L6:
        FrameLayout r1 = this.e;
        if (r1 == null) goto L9;
        r1.removeView(r4);
    L9:
        Z90().onCloseEditPanel(r0);
    L10:
        FrameLayout r5 = this.e;
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L18;
        Z90().onDestroyEditPanel();
        return;
    L18:
        ca0(false);
        ba0(r0 - 1);
        return;
    L13:
        if (r5.getChildCount() != 0) goto L15;
        r6 = true;
        goto L16
    }

    public final int W90(String r7) {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L9;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L9;
        Configuration r2 = r1.getConfiguration();
        if (r2 == null) goto L9;
        int r3 = r2.orientation;
    L10:
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation size: " + Z90().getPanelHeightInfoList().size());
        Iterator<g> r4 = Z90().getPanelHeightInfoList().iterator();
    L12:
        if (r4.hasNext() == false) goto L21;
        g r5 = r4.next();
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation id:" + r7 + ", info: " + r5 + "; orientation: " + r3);
        if (Intrinsics.areEqual(r5.a, r7) == false) goto L12;
        if (r5.c != r3) goto L12;
        if (r5.d != Z90().getEditStatus()) goto L12;
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation return id: " + r5 + "; ");
        return r5.b;
    L21:
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation not found! return 0");
        return 0;
    L9:
        r3 = 1;
        goto L10
    }

    public final int X90(Configuration r3) {
        if (r3 != null) goto L5;
        return -1;
    L5:
        if (r3.orientation != 1) goto L7;
        return -1;
    L7:
        if (this.l == false) goto L10;
        return -1;
    L10:
        return (int) (n.q(getActivity()) * 0.7f);
    }

    public final int Y90(Configuration r3) {
        if (this.m == false) goto L12;
        View r0 = getView();
        if (r0 == null) goto L7;
        int r1 = r0.getWidth();
    L8:
        if (r1 > 0) goto L14;
        tt5.a.k("BlockEditPanelFragment", "getPanelWidthInForseti, fragmentWidth is 0!");
        return X90(r3);
    L14:
        return Math.min(r1, n.d(480));
    L7:
        r1 = 0;
        goto L8
    L12:
        return X90(r3);
    }

    public final void ba0(int r11) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        List<BaseBlockEditPanel> r0 = V90();
        if (r11 < ((ArrayList) r0).size()) goto L7;
        return;
    L7:
        BaseBlockEditPanel r1 = (BaseBlockEditPanel) ListProtector.get(r0, r11);
        r1.a(true);
        int r2 = W90(r1.getPanelId());
        tt5.a.h("BlockEditPanelFragment", "resetPanelAnimator id : " + r1.getPanelId() + "; height: " + r2 + "; index: " + r11);
        if (r2 != 0) goto L37;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L16;
        Resources r13 = r12.getResources();
        if (r13 == null) goto L16;
        Configuration r14 = r13.getConfiguration();
        if (r14 == null) goto L16;
        int r16 = r14.orientation;
    L17:
        BlockEditPanelMenusModel r4 = (BlockEditPanelMenusModel) Z90().getMenuItems().getValue();
        BlockEditPanelMenusModel.BlockEditPanel r5 = null;
        Object r6 = null;
        r5 = null;
        if (r4 == null) goto L28;
        List<BlockEditPanelMenusModel.BlockEditPanel> r7 = r4.getPanels();
        if (r7 == null) goto L28;
        Iterator<T> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        Object r9 = r8.next();
        if (TextUtils.equals(((BlockEditPanelMenusModel.BlockEditPanel) r9).getPanelId(), r1.getPanelId()) == false) goto L23;
        r6 = r9;
    L27:
        r5 = (BlockEditPanelMenusModel.BlockEditPanel) r6;
    L28:
        if (r5 == null) goto L32;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r10 = r5.getMenus();
        if (r10 == null) goto L32;
        int r17 = r10.size();
    L33:
        FrameLayout r18 = (FrameLayout) r1.findViewById(2131371429);
        int r19 = r1.getHeight();
        int r20 = r18.getHeight();
        tt5.a.h("BlockEditPanelFragment", "resetPanelAnimator menus: " + r17 + "; panelHeight: " + r19 + "; panelHandlerHeight: " + r20 + ';');
        int r21 = (int) Math.ceil(((double) r17) / ((double) 4));
        if (r16 != 1) goto L37;
        if (r17 <= 4) goto L37;
        r2 = ((r1.getPanelHeight() + this.h) + (this.i * r21)) + r20;
    L32:
        r17 = 0;
    L16:
        r16 = 1;
    L37:
        U90(r1, r2).start();
        r1.setNeedResetPanelLayoutParams(true);
    }

    public final void ca0(boolean r6) {
        tt5.a.d("BlockEditPanelFragment", "shrinkBehindPanels");
        List<BaseBlockEditPanel> r0 = V90();
        Ref.IntRef r1 = new Ref.IntRef();
        int r2 = ((ArrayList) r0).size();
        r1.element = r2;
        if (r6 == false) goto L6;
        r1.element = r2 - 1;
    L6:
        if (r1.element >= 1) goto L8;
        return;
    L8:
        Iterator<T> r7 = r0.iterator();
        int r3 = 0;
    L10:
        if (r7.hasNext() == false) goto L18;
        Object r4 = r7.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        BaseBlockEditPanel r8 = (BaseBlockEditPanel) r4;
        if (r3 == r1.element) goto L17;
        r8.post(new d(r8, r1, r3, this));
    L17:
        r3 = r5;
        goto L10
    }

    public final void da0(Configuration r5) {
        FrameLayout r0 = this.e;
        if (r0 == null) goto L12;
        Sequence r1 = ViewGroupKt.getChildren(r0);
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        View r3 = (View) r2.next();
        if ((r3 instanceof BaseBlockEditPanel) == false) goto L8;
        BaseBlockEditPanel r4 = (BaseBlockEditPanel) r3;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        r6.width = Y90(r5);
        r4.setLayoutParams(r6);
    L12:
        j.c(new e(this));
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        da0(r2);
    }

    public static ValueAnimator U90(BaseBlockEditPanel r3, int r4) {
        tt5.a.h("BlockEditPanelFragment", "createHeightAnimator panel.height: " + r3.getHeight() + " to " + r4 + ';');
        ValueAnimator r5 = ValueAnimator.ofInt(new int[]{r3.getHeight(), r4});
        r5.addUpdateListener(new b(r3));
        r5.setDuration(100);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final void aa0(BaseBlockEditPanel r4, int r5) {
        ca0(true);
        r4.animate().translationY(r4.getHeight() / 4).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(200).withEndAction(new c(this, r4, r5)).start();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.e = (FrameLayout) r2;
        Z90().getHighlight().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.doc.blockeditpanel.view.b(this));
        Z90().getMenuItems().observe(getViewLifecycleOwner(), new BlockEditPanelFragment$initPanelMenusObserver$1(this));
        FrameLayout r4 = this.e;
        if (r4 == null) goto L5;
        r4.addOnLayoutChangeListener(new com.bytedance.ee.bear.doc.blockeditpanel.view.d(this));
    L5:
        this.m = ForsetiHelper.s(this);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560066, r3, false);
    }
}
