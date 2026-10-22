package osc;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.ListBlock;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static final int a(ListBlock r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WeakHashMap<Object, Map<String, Object>> r101 = com.larus.business.markdown.impl.common.utils.a.f320550a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("key_list_block_indent", "key");
        WeakHashMap<Object, Map<String, Object>> r102 = com.larus.business.markdown.impl.common.utils.a.f320550a;
        monitor-enter(r102);
        Map<String, Object> r103 = r102.get(r100);     // Catch: Throwable -> L16
        if (r103 == null) goto L9;
        Object r104 = r103.get("key_list_block_indent");     // Catch: Throwable -> L16
        if (r104 == null) goto L9;
    L10:
        monitor-exit(r102);
        Integer r105 = (Integer) r104;
        if (r105 != null) goto L21;
        return 0;
    L21:
        return r105.intValue();
    L9:
        r104 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public static final void b(ListBlock r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r102 = Integer.valueOf(r101);
        WeakHashMap<Object, Map<String, Object>> r103 = com.larus.business.markdown.impl.common.utils.a.f320550a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("key_list_block_indent", "key");
        WeakHashMap<Object, Map<String, Object>> r104 = com.larus.business.markdown.impl.common.utils.a.f320550a;
        monitor-enter(r104);
        Map<String, Object> r105 = r104.get(r100);     // Catch: Throwable -> L10
        if (r105 != null) goto L7;
        r105 = new LinkedHashMap();     // Catch: Throwable -> L10
        r104.put(r100, r105);     // Catch: Throwable -> L10
    L7:
        r105.put("key_list_block_indent", r102);     // Catch: Throwable -> L10
        monitor-exit(r104);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
