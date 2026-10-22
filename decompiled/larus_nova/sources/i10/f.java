package i10;

import com.bytedance.android.live.broadcastgame.di.BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory;
import com.bytedance.android.live.broadcastgame.di.BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory;
import com.bytedance.android.live.broadcastgame.di.BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory;
import com.bytedance.android.live.broadcastgame.f0;
import com.bytedance.android.live.broadcastgame.opengame.di.OpenPlatformModule_ProvideOpenPlatformServiceFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f487925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Provider<com.bytedance.android.live.broadcastgame.api.e> f487926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Provider<com.bytedance.android.live.broadcastgame.api.f> f487927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Provider<f0> f487928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Provider<com.bytedance.android.live.broadcastgame.api.d> f487929e;

    public f(b r100, c r101, p10.a r102, a r103) {
        this.f487925a = this;
        this.f487926b = DoubleCheck.provider(BroadcastGameAnchorModule_ProvideGameAnchorServiceFactory.create(r100));
        this.f487927c = DoubleCheck.provider(BroadcastGameAudienceModule_ProvideGameAudienceServiceFactory.create(r101));
        this.f487928d = DoubleCheck.provider(OpenPlatformModule_ProvideOpenPlatformServiceFactory.create(r102));
        this.f487929e = DoubleCheck.provider(BdpLiveModuleFallback_ProvideBdpRegisterServiceFactory.create(r103));
    }
}
