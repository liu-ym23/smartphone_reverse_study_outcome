package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.containers.FullScreenGalleryDialogActivity;
import com.bytedance.android.shopping.anchorv4.containers.GalleryViewerParams;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.GalleryFragment;
import com.bytedance.android.shopping.gallery2.GalleryAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4GalleryDialogFragment;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/GalleryViewerDialogFragment;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GalleryDialogFragment extends GalleryViewerDialogFragment {
    public final e r;
    public i s;
    public boolean t;
    public int u;
    public View v;
    public Function0<Unit> w;

    public static final class a implements e.a {
        public final /* synthetic */ AnchorV4GalleryDialogFragment a;

        public a(AnchorV4GalleryDialogFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.e.a
        public final void a(int r2) {
            this.a.V90().smoothScrollToPosition(r2);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AnchorV4GalleryDialogFragment a;

        public b(AnchorV4GalleryDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismiss();     // Catch: Exception -> L5
        L9:
            FragmentActivity r3 = this.a.getActivity();
            if (r3 == null) goto L15;
            r3.finish();
            return;
        L15:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L9;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public AnchorV4GalleryDialogFragment() {
        this(null);
    }

    public final AnchorV4GalleryCompatAdapter ba0() {
        GalleryAdapter r0 = this.p;
        if (r0 == null) goto L7;
        return (AnchorV4GalleryCompatAdapter) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    }

    public AnchorV4GalleryDialogFragment(j r2) {
        super(new AnchorV4GalleryCompatAdapter(r2));
        e r3 = new e();
        this.r = r3;
        r3.b = new a(this);
        r3.c = new b(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void X90(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.X90(r2);
        this.r.a(W90());
    }

    public final void ca0(List<Pair<f, String>> r22) {
        Intrinsics.checkNotNullParameter(r22, "galleryDisplayData");
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Pair r5 = (Pair) CollectionsKt.getOrNull(r22, 0);
        if (r5 == null) goto L7;
        f r6 = (f) r5.getFirst();
        if (r6 == null) goto L7;
        String r7 = r6.k;
    L8:
        ArrayList r8 = new ArrayList();
        r8.addAll(r22);
        r8.add(new Pair(new f(null, null, null, null, null, null, false, null, null, 2047), ""));
        String r4 = "0";
        int r9 = 0;
    L9:
        boolean r10 = true;
        if (r9 >= r8.size()) goto L54;
        String r11 = (String) ((Pair) ListProtector.get(r8, r9)).getSecond();
        f r12 = (f) ((Pair) ListProtector.get(r8, r9)).getFirst();
        String r13 = r12.k;
        if ((!Intrinsics.areEqual(r11, r4)) == true) goto L14;
    L21:
        ECUrlModel r14 = r12.b;
        if (r14 == null) goto L31;
        String r15 = r12.f;
        if (r15 != null) goto L30;
        int r16 = com.bytedance.android.ec.model.k.n;
        HashMap<Integer, String> r17 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J;
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r11) == 1) goto L29;
        r10 = false;
    L29:
        r3.add(com.bytedance.android.ec.model.k.a.a(r14, r10, r12.g, r12.c));
    L53:
        r9 = r9 + 1;
        goto L9
    L30:
        int r18 = com.bytedance.android.ec.model.k.n;
        r3.add(com.bytedance.android.ec.model.k.a.b(r14, r15, r12.g, r12.c));
        goto L53
    L31:
        View r19 = r12.a;
        if (r19 == null) goto L34;
        int r110 = com.bytedance.android.ec.model.k.n;
        String r111 = r12.g;
        com.bytedance.android.ec.model.k r112 = new com.bytedance.android.ec.model.k();
        r112.a = 3;
        r112.j = r19;
        r112.l = r111;
        r3.add(r112);
        goto L53
    L34:
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r20 = r12.d;
        if (r20 == null) goto L51;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r21 = r20.getPlayInfo();
        int r113 = com.bytedance.android.ec.model.k.n;
        if (r21 == null) goto L39;
        String r114 = r21.e();
    L40:
        if (r21 == null) goto L42;
        String r115 = r21.f();
    L43:
        if (r21 == null) goto L45;
        Integer r116 = r21.l();
    L46:
        if (r21 == null) goto L48;
        Integer r23 = r21.c();
    L49:
        r3.add(com.bytedance.android.ec.model.k.a.d(r114, r115, r116, r23, r12.g));
        goto L53
    L48:
        r23 = null;
        goto L49
    L45:
        r116 = null;
        goto L46
    L42:
        r115 = null;
        goto L43
    L39:
        r114 = null;
        goto L40
    L51:
        if (r12.h == false) goto L53;
        int r24 = com.bytedance.android.ec.model.k.n;
        com.bytedance.android.ec.model.k r25 = new com.bytedance.android.ec.model.k();
        r25.a = 9;
        r3.add(r25);
        goto L53
    L14:
        if ((!r3.isEmpty()) == false) goto L20;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r118 = r3.iterator();
    L17:
        if (r118.hasNext() == false) goto L19;
        r117.add((com.bytedance.android.ec.model.k) r118.next());
        goto L17
    L19:
        r2.add(new h(r4, r117, r7));
    L20:
        r3.clear();
        r4 = r11;
        r7 = r13;
        goto L21
    L54:
        this.r.b(r2);
        final ArrayList r26 = new ArrayList();
        Iterator r27 = r2.iterator();
    L56:
        if (r27.hasNext() == false) goto L58;
        r26.addAll(((h) r27.next()).b);
        goto L56
    L58:
        ArrayList r28 = new ArrayList();
        List<Pair<f, String>> r1 = r22;
        ArrayList r29 = new ArrayList();
        Iterator<T> r30 = r1.iterator();
    L60:
        if (r30.hasNext() == false) goto L94;
        Pair r31 = (Pair) r30.next();
        if (((f) r31.getFirst()).d == null) goto L65;
        Integer r32 = 2;
    L90:
        if (r32 == null) goto L92;
        r28.add(Integer.valueOf(((f) r31.getFirst()).e));
    L92:
        if (r32 == null) goto L60;
        r29.add(r32);
        goto L60
    L65:
        if (((f) r31.getFirst()).a == null) goto L68;
        r32 = 4;
        goto L90
    L68:
        if (((f) r31.getFirst()).b == null) goto L87;
        if (com.bytedance.android.shopping.extensions.k.c(((f) r31.getFirst()).c) == false) goto L72;
        this.t = true;
        int r33 = 7;
    L85:
        r32 = Integer.valueOf(r33);
        goto L90
    L72:
        String r34 = ((f) r31.getFirst()).f;
        if (r34 != null) goto L75;
    L78:
        boolean r35 = true;
    L79:
        if (r35 == true) goto L81;
        r33 = 5;
        goto L85
    L81:
        if (((f) r31.getFirst()).e != 0) goto L83;
        r33 = 1;
        goto L85
    L83:
        r33 = 6;
        goto L85
    L75:
        if (r34.length() == 0) goto L78;
        r35 = false;
        goto L79
    L87:
        if (((f) r31.getFirst()).h == false) goto L89;
        r32 = 8;
        goto L90
    L89:
        r32 = null;
        goto L90
    L94:
        ba0().B2(r29, r28);
        AnchorV4GalleryCompatAdapter r36 = ba0();
        Function0<Unit> r37 = new AnchorV4GalleryDialogFragment$setMediaGroup$1(this);
        Intrinsics.checkNotNullParameter(r37, "listener");
        r36.k = r37;
        ArrayList r38 = new ArrayList();
        Iterator<T> r39 = r1.iterator();
    L96:
        if (r39.hasNext() == false) goto L100;
        com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r40 = ((f) ((Pair) r39.next()).getFirst()).d;
        if (r40 == null) goto L96;
        r38.add(r40);
        goto L96
    L100:
        GalleryAdapter r41 = this.p;
        if (r41 == null) goto L119;
        ((AnchorV4GalleryCompatAdapter) r41).D2(r38);
        ArrayList r42 = new ArrayList();
        Iterator<T> r43 = r1.iterator();
    L104:
        if (r43.hasNext() == false) goto L108;
        View r44 = ((f) ((Pair) r43.next()).getFirst()).a;
        if (r44 == null) goto L104;
        r42.add(r44);
        goto L104
    L108:
        GalleryAdapter r45 = this.p;
        if (r45 == null) goto L117;
        ((AnchorV4GalleryCompatAdapter) r45).C2(r42);
        this.p.b = r26;
        this.w = new AnchorV4GalleryDialogFragment$setMediaGroup$4(this, r26);
        GalleryAdapter r46 = this.p;
        if (r46 == null) goto L115;
        ((AnchorV4GalleryCompatAdapter) r46).l = this.s;
        r46.a = 1;
        return;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L119:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.AnchorV4GalleryCompatAdapter");
    L7:
        r7 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.GalleryViewerDialogFragment
    public final void onTransitionEnd(int r2) {
        if (r2 != 0) goto L6;
        onPageSelected(this.h, false);
        this.r.c(this.u);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.PhotoViewDialogFragment
    public final void onPageSelected(int r3, boolean r4) {
        if (this.t == false) goto L5;
        Pair<Integer, Integer> r5 = ba0().E2(r3);
        aa0().setCurrentPos(((Number) r5.getFirst()).intValue());
        aa0().setCount(((Number) r5.getSecond()).intValue());
    L5:
        this.u = r3;
        this.r.c(r3);
        AnchorV4GalleryCompatAdapter r6 = ba0();
        Function1<Boolean, Unit> r0 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r0, "indicatorController");
        AnchorV4KolFeedVH r1 = r6.n;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r3 != r6.m) goto L10;
        boolean r7 = true;
    L11:
        r1.getClass();
        r0.invoke(Boolean.valueOf(!r7));
        return;
    L10:
        r7 = false;
        goto L11
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        FragmentActivity r4 = getActivity();
        if ((r4 instanceof FullScreenGalleryDialogActivity) == true) goto L5;
        r4 = null;
    L5:
        FullScreenGalleryDialogActivity r5 = (FullScreenGalleryDialogActivity) r4;
        if (r5 == null) goto L16;
        GalleryViewerParams r6 = r5.k;
        if (r6 == null) goto L16;
        if (r6.getGalleryIndex() < this.m.getItemCount()) goto L12;
        Z90(0);
        goto L16
    L12:
        Z90(r6.getGalleryIndex());
        V90().scrollToPosition(r6.getGalleryIndex());
        View r7 = this.v;
        GalleryFragment.N.getClass();
        Rect r8 = GalleryFragment.b.b(r7);
        if (r8 == null) goto L15;
        this.m.setEnterAnimationParams(r6.getGalleryIndex(), r8);
    L15:
        this.i = true;
    L16:
        Function0<Unit> r9 = this.w;
        if (r9 == null) goto L20;
        Unit r10 = (Unit) r9.invoke();
    L20:
        if (this.v != null) goto L23;
        aa0().setVisibility(4);
        return;
    }
}
