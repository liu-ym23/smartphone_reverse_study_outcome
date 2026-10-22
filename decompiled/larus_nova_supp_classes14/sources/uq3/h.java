package uq3;

import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final void a(ShopComponentResponseVO r4, WindowComponentResponseDTO r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$transform");
        Intrinsics.checkNotNullParameter(r5, "responseDTO");
        List<com.bytedance.android.ec.window.base.repository.dto.s> r0 = r5.getComponents();
        if (r0 == null) goto L8;
        List<com.bytedance.android.ec.window.base.repository.dto.s> r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L9;
        com.bytedance.android.ec.window.base.repository.dto.s r6 = (com.bytedance.android.ec.window.base.repository.dto.s) r3.next();
        int r7 = com.bytedance.android.ec.window.base.repository.vo.d.a;
        r2.add(com.bytedance.android.ec.window.base.repository.vo.d.a.a(r6));
    L9:
        r4.setComponents(r2);
        r4.setLogExtra(r5.getLogExtra());
        r4.setExtraSchema(r5.getExtraSchema());
        return;
    L8:
        r2 = new ArrayList();
        goto L9
    }
}
