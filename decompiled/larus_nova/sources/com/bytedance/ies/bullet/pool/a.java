package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.z;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends z {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Function2<CacheItemStatus, com.bytedance.ies.bullet.service.base.e, Unit> f247464q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.service.base.e f247465r;

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function2<? super CacheItemStatus, ? super com.bytedance.ies.bullet.service.base.e, Unit> r100, com.bytedance.ies.bullet.service.base.e r101) {
        this.f247464q = r100;
        this.f247465r = r101;
    }

    @Override // com.bytedance.ies.bullet.core.z, com.bytedance.ies.bullet.core.s
    public final void Ox(Uri r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f247464q.invoke(CacheItemStatus.LOADING, this.f247465r);
        if (r101 == null) goto L7;
        BulletContext r102 = r101.getBulletContext();
        if (r102 == null) goto L7;
        com.bytedance.ies.bullet.core.e r103 = r102.f246455w;
    L8:
        if (r103 == null) goto L11;
        r103.f246474b = Boolean.TRUE;
    L11:
        super.Ox(r100, r101);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.z, com.bytedance.ies.bullet.core.s
    public final void go(Uri r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (this.f246574a.compareAndSet(false, true) == false) goto L5;
        this.f247464q.invoke(CacheItemStatus.SUCCESS, this.f247465r);
    L5:
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246585l = true;
    }

    @Override // com.bytedance.ies.bullet.core.z, com.bytedance.ies.bullet.core.s
    public final void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        if (this.f246574a.compareAndSet(false, true) == false) goto L5;
        this.f247464q.invoke(CacheItemStatus.FAILED, this.f247465r);
    L5:
        super.onLoadFail(r100, r101);
    }
}
