package lr0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends a {
    public c(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        this.f510385a.notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnExit);
        return null;
    }
}
