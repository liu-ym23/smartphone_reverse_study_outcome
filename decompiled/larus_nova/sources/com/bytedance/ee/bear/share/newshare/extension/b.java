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

/* JADX INFO: loaded from: classes18.dex */
public final class b extends ShareGroupItem {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f237215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f237216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f237217g;

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final View e() {
        return null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.z
    public final e0 a() {
        d0 r100 = b().a();
        return z.g(this, new b0.c("linear_group"), new a0.a(r100, this.f237215e, this.f237216f, this.f237217g), null, CollectionsKt.listOf(new BizChecker(!r100.f237207b.isEmpty())), null, null, 52);
    }

    public b(boolean r100, boolean r101, boolean r102) {
        this.f237215e = r100;
        this.f237216f = r101;
        this.f237217g = r102;
    }
}
