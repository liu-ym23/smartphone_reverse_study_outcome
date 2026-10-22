package com.obric.assistant.performance;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/obric/assistant/performance/IObricMemoryReportService;", "", "init", "", "changeScene", "scene", "", "onStateChange", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricMemoryReportService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f390977a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f390978a = null;

        static {
            f390978a = new a();
        }

        public a() {
        }

        public static IObricMemoryReportService a() {
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
            return null;
        L7:
            return (IObricMemoryReportService) ServiceManager.get().getService(IObricMemoryReportService.class);
        }
    }

    static {
        f390977a = a.f390978a;
    }

    void a(String r100, boolean r101);

    void init();
}
