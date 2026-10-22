package kq0;

import android.os.Looper;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import com.bytedance.android.livesdk.config.qc1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends kq0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f505576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f505577f;

    public static final class a {
    }

    static {
    }

    @Override // kq0.b
    public final String type() {
        return "stay_duration";
    }

    @Override // kq0.a, kq0.b
    public final void onDestroy() {
        this.f505577f.removeMessages(1);
    }

    @Override // kq0.b
    public final boolean a() {
        if ((System.currentTimeMillis() - this.f505576e) < this.f505573b.a()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kq0.b
    public final void init() {
        this.f505576e = System.currentTimeMillis();
        d r100 = this.f505577f;
        r100.sendMessageDelayed(r100.obtainMessage(1), this.f505573b.a());
    }

    public c(OpenPlatformContext r100, qc1 r101, AudienceHighIntentionContextService r102, oq0.a r103) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "condition");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "prefHelper");
        super(r100, r101, r102, r103);
        this.f505576e = Long.MAX_VALUE;
        this.f505577f = new d(this, r102, Looper.getMainLooper());
    }
}
