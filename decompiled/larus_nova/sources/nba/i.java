package nba;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements com.bytedance.applog.i {
    public i() {
    }

    @Override // com.bytedance.applog.i
    public final void a(String r100, String r101, String r102, long r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r101, "tag");
    }

    @Override // com.bytedance.applog.i
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logType");
    }

    @Override // com.bytedance.applog.i
    public final void onEventV3(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        c.f518562a.getClass();
        com.obric.aiagent.ipc.utils.d.a(c.f518564c, new h(r100, r101));
    }
}
