package com.obric.aiagent.plugin_api;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public interface IPluginApi {
    void init();

    String query(Context r100, String r101, Bundle r102);

    String startTargetActivity(Context r100, Class<?> r101);

    String startTargetActivity(Context r100, String r101);
}
