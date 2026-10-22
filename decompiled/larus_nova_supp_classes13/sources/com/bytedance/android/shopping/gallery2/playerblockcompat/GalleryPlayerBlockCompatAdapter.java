package com.bytedance.android.shopping.gallery2.playerblockcompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import ee3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/playerblockcompat/GalleryPlayerBlockCompatAdapter;", "Lcom/bytedance/android/shopping/gallery2/GalleryAdapter;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryPlayerBlockCompatAdapter extends GalleryAdapter {
    public VideoPlayerBlockCompatVH f;
    public c g;

    public static final class a {
    }

    static {
    }

    public final boolean B2() {
        if (this.g == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onDestroy() {
        VideoPlayerBlockCompatVH r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h == false) goto L15;
        PlayerBlock r1 = r0.e;
        if (r1 == null) goto L9;
        VideoPlayerBlockCompatVH.e r3 = r0.j;
        Intrinsics.checkNotNullParameter(r3, "reporter");
        r1.p.remove(r3);
        r1.p(false);
    L9:
        r0.f.removeView(r0.e);
        ViewGroup r2 = r0.g;
        if (r2 == null) goto L12;
        r2.addView(r0.e, 0);
    L12:
        r0.h = false;
        return;
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final int getItemCount() {
        return super.getItemCount() + (B2() ? 1 : 0);
    }

    public GalleryPlayerBlockCompatAdapter() {
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final int getItemViewType(int r2) {
        if (B2() == false) goto L9;
        if (r2 != 0) goto L10;
        return 100;
    L10:
        return super.getItemViewType(r2 - 1);
    L9:
        return super.getItemViewType(r2);
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onViewAttachedToWindow(TransitionViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewAttachedToWindow(r2);
        if (B2() == true) goto L5;
    L7:
        VideoPlayerBlockCompatVH r3 = null;
    L8:
        if (r3 == null) goto L11;
        this.f = r3;
        return;
    L11:
        return;
    L5:
        if ((r2 instanceof VideoPlayerBlockCompatVH) == false) goto L7;
        r3 = (VideoPlayerBlockCompatVH) r2;
        goto L8
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryAdapter
    public final void onViewDetachedFromWindow(TransitionViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewDetachedFromWindow(r2);
        if (B2() == true) goto L5;
    L7:
        VideoPlayerBlockCompatVH r3 = null;
    L8:
        if (r3 == null) goto L15;
        c r4 = this.g;
        if (r4 == null) goto L16;
        PlayerBlock r5 = r4.getPlayer();
        if (r5 == null) goto L17;
        int r0 = PlayerBlock.T;
        r5.F(true);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if ((r2 instanceof VideoPlayerBlockCompatVH) == false) goto L7;
        r3 = (VideoPlayerBlockCompatVH) r2;
        goto L8
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
    public final TransitionViewHolder A2(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 100) goto L7;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131560597, r4, false);
        c r0 = this.g;
        Intrinsics.checkNotNull(r0);
        VideoPlayerBlockCompatVH r7 = new VideoPlayerBlockCompatVH(r6, r0);
        this.f = r7;
        Intrinsics.checkNotNull(r7);
        return r7;
    L7:
        return super.A2(r4, r5);
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
    public final void z2(TransitionViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (B2() == false) goto L6;
        if (r3 <= 0) goto L8;
        super.z2(r2, r3 - 1);
        return;
    L8:
        return;
    L6:
        super.z2(r2, r3);
    }
}
