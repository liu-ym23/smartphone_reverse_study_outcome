package ir0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends lr0.a {
    public b(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        RoomWatchDurationContextService r101 = (RoomWatchDurationContextService) this.f510385a.getService(RoomWatchDurationContextService.class);
        r101.f85287e = true;
        r101.f();
        return null;
    }
}
