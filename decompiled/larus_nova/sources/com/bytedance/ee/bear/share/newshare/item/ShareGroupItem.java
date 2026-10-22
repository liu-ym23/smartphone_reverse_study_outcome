package com.bytedance.ee.bear.share.newshare.item;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.share.newshare.ShareItemList;
import com.bytedance.ee.bear.share.newshare.z;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class ShareGroupItem extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<z> f237228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f237229d;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final ShareItemList b() {
        return (ShareItemList) this.f237229d.getValue();
    }

    public ShareGroupItem() {
        this.f237228c = new ArrayList();
        this.f237229d = LazyKt.lazy(new ShareGroupItem$subItemList$2(this));
    }

    public final void j(z r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f237228c.add(r100);
    }

    public final void k(z r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r101 == false) goto L6;
        this.f237228c.add(r100);
        return;
    }
}
