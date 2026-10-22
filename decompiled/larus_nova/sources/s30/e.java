package s30;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f540440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebcastRedirectReportInfo f540441b;

    public e(b r100, WebcastRedirectReportInfo r101) {
        this.f540440a = r100;
        this.f540441b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Object r101 = this.f540440a.f540424b;
        monitor-enter(r101);
        com.bytedance.android.live.browser.schema.core.c r102 = this.f540440a.f540423a;     // Catch: Throwable -> L15
        com.bytedance.android.live.browser.schema.core.c r103 = null;
        if (r102 == null) goto L10;
        if (r102.f64202b.a() == false) goto L9;
        r102 = null;
    L9:
        r103 = r102;
    L10:
        monitor-exit(r101);
        if (r103 == null) goto L13;
        this.f540441b.a("ugsettings_source", "0");
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "hit from cache");
        r100.onNext(r103);
    L13:
        r100.onComplete();
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
