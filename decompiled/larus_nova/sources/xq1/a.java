package xq1;

import android.content.Context;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.r5;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import ylc.e;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements f, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f564793a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void a(d r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "customParams");
        this.f564793a.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d c(Context r100, long r110, String r111, e r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomTag");
        Intrinsics.checkNotNullParameter(r112, "wrdsManager");
        Intrinsics.checkNotNullParameter(r113, "anchorId");
        return this.f564793a.c(r100, r110, r111, r112, r113);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f564793a.d(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final e f(long r100) {
        return this.f564793a.f(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void g() {
        this.f564793a.g();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void h(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_CURSOR);
        this.f564793a.h(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final q5 i() {
        return this.f564793a.i();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final r5 j() {
        return this.f564793a.j();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final void k() {
        this.f564793a.k();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d n(DataCenter r100) {
        return this.f564793a.n(r100);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.f
    public final d provideSeekMessageManager(Context r110, DataCenter r111, boolean r112, long r113, long r114, int r210, long r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f564793a.provideSeekMessageManager(r110, r111, false, r113, r114, r210, r211);
    }

    public a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "hostMessage");
        this.f564793a = r100;
    }
}
