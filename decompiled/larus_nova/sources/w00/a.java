package w00;

import com.bytedance.android.live.broadcast.BroadcastEffectService;
import com.bytedance.android.live.broadcast.effect.EffectHostLiveService;
import com.bytedance.android.live.broadcast.h;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements o, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q00.a f557775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BroadcastEffectService f557776b;

    @Override // com.bytedance.android.live.broadcast.h
    public final EffectHostLiveService a() {
        return this.f557776b.a();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        ALogger.i("BroadcastGlobalScope", "GlobalBroadcastEffectService onStart " + hashCode());
    }

    public a(q00.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commerceEffectService");
        this.f557776b = new BroadcastEffectService();
        this.f557775a = r100;
    }
}
