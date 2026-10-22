package com.bytedance.android.shopping.store.hybridproduct.extension;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class o implements d {
    public Map<String, ? extends Object> a;
    public Map<String, ? extends Object> b;
    public Map<String, ? extends Object> c;
    public Map<String, Object> d;
    public String e;
    public Map<String, String> f;
    public String g;

    public o() {
        this.a = MapsKt.emptyMap();
        this.b = MapsKt.emptyMap();
        this.c = MapsKt.emptyMap();
        this.d = new LinkedHashMap();
    }

    public final void b(ECHybridListItemVO r3) {
        Intrinsics.checkNotNullParameter(r3, "vo");
        ECNAMallCardExtra r0 = r3.c();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getSliceActions();
    L6:
        this.b = com.bytedance.android.shopping.store.slicecard.i.a(r2);
        ECNAMallCardExtra r4 = r3.c();
        if (r4 == null) goto L9;
        String r5 = r4.getSliceItemStates();
    L10:
        this.d = com.bytedance.android.shopping.store.slicecard.i.c(r5);
        ECNAMallCardExtra r6 = r3.c();
        if (r6 == null) goto L13;
        String r7 = r6.getSliceItemExtra();
    L14:
        this.c = com.bytedance.android.shopping.store.slicecard.i.b(r7);
        ECNAMallCardExtra r8 = r3.c();
        if (r8 == null) goto L17;
        r1 = r8.getSliceItemType();
    L17:
        this.e = r1;
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
