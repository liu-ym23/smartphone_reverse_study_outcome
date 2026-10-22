package rh3;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Integer a(AndroidYaTaInstance r2) {
        if (r2 == null) goto L11;
        List r3 = r2.p("specs");
        if (r3 == null) goto L11;
        c r4 = (c) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L11;
        Map r5 = r4.s();
        if (r5 == null) goto L11;
        Object r6 = r5.get("specs_state");
    L13:
        if ((r6 instanceof Map) == true) goto L15;
        r6 = null;
    L15:
        Map r7 = (Map) r6;
        if (r7 != null) goto L18;
        return null;
    L18:
        return Integer.valueOf(r7.size());
    L11:
        r6 = null;
        goto L13
    }

    public static final Integer b(AndroidYaTaInstance r2) {
        if (r2 == null) goto L11;
        List r3 = r2.p("specs");
        if (r3 == null) goto L11;
        c r4 = (c) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L11;
        Map r5 = r4.s();
        if (r5 == null) goto L11;
        Object r6 = r5.get("spec_items_state");
    L13:
        if ((r6 instanceof Map) == true) goto L15;
        r6 = null;
    L15:
        Map r7 = (Map) r6;
        if (r7 != null) goto L18;
        return null;
    L18:
        return Integer.valueOf(r7.size());
    L11:
        r6 = null;
        goto L13
    }
}
