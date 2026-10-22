package lr0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends lr0.a {

    public static final class a {
    }

    static {
    }

    public d(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.containsKey("game_interrupt") == true) goto L6;
        return null;
    L6:
        if (r100.getBoolean("game_interrupt") == false) goto L8;
        this.f510385a.notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnStop);
        this.f510385a.tryClearMiniGameInstance(MiniGameContext.StopType.ON_MINI_GAME_STOP);
        return null;
    L8:
        this.f510385a.notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnResume);
        return null;
    }
}
