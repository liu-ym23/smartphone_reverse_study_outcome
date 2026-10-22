package com.larus.bmhome.chat.reddot;

import com.larus.bmhome.FlowLarkSocialServiceImpl;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.SocialIMData;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xp9.o;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f308507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile SocialIMData f308508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f308509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f308510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f308511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f308512f;

    public static final class a {
    }

    static {
    }

    public static boolean d() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        FlowLarkSocialServiceImpl r101 = r100.J();
        if (r101 == null) goto L9;
        if (r101.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void a() {
        if (this.f308509c == false) goto L10;
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        FlowLarkSocialServiceImpl r101 = r100.J();
        if (r101 == null) goto L9;
        r101.e(this.f308511e);
    L9:
        Object r102 = o.f564776a;
        o.d(this.f308512f);
        this.f308509c = false;
        FLogger.f375446a.i("MixedFeedRedDotManager", "clear");
    L10:
        this.f308508b = null;
        this.f308510d = false;
    }

    public final void e() {
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == true) goto L7;
        FLogger.f375446a.e("MixedFeedRedDotManager", "not mix feed");
        a();
        return;
    L7:
        if (this.f308509c == false) goto L10;
        FLogger.f375446a.e("MixedFeedRedDotManager", "isRegistered");
        return;
    L10:
        this.f308509c = true;
        Object r100 = o.f564776a;
        o.a(this.f308512f);
        FLogger.f375446a.i("MixedFeedRedDotManager", "start");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.bmhome.chat.reddot.g] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.chat.reddot.h] */
    public i(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onRedDotChanged");
        this.f308507a = r100;
        this.f308511e = new g(this);
        this.f308512f = new h(this);
    }

    public static long f(Integer r100) {
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        return RangesKt.coerceAtLeast(r101, 0);
    L5:
        r101 = 0;
        goto L7
    }

    public final long b(long r100) {
        Integer r101 = null;
        if (d() == false) goto L8;
        SocialIMData r102 = this.f308508b;
        if (r102 == null) goto L7;
        r101 = r102.getRedBadge();
    L7:
        long r103 = f(r101);
    L13:
        return RangesKt.coerceAtLeast(r103, 0);
    L8:
        SocialIMData r104 = this.f308508b;
        if (r104 == null) goto L11;
        r101 = r104.getRedBadgeWithoutDoubao();
    L11:
        r103 = r100 + f(r101);
        goto L13
    }

    public static long c(SocialIMData r100, boolean r101) {
        Integer r102 = null;
        if (r101 == false) goto L7;
        if (r100 == null) goto L6;
        r102 = r100.getRedBadge();
    L6:
        long r103 = f(r102);
    L11:
        return RangesKt.coerceAtLeast(r103, 0);
    L7:
        if (r100 == null) goto L9;
        r102 = r100.getRedBadgeWithoutDoubao();
    L9:
        r103 = f(r102);
        goto L11
    }

    public final void g(SocialIMData r100, String r110) {
        if (this.f308509c == true) goto L5;
        return;
    L5:
        boolean r101 = d();
        long r102 = c(this.f308508b, this.f308510d);
        this.f308508b = r100;
        long r103 = c(this.f308508b, r101);
        if (r101 == this.f308510d) goto L8;
        boolean r104 = true;
    L9:
        this.f308510d = r101;
        if (r103 != r102) goto L13;
        if (r104 == true) goto L13;
        return;
    L13:
        FLogger.f375446a.i("MixedFeedRedDotManager", "updateRedDotCount " + r102 + " -> " + r103 + ", source=" + r110 + " migrateFinished=" + r101 + ", current=" + r100);
        this.f308507a.invoke();
        return;
    L8:
        r104 = false;
        goto L9
    }
}
