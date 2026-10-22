package com.bytedance.push.settings;

import a87.k;
import android.content.Context;
import android.content.SharedPreferences;
import j77.a;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class StatisticsSettings$$SettingImpl implements StatisticsSettings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f267018b;

    @Override // com.bytedance.push.settings.StatisticsSettings
    public final long a() {
        k r100 = this.f267018b;
        if (r100 != null) goto L5;
    L7:
        return 300000;
    L5:
        if (r100.contains("stats_fore_interval") == false) goto L7;
        return this.f267018b.getLong("stats_fore_interval");
    }

    @Override // com.bytedance.push.settings.StatisticsSettings
    public final long b() {
        k r100 = this.f267018b;
        if (r100 != null) goto L5;
    L7:
        return 300000;
    L5:
        if (r100.contains("stats_back_interval") == false) goto L7;
        return this.f267018b.getLong("stats_back_interval");
    }

    public StatisticsSettings$$SettingImpl(k r100) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.f267018b = r100;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void unregisterValChanged(a r100) {
        k r101 = this.f267018b;
        if (r101 == null) goto L6;
        r101.unregisterValChanged(r100);
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void updateSettings(Context r100, JSONObject r101) {
        if (r101 == null) goto L13;
        k r102 = this.f267018b;
        if (r102 == null) goto L14;
        SharedPreferences.Editor r103 = r102.edit();
        if (r101.has("stats_fore_interval") == false) goto L9;
        r103.putLong("stats_fore_interval", r101.optLong("stats_fore_interval"));
    L9:
        if (r101.has("stats_back_interval") == false) goto L11;
        r103.putLong("stats_back_interval", r101.optLong("stats_back_interval"));
    L11:
        r103.apply();
        return;
    L14:
        return;
    }

    @Override // com.bytedance.push.settings.ISettings
    public final void registerValChanged(Context r100, String r101, String r102, a r103) {
        k r104 = this.f267018b;
        if (r104 == null) goto L6;
        r104.registerValChanged(r100, r101, r102, r103);
        return;
    }
}
