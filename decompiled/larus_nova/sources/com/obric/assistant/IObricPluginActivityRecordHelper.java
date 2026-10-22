package com.obric.assistant;

import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/assistant/IObricPluginActivityRecordHelper;", "", "onPluginActivityResume", "", "activity", "", "onPluginActivityPause", "onPluginActivityStop", "isPluginForeground", "", "cancelBackgroundResetJob", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPluginActivityRecordHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f385120a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f385121a = null;

        static {
            f385121a = new a();
        }

        public a() {
        }

        public static IObricPluginActivityRecordHelper a() {
            if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
            return null;
        L7:
            return (IObricPluginActivityRecordHelper) ServiceManager.get().getService(IObricPluginActivityRecordHelper.class);
        }
    }

    static {
        f385120a = a.f385121a;
    }

    void a(String r100);

    void b();

    void c();

    void d();

    boolean e();
}
