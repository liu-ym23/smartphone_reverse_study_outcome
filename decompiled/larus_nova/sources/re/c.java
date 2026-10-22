package re;

import com.bytedance.android.livesdkapi.room.handler.ILiveRoomMessageHandler;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@GenProtoDecoders
public final class c implements td.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveRoomMessageHandler f537397a;

    public c(ILiveRoomMessageHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "realHandler");
        this.f537397a = r100;
    }

    @Override // td.c
    public final void b(td.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILiveRoomMessageHandler r101 = this.f537397a;
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Live");
        r101.removeListener(com.bytedance.android.ec.adapter.impl.converter.c.f.f42775b.b(r100));
    }

    @Override // td.c
    public final void a(int r100, td.a r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        ILiveRoomMessageHandler r102 = this.f537397a;
        Intrinsics.checkNotNullParameter(r101, "$this$convert2Live");
        r102.addListener(r100, com.bytedance.android.ec.adapter.impl.converter.c.f.f42775b.a(r101));
    }
}
