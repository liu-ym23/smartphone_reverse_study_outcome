package vh1;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w1 extends com.bytedance.android.livesdk.room.c<ls2.c> {
    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public w1() {
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(com.bytedance.android.livesdk.room.b r100, ts2.f r101) {
        if (r100.f510497d.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_NEED_PREFETCH_ROOM_INFO, false) == false) goto L5;
        ((xh1.c) r100.a(xh1.c.class)).Xd(false, new v1(r100));
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
