package ii3;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b {
    public final void H0(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "props");
    }

    public c(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        ((BaseSlcViewManager) this).j3 = true;
    }

    public final Map<String, Object> z0(Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "dataCtx");
        Object r0 = l().get("data");
        Object r3 = null;
        if ((r0 instanceof Map) == true) goto L5;
        r0 = null;
    L5:
        Map r1 = (Map) r0;
        if (r1 != null) goto L8;
        return r7;
    L8:
        if (r1.get("should_sec_line") == null) goto L24;
        LinkedHashMap r4 = new LinkedHashMap();
        Object r8 = r7.get("data");
        if ((r8 instanceof HashMap) == false) goto L13;
        r3 = r8;
    L13:
        HashMap r5 = (HashMap) r3;
        if (r5 == null) goto L20;
        Iterator r9 = r5.entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) r9.next();
        r4.put(r6.getKey(), r6.getValue());
        goto L17
    L19:
        r4.put("should_sec_line", r1.get("should_sec_line"));
    L20:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("data", r4);
        return r10;
    L24:
        return r7;
    }
}
