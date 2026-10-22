package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.holder.r;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4VideoView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2 extends a {
    public final /* synthetic */ b d;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c e;
    public final /* synthetic */ m f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ Ref.ObjectRef i;

    public final void d() {
        i r0 = this.d.u(this.f, Integer.valueOf(this.g));
        if (r0 == null) goto L6;
        this.e.getType();
        r0.a(this.e.p);
        return;
    }

    public final void e() {
        b.p(this.d, this.e, (View) this.i.element);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f() {
        if ((!Intrinsics.areEqual(this.e.o, Boolean.FALSE)) == false) goto L5;
    L9:
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> r0 = this.d.v(this.f, new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2$extractBrowseNodeWithType$browseNode$1(this));
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r2.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r4 = this.e;
        r1.add(new Pair(com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f.a(r3, r4.n, r4.H), this.e.m));
        goto L11
    L13:
        return r1;
    L5:
        if (this.e.D == true) goto L9;
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final p g() {
        String r1 = this.e.getType();
        if (r1 != null) goto L5;
        r1 = HeadViewType.PICTURE.getType();
    L5:
        p r0 = new p(r1, this.c);
        b r2 = this.d;
        PlayerBlock r3 = null;
        if ((r2 instanceof r) == true) goto L9;
        r2 = null;
    L9:
        if (((r) r2) == null) goto L14;
        AnchorV4VideoView r4 = r.A((View) this.i.element);
        if (r4 == null) goto L13;
        r3 = r4.getPlayerBlock();
    L13:
        r0.a = r3;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final void b2(boolean r2) {
        AnchorV4LoadMoreRecyclerView r0 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f;
        if (r0 == null) goto L6;
        r0.setScrollState(r2);
        return;
    }

    public final View c(LayoutInflater r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutInflater");
        View r7 = View.inflate(this.d.getContext(), 2131560609, null);
        if (r7 == null) goto L28;
        ViewGroup r8 = (ViewGroup) r7;
        ECDraweeView r0 = r8.findViewById(2131362814);
        this.d.s(r8, this.e.getType(), this.f, Integer.valueOf(this.g));
        this.d.r(r0, this.f.a(), new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2$getView$1(this));
        b r1 = this.d;
        SimpleDraweeView r2 = r8.findViewById(2131362813);
        ECUrlModel r3 = this.e.c;
        r1.getClass();
        b.q(r2, r3);
        View r4 = this.d.x(this.f, Integer.valueOf(this.g), this.h);
        if (r4 == null) goto L7;
        r8.addView(r4, r8.getChildCount());
    L7:
        this.d.t(r8, this.e);
        b r5 = this.d;
        r5.z(r5.getContext(), r8, this.f, this.h);
        this.i.element = r8;
        Function0 r9 = (Function0) CollectionsKt.getOrNull(this.d.c, this.h);
        if (r9 == null) goto L10;
        Unit r10 = (Unit) r9.invoke();
    L10:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r11 = this.e;
        if (r11.t == null) goto L29;
        List<ECUrlModel> r12 = r11.x;
        boolean r13 = false;
        if (r12 != null) goto L15;
    L18:
        boolean r14 = true;
    L19:
        if (r14 == false) goto L30;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r15 = new com.bytedance.android.shopping.anchorv4.voavhs.head.more.c(r8, this.d.g);
        b r16 = this.d;
        r16.e = r15;
        ScrollMoreText r17 = this.e.t;
        d r18 = r16.g;
        if (r18 == null) goto L26;
        if (r18.n() != true) goto L26;
        r13 = true;
    L26:
        return r15.a(r17, r13);
    L30:
        return r8;
    L15:
        if (r12.isEmpty() == true) goto L18;
        r14 = false;
        goto L19
    L29:
        return r8;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2(b r1, com.bytedance.android.shopping.anchorv4.voavhs.head.c r2, m r3, int r4, int r5, Ref.ObjectRef r6, Context r7, int r8) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        super(r7, r8);
    }
}
