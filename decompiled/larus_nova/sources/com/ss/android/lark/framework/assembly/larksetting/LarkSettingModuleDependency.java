package com.ss.android.lark.framework.assembly.larksetting;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import org.json.JSONObject;
import yzb.b;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(ppb.a.class)
public class LarkSettingModuleDependency implements ppb.a {
    public static final String CONFIG_KEY = "messenger_feed_load_count";
    public static final String CONTACTS_CONFIG = "contacts_config";
    public static final String DYNAMIC_URL = "dynamic_url_mapper";
    private static final String KEY_OP_MONITOR_CONFIG = "monitor";
    public static final String KEY_SHORTLINK = "short_applink_to_long_applink";
    public static final String SETTING_BLANK_DETECT = "blank_detect";
    private static final String TAG = "SettingModuleDependency";
    b mUserListApi;

    public class a implements ppb.a.InterfaceC7225a {
        public a() {
        }
    }

    public LarkSettingModuleDependency() {
    }

    private b getUserListApi() {
        if (this.mUserListApi != null) goto L6;
        this.mUserListApi = (b) LarkContext.spiByDwarf(b.class);
    L6:
        return this.mUserListApi;
    }

    @Override // ppb.a
    public ppb.a.InterfaceC7225a getFeatureGatingDependency() {
        return new a();
    }

    public String getUserId() {
        return getUserListApi().c();
    }

    @Override // ppb.a
    public void fillDefaultKey2LoadConfigMap(Map<String, jpb.a> r100) {
        monitor-enter(r100);
        jpb.a r101 = jpb.a.f500010b;     // Catch: Throwable -> L6
        r100.put(CONFIG_KEY, r101);     // Catch: Throwable -> L6
        jpb.a r102 = new jpb.a();     // Catch: Throwable -> L6
        r102.f500011a = false;     // Catch: Throwable -> L6
        r100.put(KEY_OP_MONITOR_CONFIG, r102);     // Catch: Throwable -> L6
        r100.put(KEY_SHORTLINK, r101);     // Catch: Throwable -> L6
        r100.put(SETTING_BLANK_DETECT, r101);     // Catch: Throwable -> L6
        r100.put(CONTACTS_CONFIG, r101);     // Catch: Throwable -> L6
        r100.put(DYNAMIC_URL, r101);     // Catch: Throwable -> L6
        monitor-exit(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // ppb.a
    public void sendEvent(String r100, JSONObject r101) {
        Statistics.sendEvent(r100, r101);
    }
}
