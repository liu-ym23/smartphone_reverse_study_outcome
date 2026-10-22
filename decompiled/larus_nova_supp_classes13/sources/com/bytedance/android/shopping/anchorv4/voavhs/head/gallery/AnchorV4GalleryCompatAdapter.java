package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.shopping.gallery2.PhotoWithBtnVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4GalleryCompatAdapter;", "Lcom/bytedance/android/shopping/gallery2/GalleryAdapter;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GalleryCompatAdapter extends GalleryAdapter {
    public List<? extends ee3.c> f;
    public List<? extends View> g;
    public List<RecyclerView.ViewHolder> h;
    public List<Integer> i;
    public List<Integer> j;
    public Function0<Unit> k;
    public i l;
    public int m;
    public AnchorV4KolFeedVH n;
    public final j o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onDestroy() {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        AnchorV4VideoPlayerCompatVH r1 = (RecyclerView.ViewHolder) r0.next();
        if ((r1 instanceof AnchorV4VideoPlayerCompatVH) == false) goto L4;
        r1.Z0();
        goto L4
    }

    public AnchorV4GalleryCompatAdapter(j r1) {
        this.o = r1;
        this.f = CollectionsKt.emptyList();
        this.g = CollectionsKt.emptyList();
        this.h = new ArrayList();
        this.i = CollectionsKt.emptyList();
        this.j = CollectionsKt.emptyList();
        this.m = -1;
    }

    public final void C2(List<? extends View> r7) {
        Intrinsics.checkNotNullParameter(r7, "viewProvideList");
        List<Integer> r0 = this.i;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        if (((Number) r2.next()).intValue() == 4) goto L8;
        View r4 = null;
    L9:
        r1.add(r4);
        goto L4
    L8:
        int r5 = r3 + 1;
        r4 = (View) CollectionsKt.getOrNull(r7, r3);
        r3 = r5;
        goto L9
    L10:
        this.g = r1;
    }

    public final void D2(List<? extends ee3.c> r7) {
        Intrinsics.checkNotNullParameter(r7, "videoProvider2List");
        List<Integer> r0 = this.i;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        if (((Number) r2.next()).intValue() == 2) goto L8;
        ee3.c r4 = null;
    L9:
        r1.add(r4);
        goto L4
    L8:
        int r5 = r3 + 1;
        r4 = (ee3.c) CollectionsKt.getOrNull(r7, r3);
        r3 = r5;
        goto L9
    L10:
        this.f = r1;
    }

    public final Pair<Integer, Integer> E2(int r7) {
        Iterator<Integer> r0 = this.i.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        if (r0.next().intValue() != 7) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        r2 = r2 + 1;
    L13:
        if (r2 != (-1)) goto L15;
        int r1 = this.i.size();
    L16:
        if (r7 >= r2) goto L20;
        return new Pair(Integer.valueOf(r7), Integer.valueOf(r1));
    L20:
        return new Pair(Integer.valueOf(r7 - r2), Integer.valueOf(this.i.size() - r1));
    L15:
        r1 = r2;
        goto L16
    L8:
        r3 = false;
        goto L9
    L12:
        r2 = -1;
        goto L13
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final int getItemViewType(int r5) {
        int r0 = super.getItemViewType(r5);
        Integer r1 = (Integer) CollectionsKt.getOrNull(this.i, r5);
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L13:
        if (r1 != null) goto L16;
    L18:
        if (r1 != null) goto L21;
    L23:
        if (r1 != null) goto L26;
    L28:
        if (r1 != null) goto L31;
        return r0;
    L31:
        if (r1.intValue() != 8) goto L36;
    L32:
        Integer r6 = (Integer) CollectionsKt.getOrNull(this.j, r5);
        if (r6 != null) goto L35;
        return r0;
    L35:
        return r6.intValue();
    L36:
        return r0;
    L26:
        if (r1.intValue() != 7) goto L28;
    L21:
        if (r1.intValue() != 5) goto L23;
    L16:
        if (r1.intValue() != 6) goto L18;
    L11:
        if (r1.intValue() != 4) goto L13;
    L6:
        if (r1.intValue() != 2) goto L8;
        goto L8
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onViewDetachedFromWindow(TransitionViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewDetachedFromWindow(r3);
        Integer r0 = (Integer) CollectionsKt.getOrNull(this.i, r3.getAdapterPosition());
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != 2) goto L13;
        ee3.c r4 = (ee3.c) CollectionsKt.getOrNull(this.f, r3.getAdapterPosition());
        if (r4 == null) goto L14;
        PlayerBlock r5 = r4.getPlayer();
        if (r5 == null) goto L15;
        int r1 = PlayerBlock.T;
        r5.F(true);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        onViewDetachedFromWindow((TransitionViewHolder) r1);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final TransitionViewHolder A2(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        Integer r0 = (Integer) CollectionsKt.getOrNull(this.i, this.j.indexOf(Integer.valueOf(r12)));
        if (r0 == null) goto L9;
        if (r0.intValue() != 2) goto L9;
        return new AnchorV4VideoPlayerCompatVH(LayoutInflater.from(r11.getContext()).inflate(2131560597, r11, false), false, false, null, new AnonymousClass1(this));
    L9:
        if (r0 != null) goto L12;
    L14:
        if (r0 != null) goto L17;
    L19:
        if (r0 != null) goto L22;
    L25:
        if (r0 != null) goto L28;
    L31:
        if (r0 == null) goto L38;
        if (r0.intValue() != 8) goto L38;
        AnchorV4KolFeedVH r13 = new AnchorV4KolFeedVH(LayoutInflater.from(r11.getContext()).inflate(2131560592, r11, false), this.l, false, 4);
        this.n = r13;
        return r13;
    L38:
        return super.A2(r11, r12);
    L28:
        if (r0.intValue() != 7) goto L31;
        return new AnchorV4PhotoWithTitleVH(LayoutInflater.from(r11.getContext()).inflate(2131560595, r11, false), this.o);
    L22:
        if (r0.intValue() != 6) goto L25;
        return new PhotoVH(LayoutInflater.from(r11.getContext()).inflate(2131560593, r11, false));
    L17:
        if (r0.intValue() != 5) goto L19;
        return new PhotoWithBtnVH(LayoutInflater.from(r11.getContext()).inflate(2131560594, r11, false), this.o);
    L12:
        if (r0.intValue() != 4) goto L14;
        return new AnchorV4CustomViewCompatVH(LayoutInflater.from(r11.getContext()).inflate(2131560589, r11, false), this.g);
    }

    public final void B2(List<Integer> r3, List<Integer> r4) {
        Intrinsics.checkNotNullParameter(r3, "viewTypeList");
        Intrinsics.checkNotNullParameter(r4, "itemTypeList");
        this.i = r3;
        this.j = r4;
        int r5 = ((ArrayList) r3).size();
        ArrayList r6 = new ArrayList(r5);
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r6.add(null);
        r0 = r0 + 1;
        goto L3
    L5:
        this.h = r6;
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
    public final void z2(TransitionViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        if (r6 >= this.i.size()) goto L5;
        ListProtector.set(this.h, r6, r5);
    L5:
        Integer r0 = (Integer) CollectionsKt.getOrNull(this.i, r6);
        String r1 = null;
        ViewGroup r2 = null;
        if (r0 != null) goto L9;
    L16:
        if (r0 != null) goto L19;
    L36:
        if (r0 != null) goto L39;
    L58:
        if (r0 != null) goto L61;
    L63:
        super.z2(r5, r6);
        return;
    L61:
        if (r0.intValue() != 8) goto L63;
        this.m = r5.getAdapterPosition();
        return;
    L39:
        if (r0.intValue() != 7) goto L58;
        if ((r5 instanceof AnchorV4PhotoWithTitleVH) == true) goto L43;
        TransitionViewHolder r3 = null;
    L44:
        AnchorV4PhotoWithTitleVH r4 = (AnchorV4PhotoWithTitleVH) r3;
        if (r4 == null) goto L57;
        List<? extends l> r7 = this.b;
        if (r7 == null) goto L49;
        l r8 = (l) CollectionsKt.getOrNull(r7, r6);
    L51:
        if ((r8 instanceof com.bytedance.android.ec.model.k) == true) goto L53;
        r8 = null;
    L53:
        com.bytedance.android.ec.model.k r9 = (com.bytedance.android.ec.model.k) r8;
        if (r9 == null) goto L56;
        r1 = r9.m;
    L56:
        r4.V3(r1);
        goto L57
    L49:
        r8 = null;
    L57:
        super.z2(r5, r6);
        return;
    L43:
        r3 = r5;
        goto L44
    L19:
        if (r0.intValue() != 4) goto L36;
        if ((r5 instanceof AnchorV4CustomViewCompatVH) == true) goto L23;
        r5 = null;
    L23:
        AnchorV4CustomViewCompatVH r10 = (AnchorV4CustomViewCompatVH) r5;
        if (r10 == null) goto L67;
        Function0<Unit> r11 = this.k;
        View r12 = (View) CollectionsKt.getOrNull(r10.c, r10.getAdapterPosition());
        ViewGroup r13 = r10.b;
        if (r13 != null) goto L28;
    L35:
        r10.a.setOnClickListener(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.a(r11));
        return;
    L28:
        if (r13.getChildCount() != 0) goto L30;
        boolean r14 = true;
    L31:
        if (r14 == false) goto L33;
        r2 = r13;
    L33:
        if (r2 == null) goto L35;
        r2.addView(r12);
        goto L35
    L30:
        r14 = false;
        goto L31
    L67:
        return;
    L9:
        if (r0.intValue() != 2) goto L16;
        if ((r5 instanceof AnchorV4VideoPlayerCompatVH) == true) goto L13;
        r5 = null;
    L13:
        AnchorV4VideoPlayerCompatVH r15 = (AnchorV4VideoPlayerCompatVH) r5;
        if (r15 == null) goto L65;
        r15.I3(r6, null);
        return;
    }
}
