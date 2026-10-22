package com.bytedance.pia.core.spi;

import com.bytedance.pia.core.spi.api.IPiaConfigTask;
import com.bytedance.pia.core.utils.d;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes21.dex */
public class ConfigTask implements IPiaConfigTask {
    public ConfigTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    public static IPiaConfigTask get() {
        return (IPiaConfigTask) ServiceManager.get().getService(IPiaConfigTask.class);
    L4:
        d.i("[SPI] try get config task failed, fallback to default.");
        return new ConfigTask();
    }
}
