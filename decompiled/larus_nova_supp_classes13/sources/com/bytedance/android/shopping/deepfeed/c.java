package com.bytedance.android.shopping.deepfeed;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.google.gson.JsonElement;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import he3.h2;
import he3.k0;
import he3.m2;
import he3.n0;
import he3.p0;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ DeepFeedProductFragment a;

    public c(DeepFeedProductFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        he3.l r15 = (he3.l) r14;
        if (r15 == null) goto L104;
        Map<Long, he3.j> r0 = r15.b();
        if (r0 == null) goto L105;
        he3.j r1 = (he3.j) CollectionsKt.firstOrNull(r0.values());
        ConstraintLayout r2 = null;
        if (r1 == null) goto L9;
        JsonElement r3 = r1.c();
    L10:
        if (r3 == null) goto L12;
        String r4 = u0.d(r3);
    L13:
        he3.j r5 = (he3.j) CollectionsKt.firstOrNull(r0.values());
        if (r5 == null) goto L16;
        m2 r6 = r5.d();
    L17:
        AbsDeepFeedProductVH r7 = this.a.v;
        if (r7 == null) goto L31;
        InFeedProductV2 r8 = r7.m;
        if (r8 == null) goto L31;
        InFeedProductPackData r9 = r8.getPackData();
        if (r9 == null) goto L31;
        InFeedProductPackDataElements r10 = r9.getElements();
        if (r10 == null) goto L31;
        List<p0> r11 = r10.getProducts();
        if (r11 == null) goto L31;
        p0 r12 = (p0) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L31;
        h2 r13 = r12.l();
        if (r13 == null) goto L31;
    L45:
        boolean r16 = com.bytedance.android.shopping.deepfeed.utlis.h.c(r13);
        boolean r17 = com.bytedance.android.shopping.deepfeed.utlis.h.b(r13);
        if (r4.length() != 0) goto L48;
        boolean r18 = true;
    L50:
        if (r18 == false) goto L52;
    L54:
        Long r19 = r15.a();
        if (r19 != null) goto L58;
    L70:
        Long r20 = r15.a();
        if (r20 != null) goto L74;
    L78:
        Long r21 = r15.a();
        if (r21 != null) goto L82;
    L83:
        Context r22 = this.a.getContext();
        if (r22 == null) goto L89;
        int r23 = ed3.d.a;
        String r24 = r15.c();
        if (r24 != null) goto L88;
        r24 = "领券未成功，稍后再试试哦";
    L88:
        Intrinsics.checkNotNullParameter(r22, "ctx");
        Intrinsics.checkNotNullParameter(r24, "str");
    L89:
        if (r17 == true) goto L113;
        View r25 = this.a.getView();
        if (r25 == null) goto L94;
        r2 = (ConstraintLayout) r25.findViewById(2131368693);
    L94:
        if (r2 == null) goto L110;
        dd3.d r26 = (dd3.d) this.a.H0.getValue();
        if (r26 == null) goto L98;
        r26.a(new b(r0, this, r15));
    L98:
        DeepFeedProductFragment r110 = this.a;
        if (r110.t >= 10) goto L111;
        dd3.d r111 = (dd3.d) r110.H0.getValue();
        if (r111 == null) goto L112;
        r111.b(this.a.getLifecycle(), r2, r4, this.a.aa0());
        return;
    L112:
        return;
    L111:
        return;
    L110:
        return;
    L113:
        return;
    L82:
        if (r21.longValue() == 2) goto L89;
    L74:
        if (r20.longValue() != 10) goto L78;
        DeepFeedProductFragment r27 = this.a;
        AbsDeepFeedProductVH r28 = r27.v;
        if (r28 == null) goto L108;
        r28.y4(r15, r27.aa0());
        return;
    L108:
        return;
    L58:
        if (r19.longValue() != 2) goto L70;
        if (r16 == true) goto L67;
        Context r29 = this.a.getContext();
        if (r29 == null) goto L67;
        if (r6 == null) goto L66;
        String r30 = r6.a();
        if (r30 == null) goto L66;
        int r31 = ed3.d.a;
        Intrinsics.checkNotNullParameter(r29, "ctx");
        Intrinsics.checkNotNullParameter(r30, "line1");
    L66:
        int r32 = ed3.d.a;
        Intrinsics.checkNotNullParameter(r29, "ctx");
        Intrinsics.checkNotNullParameter("领取成功", "str");
    L67:
        DeepFeedProductFragment r33 = this.a;
        AbsDeepFeedProductVH r34 = r33.v;
        if (r34 == null) goto L106;
        r34.y4(r15, r33.aa0());
        return;
    L106:
        return;
    L52:
        if (((dd3.d) this.a.H0.getValue()) == null) goto L54;
        if (r17 == false) goto L70;
    L48:
        r18 = false;
    L31:
        AbsDeepFeedProductVH r35 = this.a.v;
        if (r35 == null) goto L44;
        InFeedProductV2 r36 = r35.m;
        if (r36 == null) goto L44;
        InFeedProductPackData r37 = r36.getPackData();
        if (r37 == null) goto L44;
        InFeedProductPackDataElements r38 = r37.getElements();
        if (r38 == null) goto L44;
        n0 r39 = r38.getSliceCard();
        if (r39 == null) goto L44;
        k0 r40 = r39.e();
        if (r40 == null) goto L44;
        r13 = r40.f();
    L44:
        r13 = null;
        goto L45
    L16:
        r6 = null;
        goto L17
    L12:
        r4 = "";
        goto L13
    L9:
        r3 = null;
        goto L10
    L105:
        return;
    }
}
