package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewHolderBuilder;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryDialogFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryViewerCompat;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.TransSmallComponent;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeadScrollStateManager;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SlidesAndIndicatorV4Component implements d83.b {
    public static final /* synthetic */ int I = 0;
    public final g A;
    public final d83.a B;
    public final c63.b C;
    public final d83.d D;
    public final Function0<AnchorV4VM> E;
    public final Function0<SlcRenderContext> F;
    public final View G;
    public final View H;
    public com.bytedance.android.shopping.anchorv4.containers.e a;
    public com.bytedance.android.shopping.anchorv4.containers.i b;
    public g83.a c;
    public l d;
    public AnchorV4HeadViewPager e;
    public f83.k f;
    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> g;
    public List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> h;
    public CommonFindSameElement i;
    public boolean j;
    public AnchorV4HeadIndicator k;
    public AnchorV4DownTabIndicator l;
    public View m;
    public final u n;
    public final Lazy o;
    public boolean p;
    public TransSmallComponent q;
    public Integer r;
    public final t s;
    public l53.b t;
    public final Lazy u;
    public final FrameLayout v;
    public final FrameLayout w;
    public final FrameLayout x;
    public final c63.d y;
    public final o z;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i {
        public final /* synthetic */ SlidesAndIndicatorV4Component a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Map<String, Object> d() {
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String c() {
            int r0 = t0.a;     // Catch: Exception -> L8
            Gson r1 = t0.a.b;     // Catch: Exception -> L8
            AnchorV4VM r2 = (AnchorV4VM) this.a.E.invoke();     // Catch: Exception -> L8
            if (r2 == null) goto L5;
            Map r3 = r2.getEventParams();     // Catch: Exception -> L8
        L6:
            return r1.toJson(r3);
        L5:
            r3 = null;
        L8:
            e = move-exception;
            ECExceptionMonitor.e(e);
            return "";
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String e() {
            SlidesAndIndicatorV4Component r0 = this.a;
            if (r0.e == null) goto L20;
            List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r1 = r0.h;
            Intrinsics.checkNotNullParameter(r1, "displayData");
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            Object r3 = r2.next();
            if (((com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) ((Pair) r3).getFirst()).h == false) goto L6;
        L11:
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r5 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r4.getFirst();
            if (r5 != null) goto L16;
            return null;
        L16:
            return r5.j;
        L21:
            return null;
        L10:
            r3 = null;
            goto L11
        L20:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String f() {
            AnchorV4VM r0 = (AnchorV4VM) this.a.E.invoke();
            if (r0 == null) goto L7;
            CommonMeta r1 = r0.commonMeta();
            if (r1 == null) goto L7;
            return r1.getProductId();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Float h() {
            SlidesAndIndicatorV4Component r0 = this.a;
            if (r0.e == null) goto L20;
            List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r1 = r0.h;
            Intrinsics.checkNotNullParameter(r1, "displayData");
            Iterator<T> r2 = r1.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            Object r3 = r2.next();
            if (((com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) ((Pair) r3).getFirst()).h == false) goto L6;
        L11:
            Pair r4 = (Pair) r3;
            if (r4 == null) goto L21;
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r5 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r4.getFirst();
            if (r5 != null) goto L16;
            return null;
        L16:
            return r5.i;
        L21:
            return null;
        L10:
            r3 = null;
            goto L11
        L20:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Boolean g() {
            return Boolean.FALSE;
        }

        public b(SlidesAndIndicatorV4Component r1) {
            this.a = r1;
        }
    }

    public static final class c implements OnPageSelectedListener {
        public final /* synthetic */ AnchorV4GalleryDialogFragment a;
        public final /* synthetic */ SlidesAndIndicatorV4Component b;

        public final void onPageSelected(int r8) {
            AnchorV4HeadViewPager r0 = this.b.e;
            if (r0 == null) goto L5;
            Pair<Integer, Integer> r1 = r0.k(r8);
        L6:
            if (r1 == null) goto L8;
            Integer r2 = (Integer) r1.getFirst();
        L9:
            AnchorV4HeadViewPager r3 = this.b.e;
            if (r3 == null) goto L12;
            Integer r4 = Integer.valueOf(r3.getCurrentItem());
        L14:
            if ((!Intrinsics.areEqual(r2, r4)) == false) goto L23;
            c63.d r5 = this.b.y;
            AnchorV4GalleryDialogFragment r6 = this.a;
            String r7 = (String) ((HashMap) r6.r.e).get(Integer.valueOf(r8));
            if (com.bytedance.android.shopping.extensions.k.c(r7) == true) goto L22;
            String r9 = (String) ((HashMap) r6.r.d).get(Integer.valueOf(r8));
            if (r9 != null) goto L21;
            r9 = "0";
        L21:
            int r10 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a;
            Intrinsics.checkNotNullParameter(r9, "titleType");
            r7 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J.get(Integer.valueOf(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r9)));
        L22:
            r5.H(r8, r7);
        L23:
            if (r1 == null) goto L29;
            AnchorV4HeadViewPager r11 = this.b.e;
            if (r11 == null) goto L27;
            r11.setCurrentItem(((Number) r1.getFirst()).intValue());
        L27:
            this.b.D.a(true, (Integer) r1.getFirst(), null);
            e83.a r12 = e83.a.d;
            ((Number) r1.getSecond()).intValue();
            e83.b r13 = new e83.b();
            r12.getClass();
            e83.a.c(r13);
            return;
        L29:
            return;
        L12:
            r4 = null;
            goto L14
        L8:
            r2 = null;
            goto L9
        L5:
            r1 = null;
            goto L6
        }

        public c(AnchorV4GalleryDialogFragment r1, SlidesAndIndicatorV4Component r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements OnPageSelectedListener {
        public final /* synthetic */ AnchorV4GalleryViewerCompat a;
        public final /* synthetic */ SlidesAndIndicatorV4Component b;

        public final void onPageSelected(int r7) {
            AnchorV4HeadViewPager r0 = this.b.e;
            if (r0 == null) goto L5;
            Pair<Integer, Integer> r1 = r0.k(r7);
        L6:
            if (r1 == null) goto L8;
            Integer r2 = (Integer) r1.getFirst();
        L9:
            AnchorV4HeadViewPager r3 = this.b.e;
            if (r3 == null) goto L12;
            Integer r4 = Integer.valueOf(r3.getCurrentItem());
        L14:
            if ((!Intrinsics.areEqual(r2, r4)) == false) goto L19;
            c63.d r5 = this.b.y;
            String r6 = (String) ((HashMap) this.a.d.d).get(Integer.valueOf(r7));
            if (r6 != null) goto L18;
            r6 = "0";
        L18:
            int r8 = com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.g.a;
            Intrinsics.checkNotNullParameter(r6, "titleType");
            r5.H(r7, com.bytedance.android.shopping.anchorv4.voavhs.head.c.J.get(Integer.valueOf(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r6))));
        L19:
            if (r1 == null) goto L25;
            AnchorV4HeadViewPager r9 = this.b.e;
            if (r9 == null) goto L23;
            r9.setCurrentItem(((Number) r1.getFirst()).intValue());
        L23:
            this.b.D.a(true, (Integer) r1.getFirst(), null);
            e83.a r10 = e83.a.d;
            ((Number) r1.getSecond()).intValue();
            e83.b r11 = new e83.b();
            r10.getClass();
            e83.a.c(r11);
            return;
        L25:
            return;
        L12:
            r4 = null;
            goto L14
        L8:
            r2 = null;
            goto L9
        L5:
            r1 = null;
            goto L6
        }

        public d(AnchorV4GalleryViewerCompat r1, SlidesAndIndicatorV4Component r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements OnDismissListener {
        public final /* synthetic */ SlidesAndIndicatorV4Component a;

        public e(SlidesAndIndicatorV4Component r1) {
            this.a = r1;
        }

        public final void onDismiss(int r2) {
            SlidesAndIndicatorV4Component r3 = this.a;
            r3.p = false;
            r3.A.a(false);
            AnchorV4VM r4 = (AnchorV4VM) this.a.E.invoke();
            if (r4 == null) goto L8;
            HeadScrollStateManager r5 = r4.getHeadScrollStateManager();
            if (r5 == null) goto L9;
            int r0 = HeadScrollStateManager.n;
            r5.l(null);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public SlidesAndIndicatorV4Component() {
        throw null;
    }

    @Override // d83.b
    public final void j(View r1) {
        throw null;
    }

    @Override // d83.b
    public final void onResume() {
    }

    @Override // d83.b
    public final List<ECUrlModel> c() {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTotalNavBlurTabCount();
    }

    @Override // d83.b
    public final void d() {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 == null) goto L15;
        HeadViewHolderBuilder r1 = r0.g;
        if (r1 == null) goto L21;
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.n> r2 = r1.d.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L22;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L12;
        r3 = null;
    L12:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r4 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r3;
        if (r4 == null) goto L8;
        r4.d();
        goto L8
    L22:
        return;
    L21:
        return;
    }

    @Override // d83.b
    public final String f() {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentImageUri();
    }

    @Override // d83.b
    public final boolean g() {
        AnchorV4VM r0 = (AnchorV4VM) this.E.invoke();
        if (r0 == null) goto L7;
        CommonMeta r1 = r0.commonMeta();
        if (r1 == null) goto L7;
        Boolean r2 = Boolean.valueOf(r1.getEnablePDPOptimize());
    L9:
        return com.bytedance.android.shopping.extensions.k.i(r2);
    L7:
        r2 = null;
        goto L9
    }

    @Override // d83.b
    public final boolean i() {
        return this.s.i();
    }

    @Override // d83.b
    public final List<ECUrlModel> k() {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTotalBottomTabCount();
    }

    @Override // d83.b
    public final boolean a() {
        return this.p;
    }

    @Override // d83.b
    public final View e() {
        return this.G;
    }

    @Override // d83.b
    public final View h() {
        return this.m;
    }

    @Override // d83.b
    public final void b(boolean r4) {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 == null) goto L15;
        HeadViewHolderBuilder r1 = r0.g;
        if (r1 == null) goto L21;
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.n> r2 = r1.d.keySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L22;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.n r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) == true) goto L12;
        r3 = null;
    L12:
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.h r5 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.h) r3;
        if (r5 == null) goto L8;
        r5.b(r4);
        goto L8
    L22:
        return;
    L21:
        return;
    }

    public final void m(int r2) {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 != null) goto L5;
    L6:
        AnchorV4HeadViewPager r1 = this.e;
        if (r1 == null) goto L11;
        r1.setCurrentItem(r2);
        return;
    L11:
        return;
    L5:
        if (r0.getCurrentItem() != r2) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.List<kotlin.Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, java.lang.String>>] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList] */
    public final void l(Integer r7, final int r8, final boolean r9) {
        AnchorV4HeadViewPager r0 = this.e;
        if (r0 == null) goto L6;
        List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r1 = r0.getGalleryDisplayData();
        if (r1 == null) goto L6;
    L7:
        this.h = r1;
        if (this.q != null) goto L10;
    L23:
        boolean r2 = true;
        this.p = true;
        this.A.a(true);
        if (r7 != null) goto L30;
        AnchorV4HeadViewPager r10 = this.e;
        if (r10 == null) goto L28;
        r7 = Integer.valueOf(r10.getCurrentItem());
        goto L30
    L28:
        r7 = null;
    L30:
        if (r7 == null) goto L32;
        final int r11 = r7.intValue();
    L33:
        int r4 = -1;
        if (com.bytedance.android.ec.core.opt.ab.c.d() == false) goto L64;
        Fragment r3 = com.bytedance.android.shopping.anchorv4.containers.a.a;
        AnchorV4GalleryDialogFragment r5 = new AnchorV4GalleryDialogFragment(new r(this));
        r5.s = new b(this);
        r5.ca0(this.h);
        r5.f = new c(r5, this);
        r5.g = new SlidesAndIndicatorV4Component$openGalleryViewer$$inlined$apply$lambda$3(this, r11, r8, r9);
        AnchorV4HeadViewPager r6 = this.e;
        if (r6 == null) goto L38;
        int r12 = r6.j(r11, r8);
    L39:
        if (r9 == true) goto L54;
        Iterator<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> r13 = this.h.iterator();
        int r14 = 0;
    L42:
        if (r13.hasNext() == false) goto L47;
        if (((com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r13.next().getFirst()).h == true) goto L45;
        r14 = r14 + 1;
        goto L42
    L45:
        r4 = r14;
    L47:
        if (r12 == r4) goto L50;
        r2 = false;
    L50:
        if (r2 == false) goto L52;
        ViewPager r15 = null;
    L53:
        r5.v = r15;
        goto L54
    L52:
        r15 = this.e;
    L54:
        if (r12 < 0) goto L62;
        ViewPager r16 = this.e;
        if (r16 == null) goto L58;
        Context r17 = r16.getContext();
    L59:
        if (r17 == null) goto L63;
        int r18 = FullScreenGalleryDialogActivity.l;
        FullScreenGalleryDialogActivity.a.a(r17, new GalleryViewerParams(r12), null);
    L63:
        Unit r19 = Unit.INSTANCE;
        com.bytedance.android.shopping.anchorv4.containers.a.a = r5;
    L76:
        this.y.l();
        this.y.f();
        return;
    L58:
        r17 = null;
        goto L59
    L62:
        this.p = false;
        goto L63
    L38:
        r12 = -1;
        goto L39
    L64:
        AnchorV4GalleryViewerCompat r20 = new AnchorV4GalleryViewerCompat(this.v.getContext(), new r(this));
        r20.b(this.h);
        r20.setOnPageSelectedListener(new d(r20, this));
        RecyclerView.OnScrollListener r21 = new SlidesAndIndicatorV4Component$openGalleryViewer$$inlined$apply$lambda$5(this);
        Intrinsics.checkNotNullParameter(r21, "listener");
        r20.getPager().addOnScrollListener(r21);
        r20.setOnDismissListener(new e(this));
        AnchorV4HeadViewPager r22 = this.e;
        if (r22 == null) goto L67;
        r4 = r22.j(r11, r8);
    L67:
        if (r4 < 0) goto L75;
        if (r9 == false) goto L70;
        r20.show(r4);
        goto L76
    L70:
        ViewPager r23 = this.e;
        if (r23 == null) goto L74;
        r20.showAnimated(r4, r23);
        goto L76
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L75:
        this.p = false;
        goto L76
    L32:
        r11 = 0;
        goto L33
    L10:
        if (this.z.a() == true) goto L23;
        TransSmallComponent r24 = this.q;
        if (r24 == null) goto L21;
        ArrayList<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r25 = r24.h;
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10));
        Iterator<com.bytedance.android.shopping.anchorv4.voavhs.head.base.a> r27 = r25.iterator();
    L15:
        if (r27.hasNext() == false) goto L17;
        r26.add(r27.next().f());
        goto L15
    L17:
        ?? r28 = new ArrayList();
        Iterator r29 = r26.iterator();
    L19:
        if (r29.hasNext() == false) goto L22;
        r28.addAll((List) r29.next());
    L22:
        this.h = r28;
        goto L23
    L21:
        r28 = CollectionsKt.emptyList();
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }

    public SlidesAndIndicatorV4Component(FrameLayout r2, FrameLayout r3, FrameLayout r4, AnchorV4HeadView$slidesAndIndicatorComponent$2.a r5, AnchorV4HeadView$slidesAndIndicatorComponent$2.b r6, AnchorV4HeadView$slidesAndIndicatorComponent$2.c r7, AnchorV4HeadView$slidesAndIndicatorComponent$2.d r8, AnchorV4HeadView$slidesAndIndicatorComponent$2.e r9, AnchorV4HeadView$slidesAndIndicatorComponent$2.f r10, AnchorV4HeadView$slidesAndIndicatorComponent$2.g r11, Function0 r12, Function0 r13, AnchorV4HeadView r14) {
        Intrinsics.checkNotNullParameter(r2, "slidesContainer");
        Intrinsics.checkNotNullParameter(r3, "indicatorContainer");
        Intrinsics.checkNotNullParameter(r4, "downTabIndicatorContainer");
        Intrinsics.checkNotNullParameter(r5, "logAction");
        Intrinsics.checkNotNullParameter(r6, "guessULikeAction");
        Intrinsics.checkNotNullParameter(r7, "statusTracker");
        Intrinsics.checkNotNullParameter(r8, "galleryStatusChecker");
        Intrinsics.checkNotNullParameter(r9, "findSameAction");
        Intrinsics.checkNotNullParameter(r10, "videoPlayListener");
        Intrinsics.checkNotNullParameter(r11, "pageScrollAction");
        Intrinsics.checkNotNullParameter(r12, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r13, "slcRenderContext");
        Intrinsics.checkNotNullParameter(r14, "headView");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.z = r7;
        this.A = r8;
        this.B = r9;
        this.C = r10;
        this.D = r11;
        this.E = r12;
        this.F = r13;
        this.G = r14;
        this.H = null;
        this.g = CollectionsKt.emptyList();
        this.h = CollectionsKt.emptyList();
        this.n = new u();
        this.o = LazyKt.lazy(new SlidesAndIndicatorV4Component$tabLogicInterceptor$2(this));
        this.s = new t(this);
        this.u = LazyKt.lazy(new SlidesAndIndicatorV4Component$headFloatVideoHandler$2(this));
    }
}
