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
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.doc.blockeditpanel.BlockEditPanelViewModel;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010-\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010.\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\b\u00100\u001a\u00020\u001fH\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0012\u00104\u001a\u00020\u001f2\b\b\u0002\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0014\u0010<\u001a\u0004\u0018\u0001032\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020\u0014H\u0016J\u0018\u0010@\u001a\u00020\u001f2\u0006\u0010:\u001a\u0002032\u0006\u0010A\u001a\u00020\u000eH\u0002J\u0012\u0010B\u001a\u00020\u001f2\b\u0010C\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020\u000eH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010H\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u000103H\u0016J\u000e\u0010I\u001a\u00020\u001f2\u0006\u0010J\u001a\u00020\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/doc/blockeditpanel/view/BlockEditPanelFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/doc/blockeditpanel/listener/OnClosePanelListener;", "<init>", "()V", "rootView", "Landroid/widget/FrameLayout;", "viewModel", "Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/doc/blockeditpanel/BlockEditPanelViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dp16", "", "dp14", "dp8", "lastHeight", "lastWidth", "forceMatchParentWidth", "", "isInForseti", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initRootViewHeightListener", "initPanelMenusObserver", "addPanelHeightInfo", "panelId", "", "measuredHeight", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "updateWidth", "getPanelWidthCompat", "configuration", "getPanelWidth", "getPanelWidthInForseti", "isHighlightPanel", "initHighlightObserver", "getChildPanels", "", "Lcom/bytedance/ee/bear/doc/blockeditpanel/view/panel/BaseBlockEditPanel;", "shrinkBehindPanelsWidth", "ignoreTopPanel", "shrinkBehindPanelsHeight", "getPanelHeightWithOrientation", "createHeightAnimator", "Landroid/animation/ValueAnimator;", "panel", "targetHeight", "createEditPanel", "eMenuPanelId", "Lcom/bytedance/ee/bear/doc/blockeditpanel/model/EMenuPanelId;", "onBackPressed", "removePanel", "currentPanelLevel", "onPanelClosed", "editView", "resetPanelAnimator", "index", "onPanelStartClose", "editPanel", "onTriangleButtonClick", "setForceMatchParentWidth", "force", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockEditPanelFragment extends BaseFragment implements dy4.c {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f217632n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f217633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f217634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f217635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f217636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f217637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f217638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f217639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f217640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f217641m;

    public static final class a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBlockEditPanel f217642a;

        public b(BaseBlockEditPanel r100) {
            this.f217642a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ViewGroup.LayoutParams r101 = this.f217642a.getLayoutParams();
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.height = ((Integer) r102).intValue();
            this.f217642a.setLayoutParams(r101);
            FrameLayout r103 = (FrameLayout) this.f217642a.findViewById(R.id.edit_panel_container);
            ViewGroup.LayoutParams r104 = r103.getLayoutParams();
            Object r105 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
            r104.height = ((Integer) r105).intValue();
            r103.setLayoutParams(r104);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockEditPanelFragment f217643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseBlockEditPanel f217644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f217645c;

        public c(BlockEditPanelFragment r100, BaseBlockEditPanel r101, int r102) {
            this.f217643a = r100;
            this.f217644b = r101;
            this.f217645c = r102;
        }

        public final void a() {
            FrameLayout r100 = this.f217643a.f217633e;
            if (r100 == null) goto L5;
            r100.removeView(this.f217644b);
        L5:
            this.f217643a.Z90().onCloseEditPanel(this.f217645c);
            FrameLayout r101 = this.f217643a.f217633e;
            boolean r102 = false;
            if (r101 != null) goto L8;
        L10:
            if (r102 == false) goto L12;
            this.f217643a.Z90().onDestroyEditPanel();
        L12:
            tt5.a.h("BlockEditPanelFragment", "removeView end: resetPanelAnimator");
            this.f217643a.ba0(this.f217645c - 1);
            return;
        L8:
            if (r101.getChildCount() != 0) goto L10;
            r102 = true;
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBlockEditPanel f217646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f217647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f217648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BlockEditPanelFragment f217649d;

        public d(BaseBlockEditPanel r100, Ref.IntRef r101, int r102, BlockEditPanelFragment r103) {
            this.f217646a = r100;
            this.f217647b = r101;
            this.f217648c = r102;
            this.f217649d = r103;
        }

        public final void a() {
            int r100 = this.f217646a.getMeasuredWidth();
            this.f217646a.animate().setDuration(100).scaleX((r100 - (((this.f217647b.element - this.f217648c) - 1) * this.f217649d.f217635g)) / r100).setInterpolator(new AccelerateInterpolator()).start();
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockEditPanelFragment f217650a;

        public e(BlockEditPanelFragment r100) {
            this.f217650a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BlockEditPanelFragment r100 = this.f217650a;     // Catch: Throwable -> L8
            int r101 = BlockEditPanelFragment.f217632n;     // Catch: Throwable -> L8
            if (Intrinsics.areEqual(r100.Z90().getActive().getValue(), Boolean.TRUE) == false) goto L11;
            BlockEditPanelFragment r102 = this.f217650a;     // Catch: Throwable -> L8
            if (r102.f217638j <= 0) goto L15;
            r102.Z90().onPanelHeightChanged(this.f217650a.f217638j);     // Catch: Throwable -> L8
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
        ArrayList r100 = new ArrayList();
        FrameLayout r101 = this.f217633e;
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101 == null) goto L11;
        int r102 = r101.getChildCount();
        if (r102 == 0) goto L11;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        View r104 = r101.getChildAt(r103);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        r100.add((BaseBlockEditPanel) r104);
        r103 = r103 + 1;
    L11:
        return r100;
    }

    public final BlockEditPanelViewModel Z90() {
        return (BlockEditPanelViewModel) this.f217634f.getValue();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        FrameLayout r100 = this.f217633e;
        if (r100 == null) goto L8;
        int r101 = r100.getChildCount() - 1;
        if (r101 <= 0) goto L7;
        Z90().onClickBack(r101);
        View r102 = r100.getChildAt(r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        aa0((BaseBlockEditPanel) r102, r101);
        goto L8
    L7:
        Z90().onCloseEditPanel(0);
        Z90().onDestroyEditPanel();
    L8:
        return true;
    }

    @Override // dy4.c
    public final void sg() {
        FrameLayout r100 = this.f217633e;
        if (r100 == null) goto L9;
        int r101 = r100.getChildCount() - 1;
        if (r101 <= 0) goto L7;
        Z90().onClickTriangleButton(r101);
        View r102 = r100.getChildAt(r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel");
        aa0((BaseBlockEditPanel) r102, r101);
        return;
    L7:
        Z90().onCloseEditPanel(0);
        Z90().onDestroyEditPanel();
        return;
    }

    public BlockEditPanelFragment() {
        this.f217634f = LazyKt.lazy(new BlockEditPanelFragment$viewModel$2(this));
        this.f217635g = n.d(16);
        this.f217636h = n.d(14);
        this.f217637i = n.d(8);
    }

    @Override // dy4.c
    public final void LH(BaseBlockEditPanel r100) {
        tt5.a.h("BlockEditPanelFragment", "onClose BlockEditPanelView.");
        int r101 = CollectionsKt.indexOf(V90(), r100);
        if (r101 == (-1)) goto L10;
        if (r101 <= 0) goto L6;
        Z90().onPullingDown(r101);
    L6:
        FrameLayout r102 = this.f217633e;
        if (r102 == null) goto L9;
        r102.removeView(r100);
    L9:
        Z90().onCloseEditPanel(r101);
    L10:
        FrameLayout r103 = this.f217633e;
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        Z90().onDestroyEditPanel();
        return;
    L18:
        ca0(false);
        ba0(r101 - 1);
        return;
    L13:
        if (r103.getChildCount() != 0) goto L15;
        r104 = true;
        goto L16
    }

    public final int W90(String r100) {
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L9;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L9;
        Configuration r103 = r102.getConfiguration();
        if (r103 == null) goto L9;
        int r104 = r103.orientation;
    L10:
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation size: " + Z90().getPanelHeightInfoList().size());
        Iterator<g> r105 = Z90().getPanelHeightInfoList().iterator();
    L12:
        if (r105.hasNext() == false) goto L21;
        g r106 = r105.next();
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation id:" + r100 + ", info: " + r106 + "; orientation: " + r104);
        if (Intrinsics.areEqual(r106.f474803a, r100) == false) goto L12;
        if (r106.f474805c != r104) goto L12;
        if (r106.f474806d != Z90().getEditStatus()) goto L12;
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation return id: " + r106 + "; ");
        return r106.f474804b;
    L21:
        tt5.a.b("BlockEditPanelFragment", "getPanelHeightWithOrientation not found! return 0");
        return 0;
    L9:
        r104 = 1;
        goto L10
    }

    public final int X90(Configuration r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        if (r100.orientation != 1) goto L7;
        return -1;
    L7:
        if (this.f217640l == false) goto L10;
        return -1;
    L10:
        return (int) (n.q(getActivity()) * 0.7f);
    }

    public final int Y90(Configuration r100) {
        if (this.f217641m == false) goto L12;
        View r101 = getView();
        if (r101 == null) goto L7;
        int r102 = r101.getWidth();
    L8:
        if (r102 > 0) goto L14;
        tt5.a.k("BlockEditPanelFragment", "getPanelWidthInForseti, fragmentWidth is 0!");
        return X90(r100);
    L14:
        return Math.min(r102, n.d(480));
    L7:
        r102 = 0;
        goto L8
    L12:
        return X90(r100);
    }

    public final void ba0(int r110) {
        if (r110 >= 0) goto L4;
        return;
    L4:
        List<BaseBlockEditPanel> r100 = V90();
        if (r110 < ((ArrayList) r100).size()) goto L7;
        return;
    L7:
        BaseBlockEditPanel r101 = (BaseBlockEditPanel) ListProtector.get(r100, r110);
        r101.a(true);
        int r102 = W90(r101.getPanelId());
        tt5.a.h("BlockEditPanelFragment", "resetPanelAnimator id : " + r101.getPanelId() + "; height: " + r102 + "; index: " + r110);
        if (r102 != 0) goto L37;
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L16;
        Resources r112 = r111.getResources();
        if (r112 == null) goto L16;
        Configuration r113 = r112.getConfiguration();
        if (r113 == null) goto L16;
        int r114 = r113.orientation;
    L17:
        BlockEditPanelMenusModel r103 = Z90().getMenuItems().getValue();
        BlockEditPanelMenusModel.BlockEditPanel r104 = null;
        Object r105 = null;
        r104 = null;
        if (r103 == null) goto L28;
        List<BlockEditPanelMenusModel.BlockEditPanel> r106 = r103.getPanels();
        if (r106 == null) goto L28;
        Iterator<T> r107 = r106.iterator();
    L23:
        if (r107.hasNext() == false) goto L27;
        Object r108 = r107.next();
        if (TextUtils.equals(((BlockEditPanelMenusModel.BlockEditPanel) r108).getPanelId(), r101.getPanelId()) == false) goto L23;
        r105 = r108;
    L27:
        r104 = (BlockEditPanelMenusModel.BlockEditPanel) r105;
    L28:
        if (r104 == null) goto L32;
        List<BlockEditPanelMenusModel.BlockEditPanelMenuItem> r109 = r104.getMenus();
        if (r109 == null) goto L32;
        int r115 = r109.size();
    L33:
        FrameLayout r116 = (FrameLayout) r101.findViewById(R.id.edit_panel_handler_view);
        int r117 = r101.getHeight();
        int r118 = r116.getHeight();
        tt5.a.h("BlockEditPanelFragment", "resetPanelAnimator menus: " + r115 + "; panelHeight: " + r117 + "; panelHandlerHeight: " + r118 + ';');
        int r119 = (int) Math.ceil(((double) r115) / ((double) 4));
        if (r114 != 1) goto L37;
        if (r115 <= 4) goto L37;
        r102 = ((r101.getPanelHeight() + this.f217636h) + (this.f217637i * r119)) + r118;
    L32:
        r115 = 0;
    L16:
        r114 = 1;
    L37:
        U90(r101, r102).start();
        r101.setNeedResetPanelLayoutParams(true);
    }

    public final void ca0(boolean r100) {
        tt5.a.d("BlockEditPanelFragment", "shrinkBehindPanels");
        List<BaseBlockEditPanel> r101 = V90();
        Ref.IntRef r102 = new Ref.IntRef();
        int r103 = ((ArrayList) r101).size();
        r102.element = r103;
        if (r100 == false) goto L6;
        r102.element = r103 - 1;
    L6:
        if (r102.element >= 1) goto L8;
        return;
    L8:
        Iterator<T> r104 = r101.iterator();
        int r105 = 0;
    L10:
        if (r104.hasNext() == false) goto L18;
        Object r106 = r104.next();
        int r107 = r105 + 1;
        if (r105 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        BaseBlockEditPanel r108 = (BaseBlockEditPanel) r106;
        if (r105 == r102.element) goto L17;
        r108.post(new d(r108, r102, r105, this));
    L17:
        r105 = r107;
        goto L10
    }

    public final void da0(Configuration r100) {
        FrameLayout r101 = this.f217633e;
        if (r101 == null) goto L12;
        Sequence<View> r102 = ViewGroupKt.getChildren(r101);
        if (r102 == null) goto L12;
        Iterator<View> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        View r104 = r103.next();
        if ((r104 instanceof BaseBlockEditPanel) == false) goto L8;
        BaseBlockEditPanel r105 = (BaseBlockEditPanel) r104;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = Y90(r100);
        r105.setLayoutParams(r106);
    L12:
        j.c(new e(this));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        da0(r100);
    }

    public static ValueAnimator U90(BaseBlockEditPanel r100, int r101) {
        tt5.a.h("BlockEditPanelFragment", "createHeightAnimator panel.height: " + r100.getHeight() + " to " + r101 + ';');
        ValueAnimator r102 = ValueAnimator.ofInt(new int[]{r100.getHeight(), r101});
        r102.addUpdateListener(new b(r100));
        r102.setDuration(100);
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public final void aa0(BaseBlockEditPanel r100, int r101) {
        ca0(true);
        r100.animate().translationY(r100.getHeight() / 4).alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(200).withEndAction(new c(this, r100, r101)).start();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f217633e = (FrameLayout) r100;
        Z90().getHighlight().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.doc.blockeditpanel.view.b(this));
        Z90().getMenuItems().observe(getViewLifecycleOwner(), new BlockEditPanelFragment$initPanelMenusObserver$1(this));
        FrameLayout r102 = this.f217633e;
        if (r102 == null) goto L5;
        r102.addOnLayoutChangeListener(new com.bytedance.ee.bear.doc.blockeditpanel.view.d(this));
    L5:
        this.f217641m = ForsetiHelper.s(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_block_edit_panel_fragment, r101, false);
    }
}
