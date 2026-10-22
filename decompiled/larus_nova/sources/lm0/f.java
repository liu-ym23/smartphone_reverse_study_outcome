package lm0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f509832a;

    public f(e r100) {
        this.f509832a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        ALogger.d("ExitMicTimeLimitTrigger", "insert");
        e r102 = this.f509832a;
        r102.d(r102.f509828f);
    }
}
