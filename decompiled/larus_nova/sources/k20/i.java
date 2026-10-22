package k20;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f501468a = null;

    static {
        f501468a = new i();
    }

    public i() {
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        InteractGameContext r100 = InteractGameContext.Companion.getContext();
        if (r100 == null) goto L8;
        m<Boolean> r101 = r100.isXPlayGameSessionRunning();
        if (r101 == null) goto L9;
        r101.setValue(Boolean.FALSE);
        return;
    L9:
        return;
    }
}
