package gx6;

import com.bytedance.locallife.dito.utils.e;
import com.bytedance.locallife.pdp.headimage.vo.ItemInfoType;
import jx6.i;
import jx6.o;
import jx6.p;
import jx6.q;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static final int a(p r100, i r101) {
        if (r100 == null) goto L4;
        Integer r102 = Integer.valueOf(r100.getType());
    L5:
        int r103 = ItemInfoType.RATE.getType();
        if (r102 != null) goto L9;
    L11:
        int r104 = ItemInfoType.VIDEO.getType();
        if (r102 != null) goto L15;
    L17:
        int r105 = 0;
        if (r100 == null) goto L26;
        o r106 = r100.b();
        if (r106 == null) goto L26;
        q r107 = r106.a();
        if (r107 == null) goto L26;
        boolean r108 = true;
        if (r107.a() != true) goto L26;
    L27:
        if (r108 == true) goto L35;
        if (r101 == null) goto L30;
        r105 = r101.f500877a;
    L30:
        if (r105 <= 0) goto L35;
        if (r101 == null) goto L39;
        return e.b(Integer.valueOf(r101.f500877a));
    L39:
        return com.bytedance.locallife.biz.common.utils.e.b();
    L35:
        return com.bytedance.locallife.biz.common.utils.e.b();
    L26:
        r108 = false;
        goto L27
    L15:
        if (r102.intValue() != r104) goto L17;
        return com.bytedance.locallife.biz.common.utils.e.b();
    L9:
        if (r102.intValue() != r103) goto L11;
        return com.bytedance.locallife.biz.common.utils.e.b();
    L4:
        r102 = null;
        goto L5
    }
}
