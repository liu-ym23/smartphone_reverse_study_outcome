package j90;

import com.bytedance.android.live.broadcast.effect.IDownloadableModelConfigService;
import com.bytedance.android.live.effect.api.n;
import com.bytedance.android.live.effect.api.t;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements com.bytedance.android.live.effect.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f497761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f497762b;

    public a() {
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void d(boolean r100) {
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final void sendLog(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final DownloadableModelConfig b() {
        IDownloadableModelConfigService r100 = (IDownloadableModelConfigService) k.f(IDownloadableModelConfigService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getDownloadModelConfig();
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final t c() {
        if (this.f497761a != null) goto L5;
        this.f497761a = new b();
    L5:
        b r100 = this.f497761a;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.android.live.effect.api.c
    public final n e() {
        if (this.f497762b != null) goto L5;
        this.f497762b = new d();
    L5:
        d r100 = this.f497762b;
        Intrinsics.checkNotNull(r100);
        return r100;
    }
}
