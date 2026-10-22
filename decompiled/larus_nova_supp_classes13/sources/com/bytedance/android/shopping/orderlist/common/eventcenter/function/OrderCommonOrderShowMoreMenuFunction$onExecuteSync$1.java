package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

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
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class OrderCommonOrderShowMoreMenuFunction$onExecuteSync$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e $input;
    final /* synthetic */ Ref.ObjectRef $result;
    final /* synthetic */ i this$0;

    public OrderCommonOrderShowMoreMenuFunction$onExecuteSync$1(i r1, com.bytedance.kmp.ec.yata.event.common.e r2, Ref.ObjectRef r3) {
        this.this$0 = r1;
        this.$input = r2;
        this.$result = r3;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1885invoke() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderCommonOrderShowMoreMenuFunction", AnonymousClass1.INSTANCE);
        com.bytedance.kmp.ec.yata.common.platform.o r1 = this.$input.m();
        if (r1 == null) goto L5;
        View r6 = r1.a;
    L7:
        if (r6 != null) goto L18;
        StringBuilder r2 = new StringBuilder("OrderCommonOrderShowMoreMenuFunction-doExecuteSync: targetView is null ");
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
        OrderCommonErrorMonitorKt.b(this.this$0.e.E0(), "SELF_FUN_ERROR", r2.toString());
        this.$result.element = new Pair(Boolean.FALSE, "targetView is null");
        return;
    L15:
        r3 = null;
        goto L16
    L11:
        r9 = null;
        goto L12
    L18:
        i r10 = this.this$0;
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
        if (r19 != null) goto L102;
    L66:
        List r110 = 0;
    L68:
        if (r110 != 0) goto L70;
    L73:
        boolean r20 = true;
    L74:
        if (r20 == false) goto L84;
        StringBuilder r21 = new StringBuilder();
        StringBuilder r111 = new StringBuilder("OrderCommonOrderShowMoreMenuFunction-composeButtonList: ");
        int r112 = com.bytedance.android.ec.core.hybrid.utils.k.a;
        r111.append(com.bytedance.android.ec.core.hybrid.utils.k.b(r11.q()));
        r111.append("  ");
        r21.append(r111.toString());
        StringBuilder r113 = new StringBuilder("renderNodeKey:");
        com.bytedance.kmp.ec.yata.store.node.c r22 = r11.j();
        if (r22 == null) goto L78;
        String r23 = r22.getKey();
    L79:
        r113.append(r23);
        r113.append(' ');
        r21.append(r113.toString());
        StringBuilder r24 = new StringBuilder("name:");
        com.bytedance.kmp.ec.yata.store.node.c r25 = r11.j();
        if (r25 == null) goto L82;
        String r26 = r25.getNodeName();
    L83:
        r24.append(r26);
        r21.append(r24.toString());
        OrderCommonErrorMonitorKt.b(r10.e.E0(), "SELF_FUN_ERROR", r21.toString());
        goto L84
    L82:
        r26 = null;
        goto L83
    L78:
        r23 = null;
    L84:
        if (r110 != 0) goto L86;
        r110 = CollectionsKt.emptyList();
    L86:
        i r27 = this.this$0;
        com.bytedance.kmp.ec.yata.event.common.e r28 = this.$input;
        r27.getClass();
        LinearLayout r29 = new LinearLayout(r27.f);
        r29.setOrientation(1);
        Iterator r30 = r110.iterator();
        int r31 = 0;
    L88:
        if (r30.hasNext() == false) goto L96;
        Object r32 = r30.next();
        int r33 = r31 + 1;
        if (r31 >= 0) goto L92;
        CollectionsKt.throwIndexOverflow();
    L92:
        i.a r34 = (i.a) r32;
        TextView r114 = new TextView(r27.f);
        r114.setTextSize(14.0f);
        r114.setTextColor(ContextCompat.getColor(r114.getContext(), 2131103976));
        r114.setGravity(17);
        r114.setBackgroundColor(0);
        r114.setText(r34.b);
        r114.setOnClickListener(new j(r27, r28, r34));
        r29.addView(r114, new ViewGroup.LayoutParams(r34.d, r34.e));
        if (r31 == CollectionsKt.getLastIndex(r110)) goto L95;
        View r35 = new View(r27.f);
        r35.setBackgroundColor(ContextCompat.getColor(r27.f, 2131106018));
        r29.addView(r35, new ViewGroup.LayoutParams(r34.d, r27.c));
    L95:
        r31 = r33;
        goto L88
    L96:
        View r36 = r6.getRootView();
        if (r36 == null) goto L99;
        View r37 = r36.findViewById(2131381628);
    L100:
        int r38 = OrderCommonBubbleHelper.a;
        i r39 = this.this$0;
        final PopupWindow r40 = OrderCommonBubbleHelper.a(new com.bytedance.android.shopping.orderlist.common.widgets.bubble.b(r39.f, r29, r6, BubbleOrientation.TOP, r39.a, (r110.size() * this.this$0.b) + (RangesKt.coerceAtLeast(r110.size() - 1, 0) * this.this$0.c), com.bytedance.android.shopping.extensions.b.b(12), r37, 896), new OrderCommonOrderShowMoreMenuFunction$onExecuteSync$1$popup$1(this));
        this.this$0.d = new AnonymousClass2(r40);
        return;
    L99:
        r37 = null;
        goto L100
    L70:
        if (r110.isEmpty() == true) goto L73;
        r20 = false;
        goto L74
    L102:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L41
        Object r41 = Result.constructor-impl(r19.subList(0, r19.size() - r16));     // Catch: Throwable -> L41
    L44:
        if (Result.isFailure-impl(r41) == false) goto L46;
        r41 = null;
    L46:
        List r42 = (List) r41;
        if (r42 == null) goto L66;
        r110 = new ArrayList();
        Iterator r43 = r42.iterator();
    L50:
        if (r43.hasNext() == false) goto L68;
        Map r116 = (Map) r43.next();
        Object r117 = r116.get("name");
        if ((r117 instanceof String) == true) goto L54;
        r117 = null;
    L54:
        String r118 = (String) r117;
        if (r118 != null) goto L57;
        String r119 = "";
    L58:
        Object r120 = r116.get("event_name");
        if ((r120 instanceof String) == true) goto L61;
        r120 = null;
    L61:
        String r121 = (String) r120;
        if (r121 != null) goto L64;
        String r44 = "";
    L65:
        r110.add(new i.a(r116, r119, r44, r10.a, r10.b));
        goto L50
    L64:
        r44 = r121;
        goto L65
    L57:
        r119 = r118;
    L41:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
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
        m1885invoke();
        return Unit.INSTANCE;
    }
}
