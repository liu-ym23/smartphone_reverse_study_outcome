package wha;

import com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static final IWakeupStatisticsAPI a() {
        return (IWakeupStatisticsAPI) ServiceManager.get().getService(IWakeupStatisticsAPI.class);
    }
}
