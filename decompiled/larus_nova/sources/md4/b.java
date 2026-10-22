package md4;

import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerName;
import com.bytedance.caijing.sdk.infra.base.api.container.jsbDependency.ContainerType;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface b {
    ContainerName a();

    String getContainerId();

    ContainerType getContainerType();

    Map<String, String> getReportParams();

    String getSchema();

    Map<String, String> getSecurityHeader();
}
