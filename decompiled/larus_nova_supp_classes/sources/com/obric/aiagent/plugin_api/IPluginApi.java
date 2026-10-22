package com.obric.aiagent.plugin_api;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IPluginApi {
    void init();

    String query(Context r1, String r2, Bundle r3);

    String startTargetActivity(Context r1, Class<?> r2);

    String startTargetActivity(Context r1, String r2);
}
