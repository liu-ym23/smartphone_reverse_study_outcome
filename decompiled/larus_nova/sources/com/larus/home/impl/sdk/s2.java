package com.larus.home.impl.sdk;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.IMMsgExt;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.LoginService;
import com.larus.login.api.TouristManager;
import com.larus.platform.api.s3;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class s2 implements s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f346237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f346238b;

    static {
        f346237a = new s2();
    }

    public s2() {
    }

    @Override // com.larus.platform.api.s3
    public final boolean a() {
        return TouristManager.f357001a.a();
    }

    @Override // com.larus.platform.api.s3
    public final boolean c() {
        return TouristManager.f357001a.c();
    }

    @Override // com.larus.platform.api.s3
    public final void e() {
        LoginService.f356989a.e();
    }

    @Override // com.larus.platform.api.s3
    public final boolean f() {
        return TouristManager.f357001a.f();
    }

    @Override // com.larus.platform.api.s3
    public final boolean h() {
        if (i3.f365750a.f() == false) goto L14;
        Integer r100 = AppHost.f326268a.a().d();
        if (r100 == null) goto L14;
        if (r100.intValue() != 1) goto L14;
        if (f346238b == true) goto L13;
        s3.a.b();
        f346238b = true;
        return true;
    L13:
        f346238b = false;
    L14:
        return false;
    }

    @Override // com.larus.platform.api.s3
    public final boolean i() {
        return TouristManager.f357001a.t();
    }

    @Override // com.larus.platform.api.s3
    public final void b() {
        TouristManager.f357001a.k(IMMsgExt.ERROR_TOURIST_REACH_CREATE_BOT_LIMIT);
    }

    @Override // com.larus.platform.api.s3
    public final void g(TriggerLoginScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ITouristApi.a.a(TouristManager.f357001a, r100, false, 2);
    }

    @Override // com.larus.platform.api.s3
    public final void d(TriggerLoginScene r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        TouristManager.f357001a.d(r100, r101);
    }
}
