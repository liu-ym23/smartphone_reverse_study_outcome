package com.obric.aiagent.platform;

import android.util.EventsUtils;
import com.obric.aiagent.runtime.AppContextImpl;
import com.obric.aiagent.runtime.BuildContextImpl;
import com.obric.aiagent.runtime.CloudConfigImpl;
import com.obric.aiagent.runtime.LogDependImpl;
import com.obric.aiagent.runtime.TraceDependImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/platform/IAIAgentPlatform;", XmlPullParser.NO_NAMESPACE, "getAppContext", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getRuntimeContext", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "getBuildContext", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "getLogger", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "getSecureLogger", "Lcom/obric/aiagent/platform/depend/ISecureLogDepend;", "getSysLogger", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "getTracer", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "getCloudConfig", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IAIAgentPlatform {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Map<String, Object> b = null;

        public a() {
        }

        static {
            a = new a();
            b = new LinkedHashMap();
        }
    }

    static {
        a = a.a;
    }

    CloudConfigImpl a();

    void b();

    BuildContextImpl c();

    void d();

    TraceDependImpl e();

    void f();

    AppContextImpl getAppContext();

    LogDependImpl getLogger();
}
