package com.bytedance.ee.bear.more.protocol3.extension;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class MoreGroupItem extends com.bytedance.ee.bear.more.protocol3.g {
    public String c;
    public final ArrayList<com.bytedance.ee.bear.more.protocol3.b> d;
    public final Lazy e;

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return (com.bytedance.ee.bear.more.protocol3.c) this.e.getValue();
    }

    public MoreGroupItem() {
        this.d = new ArrayList();
        this.e = LazyKt.lazy(new MoreGroupItem$subItemList$2(this));
    }

    public final void l(com.bytedance.ee.bear.more.protocol3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.d.add(r2);
    }

    public final void o(int r2) {
        this.c = eu5.b.a.getString(r2);
    }

    public final void m(com.bytedance.ee.bear.more.protocol3.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (r3 == false) goto L6;
        this.d.add(r2);
        return;
    }

    public final void k(FragmentActivity r4, CommonMoreItemId r5, jdb.g r6, by4.d r7) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r7, "kvStorage");
        BaseMoreItem r8 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).q(r4, r5, r6, r7);
        this.d.add(r8);
    }

    public final void n(FragmentActivity r7, CommonMoreItemId r8, jdb.g r9, by4.d r10) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_ID);
        Intrinsics.checkNotNullParameter(r10, "kvStorage");
        Intrinsics.checkNotNullParameter("doc_detail", "module");
        BaseMoreItem r11 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).g(r7, r8, r9, r10, "doc_detail");
        this.d.add(r11);
    }
}
