package kq0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.openplatform.impl.miniappaudience.intention.AudienceHighIntentionContextService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f505578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a f505579b;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r100.what != 1) goto L7;
        com.bytedance.android.live.openplatform.impl.miniappaudience.intention.a r101 = this.f505579b;
        this.f505578a.getClass();
        r101.a("stay_duration");
        return;
    }

    public d(c r100, AudienceHighIntentionContextService r101, Looper r102) {
        this.f505578a = r100;
        this.f505579b = r101;
        super(r102);
    }
}
