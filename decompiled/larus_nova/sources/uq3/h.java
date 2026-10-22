package uq3;

import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {
    public static final void a(ShopComponentResponseVO r100, WindowComponentResponseDTO r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transform");
        Intrinsics.checkNotNullParameter(r101, "responseDTO");
        List<com.bytedance.android.ec.window.base.repository.dto.s> r102 = r101.getComponents();
        if (r102 == null) goto L8;
        List<com.bytedance.android.ec.window.base.repository.dto.s> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        com.bytedance.android.ec.window.base.repository.dto.s r106 = (com.bytedance.android.ec.window.base.repository.dto.s) r105.next();
        int r107 = com.bytedance.android.ec.window.base.repository.vo.d.f49497a;
        r104.add(com.bytedance.android.ec.window.base.repository.vo.d.a.a(r106));
    L9:
        r100.setComponents(r104);
        r100.setLogExtra(r101.getLogExtra());
        r100.setExtraSchema(r101.getExtraSchema());
        return;
    L8:
        r104 = new ArrayList();
        goto L9
    }
}
