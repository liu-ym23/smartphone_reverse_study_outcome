package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedQueryParam;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import he3.e1;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSlcOpenAction extends b {
    public DeepFeedSlcOpenAction(w r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r23, View r24) {
        Intrinsics.checkNotNullParameter(r23, "action");
        Intrinsics.checkNotNullParameter(r24, "targetView");
        Map r1 = r23.getParams();
        String r9 = null;
        if (r1 == null) goto L5;
        Object r2 = r1.get("link");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        final String r3 = (String) r2;
        Map r4 = r23.getParams();
        if (r4 == null) goto L12;
        Object r5 = r4.get("type");
    L14:
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        String r10 = (String) r5;
        Map r6 = r23.getParams();
        if (r6 == null) goto L19;
        Object r7 = r6.get("btm");
    L21:
        if ((r7 instanceof String) == true) goto L23;
        r7 = null;
    L23:
        String r8 = (String) r7;
        Map r11 = r23.getParams();
        if (r11 == null) goto L26;
        Object r12 = r11.get("btmAppendIndex");
    L28:
        if ((r12 instanceof Boolean) == true) goto L30;
        r12 = null;
    L30:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L33;
        boolean r14 = r13.booleanValue();
    L34:
        Map r15 = r23.getParams();
        if (r15 == null) goto L37;
        Object r16 = r15.get("btmAppendBcm");
    L39:
        if ((r16 instanceof Boolean) == true) goto L41;
        r16 = null;
    L41:
        Boolean r17 = (Boolean) r16;
        if (r17 == null) goto L44;
        boolean r18 = r17.booleanValue();
    L46:
        if (r3 != null) goto L49;
        r3 = "";
    L49:
        if (StringsKt.startsWith$default(r3, "$", false, 2, null) == false) goto L52;
        r3 = this.c.s(r3);
    L52:
        if (r3 != null) goto L54;
        return false;
    L54:
        final com.bytedance.android.shopping.deepfeed.action.d r19 = this.c.c();
        w r110 = this.c;
        if (r10 != null) goto L57;
        String r20 = "";
    L58:
        if (r8 != null) goto L60;
        String r21 = "";
    L61:
        final vc3.c r22 = r110.j(new vc3.d(r20, r21, r14, r18, r24));
        if (r10 != null) goto L65;
    L113:
        if (r19 == null) goto L118;
        String r25 = r22.d;
        if (r10 != null) goto L117;
        r10 = "";
    L117:
        r19.k(r25, r3, r10);
    L118:
        return false;
    L65:
        switch(r10.hashCode()) {
            case -1236338690: goto L110;
            case -906336856: goto L106;
            case -425218655: goto L101;
            case 97926: goto L97;
            case 3322092: goto L89;
            case 3529462: goto L85;
            case 950398559: goto L81;
            case 1877982225: goto L78;
            case 2059707431: goto L68;
            default: goto L113;
        };
    L68:
        if (r10.equals("coupon_waist") == false) goto L113;
        w r26 = this.c;
        int r27 = r22.b;
        InFeedProductV2 r28 = r22.a;
        if (r28 == null) goto L74;
        e1 r29 = com.bytedance.android.shopping.deepfeed.utlis.a.a(r28);
        if (r29 == null) goto L74;
        r9 = r29.a();
    L74:
        r26.z(r27, r9);
        if (r19 == null) goto L118;
        String r30 = r22.d;
        int r31 = com.bytedance.android.shopping.deepfeed.action.d.h;
        r19.k(r30, r3, "");
        goto L118
    L78:
        if (r10.equals("pause_search") == false) goto L113;
        this.c.t(new DeepFeedSlcOpenAction$onHandleAction$1(r3, r19, r22));
        goto L118
    L81:
        if (r10.equals("comment") == false) goto L113;
        if (r19 == null) goto L118;
        r19.d(r22.a, r22.d, r3);
        goto L118
    L85:
        if (r10.equals("shop") == false) goto L113;
        if (r19 == null) goto L118;
        r19.h(r22.a, r22.c, r22.d, r3);
        goto L118
    L89:
        if (r10.equals("live") == false) goto L113;
        if (r19 == null) goto L118;
        InFeedProductV2 r32 = r22.a;
        int r33 = r22.b;
        String r34 = r22.e;
        if (r34 != null) goto L94;
        String r35 = "";
    L95:
        r19.e(r32, r3, r33, r35, r24);
        goto L118
    L94:
        r35 = r34;
        goto L95
    L97:
        if (r10.equals("buy") == false) goto L113;
        if (r19 == null) goto L118;
        InFeedProductV2 r111 = r22.a;
        String r36 = r22.d;
        r19.b(r111, r22.c, r22.b, r22.f, r22.g, r22.h, r36, r3);
        goto L118
    L101:
        if (r10.equals("product_detail") == false) goto L113;
        this.c.w(r22.b);
        if (r19 == null) goto L118;
        InFeedProductV2 r112 = r22.a;
        int r113 = r22.b;
        DeepFeedQueryParam r37 = r22.c;
        String r38 = r22.d;
        int r39 = com.bytedance.android.shopping.deepfeed.action.d.h;
        r19.f(r112, r113, r37, r38, r3, false);
        goto L118
    L106:
        if (r10.equals("search") == false) goto L113;
        if (r19 == null) goto L118;
        r19.g(r22.a, r22.d, r3);
        goto L118
    L110:
        if (r10.equals("add_cart") == false) goto L113;
        if (r19 == null) goto L118;
        r19.a(r22.a, r22.c, r22.b, r22.f, r22.g, r22.d, r3);
        goto L118
    L60:
        r21 = r8;
        goto L61
    L57:
        r20 = r10;
        goto L58
    L44:
        r18 = true;
        goto L46
    L37:
        r16 = null;
        goto L39
    L33:
        r14 = true;
        goto L34
    L26:
        r12 = null;
        goto L28
    L19:
        r7 = null;
        goto L21
    L12:
        r5 = null;
        goto L14
    L5:
        r2 = null;
        goto L7
    }
}
