package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.s0;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowCouponPresenter extends ECWindowHolderBaseFragmentPresenter {
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public com.bytedance.android.window.shop.repository.dto.q.c t;

    public static final class a {
        public final String a;

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "secAuthorId");
            this.a = r2;
        }
    }

    public final void c0() {
        s0.e(this);
    }

    public WindowCouponPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.i = LazyKt.lazy(new WindowCouponPresenter$tvNotice$2(this));
        this.j = LazyKt.lazy(new WindowCouponPresenter$tvDiscountPrefix$2(this));
        this.k = LazyKt.lazy(new WindowCouponPresenter$tvDiscountPrefixWrapper$2(this));
        this.l = LazyKt.lazy(new WindowCouponPresenter$tvDiscountDesc$2(this));
        this.m = LazyKt.lazy(new WindowCouponPresenter$tvDiscountSuffix$2(this));
        this.n = LazyKt.lazy(new WindowCouponPresenter$tvDiscountExtraDesc$2(this));
        this.o = LazyKt.lazy(new WindowCouponPresenter$tvCouponDiscountNoticePrefix$2(this));
        this.p = LazyKt.lazy(new WindowCouponPresenter$tvCouponDiscountNoticeDesc$2(this));
        this.q = LazyKt.lazy(new WindowCouponPresenter$tvCouponDiscountNoticeSuffix$2(this));
        this.r = LazyKt.lazy(new WindowCouponPresenter$initClickForOnce$2(this));
        this.s = LazyKt.lazy(new WindowCouponPresenter$reportShowEventForOnce$2(this));
    }

    public final void b0(QModel r3) {
        fo.b r0 = d0().getOverallData();
        fo.a<tq3.a> r1 = tq3.a.k;
        tq3.a r2 = (tq3.a) r0.a(tq3.a.k);
        com.bytedance.android.window.shop.repository.dto.q.c r4 = null;
        if (r2 == null) goto L5;
    L8:
        if (r2 == null) goto L12;
        List<com.bytedance.android.window.shop.repository.dto.q.c> r5 = r2.j;
        if (r5 == null) goto L12;
        r4 = (com.bytedance.android.window.shop.repository.dto.q.c) CollectionsKt.firstOrNull(r5);
    L12:
        this.t = r4;
        i0(r4);
        Unit r6 = (Unit) this.s.getValue();
        Unit r7 = (Unit) this.r.getValue();
        s0.c(this);
        return;
    L5:
        if ((r3 instanceof tq3.a) == true) goto L7;
        r3 = null;
    L7:
        r2 = (tq3.a) r3;
        goto L8
    }

    public final void i0(com.bytedance.android.window.shop.repository.dto.q.c r5) {
        TextView r0 = (TextView) this.i.getValue();
        if (r5 == null) goto L5;
        String r2 = r5.a();
    L6:
        j0(r0, r2, null);
        TextView r1 = (TextView) this.j.getValue();
        if (r5 == null) goto L11;
        com.bytedance.android.window.shop.repository.dto.q.b r3 = r5.c();
        if (r3 == null) goto L11;
        String r4 = r3.c();
    L12:
        j0(r1, r4, (ViewGroup) this.k.getValue());
        TextView r6 = (TextView) this.l.getValue();
        if (r5 == null) goto L17;
        com.bytedance.android.window.shop.repository.dto.q.b r7 = r5.c();
        if (r7 == null) goto L17;
        String r8 = r7.a();
    L18:
        j0(r6, r8, null);
        TextView r9 = (TextView) this.m.getValue();
        if (r5 == null) goto L23;
        com.bytedance.android.window.shop.repository.dto.q.b r10 = r5.c();
        if (r10 == null) goto L23;
        String r11 = r10.d();
    L24:
        j0(r9, r11, null);
        TextView r12 = (TextView) this.n.getValue();
        if (r5 == null) goto L29;
        com.bytedance.android.window.shop.repository.dto.q.b r13 = r5.c();
        if (r13 == null) goto L29;
        String r14 = r13.b();
    L30:
        j0(r12, r14, null);
        TextView r15 = (TextView) this.o.getValue();
        if (r5 == null) goto L35;
        com.bytedance.android.window.shop.repository.dto.q.a r16 = r5.b();
        if (r16 == null) goto L35;
        String r17 = r16.b();
    L36:
        j0(r15, r17, null);
        TextView r18 = (TextView) this.p.getValue();
        if (r5 == null) goto L41;
        com.bytedance.android.window.shop.repository.dto.q.a r19 = r5.b();
        if (r19 == null) goto L41;
        String r20 = r19.a();
    L42:
        j0(r18, r20, null);
        TextView r21 = (TextView) this.q.getValue();
        if (r5 == null) goto L47;
        com.bytedance.android.window.shop.repository.dto.q.a r22 = r5.b();
        if (r22 == null) goto L47;
        String r23 = r22.c();
    L48:
        j0(r21, r23, null);
        return;
    L47:
        r23 = null;
    L41:
        r20 = null;
    L35:
        r17 = null;
    L29:
        r14 = null;
    L23:
        r11 = null;
    L17:
        r8 = null;
    L11:
        r4 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onCouponVOUpdated(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((!Intrinsics.areEqual(r2.a, d0().getShopParam().getSecAuthorId())) == false) goto L5;
        return;
    L5:
        fo.b r3 = d0().getOverallData();
        fo.a<tq3.a> r0 = tq3.a.k;
        tq3.a r4 = (tq3.a) r3.a(tq3.a.k);
        if (r4 == null) goto L10;
        List<com.bytedance.android.window.shop.repository.dto.q.c> r5 = r4.j;
        if (r5 == null) goto L10;
        com.bytedance.android.window.shop.repository.dto.q.c r6 = (com.bytedance.android.window.shop.repository.dto.q.c) CollectionsKt.firstOrNull(r5);
    L11:
        this.t = r6;
        i0(r6);
        return;
    L10:
        r6 = null;
        goto L11
    }

    public static void j0(TextView r2, String r3, ViewGroup r4) {
        if (r4 != null) goto L6;
        View r5 = r2;
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        r5.setVisibility(8);
        return;
    L14:
        r5.setVisibility(0);
        r2.setText(r3);
        return;
    L8:
        if (StringsKt.isBlank(r3) == true) goto L11;
        r1 = false;
        goto L12
    }
}
