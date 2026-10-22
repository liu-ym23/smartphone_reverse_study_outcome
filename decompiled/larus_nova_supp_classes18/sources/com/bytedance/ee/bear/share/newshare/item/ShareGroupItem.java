package com.bytedance.ee.bear.share.newshare.item;

import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.z;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class ShareGroupItem extends z {
    public final ArrayList<z> c;
    public final Lazy d;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final ShareItemList b() {
        return (ShareItemList) this.d.getValue();
    }

    public ShareGroupItem() {
        this.c = new ArrayList();
        this.d = LazyKt.lazy(new ShareGroupItem$subItemList$2(this));
    }

    public final void j(z r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.c.add(r2);
    }

    public final void k(z r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (r3 == false) goto L6;
        this.c.add(r2);
        return;
    }
}
