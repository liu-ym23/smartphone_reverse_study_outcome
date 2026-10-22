package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j0 extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public j0(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mallFeedScrollToTop";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r7, IBDXBridgeContext r8, Map<String, ? extends Object> r9, Map<String, Object> r10) {
        Intrinsics.checkNotNullParameter(r7, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "result");
        if ((!r9.isEmpty()) == false) goto L84;
        Object r11 = r9.get("type");
        Object r2 = null;
        if ((r11 instanceof String) == true) goto L7;
        r11 = null;
    L7:
        String r12 = (String) r11;
        int r1 = com.bytedance.android.ec.hybrid.list.util.c.a;
        Object r3 = r9.get("y");
        if ((r3 instanceof Integer) == true) goto L10;
        r3 = null;
    L10:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        int r6 = com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(r5));
        Object r13 = r9.get("animated");
        if ((r13 instanceof Boolean) == true) goto L17;
        r13 = null;
    L17:
        boolean r14 = !Intrinsics.areEqual((Boolean) r13, Boolean.FALSE);
        Object r15 = r9.get(ErrorPageButtonAction.REFRESH);
        if ((r15 instanceof Boolean) == false) goto L21;
        r2 = r15;
    L21:
        Boolean r16 = Boolean.TRUE;
        boolean r17 = Intrinsics.areEqual((Boolean) r2, r16);
        if (r12 == null) goto L62;
        int r18 = r12.hashCode();
        if (r18 == (-554435892)) goto L49;
        if (r18 == 115029) goto L46;
        if (r18 != 1728122231) goto L62;
        if (r12.equals("absolute") == false) goto L62;
        ECMallFeed r19 = r7.b;
        if (r14 == false) goto L40;
        ECHybridListEngine r20 = r19.J;
        if (r20 == null) goto L63;
        ECHybridRecyclerView r21 = r20.b;
        if (r21 == null) goto L63;
        r21.smoothScrollToPosition(r6);
    L63:
        if (r17 == false) goto L86;
        r7.b.A1.BQ(r16);
        com.bytedance.android.shopping.mall.feed.help.r r22 = r7.b.o1;
        if (r22 == null) goto L86;
        Keva r23 = r22.h;
        if (r23 == null) goto L86;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L82
        String[] r25 = r23.getStringArray("show_time_array", new String[0]);     // Catch: Throwable -> L82
        if (r25.length != 0) goto L72;
        boolean r26 = true;
    L74:
        if ((!r26) == false) goto L80;
        Object[] r27 = ArraysKt.dropLast(r25, 1).toArray(new String[0]);     // Catch: Throwable -> L82
        if (r27 == null) goto L79;
        r22.h.storeStringArray("show_time_array", (String[]) r27);     // Catch: Throwable -> L82
        goto L80
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Throwable -> L82
    L80:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L82
        goto L86
    L72:
        r26 = false;
    L82:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L86:
        return qf3.e.f(this);
    L40:
        ECHybridListEngine r29 = r19.J;
        if (r29 == null) goto L63;
        ECHybridRecyclerView r30 = r29.b;
        if (r30 == null) goto L63;
        r30.scrollToPosition(r6);
        r30.post(new com.bytedance.android.shopping.mall.feed.o0(r30, r19));
        goto L63
    L46:
        if (r12.equals("top") == false) goto L62;
        r7.b.i0(r14);
        goto L63
    L49:
        if (r12.equals("relative") == false) goto L62;
        ECMallFeed r31 = r7.b;
        if (r14 == false) goto L57;
        ECHybridListEngine r32 = r31.J;
        if (r32 == null) goto L63;
        ECHybridRecyclerView r33 = r32.b;
        if (r33 == null) goto L63;
        r33.smoothScrollBy(0, r6);
        goto L63
    L57:
        ECHybridListEngine r34 = r31.J;
        if (r34 == null) goto L63;
        ECHybridRecyclerView r35 = r34.b;
        if (r35 == null) goto L63;
        r35.scrollBy(0, r6);
        r35.post(new com.bytedance.android.shopping.mall.feed.n0(r35, r31));
    L62:
        r7.b.i0(r14);
        goto L63
    L13:
        r5 = 0;
        goto L14
    L84:
        r7.b.i0(false);
        goto L86
    }
}
