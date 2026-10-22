package com.bytedance.bdp.bdpbase.util;

import android.app.Application;
import com.bytedance.bdp.bdpbase.core.BdpPluginService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;

/* JADX INFO: loaded from: classes11.dex */
public final class b {
    public static final ClassLoader a() {
        Application r100 = ((BdpPluginService) BdpManager.getInst().getService(BdpPluginService.class)).getHostApplication();
        if (r100 == null) goto L7;
        return r100.getClassLoader();
    L7:
        throw new RuntimeException("ClassLoaderUtil.getApplicationClassLoader() 方法中application必须不为空！");
    }
}
