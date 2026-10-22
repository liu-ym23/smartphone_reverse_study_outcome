package com.bytedance.android.shopping.store.product;

import com.bytedance.android.ec.store.repository.vo.n;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.shopping.store.restore.h;
import com.bytedance.android.shopping.store.restore.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements com.bytedance.android.shopping.store.restore.a {
    public final int a;
    public final /* synthetic */ ECStoreProductTabFragment b;

    @Override // com.bytedance.android.shopping.store.restore.a
    public final h a() {
        ej3.f r3 = (ej3.f) this.b.V90().getSortsVO().getValue();
        List r1 = (List) this.b.V90().getSortTypes().getValue();
        n r5 = (n) this.b.V90().getDiscountButton().getValue();
        Boolean r6 = (Boolean) this.b.V90().getBigSaleMoveToTop().getValue();
        List<com.bytedance.android.ec.store.repository.dto.c> r2 = this.b.V90().getSelectButtons();
        ej3.f r9 = null;
        if ((!r2.isEmpty()) == true) goto L6;
        r2 = null;
    L6:
        if (r2 == null) goto L8;
        List r7 = CollectionsKt.toList(r2);
    L9:
        List<com.bytedance.android.ec.store.repository.dto.c> r4 = this.b.V90().getFilterSelectButtons();
        if ((!r4.isEmpty()) == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L15;
        List r8 = CollectionsKt.toList(r4);
    L16:
        if (r3 != null) goto L23;
        if (r1 != null) goto L23;
        if (r5 != null) goto L23;
        if (r6 != null) goto L23;
        if (r7 != null) goto L23;
        if (r8 != null) goto L23;
        return null;
    L23:
        h r10 = new h(r3, r1, r5, r6, r7, r8);
        Intrinsics.checkNotNullParameter(r10, "$this$detachCallbacks");
        if (r1 == null) goto L30;
        List r11 = r1;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L29;
        r12.add(((r) r13.next()).b());
        goto L27
    L29:
        ArrayList r14 = r12;
    L31:
        ej3.f r15 = r10.a;
        if (r15 == null) goto L35;
        r9 = t.a(r15);
    L35:
        return new h(r9, r14, r10.c, r10.d, r10.e, r10.f);
    L30:
        r14 = null;
        goto L31
    L15:
        r8 = null;
        goto L16
    L8:
        r7 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.restore.a
    public final int getTabType() {
        return this.a;
    }

    public final void b(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        ej3.f r0 = r3.a;
        if (r0 == null) goto L5;
        this.b.V90().getSortsVO().setValue(r0);
    L5:
        List<r> r1 = r3.b;
        if (r1 == null) goto L8;
        this.b.V90().getSortTypes().setValue(r1);
    L8:
        n r2 = r3.c;
        if (r2 == null) goto L11;
        this.b.V90().getDiscountButton().setValue(r2);
    L11:
        Boolean r4 = r3.d;
        if (r4 == null) goto L14;
        boolean r5 = r4.booleanValue();
        this.b.V90().getBigSaleMoveToTop().setValue(Boolean.valueOf(r5));
    L14:
        List<com.bytedance.android.ec.store.repository.dto.c> r6 = r3.e;
        if (r6 == null) goto L17;
        this.b.V90().setSelectButtons(CollectionsKt.toMutableList(r6));
    L17:
        List<com.bytedance.android.ec.store.repository.dto.c> r7 = r3.f;
        if (r7 == null) goto L21;
        this.b.V90().setFilterSelectButtons(CollectionsKt.toMutableList(r7));
        return;
    }

    public b(ECStoreProductTabFragment r1, Integer r2) {
        this.b = r1;
        this.a = r2.intValue();
    }
}
