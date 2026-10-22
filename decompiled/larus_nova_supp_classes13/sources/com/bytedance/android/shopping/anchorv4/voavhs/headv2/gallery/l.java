package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public final z0 a;
    public final List<com.bytedance.android.ec.model.k> b;
    public final List<c0> c;
    public final Context d;
    public final LifecycleOwner e;
    public final GalleryViewModel f;
    public final m g;
    public final i0 h;
    public final GalleryLayerItemStateManager i;
    public final GalleryViewerParams j;
    public final PageFinder k;
    public EventChain l;

    public static final class a {
    }

    static {
    }

    public final boolean a() {
        i0 r0 = this.h;
        if (r0 == null) goto L5;
        GalleryFromType r1 = r0.c();
    L7:
        if (r1 != GalleryFromType.Head) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean b() {
        i0 r0 = this.h;
        if (r0 == null) goto L5;
        GalleryFromType r1 = r0.c();
    L7:
        if (r1 != GalleryFromType.MoreVideo) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final Context getContext() {
        return this.d;
    }

    public l(List r16, List r17, Context r18, LifecycleOwner r19, GalleryViewModel r20, m r21, i0 r22, GalleryLayerItemStateManager r23, GalleryViewerParams r24, PageFinder r25) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r20, "viewModel");
        Intrinsics.checkNotNullParameter(r21, "eventManager");
        Intrinsics.checkNotNullParameter(r25, "pageFinder");
        this.b = r16;
        this.c = r17;
        this.d = r18;
        this.e = r19;
        this.f = r20;
        this.g = r21;
        this.h = r22;
        this.i = r23;
        this.j = r24;
        this.k = r25;
        List<s> r2 = null;
        this.l = null;
        r21.b = this;
        if (r16 == null) goto L45;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r1 = r16.iterator();
        int r9 = 0;
    L6:
        if (r1.hasNext() == false) goto L44;
        Object r6 = r1.next();
        int r13 = r9 + 1;
        if (r9 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        com.bytedance.android.ec.model.k r7 = (com.bytedance.android.ec.model.k) r6;
        if ((r7 instanceof g0) == true) goto L13;
        com.bytedance.android.ec.model.k r8 = null;
    L14:
        g0 r10 = (g0) r8;
        if (r10 == null) goto L42;
        q r11 = r10.p;
        if (r11 == null) goto L42;
        if (r11.l == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L42;
        int r12 = f0.a;
        c0 r14 = r11.m;
        if (r14 == null) goto L26;
        String r15 = r14.a(r9);
    L27:
        String r26 = f0.a(r15);
        if (r26 != null) goto L30;
        r26 = "";
    L30:
        String r110 = r26;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r27 = r11.d;
        if (r27 == null) goto L36;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r28 = r27.getPlayInfo();
        if (r28 == null) goto L36;
        String r29 = r28.f();
        if (r29 == null) goto L36;
    L38:
        if (r11.d == null) goto L40;
        boolean r111 = true;
    L41:
        s r112 = new s(r110, r29, r9, r111, r110, false);
    L43:
        r3.add(r112);
        r9 = r13;
        goto L6
    L40:
        r111 = false;
    L36:
        r29 = r7.b;
        goto L38
    L26:
        r15 = null;
    L42:
        r112 = null;
        goto L43
    L13:
        r8 = r7;
        goto L14
    L44:
        r2 = r3;
    L45:
        if (r2 != null) goto L47;
        r2 = CollectionsKt.emptyList();
    L47:
        r20.setFullThumbList(r2);
        this.a = new z0();
    }
}
