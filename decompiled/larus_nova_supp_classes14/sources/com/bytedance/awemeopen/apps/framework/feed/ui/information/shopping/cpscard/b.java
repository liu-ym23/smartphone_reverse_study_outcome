package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard.Coupon;
import com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard.CpsShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.feed.shopping.cpscard.ProductDetail;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends BaseElement<j, k, tz3.a, jz3.a> {
    public final Activity g;
    public final LifecycleOwner h;
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o i;
    public r14.c j;
    public final C0092b k;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard.b$b, reason: collision with other inner class name */
    public static final class C0092b extends com.bytedance.awemeopen.infra.util.j {
        public final /* synthetic */ b c;

        /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard.b$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Lifecycle.Event.values().length];
                r0[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public C0092b(b r1) {
            this.c = r1;
        }

        public final void a(LifecycleOwner r2, Lifecycle.Event r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (a.a[r3.ordinal()] != 1) goto L6;
            b r4 = this.c;
            Lifecycle r5 = r4.h.getLifecycle();
            C0092b r6 = r4.k;
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Intrinsics.checkNotNullParameter(r6, "observer");
            r5.removeObserver(((com.bytedance.awemeopen.infra.util.j) r6).b);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.j = null;
        Lifecycle r0 = this.h.getLifecycle();
        C0092b r1 = this.k;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.removeObserver(((com.bytedance.awemeopen.infra.util.j) r1).b);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new j();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new k();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new i(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        r14.c r1 = this.j;
        if (r1 == null) goto L41;
        CpsShoppingCardInfo r2 = r1.n();
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = this.i.sceneId();
        User r6 = r1.f();
        String r7 = null;
        if (r6 == null) goto L8;
        String r8 = r6.u();
    L10:
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        String r9 = r1.c();
        String r10 = r1.r().c;
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        if (b14.a.a(y24.d.class).E1(r1) == false) goto L18;
        String r11 = CommentScene.COMMENTSCENE_NO_AWEME;
    L19:
        ProductDetail r12 = r2.getProductDetail();
        if (r12 == null) goto L22;
        String r13 = r12.getProductId();
    L23:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        String r14 = this.i.getPageConfig().getHostEnterFrom();
        r14.c r15 = this.j;
        if (r15 == null) goto L30;
        a0 r16 = r15.d;
        if (r16 == null) goto L30;
        String r17 = r16.a();
    L31:
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        r14.c r18 = this.j;
        if (r18 == null) goto L36;
        r7 = r18.r().d;
    L36:
        if (r7 != null) goto L38;
        String r19 = "";
    L39:
        r4.l1(r5, r8, r9, r10, r11, r13, r14, r17, r19, r1.i(), this.i.getPageConfig().isCardMode(), this.i.getPageConfig().getHostExtraParams());
        return;
    L38:
        r19 = r7;
    L30:
        r17 = null;
        goto L31
    L22:
        r13 = null;
        goto L23
    L18:
        r11 = "0";
        goto L19
    L8:
        r8 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        j r0 = g();
        Observer<Unit> r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.cpscard.a(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.e;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public static String q(long r5) {
        StringBuilder r0 = new StringBuilder();
        long r1 = 100;
        r0.append(r5 / r1);
        long r6 = r5 % r1;
        if (r6 == 0) goto L5;
        String r7 = "." + r6;
    L6:
        r0.append(r7);
        return r0.toString();
    L5:
        r7 = "";
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r12) {
        jz3.a r13 = r12;
        Intrinsics.checkNotNullParameter(r13, "data");
        r14.c r14 = r13.a;
        this.j = r14;
        String r0 = null;
        if (r14 == null) goto L5;
        CpsShoppingCardInfo r15 = r14.n();
    L6:
        if (r15 == null) goto L10;
        ProductDetail r1 = r15.getProductDetail();
        if (r1 == null) goto L10;
        Long r2 = r1.getPrice();
    L11:
        if (r2 == null) goto L105;
        String r3 = r15.getDeepLink();
        boolean r4 = true;
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L105;
        k r6 = h();
        ProductDetail r7 = r15.getProductDetail();
        if (r7 == null) goto L25;
        List<String> r8 = r7.getImgUrls();
        if (r8 == null) goto L25;
    L26:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "urlList");
        r6.a.b(r8);
        k r9 = h();
        ProductDetail r10 = r15.getProductDetail();
        if (r10 == null) goto L29;
        String r11 = r10.getTitle();
    L30:
        r9.b.b(r11);
        ProductDetail r16 = r15.getProductDetail();
        if (r16 != null) goto L33;
    L37:
        boolean r17 = false;
    L38:
        k r18 = h();
        ProductDetail r19 = r15.getProductDetail();
        String r20 = "";
        if (r19 == null) goto L44;
        if (r17 == false) goto L42;
        Long r21 = r19.getCouponPrice();
        Intrinsics.checkNotNull(r21);
        String r22 = q(r21.longValue());
    L43:
        if (r22 == null) goto L44;
    L45:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r22, "price");
        r18.d.b(r22);
        k r23 = h();
        ProductDetail r24 = r15.getProductDetail();
        if (r24 == null) goto L51;
        if (r17 == false) goto L49;
        StringBuilder r25 = new StringBuilder("¥");
        Long r26 = r24.getPrice();
        Intrinsics.checkNotNull(r26);
        r25.append(q(r26.longValue()));
        String r27 = r25.toString();
    L50:
        if (r27 == null) goto L51;
    L52:
        r23.getClass();
        Intrinsics.checkNotNullParameter(r27, "originPrice");
        r23.e.b(r27);
        k r28 = h();
        if (r17 == false) goto L58;
        ProductDetail r29 = r15.getProductDetail();
        if (r29 == null) goto L58;
        Long r30 = r29.getPrice();
        Intrinsics.checkNotNull(r30);
        long r31 = r30.longValue();
        Long r32 = r29.getCouponPrice();
        Intrinsics.checkNotNull(r32);
        String r33 = q(r31 - r32.longValue());
        if (r33 == null) goto L58;
    L59:
        r28.getClass();
        Intrinsics.checkNotNullParameter(r33, "allowancePrice");
        r28.f.b(r33);
        ArrayList r34 = new ArrayList();
        ProductDetail r35 = r15.getProductDetail();
        if (r35 == null) goto L64;
        List r36 = r35.getAvailableCoupons();
        if (r36 == null) goto L64;
        int r37 = r36.size();
    L65:
        if (r37 != 1) goto L82;
        ProductDetail r38 = r15.getProductDetail();
        if (r38 == null) goto L77;
        List r39 = r38.getAvailableCoupons();
        if (r39 == null) goto L77;
        Coupon r40 = (Coupon) ListProtector.get(r39, 0);
        if (r40 == null) goto L77;
        String r41 = r40.getDiscountDesc();
        if (r41 == null) goto L77;
        r20 = r41;
    L77:
        if (r20.length() <= 0) goto L79;
        boolean r42 = true;
    L80:
        if (r42 == false) goto L84;
        r34.add(r20);
    L84:
        ProductDetail r43 = r15.getProductDetail();
        if (r43 == null) goto L87;
        boolean r44 = Intrinsics.areEqual(r43.isAssured(), Boolean.TRUE);
    L88:
        if (r44 == false) goto L90;
        r34.add(getContext().getString(2131894181));
    L90:
        ProductDetail r45 = r15.getProductDetail();
        if (r45 == null) goto L98;
        Integer r46 = r45.getCommodityActivityId();
        if (r46 == null) goto L98;
        if (r46.intValue() != 1) goto L98;
    L99:
        if (r4 == false) goto L101;
        r34.add(getContext().getString(2131894179));
    L101:
        k r47 = h();
        ProductDetail r110 = r15.getProductDetail();
        if (r110 == null) goto L104;
        r0 = r110.getShopName();
    L104:
        p r48 = new p(r34, r0);
        r47.getClass();
        Intrinsics.checkNotNullParameter(r48, "productDesc");
        r47.c.b(r48);
        p();
        return;
    L98:
        r4 = false;
        goto L99
    L87:
        r44 = false;
        goto L88
    L79:
        r42 = false;
        goto L80
    L82:
        if (r37 <= 1) goto L84;
        r34.add(getContext().getString(2131894178));
    L64:
        r37 = 0;
    L58:
        r33 = "";
        goto L59
    L49:
        r27 = "";
    L51:
        r27 = "";
        goto L52
    L42:
        Long r49 = r19.getPrice();
        Intrinsics.checkNotNull(r49);
        r22 = q(r49.longValue());
    L44:
        r22 = "";
        goto L45
    L33:
        if (r16.getCouponPrice() == null) goto L37;
        Long r50 = r16.getPrice();
        Intrinsics.checkNotNull(r50);
        long r51 = r50.longValue();
        Long r52 = r16.getCouponPrice();
        Intrinsics.checkNotNull(r52);
        if (r51 <= r52.longValue()) goto L37;
        r17 = true;
        goto L38
    L29:
        r11 = null;
    L25:
        r8 = CollectionsKt.emptyList();
        goto L26
    L15:
        if (r3.length() == 0) goto L18;
        r5 = false;
    L105:
        j();
        return;
    L10:
        r2 = null;
        goto L11
    L5:
        r15 = null;
        goto L6
    }

    public b(Activity r2, LifecycleOwner r3, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.k = new C0092b(this);
    }
}
