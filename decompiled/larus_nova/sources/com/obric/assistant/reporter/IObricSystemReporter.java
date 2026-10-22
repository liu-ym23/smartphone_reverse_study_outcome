package com.obric.assistant.reporter;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.login.LoginReportImpl$report$1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/reporter/IObricSystemReporter;", "", "init", "", "reportSystemEvent", "eventName", "", "params", "Lorg/json/JSONObject;", "acquireDeviceId", "acquirer", "Lkotlin/Function1;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricSystemReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f391337a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f391338a = null;

        static {
            f391338a = new a();
        }

        public a() {
        }

        public static IObricSystemReporter a() {
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
            return null;
        L7:
            return (IObricSystemReporter) ServiceManager.get().getService(IObricSystemReporter.class);
        }
    }

    static {
        f391337a = a.f391338a;
    }

    void a(LoginReportImpl$report$1.a r100);

    void b(String r100, JSONObject r101);

    void init();
}
