package com.bytedance.locallife.live.lynx.syncjsb;

import android.text.TextUtils;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends a {
    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final String c() {
        return "getABTestParams";
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        super(r100);
    }

    @Override // com.bytedance.locallife.live.lynx.syncjsb.a
    public final HashMap<String, Object> f(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = r100.get("keys");
        if ((r101 instanceof List) == false) goto L5;
        List r102 = (List) r101;
    L6:
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();
    L9:
        if (r102.isEmpty() == true) goto L11;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L39;
        Object r105 = ((HashMap) r104.next()).get("key");
        if ((r105 instanceof String) == false) goto L18;
        String r106 = (String) r105;
    L20:
        if (TextUtils.isEmpty(r106) == true) goto L22;
        boolean r107 = LiveLocalLifeUtil.f260684b;
        Intrinsics.checkNotNull(r106);
        Object r108 = LiveLocalLifeUtil.b(r106);
        if ((r108 instanceof Boolean) == false) goto L27;
        r108 = Integer.valueOf(Intrinsics.areEqual(r108, Boolean.TRUE) ? 1 : 0);
    L33:
        if (r108 == null) goto L36;
        String r109 = r108.toString();
        if (r109 == null) goto L36;
    L37:
        r103.put(r106, r109);
    L36:
        r109 = "";
        goto L37
    L27:
        if ((r108 instanceof String) == false) goto L33;
        if (Intrinsics.areEqual(r108, "true") == false) goto L31;
    L32:
        r108 = Integer.valueOf(Intrinsics.areEqual(r108, "true") ? 1 : 0);
        goto L33
    L31:
        if (Intrinsics.areEqual(r108, "false") == false) goto L33;
    L22:
        return a.b("参数校验出错，key为空");
    L18:
        r106 = null;
        goto L20
    L39:
        return a.d(this, r103, 1);
    L11:
        return a.b("参数检验出错，keys为空");
    L5:
        r102 = null;
        goto L6
    }
}
