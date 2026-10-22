package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.ItemViewHolder;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFragment;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFromType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f extends com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a {
    public final /* synthetic */ e c;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public final Rect a(com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r4) {
        if (r4 == null) goto L4;
        int r0 = r4.h;
    L5:
        RecyclerView r1 = this.c.m;
        if (r1 == null) goto L8;
        RecyclerView.ViewHolder r2 = r1.findViewHolderForAdapterPosition(r0);
    L10:
        if ((r2 instanceof ItemViewHolder) == true) goto L12;
        r2 = null;
    L12:
        ItemViewHolder r3 = (ItemViewHolder) r2;
        if (r3 == null) goto L15;
        Object r5 = ((RecyclerView.ViewHolder) r3).itemView;
    L17:
        if ((r5 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w) == true) goto L19;
        r5 = null;
    L19:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w r6 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w) r5;
        if (r6 == null) goto L28;
        if (r4 == null) goto L23;
        Integer r7 = r4.k;
    L24:
        View r8 = r6.B(r7);
        if (r8 == null) goto L29;
        GalleryFragment.N.getClass();
        return GalleryFragment.b.b(r8);
    L29:
        return null;
    L23:
        r7 = null;
        goto L24
    L28:
        return null;
    L15:
        r5 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    L4:
        r0 = this.c.b;
        goto L5
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public final void b(com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r3) {
        if (r3 == null) goto L15;
        int r4 = Integer.valueOf(r3.h).intValue();
        PlayerBlock r5 = this.c.g.d(r4);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.M != null) goto L17;
        gj.b r0 = r5.f;
        if (r0 == null) goto L12;
        boolean r1 = true;
        if (r0.isPlaying() != true) goto L12;
    L13:
        r5.M = Boolean.valueOf(r1);
        return;
    L12:
        r1 = false;
        goto L13
    L17:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public final void d(com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r11, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.h r12) {
        this.c.k = false;
        if (r11 == null) goto L7;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r2 = r11.d;
        if (r2 == null) goto L7;
        x73.c r3 = r2.getSharePlayer();
    L9:
        if (r3 != null) goto L29;
        if (r12 == null) goto L29;
        Boolean r4 = Boolean.FALSE;
        y r5 = this.c.g;
        if (r11 == null) goto L14;
        int r6 = r11.h;
    L15:
        PlayerBlock r7 = r5.d(r6);
        if (r7 != null) goto L18;
    L30:
        u r13 = this.c.rR();
        if (r13 == null) goto L33;
        r13.a0(r4);
    L33:
        this.c.C = null;
        if (r11 == null) goto L48;
        int r14 = Integer.valueOf(r11.h).intValue();
        y r15 = this.c.g;
        r15.getClass();
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.c() == true) goto L49;
        PlayerBlockWrapper r16 = r15.a.get(r14);
        if (r16 == null) goto L50;
        PlayerBlock r17 = r16.d;
        if (r17 != null) goto L42;
        return;
    L42:
        if (r17.isPlaying() == false) goto L44;
        PlayerBlock.z(r17, false, false, "main_picture", 3);
    L44:
        c63.c r18 = r17.N;
        if (r18 == null) goto L52;
        r18.y("main_picture");
        return;
    L52:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L18:
        if (r12.c == r7.o) goto L21;
        PlayerBlock.o(r7, false, 3);
    L21:
        if (r12.b < r7.s()) goto L23;
    L28:
        r7.J(0.0f);
        goto L30
    L23:
        if (r7.s() <= 0) goto L28;
        if (r12.a == false) goto L27;
        r4 = Boolean.TRUE;
        r7.j();
    L27:
        r7.J((r12.b / r7.s()) * 100);
        goto L30
    L14:
        r6 = -1;
    L29:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }

    public f(e r1, r r2, GalleryFromType r3) {
        this.c = r1;
        super(r2, r3);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.a, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i0
    public final void e(int r3, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q r4, boolean r5) {
        e r0 = this.c;
        if (r0.b != r3) goto L5;
        if (r5 == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L16;
        e.b r6 = r0.f;
        int r7 = r4.h;
        Boolean r1 = Boolean.TRUE;
        r6.n(r7, r1);
        if (this.c.aN(r4.h) == false) goto L9;
        this.c.m90();
        e r8 = this.c;
        r8.u = r1;
        int r9 = k83.b.a;
        k83.b.c(r8.m);
    L9:
        RecyclerView r10 = this.c.m;
        if (r10 != null) goto L12;
        return;
    L12:
        if (ViewCompat.isAttachedToWindow(r10) == true) goto L18;
        e r11 = this.c;
        r11.y = true;
        e.l(r11, r4.h);
        this.c.y = false;
        return;
    L18:
        return;
    }
}
