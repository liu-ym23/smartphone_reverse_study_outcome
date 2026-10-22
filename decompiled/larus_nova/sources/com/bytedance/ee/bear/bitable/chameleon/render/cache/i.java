package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.load.cache.CacheType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements e {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // com.bytedance.ee.bear.bitable.chameleon.render.cache.e
    public final d a(f r210) {
        Intrinsics.checkNotNullParameter(r210, "request");
        boolean r100 = false;
        if (r210.f209710c.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L31;
        if (r210.f209708a.length() != 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L31;
        com.bytedance.ee.bear.bitable.preload.util.b r103 = new com.bytedance.ee.bear.bitable.preload.util.b();
        CacheType r104 = CacheType.DB;
        String r105 = r210.f209710c;
        BitableResourceData r106 = r103.c(r104, r105, "bitable.sending." + r105 + '.' + r210.f209708a);
        String r107 = r210.f209710c;
        BitableResourceData r108 = r103.c(r104, r107, "bitable.queue." + r107 + '.' + r210.f209708a);
        if (r106 != null) goto L16;
    L18:
        boolean r109 = false;
    L20:
        if (r103.f215022a.length() != 0) goto L22;
        boolean r110 = true;
    L23:
        if (r110 == false) goto L29;
        if (r106 != null) goto L26;
        if (r108 != null) goto L26;
    L27:
        r100 = true;
    L26:
        if (r109 == true) goto L27;
    L29:
        return new d(null, null, null, null, null, Boolean.valueOf(r100), 31);
    L22:
        r110 = false;
        goto L23
    L16:
        if (r106.getTimestamp().longValue() >= (System.currentTimeMillis() - 2592000000L)) goto L18;
        r109 = true;
        goto L20
    L10:
        r102 = false;
    L31:
        return new d(null, null, null, null, null, Boolean.FALSE, 31);
    L5:
        r101 = false;
        goto L6
    }
}
