package com.bytedance.map.api.service;

import com.bytedance.map.api.plugin.IMapPluginSpiService;

/* JADX INFO: loaded from: classes21.dex */
public interface IMapHostServiceProvider {
    IMapInstanceService getMapInstanceService();

    IMapPluginSpiService getMapPluginSpiService();
}
