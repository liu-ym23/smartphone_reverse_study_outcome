package ph6;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements qh0.d<rh0.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qg6.a f529289a;

    public j(tg6.b r100) {
        this.f529289a = r100;
    }

    @Override // qh0.d
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        this.f529289a.b(r100);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r100) {
        this.f529289a.a();
    }
}
