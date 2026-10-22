package r9a;

import com.obric.aiagent.platform.IAIAgentPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    static {
    }

    public static IAIAgentPlatform a() {
        return (IAIAgentPlatform) ServiceManager.get().getService(IAIAgentPlatform.class);
    }
}
