package com.bytedance.android.livesdk.liveinit.openplat;

import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAnchorService;
import com.bytedance.android.live.openplatform.api.minigame.IOpenPlatformMgAudienceService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.liveinit.a;
import com.bytedance.android.livesdkapi.openplatform.IOpenPlatformOuterService;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/openplat/LiveOpenPlatformInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "()V", "getUnitKey", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initialize", "", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenPlatformInitUnit extends AbsLiveInitUnit {
    public static final LiveOpenPlatformInitUnit INSTANCE = null;

    static {
        INSTANCE = new LiveOpenPlatformInitUnit();
    }

    public void initialize() {
        int r0 = a.a;
        a.b(IOpenPlatformAnchorService.class, AnonymousClass1.INSTANCE);
        a.b(IOpenPlatformAudienceService.class, AnonymousClass2.INSTANCE);
        k.m(IOpenPlatformOuterService.class, AnonymousClass3.INSTANCE);
        a.b(IOpenPlatformMgAnchorService.class, AnonymousClass4.INSTANCE);
        a.b(IOpenPlatformMgAudienceService.class, AnonymousClass5.INSTANCE);
    }

    private LiveOpenPlatformInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveOpenPlatformInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
