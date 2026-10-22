package com.flow.performance.quality.appinit;

import com.larus.platform.api.IAppLaunchReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import gu7.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ju7.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mu7.c;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001e\u001a\u00020\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0 J\u001e\u0010\"\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u001e\u0010$\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J.\u0010%\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J&\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J&\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J6\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J&\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\u0018\u00102\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\"\u00104\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00067"}, d2 = {"Lcom/flow/performance/quality/appinit/AppLaunchTracer;", "Lcom/larus/platform/api/IAppLaunchReporter;", "Lcom/flow/performance/quality/reporter/api/ILogger;", "<init>", "()V", "BIZ_TYPE", "", "MAJOR_NAME", "MINOR_NAME", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LAUNCH_TRACER_KEY_LAUNCH_TIME", "LAUNCH_TRACER_KEY_AGREE_PRIVACY", "LAUNCH_TRACER_KEY_TOURIST_MODE", "LAUNCH_TRACER_KEY_IS_BACKGROUND", "LAUNCH_TRACER_KEY_IS_LOGIN", "LAUNCH_TRACER_KEY_APP_DURATION", "LAUNCH_TRACER_KEY_TIME_STAMP", NativeDownloadModel.JsonKey.SCENE, "Lcom/flow/performance/quality/reporter/api/IScene;", "getMScene", "()Lcom/flow/performance/quality/reporter/api/IScene;", "mScene$delegate", "Lkotlin/Lazy;", "init", "", "isDebug", "", "reporter", "Lcom/flow/performance/quality/reporter/api/IEventReporter;", "updateCommonParams", "map", "", "", "reportSenseStart", "extraMap", "reportSenseSuccess", "reportSenseFail", "errCode", "", "errMsg", "reportStepStart", "step", "reportStepSuccess", "reportStepFail", "reportEvent", "event", "d", "tag", "msg", RXScreenCaptureService.KEY_INDEX, "w", "e", "t", "", "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppLaunchTracer implements IAppLaunchReporter, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppLaunchTracer f274169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f274170b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f274171c = null;

    private AppLaunchTracer() {
    }

    static {
        f274169a = new AppLaunchTracer();
        f274170b = new AtomicBoolean(false);
        f274171c = LazyKt.lazy(new a());
    }

    public static void e(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        int r101 = iu7.a.f495802a;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r100, "map");     // Catch: Exception -> L8
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> r102 = c.f515781a;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r100, "params");     // Catch: Exception -> L8
        if (r100.isEmpty() == true) goto L13;
        c.f515782b.putAll(r100);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("AppLaunchTracer", "updateCommonParams error", e);
    }

    @Override // ju7.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.d("f_quality", r100);
    }

    @Override // ju7.b
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.i("f_quality", r100);
    }

    @Override // ju7.b
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        FLogger.f375446a.w("f_quality", r100);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        ((ju7.c) f274171c.getValue()).b(r100, r101);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void c(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        ((ju7.c) f274171c.getValue()).c(r100, r101);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void a(String r100, Map<String, ? extends Object> r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r103, "errMsg");
        ((ju7.c) f274171c.getValue()).d(r100, r102, r103, r101);
    }
}
