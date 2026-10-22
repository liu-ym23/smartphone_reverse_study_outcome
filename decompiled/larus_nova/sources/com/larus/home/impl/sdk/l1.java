package com.larus.home.impl.sdk;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.avatar.api.IDigitalAvatarService;
import com.larus.common.pollingconfig.api.PollingConfigApi;
import com.larus.platform.model.video.VideoPortraitConfig;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l1 f346198a = null;

    static {
        f346198a = new l1();
    }

    public l1() {
    }

    public final VideoPortraitConfig a() {
        VideoPortraitConfig r100 = z2.f365865a.L0();
        PollingConfigApi r101 = (PollingConfigApi) ServiceManager.get().getService(PollingConfigApi.class);
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f("et_video_dg");
    L6:
        boolean r104 = Intrinsics.areEqual(r103, "1");
        PollingConfigApi r105 = (PollingConfigApi) ServiceManager.get().getService(PollingConfigApi.class);
        if (r105 == null) goto L9;
        String r106 = r105.f("avatar_cre_dg");
    L10:
        boolean r107 = Intrinsics.areEqual(r106, "1");
        PollingConfigApi r108 = (PollingConfigApi) ServiceManager.get().getService(PollingConfigApi.class);
        if (r108 == null) goto L13;
        r102 = r108.f("video_avatar_dg");
    L13:
        boolean r109 = Intrinsics.areEqual(r102, "1");
        if (r100.getEnableEditVideo() == false) goto L17;
        if (r104 == true) goto L17;
        boolean r110 = true;
    L19:
        if (r100.getEnableAvatarCreation() == false) goto L22;
        if (r107 == true) goto L22;
        boolean r111 = true;
    L24:
        if (r100.getEnableVideoAvatar() == false) goto L27;
        if (r109 == true) goto L27;
        boolean r112 = true;
    L29:
        return VideoPortraitConfig.copy$default(r100, false, r110, r111, r112, 1, null);
    L27:
        r112 = false;
    L22:
        r111 = false;
    L17:
        r110 = false;
        goto L19
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final boolean b() {
        return z2.f365865a.r3();
    }

    public final boolean c() {
        return IUgcAIGCService.f373945a.v();
    }

    public final void d(FragmentActivity r100, Context r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IDigitalAvatarService.f290722a.f(r100, r101, r102);
    }
}
