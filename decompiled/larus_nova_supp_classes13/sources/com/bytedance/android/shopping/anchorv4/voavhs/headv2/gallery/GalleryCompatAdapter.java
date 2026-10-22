package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4KolFeedVH;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4PhotoWithTitleVH;
import com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4VideoPlayerCompatVH;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.GalleryVideoVH;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.shopping.gallery2.PhotoWithBtnVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/GalleryCompatAdapter;", "Lcom/bytedance/android/shopping/gallery2/GalleryAdapter;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryCompatAdapter extends GalleryAdapter {
    public static final /* synthetic */ int l = 0;
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g> f;
    public h0 g;
    public com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.j h;
    public final Function1<Float, Unit> i;
    public final Function2<View, RectF, Unit> j;
    public boolean k;

    public static final class a implements com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i {
        public final /* synthetic */ g0 a;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String c() {
            int r0 = com.bytedance.android.ec.core.utils.t0.a;     // Catch: Exception -> L8
            Gson r1 = com.bytedance.android.ec.core.utils.t0.a.b;     // Catch: Exception -> L8
            p r2 = this.a.q;     // Catch: Exception -> L8
            if (r2 == null) goto L5;
            Map<String, Object> r3 = r2.c;     // Catch: Exception -> L8
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
        public final Map<String, Object> d() {
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r0 = this.a.o;
            if (r0 == null) goto L7;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1 = r0.getPlayInfo();
            if (r1 == null) goto L7;
            return r1.g();
        L7:
            return null;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String e() {
            p r0 = this.a.q;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.d;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final String f() {
            p r0 = this.a.q;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Boolean g() {
            com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r0 = this.a.o;
            if (r0 == null) goto L9;
            com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r1 = r0.getPlayInfo();
            if (r1 == null) goto L9;
            Boolean r2 = r1.i();
            if (r2 == null) goto L9;
            boolean r3 = r2.booleanValue();
        L11:
            return Boolean.valueOf(r3);
        L9:
            r3 = false;
            goto L11
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.i
        public final Float h() {
            p r0 = this.a.q;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b;
        }

        public a(g0 r1) {
            this.a = r1;
        }
    }

    public final void C2() {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        Iterator<T> r0 = this.f.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r0.next()).Z0();
        goto L7
    }

    public GalleryCompatAdapter() {
        this.f = new ArrayList();
        this.i = new GalleryCompatAdapter$zoomListener$1(this);
        this.j = new GalleryCompatAdapter$imageBoundsSetListener$1(this);
    }

    public final g0 B2(int r3) {
        List<? extends com.bytedance.android.ec.model.l> r0 = this.b;
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

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final int getItemViewType(int r2) {
        List<? extends com.bytedance.android.ec.model.l> r0 = this.b;
        if (r0 == null) goto L7;
        com.bytedance.android.ec.model.l r3 = (com.bytedance.android.ec.model.l) ListProtector.get(r0, r2);
        if (r3 == null) goto L7;
        return r3.getType();
    L7:
        return 1;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onViewAttachedToWindow(TransitionViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        if (i.b() == true) goto L5;
        return;
    L5:
        if ((r2 instanceof j0) == true) goto L7;
        r2 = null;
    L7:
        j0 r3 = (j0) r2;
        if (r3 == null) goto L18;
        d r4 = r3.S3();
        if (r4 == null) goto L19;
        h0 r0 = this.g;
        if (r0 == null) goto L20;
        GalleryLayerItemStateManager r1 = r0.a();
        if (r1 == null) goto L21;
        r1.c(r4);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onViewDetachedFromWindow(TransitionViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        if (i.c() == true) goto L12;
        g0 r0 = B2(r3.getAdapterPosition());
        if (r0 == null) goto L12;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r1 = r0.o;
        if (r1 == null) goto L12;
        PlayerBlock r2 = r1.getPlayer();
        if (r2 == null) goto L12;
        int r4 = PlayerBlock.T;
        r2.F(true);
    L12:
        if ((r3 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L14;
        TransitionViewHolder r5 = null;
    L15:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r6 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r5;
        if (r6 == null) goto L19;
        r6.onViewDetachedFromWindow();
    L19:
        if (i.b() == true) goto L21;
        return;
    L21:
        if ((r3 instanceof j0) == true) goto L23;
        r3 = null;
    L23:
        j0 r7 = (j0) r3;
        if (r7 == null) goto L35;
        d r8 = r7.S3();
        if (r8 == null) goto L32;
        h0 r9 = this.g;
        if (r9 == null) goto L32;
        GalleryLayerItemStateManager r10 = r9.a();
        if (r10 == null) goto L32;
        r10.h(r8);
    L32:
        r7.o0();
        return;
    L35:
        return;
    L14:
        r5 = r3;
        goto L15
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        onViewAttachedToWindow((TransitionViewHolder) r1);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((TransitionViewHolder) r1);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final TransitionViewHolder A2(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        TransitionViewHolder r2 = null;
        if (r11 == 2) goto L15;
        if (r11 != 5) goto L7;
        TransitionViewHolder r12 = new PhotoWithBtnVH(LayoutInflater.from(r10.getContext()).inflate(2131560594, r10, false), this.h);
    L30:
        TransitionViewHolder r13 = r12;
    L32:
        if (i.b() == false) goto L66;
        boolean r14 = r13 instanceof PhotoVH;
        if (r14 == false) goto L36;
        TransitionPhotoDraweeView r1 = ((PhotoVH) r13).a;
    L40:
        if (r1 == null) goto L47;
        r1.setDragReturnAnimationEnabled(true);
        r1.setMaxDragTransitionFactor(0.3f);
        h0 r3 = this.g;
        if (r3 == null) goto L44;
        Function0<Rect> r4 = r3.g();
    L45:
        r1.setGetExitRect(r4);
        goto L47
    L44:
        r4 = null;
    L47:
        if ((r13 instanceof PhotoWithBtnVH) == true) goto L49;
        TransitionViewHolder r5 = null;
    L50:
        PhotoWithBtnVH r6 = (PhotoWithBtnVH) r5;
        if (r6 == null) goto L53;
        r6.f = true;
    L53:
        h0 r0 = this.g;
        if (r0 == null) goto L58;
        GalleryLayerItemStateManager r7 = r0.a();
        if (r7 == null) goto L58;
        r13.getTransitionLayout().addTransitionListener(r7.q);
    L58:
        if (r14 == false) goto L61;
        r2 = r13;
    L61:
        PhotoVH r8 = (PhotoVH) r2;
        if (r8 == null) goto L66;
        TransitionPhotoDraweeView r15 = r8.a;
        if (r15 == null) goto L66;
        r15.setZoomListener(this.i);
        r15.addBoundsChangeListener(this.j);
        r15.setCallback(new k(this, (PhotoVH) r13));
        goto L66
    L49:
        r5 = r13;
        goto L50
    L36:
        TransitionPhotoDraweeView r9 = ((RecyclerView.ViewHolder) r13).itemView;
        if ((r9 instanceof TransitionLayout) == true) goto L39;
        r9 = null;
    L39:
        r1 = (TransitionLayout) r9;
    L66:
        return r13;
    L7:
        if (r11 != 7) goto L9;
        r12 = new AnchorV4PhotoWithTitleVH(LayoutInflater.from(r10.getContext()).inflate(2131560595, r10, false), this.h);
        goto L30
    L9:
        if (r11 == 8) goto L11;
        r13 = super.A2(r10, r11);
        goto L32
    L11:
        r12 = new AnchorV4KolFeedVH(LayoutInflater.from(r10.getContext()).inflate(2131560592, r10, false), null, true, 2);
        goto L30
    L15:
        if (i.c() == false) goto L21;
        View r16 = LayoutInflater.from(r10.getContext()).inflate(2131560599, r10, false);
        h0 r17 = this.g;
        if (r17 == null) goto L19;
        l r18 = r17.c();
    L20:
        r12 = new GalleryVideoVH(r16, r18, new AnonymousClass1(this));
        ((ArrayList) this.f).add(r12);
        goto L30
    L19:
        r18 = null;
        goto L20
    L21:
        LayoutInflater r19 = LayoutInflater.from(r10.getContext());
        if (i.b() == false) goto L24;
        int r20 = 2131560598;
    L25:
        View r21 = r19.inflate(r20, r10, false);
        h0 r110 = this.g;
        if (r110 == null) goto L28;
        l r22 = r110.c();
    L29:
        r12 = new AnchorV4VideoPlayerCompatVH(r21, true, true, r22, new AnonymousClass3(this));
        ((ArrayList) this.f).add(r12);
        goto L30
    L28:
        r22 = null;
        goto L29
    L24:
        r20 = 2131560597;
        goto L25
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((TransitionViewHolder) r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1, r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void z2(TransitionViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        g0 r0 = B2(r7);
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getType());
    L6:
        if (r2 != null) goto L9;
    L17:
        if (r2 != null) goto L20;
    L40:
        if (r2 != null) goto L43;
    L51:
        super.z2(r6, r7);
    L53:
        if ((r6 instanceof PhotoVH) == true) goto L55;
        r6 = null;
    L55:
        PhotoVH r8 = (PhotoVH) r6;
        if (r8 == null) goto L61;
        TransitionPhotoDraweeView r9 = r8.a;
        if (r9 == null) goto L62;
        r9.setTag(2131382093, Integer.valueOf(r7));
        return;
    L62:
        return;
    L61:
        return;
    L43:
        if (r2.intValue() != 8) goto L51;
        if ((r6 instanceof AnchorV4KolFeedVH) == true) goto L47;
        TransitionViewHolder r3 = null;
    L48:
        AnchorV4KolFeedVH r4 = (AnchorV4KolFeedVH) r3;
        if (r4 == null) goto L53;
        r4.e = new a(r0);
        goto L53
    L47:
        r3 = r6;
        goto L48
    L20:
        if (r2.intValue() != 7) goto L40;
        if ((r6 instanceof AnchorV4PhotoWithTitleVH) == true) goto L24;
        TransitionViewHolder r1 = null;
    L25:
        AnchorV4PhotoWithTitleVH r5 = (AnchorV4PhotoWithTitleVH) r1;
        if (r5 == null) goto L39;
        List<? extends com.bytedance.android.ec.model.l> r10 = this.b;
        if (r10 == null) goto L30;
        com.bytedance.android.ec.model.l r11 = (com.bytedance.android.ec.model.l) CollectionsKt.getOrNull(r10, r7);
    L32:
        if ((r11 instanceof com.bytedance.android.ec.model.k) == true) goto L34;
        r11 = null;
    L34:
        com.bytedance.android.ec.model.k r12 = (com.bytedance.android.ec.model.k) r11;
        if (r12 == null) goto L37;
        String r13 = r12.m;
    L38:
        r5.V3(r13);
        goto L39
    L37:
        r13 = null;
        goto L38
    L30:
        r11 = null;
    L39:
        super.z2(r6, r7);
        goto L53
    L24:
        r1 = r6;
        goto L25
    L9:
        if (r2.intValue() != 2) goto L17;
        if ((r6 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) == true) goto L13;
        TransitionViewHolder r14 = null;
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g r15 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g) r14;
        if (r15 == null) goto L53;
        r15.I3(r7, r0.o);
        goto L53
    L13:
        r14 = r6;
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
