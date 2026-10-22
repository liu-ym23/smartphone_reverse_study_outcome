package com.bytedance.ug.sdk.luckydog.api.settings;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class LuckyDogLocalSettings$$Impl implements LuckyDogLocalSettings {
    private static final Gson GSON = null;
    private final ConcurrentHashMap<String, Object> mCachedSettings;
    private final m37.d mInstanceCreator;
    private h37.f mStorage;

    public class a implements m37.d {
        @Override // m37.d
        public final <T> T create(Class<T> r100) {
            return null;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class b extends TypeToken<LinkedHashSet<Long>> {
        public b() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class c extends TypeToken<LinkedHashSet<Long>> {
        public c() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class d extends TypeToken<LinkedHashSet<String>> {
        public d() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class e extends TypeToken<String> {
        public e() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class f extends TypeToken<LinkedHashSet<Long>> {
        public f() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class g extends TypeToken<LinkedHashSet<String>> {
        public g() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public class h extends TypeToken<LinkedHashSet<Long>> {
        public h() {
        }
    }

    static {
        GSON = new Gson();
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getBdnEnv() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_bdn_evn") == false) goto L7;
        return this.mStorage.getString("key_bdn_evn");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getColdPopData() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_cold_pop_data") == false) goto L7;
        return this.mStorage.getString("key_cold_pop_data");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getColdPopupSet() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L11:
        return "";
    L5:
        if (r100.contains("key_cold_popup_set") == false) goto L11;
        String r101 = this.mStorage.getString("key_cold_popup_set");
        return (String) GSON.fromJson(r101, new e().getType());
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public int getColdRequestFailTimes() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("key_cold_request_fail_times") == false) goto L7;
        return this.mStorage.getInt("key_cold_request_fail_times");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getDynamicSettings() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_dynamic_setttings") == false) goto L7;
        return this.mStorage.getString("key_dynamic_setttings");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public long getLastServerTime() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("key_last_server_time") == false) goto L7;
        return this.mStorage.getLong("key_last_server_time");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<String> getNotificationSet() {
        if (this.mCachedSettings.containsKey("key_notification_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<String> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_notification_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_notification_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_notification_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new g().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_notification_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getPollSettings() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_poll_settings") == false) goto L7;
        return this.mStorage.getString("key_poll_settings");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getPollSettingsDg() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_poll_settings_dg") == false) goto L7;
        return this.mStorage.getString("key_poll_settings_dg");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<String> getPopupSet() {
        if (this.mCachedSettings.containsKey("key_popup_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<String> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_popup_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_popup_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_popup_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new d().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_popup_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<Long> getReceivePopupIdSet() {
        if (this.mCachedSettings.containsKey("key_receive_popup_id_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<Long> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_receive_popup_id_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_receive_popup_id_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_receive_popup_id_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new c().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_receive_popup_id_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<Long> getShownLottieIdSet() {
        if (this.mCachedSettings.containsKey("key_shown_lottie_id_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<Long> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_shown_lottie_id_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_shown_lottie_id_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_shown_lottie_id_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new h().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_shown_lottie_id_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<Long> getShownNotificationIdSet() {
        if (this.mCachedSettings.containsKey("key_shown_notification_id_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<Long> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_shown_notification_id_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_shown_notification_id_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_shown_notification_id_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new f().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_shown_notification_id_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public LinkedHashSet<Long> getShownPopupIdSet() {
        if (this.mCachedSettings.containsKey("key_shown_popup_id_set") == true) goto L20;
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L8;
    L14:
        LinkedHashSet<Long> r101 = null;
    L15:
        if (r101 == null) goto L21;
        this.mCachedSettings.put("key_shown_popup_id_set", r101);
        return r101;
    L21:
        return r101;
    L8:
        if (r100.contains("key_shown_popup_id_set") == false) goto L14;
        String r102 = this.mStorage.getString("key_shown_popup_id_set");
        r101 = (LinkedHashSet) GSON.fromJson(r102, new b().getType());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L20:
        return (LinkedHashSet) this.mCachedSettings.get("key_shown_popup_id_set");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public String getStaticSettings() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return "";
    L5:
        if (r100.contains("key_static_settings") == false) goto L7;
        return this.mStorage.getString("key_static_settings");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public long getTimeInterval() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("key_time_interval") == false) goto L7;
        return this.mStorage.getLong("key_time_interval");
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public long getTimeManagerOldBoot() {
        h37.f r100 = this.mStorage;
        if (r100 != null) goto L5;
    L7:
        return 0;
    L5:
        if (r100.contains("key_boot_time") == false) goto L7;
        return this.mStorage.getLong("key_boot_time");
    }

    public LuckyDogLocalSettings$$Impl(h37.f r100) {
        this.mCachedSettings = new ConcurrentHashMap();
        this.mInstanceCreator = new a();
        this.mStorage = r100;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setBdnEnv(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_bdn_evn", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setColdPopData(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_cold_pop_data", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setColdPopupSet(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_cold_popup_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setColdRequestFailTimes(int r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putInt("key_cold_request_fail_times", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setDynamicSettings(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_dynamic_setttings", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setLastServerTime(long r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putLong("key_last_server_time", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setNotificationSet(LinkedHashSet<String> r100) {
        this.mCachedSettings.remove("key_notification_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_notification_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setPollSettings(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_poll_settings", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setPollSettingsDg(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_poll_settings_dg", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setPopupSet(LinkedHashSet<String> r100) {
        this.mCachedSettings.remove("key_popup_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_popup_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setReceivePopupIdSet(LinkedHashSet<Long> r100) {
        this.mCachedSettings.remove("key_receive_popup_id_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_receive_popup_id_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setShownLottieIdSet(LinkedHashSet<Long> r100) {
        this.mCachedSettings.remove("key_shown_lottie_id_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_shown_lottie_id_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setShownNotificationIdSet(LinkedHashSet<Long> r100) {
        this.mCachedSettings.remove("key_shown_notification_id_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_shown_notification_id_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setShownPopupIdSet(LinkedHashSet<Long> r100) {
        this.mCachedSettings.remove("key_shown_popup_id_set");
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_shown_popup_id_set", GsonProtectorUtils.toJson(GSON, r100));
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setStaticSettings(String r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putString("key_static_settings", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setTimeInterval(long r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putLong("key_time_interval", r100);
        this.mStorage.apply();
        return;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings
    public void setTimeManagerOldBoot(long r100) {
        h37.f r101 = this.mStorage;
        if (r101 == null) goto L6;
        r101.putLong("key_boot_time", r100);
        this.mStorage.apply();
        return;
    }
}
