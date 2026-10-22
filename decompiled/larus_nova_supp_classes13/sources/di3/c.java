package di3;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.shopping.anchorv3.comment.model.StatTagItem;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static StatTagItem b(Map r35) {
        if (r35 == null) goto L29;
        Object r2 = r35.get("id");
        if (r2 == null) goto L29;
        if (com.bytedance.android.ecom.arch.slice.render.util.b.m(r2) == 1) goto L9;
        boolean r3 = true;
    L10:
        Object r4 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L29;
        long r6 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r35.get("id"));
        long r12 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r35.get("sentiment"));
        long r8 = com.bytedance.android.ecom.arch.slice.render.util.b.m(r35.get("count_number"));
        Object r1 = r35.get("tag_name");
        if ((r1 instanceof String) == true) goto L19;
        r1 = null;
    L19:
        String r5 = (String) r1;
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        String r11 = r5;
        String r10 = r11 + ' ' + r8;
        Object r0 = r35.get("tag_type");
        if ((r0 instanceof String) == false) goto L27;
        r4 = r0;
    L27:
        return new StatTagItem(r6, r8, r10, r11, r12, Intrinsics.areEqual((String) r4, "1"), null, 0, 192, null);
    L9:
        r3 = false;
    L29:
        return new StatTagItem(1, 0, null, "全部", 0, false, null, 0, 246, null);
    }

    public static Object a(Map r1, Class r2) {
        Intrinsics.checkNotNullParameter(r2, "objectClass");
        if (r1 != null) goto L5;
    L9:
        return null;
    L5:
        if (r1.isEmpty() == true) goto L9;
        return u0.b(k.d(r1), r2);
    }
}
