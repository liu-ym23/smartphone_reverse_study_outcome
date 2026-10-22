package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.AnchorV4VideoView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.shopping.anchorv4.voavhs.head.base.b<h83.g> {
    public Function2<? super Integer, ? super Float, Unit> i;
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b> j;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d k;
    public final l53.b l;
    public final boolean m;

    public final class a implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.k {
        public final AnchorV4VideoView a;
        public AnchorV4VideoView b;
        public final h83.g c;
        public final Integer d;
        public final int e;
        public final /* synthetic */ r f;

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
        public final void onPause() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
        public final void onResume() {
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
        public final void c() {
            AnchorV4VideoView r0 = this.b;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
        public final void d() {
            AnchorV4VideoView r0 = this.b;
            if (r0 == null) goto L6;
            r0.d();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
        public final void onDestroy() {
            AnchorV4VideoView r0 = this.b;
            if (r0 == null) goto L6;
            r0.onDestroy();
            return;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
        public final void e(boolean r2) {
            AnchorV4VideoView r0 = this.b;
            if (r0 == null) goto L6;
            r0.e(r2);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final AnchorV4VideoView g(Function0<Unit> r9) {
            GaussianBlurConfig r4 = null;
            Object[] r5 = 0 == true ? 1 : 0;
            AnchorV4VideoView r0 = new AnchorV4VideoView(this.f.getContext(), r5, 6, 0);
            r0.setIsSmallComponent(this.f.m);
            this.b = r0;
            h83.g r1 = this.c;
            r r2 = this.f;
            com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3 = r2.g;
            Integer r6 = this.d;
            r0.k(r1, r3, new s(r2, r1, r2.k, r6), r9);
            final r r10 = this.f;
            final h83.g r7 = this.c;
            final int r8 = this.e;
            r10.getClass();
            Function1<Float, Unit> r11 = new VideoHolderBuilder$processVideoView$$inlined$let$lambda$1(r10, r8, r7);
            Intrinsics.checkNotNullParameter(r11, "listener");
            ((ArrayList) r0.i).add(r11);
            List<com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.b> r12 = r10.j;
            ArrayList r13 = (ArrayList) r12;
            r13.add(new u(r0));
            if (r7 == null) goto L5;
            r4 = r7.h;
        L5:
            r0.m(r4);
            return r0;
        }

        public a(r r1, h83.g r2, Integer r3, int r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
            this.a = g(null);
            r1.getClass();
            Intrinsics.checkNotNullParameter(this, "listener");
            ((ArrayList) r1.a).add(this);
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b, com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void i(float r1) {
    }

    public static AnchorV4VideoView A(View r2) {
        if ((r2 instanceof ViewGroup) == true) goto L5;
        r2 = null;
    L5:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L11;
        List r4 = com.bytedance.commerce.base.view.b.a(r3);
        if (r4 == null) goto L11;
        View r5 = (View) CollectionsKt.getOrNull(r4, CollectionsKt.getLastIndex(r4));
        if (r5 == null) goto L11;
    L13:
        if ((r5 instanceof AnchorV4VideoView) == false) goto L16;
        return (AnchorV4VideoView) r5;
    L16:
        if ((r5 instanceof q) == false) goto L20;
        ((q) r5).getClass();
        throw null;
    L20:
        return null;
    L11:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.j
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.m g(final com.bytedance.android.shopping.anchorv4.voavhs.head.c r15) {
        Intrinsics.checkNotNullParameter(r15, "nodeVO");
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r0 = r15.i;
        GaussianBlurConfig r1 = null;
        if (r0 == null) goto L5;
        int r2 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.f;
        String r3 = r0.k(null);
    L7:
        if (Intrinsics.areEqual(r3, "3_4") == false) goto L9;
    L10:
        r1 = new GaussianBlurConfig(null, null, null, 7, null);
    L11:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r4 = r15.i;
        String r5 = r15.j;
        ECUrlModel r6 = r15.h;
        l53.b r7 = this.l;
        String r8 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J.get(Integer.valueOf(com.bytedance.android.shopping.anchorv4.voavhs.head.c.a.a(r15.m)));
        String r9 = r15.u;
        GaussianBlurConfig r10 = r15.w;
        if (r10 != null) goto L14;
        GaussianBlurConfig r11 = r1;
    L15:
        boolean r12 = Intrinsics.areEqual(r15.getType(), HeadViewType.GOOD_COMMENT.getType());
        h83.a r13 = r15.B;
        if (r13 == null) goto L21;
        CommentVideoInfo r14 = r13.a;
        if (r14 == null) goto L21;
        r14.getMoreText();
    L21:
        return new h83.g(r4, r5, r6, r7, r8, r9, r11, r12, r13, new VideoHolderBuilder$trans2CustomHolderVO$1(r15), r15.D);
    L14:
        r11 = r10;
        goto L15
    L9:
        if (Intrinsics.areEqual(r3, "9_16") == false) goto L11;
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.base.i u(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r3, Integer r4) {
        return new s(this, (h83.g) r3, this.k, r4);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final List v(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r14, Function0 r15) {
        h83.g r16 = (h83.g) r14;
        Intrinsics.checkNotNullParameter(r15, "rootView");
        boolean r0 = false;
        if (r16 != null) goto L5;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L15;
        return CollectionsKt.emptyList();
    L15:
        if (r16 != null) goto L17;
    L21:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L25;
        t r6 = null;
    L27:
        if (r16 == null) goto L29;
        String r8 = r16.g;
    L30:
        if (r16 != null) goto L32;
    L36:
        boolean r9 = false;
    L37:
        if (r16 != null) goto L39;
    L45:
        String r10 = null;
    L46:
        if (r16 != null) goto L48;
    L52:
        if (r0 == false) goto L56;
        AnchorV4VideoView r17 = A((View) r15.invoke());
        if (r17 == null) goto L56;
        Float r18 = r17.getVideoProgress();
    L58:
        return CollectionsKt.listOf(new com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.f(null, null, null, r6, null, r8, r9, r18, r10, 1079));
    L56:
        r18 = null;
        goto L58
    L48:
        if (r16.i != true) goto L52;
        if (r16.l == false) goto L52;
        r0 = true;
        goto L52
    L39:
        if (r16.i != true) goto L45;
        if (r16.l == false) goto L45;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r11 = r16.a;
        if (r11 == null) goto L45;
        r10 = com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b.d(r11);
        goto L46
    L32:
        if (r16.i != true) goto L36;
        if (r16.l == false) goto L36;
        r9 = true;
        goto L37
    L29:
        r8 = null;
        goto L30
    L25:
        r6 = new t(this, r15, r16);
        goto L27
    L17:
        if (r16.i != true) goto L21;
        if (r16.l == false) goto L21;
        r5 = true;
        goto L23
    L5:
        if (r16.i != true) goto L11;
        if (r16.j == null) goto L11;
        if (r16.l == true) goto L11;
        r2 = true;
        goto L12
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final View x(com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r2, Integer r3, int r4) {
        return new a(this, (h83.g) r2, r3, r4).a;
    }

    public r(Context r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r3, l53.b r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.k = r3;
        this.l = r4;
        this.m = r5;
        this.j = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.b
    public final void z(Context r1, View r2, com.bytedance.android.shopping.anchorv4.voavhs.head.base.m r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter((h83.g) r3, "headNodeVO");
        ECDraweeView r5 = r2.findViewById(2131362814);
        r5.setAdjustMode(0);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        r6.width = -1;
        r6.height = -1;
        Unit r7 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        r5.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    }
}
