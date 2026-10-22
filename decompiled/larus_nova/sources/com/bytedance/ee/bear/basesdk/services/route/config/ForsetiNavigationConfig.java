package com.bytedance.ee.bear.basesdk.services.route.config;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes15.dex */
@AppConfig(key = ForsetiNavigationConfig.FORSETI_NAVIGATION_CONFIG_KEY)
public class ForsetiNavigationConfig implements NonProguard {
    public static final String FORSETI_NAVIGATION_CONFIG_KEY = "ccm_forseti_open_docx_by_activity_route_config";
    public ArrayList<String> enableSceneList;

    public ForsetiNavigationConfig() {
    }
}
