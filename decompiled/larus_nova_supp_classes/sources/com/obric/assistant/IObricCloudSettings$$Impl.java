package com.obric.assistant;

import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import h37.f;
import j37.a;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import m37.c;
import m37.d;
import m37.e;
import m37.h;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class IObricCloudSettings$$Impl implements IObricCloudSettings {
    private static final Gson GSON = null;
    private static final int VERSION = -589498109;
    private IEnsure iEnsure;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private a mExposedManager;
    private final d mInstanceCreator;
    private final ConcurrentHashMap<String, Object> mStickySettings;
    private f mStorage;
    private final ConcurrentHashMap<String, Object> mTransientSettings;

    public class k implements d {
        public k() {
        }

        @Override // m37.d
        public final <T> T create(Class<T> r2) {
            if (r2 != l1.class) goto L7;
            return (T) new l1();
        L7:
            if (r2 != k1.class) goto L11;
            return (T) new k1();
        L11:
            if (r2 == q4.class) goto L13;
            return null;
        L13:
            return (T) new q4();
        }
    }

    public class x1 extends TypeToken<JsonObject> {
        public x1() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean enableObricSettingsOverride() {
        this.mExposedManager.e("obric_settings_override_enable");
        if (a.g("obric_settings_override_enable") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_settings_override_enable time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return true;
    L10:
        if (r1.contains("obric_settings_override_enable") == false) goto L12;
        return this.mStorage.getBoolean("obric_settings_override_enable");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getAgentSkillsSettingsJson() {
        this.mExposedManager.e("o_agent_skills");
        if (a.g("o_agent_skills") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = o_agent_skills time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("o_agent_skills") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("o_agent_skills", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("o_agent_skills") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("o_agent_skills"), new e0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("o_agent_skills");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getAutoGuiAutomaticExecutionAuthorizationConfig() {
        this.mExposedManager.e("auto_gui_automatic_execution_authorization");
        if (a.g("auto_gui_automatic_execution_authorization") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = auto_gui_automatic_execution_authorization time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("auto_gui_automatic_execution_authorization") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("auto_gui_automatic_execution_authorization", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("auto_gui_automatic_execution_authorization") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("auto_gui_automatic_execution_authorization"), new c0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("auto_gui_automatic_execution_authorization");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public ObricMmtVideoHardwareConfig getMmtVideoHardwareConfig() {
        this.mExposedManager.e("obric_mmt_video_hardware_config");
        if (a.g("obric_mmt_video_hardware_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_mmt_video_hardware_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_mmt_video_hardware_config") == false) goto L14;
        ObricMmtVideoHardwareConfig r1 = (ObricMmtVideoHardwareConfig) this.mCachedSettings.get("obric_mmt_video_hardware_config");
        if (r1 != null) goto L33;
        ((l1) c.a(l1.class, this.mInstanceCreator)).getClass();
        r1 = new ObricMmtVideoHardwareConfig(false, null, 3, null);
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L33;
        r2.ensureNotReachHere("value == null obric_mmt_video_hardware_config");
    L33:
        return r1;
    L14:
        f r3 = this.mStorage;
        if (r3 != null) goto L17;
    L27:
        ((l1) c.a(l1.class, this.mInstanceCreator)).getClass();
        r1 = new ObricMmtVideoHardwareConfig(false, null, 3, null);
    L28:
        if (r1 == null) goto L30;
        this.mCachedSettings.put("obric_mmt_video_hardware_config", r1);
        goto L33
    L30:
        ((l1) c.a(l1.class, this.mInstanceCreator)).getClass();
        r1 = new ObricMmtVideoHardwareConfig(false, null, 3, null);
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere("value == null key = obric_mmt_video_hardware_config");
        goto L33
    L17:
        if (r3.contains("obric_mmt_video_hardware_config") == false) goto L27;
        String r5 = this.mStorage.getString("obric_mmt_video_hardware_config");
        ObricMmtVideoHardwareConfig r6 = (ObricMmtVideoHardwareConfig) GSON.fromJson(r5, new g0().getType());     // Catch: Exception -> L21
    L26:
        r1 = r6;
    L21:
        e = move-exception;
        ((l1) c.a(l1.class, this.mInstanceCreator)).getClass();
        ObricMmtVideoHardwareConfig r7 = new ObricMmtVideoHardwareConfig(false, null, 3, null);
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L25;
        r8.ensureNotReachHere(e, "gson from json error" + r5);
    L25:
        e.printStackTrace();
        r6 = r7;
        goto L26
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricActionBarItemsConfig() {
        this.mExposedManager.e("obric_action_bar_items_config");
        if (a.g("obric_action_bar_items_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_action_bar_items_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_action_bar_items_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_action_bar_items_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_action_bar_items_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_action_bar_items_config"), new h0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_action_bar_items_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricActionBarModelMenuConfig() {
        this.mExposedManager.e("obric_action_bar_model_menu_config");
        if (a.g("obric_action_bar_model_menu_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_action_bar_model_menu_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_action_bar_model_menu_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_action_bar_model_menu_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_action_bar_model_menu_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_action_bar_model_menu_config"), new i0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_action_bar_model_menu_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAiKeyConfig() {
        this.mExposedManager.e("obric_ai_key_config");
        if (a.g("obric_ai_key_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_ai_key_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_ai_key_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_ai_key_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_ai_key_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_ai_key_config"), new u0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_ai_key_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAigcGenerationStateConfig() {
        this.mExposedManager.e("obric_aigc_generation_state_config");
        if (a.g("obric_aigc_generation_state_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_aigc_generation_state_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_aigc_generation_state_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_aigc_generation_state_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_aigc_generation_state_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_aigc_generation_state_config"), new f2().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_aigc_generation_state_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAppFunctionSettings() {
        this.mExposedManager.e("obric_app_function_settings");
        if (a.g("obric_app_function_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_app_function_settings time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_app_function_settings") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_app_function_settings", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_app_function_settings") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_app_function_settings"), new v().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_app_function_settings");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAppIntentLockScreenExecuteConfig() {
        this.mExposedManager.e("obric_appintent_lockscreen_execute_config");
        if (a.g("obric_appintent_lockscreen_execute_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_appintent_lockscreen_execute_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_appintent_lockscreen_execute_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_appintent_lockscreen_execute_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_appintent_lockscreen_execute_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_appintent_lockscreen_execute_config"), new r1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_appintent_lockscreen_execute_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAppIntentScreenshotCacheConfig() {
        this.mExposedManager.e("obric_appintent_screenshot_cache_config");
        if (a.g("obric_appintent_screenshot_cache_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_appintent_screenshot_cache_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_appintent_screenshot_cache_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_appintent_screenshot_cache_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_appintent_screenshot_cache_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_appintent_screenshot_cache_config"), new f1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_appintent_screenshot_cache_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAppLogSettingsConfig() {
        this.mExposedManager.e("obric_applog_settings_config");
        if (a.g("obric_applog_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_applog_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_applog_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_applog_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_applog_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_applog_settings_config"), new o().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_applog_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAsrFeedbackConfig() {
        this.mExposedManager.e("obric_asr_feedback_config");
        if (a.g("obric_asr_feedback_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_asr_feedback_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_asr_feedback_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_asr_feedback_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_asr_feedback_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_asr_feedback_config"), new m0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_asr_feedback_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAutoGuiAppScopeConfig() {
        this.mExposedManager.e("obric_auto_gui_app_scope_config");
        if (a.g("obric_auto_gui_app_scope_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_auto_gui_app_scope_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_auto_gui_app_scope_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_auto_gui_app_scope_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_auto_gui_app_scope_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_auto_gui_app_scope_config"), new b0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_auto_gui_app_scope_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAutoGuiBlacklistConfig() {
        this.mExposedManager.e("obric_auto_gui_blacklist_config");
        if (a.g("obric_auto_gui_blacklist_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_auto_gui_blacklist_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_auto_gui_blacklist_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_auto_gui_blacklist_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_auto_gui_blacklist_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_auto_gui_blacklist_config"), new a0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_auto_gui_blacklist_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAutoIncreaseDelayedTimeConfig() {
        this.mExposedManager.e("obric_auto_increase_delayed_time_config");
        if (a.g("obric_auto_increase_delayed_time_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_auto_increase_delayed_time_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_auto_increase_delayed_time_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_auto_increase_delayed_time_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_auto_increase_delayed_time_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_auto_increase_delayed_time_config"), new m().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_auto_increase_delayed_time_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricAutoSettingsJson() {
        this.mExposedManager.e("OAutoSettings");
        if (a.g("OAutoSettings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = OAutoSettings time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("OAutoSettings") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("OAutoSettings", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("OAutoSettings") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("OAutoSettings"), new d0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("OAutoSettings");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricBottomTabConfig() {
        this.mExposedManager.e("obric_bottom_tab_config");
        if (a.g("obric_bottom_tab_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_bottom_tab_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_bottom_tab_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_bottom_tab_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_bottom_tab_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_bottom_tab_config"), new j0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_bottom_tab_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricBreathWakeupDataTrackerJson() {
        this.mExposedManager.e("obric_breath_wakeup_data_config");
        if (a.g("obric_breath_wakeup_data_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_breath_wakeup_data_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_breath_wakeup_data_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_breath_wakeup_data_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_breath_wakeup_data_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_breath_wakeup_data_config"), new z().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_breath_wakeup_data_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricCheckUpdateConfig() {
        this.mExposedManager.e("obric_inhouse_check_update_settings");
        if (a.g("obric_inhouse_check_update_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_inhouse_check_update_settings time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_inhouse_check_update_settings") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_inhouse_check_update_settings");
    L11:
        if (this.mCachedSettings.containsKey("obric_inhouse_check_update_settings") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_inhouse_check_update_settings");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_inhouse_check_update_settings", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_inhouse_check_update_settings", r1);
        goto L25
    L16:
        if (r2.contains("obric_inhouse_check_update_settings") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_inhouse_check_update_settings"), new c1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public HashMap<String, Object> getObricComplexTaskCaseFromPC() {
        this.mExposedManager.e("obric_pc_complex_task_case");
        if (a.g("obric_pc_complex_task_case") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_pc_complex_task_case time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_pc_complex_task_case") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        HashMap<String, Object> r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_pc_complex_task_case", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_pc_complex_task_case") == false) goto L19;
        r2 = (HashMap) GSON.fromJson(this.mStorage.getString("obric_pc_complex_task_case"), new l().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (HashMap) this.mCachedSettings.get("obric_pc_complex_task_case");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricComplexTaskSettingsConfig() {
        this.mExposedManager.e("obric_complex_task_settings_config");
        if (a.g("obric_complex_task_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_complex_task_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_complex_task_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_complex_task_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_complex_task_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_complex_task_settings_config"), new b().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_complex_task_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricContTalkConfig() {
        this.mExposedManager.e("obric_continuous_talk_settings_config");
        if (a.g("obric_continuous_talk_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_continuous_talk_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_continuous_talk_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_continuous_talk_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_continuous_talk_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_continuous_talk_settings_config"), new n0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_continuous_talk_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricCrashDumpHprofConfig() {
        this.mExposedManager.e("obric_crash_dump_hprof_config");
        if (a.g("obric_crash_dump_hprof_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_crash_dump_hprof_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_crash_dump_hprof_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_crash_dump_hprof_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_crash_dump_hprof_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_crash_dump_hprof_config"), new w().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_crash_dump_hprof_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricDoraGNewDeviceManageConfig() {
        this.mExposedManager.e("obric_dorag_new_device_manage_enable");
        if (a.g("obric_dorag_new_device_manage_enable") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_dorag_new_device_manage_enable time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_dorag_new_device_manage_enable") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_dorag_new_device_manage_enable", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_dorag_new_device_manage_enable") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_dorag_new_device_manage_enable"), new x0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_dorag_new_device_manage_enable");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricEventTaskExperimentConfig() {
        this.mExposedManager.e("obric_event_task_experiment_config");
        if (a.g("obric_event_task_experiment_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_event_task_experiment_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_event_task_experiment_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_event_task_experiment_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_event_task_experiment_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_event_task_experiment_config"), new l0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_event_task_experiment_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureAudioBreathDataTrackerConfig() {
        this.mExposedManager.e("obric_feature_audio_breath_data_tracker");
        if (a.g("obric_feature_audio_breath_data_tracker") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_audio_breath_data_tracker time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_audio_breath_data_tracker") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_audio_breath_data_tracker", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_audio_breath_data_tracker") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_audio_breath_data_tracker"), new w0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_audio_breath_data_tracker");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureAutoActionAppBlacklistConfig() {
        this.mExposedManager.e("obric_feature_auto_action_app_blacklist");
        if (a.g("obric_feature_auto_action_app_blacklist") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_auto_action_app_blacklist time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_auto_action_app_blacklist") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_auto_action_app_blacklist", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_auto_action_app_blacklist") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_auto_action_app_blacklist"), new z0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_auto_action_app_blacklist");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureCocreationReviewSupport() {
        this.mExposedManager.e("obric_feature_cocreation_review_support");
        if (a.g("obric_feature_cocreation_review_support") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_cocreation_review_support time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_feature_cocreation_review_support") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_feature_cocreation_review_support");
    L11:
        if (this.mCachedSettings.containsKey("obric_feature_cocreation_review_support") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_feature_cocreation_review_support");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_feature_cocreation_review_support", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_feature_cocreation_review_support", r1);
        goto L25
    L16:
        if (r2.contains("obric_feature_cocreation_review_support") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_cocreation_review_support"), new t1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureConfigGroup() {
        this.mExposedManager.e("obric_feature_config_group");
        if (a.g("obric_feature_config_group") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_config_group time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_config_group") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_config_group", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_config_group") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_config_group"), new i1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_config_group");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureConfigMap() {
        this.mExposedManager.e("obric_feature_config_map_settings");
        if (a.g("obric_feature_config_map_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_config_map_settings time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_config_map_settings") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_config_map_settings", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_config_map_settings") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_config_map_settings"), new j().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_config_map_settings");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureConfigSingle() {
        this.mExposedManager.e("obric_feature_config_single");
        if (a.g("obric_feature_config_single") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_config_single time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_config_single") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_config_single", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_config_single") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_config_single"), new h1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_config_single");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureDownloadCertificateConfig() {
        this.mExposedManager.e("obric_feature_download_certificate");
        if (a.g("obric_feature_download_certificate") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_download_certificate time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_download_certificate") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_download_certificate", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_download_certificate") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_download_certificate"), new w1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_download_certificate");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureExitAiAgentWhenNovaDied() {
        this.mExposedManager.e("obric_feature_exit_aiagent_when_nova_died");
        if (a.g("obric_feature_exit_aiagent_when_nova_died") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_exit_aiagent_when_nova_died time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_exit_aiagent_when_nova_died") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_exit_aiagent_when_nova_died", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_exit_aiagent_when_nova_died") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_exit_aiagent_when_nova_died"), new b2().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_exit_aiagent_when_nova_died");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureGenesisFeedbackSupport() {
        this.mExposedManager.e("obric_feature_genesis_feedback_support");
        if (a.g("obric_feature_genesis_feedback_support") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_genesis_feedback_support time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_genesis_feedback_support") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_genesis_feedback_support", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_genesis_feedback_support") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_genesis_feedback_support"), new s1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_genesis_feedback_support");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureKeepAliveHighLevel() {
        this.mExposedManager.e("obric_feature_keep_alive_high_level");
        if (a.g("obric_feature_keep_alive_high_level") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_keep_alive_high_level time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_keep_alive_high_level") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_keep_alive_high_level", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_keep_alive_high_level") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_keep_alive_high_level"), new x1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_keep_alive_high_level");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureKeepAliveLowLevel() {
        this.mExposedManager.e("obric_feature_keep_alive_low_level");
        if (a.g("obric_feature_keep_alive_low_level") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_keep_alive_low_level time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_keep_alive_low_level") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_keep_alive_low_level", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_keep_alive_low_level") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_keep_alive_low_level"), new a2().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_keep_alive_low_level");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureKeepAliveMidLevel() {
        this.mExposedManager.e("obric_feature_keep_alive_mid_level");
        if (a.g("obric_feature_keep_alive_mid_level") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_keep_alive_mid_level time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_keep_alive_mid_level") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_keep_alive_mid_level", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_keep_alive_mid_level") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_keep_alive_mid_level"), new z1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_keep_alive_mid_level");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricFeatureMemoryTogglesConfig() {
        this.mExposedManager.e("obric_memd_toggle_list_config");
        if (a.g("obric_memd_toggle_list_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_memd_toggle_list_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_memd_toggle_list_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_memd_toggle_list_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_memd_toggle_list_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_memd_toggle_list_config"), new j1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_memd_toggle_list_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricImageUploadCompressConfig() {
        this.mExposedManager.e("obric_image_upload_compress_config");
        if (a.g("obric_image_upload_compress_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_image_upload_compress_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_image_upload_compress_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_image_upload_compress_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_image_upload_compress_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_image_upload_compress_config"), new e1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_image_upload_compress_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricIpcAnomalyReportConfig() {
        this.mExposedManager.e("obric_ipc_anomaly_report_config");
        if (a.g("obric_ipc_anomaly_report_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_ipc_anomaly_report_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_ipc_anomaly_report_config") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_ipc_anomaly_report_config");
    L11:
        if (this.mCachedSettings.containsKey("obric_ipc_anomaly_report_config") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_ipc_anomaly_report_config");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_ipc_anomaly_report_config", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_ipc_anomaly_report_config", r1);
        goto L25
    L16:
        if (r2.contains("obric_ipc_anomaly_report_config") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_ipc_anomaly_report_config"), new l1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricLarkConfirmSettingsConfig() {
        this.mExposedManager.e("obric_lark_confirm_config");
        if (a.g("obric_lark_confirm_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_lark_confirm_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_lark_confirm_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_lark_confirm_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_lark_confirm_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_lark_confirm_config"), new d1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_lark_confirm_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public ObricLazyInitConfig getObricLazyInitConfig() {
        this.mExposedManager.e("background_cold_start_lazy_init_config");
        if (a.g("background_cold_start_lazy_init_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = background_cold_start_lazy_init_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("background_cold_start_lazy_init_config") == false) goto L11;
        return (ObricLazyInitConfig) this.mStickySettings.get("background_cold_start_lazy_init_config");
    L11:
        if (this.mCachedSettings.containsKey("background_cold_start_lazy_init_config") == false) goto L17;
        ObricLazyInitConfig r1 = (ObricLazyInitConfig) this.mCachedSettings.get("background_cold_start_lazy_init_config");
        if (r1 != null) goto L35;
        ((k1) c.a(k1.class, this.mInstanceCreator)).getClass();
        r1 = k1.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L35;
        r2.ensureNotReachHere("value == null background_cold_start_lazy_init_config");
    L35:
        this.mStickySettings.put("background_cold_start_lazy_init_config", r1);
        return r1;
    L17:
        f r3 = this.mStorage;
        if (r3 != null) goto L20;
    L29:
        ((k1) c.a(k1.class, this.mInstanceCreator)).getClass();
        ObricLazyInitConfig r4 = k1.a();
    L30:
        if (r4 == null) goto L32;
        this.mCachedSettings.put("background_cold_start_lazy_init_config", r4);
        r1 = r4;
        goto L35
    L32:
        ((k1) c.a(k1.class, this.mInstanceCreator)).getClass();
        r1 = k1.a();
        IEnsure r5 = this.iEnsure;
        if (r5 == null) goto L35;
        r5.ensureNotReachHere("value == null key = background_cold_start_lazy_init_config");
        goto L35
    L20:
        if (r3.contains("background_cold_start_lazy_init_config") == false) goto L29;
        String r6 = this.mStorage.getString("background_cold_start_lazy_init_config");
        r4 = (ObricLazyInitConfig) GSON.fromJson(r6, new r0().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((k1) c.a(k1.class, this.mInstanceCreator)).getClass();
        ObricLazyInitConfig r7 = k1.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L28;
        r8.ensureNotReachHere(e, "gson from json error" + r6);
    L28:
        e.printStackTrace();
        r4 = r7;
        goto L30
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricLogSettingsConfig() {
        this.mExposedManager.e("obric_log_settings_config");
        if (a.g("obric_log_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_log_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_log_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_log_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_log_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_log_settings_config"), new p().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_log_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricMemoryDataCollectConfig() {
        this.mExposedManager.e("obric_memory_data_collect_config");
        if (a.g("obric_memory_data_collect_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_memory_data_collect_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_memory_data_collect_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_memory_data_collect_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_memory_data_collect_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_memory_data_collect_config"), new b1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_memory_data_collect_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricMemoryReportConfig() {
        this.mExposedManager.e("obric_performance_memory_report_config");
        if (a.g("obric_performance_memory_report_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_memory_report_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_performance_memory_report_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_performance_memory_report_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_performance_memory_report_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_memory_report_config"), new s().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_performance_memory_report_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricModelSettingsConfig() {
        this.mExposedManager.e("obric_model_settings_config");
        if (a.g("obric_model_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_model_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_model_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_model_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_model_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_model_settings_config"), new e().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_model_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricOUseMemory() {
        this.mExposedManager.e("obric_o_use_memory");
        if (a.g("obric_o_use_memory") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_o_use_memory time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_o_use_memory") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_o_use_memory", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_o_use_memory") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_o_use_memory"), new a1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_o_use_memory");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricOmniDataFeedbackToggleMap() {
        this.mExposedManager.e("obric_omni_data_feedback_toggle_map");
        if (a.g("obric_omni_data_feedback_toggle_map") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_omni_data_feedback_toggle_map time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_omni_data_feedback_toggle_map") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_omni_data_feedback_toggle_map", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_omni_data_feedback_toggle_map") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_omni_data_feedback_toggle_map"), new p1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_omni_data_feedback_toggle_map");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricOmniSupportFileUploadMap() {
        this.mExposedManager.e("obric_omni_support_file_upload_map");
        if (a.g("obric_omni_support_file_upload_map") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_omni_support_file_upload_map time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_omni_support_file_upload_map") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_omni_support_file_upload_map", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_omni_support_file_upload_map") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_omni_support_file_upload_map"), new f0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_omni_support_file_upload_map");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricOmniUploadImageAutoDrainToggleMap() {
        this.mExposedManager.e("obric_omni_upload_image_auto_drain_toggle_map");
        if (a.g("obric_omni_upload_image_auto_drain_toggle_map") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_omni_upload_image_auto_drain_toggle_map time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_omni_upload_image_auto_drain_toggle_map") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_omni_upload_image_auto_drain_toggle_map", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_omni_upload_image_auto_drain_toggle_map") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_omni_upload_image_auto_drain_toggle_map"), new q1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_omni_upload_image_auto_drain_toggle_map");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricOneLoginConfig() {
        this.mExposedManager.e("obric_one_login_config");
        if (a.g("obric_one_login_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_one_login_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_one_login_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_one_login_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_one_login_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_one_login_config"), new y().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_one_login_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricPerformanceCPUExceptionDiagnosisSettingsConfig() {
        this.mExposedManager.e("obric_performance_cpu_exception_diagnosis_config");
        if (a.g("obric_performance_cpu_exception_diagnosis_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_cpu_exception_diagnosis_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_performance_cpu_exception_diagnosis_config") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_performance_cpu_exception_diagnosis_config");
    L11:
        if (this.mCachedSettings.containsKey("obric_performance_cpu_exception_diagnosis_config") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_performance_cpu_exception_diagnosis_config");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_performance_cpu_exception_diagnosis_config", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_performance_cpu_exception_diagnosis_config", r1);
        goto L25
    L16:
        if (r2.contains("obric_performance_cpu_exception_diagnosis_config") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_cpu_exception_diagnosis_config"), new m1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricPerformanceMonitorConfig() {
        this.mExposedManager.e("obric_performance_monitor_config");
        if (a.g("obric_performance_monitor_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_monitor_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_performance_monitor_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_performance_monitor_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_performance_monitor_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_monitor_config"), new r().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_performance_monitor_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricPerformancePowerMonitorSettingsConfig() {
        this.mExposedManager.e("obric_performance_power_monitor_config");
        if (a.g("obric_performance_power_monitor_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_power_monitor_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_performance_power_monitor_config") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_performance_power_monitor_config");
    L11:
        if (this.mCachedSettings.containsKey("obric_performance_power_monitor_config") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_performance_power_monitor_config");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_performance_power_monitor_config", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_performance_power_monitor_config", r1);
        goto L25
    L16:
        if (r2.contains("obric_performance_power_monitor_config") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_power_monitor_config"), new k1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricPowerLockConfig() {
        this.mExposedManager.e("obric_power_lock_config");
        if (a.g("obric_power_lock_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_power_lock_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_power_lock_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_power_lock_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_power_lock_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_power_lock_config"), new y1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_power_lock_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public int getObricPrivacyLaneType() {
        this.mExposedManager.e("obric_privacy_lane_type");
        if (a.g("obric_privacy_lane_type") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_privacy_lane_type time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return 1;
    L10:
        if (r1.contains("obric_privacy_lane_type") == false) goto L12;
        return this.mStorage.getInt("obric_privacy_lane_type");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricProcessesManagerConfig() {
        this.mExposedManager.e("obric_processes_manager_config");
        if (a.g("obric_processes_manager_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_processes_manager_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_processes_manager_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_processes_manager_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_processes_manager_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_processes_manager_config"), new n().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_processes_manager_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricProductInfoConfig() {
        this.mExposedManager.e("obric_product_info_config");
        if (a.g("obric_product_info_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_product_info_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_product_info_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_product_info_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_product_info_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_product_info_config"), new v0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_product_info_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricPromptCellConfig() {
        this.mExposedManager.e("obric_prompt_cell_config");
        if (a.g("obric_prompt_cell_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_prompt_cell_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_prompt_cell_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_prompt_cell_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_prompt_cell_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_prompt_cell_config"), new s0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_prompt_cell_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricQueryAuthenticateConfig() {
        this.mExposedManager.e("obric_query_authenticate_config");
        if (a.g("obric_query_authenticate_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_query_authenticate_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_query_authenticate_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_query_authenticate_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_query_authenticate_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_query_authenticate_config"), new g().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_query_authenticate_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricResetTaskModeTimeConfig() {
        this.mExposedManager.e("obric_reset_task_mode_time");
        if (a.g("obric_reset_task_mode_time") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_reset_task_mode_time time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_reset_task_mode_time") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_reset_task_mode_time", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_reset_task_mode_time") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_reset_task_mode_time"), new p0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_reset_task_mode_time");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricScreenshotUploadConfig() {
        this.mExposedManager.e("obric_screenshot_upload_config");
        if (a.g("obric_screenshot_upload_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_screenshot_upload_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_screenshot_upload_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_screenshot_upload_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_screenshot_upload_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_screenshot_upload_config"), new g1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_screenshot_upload_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricScriptToggleMap() {
        this.mExposedManager.e("obric_script_toggle_map");
        if (a.g("obric_script_toggle_map") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_script_toggle_map time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_script_toggle_map") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_script_toggle_map");
    L11:
        if (this.mCachedSettings.containsKey("obric_script_toggle_map") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_script_toggle_map");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_script_toggle_map", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_script_toggle_map", r1);
        goto L25
    L16:
        if (r2.contains("obric_script_toggle_map") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_script_toggle_map"), new o1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricSecuritySettingsConfig() {
        this.mExposedManager.e("obric_security_settings");
        if (a.g("obric_security_settings") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_security_settings time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_security_settings") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_security_settings", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_security_settings") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_security_settings"), new h().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_security_settings");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricSecuritySettingsPackageWhitelistConfig() {
        this.mExposedManager.e("obric_security_settings_package_whitelist");
        if (a.g("obric_security_settings_package_whitelist") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_security_settings_package_whitelist time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_security_settings_package_whitelist") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_security_settings_package_whitelist", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_security_settings_package_whitelist") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_security_settings_package_whitelist"), new i().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_security_settings_package_whitelist");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricSelfUpdateSettingsConfig() {
        this.mExposedManager.e("obric_self_update_settings_config");
        if (a.g("obric_self_update_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_self_update_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_self_update_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_self_update_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_self_update_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_self_update_settings_config"), new c().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_self_update_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricSettingsConfig() {
        this.mExposedManager.e("obric_settings_config");
        if (a.g("obric_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_settings_config"), new x().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricSettingsListConfig() {
        this.mExposedManager.e("obric_settings_list_config");
        if (a.g("obric_settings_list_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_settings_list_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_settings_list_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_settings_list_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_settings_list_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_settings_list_config"), new q().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_settings_list_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricStateMachineMultitaskConfig() {
        this.mExposedManager.e("obric_state_machine_multitask_config");
        if (a.g("obric_state_machine_multitask_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_state_machine_multitask_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_state_machine_multitask_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_state_machine_multitask_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_state_machine_multitask_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_state_machine_multitask_config"), new e2().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_state_machine_multitask_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricTaskSystemConfig() {
        this.mExposedManager.e("obric_task_system_config");
        if (a.g("obric_task_system_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_task_system_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_task_system_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_task_system_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_task_system_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_task_system_config"), new k0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_task_system_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricTaskTimeoutConfig() {
        this.mExposedManager.e("obric_task_timeout_config");
        if (a.g("obric_task_timeout_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_task_timeout_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_task_timeout_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_task_timeout_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_task_timeout_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_task_timeout_config"), new t0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_task_timeout_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricThresholdDumpHprofConfig() {
        this.mExposedManager.e("obric_performance_threshold_dump_hprof_config");
        if (a.g("obric_performance_threshold_dump_hprof_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_threshold_dump_hprof_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_performance_threshold_dump_hprof_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_performance_threshold_dump_hprof_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_performance_threshold_dump_hprof_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_threshold_dump_hprof_config"), new t().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_performance_threshold_dump_hprof_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricThresholdPssUploadFilesConfig() {
        this.mExposedManager.e("obric_performance_threshold_pss_upload_files_config");
        if (a.g("obric_performance_threshold_pss_upload_files_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_performance_threshold_pss_upload_files_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_performance_threshold_pss_upload_files_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_performance_threshold_pss_upload_files_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_performance_threshold_pss_upload_files_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_performance_threshold_pss_upload_files_config"), new u().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_performance_threshold_pss_upload_files_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricUpdateSettingsConfig() {
        this.mExposedManager.e("obric_update_settings_config");
        if (a.g("obric_update_settings_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_update_settings_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_update_settings_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_update_settings_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_update_settings_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_update_settings_config"), new d().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_update_settings_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricVoicePrintAuthenticateSettingsConfig() {
        this.mExposedManager.e("obric_voice_print_authenticate_config");
        if (a.g("obric_voice_print_authenticate_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_voice_print_authenticate_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_voice_print_authenticate_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_voice_print_authenticate_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_voice_print_authenticate_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_voice_print_authenticate_config"), new f().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_voice_print_authenticate_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricVoiceSectionTrackerEnableSlardar() {
        this.mExposedManager.e("obric_voice_section_tracker_enable_slardar");
        if (a.g("obric_voice_section_tracker_enable_slardar") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_voice_section_tracker_enable_slardar time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_voice_section_tracker_enable_slardar") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_voice_section_tracker_enable_slardar", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_voice_section_tracker_enable_slardar") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_voice_section_tracker_enable_slardar"), new d2().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_voice_section_tracker_enable_slardar");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricWakeupAudioCaptureConfig() {
        this.mExposedManager.e("obric_wakeup_audio_capture_config");
        if (a.g("obric_wakeup_audio_capture_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_wakeup_audio_capture_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_wakeup_audio_capture_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_wakeup_audio_capture_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_wakeup_audio_capture_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_wakeup_audio_capture_config"), new a().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_wakeup_audio_capture_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getObricWakeupSoundConfig() {
        this.mExposedManager.e("obric_wakeup_sound_config");
        if (a.g("obric_wakeup_sound_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_wakeup_sound_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_wakeup_sound_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_wakeup_sound_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_wakeup_sound_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_wakeup_sound_config"), new q0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_wakeup_sound_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public int getObricWakeupSoundConfigWhite() {
        this.mExposedManager.e("obric_wakeup_sound_config_white");
        if (a.g("obric_wakeup_sound_config_white") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_wakeup_sound_config_white time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return 0;
    L10:
        if (r1.contains("obric_wakeup_sound_config_white") == false) goto L12;
        return this.mStorage.getInt("obric_wakeup_sound_config_white");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public ZeusAutoFetchConfig getObricZeusAutoFetchConfig() {
        this.mExposedManager.e("obric_zeus_auto_fetch_config");
        if (a.g("obric_zeus_auto_fetch_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_zeus_auto_fetch_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_zeus_auto_fetch_config") == false) goto L11;
        return (ZeusAutoFetchConfig) this.mStickySettings.get("obric_zeus_auto_fetch_config");
    L11:
        if (this.mCachedSettings.containsKey("obric_zeus_auto_fetch_config") == false) goto L17;
        ZeusAutoFetchConfig r1 = (ZeusAutoFetchConfig) this.mCachedSettings.get("obric_zeus_auto_fetch_config");
        if (r1 != null) goto L35;
        ((q4) c.a(q4.class, this.mInstanceCreator)).getClass();
        r1 = q4.a();
        IEnsure r2 = this.iEnsure;
        if (r2 == null) goto L35;
        r2.ensureNotReachHere("value == null obric_zeus_auto_fetch_config");
    L35:
        this.mStickySettings.put("obric_zeus_auto_fetch_config", r1);
        return r1;
    L17:
        f r3 = this.mStorage;
        if (r3 != null) goto L20;
    L29:
        ((q4) c.a(q4.class, this.mInstanceCreator)).getClass();
        ZeusAutoFetchConfig r4 = q4.a();
    L30:
        if (r4 == null) goto L32;
        this.mCachedSettings.put("obric_zeus_auto_fetch_config", r4);
        r1 = r4;
        goto L35
    L32:
        ((q4) c.a(q4.class, this.mInstanceCreator)).getClass();
        r1 = q4.a();
        IEnsure r5 = this.iEnsure;
        if (r5 == null) goto L35;
        r5.ensureNotReachHere("value == null key = obric_zeus_auto_fetch_config");
        goto L35
    L20:
        if (r3.contains("obric_zeus_auto_fetch_config") == false) goto L29;
        String r6 = this.mStorage.getString("obric_zeus_auto_fetch_config");
        r4 = (ZeusAutoFetchConfig) GSON.fromJson(r6, new c2().getType());     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ((q4) c.a(q4.class, this.mInstanceCreator)).getClass();
        ZeusAutoFetchConfig r7 = q4.a();
        IEnsure r8 = this.iEnsure;
        if (r8 == null) goto L28;
        r8.ensureNotReachHere(e, "gson from json error" + r6);
    L28:
        e.printStackTrace();
        r4 = r7;
        goto L30
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getVoiceWakeupSidThresholdConfig() {
        this.mExposedManager.e("obric_voice_wakeup_sid_threshold");
        if (a.g("obric_voice_wakeup_sid_threshold") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_voice_wakeup_sid_threshold time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_voice_wakeup_sid_threshold") == false) goto L11;
        return (JsonObject) this.mStickySettings.get("obric_voice_wakeup_sid_threshold");
    L11:
        if (this.mCachedSettings.containsKey("obric_voice_wakeup_sid_threshold") == false) goto L13;
        JsonObject r1 = (JsonObject) this.mCachedSettings.get("obric_voice_wakeup_sid_threshold");
    L25:
        if (r1 == null) goto L31;
        this.mStickySettings.put("obric_voice_wakeup_sid_threshold", r1);
        return r1;
    L31:
        return r1;
    L13:
        f r2 = this.mStorage;
        if (r2 != null) goto L16;
    L22:
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        this.mCachedSettings.put("obric_voice_wakeup_sid_threshold", r1);
        goto L25
    L16:
        if (r2.contains("obric_voice_wakeup_sid_threshold") == false) goto L22;
        r1 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_voice_wakeup_sid_threshold"), new u1().getType());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getVoiceWakeupStage1Config() {
        this.mExposedManager.e("obric_voice_wakeup_stage1_config");
        if (a.g("obric_voice_wakeup_stage1_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_voice_wakeup_stage1_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_voice_wakeup_stage1_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_voice_wakeup_stage1_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_voice_wakeup_stage1_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_voice_wakeup_stage1_config"), new y0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_voice_wakeup_stage1_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getWindowActionBarItemsConfig() {
        this.mExposedManager.e("window_action_bar_item_config");
        if (a.g("window_action_bar_item_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = window_action_bar_item_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("window_action_bar_item_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("window_action_bar_item_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("window_action_bar_item_config") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("window_action_bar_item_config"), new o0().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("window_action_bar_item_config");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public JsonObject getWindowFeatureEnabled() {
        this.mExposedManager.e("obric_feature_window_mode");
        if (a.g("obric_feature_window_mode") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_feature_window_mode time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_feature_window_mode") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        JsonObject r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_feature_window_mode", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_feature_window_mode") == false) goto L19;
        r2 = (JsonObject) GSON.fromJson(this.mStorage.getString("obric_feature_window_mode"), new v1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (JsonObject) this.mCachedSettings.get("obric_feature_window_mode");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean isBypassAdaptiveSid() {
        this.mExposedManager.e("obric_bypass_adaptive_sid");
        if (a.g("obric_bypass_adaptive_sid") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_bypass_adaptive_sid time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mStickySettings.containsKey("obric_bypass_adaptive_sid") == true) goto L18;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L15:
        boolean r2 = true;
    L16:
        this.mStickySettings.put("obric_bypass_adaptive_sid", Boolean.valueOf(r2));
        return r2;
    L13:
        if (r1.contains("obric_bypass_adaptive_sid") == false) goto L15;
        r2 = this.mStorage.getBoolean("obric_bypass_adaptive_sid");
        goto L16
    L18:
        return ((Boolean) this.mStickySettings.get("obric_bypass_adaptive_sid")).booleanValue();
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean isCloseAudioConnAppBackGroundOnlyForObric() {
        this.mExposedManager.e("is_close_audio_connection_app_background_only_for_obric");
        if (a.g("is_close_audio_connection_app_background_only_for_obric") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = is_close_audio_connection_app_background_only_for_obric time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return true;
    L10:
        if (r1.contains("is_close_audio_connection_app_background_only_for_obric") == false) goto L12;
        return this.mStorage.getBoolean("is_close_audio_connection_app_background_only_for_obric");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean isObricContTalkPvadSwitchShowEnable() {
        this.mExposedManager.e("obric_continuous_talk_pvad_switch_show");
        if (a.g("obric_continuous_talk_pvad_switch_show") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_continuous_talk_pvad_switch_show time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return false;
    L10:
        if (r1.contains("obric_continuous_talk_pvad_switch_show") == false) goto L12;
        return this.mStorage.getBoolean("obric_continuous_talk_pvad_switch_show");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean isOfficeSdkLazyInitEnabled() {
        this.mExposedManager.e("obric_office_sdk_lazy_init");
        if (a.g("obric_office_sdk_lazy_init") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_office_sdk_lazy_init time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return false;
    L10:
        if (r1.contains("obric_office_sdk_lazy_init") == false) goto L12;
        return this.mStorage.getBoolean("obric_office_sdk_lazy_init");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public boolean isReRecordWakeWordGuideEnable() {
        this.mExposedManager.e("obric_re_record_wake_word_guide_enable");
        if (a.g("obric_re_record_wake_word_guide_enable") == false) goto L7;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L7;
        r0.ensureNotReachHere("get settings key = obric_re_record_wake_word_guide_enable time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L7:
        f r1 = this.mStorage;
        if (r1 != null) goto L10;
    L12:
        return false;
    L10:
        if (r1.contains("obric_re_record_wake_word_guide_enable") == false) goto L12;
        return this.mStorage.getBoolean("obric_re_record_wake_word_guide_enable");
    }

    @Override // com.obric.assistant.IObricCloudSettings
    public HashMap<String, Object> obricPluginsConfig() {
        this.mExposedManager.e("obric_plugins_config");
        if (a.g("obric_plugins_config") == false) goto L8;
        IEnsure r0 = this.iEnsure;
        if (r0 == null) goto L8;
        r0.ensureNotReachHere("get settings key = obric_plugins_config time = " + a.c() + " thread name = " + ThreadMethodProxy.currentThread().getName());
    L8:
        if (this.mCachedSettings.containsKey("obric_plugins_config") == true) goto L25;
        f r1 = this.mStorage;
        if (r1 != null) goto L13;
    L19:
        HashMap<String, Object> r2 = null;
    L20:
        if (r2 == null) goto L26;
        this.mCachedSettings.put("obric_plugins_config", r2);
        return r2;
    L26:
        return r2;
    L13:
        if (r1.contains("obric_plugins_config") == false) goto L19;
        r2 = (HashMap) GSON.fromJson(this.mStorage.getString("obric_plugins_config"), new n1().getType());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        return (HashMap) this.mCachedSettings.get("obric_plugins_config");
    }

    public IObricCloudSettings$$Impl(f r2) {
        this.mStickySettings = new ConcurrentHashMap();
        this.mTransientSettings = new ConcurrentHashMap();
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new k();
        this.mStorage = r2;
        this.mExposedManager = a.b(m37.a.getContext());
        this.iEnsure = IEnsureWrapper.getInstance();
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ISettings
    public void updateSettings(SettingsData r7) {
        h r0 = h.a(m37.a.getContext());
        if (r7 == null) goto L5;
    L33:
        if (r7 != null) goto L35;
        return;
    L35:
        if (this.mStorage == null) goto L319;
        JSONObject r2 = r7.getAppSettings();
        if (r2 != null) goto L39;
    L311:
        this.mStorage.apply();
        r0.g("nova_settings_com.obric.assistant.IObricCloudSettings", r7.getToken());
        return;
    L39:
        if (r2.has("obric_app_function_settings") == false) goto L42;
        this.mStorage.putString("obric_app_function_settings", r2.optString("obric_app_function_settings"));
        this.mCachedSettings.remove("obric_app_function_settings");
    L42:
        if (r2.has("obric_settings_override_enable") == false) goto L45;
        this.mStorage.putBoolean("obric_settings_override_enable", e.a(r2, "obric_settings_override_enable"));
    L45:
        if (r2.has("obric_office_sdk_lazy_init") == false) goto L48;
        this.mStorage.putBoolean("obric_office_sdk_lazy_init", e.a(r2, "obric_office_sdk_lazy_init"));
    L48:
        if (r2.has("obric_mmt_video_hardware_config") == false) goto L51;
        this.mStorage.putString("obric_mmt_video_hardware_config", r2.optString("obric_mmt_video_hardware_config"));
        this.mCachedSettings.remove("obric_mmt_video_hardware_config");
    L51:
        if (r2.has("background_cold_start_lazy_init_config") == false) goto L54;
        this.mStorage.putString("background_cold_start_lazy_init_config", r2.optString("background_cold_start_lazy_init_config"));
        this.mCachedSettings.remove("background_cold_start_lazy_init_config");
    L54:
        if (r2.has("obric_privacy_lane_type") == false) goto L57;
        this.mStorage.putInt("obric_privacy_lane_type", r2.optInt("obric_privacy_lane_type"));
    L57:
        if (r2.has("obric_inhouse_check_update_settings") == false) goto L60;
        this.mStorage.putString("obric_inhouse_check_update_settings", r2.optString("obric_inhouse_check_update_settings"));
        this.mCachedSettings.remove("obric_inhouse_check_update_settings");
    L60:
        if (r2.has("obric_plugins_config") == false) goto L63;
        this.mStorage.putString("obric_plugins_config", r2.optString("obric_plugins_config"));
        this.mCachedSettings.remove("obric_plugins_config");
    L63:
        if (r2.has("obric_power_lock_config") == false) goto L66;
        this.mStorage.putString("obric_power_lock_config", r2.optString("obric_power_lock_config"));
        this.mCachedSettings.remove("obric_power_lock_config");
    L66:
        if (r2.has("obric_state_machine_multitask_config") == false) goto L69;
        this.mStorage.putString("obric_state_machine_multitask_config", r2.optString("obric_state_machine_multitask_config"));
        this.mCachedSettings.remove("obric_state_machine_multitask_config");
    L69:
        if (r2.has("obric_aigc_generation_state_config") == false) goto L72;
        this.mStorage.putString("obric_aigc_generation_state_config", r2.optString("obric_aigc_generation_state_config"));
        this.mCachedSettings.remove("obric_aigc_generation_state_config");
    L72:
        if (r2.has("obric_wakeup_audio_capture_config") == false) goto L75;
        this.mStorage.putString("obric_wakeup_audio_capture_config", r2.optString("obric_wakeup_audio_capture_config"));
        this.mCachedSettings.remove("obric_wakeup_audio_capture_config");
    L75:
        if (r2.has("obric_complex_task_settings_config") == false) goto L78;
        this.mStorage.putString("obric_complex_task_settings_config", r2.optString("obric_complex_task_settings_config"));
        this.mCachedSettings.remove("obric_complex_task_settings_config");
    L78:
        if (r2.has("obric_self_update_settings_config") == false) goto L81;
        this.mStorage.putString("obric_self_update_settings_config", r2.optString("obric_self_update_settings_config"));
        this.mCachedSettings.remove("obric_self_update_settings_config");
    L81:
        if (r2.has("obric_update_settings_config") == false) goto L84;
        this.mStorage.putString("obric_update_settings_config", r2.optString("obric_update_settings_config"));
        this.mCachedSettings.remove("obric_update_settings_config");
    L84:
        if (r2.has("obric_model_settings_config") == false) goto L87;
        this.mStorage.putString("obric_model_settings_config", r2.optString("obric_model_settings_config"));
        this.mCachedSettings.remove("obric_model_settings_config");
    L87:
        if (r2.has("obric_voice_print_authenticate_config") == false) goto L90;
        this.mStorage.putString("obric_voice_print_authenticate_config", r2.optString("obric_voice_print_authenticate_config"));
        this.mCachedSettings.remove("obric_voice_print_authenticate_config");
    L90:
        if (r2.has("obric_query_authenticate_config") == false) goto L93;
        this.mStorage.putString("obric_query_authenticate_config", r2.optString("obric_query_authenticate_config"));
        this.mCachedSettings.remove("obric_query_authenticate_config");
    L93:
        if (r2.has("obric_security_settings") == false) goto L96;
        this.mStorage.putString("obric_security_settings", r2.optString("obric_security_settings"));
        this.mCachedSettings.remove("obric_security_settings");
    L96:
        if (r2.has("obric_security_settings_package_whitelist") == false) goto L99;
        this.mStorage.putString("obric_security_settings_package_whitelist", r2.optString("obric_security_settings_package_whitelist"));
        this.mCachedSettings.remove("obric_security_settings_package_whitelist");
    L99:
        if (r2.has("obric_feature_config_map_settings") == false) goto L102;
        this.mStorage.putString("obric_feature_config_map_settings", r2.optString("obric_feature_config_map_settings"));
        this.mCachedSettings.remove("obric_feature_config_map_settings");
    L102:
        if (r2.has("obric_pc_complex_task_case") == false) goto L105;
        this.mStorage.putString("obric_pc_complex_task_case", r2.optString("obric_pc_complex_task_case"));
        this.mCachedSettings.remove("obric_pc_complex_task_case");
    L105:
        if (r2.has("obric_auto_increase_delayed_time_config") == false) goto L108;
        this.mStorage.putString("obric_auto_increase_delayed_time_config", r2.optString("obric_auto_increase_delayed_time_config"));
        this.mCachedSettings.remove("obric_auto_increase_delayed_time_config");
    L108:
        if (r2.has("obric_processes_manager_config") == false) goto L111;
        this.mStorage.putString("obric_processes_manager_config", r2.optString("obric_processes_manager_config"));
        this.mCachedSettings.remove("obric_processes_manager_config");
    L111:
        if (r2.has("obric_applog_settings_config") == false) goto L114;
        this.mStorage.putString("obric_applog_settings_config", r2.optString("obric_applog_settings_config"));
        this.mCachedSettings.remove("obric_applog_settings_config");
    L114:
        if (r2.has("obric_log_settings_config") == false) goto L117;
        this.mStorage.putString("obric_log_settings_config", r2.optString("obric_log_settings_config"));
        this.mCachedSettings.remove("obric_log_settings_config");
    L117:
        if (r2.has("obric_settings_list_config") == false) goto L120;
        this.mStorage.putString("obric_settings_list_config", r2.optString("obric_settings_list_config"));
        this.mCachedSettings.remove("obric_settings_list_config");
    L120:
        if (r2.has("obric_performance_monitor_config") == false) goto L123;
        this.mStorage.putString("obric_performance_monitor_config", r2.optString("obric_performance_monitor_config"));
        this.mCachedSettings.remove("obric_performance_monitor_config");
    L123:
        if (r2.has("obric_performance_memory_report_config") == false) goto L126;
        this.mStorage.putString("obric_performance_memory_report_config", r2.optString("obric_performance_memory_report_config"));
        this.mCachedSettings.remove("obric_performance_memory_report_config");
    L126:
        if (r2.has("obric_performance_threshold_dump_hprof_config") == false) goto L129;
        this.mStorage.putString("obric_performance_threshold_dump_hprof_config", r2.optString("obric_performance_threshold_dump_hprof_config"));
        this.mCachedSettings.remove("obric_performance_threshold_dump_hprof_config");
    L129:
        if (r2.has("obric_performance_threshold_pss_upload_files_config") == false) goto L132;
        this.mStorage.putString("obric_performance_threshold_pss_upload_files_config", r2.optString("obric_performance_threshold_pss_upload_files_config"));
        this.mCachedSettings.remove("obric_performance_threshold_pss_upload_files_config");
    L132:
        if (r2.has("obric_crash_dump_hprof_config") == false) goto L135;
        this.mStorage.putString("obric_crash_dump_hprof_config", r2.optString("obric_crash_dump_hprof_config"));
        this.mCachedSettings.remove("obric_crash_dump_hprof_config");
    L135:
        if (r2.has("obric_settings_config") == false) goto L138;
        this.mStorage.putString("obric_settings_config", r2.optString("obric_settings_config"));
        this.mCachedSettings.remove("obric_settings_config");
    L138:
        if (r2.has("obric_one_login_config") == false) goto L141;
        this.mStorage.putString("obric_one_login_config", r2.optString("obric_one_login_config"));
        this.mCachedSettings.remove("obric_one_login_config");
    L141:
        if (r2.has("obric_breath_wakeup_data_config") == false) goto L144;
        this.mStorage.putString("obric_breath_wakeup_data_config", r2.optString("obric_breath_wakeup_data_config"));
        this.mCachedSettings.remove("obric_breath_wakeup_data_config");
    L144:
        if (r2.has("obric_auto_gui_blacklist_config") == false) goto L147;
        this.mStorage.putString("obric_auto_gui_blacklist_config", r2.optString("obric_auto_gui_blacklist_config"));
        this.mCachedSettings.remove("obric_auto_gui_blacklist_config");
    L147:
        if (r2.has("obric_auto_gui_app_scope_config") == false) goto L150;
        this.mStorage.putString("obric_auto_gui_app_scope_config", r2.optString("obric_auto_gui_app_scope_config"));
        this.mCachedSettings.remove("obric_auto_gui_app_scope_config");
    L150:
        if (r2.has("auto_gui_automatic_execution_authorization") == false) goto L153;
        this.mStorage.putString("auto_gui_automatic_execution_authorization", r2.optString("auto_gui_automatic_execution_authorization"));
        this.mCachedSettings.remove("auto_gui_automatic_execution_authorization");
    L153:
        if (r2.has("OAutoSettings") == false) goto L156;
        this.mStorage.putString("OAutoSettings", r2.optString("OAutoSettings"));
        this.mCachedSettings.remove("OAutoSettings");
    L156:
        if (r2.has("o_agent_skills") == false) goto L159;
        this.mStorage.putString("o_agent_skills", r2.optString("o_agent_skills"));
        this.mCachedSettings.remove("o_agent_skills");
    L159:
        if (r2.has("obric_omni_support_file_upload_map") == false) goto L162;
        this.mStorage.putString("obric_omni_support_file_upload_map", r2.optString("obric_omni_support_file_upload_map"));
        this.mCachedSettings.remove("obric_omni_support_file_upload_map");
    L162:
        if (r2.has("obric_action_bar_items_config") == false) goto L165;
        this.mStorage.putString("obric_action_bar_items_config", r2.optString("obric_action_bar_items_config"));
        this.mCachedSettings.remove("obric_action_bar_items_config");
    L165:
        if (r2.has("obric_action_bar_model_menu_config") == false) goto L168;
        this.mStorage.putString("obric_action_bar_model_menu_config", r2.optString("obric_action_bar_model_menu_config"));
        this.mCachedSettings.remove("obric_action_bar_model_menu_config");
    L168:
        if (r2.has("obric_bottom_tab_config") == false) goto L171;
        this.mStorage.putString("obric_bottom_tab_config", r2.optString("obric_bottom_tab_config"));
        this.mCachedSettings.remove("obric_bottom_tab_config");
    L171:
        if (r2.has("obric_task_system_config") == false) goto L174;
        this.mStorage.putString("obric_task_system_config", r2.optString("obric_task_system_config"));
        this.mCachedSettings.remove("obric_task_system_config");
    L174:
        if (r2.has("obric_event_task_experiment_config") == false) goto L177;
        this.mStorage.putString("obric_event_task_experiment_config", r2.optString("obric_event_task_experiment_config"));
        this.mCachedSettings.remove("obric_event_task_experiment_config");
    L177:
        if (r2.has("obric_asr_feedback_config") == false) goto L180;
        this.mStorage.putString("obric_asr_feedback_config", r2.optString("obric_asr_feedback_config"));
        this.mCachedSettings.remove("obric_asr_feedback_config");
    L180:
        if (r2.has("obric_continuous_talk_settings_config") == false) goto L183;
        this.mStorage.putString("obric_continuous_talk_settings_config", r2.optString("obric_continuous_talk_settings_config"));
        this.mCachedSettings.remove("obric_continuous_talk_settings_config");
    L183:
        if (r2.has("obric_continuous_talk_pvad_switch_show") == false) goto L186;
        this.mStorage.putBoolean("obric_continuous_talk_pvad_switch_show", e.a(r2, "obric_continuous_talk_pvad_switch_show"));
    L186:
        if (r2.has("obric_re_record_wake_word_guide_enable") == false) goto L189;
        this.mStorage.putBoolean("obric_re_record_wake_word_guide_enable", e.a(r2, "obric_re_record_wake_word_guide_enable"));
    L189:
        if (r2.has("window_action_bar_item_config") == false) goto L192;
        this.mStorage.putString("window_action_bar_item_config", r2.optString("window_action_bar_item_config"));
        this.mCachedSettings.remove("window_action_bar_item_config");
    L192:
        if (r2.has("obric_reset_task_mode_time") == false) goto L195;
        this.mStorage.putString("obric_reset_task_mode_time", r2.optString("obric_reset_task_mode_time"));
        this.mCachedSettings.remove("obric_reset_task_mode_time");
    L195:
        if (r2.has("obric_wakeup_sound_config") == false) goto L198;
        this.mStorage.putString("obric_wakeup_sound_config", r2.optString("obric_wakeup_sound_config"));
        this.mCachedSettings.remove("obric_wakeup_sound_config");
    L198:
        if (r2.has("obric_wakeup_sound_config_white") == false) goto L201;
        this.mStorage.putInt("obric_wakeup_sound_config_white", r2.optInt("obric_wakeup_sound_config_white"));
    L201:
        if (r2.has("obric_prompt_cell_config") == false) goto L204;
        this.mStorage.putString("obric_prompt_cell_config", r2.optString("obric_prompt_cell_config"));
        this.mCachedSettings.remove("obric_prompt_cell_config");
    L204:
        if (r2.has("obric_task_timeout_config") == false) goto L207;
        this.mStorage.putString("obric_task_timeout_config", r2.optString("obric_task_timeout_config"));
        this.mCachedSettings.remove("obric_task_timeout_config");
    L207:
        if (r2.has("obric_ai_key_config") == false) goto L210;
        this.mStorage.putString("obric_ai_key_config", r2.optString("obric_ai_key_config"));
        this.mCachedSettings.remove("obric_ai_key_config");
    L210:
        if (r2.has("obric_product_info_config") == false) goto L213;
        this.mStorage.putString("obric_product_info_config", r2.optString("obric_product_info_config"));
        this.mCachedSettings.remove("obric_product_info_config");
    L213:
        if (r2.has("obric_feature_audio_breath_data_tracker") == false) goto L216;
        this.mStorage.putString("obric_feature_audio_breath_data_tracker", r2.optString("obric_feature_audio_breath_data_tracker"));
        this.mCachedSettings.remove("obric_feature_audio_breath_data_tracker");
    L216:
        if (r2.has("obric_dorag_new_device_manage_enable") == false) goto L219;
        this.mStorage.putString("obric_dorag_new_device_manage_enable", r2.optString("obric_dorag_new_device_manage_enable"));
        this.mCachedSettings.remove("obric_dorag_new_device_manage_enable");
    L219:
        if (r2.has("obric_voice_wakeup_stage1_config") == false) goto L222;
        this.mStorage.putString("obric_voice_wakeup_stage1_config", r2.optString("obric_voice_wakeup_stage1_config"));
        this.mCachedSettings.remove("obric_voice_wakeup_stage1_config");
    L222:
        if (r2.has("obric_feature_auto_action_app_blacklist") == false) goto L225;
        this.mStorage.putString("obric_feature_auto_action_app_blacklist", r2.optString("obric_feature_auto_action_app_blacklist"));
        this.mCachedSettings.remove("obric_feature_auto_action_app_blacklist");
    L225:
        if (r2.has("obric_o_use_memory") == false) goto L228;
        this.mStorage.putString("obric_o_use_memory", r2.optString("obric_o_use_memory"));
        this.mCachedSettings.remove("obric_o_use_memory");
    L228:
        if (r2.has("obric_memory_data_collect_config") == false) goto L231;
        this.mStorage.putString("obric_memory_data_collect_config", r2.optString("obric_memory_data_collect_config"));
        this.mCachedSettings.remove("obric_memory_data_collect_config");
    L231:
        if (r2.has("obric_lark_confirm_config") == false) goto L234;
        this.mStorage.putString("obric_lark_confirm_config", r2.optString("obric_lark_confirm_config"));
        this.mCachedSettings.remove("obric_lark_confirm_config");
    L234:
        if (r2.has("obric_image_upload_compress_config") == false) goto L237;
        this.mStorage.putString("obric_image_upload_compress_config", r2.optString("obric_image_upload_compress_config"));
        this.mCachedSettings.remove("obric_image_upload_compress_config");
    L237:
        if (r2.has("obric_appintent_screenshot_cache_config") == false) goto L240;
        this.mStorage.putString("obric_appintent_screenshot_cache_config", r2.optString("obric_appintent_screenshot_cache_config"));
        this.mCachedSettings.remove("obric_appintent_screenshot_cache_config");
    L240:
        if (r2.has("obric_screenshot_upload_config") == false) goto L243;
        this.mStorage.putString("obric_screenshot_upload_config", r2.optString("obric_screenshot_upload_config"));
        this.mCachedSettings.remove("obric_screenshot_upload_config");
    L243:
        if (r2.has("obric_feature_config_single") == false) goto L246;
        this.mStorage.putString("obric_feature_config_single", r2.optString("obric_feature_config_single"));
        this.mCachedSettings.remove("obric_feature_config_single");
    L246:
        if (r2.has("obric_feature_config_group") == false) goto L249;
        this.mStorage.putString("obric_feature_config_group", r2.optString("obric_feature_config_group"));
        this.mCachedSettings.remove("obric_feature_config_group");
    L249:
        if (r2.has("obric_memd_toggle_list_config") == false) goto L252;
        this.mStorage.putString("obric_memd_toggle_list_config", r2.optString("obric_memd_toggle_list_config"));
        this.mCachedSettings.remove("obric_memd_toggle_list_config");
    L252:
        if (r2.has("obric_performance_power_monitor_config") == false) goto L255;
        this.mStorage.putString("obric_performance_power_monitor_config", r2.optString("obric_performance_power_monitor_config"));
        this.mCachedSettings.remove("obric_performance_power_monitor_config");
    L255:
        if (r2.has("obric_ipc_anomaly_report_config") == false) goto L258;
        this.mStorage.putString("obric_ipc_anomaly_report_config", r2.optString("obric_ipc_anomaly_report_config"));
        this.mCachedSettings.remove("obric_ipc_anomaly_report_config");
    L258:
        if (r2.has("obric_performance_cpu_exception_diagnosis_config") == false) goto L261;
        this.mStorage.putString("obric_performance_cpu_exception_diagnosis_config", r2.optString("obric_performance_cpu_exception_diagnosis_config"));
        this.mCachedSettings.remove("obric_performance_cpu_exception_diagnosis_config");
    L261:
        if (r2.has("obric_script_toggle_map") == false) goto L264;
        this.mStorage.putString("obric_script_toggle_map", r2.optString("obric_script_toggle_map"));
        this.mCachedSettings.remove("obric_script_toggle_map");
    L264:
        if (r2.has("obric_omni_data_feedback_toggle_map") == false) goto L267;
        this.mStorage.putString("obric_omni_data_feedback_toggle_map", r2.optString("obric_omni_data_feedback_toggle_map"));
        this.mCachedSettings.remove("obric_omni_data_feedback_toggle_map");
    L267:
        if (r2.has("obric_omni_upload_image_auto_drain_toggle_map") == false) goto L270;
        this.mStorage.putString("obric_omni_upload_image_auto_drain_toggle_map", r2.optString("obric_omni_upload_image_auto_drain_toggle_map"));
        this.mCachedSettings.remove("obric_omni_upload_image_auto_drain_toggle_map");
    L270:
        if (r2.has("obric_appintent_lockscreen_execute_config") == false) goto L273;
        this.mStorage.putString("obric_appintent_lockscreen_execute_config", r2.optString("obric_appintent_lockscreen_execute_config"));
        this.mCachedSettings.remove("obric_appintent_lockscreen_execute_config");
    L273:
        if (r2.has("is_close_audio_connection_app_background_only_for_obric") == false) goto L276;
        this.mStorage.putBoolean("is_close_audio_connection_app_background_only_for_obric", e.a(r2, "is_close_audio_connection_app_background_only_for_obric"));
    L276:
        if (r2.has("obric_feature_genesis_feedback_support") == false) goto L279;
        this.mStorage.putString("obric_feature_genesis_feedback_support", r2.optString("obric_feature_genesis_feedback_support"));
        this.mCachedSettings.remove("obric_feature_genesis_feedback_support");
    L279:
        if (r2.has("obric_feature_cocreation_review_support") == false) goto L282;
        this.mStorage.putString("obric_feature_cocreation_review_support", r2.optString("obric_feature_cocreation_review_support"));
        this.mCachedSettings.remove("obric_feature_cocreation_review_support");
    L282:
        if (r2.has("obric_voice_wakeup_sid_threshold") == false) goto L285;
        this.mStorage.putString("obric_voice_wakeup_sid_threshold", r2.optString("obric_voice_wakeup_sid_threshold"));
        this.mCachedSettings.remove("obric_voice_wakeup_sid_threshold");
    L285:
        if (r2.has("obric_bypass_adaptive_sid") == false) goto L288;
        this.mStorage.putBoolean("obric_bypass_adaptive_sid", e.a(r2, "obric_bypass_adaptive_sid"));
    L288:
        if (r2.has("obric_feature_window_mode") == false) goto L291;
        this.mStorage.putString("obric_feature_window_mode", r2.optString("obric_feature_window_mode"));
        this.mCachedSettings.remove("obric_feature_window_mode");
    L291:
        if (r2.has("obric_feature_download_certificate") == false) goto L294;
        this.mStorage.putString("obric_feature_download_certificate", r2.optString("obric_feature_download_certificate"));
        this.mCachedSettings.remove("obric_feature_download_certificate");
    L294:
        if (r2.has("obric_feature_keep_alive_high_level") == false) goto L297;
        this.mStorage.putString("obric_feature_keep_alive_high_level", r2.optString("obric_feature_keep_alive_high_level"));
        this.mCachedSettings.remove("obric_feature_keep_alive_high_level");
    L297:
        if (r2.has("obric_feature_keep_alive_mid_level") == false) goto L300;
        this.mStorage.putString("obric_feature_keep_alive_mid_level", r2.optString("obric_feature_keep_alive_mid_level"));
        this.mCachedSettings.remove("obric_feature_keep_alive_mid_level");
    L300:
        if (r2.has("obric_feature_keep_alive_low_level") == false) goto L303;
        this.mStorage.putString("obric_feature_keep_alive_low_level", r2.optString("obric_feature_keep_alive_low_level"));
        this.mCachedSettings.remove("obric_feature_keep_alive_low_level");
    L303:
        if (r2.has("obric_feature_exit_aiagent_when_nova_died") == false) goto L306;
        this.mStorage.putString("obric_feature_exit_aiagent_when_nova_died", r2.optString("obric_feature_exit_aiagent_when_nova_died"));
        this.mCachedSettings.remove("obric_feature_exit_aiagent_when_nova_died");
    L306:
        if (r2.has("obric_zeus_auto_fetch_config") == false) goto L309;
        this.mStorage.putString("obric_zeus_auto_fetch_config", r2.optString("obric_zeus_auto_fetch_config"));
        this.mCachedSettings.remove("obric_zeus_auto_fetch_config");
    L309:
        if (r2.has("obric_voice_section_tracker_enable_slardar") == false) goto L311;
        this.mStorage.putString("obric_voice_section_tracker_enable_slardar", r2.optString("obric_voice_section_tracker_enable_slardar"));
        this.mCachedSettings.remove("obric_voice_section_tracker_enable_slardar");
        goto L311
    L319:
        return;
    L5:
        if (VERSION == r0.b("nova_settings_com.obric.assistant.IObricCloudSettings")) goto L20;
        r7 = m37.f.b(m37.a.getContext()).d(XmlPullParser.NO_NAMESPACE);
    L13:
        th = move-exception;
        if (r7 == null) goto L16;
        r0.f("nova_settings_com.obric.assistant.IObricCloudSettings", VERSION);
    L16:
        IEnsure r3 = this.iEnsure;
        if (r3 == null) goto L33;
        r3.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L8:
        if (a.i == false) goto L11;
        if (r7 == null) goto L315;
        r0.f("nova_settings_com.obric.assistant.IObricCloudSettings", VERSION);     // Catch: Throwable -> L13
    L315:
        goto L33
    L11:
        r0.f("nova_settings_com.obric.assistant.IObricCloudSettings", VERSION);     // Catch: Throwable -> L13
        goto L315
    L20:
        if (r0.d("nova_settings_com.obric.assistant.IObricCloudSettings", XmlPullParser.NO_NAMESPACE) == false) goto L22;
        r7 = m37.f.b(m37.a.getContext()).d(XmlPullParser.NO_NAMESPACE);
        goto L33
    L22:
        if (r7 != null) goto L33;
    L29:
        th = move-exception;
        IEnsure r4 = this.iEnsure;
        if (r4 == null) goto L33;
        r4.ensureNotReachHere(th, "isUseOneSpForAppSettingsStatic error");
        goto L33
    L24:
        if (a.i == false) goto L33;
        if (r0.c("nova_settings_com.obric.assistant.IObricCloudSettings") == true) goto L33;
        r7 = m37.f.b(m37.a.getContext()).d(XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L29
        r0.e("nova_settings_com.obric.assistant.IObricCloudSettings");     // Catch: Throwable -> L29
        goto L33
    }
}
