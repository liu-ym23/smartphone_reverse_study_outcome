package com.bytedance.android.livesdk.liveinit.multilink;

import com.bytedance.android.live.multilink.external.api.IMultiLinkService;
import com.bytedance.android.live.soloktv.ISoloKtvService;
import com.bytedance.android.livesdk.init.AbsLiveInitUnit;
import com.bytedance.android.livesdk.init.LiveInitPoint;
import com.bytedance.android.livesdk.init.LiveInitUnitKey;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.live.livelink.kmp.impl.core.instance.AndroidLiveLinkService;
import jc1.k;
import kotlin.Metadata;
import zm0.a;
import zm0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/liveinit/multilink/LiveMultiLinkInitUnit;", "Lcom/bytedance/android/livesdk/init/AbsLiveInitUnit;", "Lcom/bytedance/android/livesdk/init/LiveInitPoint;", "initPoint", "Lcom/bytedance/android/livesdk/init/LiveInitUnitKey;", "getUnitKey", "", "initialize", "Lzm0/b;", "serviceInitializer", "Lzm0/b;", "<init>", "()V", "livesdk-init_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMultiLinkInitUnit extends AbsLiveInitUnit {
    public static final LiveMultiLinkInitUnit INSTANCE = null;
    private static final b serviceInitializer = null;

    static {
        INSTANCE = new LiveMultiLinkInitUnit();
        serviceInitializer = new b();
    }

    public void initialize() {
        k.l(IMultiLinkService.class, new a());
        k.m(IKtvService.class, AnonymousClass1.INSTANCE);
        k.m(ISoloKtvService.class, AnonymousClass2.INSTANCE);
        serviceInitializer.a();
        new AndroidLiveLinkService();
    }

    private LiveMultiLinkInitUnit() {
    }

    public LiveInitUnitKey getUnitKey() {
        return LiveInitUnitKey.LiveMultiLinkInitUnit;
    }

    public LiveInitPoint initPoint() {
        return LiveInitPoint.COMPLETE_INIT;
    }
}
