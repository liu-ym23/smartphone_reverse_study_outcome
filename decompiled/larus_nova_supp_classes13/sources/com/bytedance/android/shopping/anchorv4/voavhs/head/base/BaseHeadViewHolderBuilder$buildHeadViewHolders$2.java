package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.ScrollMoreText;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BaseHeadViewHolderBuilder$buildHeadViewHolders$2 extends a {
    public final /* synthetic */ b d;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.head.c e;
    public final /* synthetic */ ViewGroup f;
    public final /* synthetic */ m g;
    public final /* synthetic */ int h;

    public final void d() {
        i r0 = this.d.u(this.g, Integer.valueOf(this.h));
        if (r0 == null) goto L6;
        this.e.getType();
        r0.a(this.e.p);
        return;
    }

    public final void e() {
        b.p(this.d, this.e, this.f);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final List<Pair<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f, String>> f() {
        if ((!Intrinsics.areEqual(this.e.o, Boolean.FALSE)) == false) goto L10;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> r0 = this.d.v(this.g, new BaseHeadViewHolderBuilder$buildHeadViewHolders$2$extractBrowseNodeWithType$browseNode$1(this));
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f r3 = (com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f) r2.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r4 = this.e;
        r1.add(new Pair(com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f.a(r3, r4.n, r4.H), this.e.m));
        goto L6
    L8:
        return r1;
    L10:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final p g() {
        String r1 = this.e.getType();
        if (r1 != null) goto L6;
        r1 = HeadViewType.PICTURE.getType();
    L6:
        return new p(r1, this.c);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.a
    public final void b2(boolean r2) {
        AnchorV4LoadMoreRecyclerView r0 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f;
        if (r0 == null) goto L6;
        r0.setScrollState(r2);
        return;
    }

    public final View c(LayoutInflater r5) {
        Intrinsics.checkNotNullParameter(r5, "layoutInflater");
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r6 = this.e;
        if (r6.t == null) goto L19;
        List<ECUrlModel> r7 = r6.x;
        boolean r0 = false;
        if (r7 != null) goto L7;
    L10:
        boolean r8 = true;
    L11:
        if (r8 == false) goto L19;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r9 = new com.bytedance.android.shopping.anchorv4.voavhs.head.more.c(this.f, this.d.g);
        ScrollMoreText r2 = this.e.t;
        d r3 = this.d.g;
        if (r3 == null) goto L20;
        if (r3.n() != true) goto L20;
        r0 = true;
    L20:
        return r9.a(r2, r0);
    L7:
        if (r7.isEmpty() == true) goto L10;
        r8 = false;
    L19:
        return this.f;
    }

    public BaseHeadViewHolderBuilder$buildHeadViewHolders$2(b r1, com.bytedance.android.shopping.anchorv4.voavhs.head.c r2, ViewGroup r3, m r4, int r5, Context r6, int r7) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        super(r6, r7);
    }
}
