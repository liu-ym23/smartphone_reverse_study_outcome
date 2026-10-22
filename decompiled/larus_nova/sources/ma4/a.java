package ma4;

import com.bytedance.bdp.live.livecontainer.miniapp.di.MiniAppModule_ProvideMiniAppServiceFactory;
import com.bytedance.bdp.live.livecontainer.sonicgame.di.SonicGameModule_ProvideSonicGameServiceFactory;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider<ya4.a> f512693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Provider<com.bytedance.bdp.live.livecontainer.sonicgame.a> f512694b;

    /* JADX INFO: renamed from: ma4.a$a, reason: collision with other inner class name */
    public static final class C6788a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public za4.a f512695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bb4.a f512696b;

        public C6788a() {
        }
    }

    public a(C6788a r100) {
        this.f512693a = DoubleCheck.provider(MiniAppModule_ProvideMiniAppServiceFactory.create(r100.f512695a));
        this.f512694b = DoubleCheck.provider(SonicGameModule_ProvideSonicGameServiceFactory.create(r100.f512696b));
    }
}
