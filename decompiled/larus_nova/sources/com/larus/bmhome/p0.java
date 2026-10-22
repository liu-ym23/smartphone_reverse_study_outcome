package com.larus.bmhome;

import android.os.Handler;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hq9.v2;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 implements ltb.a<mtb.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f313531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OfficeSDKUserApi f313532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v2 f313533c;

    @Override // ltb.a
    public final void onSuccess(mtb.k r100) {
        mtb.k r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        if (this.f313531a.a(this.f313532b, this.f313533c) == true) goto L5;
        FLogger.f375446a.w("SideBarLarkBadgeManager", "ignore stale getNewFriendBadge callback generation=" + this.f313533c.f486795b);
        return;
    L5:
        FLogger.f375446a.i("SideBarLarkBadgeManager", "getNewFriendBadge onSuccess badgeCount=" + r101.f515692a);
        this.f313531a.f312457b.set(r101.f515692a);
        SoftReference<Handler> r102 = com.larus.utils.y.f375498a;
        final l0 r103 = this.f313531a;
        final OfficeSDKUserApi r104 = this.f313532b;
        final v2 r105 = this.f313533c;
        com.larus.utils.y.c(new o0(r103, r104, r105));
    }

    @Override // ltb.a
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        FLogger.f375446a.e("SideBarLarkBadgeManager", "getNewFriendBadge onError code=" + r100 + " message=" + r101);
    }

    public p0(l0 r100, OfficeSDKUserApi r101, v2 r102) {
        this.f313531a = r100;
        this.f313532b = r101;
        this.f313533c = r102;
    }
}
