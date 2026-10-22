package l20;

import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f507094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f507095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final XplayMonitorSession f507096c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        c r100 = this.f507094a;
        r100.f507091b.clear();
        r100.f507090a = null;
        this.f507095b.dispose();
    }

    public e(p r100, XplayMonitorSession r101) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        Intrinsics.checkNotNullParameter(r101, "monitorSession");
        this.f507096c = r101;
        this.f507094a = new c();
        this.f507095b = new CompositeDisposable();
    }
}
