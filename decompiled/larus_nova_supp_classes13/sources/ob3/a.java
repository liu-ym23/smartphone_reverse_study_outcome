package ob3;

import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.event.common.j;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements j {

    /* JADX INFO: renamed from: ob3.a$a, reason: collision with other inner class name */
    public static final class C0221a {
    }

    static {
    }

    public a() {
    }

    public final Map<String, Object> a(List<? extends c> r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r11, "nodeList");
        Intrinsics.checkNotNullParameter(r12, "params");
        Iterator<T> r13 = r11.iterator();
        boolean r1 = true;
        int r2 = 0;
    L4:
        if (r13.hasNext() == false) goto L44;
        c r3 = (c) r13.next();
        p r4 = r3.b.b;
        Object r6 = null;
        if (r4 == null) goto L11;
        Object r5 = q.b(r4, Reflection.getOrCreateKotlinClass(Boolean.class), "is_collection_card");
        if ((r5 instanceof Boolean) == true) goto L10;
        r5 = null;
    L10:
        Boolean r7 = (Boolean) r5;
    L12:
        Boolean r8 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r8) == false) goto L24;
        p r9 = r3.b.b;
        if (r9 == null) goto L20;
        Object r10 = q.b(r9, Reflection.getOrCreateKotlinClass(Boolean.class), "is_selected");
        if ((r10 instanceof Boolean) == true) goto L19;
        r10 = null;
    L19:
        Boolean r14 = (Boolean) r10;
    L22:
        if (Intrinsics.areEqual(r14, r8) == false) goto L24;
        r2 = r2 + 1;
        goto L24
    L20:
        r14 = null;
    L24:
        p r15 = r3.b.b;
        if (r15 == null) goto L30;
        Object r16 = q.b(r15, Reflection.getOrCreateKotlinClass(Boolean.class), "is_collection_card");
        if ((r16 instanceof Boolean) == true) goto L29;
        r16 = null;
    L29:
        Boolean r17 = (Boolean) r16;
    L32:
        if (Intrinsics.areEqual(r17, r8) == false) goto L4;
        p r18 = r3.b.b;
        if (r18 == null) goto L41;
        Object r19 = q.b(r18, Reflection.getOrCreateKotlinClass(Boolean.class), "is_selected");
        if ((r19 instanceof Boolean) == false) goto L39;
        r6 = r19;
    L39:
        r6 = (Boolean) r6;
    L41:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L4;
        r1 = false;
        goto L4
    L30:
        r17 = null;
        goto L32
    L11:
        r7 = null;
        goto L12
    L44:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("isFooterSelected", Boolean.valueOf(r1)), TuplesKt.to("footerSelectNum", Integer.valueOf(r2))});
    }
}
