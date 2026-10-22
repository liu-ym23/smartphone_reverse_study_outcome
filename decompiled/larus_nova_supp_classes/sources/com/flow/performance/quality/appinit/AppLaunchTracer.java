package com.flow.performance.quality.appinit;

import android.util.EventsUtils;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.utils.logger.FLogger;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001e\u001a\u00020\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0 J\u001e\u0010\"\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u001e\u0010$\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J.\u0010%\u001a\u00020\u00192\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J&\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J&\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J6\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J&\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00062\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016J\u0018\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\u0018\u00102\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0016J\"\u00104\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000106H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00067"}, d2 = {"Lcom/flow/performance/quality/appinit/AppLaunchTracer;", "Lcom/larus/platform/api/IAppLaunchReporter;", "Lcom/flow/performance/quality/reporter/api/ILogger;", "<init>", "()V", "BIZ_TYPE", XmlPullParser.NO_NAMESPACE, "MAJOR_NAME", "MINOR_NAME", "isInited", "Ljava/util/concurrent/atomic/AtomicBoolean;", "LAUNCH_TRACER_KEY_LAUNCH_TIME", "LAUNCH_TRACER_KEY_AGREE_PRIVACY", "LAUNCH_TRACER_KEY_TOURIST_MODE", "LAUNCH_TRACER_KEY_IS_BACKGROUND", "LAUNCH_TRACER_KEY_IS_LOGIN", "LAUNCH_TRACER_KEY_APP_DURATION", "LAUNCH_TRACER_KEY_TIME_STAMP", "mScene", "Lcom/flow/performance/quality/reporter/api/IScene;", "getMScene", "()Lcom/flow/performance/quality/reporter/api/IScene;", "mScene$delegate", "Lkotlin/Lazy;", "init", XmlPullParser.NO_NAMESPACE, "isDebug", XmlPullParser.NO_NAMESPACE, "reporter", "Lcom/flow/performance/quality/reporter/api/IEventReporter;", "updateCommonParams", "map", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "reportSenseStart", "extraMap", "reportSenseSuccess", "reportSenseFail", "errCode", XmlPullParser.NO_NAMESPACE, "errMsg", "reportStepStart", "step", "reportStepSuccess", "reportStepFail", "reportEvent", "event", "d", "tag", "msg", "i", "w", "e", "t", XmlPullParser.NO_NAMESPACE, "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class AppLaunchTracer implements IAppLaunchReporter, b {
    public static final AppLaunchTracer a = null;
    public static final AtomicBoolean b = null;
    public static final Lazy c = null;

    private AppLaunchTracer() {
    }

    static {
        a = new AppLaunchTracer();
        b = new AtomicBoolean(false);
        c = LazyKt.lazy(new a());
    }

    public static void e(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        int r1 = iu7.a.a;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r3, "map");     // Catch: Exception -> L8
        ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> r0 = c.a;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r3, "params");     // Catch: Exception -> L8
        if (r3.isEmpty() == true) goto L13;
        c.b.putAll(r3);     // Catch: Exception -> L8
        return;
    L13:
        return;
    L8:
        e = move-exception;
        FLogger.a.e("AppLaunchTracer", "updateCommonParams error", e);
    }

    @Override // ju7.b
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.d("f_quality", r3);
    }

    @Override // ju7.b
    public final void i(String r3) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.i("f_quality", r3);
    }

    @Override // ju7.b
    public final void w(String r3) {
        Intrinsics.checkNotNullParameter("f_quality", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        FLogger.a.w("f_quality", r3);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void b(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "step");
        ((ju7.c) c.getValue()).b(r2, r3);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void c(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "step");
        ((ju7.c) c.getValue()).c(r2, r3);
    }

    @Override // com.larus.platform.api.IAppLaunchReporter
    public final void a(String r2, Map<String, ? extends Object> r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "step");
        Intrinsics.checkNotNullParameter(r5, "errMsg");
        ((ju7.c) c.getValue()).d(r2, r4, r5, r3);
    }
}
