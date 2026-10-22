package gr0;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomWatchDurationContextService f482295a;

    public a(RoomWatchDurationContextService r100) {
        this.f482295a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        int r102 = qo0.a.f534145a;
        qo0.a.c(this.f482295a.f85283a, "isCandyToolbarShow: " + r101);
        if (r101.booleanValue() == false) goto L7;
        RoomWatchDurationContextService r103 = this.f482295a;
        if ((-1) != r103.f85284b) goto L13;
        r103.f85284b = SystemClock.elapsedRealtime();
        return;
    L13:
        return;
    L7:
        this.f482295a.f();
        OpenPlatformContext r104 = this.f482295a.getOpenPlatformContext();
        if (r104 == null) goto L12;
        ((MiniGameContext) r104).setMiniGameInstance(null);
        this.f482295a.dispose();
        RoomWatchDurationContextService r105 = this.f482295a;
        r105.f85284b = -1;
        r105.f85285c = false;
        r105.f85287e = false;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }
}
