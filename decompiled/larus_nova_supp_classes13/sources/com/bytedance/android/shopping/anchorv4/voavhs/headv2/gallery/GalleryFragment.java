package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.gallery2.IndexIndicator;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.bytedance.android.shopping.anchorv4.components.ScreenCaptureManager;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.dto.ConfigModel;
import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottomConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GallerySliceVisibilityConfig;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.LynxElementVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantGravity;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.VideoCtrlContainerComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.GalleryJsEventHandler$register$2;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.GalleryVideoVH;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$1;
import com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$2;
import com.bytedance.android.shopping.buynow.data.model.TTPayCode;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionUtils;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\tJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/GalleryFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/GalleryViewerDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/k0;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/widget/f;", "Lee3/e;", "Lhl/b;", "event", "", "addShopCartSuccessEvent", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryFragment extends GalleryViewerDialogFragment implements k0, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f, ee3.e {
    public static Integer M;
    public static final b N = null;
    public boolean A;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l B;
    public List<? extends com.bytedance.android.ec.model.k> C;
    public List<c0> D;
    public boolean E;
    public final Lazy F;
    public final HashMap<String, Boolean> G;
    public PendantContainerVO H;
    public ScreenCaptureManager I;
    public final Lazy J;
    public final i0 K;
    public final Rect L;
    public final com.bytedance.android.shopping.base.arch.viewmodel.a r;
    public final m s;
    public final Lazy t;
    public int u;
    public Integer v;
    public w0 w;
    public final GalleryLayerItemStateManager x;
    public LinearLayout y;
    public final Function0<Rect> z;

    public static final class a implements h0 {
        public final /* synthetic */ GalleryFragment a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final GalleryLayerItemStateManager a() {
            return this.a.x;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l c() {
            return this.a.B;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final int d() {
            int r0 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.m.n;
            b r1 = GalleryFragment.N;
            Context r2 = this.a.requireContext();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "context");
            Integer r3 = GalleryFragment.M;
            if (r3 == null) goto L5;
            int r4 = r3.intValue();
        L7:
            return r0 + r4;
        L5:
            r4 = eh.b.b(r2);
            GalleryFragment.M = Integer.valueOf(r4);
            goto L7
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final int f() {
            w0 r0 = this.a.w;
            if (r0 == null) goto L12;
            GalleryVO r1 = r0.e;
            if (r1 != null) goto L7;
        L9:
            boolean r2 = false;
        L10:
            if (r2 != true) goto L12;
            return com.bytedance.android.shopping.extensions.b.a(Integer.valueOf(TTPayCode.TT_CJ_PAY_ANTI_FRAUD_CANCELED));
        L7:
            if (r1.getHasSkuPreview() != true) goto L9;
            r2 = true;
        L12:
            w0 r3 = this.a.w;
            if (r3 == null) goto L24;
            GalleryVO r4 = r3.e;
            if (r4 != null) goto L17;
        L19:
            boolean r5 = false;
        L20:
            if (r5 == true) goto L22;
            return 0;
        L22:
            return com.bytedance.android.shopping.extensions.b.a(52);
        L17:
            if (r4.getHasBottomButton() != true) goto L19;
            r5 = true;
            goto L20
        L24:
            return 0;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final Function0<Rect> g() {
            GalleryFragment r0 = this.a;
            if (r0.L != null) goto L7;
            return null;
        L7:
            return r0.z;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final RecyclerView getRecyclerView() {
            return this.a.V90();
        }

        public a(GalleryFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final void b(Integer r3) {
            if (r3 == null) goto L4;
            int r4 = r3.intValue();
        L5:
            GalleryFragment r0 = this.a;
            i0 r1 = r0.K;
            if (r1 == null) goto L9;
            r1.b(r0.fa0(r4));
            return;
        L9:
            return;
        L4:
            r4 = this.a.h;
            goto L5
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h0
        public final void e(View r6, RectF r7) {
            Intrinsics.checkNotNullParameter(r6, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r7, "rect");
            n0 r0 = new n0(r7.top - r6.getTop(), r6.getBottom() - r7.bottom, r7.left - r6.getLeft(), r6.getRight() - r7.right);
            GalleryFragment r8 = this.a;
            Integer r9 = GalleryFragment.M;
            GalleryViewModel r10 = r8.ja0();
            AnchorContainer r11 = AnchorContainer.GALLERY_PIC;
            State r2 = State.SHOW;
            r10.setAnchorContainerState(r11, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j(r2, r0));
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r12 = this.a.ha0();
            if (r12 == null) goto L29;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j r3 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j(r2, r0);
            Intrinsics.checkNotNullParameter(r11, "anchorContainer");
            Intrinsics.checkNotNullParameter(r3, "data");
            if (r12.c == null) goto L29;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
            Iterator r13 = r12.a.entrySet().iterator();     // Catch: Throwable -> L24
        L9:
            if (r13.hasNext() == false) goto L22;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r4 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) ((Map.Entry) r13.next()).getValue();     // Catch: Throwable -> L24
            if (r4 == null) goto L9;
            LynxElementVO r5 = r4.f;     // Catch: Throwable -> L24
            if (r5 == null) goto L9;
            AnchorContainer.a r14 = AnchorContainer.Companion;     // Catch: Throwable -> L24
            ConfigModel r15 = r5.getConfig();     // Catch: Throwable -> L24
            if (r15 == null) goto L18;
            String r16 = r15.getAnchorContainer();     // Catch: Throwable -> L24
        L19:
            r14.getClass();     // Catch: Throwable -> L24
            if (AnchorContainer.a.a(r16) != r11) goto L9;
            r5.updateReactMargin(r3.b);     // Catch: Throwable -> L24
            goto L9
        L18:
            r16 = null;
            goto L19
        L22:
            Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        L26:
            Throwable r18 = Result.exceptionOrNull-impl(r17);
            if (r18 == null) goto L29;
            ECExceptionMonitor.e(r18);
        L24:
            th = move-exception;
            Result.Companion r19 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
        L29:
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r20 = this.a.ha0();
            if (r20 != null) goto L32;
            return;
        L32:
            if (r20.c == null) goto L113;
            Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L70
            Iterator r22 = r20.a.entrySet().iterator();     // Catch: Throwable -> L70
        L36:
            if (r22.hasNext() == false) goto L68;
            Map.Entry r23 = (Map.Entry) r22.next();     // Catch: Throwable -> L70
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r24 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r23.getValue();     // Catch: Throwable -> L70
            if (r24 == null) goto L42;
            View r25 = r24.a;     // Catch: Throwable -> L70
            if (r25 == null) goto L42;
            ViewGroup.LayoutParams r26 = r25.getLayoutParams();     // Catch: Throwable -> L70
        L44:
            if ((r26 instanceof FrameLayout.LayoutParams) == true) goto L46;
            r26 = null;
        L46:
            FrameLayout.LayoutParams r27 = (FrameLayout.LayoutParams) r26;     // Catch: Throwable -> L70
            if (r27 == null) goto L36;
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r28 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r23.getValue();     // Catch: Throwable -> L70
            if (r28 == null) goto L51;
            LynxElementVO r29 = r28.f;     // Catch: Throwable -> L70
        L52:
            if (r29 == null) goto L36;
            PendantGravity r30 = r29.getGravity();     // Catch: Throwable -> L70
            if (r30 == null) goto L36;
            int r31 = com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.f.c[r30.ordinal()];     // Catch: Throwable -> L70
            if (r31 != 1) goto L58;
            r27.bottomMargin = r29.getUseBottomMargin();     // Catch: Throwable -> L70
            r27.leftMargin = r29.getUseLeftMargin();     // Catch: Throwable -> L70
            r27.gravity = 8388691;     // Catch: Throwable -> L70
            goto L36
        L58:
            if (r31 != 2) goto L60;
            r27.topMargin = r29.getUseTopMargin();     // Catch: Throwable -> L70
            r27.rightMargin = r29.getUseRightMargin();     // Catch: Throwable -> L70
            r27.gravity = 8388661;     // Catch: Throwable -> L70
            goto L36
        L60:
            if (r31 != 3) goto L62;
            r27.bottomMargin = r29.getUseBottomMargin();     // Catch: Throwable -> L70
            r27.rightMargin = r29.getUseRightMargin();     // Catch: Throwable -> L70
            r27.gravity = 8388693;     // Catch: Throwable -> L70
            goto L36
        L62:
            if (r31 != 4) goto L36;
            r27.topMargin = r29.getUseTopMargin();     // Catch: Throwable -> L70
            r27.leftMargin = r29.getUseLeftMargin();     // Catch: Throwable -> L70
            r27.gravity = 8388659;     // Catch: Throwable -> L70
            goto L36
        L51:
            r29 = null;
        L42:
            r26 = null;
            goto L44
        L68:
            Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L70
        L72:
            Throwable r33 = Result.exceptionOrNull-impl(r32);
            if (r33 == null) goto L75;
            ECExceptionMonitor.e(r33);
        L75:
            r20.e();
            return;
        L70:
            th = move-exception;
            Result.Companion r34 = Result.Companion;
            r32 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L72
        }
    }

    public static final class b {
        public b() {
        }

        public static Integer a(q r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            if (r1.i == null) goto L6;
            return 8;
        L6:
            if (r1.d == null) goto L9;
            return 2;
        L9:
            if (r1.a != null) goto L11;
            return null;
        L11:
            if (com.bytedance.android.shopping.extensions.k.c(r1.b) == false) goto L14;
            int r2 = 7;
        L22:
            return Integer.valueOf(r2);
        L14:
            if (com.bytedance.android.shopping.extensions.k.c(r1.e) == false) goto L16;
            r2 = 5;
            goto L22
        L16:
            r2 = 1;
            goto L22
        }

        public static Rect b(View r3) {
            View r0 = null;
            if (r3 != null) goto L6;
            return null;
        L6:
            if ((r3 instanceof GenericDraweeView) == false) goto L9;
            r0 = r3;
        L9:
            GenericDraweeView r1 = (GenericDraweeView) r0;
            if (r1 == null) goto L14;
            GenericDraweeHierarchy r2 = r1.getHierarchy();
            if (r2 == null) goto L14;
            RectF r4 = new RectF();
            r2.getActualImageBounds(r4);
            int r5 = (int) r4.width();
            int r6 = (int) r4.height();
        L15:
            if (r6 == 0) goto L17;
            if (r5 == 0) goto L17;
        L19:
            return TransitionUtils.calculateStartRect(r3, r5, r6, true);
        L17:
            r5 = r3.getWidth();
            r6 = r3.getHeight();
        L14:
            r5 = 0;
            r6 = 0;
            goto L15
        }
    }

    public static final class c extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {
        public final /* synthetic */ View c;
        public final /* synthetic */ Pair d;
        public final /* synthetic */ GalleryFragment e;
        public final /* synthetic */ i0 f;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r4) {
            GalleryVO r0 = this.f.s0();
            if (r0 == null) goto L11;
            GalleryPendants r1 = r0.getPendants();
            if (r1 == null) goto L11;
            GalleryConfig r2 = r1.getConfig();
            if (r2 == null) goto L11;
            Map r3 = r2.getVisibility();
            if (r3 == null) goto L11;
            GallerySliceVisibilityConfig r5 = (GallerySliceVisibilityConfig) r3.get(this.d.getFirst());
        L12:
            if (r5 == null) goto L14;
            GalleryFragment r6 = this.e;
            Integer r7 = GalleryFragment.M;
            r6.getClass();
            return GalleryFragment.da0(r5, r4);
        L14:
            return false;
        L11:
            r5 = null;
            goto L12
        }

        public c(View r1, View r2, m0 r3, Pair r4, GalleryFragment r5, i0 r6) {
            this.c = r1;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            super(r2, r3);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ GalleryFragment a;

        public d(GalleryFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GalleryFragment.ba0(this.a);     // Catch: Throwable -> L4
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
        public final /* synthetic */ GalleryFragment a;
        public final /* synthetic */ State b;

        public e(GalleryFragment r1, State r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GalleryFragment r0 = this.a;     // Catch: Throwable -> L4
            Integer r1 = GalleryFragment.M;     // Catch: Throwable -> L4
            r0.ja0().setShowDependsState(ShowDependsOn.GALLERY_FIND_SIMILAR, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ GalleryFragment a;

        public f(GalleryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            GalleryFragment r5 = this.a;
            int r0 = r5.h;
            Integer r1 = GalleryFragment.M;
            r5.ka0(r5.fa0(r0), this.a.s, "bottom_left_find_same");
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ GalleryFragment a;

        public g(GalleryFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            GalleryFragment r5 = this.a;
            int r0 = r5.h;
            Integer r1 = GalleryFragment.M;
            r5.ka0(r5.fa0(r0), this.a.s, "bottom_left_find_same");
        }
    }

    public static final class h implements com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d {
        public final /* synthetic */ GalleryFragment a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d
        public final void b() {
            GalleryFragment r0 = this.a;
            GalleryAdapter r1 = r0.p;
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r3 = null;
            if ((r1 instanceof GalleryCompatAdapter) == true) goto L5;
            r1 = null;
        L5:
            GalleryCompatAdapter r2 = (GalleryCompatAdapter) r1;
            if (r2 != null) goto L8;
            return;
        L8:
            int r4 = r0.h;
            h0 r5 = r2.g;
            if (r5 == null) goto L13;
            RecyclerView r6 = r5.getRecyclerView();
            if (r6 == null) goto L13;
            RecyclerView.ViewHolder r7 = r6.findViewHolderForAdapterPosition(r4);
        L15:
            if ((r7 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L17;
            r7 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r8 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r7;
            if ((r8 instanceof GalleryVideoVH) == false) goto L21;
            r3 = r8;
        L21:
            GalleryVideoVH r9 = (GalleryVideoVH) r3;
            if (r9 != null) goto L24;
            return;
        L24:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r10 = r9.q;
            if (r10 == null) goto L28;
            r10.f.setMoreVideoExpanded(!r9.X3());
            r9.q.g.g(r9.X3());
            return;
        L28:
            return;
        L13:
            r7 = null;
            goto L15
        }

        public h(GalleryFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.d
        public final void a(com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.b0 r8) {
            Intrinsics.checkNotNullParameter(r8, "playerEventInfo");
            GalleryFragment r0 = this.a;
            GalleryAdapter r1 = r0.p;
            Object r3 = null;
            if ((r1 instanceof GalleryCompatAdapter) == true) goto L5;
            r1 = null;
        L5:
            GalleryCompatAdapter r2 = (GalleryCompatAdapter) r1;
            if (r2 != null) goto L8;
            return;
        L8:
            int r4 = r0.h;
            h0 r5 = r2.g;
            if (r5 == null) goto L13;
            RecyclerView r6 = r5.getRecyclerView();
            if (r6 == null) goto L13;
            RecyclerView.ViewHolder r7 = r6.findViewHolderForAdapterPosition(r4);
        L15:
            if ((r7 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L17;
            r7 = null;
        L17:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r9 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r7;
            if ((r9 instanceof GalleryVideoVH) == true) goto L20;
            r9 = null;
        L20:
            GalleryVideoVH r10 = (GalleryVideoVH) r9;
            if (r10 != null) goto L24;
            return;
        L24:
            if (Intrinsics.areEqual(r8.b, "PDPPlayerControl") == false) goto L87;
            Object r11 = r8.c.get("command");
            if ((r11 instanceof String) == false) goto L29;
            r3 = r11;
        L29:
            String r12 = (String) r3;
            if (r12 != null) goto L33;
            r12 = "";
        L33:
            switch(r12.hashCode()) {
                case 3363353: goto L64;
                case 3443508: goto L56;
                case 3526264: goto L45;
                case 3540994: goto L43;
                case 106440182: goto L36;
                default: goto L101;
            };
        L43:
            r12.equals("stop");
            return;
        L101:
            return;
        L36:
            if (r12.equals("pause") == false) goto L88;
            x73.a r13 = r10.a;
            if (r13 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L41:
            if (r13.isPlaying() == false) goto L89;
            r10.pausePlay();
            return;
        L89:
            return;
        L88:
            return;
        L45:
            if (r12.equals("seek") == false) goto L92;
            Object r14 = r8.c.get("progress");
            float r15 = 0.0f;
            if (r14 == null) goto L49;
            r15 = com.bytedance.android.ecom.arch.slice.render.util.b.c(r14, 0.0f);
        L49:
            dm.a.a("GalleryFragment").i("handelLynxPlayerEvent, progress seekTo: " + r15);
            if (r15 <= 0) goto L93;
            x73.a r16 = r10.a;
            if (r16 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L54:
            r16.seek(r15);
            return;
        L93:
            return;
        L92:
            return;
        L56:
            if (r12.equals("play") == false) goto L95;
            x73.a r17 = r10.a;
            if (r17 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L61:
            if (r17.isPlaying() == true) goto L96;
            r10.startPlay();
            return;
        L96:
            return;
        L95:
            return;
        L64:
            if (r12.equals("mute") == false) goto L98;
            boolean r18 = Intrinsics.areEqual(r8.c.get("mute"), 1);
            dm.a.a("GalleryFragment").i("onPlayerEvent, isMute: " + r18);
            x73.a r19 = r10.a;
            if (r19 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
        L68:
            r19.f(r18, false);
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r20 = r10.q;
            if (r20 == null) goto L73;
            GalleryViewModel r21 = r20.f;
            if (r21 == null) goto L73;
            r21.setVideoManualMuteState(Boolean.valueOf(r18));
        L73:
            GalleryVideoVH.a r22 = r10.m;
            if (r22 == null) goto L76;
            r22.n(r18, true);
        L76:
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r23 = r10.q;
            if (r23 == null) goto L81;
            m r24 = r23.g;
            if (r24 == null) goto L81;
            r24.h(r10.getAdapterPosition(), r18);
        L81:
            com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r25 = r10.l.g;
            if (r25 == null) goto L99;
            VideoCtrlContainerComponent r26 = r25.c;
            if (r26 == null) goto L100;
            int r27 = VideoCtrlContainerComponent.g;
            r26.c(0);
            return;
        L100:
            return;
        L99:
            return;
        L98:
            return;
        L87:
            return;
        L13:
            r7 = null;
            goto L15
        }
    }

    public static final class i extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b {
        public final /* synthetic */ GalleryFragment c;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b
        public final boolean a(int r4) {
            GalleryFragment r0 = this.c;
            Integer r1 = GalleryFragment.M;
            q r5 = r0.fa0(r4);
            if (r5 == null) goto L19;
            String r2 = r5.c;
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L13;
        L15:
            boolean r6 = false;
        L16:
            if (r6 != true) goto L20;
            return true;
        L20:
            return false;
        L13:
            if (r5.i != null) goto L15;
            r6 = true;
            goto L16
        L7:
            if (r2.length() == 0) goto L10;
            r3 = false;
            goto L11
        L19:
            return false;
        }

        public i(GalleryFragment r1, IndexIndicator r2, m0 r3) {
            this.c = r1;
            super(r2, r3);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ GalleryFragment a;

        public j(GalleryFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            GalleryFragment r0 = this.a;
            int r5 = ((Integer) r4).intValue();
            Integer r1 = GalleryFragment.M;
            if (r5 != 3) goto L7;
            q r6 = r0.fa0(r0.h);
            i0 r2 = r0.K;
            if (r2 == null) goto L9;
            r2.e(r0.h, r6, true);
            return;
        L9:
            return;
        L7:
            r0.getClass();
        }
    }

    public static final class k implements l0 {
        public final /* synthetic */ GalleryFragment a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final String a() {
            return this.a.K.y0();
        }

        public final ActionContext d() {
            return this.a.K.n0();
        }

        public final ng3.a e() {
            return this.a.K.r0();
        }

        public k(GalleryFragment r1) {
            this.a = r1;
        }

        public final com.bytedance.android.ecom.arch.slice.action.p b(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            return this.a.K.u0(r2);
        }

        public final com.bytedance.android.ecom.arch.slice.action.j c(FragmentActivity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            return this.a.K.t0(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final void k0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "sliceId");
            this.a.K.k0(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l0
        public final void l0(int r2, String r3) {
            this.a.K.l0(r2, r3);
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ GalleryFragment a;

        public l(GalleryFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r20) {
            Pair r0 = (Pair) r20;
            Map r1 = (Map) r0.component1();
            Map r2 = (Map) r0.component2();
            GalleryFragment r3 = this.a;
            PendantContainerVO r4 = r3.H;
            if (r4 == null) goto L284;
            ArrayList r5 = new ArrayList();
            ArrayList r6 = new ArrayList();
            ArrayList r7 = new ArrayList();
            ArrayList r8 = new ArrayList();
            if (r1 == null) goto L117;
            Iterator r9 = r1.entrySet().iterator();
        L9:
            if (r9.hasNext() == false) goto L116;
            Map.Entry r12 = (Map.Entry) r9.next();
            AnchorContainer r13 = (AnchorContainer) r12.getKey();
            com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j r14 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j) r12.getValue();
            if (r14.a != State.SHOW) goto L9;
            List r15 = r4.getLeftBottom();
            if (r15 == null) goto L38;
            ArrayList r10 = new ArrayList();
            Iterator<T> r16 = r15.iterator();
        L16:
            if (r16.hasNext() == false) goto L29;
            T r11 = r16.next();
            LynxElementVO r17 = (LynxElementVO) r11;
            AnchorContainer.a r18 = AnchorContainer.Companion;
            if (r17 == null) goto L22;
            ConfigModel r19 = r17.getConfig();
            if (r19 == null) goto L22;
            String r110 = r19.getAnchorContainer();
        L23:
            r18.getClass();
            if (AnchorContainer.a.a(r110) != r13) goto L26;
            boolean r111 = true;
        L27:
            if (r111 == false) goto L16;
            r10.add(r11);
            goto L16
        L26:
            r111 = false;
        L22:
            r110 = null;
            goto L23
        L29:
            ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r21 = r10.iterator();
        L31:
            if (r21.hasNext() == false) goto L37;
            LynxElementVO r113 = (LynxElementVO) r21.next();
            if (r113 == null) goto L35;
            r113.updateReactMargin(r14.b);
        L36:
            r112.add(r113);
            goto L31
        L35:
            r113 = null;
            goto L36
        L37:
            r5.addAll(r112);
        L38:
            List r22 = r4.getRightBottom();
            if (r22 == null) goto L64;
            ArrayList r114 = new ArrayList();
            Iterator<T> r23 = r22.iterator();
        L42:
            if (r23.hasNext() == false) goto L55;
            T r115 = r23.next();
            LynxElementVO r116 = (LynxElementVO) r115;
            AnchorContainer.a r117 = AnchorContainer.Companion;
            if (r116 == null) goto L48;
            ConfigModel r118 = r116.getConfig();
            if (r118 == null) goto L48;
            String r119 = r118.getAnchorContainer();
        L49:
            r117.getClass();
            if (AnchorContainer.a.a(r119) != r13) goto L52;
            boolean r120 = true;
        L53:
            if (r120 == false) goto L42;
            r114.add(r115);
            goto L42
        L52:
            r120 = false;
        L48:
            r119 = null;
            goto L49
        L55:
            ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
            Iterator r121 = r114.iterator();
        L57:
            if (r121.hasNext() == false) goto L63;
            LynxElementVO r122 = (LynxElementVO) r121.next();
            if (r122 == null) goto L61;
            r122.updateReactMargin(r14.b);
        L62:
            r24.add(r122);
            goto L57
        L61:
            r122 = null;
            goto L62
        L63:
            r6.addAll(r24);
        L64:
            List r25 = r4.getTopRight();
            if (r25 == null) goto L90;
            ArrayList r123 = new ArrayList();
            Iterator<T> r26 = r25.iterator();
        L68:
            if (r26.hasNext() == false) goto L81;
            T r124 = r26.next();
            LynxElementVO r125 = (LynxElementVO) r124;
            AnchorContainer.a r126 = AnchorContainer.Companion;
            if (r125 == null) goto L74;
            ConfigModel r127 = r125.getConfig();
            if (r127 == null) goto L74;
            String r128 = r127.getAnchorContainer();
        L75:
            r126.getClass();
            if (AnchorContainer.a.a(r128) != r13) goto L78;
            boolean r129 = true;
        L79:
            if (r129 == false) goto L68;
            r123.add(r124);
            goto L68
        L78:
            r129 = false;
        L74:
            r128 = null;
            goto L75
        L81:
            ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r123, 10));
            Iterator r130 = r123.iterator();
        L83:
            if (r130.hasNext() == false) goto L89;
            LynxElementVO r131 = (LynxElementVO) r130.next();
            if (r131 == null) goto L87;
            r131.updateReactMargin(r14.b);
        L88:
            r27.add(r131);
            goto L83
        L87:
            r131 = null;
            goto L88
        L89:
            r7.addAll(r27);
        L90:
            List r28 = r4.getTopLeft();
            if (r28 == null) goto L9;
            ArrayList r132 = new ArrayList();
            Iterator<T> r29 = r28.iterator();
        L94:
            if (r29.hasNext() == false) goto L107;
            T r133 = r29.next();
            LynxElementVO r134 = (LynxElementVO) r133;
            AnchorContainer.a r135 = AnchorContainer.Companion;
            if (r134 == null) goto L100;
            ConfigModel r136 = r134.getConfig();
            if (r136 == null) goto L100;
            String r137 = r136.getAnchorContainer();
        L101:
            r135.getClass();
            if (AnchorContainer.a.a(r137) != r13) goto L104;
            boolean r138 = true;
        L105:
            if (r138 == false) goto L94;
            r132.add(r133);
            goto L94
        L104:
            r138 = false;
        L100:
            r137 = null;
            goto L101
        L107:
            ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
            Iterator r139 = r132.iterator();
        L109:
            if (r139.hasNext() == false) goto L115;
            LynxElementVO r140 = (LynxElementVO) r139.next();
            if (r140 == null) goto L113;
            r140.updateReactMargin(r14.b);
        L114:
            r30.add(r140);
            goto L109
        L113:
            r140 = null;
            goto L114
        L115:
            r8.addAll(r30);
            goto L9
        L116:
            Unit r31 = Unit.INSTANCE;
        L117:
            GalleryFragment$onPendantContainerStateChange$2 r32 = GalleryFragment$onPendantContainerStateChange$2.INSTANCE;
            ArrayList r33 = new ArrayList();
            ArrayList r34 = new ArrayList();
            ArrayList r141 = new ArrayList();
            ArrayList r142 = new ArrayList();
            ArrayList r143 = new ArrayList();
            Iterator r144 = r5.iterator();
        L119:
            if (r144.hasNext() == false) goto L131;
            Object r145 = r144.next();
            LynxElementVO r146 = (LynxElementVO) r145;
            if (r146 == null) goto L125;
            ConfigModel r147 = r146.getConfig();
            if (r147 == null) goto L125;
            String r148 = r147.getShowDependsOn();
        L126:
            if (r148 != null) goto L128;
            boolean r149 = true;
        L129:
            if (r149 == false) goto L119;
            r143.add(r145);
            goto L119
        L128:
            r149 = false;
        L125:
            r148 = null;
            goto L126
        L131:
            r33.addAll(r143);
            ArrayList r150 = new ArrayList();
            Iterator r151 = r6.iterator();
        L133:
            if (r151.hasNext() == false) goto L145;
            Object r152 = r151.next();
            LynxElementVO r153 = (LynxElementVO) r152;
            if (r153 == null) goto L139;
            ConfigModel r154 = r153.getConfig();
            if (r154 == null) goto L139;
            String r155 = r154.getShowDependsOn();
        L140:
            if (r155 != null) goto L142;
            boolean r156 = true;
        L143:
            if (r156 == false) goto L133;
            r150.add(r152);
            goto L133
        L142:
            r156 = false;
        L139:
            r155 = null;
            goto L140
        L145:
            r34.addAll(r150);
            ArrayList r157 = new ArrayList();
            Iterator r158 = r7.iterator();
        L147:
            if (r158.hasNext() == false) goto L159;
            Object r159 = r158.next();
            LynxElementVO r160 = (LynxElementVO) r159;
            if (r160 == null) goto L153;
            ConfigModel r161 = r160.getConfig();
            if (r161 == null) goto L153;
            String r162 = r161.getShowDependsOn();
        L154:
            if (r162 != null) goto L156;
            boolean r163 = true;
        L157:
            if (r163 == false) goto L147;
            r157.add(r159);
            goto L147
        L156:
            r163 = false;
        L153:
            r162 = null;
            goto L154
        L159:
            r141.addAll(r157);
            ArrayList r164 = new ArrayList();
            Iterator r165 = r8.iterator();
        L161:
            if (r165.hasNext() == false) goto L173;
            Object r166 = r165.next();
            LynxElementVO r167 = (LynxElementVO) r166;
            if (r167 == null) goto L167;
            ConfigModel r168 = r167.getConfig();
            if (r168 == null) goto L167;
            String r169 = r168.getShowDependsOn();
        L168:
            if (r169 != null) goto L170;
            boolean r170 = true;
        L171:
            if (r170 == false) goto L161;
            r164.add(r166);
            goto L161
        L170:
            r170 = false;
        L167:
            r169 = null;
            goto L168
        L173:
            r142.addAll(r164);
            if (r2 == null) goto L184;
            Iterator r35 = r2.entrySet().iterator();
        L177:
            if (r35.hasNext() == false) goto L183;
            Map.Entry r171 = (Map.Entry) r35.next();
            ShowDependsOn r172 = (ShowDependsOn) r171.getKey();
            State r173 = (State) r171.getValue();
            if (r173 == State.SHOW) goto L182;
            if (r173 != State.ANIM_END) goto L177;
        L182:
            GalleryFragment$onPendantContainerStateChange$2 r174 = GalleryFragment$onPendantContainerStateChange$2.INSTANCE;
            r33.addAll(r174.invoke(r5, r172, r173));
            r34.addAll(r174.invoke(r6, r172, r173));
            r141.addAll(r174.invoke(r7, r172, r173));
            r142.addAll(r174.invoke(r8, r172, r173));
            goto L177
        L183:
            Unit r36 = Unit.INSTANCE;
        L184:
            PendantContainerVO.Companion r37 = PendantContainerVO.Companion;
            List r38 = r4.getLeftBottom();
            r37.getClass();
            PendantContainerVO r39 = r4.copy(PendantContainerVO.Companion.d(r38, r33), PendantContainerVO.Companion.d(r4.getRightBottom(), r34), PendantContainerVO.Companion.d(r4.getTopRight(), r141), PendantContainerVO.Companion.d(r4.getTopLeft(), r142));
            if (r39.getLeftBottom() == null) goto L189;
            if (r39.getLeftBottom().isEmpty() == true) goto L189;
        L200:
            boolean r175 = true;
        L202:
            if (r175 == true) goto L205;
            r39 = null;
        L205:
            r3.H = r39;
            if (r33.isEmpty() == true) goto L208;
        L214:
            PendantContainerVO r40 = new PendantContainerVO(r33, r34, r141, r142);
            i0 r41 = r3.K;
            if (r41 == null) goto L283;
            r3.ca0(r40, r41);
            return;
        L283:
            return;
        L208:
            if (r34.isEmpty() == false) goto L214;
            if (r141.isEmpty() == false) goto L214;
            if (r142.isEmpty() == false) goto L214;
            return;
        L189:
            if (r39.getRightBottom() == null) goto L193;
            if (r39.getRightBottom().isEmpty() == false) goto L200;
        L193:
            if (r39.getTopRight() == null) goto L197;
            if (r39.getTopRight().isEmpty() == false) goto L200;
        L197:
            if (r39.getTopLeft() != null) goto L199;
        L201:
            r175 = false;
            goto L202
        L199:
            if (r39.getTopLeft().isEmpty() == true) goto L201;
        }
    }

    public GalleryFragment() {
        this(null, null);
    }

    public final com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e ha0() {
        return (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e) this.F.getValue();
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g ia0() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g) this.t.getValue();
    }

    public final GalleryViewModel ja0() {
        return (GalleryViewModel) this.r.getValue();
    }

    static {
        N = new b();
    }

    @Override // ee3.e
    public final void M0() {
        m r0 = this.s;
        if (r0 == null) goto L6;
        m.d(r0, "pdp_long_press", null, null, "a1.b34986.c0.d0", 30);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void Y90() {
        GalleryAdapter r0 = this.p;
        if ((r0 instanceof GalleryCompatAdapter) == true) goto L5;
        r0 = null;
    L5:
        GalleryCompatAdapter r1 = (GalleryCompatAdapter) r0;
        if (r1 == null) goto L8;
        r1.C2();
    L8:
        Lazy r2 = UIUtils.a;
        UIUtils.c().post(new d(this));
    }

    public final boolean ea0() {
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L17;
        RecyclerView.ViewHolder r0 = V90().findViewHolderForAdapterPosition(this.h);
        if (r0 != null) goto L7;
        return false;
    L7:
        if ((r0 instanceof TransitionViewHolder) == true) goto L9;
        r0 = null;
    L9:
        TransitionViewHolder r1 = (TransitionViewHolder) r0;
        if (r1 == null) goto L20;
        TransitionLayout r2 = r1.getTransitionLayout();
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r2.isEnableDismissTransition() == false) goto L22;
        r2.dismissAnimated();
        return true;
    L22:
        return false;
    L20:
        return false;
    L17:
        return false;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L6;
        r0.f();
    L6:
        if (this.E == false) goto L10;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r1 = ha0();
        if (r1 == null) goto L10;
        r1.f();
    L10:
        m r2 = this.s;
        Long r3 = r2.c;
        if (r3 == null) goto L13;
        long r4 = (System.currentTimeMillis() - r3.longValue()) / ((long) 1000);
    L14:
        Pair[] r5 = new Pair[2];
        r5[0] = TuplesKt.to("duration", Long.valueOf(r4));
        if (r2.d == false) goto L17;
        String r6 = "back";
    L18:
        r5[1] = TuplesKt.to("click_area", r6);
        m.d(r2, "pdp_big_picture_click", MapsKt.mapOf(r5), null, "a1.b34986.c0.d0", 28);
        w0 r7 = this.w;
        if (r7 == null) goto L32;
        v0 r8 = r7.a;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r9 = r8.b;
        if (r9 == null) goto L23;
        r9.release();
    L23:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r10 = r8.i;
        if (r10 == null) goto L28;
        EventChain r11 = r10.l;
        if (r11 == null) goto L28;
        r11.b();
    L28:
        SlcContext r12 = r8.a;
        if (r12 == null) goto L32;
        r12.d();
    L32:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L34;
        com.bytedance.android.ec.core.utils.s0.e(this);
    L34:
        i0 r13 = this.K;
        GalleryAdapter r14 = null;
        if (r13 == null) goto L43;
        q r15 = fa0(this.h);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r16 = this.B;
        if (r16 == null) goto L41;
        z0 r17 = r16.a;
        if (r17 == null) goto L41;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h r18 = r17.b;
    L42:
        r13.d(r15, r18);
    L41:
        r18 = null;
    L43:
        GalleryAdapter r19 = this.p;
        if ((r19 instanceof GalleryCompatAdapter) == false) goto L47;
        r14 = r19;
    L47:
        GalleryCompatAdapter r20 = (GalleryCompatAdapter) r14;
        if (r20 == null) goto L50;
        r20.C2();
    L50:
        this.G.clear();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L56;
        Iterator r21 = ((LinkedHashMap) ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.J.getValue()).a).entrySet().iterator();
    L54:
        if (r21.hasNext() == false) goto L58;
        Map.Entry r22 = (Map.Entry) r21.next();
        ECLiveHybridUtil.p((String) r22.getKey(), (ti.j) r22.getValue());
        goto L54
    L58:
        return;
    L56:
        return;
    L17:
        r6 = "blank";
        goto L18
    L13:
        r4 = 0;
        goto L14
    }

    public final void onDestroyView() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.g r0 = ia0();
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        super.onDestroyView();
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        GalleryAdapter r0 = this.p;
        if ((r0 instanceof GalleryCompatAdapter) == true) goto L5;
        r0 = null;
    L5:
        GalleryCompatAdapter r1 = (GalleryCompatAdapter) r0;
        if (r1 == null) goto L11;
        Iterator r2 = ((ArrayList) r1.f).iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r2.next()).t0();
    L11:
        ScreenCaptureManager r3 = this.I;
        if (r3 == null) goto L16;
        r3.f();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onResume() {
        super.onResume();
        GalleryAdapter r0 = this.p;
        if ((r0 instanceof GalleryCompatAdapter) == true) goto L5;
        r0 = null;
    L5:
        GalleryCompatAdapter r1 = (GalleryCompatAdapter) r0;
        if (r1 == null) goto L11;
        Iterator r2 = ((ArrayList) r1.f).iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r2.next()).Y2();
    L11:
        ScreenCaptureManager r3 = this.I;
        if (r3 == null) goto L16;
        r3.g();
        return;
    }

    public static final /* synthetic */ void ba0(GalleryFragment r0) {
        super.Y90();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void Bt(String r4) {
        Intrinsics.checkNotNullParameter(r4, "componentName");
        q r0 = fa0(this.h);
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.extensions.k.c(r0.b) == false) goto L8;
        int r1 = 2;
    L10:
        if (r0.d == null) goto L12;
        String r2 = "video";
    L14:
        if (Intrinsics.areEqual(r4, "top_right_find_same") == false) goto L17;
        String r5 = "1";
    L20:
        this.s.a(r1, r2, r5);
        return;
    L17:
        if (Intrinsics.areEqual(r4, "bottom_left_find_same") == false) goto L19;
        r5 = "2";
        goto L20
    L19:
        r5 = null;
        goto L20
    L12:
        r2 = "image";
        goto L14
    L8:
        r1 = 1;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void T90(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        GalleryLayerItemStateManager r0 = this.x;
        if (r0 == null) goto L6;
        r0.d(r3, r0.i);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void X90(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        List<? extends com.bytedance.android.ec.model.k> r2 = this.C;
        List<c0> r3 = this.D;
        GalleryViewModel r6 = ja0();
        m r7 = this.s;
        i0 r8 = this.K;
        GalleryLayerItemStateManager r9 = this.x;
        FragmentActivity r1 = getActivity();
        if ((r1 instanceof FullScreenGalleryDialogActivity) == true) goto L5;
        r1 = null;
    L5:
        FullScreenGalleryDialogActivity r4 = (FullScreenGalleryDialogActivity) r1;
        if (r4 == null) goto L8;
        GalleryViewerParams r10 = r4.k;
    L9:
        this.B = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l(r2, r3, r13, this, r6, r7, r8, r9, r10, PageFinder.via(this));
        super.X90(r13);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L15;
        FrameLayout r0 = W90();
        View r11 = new View(r13);
        r11.setBackgroundResource(2131231269);
        GalleryLayerItemStateManager r12 = this.x;
        if (r12 == null) goto L14;
        r12.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r11, false, true, false, 16));
    L14:
        Unit r5 = Unit.INSTANCE;
        r0.addView(r11, new ViewGroup.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.a(100)));
    L15:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r14 = this.B;
        if (r14 != null) goto L18;
    L20:
        ia0().c(W90(), this.B);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L34;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.h r15 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.h(r13);
        FrameLayout r16 = W90();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r17 = this.B;
        Intrinsics.checkNotNullParameter(r16, "container");
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        r18.gravity = 8388629;
        Unit r19 = Unit.INSTANCE;
        r16.addView(r15, r18);
        if (r17 == null) goto L29;
        GalleryViewModel r110 = r17.f;
        if (r110 == null) goto L29;
        LiveData<Integer> r111 = r110.getCurPlayingVideoPosition();
        if (r111 == null) goto L29;
        r111.observe(r17.e, new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.k(r15, r17));
    L29:
        if (r17 == null) goto L35;
        GalleryLayerItemStateManager r112 = r17.i;
        if (r112 == null) goto L36;
        r112.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.l(r15, r15));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L18:
        if (r14.b() != true) goto L20;
        ja0().setMoreVideoExpanded(true);
        goto L20
    L8:
        r10 = null;
        goto L9
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void addShopCartSuccessEvent(hl.b r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (isResumed() == true) goto L5;
        return;
    L5:
        if (r10.o == true) goto L45;
        w0 r0 = this.w;
        String r1 = null;
        if (r0 == null) goto L25;
        GalleryVO r2 = r0.e;
        if (r2 == null) goto L25;
        GalleryBottom r3 = r2.getBottom();
        if (r3 == null) goto L25;
        GalleryBottomConfig r4 = r3.getConfig();
        if (r4 == null) goto L25;
        IAction r6 = r4.getAddCartToast();
        if (r6 == null) goto L25;
        int r5 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r7 = r0.i;
        if (r7 == null) goto L19;
        EventChain r8 = r7.l;
    L20:
        SlcContext r9 = r0.a.a;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r11 = r0.b;
        if (r11 == null) goto L23;
        LinearLayout r12 = r11.a;
    L24:
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(r8, null, r9, r6, r12, null);
        goto L25
    L23:
        r12 = null;
        goto L24
    L19:
        r8 = null;
    L25:
        String r13 = r10.p;
        if (r13 != null) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L46;
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L39
        r15.put("cart_id", r13);     // Catch: JSONException -> L39
        i0 r16 = this.K;     // Catch: JSONException -> L39
        if (r16 == null) goto L37;
        r1 = r16.v0();     // Catch: JSONException -> L39
    L37:
        r15.put("pdp_event_transparent_id", String.valueOf(r1));     // Catch: JSONException -> L39
        Unit r17 = Unit.INSTANCE;     // Catch: JSONException -> L39
        ECLiveHybridUtil.f("ecom.pdp.add_cart", r15);     // Catch: JSONException -> L39
        return;
    L39:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L46:
        return;
    L28:
        if (r13.length() == 0) goto L31;
        r14 = false;
        goto L32
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final boolean ey(String r3) {
        Intrinsics.checkNotNullParameter(r3, "componentName");
        if (Intrinsics.areEqual(r3, "top_right_find_same") == false) goto L7;
        return ia0().a();
    L7:
        if (Intrinsics.areEqual(r3, "bottom_left_find_same") == false) goto L15;
        LinearLayout r4 = this.y;
        if ((r4 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) == true) goto L11;
        r4 = null;
    L11:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r5 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) r4;
        if (r5 != null) goto L14;
        return false;
    L14:
        return r5.getBubbleIsShown();
    L15:
        return false;
    }

    public final q fa0(int r1) {
        g0 r2 = ga0(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.p;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void gD(State r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(new e(this, r3));
    }

    public final g0 ga0(int r3) {
        List<? extends com.bytedance.android.ec.model.l> r0 = this.p.b;
        com.bytedance.android.ec.model.l r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.ec.model.l r4 = (com.bytedance.android.ec.model.l) CollectionsKt.getOrNull(r0, r3);
    L7:
        if ((r4 instanceof g0) == false) goto L11;
        r1 = r4;
    L11:
        return (g0) r1;
    L5:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void k0(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sliceId");
        if (this.A == true) goto L5;
        return;
    L5:
        w0 r1 = this.w;
        if (r1 == null) goto L50;
        int r2 = w0.k;
        Intrinsics.checkNotNullParameter(r7, "sliceId");
        GalleryVO r0 = r1.e;
        com.bytedance.android.ecom.arch.slice.g r3 = null;
        Object r4 = null;
        r3 = null;
        r3 = null;
        if (r0 == null) goto L21;
        GalleryBottom r5 = r0.getBottom();
        if (r5 == null) goto L21;
        List r6 = r5.getSlices();
        if (r6 == null) goto L21;
        Iterator r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r9).getSliceId(), r7) == false) goto L15;
    L20:
        com.bytedance.android.ecom.arch.slice.g r10 = (com.bytedance.android.ecom.arch.slice.g) r9;
    L23:
        if (r10 == null) goto L27;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r11 = r1.b;
        if (r11 == null) goto L51;
        Intrinsics.checkNotNullParameter(r10, "slice");
        r11.b.c(r10);
        return;
    L51:
        return;
    L27:
        if (r0 == null) goto L39;
        GalleryPendants r12 = r0.getPendants();
        if (r12 == null) goto L39;
        List r13 = r12.getSlices();
        if (r13 == null) goto L39;
        Iterator r14 = r13.iterator();
    L34:
        if (r14.hasNext() == false) goto L38;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ecom.arch.slice.g) r15).getSliceId(), r7) == false) goto L34;
        r4 = r15;
    L38:
        r3 = (com.bytedance.android.ecom.arch.slice.g) r4;
    L39:
        if (r3 == null) goto L53;
        t0 r16 = r1.d;
        if (r16 == null) goto L54;
        Intrinsics.checkNotNullParameter(r3, "slice");
        r16.b.c(r3);
        return;
    L54:
        return;
    L53:
        return;
    L19:
        r9 = null;
    L21:
        r10 = null;
        goto L23
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final void k10(String r3) {
        Intrinsics.checkNotNullParameter(r3, "componentName");
        ka0(fa0(this.h), this.s, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l9(GalleryVO r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryVO");
        if (this.A == true) goto L5;
        return;
    L5:
        w0 r0 = this.w;
        if (r0 == null) goto L9;
        r0.b(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (this.K != null) goto L14;
        dismiss();     // Catch: Exception -> L6
    L10:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L14;
        r5.finish();
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L10;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L14:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == false) goto L22;
        com.bytedance.android.ec.core.utils.s0.c(this);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c r7 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.J.getValue();
        r7.a.put("triggerPdpEvent", new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.a(r7));
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == false) goto L18;
        r7.a.put("PDPPlayerControl", new GalleryJsEventHandler$register$2(r7));
        r7.a.put("PDPGalleryChangeVideoListFoldStatus", new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.b(r7));
    L18:
        Iterator r8 = ((LinkedHashMap) r7.a).entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) r8.next();
        ECLiveHybridUtil.m((String) r0.getKey(), (ti.j) r0.getValue());
    L22:
        cl.d.a.getClass();
        cl.d r9 = cl.d.a.b();
        if (r9 == null) goto L29;
        r9.f();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment
    public final void onTransitionEnd(int r2) {
        if (r2 != 0) goto L6;
        onPageSelected(this.h, false);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void w5(Map<Integer, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "galleryFindSameSchemaMap");
        List<? extends com.bytedance.android.ec.model.l> r0 = this.p.b;
        if (r0 == null) goto L17;
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L21;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.ec.model.l r5 = (com.bytedance.android.ec.model.l) r3;
        if ((r5 instanceof g0) == true) goto L13;
        r5 = null;
    L13:
        g0 r7 = (g0) r5;
        if (r7 == null) goto L16;
        LinkedHashMap r8 = (LinkedHashMap) r6;
        ((com.bytedance.android.ec.model.k) r7).k = (String) r8.get(Integer.valueOf(r2));
    L16:
        r2 = r4;
        goto L6
    L21:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void y5(String r9) {
        Intrinsics.checkNotNullParameter(r9, "specId");
        if (this.A == true) goto L5;
        return;
    L5:
        q r0 = fa0(this.h);
        if (r9.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        if (r0 == null) goto L20;
        String r2 = r0.c;
        if (r2 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        int r10 = this.h;
    L49:
        if (r10 >= 0) goto L51;
        return;
    L51:
        if (r10 == this.h) goto L58;
        V90().scrollToPosition(r10);
        return;
    L58:
        return;
    L14:
        if (r2.length() == 0) goto L17;
        r3 = false;
    L20:
        List<? extends com.bytedance.android.ec.model.l> r4 = this.p.b;
        if (r4 == null) goto L48;
        int r5 = r4.size();
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L48;
        Object r7 = ListProtector.get(r4, r6);
        String r8 = null;
        if ((r7 instanceof g0) == true) goto L27;
        r7 = null;
    L27:
        g0 r11 = (g0) r7;
        if (r11 == null) goto L33;
        q r12 = r11.p;
        if (r12 == null) goto L33;
        r8 = r12.c;
    L33:
        if (r9.length() != 0) goto L35;
        boolean r13 = true;
    L36:
        if (r13 == false) goto L45;
        if (r8 != null) goto L39;
    L42:
        boolean r14 = true;
    L43:
        if (r14 == false) goto L45;
    L46:
        r10 = r6;
        goto L49
    L39:
        if (r8.length() == 0) goto L42;
        r14 = false;
    L45:
        if (Intrinsics.areEqual(r9, r8) == true) goto L46;
        r6 = r6 + 1;
        goto L23
    L35:
        r13 = false;
    L48:
        r10 = -1;
        goto L49
    L8:
        r1 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.android.shopping.base.arch.viewmodel.FragmentViewModelLazyKt$viewModels$2, java.lang.Object] */
    public GalleryFragment(i0 r5, Rect r6) {
        super(new GalleryCompatAdapter());
        this.K = r5;
        this.L = r6;
        GalleryFragment$viewModel$2 r0 = GalleryFragment$viewModel$2.INSTANCE;
        final Function0<Fragment> r1 = new FragmentViewModelLazyKt$viewModels$1(this);
        KClass r2 = Reflection.getOrCreateKotlinClass(GalleryViewModel.class);
        ?? r3 = new FragmentViewModelLazyKt$viewModels$2(r1);
        Intrinsics.checkNotNullParameter(this, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(r2, "viewModelClass");
        Intrinsics.checkNotNullParameter(r3, "storeProducer");
        Intrinsics.checkNotNullParameter(r0, "factoryProducer");
        this.r = new com.bytedance.android.shopping.base.arch.viewmodel.a(r2, r3, r0);
        GalleryAdapter r4 = null;
        if (r5 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.n r7 = r5.o0();
    L6:
        if (r5 == null) goto L8;
        GalleryFromType r8 = r5.c();
    L9:
        m r9 = new m(r7, r8);
        GalleryAdapter r10 = this.p;
        if ((r10 instanceof GalleryCompatAdapter) == true) goto L12;
        r10 = null;
    L12:
        GalleryCompatAdapter r11 = (GalleryCompatAdapter) r10;
        if (r11 == null) goto L15;
        r11.h = r9;
    L15:
        Unit r12 = Unit.INSTANCE;
        this.s = r9;
        this.t = LazyKt.lazy(new GalleryFragment$tabIndicator$2(this));
        this.u = -1;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L18;
        GalleryLayerItemStateManager r13 = null;
    L23:
        this.x = r13;
        this.z = new GalleryFragment$exitRectGetter$1(this);
        this.F = LazyKt.lazy(new GalleryFragment$pendantContainerComponent$2(this));
        this.G = new HashMap();
        this.J = LazyKt.lazy(GalleryFragment$jsEventHandler$2.INSTANCE);
        GalleryAdapter r14 = this.p;
        if ((r14 instanceof GalleryCompatAdapter) == false) goto L27;
        r4 = r14;
    L27:
        GalleryCompatAdapter r15 = (GalleryCompatAdapter) r4;
        if (r15 == null) goto L31;
        r15.g = new a(this);
        return;
    L31:
        return;
    L18:
        if (r6 == null) goto L20;
        boolean r16 = true;
    L21:
        r13 = new GalleryLayerItemStateManager(r16, new GalleryFragment$layerStateManager$1(this));
        goto L23
    L20:
        r16 = false;
        goto L21
    L8:
        r8 = null;
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public static boolean da0(GallerySliceVisibilityConfig r2, int r3) {
        List r0 = r2.getShow();
        if (r0 != null) goto L5;
    L7:
        List r1 = r2.getHide();
        if (r1 != null) goto L10;
        return true;
    L10:
        if ((!r1.isEmpty()) == true) goto L12;
        return true;
    L12:
        if (r2.getHide().contains(Integer.valueOf(r3)) == false) goto L19;
        return false;
    L19:
        return true;
    L5:
        if ((!r0.isEmpty()) != true) goto L7;
        return r2.getShow().contains(Integer.valueOf(r3));
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void U90(RecyclerView r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        GalleryLayerItemStateManager r1 = this.x;
        if (r1 == null) goto L34;
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        if (r8 != 0) goto L30;
        int r9 = r7.getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r9) goto L13;
        View r4 = r7.getChildAt(r2);
        if (r4.getX() >= 0.0f) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        float r10 = r4.getX();
    L15:
        if (r10 != 0.0f) goto L35;
        r1.d(r7, r1.i);
        if (r1.a == false) goto L29;
        RecyclerView.ViewHolder r11 = r7.findViewHolderForAdapterPosition(r1.o);
        Float r3 = null;
        if ((r11 instanceof PhotoVH) == true) goto L21;
        r11 = null;
    L21:
        PhotoVH r12 = (PhotoVH) r11;
        if (r12 == null) goto L27;
        TransitionPhotoDraweeView r13 = r12.a;
        if (r13 == null) goto L27;
        r3 = Float.valueOf(r13.getScaleFactor());
    L27:
        if (Intrinsics.areEqual(r3, 1.0f) == false) goto L29;
        r1.g(1.0f);
    L29:
        r1.e(false);
        return;
    L35:
        return;
    L13:
        r10 = 0.0f;
        goto L15
    L30:
        r1.e(true);
        return;
    }

    public final void ca0(PendantContainerVO r21, i0 r22) {
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r1 = ha0();
        if (r1 == null) goto L5;
        r1.a(r21);
    L5:
        if (r21 == null) goto L83;
        List r0 = r21.getComponentCacheKey();
        if (r0 == null) goto L99;
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L9:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r8 = null;
        if (r4.hasNext() == false) goto L17;
        String r5 = (String) r4.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r6 = ha0();
        if (r6 == null) goto L16;
        ConcurrentHashMap r7 = r6.a;
        if (r7 == null) goto L16;
        r8 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r7.get(r5);
    L16:
        r3.add(TuplesKt.to(r5, r8));
        goto L9
    L17:
        Iterator r9 = r3.iterator();
    L19:
        if (r9.hasNext() == false) goto L100;
        Pair r10 = (Pair) r9.next();
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r11 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond();
        if (r11 == null) goto L65;
        View r12 = r11.a;
        if (r12 == null) goto L65;
        Object r13 = r12.getTag();
        if ((r13 instanceof LynxElementVO) == true) goto L27;
        r13 = null;
    L27:
        LynxElementVO r14 = (LynxElementVO) r13;
        GalleryVO r15 = r22.s0();
        if (r15 == null) goto L36;
        GalleryPendants r16 = r15.getPendants();
        if (r16 == null) goto L36;
        GalleryConfig r17 = r16.getConfig();
        if (r17 == null) goto L36;
        Map r18 = r17.getVisibility();
        if (r18 == null) goto L36;
        GallerySliceVisibilityConfig r19 = (GallerySliceVisibilityConfig) r18.get(r10.getFirst());
    L37:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r20 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond();
        if (r20 == null) goto L42;
        String r23 = r20.c;
        if (r23 == null) goto L42;
        this.G.put(r23, Boolean.TRUE);
    L42:
        GalleryLayerItemStateManager r110 = this.x;
        if (r110 == null) goto L65;
        ShowDependsOn.a r24 = ShowDependsOn.Companion;
        if (r14 == null) goto L49;
        ConfigModel r25 = r14.getConfig();
        if (r25 == null) goto L49;
        String r26 = r25.getShowDependsOn();
    L50:
        r24.getClass();
        ShowDependsOn[] r27 = ShowDependsOn.values();
        int r28 = r27.length;
        int r111 = 0;
    L51:
        if (r111 >= r28) goto L56;
        ShowDependsOn r112 = r27[r111];
        if (Intrinsics.areEqual(r112.getValue(), r26) == true) goto L54;
        r111 = r111 + 1;
        goto L51
    L54:
        ShowDependsOn r29 = r112;
    L58:
        if (r29 != ShowDependsOn.GALLERY_FIND_SIMILAR) goto L60;
        boolean r113 = true;
    L61:
        if (r19 == null) goto L63;
        int r114 = r19.getAnimType();
    L64:
        r110.c(new c(r12, r12, new m0(true, true, r113, r114, false, 48), r10, this, r22));
        goto L65
    L63:
        r114 = 1;
        goto L64
    L60:
        r113 = false;
        goto L61
    L56:
        r29 = null;
    L49:
        r26 = null;
    L36:
        r19 = null;
    L65:
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r30 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond();
        if (r30 == null) goto L68;
        State r31 = r30.d;
    L69:
        if (r31 == null) goto L19;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r32 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond();
        if (r32 == null) goto L73;
        State r33 = r32.d;
    L75:
        if (r33 == State.NORMAL) goto L19;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r34 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond();
        if (r34 == null) goto L79;
        State r35 = r34.d;
    L81:
        if (r35 == State.SHOW) goto L19;
        la0((String) r10.getFirst(), (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r10.getSecond());
        goto L19
    L79:
        r35 = null;
        goto L81
    L73:
        r33 = null;
        goto L75
    L68:
        r31 = null;
        goto L69
    L100:
        return;
    L99:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.k0
    public final void l0(int r9, String r10) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (r9 >= 0) goto L63;
        if (r10 != null) goto L10;
    L13:
        boolean r11 = true;
    L14:
        int r2 = -1;
        String r3 = null;
        if (r11 == false) goto L44;
        List<? extends com.bytedance.android.ec.model.l> r12 = this.p.b;
        if (r12 == null) goto L41;
        int r13 = r12.size();
        int r4 = 0;
    L19:
        if (r4 >= r13) goto L41;
        com.bytedance.android.ec.model.l r5 = (com.bytedance.android.ec.model.l) ListProtector.get(r12, r4);
        if (r5.getType() == 2) goto L40;
        if (r5.getType() == 8) goto L40;
        if ((r5 instanceof g0) == true) goto L27;
        r5 = null;
    L27:
        g0 r6 = (g0) r5;
        if (r6 == null) goto L32;
        q r14 = r6.p;
        if (r14 == null) goto L32;
        r3 = r14.c;
    L32:
        if (r3 != null) goto L34;
    L37:
        boolean r15 = true;
    L38:
        if (r15 == false) goto L41;
        r2 = r4;
        goto L41
    L34:
        if (r3.length() == 0) goto L37;
        r15 = false;
    L40:
        r4 = r4 + 1;
    L41:
        if (r2 >= 0) goto L43;
        r9 = 0;
        goto L63
    L43:
        r9 = r2;
        goto L63
    L44:
        List<? extends com.bytedance.android.ec.model.l> r16 = this.p.b;
        if (r16 == null) goto L62;
        Iterator<? extends com.bytedance.android.ec.model.l> r17 = r16.iterator();
        int r7 = 0;
    L48:
        if (r17.hasNext() == false) goto L62;
        com.bytedance.android.ec.model.l r8 = r17.next();
        if ((r8 instanceof g0) == true) goto L52;
        r8 = null;
    L52:
        g0 r18 = (g0) r8;
        if (r18 == null) goto L57;
        q r19 = r18.p;
        if (r19 == null) goto L57;
        String r20 = r19.c;
    L59:
        if (Intrinsics.areEqual(r20, r10) == true) goto L60;
        r7 = r7 + 1;
        goto L48
    L60:
        r9 = r7;
    L57:
        r20 = null;
    L62:
        r9 = -1;
        goto L63
    L10:
        if (r10.length() == 0) goto L13;
        r11 = false;
    L63:
        if (r9 >= 0) goto L65;
        return;
    L65:
        int r21 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r9, 0), this.p.getItemCount() - 1);
        if (r21 < 0) goto L75;
        V90().scrollToPosition(r21);
        return;
    }

    public final void la0(String r8, com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r9) {
        i0 r0 = this.K;
        String r1 = null;
        if (r0 == null) goto L13;
        GalleryVO r2 = r0.s0();
        if (r2 == null) goto L13;
        GalleryPendants r3 = r2.getPendants();
        if (r3 == null) goto L13;
        GalleryConfig r4 = r3.getConfig();
        if (r4 == null) goto L13;
        Map r5 = r4.getVisibility();
        if (r5 == null) goto L13;
        GallerySliceVisibilityConfig r6 = (GallerySliceVisibilityConfig) r5.get(r8);
    L14:
        if (r6 == null) goto L16;
        boolean r7 = da0(r6, this.h);
    L17:
        if (r9 != null) goto L19;
        return;
    L19:
        if (r9.e == r7) goto L46;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r10 = ha0();
        if (r10 == null) goto L27;
        ConcurrentHashMap r11 = r10.a;
        if (r11 == null) goto L27;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c r12 = (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r11.get(r8);
        if (r12 == null) goto L27;
        r12.e = r7;
    L27:
        String r13 = r9.c;
        String r14 = "1";
        if (r13 == null) goto L33;
        if (r7 == false) goto L33;
        if (Intrinsics.areEqual(this.G.get(r13), Boolean.TRUE) == false) goto L33;
        this.G.put(r13, Boolean.FALSE);
        Object r15 = "1";
    L34:
        ti.l r16 = r9.b;
        if (r16 == null) goto L47;
        JSONObject r17 = new JSONObject();
        i0 r18 = this.K;
        if (r18 == null) goto L39;
        r1 = r18.getSessionId();
    L39:
        KtSafeMethodExtensionKt.safePut(r17, "session_id", r1);
        if (r7 == true) goto L43;
        r14 = "0";
    L43:
        KtSafeMethodExtensionKt.safePut(r17, "visible", r14);
        KtSafeMethodExtensionKt.safePut(r17, "first_show", r15);
        KtSafeMethodExtensionKt.safePut(r17, "component_name", r9.c);
        Unit r19 = Unit.INSTANCE;
        r16.sendJsEvent("pdp_gallery_lynx_pendant_visible_status", r17);
        return;
    L47:
        return;
    L33:
        r15 = "0";
        goto L34
    L46:
        return;
    L16:
        r7 = false;
    L13:
        r6 = null;
        goto L14
    }

    public final void ma0(List<q> r7, List<c0> r8) {
        Intrinsics.checkNotNullParameter(r7, "galleryList");
        Intrinsics.checkNotNullParameter(r8, "groupList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L41;
        q r1 = (q) r9.next();
        N.getClass();
        Integer r2 = b.a(r1);
        if (r2 == null) goto L4;
        int r3 = r2.intValue();
        g0 r4 = new g0();
        ((com.bytedance.android.ec.model.k) r4).a = r3;
        ECUrlModel r5 = r1.a;
        Integer r6 = null;
        if (r5 == null) goto L10;
        String r10 = r5.getFirstUrl();
    L11:
        ((com.bytedance.android.ec.model.k) r4).b = r10;
        ECUrlModel r11 = r1.a;
        if (r11 == null) goto L14;
        Integer r12 = Integer.valueOf(r11.getWidth());
    L15:
        ((com.bytedance.android.ec.model.k) r4).g = r12;
        ECUrlModel r13 = r1.a;
        if (r13 == null) goto L18;
        Integer r14 = Integer.valueOf(r13.getHeight());
    L19:
        ((com.bytedance.android.ec.model.k) r4).h = r14;
        ((com.bytedance.android.ec.model.k) r4).l = r1.g;
        ((com.bytedance.android.ec.model.k) r4).m = r1.b;
        ((com.bytedance.android.ec.model.k) r4).k = r1.e;
        if (r3 != 2) goto L40;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r15 = r1.d;
        if (r15 == null) goto L24;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r16 = r15.getPlayInfo();
    L25:
        if (r16 == null) goto L27;
        String r17 = r16.e();
    L28:
        ((com.bytedance.android.ec.model.k) r4).b = r17;
        if (r16 == null) goto L31;
        String r18 = r16.f();
    L32:
        ((com.bytedance.android.ec.model.k) r4).f = r18;
        if (r16 == null) goto L35;
        Integer r19 = r16.l();
    L36:
        ((com.bytedance.android.ec.model.k) r4).g = r19;
        if (r16 == null) goto L39;
        r6 = r16.c();
    L39:
        ((com.bytedance.android.ec.model.k) r4).h = r6;
        goto L40
    L35:
        r19 = null;
        goto L36
    L31:
        r18 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    L24:
        r16 = null;
    L40:
        r4.p = r1;
        r4.o = r1.d;
        r4.q = r1.i;
        r0.add(r4);
        goto L4
    L18:
        r14 = null;
        goto L19
    L14:
        r12 = null;
        goto L15
    L10:
        r10 = null;
        goto L11
    L41:
        this.p.b = r0;
        ia0().setData(r8);
        this.D = r8;
        this.C = r0;
        Iterator r20 = r0.iterator();
        int r21 = 0;
    L43:
        if (r20.hasNext() == false) goto L51;
        if (((com.bytedance.android.ec.model.k) r20.next()).getType() != 7) goto L47;
        boolean r22 = true;
    L48:
        if (r22 == true) goto L52;
        r21 = r21 + 1;
    L52:
        this.u = r21;
        this.p.a = 1;
        return;
    L47:
        r22 = false;
        goto L48
    L51:
        r21 = -1;
        goto L52
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onPageSelected(final int r14, boolean r15) {
        ia0().onPageSelected(r14);
        LinearLayout r0 = this.y;
        if ((r0 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) == true) goto L5;
        LinearLayout r1 = null;
    L6:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r2 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d) r1;
        final boolean r3 = false;
        if (r2 == null) goto L12;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f r4 = r2.w;
        String r5 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.y;
        if (r4.wW(r5, Integer.valueOf(r14)) == false) goto L21;
        r2.w.Bt(r5);
    L21:
        if (this.u < 0) goto L34;
        List<? extends com.bytedance.android.ec.model.l> r6 = this.p.b;
        if (r6 == null) goto L25;
        int r7 = r6.size();
    L26:
        int r8 = this.u;
        if (r8 != (-1)) goto L29;
        int r9 = r7;
    L30:
        if (r14 >= r8) goto L32;
        Pair r10 = new Pair(Integer.valueOf(r14), Integer.valueOf(r9));
    L33:
        aa0().setCurrentPos(((Number) r10.getFirst()).intValue());
        aa0().setCount(((Number) r10.getSecond()).intValue());
        goto L34
    L32:
        r10 = new Pair(Integer.valueOf(r14 - r8), Integer.valueOf(r7 - r9));
        goto L33
    L29:
        r9 = r8;
        goto L30
    L25:
        r7 = 0;
    L34:
        q r11 = fa0(r14);
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L43;
        IndexIndicator r12 = aa0();
        r12.getClass();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r12.setPadding(vf4.a.b(5), 0, vf4.a.b(5), 0);
        r13.rightMargin = vf4.a.b(16);
        r13.bottomMargin = vf4.a.b(62);
        r13.gravity = 85;
        Unit r16 = Unit.INSTANCE;
        r12.setLayoutParams(r13);
        IndexIndicator r17 = aa0();
        g0 r18 = ga0(r14);
        if (r18 == null) goto L41;
        int r19 = 8;
        if (r18.getType() != 8) goto L41;
    L42:
        r17.setVisibility(r19);
    L41:
        r19 = 0;
    L43:
        final GalleryLayerItemStateManager r20 = this.x;
        if (r20 == null) goto L64;
        r20.o = r14;
        if (r20.p == false) goto L64;
        if (r20.m <= 0) goto L62;
        List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b> r21 = r20.i;
        final ArrayList r22 = new ArrayList();
        Iterator r23 = ((ArrayList) r21).iterator();
    L51:
        if (r23.hasNext() == false) goto L59;
        Object r24 = r23.next();
        if (((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.b) r24).b.d != 1) goto L55;
        boolean r25 = true;
    L56:
        if (r25 == false) goto L51;
        r22.add(r24);
        goto L51
    L55:
        r25 = false;
        goto L56
    L59:
        if ((!r22.isEmpty()) == false) goto L62;
        r20.g = GalleryLayerItemStateManager.i(r20, r20.g, 0.0f, 0.0f, false, new GalleryLayerItemStateManager$updateAlphaOnScroll$$inlined$also$lambda$1(r22, r20, r3, r14), 6);
    L62:
        if (((RecyclerView) r20.r.invoke()).getScrollState() != 0) goto L64;
        r20.j(r20.i);
    L64:
        w0 r26 = this.w;
        String r27 = "";
        if (r26 == null) goto L72;
        if (r11 == null) goto L68;
        String r28 = r11.c;
    L69:
        if (r28 != null) goto L71;
        r28 = "";
    L71:
        r26.c(r28);
        goto L72
    L68:
        r28 = null;
    L72:
        Integer r29 = this.v;
        if (r29 != null) goto L75;
    L76:
        if (r15 == false) goto L94;
    L77:
        i0 r30 = this.K;
        if (r30 == null) goto L80;
        r30.e(r14, r11, false);
    L80:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r31 = this.B;
        if (r31 == null) goto L94;
        m r32 = r31.g;
        if (r32 == null) goto L94;
        if (r11 == null) goto L88;
        c0 r33 = r11.m;
        if (r33 == null) goto L88;
        String r34 = r33.d;
    L89:
        Pair[] r35 = new Pair[3];
        r35[0] = TuplesKt.to("item_order", Integer.valueOf(r14 + 1));
        r35[1] = TuplesKt.to("enter_method_pic", "main_picture");
        if (r34 == null) goto L93;
        r27 = r34;
    L93:
        r35[2] = TuplesKt.to("type", r27);
        m.d(r32, "slide_product_big_picture", MapsKt.mutableMapOf(r35), null, null, 60);
    L88:
        r34 = null;
    L94:
        this.v = Integer.valueOf(r14);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r36 = this.B;
        if (r36 == null) goto L144;
        r36.f.setSelectedPosition(r14);
        List<c0> r37 = r36.c;
        if (r37 != null) goto L100;
        r37 = CollectionsKt.emptyList();
    L100:
        if (r37.isEmpty() == false) goto L102;
        c0 r38 = null;
    L110:
        if (r38 == null) goto L144;
        GalleryViewModel r39 = r36.f;
        Integer r40 = Integer.valueOf(r38.a);
        int r41 = r38.a;
        int r42 = r38.b + r41;
        List r43 = (List) r36.f.getFullThumbList().getValue();
        if (r43 != null) goto L114;
        r43 = CollectionsKt.emptyList();
    L114:
        ArrayList r44 = new ArrayList();
        boolean r45 = false;
        boolean r110 = false;
    L115:
        if (r41 >= r42) goto L123;
        s r111 = (s) CollectionsKt.getOrNull(r43, r41);
        if (r111 == null) goto L122;
        r44.add(r111);
        if (r111.d == false) goto L121;
        r45 = true;
        goto L122
    L121:
        r110 = true;
    L122:
        r41 = r41 + 1;
        goto L115
    L123:
        if (r45 == false) goto L126;
        if (r110 == false) goto L126;
        boolean r46 = true;
    L127:
        Iterator r47 = r44.iterator();
    L129:
        if (r47.hasNext() == false) goto L142;
        s r48 = (s) r47.next();
        if (r46 == true) goto L133;
    L140:
        String r49 = r48.e;
    L141:
        r48.getClass();
        Intrinsics.checkNotNullParameter(r49, "<set-?>");
        r48.a = r49;
        goto L129
    L133:
        if (r48.d == false) goto L140;
        if (r48.e.length() != 0) goto L137;
        boolean r50 = true;
    L138:
        if (r50 == false) goto L140;
        r49 = "视频";
        goto L141
    L137:
        r50 = false;
        goto L138
    L142:
        r39.setThumbList(r40, r44);
    L126:
        r46 = false;
        goto L127
    L102:
        Iterator<T> r51 = r37.iterator();
    L104:
        if (r51.hasNext() == false) goto L108;
        Object r52 = r51.next();
        if (f0.b(r14, (c0) r52) == false) goto L104;
    L109:
        r38 = (c0) r52;
        goto L110
    L108:
        r52 = null;
    L144:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.c() == false) goto L165;
        Iterator r53 = com.bytedance.commerce.base.view.b.a(V90()).iterator();
    L147:
        if (r53.hasNext() == false) goto L154;
        RecyclerView.ViewHolder r54 = V90().findContainingViewHolder((View) r53.next());
        if ((r54 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L151;
        r54 = null;
    L151:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r55 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r54;
        if (r55 == null) goto L147;
        r55.onPageSelected(r14);
        goto L147
    L154:
        g0 r56 = ga0(r14);
        if (r56 == null) goto L165;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r57 = r56.o;
        if (r57 == null) goto L165;
        if (r57.getPlayInfo() == null) goto L165;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r58 = this.B;
        if (r58 == null) goto L165;
        m r59 = r58.g;
        if (r59 == null) goto L165;
        m.d(r59, "pd_video_show", r59.b(r14), String.valueOf(r14), null, 36);
    L165:
        if (r15 == true) goto L174;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.e r112 = ha0();
        if (r112 == null) goto L196;
        ConcurrentHashMap r113 = r112.a;
        if (r113 == null) goto L197;
        Iterator r114 = r113.entrySet().iterator();
    L172:
        if (r114.hasNext() == false) goto L198;
        Map.Entry r115 = (Map.Entry) r114.next();
        la0((String) r115.getKey(), (com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.c) r115.getValue());
        goto L172
    L198:
        return;
    L197:
        return;
    L196:
        return;
    L174:
        return;
    L75:
        if (r29.intValue() != r14) goto L77;
    L12:
        if ((r0 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c) == true) goto L14;
        r0 = null;
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c r60 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c) r0;
        if (r60 == null) goto L21;
        if (r60.d.wW("bottom_left_find_same", Integer.valueOf(r14)) == false) goto L19;
        r60.setVisibility(0);
        r60.d.Bt("bottom_left_find_same");
        goto L21
    L19:
        ExtensionsKt.gone(r60);
        goto L21
    L5:
        r1 = r0;
        goto L6
    }

    public final void onViewCreated(View r26, Bundle r27) {
        Intrinsics.checkNotNullParameter(r26, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r26, r27);
        this.A = true;
        GalleryLayerItemStateManager r3 = this.x;
        if (r3 == null) goto L5;
        GalleryViewModel r4 = ja0();
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        r3.d = r4;
    L5:
        FragmentActivity r5 = getActivity();
        GalleryAdapter r6 = null;
        if ((r5 instanceof FullScreenGalleryDialogActivity) == true) goto L8;
        r5 = null;
    L8:
        FullScreenGalleryDialogActivity r7 = (FullScreenGalleryDialogActivity) r5;
        if (r7 == null) goto L11;
        GalleryViewerParams r8 = r7.k;
    L13:
        if (r8 != null) goto L15;
    L22:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r9 = this.B;
        if (r9 == null) goto L51;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a == false) goto L51;
        final t r11 = new t(r9, W90(), new GalleryFragment$onViewCreated$$inlined$also$lambda$1(this));
        RecyclerView r10 = V90();
        Intrinsics.checkNotNullParameter(r10, "pager");
        List<s> r12 = (List) r11.d.f.getThumbList().getValue();
        if (r12 != null) goto L29;
        r12 = CollectionsKt.emptyList();
    L29:
        final List<s> r13 = r11.f(r12);
        FrameLayout r14 = r11.e;
        final EdgeGradientFrameLayout r15 = new EdgeGradientFrameLayout(r11.e.getContext(), null, 6, 0);
        r11.a = r15;
        if (((ArrayList) r13).isEmpty() == false) goto L32;
        r15.setVisibility(8);
    L32:
        r15.setPadding(0, com.bytedance.android.shopping.extensions.b.a(2), 0, com.bytedance.android.shopping.extensions.b.a(12));
        final RecyclerView r16 = new RecyclerView(r15.getContext());
        r11.b = r16;
        r16.setOverScrollMode(2);
        r16.setLayoutManager(new LinearLayoutManager(r15.getContext(), 0, false));
        r16.setAdapter(new p0(r13, r11.d, new GalleryMoreVideoManager$setupMoreVideoView$$inlined$also$lambda$1(r16, r15, r11, r13)));
        Unit r1 = Unit.INSTANCE;
        r15.addView(r16, new ViewGroup.LayoutParams(-1, -2));
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        r2.gravity = 80;
        r2.leftMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r2.rightMargin = com.bytedance.android.shopping.extensions.b.a(16);
        r14.addView(r15, r2);
        EdgeGradientFrameLayout r17 = r11.a;
        if (r17 == null) goto L35;
        r17.addOnLayoutChangeListener(new z(r11));
    L35:
        RecyclerView r18 = r11.b;
        if (r18 == null) goto L38;
        r18.addOnScrollListener(new GalleryMoreVideoManager$setupMoreVideoView$4(r11));
    L38:
        RecyclerView r19 = r11.b;
        if (r19 == null) goto L41;
        r19.post(new a0(r11));
    L41:
        RecyclerView r20 = r11.b;
        if (r20 == null) goto L44;
        r20.setVisibility(4);
    L44:
        r11.d.f.isMoreVideoExpanded().observe(r11.d.e, new v(r11));
        r11.d.f.getBottomBarHeight().observe(r11.d.e, new w(r11));
        r11.d.f.getSelectedPosition().observe(r11.d.e, new x(r11));
        r11.d.f.getThumbList().observe(r11.d.e, new y(r11));
        EdgeGradientFrameLayout r21 = r11.a;
        if (r21 == null) goto L49;
        GalleryLayerItemStateManager r22 = r11.d.i;
        if (r22 == null) goto L49;
        r22.c(new u(r21, new m0(true, true, false, 0, false, 52), r11));
    L49:
        r10.addOnScrollListener(new GalleryMoreVideoManager$watchPagerScroll$1(r11));
    L51:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L53;
    L161:
        m r110 = this.s;
        r110.getClass();
        r110.c = Long.valueOf(System.currentTimeMillis());
        m.d(r110, "pdp_big_picture_show", null, null, "a1.b34986.c0.d0", 30);
        GalleryAdapter r23 = this.p;
        if ((r23 instanceof GalleryCompatAdapter) == false) goto L165;
        r6 = r23;
    L165:
        GalleryCompatAdapter r24 = (GalleryCompatAdapter) r6;
        if (r24 == null) goto L169;
        r24.e = this;
    L169:
        if (this.L == null) goto L171;
        ja0().getEnterAnimStatus().observe(getViewLifecycleOwner(), new j(this));
    L172:
        Context r25 = r26.getContext();
        i0 r28 = this.K;
        if (r28 == null) goto L186;
        GalleryVO r29 = r28.s0();
        if (r29 == null) goto L187;
        GalleryConfig r30 = r29.getConfig();
        if (r30 != null) goto L179;
        return;
    L179:
        if (r30.getEnableScreenShot() != true) goto L189;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r31 = this.B;
        if (r31 != null) goto L183;
        return;
    L183:
        if (r31.a() != true) goto L191;
        this.I = new ScreenCaptureManager(r25, this.K.p0(), PageFinder.via(this), new o(this));
        return;
    L191:
        return;
    L189:
        return;
    L187:
        return;
    L186:
        return;
    L171:
        onPageSelected(this.h, false);
        goto L172
    L53:
        if (this.K == null) goto L161;
        final w0 r32 = new w0(requireActivity(), this.x, this.B, new k(this));
        this.w = r32;
        final v0 r33 = r32.a;
        r33.getClass();
        SlcGeckoTemplateMgr r34 = SlcGeckoTemplateMgr.l;
        FragmentActivity r35 = r33.f;
        r34.getClass();
        r33.b = SlcGeckoTemplateMgr.e(r35, "pdp");
        FragmentActivity r36 = r33.f;
        com.bytedance.android.ecom.arch.slice.adapter.e r37 = new com.bytedance.android.ecom.arch.slice.adapter.e(1000);
        SlcExprContext r111 = new SlcExprContext(0);
        FragmentActivity r112 = r33.f;
        ActionContext r113 = new ActionContext(r112, r112.getSupportFragmentManager(), r33.d);
        ActionContext r114 = r33.h;
        if (r114 == null) goto L57;
        Intrinsics.checkNotNullParameter(r114, "from");
        r113.a.putAll(r114.a);
    L57:
        Unit r115 = Unit.INSTANCE;
        SlcContext r116 = new SlcContext(r36, r113, r37, r111, new com.bytedance.android.ecom.arch.slice.a(), new com.bytedance.android.shopping.anchorv4.voavhs.i(null));
        ((SlcRenderContext) r116).v = 0;
        com.bytedance.android.ecom.slice.ext.template.gecko.c r38 = r33.b;
        if (r38 == null) goto L60;
        r116.o0 = r38;
    L61:
        r33.a = r116;
        final com.bytedance.android.ecom.arch.slice.action.j r39 = r33.c;
        if (r39 == null) goto L66;
        PageFinder r40 = PageFinder.via(r33);
        if (r40 == null) goto L66;
        FragmentActivity r117 = r33.f;
        EventChain r41 = qg3.a.a(r117, "gallery_fragment", new com.bytedance.android.shopping.anchorv4.event_chain.a(r117, r39, r40, r33.e), new com.bytedance.kmp.ec.yata.common.init.c());
        r33.c.b(r41, r39, r33.f);
        r41.g(new com.bytedance.android.shopping.anchorv4.event_chain.custom_event.l(r39, r33.f, null, new SliceEnv$initEventChain$$inlined$apply$lambda$1(r33, r39)));
        r41.g(new id3.a(r39, r33.f, new SliceEnv$initEventChain$$inlined$apply$lambda$2(r33, r39)));
    L68:
        if (r41 != null) goto L70;
        boolean r42 = false;
    L82:
        if (r42 == false) goto L92;
        SlcContext r43 = r32.a.a;
        if (r43 == null) goto L88;
        com.bytedance.android.ecom.arch.slice.d r44 = r43.v0;
        if (r44 == null) goto L88;
        r44.G("gallery", new SliceViewManager$init$1(r32));
    L88:
        SlcContext r45 = r32.a.a;
        if (r45 == null) goto L92;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r46 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c(r32.g, r45);
        r46.a.addOnLayoutChangeListener(new y0(r32));
        r32.b = r46;
        r32.d = new t0(r32.g, r45, new SliceViewManager$init$$inlined$let$lambda$2(r32));
    L92:
        if (r42 == true) goto L96;
        FragmentActivity r47 = getActivity();
        if (r47 == null) goto L96;
        r47.finish();
    L96:
        w0 r48 = this.w;
        if (r48 == null) goto L104;
        FrameLayout r49 = W90();
        Intrinsics.checkNotNullParameter(r49, "rootView");
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.c r50 = r48.b;
        if (r50 == null) goto L101;
        LinearLayout r51 = r50.a;
        FrameLayout.LayoutParams r52 = new FrameLayout.LayoutParams(-1, -2);
        r52.gravity = 80;
        r49.addView(r51, r52);
    L101:
        t0 r53 = r48.d;
        if (r53 == null) goto L104;
        r49.addView(r53.a, new FrameLayout.LayoutParams(-1, -1));
    L104:
        w0 r54 = this.w;
        if (r54 == null) goto L107;
        r54.b(this.K.s0());
    L107:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c r55 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.J.getValue();
        w0 r56 = this.w;
        if (r56 == null) goto L110;
        SlcContext r57 = r56.a.a;
    L111:
        r55.b = r57;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.a() == false) goto L114;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.event.c) this.J.getValue()).c = new h(this);
    L114:
        i0 r58 = this.K;
        GalleryVO r59 = r58.s0();
        if (r59 == null) goto L123;
        GalleryPendants r60 = r59.getPendants();
        if (r60 == null) goto L123;
        PendantContainer r61 = r60.getLynxs();
        if (r61 == null) goto L123;
        PendantContainerVO.Companion.getClass();
        Pair r62 = PendantContainerVO.Companion.b(PendantContainerVO.Companion.c(r61));
        if (r62 == null) goto L123;
        PendantContainerVO r63 = (PendantContainerVO) r62.component1();
        this.H = (PendantContainerVO) r62.component2();
        ca0(r63, r58);
    L123:
        ja0().getPendantContainerState().observe(getViewLifecycleOwner(), new l(this));
        int r64 = f0.a;
        int r65 = pi3.a.a;
        long r66 = com.bytedance.android.ec.sdk.helper.q.a.getLong("anchor_v4_find_similar_button_last_show_time", -1);
        long r67 = System.currentTimeMillis() / ((long) 1000);
        if (r66 > 0) goto L126;
    L128:
        boolean r68 = true;
    L129:
        if (r68 == false) goto L134;
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d r69 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d(requireActivity(), this);
        FrameLayout r70 = W90();
        FrameLayout.LayoutParams r71 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.x);
        r71.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r70.addView(r69, r71);
        GalleryLayerItemStateManager r72 = this.x;
        if (r72 == null) goto L133;
        r72.c(r69.getLayerItem());
    L133:
        r69.setOnClickListener(new f(this));
        this.y = r69;
    L138:
        IndexIndicator r73 = aa0();
        r73.setTextColor(1946157055);
        ViewGroup.LayoutParams r74 = r73.getLayoutParams();
        if ((r74 instanceof FrameLayout.LayoutParams) == true) goto L141;
        r74 = null;
    L141:
        FrameLayout.LayoutParams r75 = (FrameLayout.LayoutParams) r74;
        if (r75 == null) goto L148;
        r75.gravity = 8388661;
        int r76 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.m.n;
        b r77 = N;
        Context r78 = r73.getContext();
        r77.getClass();
        Intrinsics.checkNotNullParameter(r78, "context");
        Integer r79 = M;
        if (r79 == null) goto L146;
        int r80 = r79.intValue();
    L147:
        r75.topMargin = (r76 + r80) + com.bytedance.android.shopping.extensions.b.a(20);
        r75.rightMargin = com.bytedance.android.shopping.extensions.b.a(20);
        r73.setLayoutParams(r75);
        goto L148
    L146:
        r80 = eh.b.b(r78);
        M = Integer.valueOf(r80);
    L148:
        aa0().setDisableUpdateVisibilityInternal(true);
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r81 = this.B;
        if (r81 != null) goto L151;
    L153:
        GalleryLayerItemStateManager r82 = this.x;
        if (r82 == null) goto L156;
        r82.c(new i(this, aa0(), new m0(true, true, false, 1, false, 52)));
    L156:
        View r84 = ia0().b();
        if (r84 == null) goto L161;
        GalleryLayerItemStateManager r85 = this.x;
        if (r85 == null) goto L161;
        r85.c(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d(r84, false, false, false, 16));
        goto L161
    L151:
        if (r81.b() != true) goto L153;
        aa0().setVisibility(8);
        goto L156
    L134:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c r86 = new com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c(requireActivity(), this);
        FrameLayout r87 = W90();
        FrameLayout.LayoutParams r88 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.c.e);
        r88.leftMargin = com.bytedance.android.shopping.extensions.b.a(12);
        r87.addView(r86, r88);
        GalleryLayerItemStateManager r89 = this.x;
        if (r89 == null) goto L137;
        r89.c(r86.getLayerItem());
    L137:
        r86.setOnClickListener(new g(this));
        ja0().setShowDependsState(ShowDependsOn.GALLERY_FIND_SIMILAR, State.SHOW);
        this.y = r86;
        goto L138
    L126:
        if ((r67 - r66) >= 86400) goto L128;
        r68 = false;
        goto L129
    L110:
        r57 = null;
        goto L111
    L70:
        SlcContext r90 = r33.a;
        if (r90 == null) goto L73;
        r90.o("eventChain", r41);
    L73:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r91 = r33.i;
        if (r91 == null) goto L76;
        r91.l = r41;
    L76:
        SlcContext r92 = r33.a;
        if (r92 == null) goto L81;
        ActionContext r94 = r92.r0;
        if (r94 == null) goto L81;
        u0 r95 = new u0(r33);
        Intrinsics.checkNotNullParameter(r95, "interceptor");
        r94.d = r95;
    L81:
        r42 = true;
    L66:
        r41 = null;
        goto L68
    L60:
        r116.v(true);
        goto L61
    L15:
        if (r8.getGalleryIndex() < this.m.getItemCount()) goto L17;
        int r96 = 0;
    L18:
        Z90(r96);
        V90().scrollToPosition(r8.getGalleryIndex());
        Rect r97 = this.L;
        if (r97 == null) goto L21;
        this.m.setEnterAnimationParams(r8.getGalleryIndex(), r97);
    L21:
        this.m.setOptEnterTransition(true);
        goto L22
    L17:
        r96 = r8.getGalleryIndex();
        goto L18
    L11:
        r8 = null;
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f
    public final boolean wW(String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r4, "componentName");
        i0 r0 = this.K;
        if (r0 == null) goto L11;
        GalleryVO r1 = r0.s0();
        if (r1 == null) goto L11;
        GalleryConfig r2 = r1.getConfig();
        if (r2 == null) goto L11;
        Map r3 = r2.getVisibility();
        if (r3 == null) goto L11;
        GallerySliceVisibilityConfig r6 = (GallerySliceVisibilityConfig) r3.get(r4);
    L13:
        if (r6 == null) goto L30;
        if (r5 == null) goto L16;
        int r7 = r5.intValue();
    L17:
        List r8 = r6.getShow();
        if (r8 != null) goto L20;
    L22:
        List r9 = r6.getHide();
        if (r9 != null) goto L25;
        return false;
    L25:
        if ((!r9.isEmpty()) == true) goto L27;
        return false;
    L27:
        if (r6.getHide().contains(Integer.valueOf(r7)) == true) goto L34;
        return true;
    L34:
        return false;
    L20:
        if ((!r8.isEmpty()) != true) goto L22;
        return r6.getShow().contains(Integer.valueOf(r7));
    L16:
        r7 = this.h;
        goto L17
    L30:
        return false;
    L11:
        r6 = null;
        goto L13
    }

    public final void ka0(q r8, m r9, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r0 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "a1.b8094.c86220.d94403", PageFinder.via(this), null, 4, null);
        ECUrlModel r1 = r8.a;
        String r2 = null;
        if (r1 == null) goto L9;
        List r3 = r1.getUrlList();
        if (r3 == null) goto L9;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
    L10:
        String r5 = r8.e;
        int r6 = 1;
        if (r5 != null) goto L41;
        i0 r7 = this.K;
        if (r7 == null) goto L39;
        GalleryVO r11 = r7.s0();
        if (r11 == null) goto L39;
        com.bytedance.android.shopping.anchorv4.dto.business.b r12 = r11.getMeta();
        if (r12 == null) goto L39;
        r5 = r12.a();
        if (r5 == null) goto L39;
        if (r8.i == null) goto L24;
    L26:
        boolean r13 = false;
    L27:
        if (r13 != true) goto L31;
        ECUrlModel r14 = r8.a;
        if (r14 == null) goto L36;
        String r15 = r14.getFirstUrl();
    L37:
        if (r15 == null) goto L41;
        r5 = com.bytedance.android.ec.core.utils.p0.d(r5, "search_image_url", r15);
    L36:
        r15 = null;
        goto L37
    L31:
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r16 = r8.d;
        if (r16 == null) goto L36;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r17 = r16.getPlayInfo();
        if (r17 == null) goto L36;
        r15 = r17.f();
        goto L37
    L24:
        if (r8.d != null) goto L26;
        r13 = true;
    L39:
        r5 = null;
    L41:
        if (com.bytedance.android.shopping.extensions.k.c(r8.b) == false) goto L44;
        r6 = 2;
    L44:
        if (r8.d == null) goto L46;
        String r18 = "video";
    L48:
        if (Intrinsics.areEqual(r10, "top_right_find_same") == false) goto L52;
        String r19 = "1";
    L50:
        r2 = r19;
    L54:
        Activity r110 = ECAppInfoService.e.getCurrentActivity();
        if (r110 != null) goto L57;
        return;
    L57:
        if (we.a.a == false) goto L63;
        if (r5 == null) goto L70;
        Uri.Builder r20 = UriProtector.parse(r5).buildUpon();
        r20.appendQueryParameter("identifier", AnchorV4DataManager.d);
        com.bytedance.android.ec.sdk.helper.p.a.d(com.bytedance.android.ec.core.btm.c.d(r20.build().toString(), r0), r110);
        if (r9 == null) goto L71;
        r9.c(r6, r18, r2);
        return;
    L71:
        return;
    L70:
        return;
    L63:
        if (r4 == null) goto L65;
        com.bytedance.android.ec.sdk.helper.h.a.a(r110, r4, new n(r9));
        return;
    L65:
        if (r5 == null) goto L74;
        Uri.Builder r21 = UriProtector.parse(r5).buildUpon();
        r21.appendQueryParameter("identifier", AnchorV4DataManager.d);
        com.bytedance.android.ec.sdk.helper.p.a.d(com.bytedance.android.ec.core.btm.c.d(r21.build().toString(), r0), r110);
        if (r9 == null) goto L75;
        r9.c(r6, r18, r2);
        return;
    L75:
        return;
    L74:
        return;
    L52:
        if (Intrinsics.areEqual(r10, "bottom_left_find_same") == false) goto L54;
        r19 = "2";
        goto L50
    L46:
        r18 = "image";
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.L == null) goto L6;
        this.i = true;
    L6:
        return super.onCreateView(r2, r3, r4);
    }
}
