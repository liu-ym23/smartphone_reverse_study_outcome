package com.larus.bmhome;

import android.os.Handler;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.v2;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 implements ltb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f313400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSDKUserApi f313401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v2 f313402c;

    @Override // ltb.b
    public final void a(mtb.k r100) {
        Intrinsics.checkNotNullParameter(r100, IAllianceService.CONTENT_TYPE_BADGE);
        if (this.f313400a.a(this.f313401b, this.f313402c) == true) goto L6;
        FLogger.f375446a.w("SideBarLarkBadgeManager", "ignore stale badge listener callback generation=" + this.f313402c.f486795b);
        return;
    L6:
        FLogger.f375446a.i("SideBarLarkBadgeManager", "onNewFriendBadgeChanged badgeCount=" + r100.f515692a);
        this.f313400a.f312457b.set(r100.f515692a);
        SoftReference<Handler> r101 = com.larus.utils.y.f375498a;
        final l0 r102 = this.f313400a;
        final OfficeSDKUserApi r103 = this.f313401b;
        final v2 r104 = this.f313402c;
        com.larus.utils.y.c(new m0(r102, r103, r104));
    }

    public n0(l0 r100, OfficeSDKUserApi r101, v2 r102) {
        this.f313400a = r100;
        this.f313401b = r101;
        this.f313402c = r102;
    }
}
