package com.larus.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes29.dex */
public final class c extends n0<Object> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e<Object> f363786m;

    public c(e r100, d r101, CoroutineDispatcher r102) {
        this.f363786m = r100;
        super(r101, r102);
    }

    @Override // com.larus.paging.n0
    public final Object c(f0 r110, f0 r210, int r211, Function0 r212, Continuation r213) {
        a0 r100 = r110;
        a0 r101 = r210;
        if ((r213 instanceof AsyncPagingDataDiffer$differBase$1$presentNewList$1) == false) goto L7;
        AsyncPagingDataDiffer$differBase$1$presentNewList$1 r102 = (AsyncPagingDataDiffer$differBase$1$presentNewList$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        int r107 = r102.I$0;
        Function0 r108 = (Function0) r102.L$3;
        a0 r109 = (a0) r102.L$2;
        a0 r111 = (a0) r102.L$1;
        c r112 = (c) r102.L$0;
        ResultKt.throwOnFailure(r104);
        int r113 = r107;
        r100 = r111;
        Function0 r114 = r108;
        r101 = r109;
        c r115 = r112;
        Object r116 = r104;
    L24:
        z r117 = (z) r116;
        r114.invoke();
        ListUpdateCallback r118 = r115.f363786m.f363807b;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r118, "callback");
        Intrinsics.checkNotNullParameter(r101, "newList");
        Intrinsics.checkNotNullParameter(r117, "diffResult");
        if (r117.f363950b == false) goto L47;
        int r119 = b0.f363777a;
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        Intrinsics.checkNotNullParameter(r118, "callback");
        Intrinsics.checkNotNullParameter(r117, "diffResult");
        b0.a r120 = new b0.a(r100, r101, r118);
        r117.f363949a.dispatchUpdatesTo(r120);
        int r121 = Math.min(r120.f363778a.a(), r120.f363781d);
        int r122 = r120.f363779b.a() - r120.f363781d;
        if (r122 <= 0) goto L31;
        if (r121 <= 0) goto L30;
        r120.f363780c.onChanged(0, r121, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
    L30:
        r120.f363780c.onInserted(0, r122);
    L35:
        r120.f363781d = r120.f363779b.a();
        int r123 = Math.min(r120.f363778a.e(), r120.f363782e);
        int r124 = r120.f363779b.e();
        int r125 = r120.f363782e;
        int r126 = r124 - r125;
        int r127 = (r120.f363781d + r120.f363783f) + r125;
        int r128 = r127 - r123;
        if (r128 == (r120.f363778a.getSize() - r123)) goto L38;
        boolean r129 = true;
    L39:
        if (r126 <= 0) goto L41;
        r120.f363780c.onInserted(r127, r126);
    L43:
        if (r123 <= 0) goto L46;
        if (r129 == false) goto L46;
        r120.f363780c.onChanged(r128, r123, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
    L46:
        r120.f363782e = r120.f363779b.e();
    L67:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r117, "diffResult");
        Intrinsics.checkNotNullParameter(r101, "newList");
        if (r117.f363950b == true) goto L70;
        int r130 = RangesKt.coerceIn(r113, RangesKt.until(0, r101.getSize()));
    L94:
        return Boxing.boxInt(r130);
    L70:
        int r131 = r113 - r100.a();
        int r132 = r100.d();
        if (r131 < 0) goto L74;
        if (r131 >= r132) goto L74;
        boolean r133 = true;
    L75:
        if (r133 == false) goto L92;
        int r134 = 0;
    L78:
        if (r134 >= 30) goto L92;
        int r135 = r134 / 2;
        if ((r134 % 2) != 1) goto L82;
        int r136 = -1;
    L83:
        int r137 = (r135 * r136) + r131;
        if (r137 < 0) goto L91;
        if (r137 >= r100.d()) goto L91;
        int r138 = r117.f363949a.convertOldPositionToNew(r137);
        if (r138 == (-1)) goto L91;
        r130 = r101.a() + r138;
    L91:
        r134 = r134 + 1;
        goto L78
    L82:
        r136 = 1;
    L92:
        r130 = RangesKt.coerceIn(r113, RangesKt.until(0, r101.getSize()));
    L74:
        r133 = false;
        goto L75
    L41:
        if (r126 >= 0) goto L43;
        r120.f363780c.onRemoved(r127 + r126, -r126);
        r123 = r123 + r126;
        goto L43
    L38:
        r129 = false;
        goto L39
    L31:
        if (r122 >= 0) goto L35;
        r120.f363780c.onRemoved(0, -r122);
        int r139 = r121 + r122;
        if (r139 <= 0) goto L35;
        r120.f363780c.onChanged(0, r139, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
        goto L35
    L47:
        int r140 = m.f363879a;
        Intrinsics.checkNotNullParameter(r118, "callback");
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        int r141 = Math.max(r100.a(), r101.a());
        int r142 = Math.min(r100.a() + r100.d(), r101.a() + r101.d());
        int r143 = r142 - r141;
        if (r143 <= 0) goto L50;
        r118.onRemoved(r141, r143);
        r118.onInserted(r141, r143);
    L50:
        int r144 = Math.min(r141, r142);
        int r145 = Math.max(r141, r142);
        int r146 = RangesKt.coerceAtMost(r100.a(), r101.getSize());
        int r147 = RangesKt.coerceAtMost(r100.a() + r100.d(), r101.getSize());
        DiffingChangePayload r148 = DiffingChangePayload.ITEM_TO_PLACEHOLDER;
        int r149 = r144 - r146;
        if (r149 <= 0) goto L53;
        r118.onChanged(r146, r149, r148);
    L53:
        int r150 = r147 - r145;
        if (r150 <= 0) goto L56;
        r118.onChanged(r145, r150, r148);
    L56:
        int r151 = RangesKt.coerceAtMost(r101.a(), r100.getSize());
        int r152 = RangesKt.coerceAtMost(r101.a() + r101.d(), r100.getSize());
        DiffingChangePayload r153 = DiffingChangePayload.PLACEHOLDER_TO_ITEM;
        int r154 = r144 - r151;
        if (r154 <= 0) goto L59;
        r118.onChanged(r151, r154, r153);
    L59:
        int r155 = r152 - r145;
        if (r155 <= 0) goto L62;
        r118.onChanged(r145, r155, r153);
    L62:
        int r156 = r101.getSize() - r100.getSize();
        if (r156 <= 0) goto L65;
        r118.onInserted(r100.getSize(), r156);
        goto L67
    L65:
        if (r156 >= 0) goto L67;
        r118.onRemoved(r100.getSize() + r156, -r156);
        goto L67
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r110.getSize() != 0) goto L18;
        r212.invoke();
        this.f363786m.f363809d.onInserted(0, r210.getSize());
        return null;
    L18:
        if (r210.getSize() != 0) goto L20;
        r212.invoke();
        this.f363786m.f363809d.onRemoved(0, r110.getSize());
        return null;
    L20:
        e<Object> r157 = this.f363786m;
        CoroutineDispatcher r158 = r157.f363808c;
        AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 r159 = new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(r100, r101, r157, null);
        r102.L$0 = this;
        r102.L$1 = r100;
        r102.L$2 = r101;
        r114 = r212;
        r102.L$3 = r114;
        r113 = r211;
        r102.I$0 = r113;
        r102.label = 1;
        r116 = BuildersKt.withContext(r158, r159, r102);
        if (r116 != r105) goto L23;
        return r105;
    L23:
        r115 = this;
    L7:
        r102 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, r213);
        goto L8
    }
}
