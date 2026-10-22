package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.r;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.m;
import com.bytedance.android.shopping.anchorv4.voavhs.head.more.AnchorV4LoadMoreRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.q;
import com.bytedance.android.shopping.events.ImagePosition;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b<T extends m> implements j<T>, n, h, fa3.d {
    public final List<k> a;
    public int b;
    public final List<Function0<Unit>> c;
    public final List<o> d;
    public com.bytedance.android.shopping.anchorv4.voavhs.head.more.c e;
    public final Context f;
    public final d g;
    public final /* synthetic */ fa3.b h;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ b g;
        public final /* synthetic */ m h;
        public final /* synthetic */ Integer i;

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            i r4 = this.g.u(this.h, this.i);
            if (r4 == null) goto L6;
            r4.b(0);
            return;
        }

        public a(b r1, m r2, Integer r3) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            super(null, null, 3);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.head.base.b$b, reason: collision with other inner class name */
    public static final class C0008b implements com.bytedance.android.ecom.arch.slice.render.b {
        public final /* synthetic */ SlcRenderContext a;

        public C0008b(SlcRenderContext r1) {
            this.a = r1;
        }

        public final void a(r r8) {
            Intrinsics.checkNotNullParameter(r8, "actionInfo");
            IAction r4 = r8.a;
            View r5 = r8.d;
            int r9 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
            SlcRenderContext r10 = this.a;
            if ((r10 instanceof SlcContext) == true) goto L5;
            r10 = null;
        L5:
            com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, (SlcContext) r10, r4, r5, null);
        }
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.add(r2);
        return r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public void i(float r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void j() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public boolean n() {
        return false;
    }

    public View w(T r1) {
        return null;
    }

    public void y(T r2) {
        Intrinsics.checkNotNullParameter(r2, "nodeVO");
    }

    public void z(Context r1, View r2, T r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "headNodeVO");
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void d() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).d();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onDestroy() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).onDestroy();
        goto L4
    L6:
        this.h.a();
        AnchorV4LoadMoreRecyclerView r1 = com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f;
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c.f = null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onPause() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).onPause();
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onResume() {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).onResume();
        goto L4
    }

    public final Context getContext() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.h
    public final void a(int r4) {
        k r0 = (k) CollectionsKt.getOrNull(this.a, r4);
        if (r0 == null) goto L5;
        r0.c();
    L5:
        o r5 = (o) CollectionsKt.getOrNull(this.d, r4);
        if (r5 == null) goto L8;
        r5.b();
    L8:
        com.bytedance.android.shopping.anchorv4.voavhs.head.more.c r6 = this.e;
        if (r6 == null) goto L17;
        AnchorV4LoadMoreRecyclerView r1 = r6.c;
        if (r1 == null) goto L13;
        r1.scrollToPosition(0);
    L13:
        d r2 = r6.e;
        if (r2 == null) goto L16;
        r2.c(0.0f);
    L16:
        r6.b = 0;
    L17:
        d r7 = this.g;
        if (r7 == null) goto L21;
        r7.b();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void b(boolean r3) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((k) r0.next()).b(r3);
        goto L4
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final List<ECUrlModel> k(com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeVO");
        List<ECUrlModel> r4 = g(r3).b();
        ArrayList r0 = new ArrayList();
        if (r73.b.b() == true) goto L5;
    L10:
        return r0;
    L5:
        if ((!r4.isEmpty()) == false) goto L10;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r0.add((ECUrlModel) r5.next());
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final List<ECUrlModel> l(com.bytedance.android.shopping.anchorv4.voavhs.head.c r3) {
        Intrinsics.checkNotNullParameter(r3, "nodeVO");
        List<ECUrlModel> r4 = g(r3).b();
        ArrayList r0 = new ArrayList();
        if ((!r4.isEmpty()) == false) goto L8;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r0.add((ECUrlModel) r5.next());
    L8:
        return r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public void m(com.bytedance.android.shopping.anchorv4.voavhs.head.c r2) {
        Intrinsics.checkNotNullParameter(r2, "nodeVO");
        Intrinsics.checkNotNullParameter(r2, "nodeVO");
    }

    public b(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = new fa3.b();
        this.f = r2;
        this.g = r3;
        this.a = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        new ArrayList();
    }

    public static void q(SimpleDraweeView r9, ECUrlModel r10) {
        n1.i.getClass();
        int r0 = n1.a.d();
        if (r10 == null) goto L13;
        r9.setVisibility(0);
        ImageExtensionsKt.D(r9, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
        int r2 = -1;
        if (r10.getWidth() != 0) goto L7;
        int r1 = -1;
    L9:
        if (r10.getWidth() == 0) goto L12;
        r2 = (r0 * r10.getHeight()) / r10.getWidth();
    L12:
        y.c(r9, r10, r1, r2, new z53.a(r10.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), null, false, 28));
        return;
    L7:
        r1 = r0;
        goto L9
    L13:
        r9.setVisibility(8);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.h
    public final void f(boolean r2, int r3) {
        k r0 = (k) CollectionsKt.getOrNull(this.a, r3);
        if (r0 == null) goto L5;
        r0.e(r2);
    L5:
        o r4 = (o) CollectionsKt.getOrNull(this.d, r3);
        if (r4 == null) goto L9;
        r4.a();
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2 h(com.bytedance.android.shopping.anchorv4.voavhs.head.c r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "nodeVO");
        T r4 = g(r11);
        int r9 = this.b;
        this.b = r9 + 1;
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = null;
        List<Function0<Unit>> r0 = this.c;
        ArrayList r1 = (ArrayList) r0;
        r1.add(BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$1.INSTANCE);
        y(r4);
        return new BaseHeadViewHolderBuilder$buildHeadViewHoldersV2$2(this, r11, r4, r12, r9, r7, this.f, r9);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.n
    public final BaseHeadViewHolderBuilder$buildHeadViewHolders$2 o(com.bytedance.android.shopping.anchorv4.voavhs.head.c r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "nodeVO");
        T r5 = g(r10);
        int r8 = this.b;
        this.b = r8 + 1;
        View r0 = View.inflate(this.f, 2131560609, null);
        if (r0 == null) goto L10;
        ViewGroup r4 = (ViewGroup) r0;
        ECDraweeView r1 = r4.findViewById(2131362814);
        s(r4, r10.getType(), r5, Integer.valueOf(r11));
        r(r1, r5.a(), new BaseHeadViewHolderBuilder$buildHeadViewHolders$1(this, r11));
        q(r4.findViewById(2131362813), r10.c);
        View r2 = x(r5, Integer.valueOf(r11), r8);
        if (r2 == null) goto L7;
        r4.addView(r2, r4.getChildCount());
    L7:
        t(r4, r10);
        z(this.f, r4, r5, r8);
        return new BaseHeadViewHolderBuilder$buildHeadViewHolders$2(this, r10, r4, r5, r11, this.f, r8);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void t(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.head.c r7) {
        d r0 = this.g;
        if (r0 == null) goto L5;
        Object r1 = r0.f();
    L7:
        if ((r1 instanceof SlcRenderContext) == true) goto L9;
        r1 = null;
    L9:
        SlcRenderContext r2 = (SlcRenderContext) r1;
        com.bytedance.android.shopping.anchorv4.voavhs.head.p r3 = r7.I;
        if (r3 == null) goto L14;
        q r4 = r3.b();
        if (r4 == null) goto L14;
        SlcElement r5 = r4.a();
    L15:
        if (r5 == null) goto L28;
        if (r2 == null) goto L29;
        SliceRender r8 = SliceRender.o;
        SlcElement r9 = r7.I.b().a();
        r8.getClass();
        com.bytedance.android.ecom.arch.slice.render.r.d.getClass();
        com.bytedance.android.ecom.arch.slice.render.r r10 = com.bytedance.android.ecom.arch.slice.render.r.a.a(r2, r9, null);
        Map<String, Object> r11 = r7.I.c();
        if (r11 == null) goto L26;
        LinkedHashMap r12 = new LinkedHashMap();
        r12.putAll(r11);
        d r13 = this.g;
        if (r13 == null) goto L24;
        boolean r14 = true;
        if (r13.i() != true) goto L24;
    L25:
        r12.put("special_size", Boolean.valueOf(r14));
        Unit r15 = Unit.INSTANCE;
        r10.a(MapsKt.mapOf(TuplesKt.to("data", r12)), null);
    L24:
        r14 = false;
    L26:
        r10.b(new C0008b(r2));
        View r16 = r10.c;
        r16.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Unit r17 = Unit.INSTANCE;
        r6.addView(r16);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r5 = null;
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    public i u(T r2, Integer r3) {
        return new c(this.g, r3);
    }

    public List<com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f> v(T r13, Function0<? extends View> r14) {
        Intrinsics.checkNotNullParameter(r14, "rootView");
        if (r13 == null) goto L5;
        ECUrlModel r3 = r13.a();
    L7:
        if (r13 == null) goto L9;
        String r7 = r13.getDescription();
    L11:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(null, r3, null, null, null, r7, false, null, null, 1981));
    L9:
        r7 = null;
        goto L11
    L5:
        r3 = null;
        goto L7
    }

    public static final void p(b r7, com.bytedance.android.shopping.anchorv4.voavhs.head.c r8, View r9) {
        d r10 = r7.g;
        SlcContext r0 = null;
        if (r10 == null) goto L5;
        Object r11 = r10.f();
    L7:
        if ((r11 instanceof SlcRenderContext) == true) goto L9;
        r11 = null;
    L9:
        SlcContext r12 = (SlcRenderContext) r11;
        com.bytedance.android.shopping.anchorv4.voavhs.head.p r13 = r8.I;
        if (r13 == null) goto L12;
        IAction r4 = r13.a();
    L13:
        if (r4 == null) goto L21;
        if (r9 == null) goto L22;
        int r14 = com.bytedance.android.shopping.anchorv4.event_chain.c.a;
        if ((r12 instanceof SlcContext) == false) goto L19;
        r0 = r12;
    L19:
        com.bytedance.android.shopping.anchorv4.event_chain.c.b(null, null, r0, r4, r9, null);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        r4 = null;
        goto L13
    L5:
        r11 = null;
        goto L7
    }

    public final void r(ECDraweeView r10, ECUrlModel r11, Function0<Unit> r12) {
        if (r11 == null) goto L9;
        ImageExtensionsKt.D(r10, new com.bytedance.android.ec.core.imagex.r("ec_detail", "ec_product_header_image"));
        y.c(r10, r11, -1, -1, new z53.a(r11.getUrlList(), ImagePosition.GOODS_HEADER.getValue(), r12, false, 24));
        d r13 = this.g;
        if (r13 != null) goto L6;
    L8:
        r10.setVisibility(0);
        return;
    L6:
        if (r13.i() != true) goto L8;
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        r14.width = -1;
        r14.height = -2;
        Unit r15 = Unit.INSTANCE;
        r10.setLayoutParams(r14);
        r10.setAdjustMode(2);
        goto L8
    L9:
        r10.setVisibility(8);
    }

    public View x(T r1, Integer r2, int r3) {
        return w(r1);
    }

    public final void s(View r2, String r3, T r4, Integer r5) {
        r2.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(2131101703));
        if ((!Intrinsics.areEqual(r3, HeadViewType.VIDEO.getType())) == false) goto L6;
        r2.setOnClickListener(new a(this, r4, r5));
        return;
    }
}
