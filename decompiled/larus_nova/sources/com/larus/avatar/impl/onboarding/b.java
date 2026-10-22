package com.larus.avatar.impl.onboarding;

import com.bytedance.keva.Keva;
import com.larus.home.impl.sdk.l1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.AccountService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import sq9.u;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f290851a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f290852b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f290853c = null;

    public b() {
    }

    static {
        f290851a = new b();
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L9;
        r100.H();
        VideoPortraitConfig r101 = l1.f346198a.a();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.getEnableVideoAvatar() != true) goto L9;
    L10:
        if (r102 == false) goto L12;
        String r103 = "has_agreed_create_digital_avatar_v2";
    L13:
        f290852b = r103;
        f290853c = Keva.getRepo("create_digital_avatar", 0);
        return;
    L12:
        r103 = "has_agreed_create_digital_avatar";
    L9:
        r102 = false;
        goto L10
    }

    public static void b() {
        f290853c.storeBoolean(f290852b + AccountService.f365697a.getUserId(), true);
    }

    @Override // sq9.u
    public final boolean a() {
        return f290853c.getBoolean(f290852b + AccountService.f365697a.getUserId(), false);
    }
}
