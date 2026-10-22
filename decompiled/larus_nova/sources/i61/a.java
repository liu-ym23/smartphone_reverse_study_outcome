package i61;

import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.context.PlatformExpRoomContext;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f488358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d61.a f488359b;

    public abstract String a();

    @Override // i61.b
    public void onRelease() {
        this.f488358a.clear();
    }

    public final d61.a getContext() {
        return this.f488359b;
    }

    public a(PlatformExpRoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f488359b = r100;
        this.f488358a = new CompositeDisposable();
    }

    public final void b(n61.a r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        SimpleAlogArgsBuilder r101 = new SimpleAlogArgsBuilder();
        r101.c(a() + " 生产source:" + r100);
        ExpOptLog.d(r101.b());
        this.f488359b.getWorkshop().processSource(r100);
    }
}
