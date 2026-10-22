package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.bubble.BubbleOrientation;
import com.bytedance.android.shopping.orderlist.common.widgets.bubble.OrderCommonBubbleHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderCommonHeaderShowMenuFunction$onExecuteSync$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e $input;
    final /* synthetic */ Ref.ObjectRef $result;
    final /* synthetic */ f this$0;

    public OrderCommonHeaderShowMenuFunction$onExecuteSync$1(f r1, com.bytedance.kmp.ec.yata.event.common.e r2, Ref.ObjectRef r3) {
        this.this$0 = r1;
        this.$input = r2;
        this.$result = r3;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1879invoke() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonHeaderShowMenuFunction", AnonymousClass1.INSTANCE);
        com.bytedance.kmp.ec.yata.common.platform.o r1 = this.$input.m();
        if (r1 == null) goto L5;
        View r6 = r1.a;
    L7:
        if (r6 != null) goto L18;
        StringBuilder r2 = new StringBuilder("OrderCommonHeaderShowMenuFunction-doExecuteSync: targetView is null ");
        StringBuilder r7 = new StringBuilder("renderNodeKey:");
        com.bytedance.kmp.ec.yata.store.node.c r8 = this.$input.j();
        if (r8 == null) goto L11;
        String r9 = r8.getKey();
    L12:
        r7.append(r9);
        r7.append(' ');
        r2.append(r7.toString());
        StringBuilder r5 = new StringBuilder("name:");
        com.bytedance.kmp.ec.yata.store.node.c r4 = this.$input.j();
        if (r4 == null) goto L15;
        String r3 = r4.getNodeName();
    L16:
        r5.append(r3);
        r2.append(r5.toString());
        OrderCommonErrorMonitorKt.b(this.this$0.d.E0(), "SELF_FUN_ERROR", r2.toString());
        this.$result.element = new Pair(Boolean.FALSE, "targetView is null");
        return;
    L15:
        r3 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L18:
        f r10 = this.this$0;
        com.bytedance.kmp.ec.yata.event.common.e r11 = this.$input;
        r10.getClass();
        com.bytedance.kmp.ec.yata.store.node.c r12 = r11.j();
        if (r12 == null) goto L29;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r13 = r12.b.b;
        if (r13 == null) goto L26;
        Object r14 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r13, Reflection.getOrCreateKotlinClass(Number.class), "max_show_num");
        if ((r14 instanceof Number) == true) goto L25;
        r14 = null;
    L25:
        Number r15 = (Number) r14;
    L27:
        if (r15 == null) goto L29;
        int r16 = r15.intValue();
    L30:
        Map r17 = r11.q();
        if (r17 == null) goto L33;
        Object r18 = r17.get("button_list");
    L35:
        if ((r18 instanceof ArrayList) == true) goto L37;
        r18 = null;
    L37:
        ArrayList r19 = (ArrayList) r18;
        if (r19 != null) goto L106;
    L73:
        List r110 = 0;
    L75:
        if (r110 != 0) goto L77;
    L80:
        boolean r20 = true;
    L81:
        if (r20 == false) goto L91;
        StringBuilder r21 = new StringBuilder();
        StringBuilder r111 = new StringBuilder("OrderCommonHeaderShowMenuFunction-composeButtonList: ");
        int r112 = com.bytedance.android.ec.core.hybrid.utils.k.a;
        r111.append(com.bytedance.android.ec.core.hybrid.utils.k.b(r11.q()));
        r111.append("  ");
        r21.append(r111.toString());
        StringBuilder r113 = new StringBuilder("renderNodeKey:");
        com.bytedance.kmp.ec.yata.store.node.c r22 = r11.j();
        if (r22 == null) goto L85;
        String r23 = r22.getKey();
    L86:
        r113.append(r23);
        r113.append(' ');
        r21.append(r113.toString());
        StringBuilder r24 = new StringBuilder("name:");
        com.bytedance.kmp.ec.yata.store.node.c r25 = r11.j();
        if (r25 == null) goto L89;
        String r26 = r25.getNodeName();
    L90:
        r24.append(r26);
        r21.append(r24.toString());
        OrderCommonErrorMonitorKt.b(r10.d.E0(), "SELF_FUN_ERROR", r21.toString());
        goto L91
    L89:
        r26 = null;
        goto L90
    L85:
        r23 = null;
    L91:
        if (r110 != 0) goto L93;
        r110 = CollectionsKt.emptyList();
    L93:
        f r27 = this.this$0;
        com.bytedance.kmp.ec.yata.event.common.e r28 = this.$input;
        r27.getClass();
        LinearLayout r29 = new LinearLayout(r27.e);
        r29.setOrientation(1);
        Iterator r30 = r110.iterator();
        int r31 = 0;
    L95:
        if (r30.hasNext() == false) goto L104;
        Object r32 = r30.next();
        int r33 = r31 + 1;
        if (r31 >= 0) goto L99;
        CollectionsKt.throwIndexOverflow();
    L99:
        f.a r34 = (f.a) r32;
        View r114 = LayoutInflater.from(r27.e).inflate(2131564143, null, false);
        com.bytedance.android.ec.core.imagex.h0.e(r114.findViewById(2131381630), r34.c, new com.bytedance.android.ec.core.imagex.r("ec_na_order_list", "ec_order_list_header_show_menu"), null, null, 120);
        ((TextView) r114.findViewById(2131381631)).setText(r34.b);
        r114.setOnClickListener(new g(r27, r28, r34));
        r114.setContentDescription(r27.e.getResources().getString(2131912778, new Object[]{r34.b}));
        r29.addView(r114, new ViewGroup.LayoutParams(r34.e, r34.f));
        if (r31 == CollectionsKt.getLastIndex(r110)) goto L103;
        View r35 = new View(r27.e);
        r35.setBackgroundColor(ContextCompat.getColor(r27.e, 2131103975));
        r29.addView(r35, new ViewGroup.LayoutParams(r34.e, 1));
    L103:
        r31 = r33;
        goto L95
    L104:
        int r36 = OrderCommonBubbleHelper.a;
        f r37 = this.this$0;
        final PopupWindow r38 = OrderCommonBubbleHelper.a(new com.bytedance.android.shopping.orderlist.common.widgets.bubble.b(r37.e, r29, r6, BubbleOrientation.BOTTOM, r37.a, this.this$0.b * r110.size(), 0, null, 1984), new OrderCommonHeaderShowMenuFunction$onExecuteSync$1$popup$1(this));
        this.this$0.c = new AnonymousClass2(r38);
        return;
    L77:
        if (r110.isEmpty() == true) goto L80;
        r20 = false;
        goto L81
    L106:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L41
        Object r39 = Result.constructor-impl(r19.subList(0, r19.size() - r16));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r39) == false) goto L46;
        r39 = null;
    L46:
        List r40 = (List) r39;
        if (r40 == null) goto L73;
        r110 = new ArrayList();
        Iterator r41 = r40.iterator();
    L50:
        if (r41.hasNext() == false) goto L75;
        Map r116 = (Map) r41.next();
        Object r117 = r116.get("name");
        if ((r117 instanceof String) == true) goto L54;
        r117 = null;
    L54:
        String r118 = (String) r117;
        if (r118 != null) goto L57;
        String r119 = "";
    L58:
        Object r120 = r116.get("icon");
        if ((r120 instanceof String) == true) goto L61;
        r120 = null;
    L61:
        String r121 = (String) r120;
        if (r121 != null) goto L64;
        String r42 = "";
    L65:
        Object r122 = r116.get("event_name");
        if ((r122 instanceof String) == true) goto L68;
        r122 = null;
    L68:
        String r123 = (String) r122;
        if (r123 != null) goto L71;
        String r124 = "";
    L72:
        r110.add(new f.a(r116, r119, r42, r124, r10.a, r10.b));
        goto L50
    L71:
        r124 = r123;
        goto L72
    L64:
        r42 = r121;
        goto L65
    L57:
        r119 = r118;
    L41:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L33:
        r18 = null;
        goto L35
    L26:
        r15 = null;
    L29:
        r16 = 0;
        goto L30
    L5:
        r6 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1879invoke();
        return Unit.INSTANCE;
    }
}
