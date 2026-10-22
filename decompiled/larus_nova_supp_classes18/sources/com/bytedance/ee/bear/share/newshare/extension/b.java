package com.bytedance.ee.bear.share.newshare.extension;

import android.view.View;
import com.bytedance.ee.bear.share.newshare.a0;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.checker.BizChecker;
import com.bytedance.ee.bear.share.newshare.d0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.item.ShareGroupItem;
import com.bytedance.ee.bear.share.newshare.z;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends ShareGroupItem {
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        d0 r0 = b().a();
        return z.g(this, new b0.c("linear_group"), new a0.a(r0, this.e, this.f, this.g), null, CollectionsKt.listOf(new BizChecker(!r0.b.isEmpty())), null, null, 52);
    }

    public b(boolean r1, boolean r2, boolean r3) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
    }
}
