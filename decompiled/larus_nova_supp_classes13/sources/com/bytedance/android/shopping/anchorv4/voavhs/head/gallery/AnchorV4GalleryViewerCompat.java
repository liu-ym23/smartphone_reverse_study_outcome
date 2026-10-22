package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.r;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4GalleryViewerCompat;", "Lcom/bytedance/android/shopping/gallery2/GalleryViewer;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GalleryViewerCompat extends GalleryViewer {
    public final e d;
    public boolean e;
    public int f;

    public final void b(List<Pair<f, String>> r20) {
        Intrinsics.checkNotNullParameter(r20, "galleryDisplayData");
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        r4.addAll(r20);
        r4.add(new Pair(new f(null, null, null, null, null, null, false, null, null, 2047), ""));
        String r5 = "0";
        int r7 = 0;
    L3:
        boolean r9 = true;
        Integer r10 = null;
        if (r7 >= r4.size()) goto L47;
        String r8 = (String) ((Pair) ListProtector.get(r4, r7)).getSecond();
        f r11 = (f) ((Pair) ListProtector.get(r4, r7)).getFirst();
        String r12 = r11.k;
        if ((!Intrinsics.areEqual(r8, r5)) == true) goto L8;
    L15:
        ECUrlModel r13 = r11.b;
        if (r13 == null) goto L25;
        String r14 = r11.f;
        if (r14 != null) goto L24;
        int r15 = com.bytedance.android.ec.model.k.n;
        HashMap<Integer, String> r16 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r8) == 1) goto L23;
        r9 = false;
    L23:
        r3.add(com.bytedance.android.ec.model.k.a.a(r13, r9, r11.g, r11.c));
    L46:
        r7 = r7 + 1;
        goto L3
    L24:
        int r17 = com.bytedance.android.ec.model.k.n;
        r3.add(com.bytedance.android.ec.model.k.a.b(r13, r14, r11.g, r11.c));
        goto L46
    L25:
        View r18 = r11.a;
        if (r18 == null) goto L28;
        int r19 = com.bytedance.android.ec.model.k.n;
        String r21 = r11.g;
        com.bytedance.android.ec.model.k r110 = new com.bytedance.android.ec.model.k();
        r110.a = 3;
        r110.j = r18;
        r110.l = r21;
        r3.add(r110);
        goto L46
    L28:
        b r22 = r11.d;
        if (r22 == null) goto L44;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r23 = r22.getPlayInfo();
        int r24 = com.bytedance.android.ec.model.k.n;
        if (r23 == null) goto L33;
        String r25 = r23.e();
    L34:
        if (r23 == null) goto L36;
        String r111 = r23.f();
    L37:
        if (r23 == null) goto L39;
        Integer r112 = r23.l();
    L40:
        if (r23 == null) goto L42;
        r10 = r23.c();
    L42:
        r3.add(com.bytedance.android.ec.model.k.a.d(r25, r111, r112, r10, r11.g));
        goto L46
    L39:
        r112 = null;
        goto L40
    L36:
        r111 = null;
        goto L37
    L33:
        r25 = null;
        goto L34
    L44:
        if (r11.h == false) goto L46;
        int r26 = com.bytedance.android.ec.model.k.n;
        com.bytedance.android.ec.model.k r27 = new com.bytedance.android.ec.model.k();
        r27.a = 9;
        r3.add(r27);
        goto L46
    L8:
        if ((!r3.isEmpty()) == false) goto L14;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r114 = r3.iterator();
    L11:
        if (r114.hasNext() == false) goto L13;
        r113.add((com.bytedance.android.ec.model.k) r114.next());
        goto L11
    L13:
        r2.add(new h(r5, r113, r12));
    L14:
        r3.clear();
        r5 = r8;
        goto L15
    L47:
        this.d.b(r2);
        ArrayList r6 = new ArrayList();
        Iterator r28 = r2.iterator();
    L49:
        if (r28.hasNext() == false) goto L51;
        r6.addAll(((h) r28.next()).b);
        goto L49
    L51:
        ArrayList r29 = new ArrayList();
        List<Pair<f, String>> r1 = r20;
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r1.iterator();
    L53:
        if (r31.hasNext() == false) goto L87;
        Pair r32 = (Pair) r31.next();
        if (((f) r32.getFirst()).d == null) goto L58;
        Integer r33 = 2;
    L83:
        if (r33 == null) goto L85;
        r29.add(Integer.valueOf(((f) r32.getFirst()).e));
    L85:
        if (r33 == null) goto L53;
        r30.add(r33);
        goto L53
    L58:
        if (((f) r32.getFirst()).a == null) goto L61;
        r33 = 4;
        goto L83
    L61:
        if (((f) r32.getFirst()).b == null) goto L80;
        if (com.bytedance.android.shopping.extensions.k.c(((f) r32.getFirst()).c) == false) goto L65;
        this.e = true;
        int r34 = 7;
    L78:
        r33 = Integer.valueOf(r34);
        goto L83
    L65:
        String r35 = ((f) r32.getFirst()).f;
        if (r35 != null) goto L68;
    L71:
        boolean r36 = true;
    L72:
        if (r36 == true) goto L74;
        r34 = 5;
        goto L78
    L74:
        if (((f) r32.getFirst()).e != 0) goto L76;
        r34 = 1;
        goto L78
    L76:
        r34 = 6;
        goto L78
    L68:
        if (r35.length() == 0) goto L71;
        r36 = false;
        goto L72
    L80:
        if (((f) r32.getFirst()).h == false) goto L82;
        r33 = 8;
        goto L83
    L82:
        r33 = null;
        goto L83
    L87:
        GalleryAdapter r37 = this.c;
        if (r37 == null) goto L116;
        ((AnchorV4GalleryCompatAdapter) r37).B2(r30, r29);
        GalleryAdapter r38 = this.c;
        if (r38 == null) goto L114;
        Function0<Unit> r39 = new AnchorV4GalleryViewerCompat$setMediaGroup$1(this);
        Intrinsics.checkNotNullParameter(r39, "listener");
        ((AnchorV4GalleryCompatAdapter) r38).k = r39;
        ArrayList r40 = new ArrayList();
        Iterator<T> r41 = r1.iterator();
    L93:
        if (r41.hasNext() == false) goto L97;
        b r42 = ((f) ((Pair) r41.next()).getFirst()).d;
        if (r42 == null) goto L93;
        r40.add(r42);
        goto L93
    L97:
        GalleryAdapter r43 = this.c;
        if (r43 == null) goto L112;
        ((AnchorV4GalleryCompatAdapter) r43).D2(r40);
        ArrayList r44 = new ArrayList();
        Iterator<T> r45 = r1.iterator();
    L101:
        if (r45.hasNext() == false) goto L105;
        View r46 = ((f) ((Pair) r45.next()).getFirst()).a;
        if (r46 == null) goto L101;
        r44.add(r46);
        goto L101
    L105:
        GalleryAdapter r47 = this.c;
        if (r47 == null) goto L110;
        ((AnchorV4GalleryCompatAdapter) r47).C2(r44);
        a(r6, false);
        this.c.a = 1;
        return;
    L110:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L114:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    }

    public final void onPageSelected(int r4) {
        if (this.e == false) goto L9;
        GalleryAdapter r0 = this.c;
        if (r0 == null) goto L8;
        Pair<Integer, Integer> r1 = ((AnchorV4GalleryCompatAdapter) r0).E2(r4);
        this.a.setCurrentPos(((Number) r1.getFirst()).intValue());
        this.a.setCount(((Number) r1.getSecond()).intValue());
    L10:
        this.f = r4;
        this.d.c(r4);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L9:
        super.onPageSelected(r4);
        goto L10
    }

    @Override // com.bytedance.android.shopping.gallery2.GalleryViewer
    public final void onTransitionEnd(int r2) {
        if (r2 != 0) goto L6;
        this.d.a(getRootContainer());
        onPageSelected(getCurrentPosition());
        this.d.c(this.f);
        return;
    }

    public AnchorV4GalleryViewerCompat(Context r2, r r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "galleryLog");
        super(r2, new AnchorV4GalleryCompatAdapter(r3));
        e r4 = new e();
        this.d = r4;
        r4.b = new c(this);
        r4.c = new d(this);
    }
}
