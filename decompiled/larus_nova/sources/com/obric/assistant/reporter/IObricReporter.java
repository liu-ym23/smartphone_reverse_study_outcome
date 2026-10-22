package com.obric.assistant.reporter;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\bg\u0018\u0000 &2\u00020\u0001:\u0001&J\b\u0010\u0002\u001a\u00020\u0003H&J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0006H&J\b\u0010\u001b\u001a\u00020\u0006H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&JB\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\t2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010$H&J\b\u0010%\u001a\u00020\u0003H&¨\u0006'"}, d2 = {"Lcom/obric/assistant/reporter/IObricReporter;", "", "initLaunchReport", "", "updateLaunchReportParams", "launchMethod", "", "launchService", "allowUpdateInForeground", "", "updateLaunchServiceParams", "resetLaunchReportParams", "getLaunchMethod", "getLaunchService", "getKeepAliveLevelMode", "getLastLaunchType", "", "initObricAppStartManager", "getCurrentProcessAdj", "markStartedByExternalKeepAliveNormalService", "setLastBackgroundTime", "time", "", "getLastBackgroundTime", "initFrontierReport", "updateWakeupSource", "source", "getWakeupSource", "initBuildChannelWriteValue", "initFlowAppLogObserver", "reportPerformanceCost", "scene", "stage", "costMs", "success", "extra", "", "flushCachedDialogClicks", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f391335a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f391336a = null;

        static {
            f391336a = new a();
        }

        public a() {
        }

        public static IObricReporter a() {
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
            return null;
        L7:
            return (IObricReporter) ServiceManager.get().getService(IObricReporter.class);
        }
    }

    public static final class b {
        public static /* synthetic */ void a(IObricReporter r100, String r101, String r102, long r110, boolean r111, int r112) {
            if ((r112 & 8) == 0) goto L5;
            boolean r103 = true;
        L6:
            r100.h(r101, r102, r110, r103, null);
            return;
        L5:
            r103 = r111;
            goto L6
        }
    }

    static {
        f391335a = a.f391336a;
    }

    String a();

    void b(String r100);

    void c();

    void d();

    void e();

    void f();

    void g();

    String getWakeupSource();

    void h(String r100, String r101, long r102, boolean r103, Map<String, String> r104);

    void i();

    String j();

    void k();

    String l();

    int m();

    void n(String r100, String r101, boolean r102);

    void o();

    void p(String r100);

    int q();

    void r();
}
