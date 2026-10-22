package com.obric.aiagent.platform;

import com.obric.aiagent.runtime.AppContextImpl;
import com.obric.aiagent.runtime.BuildContextImpl;
import com.obric.aiagent.runtime.CloudConfigImpl;
import com.obric.aiagent.runtime.LogDependImpl;
import com.obric.aiagent.runtime.TraceDependImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/platform/IAIAgentPlatform;", "", "getAppContext", "Lcom/obric/aiagent/platform/depend/IAppContext;", "getRuntimeContext", "Lcom/obric/aiagent/platform/depend/IRuntimeContext;", "getBuildContext", "Lcom/obric/aiagent/platform/depend/IBuildContext;", "getLogger", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "getSecureLogger", "Lcom/obric/aiagent/platform/depend/ISecureLogDepend;", "getSysLogger", "Lcom/obric/aiagent/platform/depend/ISysLogDepend;", "getTracer", "Lcom/obric/aiagent/platform/depend/ITraceDepend;", "getCloudConfig", "Lcom/obric/aiagent/platform/depend/ICloudConfig;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIAgentPlatform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f384974a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f384975a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Map<String, Object> f384976b = null;

        public a() {
        }

        static {
            f384975a = new a();
            f384976b = new LinkedHashMap();
        }
    }

    static {
        f384974a = a.f384975a;
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
