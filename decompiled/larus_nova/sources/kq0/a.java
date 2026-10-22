package kq0;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.livesdk.config.qc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenPlatformContext f505572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qc1 f505573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a f505574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oq0.a f505575d;

    @Override // kq0.b
    public void onDestroy() {
    }

    public a(OpenPlatformContext r100, qc1 r101, AudienceHighIntentionContextService r102, oq0.a r103) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "condition");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "prefHelper");
        this.f505572a = r100;
        this.f505573b = r101;
        this.f505574c = r102;
        this.f505575d = r103;
    }
}
