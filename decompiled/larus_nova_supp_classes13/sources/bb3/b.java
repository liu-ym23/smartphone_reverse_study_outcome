package bb3;

import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.common.j;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements j {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final Map<String, Object> a(List<? extends c> r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "nodeList");
        Intrinsics.checkNotNullParameter(r11, "params");
        Object r1 = r11.get("store_all_selected");
        Map<String, Object> r3 = null;
        if ((r1 instanceof Boolean) == true) goto L5;
        r1 = null;
    L5:
        Boolean r2 = (Boolean) r1;
        Object r4 = r11.get("current_cart_id");
        if ((r4 instanceof String) == true) goto L8;
        r4 = null;
    L8:
        String r5 = (String) r4;
        Object r12 = r11.get("cart_group_key");
        if ((r12 instanceof String) == true) goto L11;
        r12 = null;
    L11:
        String r13 = (String) r12;
        if (r2 == null) goto L60;
        if (r5 == null) goto L60;
        if (r13 == null) goto L60;
        r2.booleanValue();
        Iterator<T> r14 = r10.iterator();
    L17:
        if (r14.hasNext() == false) goto L59;
        c r6 = (c) r14.next();
        p r7 = r6.b.b;
        if (r7 == null) goto L24;
        Object r8 = q.b(r7, Reflection.getOrCreateKotlinClass(Map.class), "basic_info");
        if ((r8 instanceof Map) == true) goto L23;
        r8 = null;
    L23:
        Map r9 = (Map) r8;
    L25:
        if (r9 == null) goto L27;
        Object r15 = r9.get("cart_id");
    L29:
        if (Intrinsics.areEqual(r15, r5) == true) goto L17;
        p r16 = r6.b.b;
        if (r16 == null) goto L37;
        Object r17 = q.b(r16, Reflection.getOrCreateKotlinClass(String.class), "cart_group_key");
        if ((r17 instanceof String) == true) goto L36;
        r17 = null;
    L36:
        String r18 = (String) r17;
    L39:
        if (Intrinsics.areEqual(r18, r13) == false) goto L17;
        p r19 = r6.b.b;
        if (r19 == null) goto L46;
        Object r20 = q.b(r19, Reflection.getOrCreateKotlinClass(Boolean.class), "selected");
        if ((r20 instanceof Boolean) == true) goto L45;
        r20 = null;
    L45:
        Boolean r21 = (Boolean) r20;
    L47:
        Boolean r22 = Boolean.FALSE;
        if (Intrinsics.areEqual(r21, r22) == false) goto L17;
        p r23 = r6.b.b;
        if (r23 == null) goto L55;
        Object r24 = q.b(r23, Reflection.getOrCreateKotlinClass(Boolean.class), "can_select");
        if ((r24 instanceof Boolean) == true) goto L54;
        r24 = null;
    L54:
        Boolean r25 = (Boolean) r24;
    L57:
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == false) goto L17;
        r2 = r22;
        goto L17
    L55:
        r25 = null;
        goto L57
    L46:
        r21 = null;
        goto L47
    L37:
        r18 = null;
        goto L39
    L27:
        r15 = null;
        goto L29
    L24:
        r9 = null;
        goto L25
    L59:
        r3 = MapsKt.mapOf(TuplesKt.to("store_all_selected", r2));
    L60:
        if (r3 == null) goto L62;
        return r3;
    L62:
        return MapsKt.emptyMap();
    }
}
