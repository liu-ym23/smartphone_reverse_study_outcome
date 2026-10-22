package com.bytedance.bdp.bdpbase.core;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpPluginService extends BdpPluginAdapterService {
    Application getHostApplication();

    Class k1(String r100);
}
