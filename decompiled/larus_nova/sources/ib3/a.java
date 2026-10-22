package ib3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.event.common.b {
    public a() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Map<String, Object> r101 = r100.q();
        if (r101 == null) goto L5;
        Object r102 = r101.get("current_index");
    L7:
        if ((r102 instanceof Integer) == true) goto L9;
        r102 = null;
    L9:
        Integer r103 = (Integer) r102;
        if (r101 == null) goto L12;
        Object r104 = r101.get("current_word");
    L14:
        if ((r104 instanceof String) == true) goto L16;
        r104 = null;
    L16:
        String r105 = (String) r104;
        if (r101 == null) goto L19;
        Object r106 = r101.get("history_words");
    L21:
        if ((r106 instanceof List) == true) goto L23;
        r106 = null;
    L23:
        List r107 = (List) r106;
        if (r107 == null) goto L26;
        List r108 = CollectionsKt.toMutableList(r107);
    L27:
        if (r103 != null) goto L30;
    L31:
        if (r103 == null) goto L35;
        if (r108 == null) goto L37;
        String r109 = (String) ListProtector.remove(r108, r103.intValue());
    L37:
        if (r105 == null) goto L40;
        if (r108 == null) goto L40;
        r108.remove(r105);
    L40:
        int r110 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        if (r108 == null) goto L44;
        List r111 = CollectionsKt.toList(r108);
        if (r111 == null) goto L44;
    L46:
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("new_history_words", r111)), null, 5);
    L44:
        r111 = CollectionsKt.emptyList();
    L35:
        if (r108 == null) goto L37;
        r108.clear();
        goto L37
    L30:
        if (r103.intValue() == (-1)) goto L35;
    L26:
        r108 = null;
        goto L27
    L19:
        r106 = null;
        goto L21
    L12:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
